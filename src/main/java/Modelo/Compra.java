
package Modelo;

public class Compra {
    private int id;
    private int cuit;
    private String  nombreProv;
    private double total;
    private String fecha;

    public Compra() {
    }

    public Compra(int id, int cuit,String nombreProv, double total, String fecha) {
        this.id = id;
        this.cuit = cuit;
        this.nombreProv=nombreProv;
        this.total = total;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }
    

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreProv() {
        return nombreProv;
    }

    public void setNombreProv(String nombreProv) {
        this.nombreProv = nombreProv;
    }
}
