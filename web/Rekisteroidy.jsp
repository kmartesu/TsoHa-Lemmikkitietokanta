<%-- 
    Document   : Rekisteroidy
    Created on : 22.3.2015, 12:50:50
    Author     : Kim Martesuo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <form class="form-horizontal" action = "Etusivu.jsp" align = "center" style = "margin-top: 3%">
            <fieldset>

            <!-- Form Name -->
            <legend>Luo käyttäjä</legend>

            <!-- Text input-->
            <div class="control-group">
              <label class="control-label" for="kayttajatunnus">Käyttäjätunnus</label>
              <div class="controls">
                <input id="textinput" name="kayttajatunnus" type="text" placeholder="" class="input-xlarge">

              </div>
            </div>

            <!-- Text input-->
            <div class="control-group">
              <label class="control-label" for="etunimi">Etunimi</label>
              <div class="controls">
                <input id="Etunimi" name="etunimi" type="text" placeholder="" class="input-xlarge">

              </div>
            </div>

            <!-- Text input-->
            <div class="control-group">
              <label class="control-label" for="sukunimi">Sukunimi</label>
              <div class="controls">
                <input id="Sukunimi" name="sukunimi" type="text" placeholder="" class="input-xlarge">

              </div>
            </div>

            <!-- Text input-->
            <div class="control-group">
              <label class="control-label" for="sahkoposti">Sähköposti</label>
              <div class="controls">
                <input id="Sähköposti" name="sahkoposti" type="text" placeholder="" class="input-xlarge">

              </div>
            </div>

            <!-- Text input-->
            <div class="control-group">
              <label class="control-label" for="postinumero">Postinumero</label>
              <div class="controls">
                <input id="Postinumero" name="postinumero" type="number" placeholder="" class="input-xlarge">

              </div>
            </div>

            <!-- Password input-->
            <div class="control-group">
              <label class="control-label" for="salasana">Salasana</label>
              <div class="controls">
                <input id="Salasana" name="salasana" type="password" placeholder="" class="input-xlarge">

              </div>
            </div>

            <!-- Password input-->
            <div class="control-group">
              <label class="control-label" for="varmistaSalasana">Varmista salasana</label>
              <div class="controls">
                <input id="Varmista salasana" name="varmistaSalasana" type="password" placeholder="" class="input-xlarge">

              </div>
            </div>

            <!-- Button -->
            <div class="control-group">
              <label class="control-label" for="Rekisteröidy"></label>
              <div class="controls">
                <button id="Rekisteröidy" name="Rekisteröidy" class="btn btn-success">Rekisteröidy</button>
              </div>
            </div>

            </fieldset>
            </form>
    </body>
</html>
