package com.readerwriter.reader_writer;

class Writer extends Thread {
    int rounds;
    Database database;

    public Writer(int rounds, Database database) {
        this.rounds = rounds;
        this.database = database;
    }

    @Override
    public void run() {
        for (int i = 0; i < rounds; i++) {
            database.write();
        }
    }
}
