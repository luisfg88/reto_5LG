package controlador;

import java.util.ArrayList;

import modelo.DAO.*;
import modelo.VO.*;

import java.sql.SQLException;

public class ControladorRequerimientos {

    private final LideresDocsBaqDAO lideresDocsBaqDAO;
    private final MaterialesProyectosDAO materialesProyectosDAO;
    private final LideresCostosPromDAO lideresCostosPromDAO;

    public ControladorRequerimientos(){
        lideresDocsBaqDAO = new LideresDocsBaqDAO();
        materialesProyectosDAO = new MaterialesProyectosDAO();
        lideresCostosPromDAO = new LideresCostosPromDAO();
    }
    
    public ArrayList<LideresDocsBaqVO> consultarLideresDocsBaq() throws SQLException{
        return lideresDocsBaqDAO.consultarLideresDocsBaq();
    }

    public ArrayList<MaterialesProyectosVO> consultarMaterialesProyectos() throws SQLException{
        return materialesProyectosDAO.consultarMaterialesProyectos();
    }

    public ArrayList<LideresCostosPromVO> consultarLideresCostosProm() throws SQLException{
        return lideresCostosPromDAO.consultarLideresCostosProm();
    }
}
