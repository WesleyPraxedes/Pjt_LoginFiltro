<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logado</title>
    </head>
    <body>
        <h1>Você está logado!</h1>
        <p><a href="../index.jsp">Inicio</a> - Logado - <a href="menu_1.jsp">Menu 1</a> - <a href="menu_2.jsp">Menu 2</a></p><br/>
        Olá <%=session.getAttribute("PjtLoginFiltro_name")%> vc está logado.<br/>
        Acessando como <%=session.getAttribute("PjtLoginFiltro_post")%>. <a href="FazerLogoff">Clique aqui para sair</a>.<br/>
    </body>
</html>
