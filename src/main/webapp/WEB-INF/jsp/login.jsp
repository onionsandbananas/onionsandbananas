<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
    <h2>Biblioteka</h2>
	<form action = "login_check" method="POST">
         Login: <input type="text" name="login">
         <br/>
         Hasło: <input type="password" name="password">
         <br/>
         <input type = "submit" value="Login"/>
      </form>
    <a href="welcome">Kontynuuj bez logowania</a>
</body>
</html>