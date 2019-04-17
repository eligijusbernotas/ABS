<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Yup</title>
</head>
<body>
<form method="get" action="GetStudentoKursai">
		<table>
			<tr>
				<td>Studento ID</td>
				<td><input type="text" name="stud_id"></td>
			</tr>
			<tr>
				<td>Gauti studento kursus <input type="submit" name="getKursai"></td>
			</tr>
		</table>
	</form>
	
	
<form method="get" action="GetKursoUzduotis">
		<table>
			<tr>
				<td>Kurso kodas</td>
				<td><input type="text" name="kursoKodas"></td>
			</tr>
			<tr>
				<td>Gauti kurso uzduotis <input type="submit" name="getUzduotys"></td>
			</tr>
		</table>
	</form>
</body>
</html>