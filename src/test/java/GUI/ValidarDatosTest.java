/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author exequ
 */
public class ValidarDatosTest {
    
    public ValidarDatosTest() {
    }

    /**
     * Test of CorreoValido method, of class ValidarDatos.
     */
    @org.junit.jupiter.api.Test
    public void testCorreoValido() {
        System.out.println("CorreoValido");
        String correo = "admin@gmail.com";
        ValidarDatos instance = new ValidarDatos();
        boolean expResult = true;
        boolean result = instance.CorreoValido(correo);
        assertEquals(expResult, result);
    }

    /**
     * Test of PassWordValida method, of class ValidarDatos.
     */
    @org.junit.jupiter.api.Test
    public void testPassWordValida() {
        System.out.println("PassWordValida");
        String pass = "admin";
        ValidarDatos instance = new ValidarDatos();
        boolean expResult = true;
        boolean result = instance.PassWordValida(pass);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of DNICorrecto method, of class ValidarDatos.
     */
    @org.junit.jupiter.api.Test
    public void testDNICorrecto(){
        System.out.println("DNICorrecto");
        int doc = 12345678;
        ValidarDatos instance = new ValidarDatos();
        boolean expResult=true;
        boolean result=instance.DNICorrecto(doc);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of CadenaCorrecta method, of class ValidarDatos.
     */
    @org.junit.jupiter.api.Test
    public void testCadenaCorrecta(){
        System.out.println("CadenaCorrecta");
        String cadena="Desodorante 900ml";
        ValidarDatos instance = new ValidarDatos();
        boolean expResult=true;
        boolean result=instance.CadenaCorrecta(cadena);
        assertEquals(expResult, result);
    }
    
}
