
package Modelo;

public class DetalleCompras {
    private int id;
    private int id_pro;
    private int cantidad;
    private double costo;
    private int id_compra;

    public DetalleCompras() {
    }

    public DetalleCompras(int id, int id_pro, int cantidad, double costo, int id_compra) {
        this.id = id;
        this.id_pro = id_pro;
        this.cantidad = cantidad;
        this.costo = costo;
        this.id_compra = id_compra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_pro() {
        return id_pro;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }
    
}
