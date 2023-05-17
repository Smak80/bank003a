import ru.smak.db.DBHelper;
import ru.smak.data.User;
import ru.smak.net.Server;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Server srv = new Server(5003);
        srv.start();
    }
}
