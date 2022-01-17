<%-- 
    Document   : arithmeticcalculator
    Created on : Jan 16, 2022, 5:00:45 PM
    Author     : Yoonju Baek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        
        <form action="arithmetic" method="post">
            <div>
            <label for="first">First: </label>
            <input type="text" name="first" id="first" value="${firstInput}">
            </div>
            <div>
            <label for="second">Second: </label>
            <input type="text" name="second" id="second" value="${secondInput}">
            </div>
            <div>
                <button type="submit" id="add" name="add">+</button>
                <button type="submit" id="subtract" name="subtract">-</button>
                <button type="submit" id="multiply" name="multiply">*</button>
                <button type="submit" id="divide" name="divide">%</button>
            </div>
            
        </form>

        <br>
        <div>Result: ${result}</div>
        <a href="age">Age Calculator</a>
    </body>
</html>
