<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*"
    import="BaluSistema.Kursas"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kursai</title>
</head>
<body> 
<table border="1">
<tr>
<td width="119"><b>Kodas</b></td>
<td width="168"><b>Pavadinimas</b></td>
  </tr> 
        <%Set<Kursas> std =  
            (Set<Kursas>)request.getAttribute("data"); 
        for(Kursas k:std){%> 
            <tr> 
                <td><%=k.getKodas()%></td> 
                <td><%=k.getPavadinimas()%></td> 
            </tr> 
            <%}%> 
</table>
</body>
</html>