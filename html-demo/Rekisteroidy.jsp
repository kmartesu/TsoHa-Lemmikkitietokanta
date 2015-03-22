<%-- 
    Document   : Rekisteroidy
    Created on : 22.3.2015, 12:50:50
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
            <form class="form-horizontal" action = "Etusivu.jsp" align = "center" style = "margin-top: 3%">
            <fieldset>

            <!-- Form Name -->
            <legend>Luo käyttäjä</legend>

            <!-- Text input-->
            <div class="control-group">
              <label class="control-label" for="textinput">Käyttäjätunnus</label>
              <div class="controls">
                <input id="textinput" name="textinput" type="text" placeholder="" class="input-xlarge">

              </div>
            </div>

            <!-- Text input-->
            <div class="control-group">
              <label class="control-label" for="Etunimi">Etunimi</label>
              <div class="controls">
                <input id="Etunimi" name="Etunimi" type="text" placeholder="" class="input-xlarge">

              </div>
            </div>

            <!-- Text input-->
            <div class="control-group">
              <label class="control-label" for="Sukunimi">Sukunimi</label>
              <div class="controls">
                <input id="Sukunimi" name="Sukunimi" type="text" placeholder="" class="input-xlarge">

              </div>
            </div>

            <!-- Text input-->
            <div class="control-group">
              <label class="control-label" for="Sähköposti">Sähköposti</label>
              <div class="controls">
                <input id="Sähköposti" name="Sähköposti" type="text" placeholder="" class="input-xlarge">

              </div>
            </div>

            <!-- Text input-->
            <div class="control-group">
              <label class="control-label" for="Postinumero">Postinumero</label>
              <div class="controls">
                <input id="Postinumero" name="Postinumero" type="text" placeholder="" class="input-xlarge">

              </div>
            </div>

            <!-- Password input-->
            <div class="control-group">
              <label class="control-label" for="Salasana">Salasana</label>
              <div class="controls">
                <input id="Salasana" name="Salasana" type="password" placeholder="" class="input-xlarge">

              </div>
            </div>

            <!-- Password input-->
            <div class="control-group">
              <label class="control-label" for="Varmista salasana">Varmista salasana</label>
              <div class="controls">
                <input id="Varmista salasana" name="Varmista salasana" type="password" placeholder="" class="input-xlarge">

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
