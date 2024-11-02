package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompraDao {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    public int IdCompra() {
        int id = 0;
        String sql = "SELECT MAX(id) FROM compras";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return id;
    }

    public void RegistrarCompra(Compra c) {
        String sql = "INSERT INTO compras (id, cuit, total, fecha) VALUES (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, c.getId());
            ps.setInt(2, c.getCuit());
            ps.setDouble(3, c.getTotal());
            ps.setString(4, c.getFecha());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public void RegistrarDetalleCompra(DetalleCompras dc) {
        String sql = "INSERT INTO detallecompras (id_prod, cantidad, costo, id_compra) VALUES (?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dc.getId_pro());
            ps.setInt(2, dc.getCantidad());
            ps.setDouble(3, dc.getCosto());
            ps.setInt(4, dc.getId_compra());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public List ListarCompras() {
        List<Compra> ListaCompra = new ArrayList();
        String sql = "SELECT proveedor.id AS id_prov, proveedor.nombre, compras.* FROM proveedor INNER JOIN compras ON proveedor.id = compras.cuit";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Compra sale = new Compra();
                sale.setId(rs.getInt("id"));
                sale.setNombreProv(rs.getString("nombre"));
                sale.setTotal(rs.getDouble("total"));
                ListaCompra.add(sale);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaCompra;
    }

    public Compra BuscarCompra(int id) {
        Compra c = new Compra();
        String sql = "SELECT * FROM compras WHERE id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                c.setId(rs.getInt("id"));
                c.setCuit(rs.getInt("cuit"));
                c.setTotal(rs.getDouble("total"));
                c.setFecha(rs.getString("fecha"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return c;
    }
}
