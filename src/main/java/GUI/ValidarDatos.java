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
    
    

}
