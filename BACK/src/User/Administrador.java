package CMPCD.BACK.src.User;

import java.sql.ResultSet;

public class Administrador extends User {

    public Administrador(int codigo, String senha, String nomelogin) {
        super(codigo, nomelogin);
    }

    public void loginAuthenticacao(Administrador admin) {
        try {
            ControlAdministrador objuser = new ControlAdministrador();
            ResultSet rsusuario = objuser.authentificacaoAdmin(admin);

            if (rsusuario.next()) {

            } else {

            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
