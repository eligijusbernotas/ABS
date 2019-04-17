<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List"
    import="BaluSistema.Uzduotis"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Uzduotys</title>
</head>
<body> 
<table border="1">
<tr>
<td width="119"><b>Pavadinimas</b></td>
<td width="168"><b>Salyga</b></td>
<td width="168"><b>Vertinimo tvarka</b></td>
<td width="168"><b>Max balai</b></td>
<td width="168"><b>Terminas</b></td>
<td width="168"><b>Galima ikelti</b></td>
  </tr> 
        <%List<Uzduotis> std =  
            (List<Uzduotis>)request.getAttribute("data"); 
        for(Uzduotis u:std){%> 
            <tr> 
                <td><%=u.getPavadinimas()%></td> 
                <td><%=u.getSalyga()%></td>
                <td><%=u.getVertinimoTvarka()%></td>
                <td><%=u.getMaxBalai()%></td>
                <td><%=u.getTerminas()%></td>
                <td><%=u.isGalimaIkelti()%></td> 
            </tr> 
            <%}%> 
</table>
</body>
</html>