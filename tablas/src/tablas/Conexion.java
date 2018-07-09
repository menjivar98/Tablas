package tablas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private Connection con = null;
    private final String base = "tienda";
    private final String user = "root";
    private final String password = "1234";
    private final String url = "jdbc:mariadb://localhost:3306/" + base;

    public Connection getConexion() {
        try {
            try {
                Class.forName("com.mariadb.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = (Connection) DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {

        }
        return con;
    }

}
