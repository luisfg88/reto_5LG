package modelo.DAO;

import util.JDBCutilities;

import java.util.ArrayList;
import modelo.VO.LideresDocsBaqVO;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LideresDocsBaqDAO {
    
    public ArrayList<LideresDocsBaqVO> consultarLideresDocsBaq() throws SQLException{
        
        ArrayList<LideresDocsBaqVO> respuesta = new ArrayList<LideresDocsBaqVO>();

        Connection conexion = JDBCutilities.getConnection();

        String query = "SELECT Nombre ||\" \"|| Primer_Apellido ||\" \"|| Segundo_Apellido Nombre, Documento_Identidad " + 
        "FROM Lider l " + 
        "WHERE Ciudad_Residencia = 'Barranquilla'" +
        "ORDER BY Nombre";

        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            String nombre = rs.getString("Nombre");
            String documentoIdentidad = rs.getString("Documento_Identidad");

            LideresDocsBaqVO registro = new LideresDocsBaqVO(nombre, documentoIdentidad);

            respuesta.add(registro);
        }

        return respuesta;

    }
}
