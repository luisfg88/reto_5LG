package modelo.VO;

public class LideresCostosPromVO {

    private String Nombre;
    private Integer Promedio;


    public LideresCostosPromVO(String Nombre, Integer Promedio){
        this.Nombre = Nombre;
        this.Promedio = Promedio;
    }


    public String getNombre() {
        return Nombre;
    }


    public void setNombre(String nombre) {
        Nombre = nombre;
    }


    public Integer getPromedio() {
        return Promedio;
    }


    public void setPromedio(Integer promedio) {
        Promedio = promedio;
    }

     
}
