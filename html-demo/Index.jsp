<%-- 
    Document   : Index.jsp
    Created on : 22.3.2015, 12:21:37
    Author     : Kim Martesuo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="../css/bootstrap.css" rel="stylesheet">
        <link href="../css/bootstrap-theme.css" rel="stylesheet">
        <link href="../css/main.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <p style = "text-align:center"><img src = "cat-153337_1280.png" style = "width: 700px; height: 600px"></p>
        </div>
            <form class="form-horizontal" align = "center" Action = "Etusivu.jsp">
        
            <fieldset>

            <!-- Text input-->
            <div class="control-group">
              <label class="control-label" for="Käyttäjätunnus">Käyttäjätunnus</label>
              <div class="controls">
                <input id="Käyttäjätunnus" name="Käyttäjätunnus" type="text" placeholder="Käyttäjätunnus" class="input-xlarge">
                <p class="help-block">Paina "kirjaudu sisään" jatkaaksesi. Tunnuksia ei vielä ole.</p>
              </div>
            </div>

            <!-- Password input-->
            <div class="control-group">
              <label class="control-label" for="Salasana">Salasana</label>
              <div class="controls">
                <input id="Salasana" name="Salasana" type="password" placeholder="Salasana" class="input-xlarge">

              </div>
            </div>

            <!-- Button -->
            <div class="control-group">
              <label class="control-label" for="Kirjaudu sisään"></label>
              <div class="controls">
                  
                  <button id="Kirjaudu sisään" name="Kirjaudu sisään" class="btn btn-primary">Kirjaudu sisään</button>
                  
              </div>
              <a href="Rekisteroidy.jsp">Luo käyttäjä</a>
            </div>

            </fieldset>
            </form>
    </body>
</html>
