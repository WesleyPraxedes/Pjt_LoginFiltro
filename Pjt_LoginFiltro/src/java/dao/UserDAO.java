package dao;

import dao.MySQLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import vo.User;

public class UserDAO extends MySQLConnection{
    private PreparedStatement ps;
    private Connection conn;
    private ResultSet rs;
    
    public UserDAO() throws ClassNotFoundException, SQLException{//Construtor com argumeto.
        this.conn = getConnection();//Ao criar um novo ClienteDAO ele cria uma conexão.
    }
    
    public User verificarUsuarioHash(String login, String senha) throws Exception{
        ps = this.conn.prepareStatement("SELECT nome , cargo FROM tb_usuario WHERE login=? AND senha=md5(?)");
        ps.setString(1, login);
        ps.setString(2, senha);
        rs = ps.executeQuery();
        User u = new User();
        if(rs.next()){
            u.setNome(rs.getString("nome"));
            u.setCargo(rs.getString("cargo"));
        }
        return u;
    }
    
    public void cadastar(User us) throws Exception{
        String SQL = "INSERT INTO tb_usuario VALUES(null,?,?,?,null)";
        ps = conn.prepareStatement(SQL);
        ps.setString(1, us.getNome());
        ps.setString(2, us.getLogin());
        ps.setString(3, us.getSenha());
        ps.execute();
    }
}