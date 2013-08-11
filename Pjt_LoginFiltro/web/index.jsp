<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pjt_login_filtro</title>
    </head>
    <body>
        <h1 align="center">Pagina Restrita & Senha Codificada</h1>
        <hr>
        Inicio - <a href="admin/logado.jsp">Logado</a> - <a href="admin/menu_1.jsp">Menu 1</a> - <a href="admin/menu_2.jsp">Menu 2</a>
        <form method="post" action="AutenticarLogin">
            <input type="text" name="usuario"><br/>
            <input type="password" name="senha"><br/>
            <input type="submit" value="Entrar">            
      </form>
    </body>
</html>