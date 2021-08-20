package modelo.VO;

public class LideresDocsBaqVO {

    private String Nombre;
    private String Documento_Identidad;

    public LideresDocsBaqVO(String Nombre, String Documento_Identidad){
        this.Nombre = Nombre;
        this.Documento_Identidad = Documento_Identidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDocumento_Identidad() {
        return Documento_Identidad;
    }

    public void setDocumento_Identidad(String documento_Identidad) {
        Documento_Identidad = documento_Identidad;
    }

}
