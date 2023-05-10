import ru.smak.db.DBHelper;
import ru.smak.db.User;

import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            DBHelper db = new DBHelper("localhost", 3306, "root","");
            var u = new User();
            u.setBirth(Date.valueOf("1990-01-03"));
            u.setFirstName("Ник");
            u.setLastName("Иванов");
            u.setMiddleName("Николаевич");
            u.setPhone("+79005553535");
            u.setPassword("qwerty");
            db.addUser(u);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
