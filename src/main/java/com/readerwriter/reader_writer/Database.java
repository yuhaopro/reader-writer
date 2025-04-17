package com.readerwriter.reader_writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Database {
    private Logger logger = LoggerFactory.getLogger(Database.class);
    private int data = 0; // the data
    int nr = 0;

    private synchronized void startRead() {
        nr++;
    }

    private synchronized void endRead() {
        nr--;

        if (nr == 0) {
            notify(); // awaken a single waiting writer
        }

    }

    public void read() {
        int snapshot;
        startRead(); // thread starts reading
        snapshot = data; // thread gets the current data, which may occur if writer is writing the data.
        logger.info("read: {}", snapshot);
        endRead();
    }

    public synchronized void write() {
        int temp;
        while (nr > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                logger.error("Interrupted while wait()", e);
            }
        }
        temp = data;
        data = 99999;
        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            logger.error("Interrupted while sleep(): ", e);
            Thread.currentThread().interrupt();
        }
        data = temp + 1;
        notify(); // wakes up another writer since this writer has finished writing.
        logger.info("wrote: {}", data);
    }
}
