package com.readerwriter.reader_writer;

class Reader extends Thread {
    int rounds;
    Database database;

    public Reader(int rounds, Database database) {
        this.rounds = rounds;
        this.database = database;
    }

    // this is executed currently in the background
    @Override
    public void run() {
        for (int i = 0; i < rounds; i++) {
            database.read();
        }
    }
}
