<%-- 
    Document   : indexPohja
    Created on : 29.3.2015, 17:08:13
    Author     : Kim Martesuo
--%>

<%@tag description="Pohja lemmikkitietokannan index-sivulle" pageEncoding="UTF-8" trimDirectiveWhitespaces = "true"%>
<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="virheViesti"%>
<%@attribute name="kayttajaLuotu"%>
<%@attribute name="kayttajaPoistettu"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap-theme.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        <div>
            <p style = "text-align:center"><img src = "cat-153337_1280.png" style = "width: 700px; height: 600px"></p>
        </div>
        <form class="form-horizontal" align = "center" action = "kirjautuminen"  method ="POST">
            <p>${kayttajaLuotu}</p>
            <p>${kayttajaPoistettu}</p>
            <!--Käyttäjätunnus input-->
            <div class="control-group">
              
              <label class="control-label" for="Kayttajatunnus">Käyttäjätunnus</label>
              <div class="controls">
                <input id="Käyttäjätunnus" name="Kayttajatunnus" type="text" placeholder="Käyttäjätunnus" class="input-xlarge">
                <p class="help-block">Kirjaudu sisään tunnuksilla: user</p>
                <p class="help-block">salasanalla: password</p>
                                      
              </div>
            </div>
            
            <!-- Salasana input-->
            <div class="control-group">
              <label class="control-label" for="Salasana">Salasana</label>
              <div class="controls">
                <input id="Salasana" name="Salasana" type="password" placeholder="Salasana" class="input-xlarge">      
              </div>
            </div>

            <!-- Sisäänkirjautumisnappi -->
            <div class="control-group">
              <label class="control-label" for="Kirjaudu sisään"></label>
              <div class="controls">
                  <p>${virheViesti}</p>
                  <button id="Kirjaudu sisään" name="Kirjaudu sisään" class="btn btn-primary">Kirjaudu sisään</button>
              </div>
            </div>
        </form>
            <form action = "Rekisteroityminen"  method ="POST" align = "center">
              <button id="Rekisteroidy" name="Rekisteroidy" class="btn btn-link">Luo käyttäjä</a>
            </form>
            
    </body>
</html>