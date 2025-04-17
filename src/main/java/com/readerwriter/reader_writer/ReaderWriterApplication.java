	package com.readerwriter.reader_writer;

	public class ReaderWriterApplication {

		static Database database = new Database();
		public static void main(String[] args) {

			int rounds = 100;
			new Reader(rounds, database).start();
			new Reader(rounds, database).start();
			new Writer(rounds, database).start();
			new Writer(rounds, database).start();
		}

	}
