package modelo.DAO;

import util.JDBCutilities;

import java.util.ArrayList;
import modelo.VO.LideresCostosPromVO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LideresCostosPromDAO {
    
    public ArrayList<LideresCostosPromVO> consultarLideresCostosProm() throws SQLException{
        
        ArrayList<LideresCostosPromVO> respuesta = new ArrayList<LideresCostosPromVO>();

        Connection conexion = JDBCutilities.getConnection();

        String query = "SELECT Nombre ||\" \"|| Primer_Apellido ||\" \"|| Segundo_Apellido Nombre, SUM(c.Cantidad * mc.Precio_Unidad) / COUNT(DISTINCT p.ID_Proyecto) Promedio " +
    "FROM Lider l " +
        "LEFT JOIN Proyecto p ON l.ID_Lider = p.ID_Lider " +
        "LEFT JOIN Compra c ON p.ID_Proyecto = c.ID_Proyecto " +
        "lEFT JOIN MaterialConstruccion mc ON c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion " +
    "WHERE p.Ciudad = 'Pereira' " +
    "GROUP BY l.ID_Lider " +
    "HAVING COUNT(DISTINCT p.ID_Proyecto) >= 2 " +
    "ORDER BY Promedio DESC " +
    "LIMIT 3 ";

        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            String nombre = rs.getString("Nombre");
            Integer promedio = rs.getInt("Promedio");

            LideresCostosPromVO registro = new LideresCostosPromVO(nombre, promedio);

            respuesta.add(registro);
        }

        return respuesta;

    }
}
