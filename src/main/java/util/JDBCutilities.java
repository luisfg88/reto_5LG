package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCutilities {

    //public final static String UBICACION_BD = "C:/Users/GAME/Desktop/El gordo/MincTIC2022/Ciclo 2/Basedatos/ProyectosConstruccion.db";
    //public final static String UBICACION_BD = "ProyectosConstruccion.db";
    public final static String UBICACION_BD = "./database/ProyectosConstruccion.db";

    public static Connection getConnection() throws SQLException{
        String url  = "jdbc:sqlite:" + UBICACION_BD;
        return DriverManager.getConnection(url);
    }
}
