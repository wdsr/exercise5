package wdsr.exercise5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wdsr.exercise5.hsqldb.MyHsqlServer;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) throws InterruptedException {
		MyHsqlServer dbServer = new MyHsqlServer("test-db", "mem:test-db");
		dbServer.start();
		log.info("Database started");
	}
}
