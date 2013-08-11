package teste;

import dao.UserDAO;
import vo.User;

public class TesteLogin {
    public static void main(String[] args) throws Exception{
        String login = "user";
        String senha = "123";
        
        User us = new User();
        
        UserDAO dao = new UserDAO();
        us = dao.verificarUsuarioHash(login, senha);
        System.out.println(us.getNome());
        System.out.println(us.getCargo());
        if(us.getNome()!=null){
            System.out.println("Login feito com sucesso ");
        } else {
            System.out.println("Login ou senha invalidos");
        }
    }
}