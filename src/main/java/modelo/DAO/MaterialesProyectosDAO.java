package modelo.DAO;

import util.JDBCutilities;

import java.util.ArrayList;
import modelo.VO.MaterialesProyectosVO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MaterialesProyectosDAO {


    public ArrayList<MaterialesProyectosVO> consultarMaterialesProyectos() throws SQLException{

        ArrayList<MaterialesProyectosVO> respuesta = new ArrayList<MaterialesProyectosVO>();

        Connection conexion = JDBCutilities.getConnection();

        String query = "SELECT mc.Nombre_Material, mc.Precio_Unidad, SUM(c.Cantidad) Total " +
        "FROM Proyecto p " +
        "      LEFT JOIN Compra c ON p.ID_Proyecto = c.ID_Proyecto " +
        "      lEFT JOIN MaterialConstruccion mc ON c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion " +
        "WHERE p.ID_Proyecto in (183, 331, 352, 365, 76) " +
        "GROUP BY mc.Nombre_Material " +
        "ORDER BY mc.Nombre_Material";

        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            String nombreMaterial = rs.getString("Nombre_Material");
            Integer precioUnidad = rs.getInt("Precio_Unidad");
            Integer total = rs.getInt("Total");

            MaterialesProyectosVO registro = new MaterialesProyectosVO(nombreMaterial, precioUnidad, total);

            respuesta.add(registro);
        }

        conexion.close();
        st.close();
        rs.close();

        return respuesta;

    }
    
}
