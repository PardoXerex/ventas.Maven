package GUI;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarDatos {

    public boolean CorreoValido(String correo) {
        Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }
    
    public boolean PassWordValida(String pass){
        Pattern pattern = Pattern.compile("^[a-z0-9]+$");
        Matcher matcher = pattern.matcher(pass);
        return matcher.matches();
    }
    
    public boolean DNICorrecto(int dni){
        Pattern pattern =Pattern.compile("[0-9]{8}");
        Matcher matcher =pattern.matcher(String.valueOf(dni));
        return matcher.matches();
    }
    
    public boolean CadenaCorrecta(String cadena){
        Pattern pattern =Pattern.compile("[a-zA-Z0-9]+$");
        Matcher matcher =pattern.matcher(cadena);
        return matcher.matches();
    }

}
