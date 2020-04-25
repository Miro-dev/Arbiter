<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <!DOCTYPE html>
<html>
<body style="background-color:powderblue;">
<h2 align="center" >SSS</h2>

<div align="center">
<form action="add" method="get">
<input  type="text" name="t1"><br>
<input  type="text" name="t2"><br>
<input  type="submit"><br><br>
</form>
</div>

<div align="center">

<form action="createOrder" method="post">
<input  type="submit" value="Create"><br><br>
</form>

<form action="deleteOrder" method="post">
<input  type="number" name="destr"><br>
<input  type="submit" value="Destroy"><br><br>
</form>
</div>

</body>
</html>
