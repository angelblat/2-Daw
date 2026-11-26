<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
 // Obtener los parámetros del formulario
 String op1Str = request.getParameter("operando1");
 String op2Str = request.getParameter("operando2");
 String operador = request.getParameter("operador");
 double resultado = 0;
 String mensaje = "";
 try {
 double operando1 = Double.parseDouble(op1Str);
 double operando2 = Double.parseDouble(op2Str);
 switch (operador) {
 case "+":
 resultado = operando1 + operando2;
 break;
 case "-":
 resultado = operando1 - operando2;
 break;
 case "*":
 resultado = operando1 * operando2;
 break;
 case "/":
 if (operando2 != 0) {
 resultado = operando1 / operando2;
 } else {
 mensaje = "Error: División por cero.";
 }
 break;
 default:
 mensaje = "Operador no válido.";
 }
 if (mensaje.equals("")) {
 mensaje = "Resultado: " + resultado;
 }
 } catch (NumberFormatException e) {
 mensaje = "Error: Entrada no válida.";
 }
%>

<!DOCTYPE html>
<html lang="es">
<head>
 <meta charset="UTF-8">
 <title>Resultado</title>
</head>
<body>
 <h2><%= mensaje %></h2>
 <a href="index.html">Volver al formulario</a>
</body>
</html>