package wdsr.exercise5.hsqldb;

import java.util.concurrent.TimeUnit;

import org.hsqldb.server.Server;
import org.hsqldb.server.ServerConstants;

/**
 * Created by maro on 2014-06-03.
 */
public final class MyHsqlServer extends Server {
    public MyHsqlServer(final int port, final String databaseName, final String databasePath) {
        setLogWriter(new Log4jPrintWriter());
        setDatabaseName(0, databaseName);
        setDatabasePath(0, databasePath);
        setPort(port);
    }

    @Override
    public int stop() {
        getLogWriter().print("Stopping HSQLDB");
        super.stop();
        try {
            do {
                TimeUnit.SECONDS.sleep(1);
            } while (super.getState() != ServerConstants.SERVER_STATE_SHUTDOWN);
        } catch (InterruptedException e) {
            getLogWriter().print("Interrupted Exception");
            Thread.currentThread().interrupt();
        }
        getLogWriter().print("HSQLDB stopped: "+super.getState());
        return super.getState();
    }
}
