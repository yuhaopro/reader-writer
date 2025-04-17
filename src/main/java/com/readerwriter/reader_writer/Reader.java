package com.readerwriter.reader_writer;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Reader extends Thread {
    private Logger logger = LoggerFactory.getLogger(Reader.class);
    int rounds;
    Database database;
    private Random generator = new Random();

    public Reader(int rounds, Database database) {
        this.rounds = rounds;
        this.database = database;
    }

    // this is executed currently in the background
    @Override
    public void run() {
        for (int i = 0; i < rounds; i++) {
            try {
                Thread.sleep(generator.nextInt(500)); // random delay for effect! \
            } catch (InterruptedException e) {
                logger.error("Thread interrupted: ", e);
            }
            logger.info("read: {}", database.read());
        }
    }
}
