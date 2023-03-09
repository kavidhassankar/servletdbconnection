<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Details</title>
</head>
<body>
  
    <h2>------Fill in the details------</h2>
  
    <form action="InsertController" method="post">
        <table>
            <tr>
                <td>ID:</td>
                <td><input type="text" name="id"  id ="id" /></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name"  id ="name"></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email" id ="email"></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><input type="text" name="phone" id ="phone" /></td>
            </tr>
            <tr />
        </table>
        <br /> <input type="submit" value="Insert Data" />
  
    </form>
    <br />
    <input type="button" value="Return to Home"
        onclick="window.location.href='Home.jsp'" />
  
  
</body>
  
</html>