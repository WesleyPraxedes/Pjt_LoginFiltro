/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import dao.UserDAO;
import vo.User;

/**
 *
 * @author Wesley
 */
public class TesteCadastrar {
    public static void main(String[] args) throws Exception{
        
        User us = new User();
        us.setNome("Carlos Alberto");
        us.setLogin("user");
        us.setSenha("123");
        
        UserDAO dao = new UserDAO();
        dao.cadastar(us);
        System.out.println("Usuario cadastrado!");
    }
}
