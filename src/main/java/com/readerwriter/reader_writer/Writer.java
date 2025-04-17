package com.readerwriter.reader_writer;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Writer extends Thread {
    Logger logger = LoggerFactory.getLogger(Writer.class);
    int rounds;
    Database database;
    private Random generator = new Random();

    public Writer(int rounds, Database database) {
        this.rounds = rounds;
        this.database = database;
    }

    @Override
    public void run() {
        for (int i = 0; i < rounds; i++) {
            try {
                Thread.sleep(generator.nextInt(500)); // random delay for effect!
            } catch (java.lang.InterruptedException e) {
            }
            logger.info("wrote: {}", database.write());

        }
    }
}
