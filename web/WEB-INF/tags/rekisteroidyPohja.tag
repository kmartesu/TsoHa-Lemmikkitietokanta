<%-- 
    Document   : rekisteroidyPohja
    Created on : 17.4.2015, 14:00:02
    Author     : Kim Martesuo
--%>

<%@tag description="Pohja rekisteröitymissivulle" pageEncoding="UTF-8" trimDirectiveWhitespaces = "true"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="salasanatEiTasmaa"%>
<%@attribute name="postinumerot"%>
<%@attribute name="kayttajatunnusEiVapaa"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap-theme.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rekisteroityminen</title>
    </head>
    <body>
            <form class="form-horizontal" action = "RekisteroiUusiKayttaja" align = "center" style = "margin-top: 3%">
            <fieldset>
            <legend>Luo käyttäjä</legend>

            <!-- Uuden käyttäjän käyttäjätunnus-->
            <div class="control-group">
              <p>${kayttajatunnusEiVapaa}</p>
              <label class="control-label" for="kayttajatunnus">Kayttajatunnus</label>
              <div class="controls">
                <input id="textinput" name="kayttajatunnus" maxlength="20" type="text" placeholder="" class="input-xlarge">
              </div>
            </div>

            <!-- Etunimi-->
            <div class="control-group">
              <label class="control-label" for="etunimi">Etunimi</label>
              <div class="controls">
                <input id="Etunimi" name="etunimi" type="text" maxlength="20" placeholder="" class="input-xlarge">
              </div>
            </div>

            <!-- Sukunimi-->
            <div class="control-group">
              <label class="control-label" for="sukunimi">Sukunimi</label>
              <div class="controls">
                <input id="Sukunimi" name="sukunimi" maxlength="20" type="text" placeholder="" class="input-xlarge">
              </div>
            </div>

            <!-- Sähköposti-->
            <div class="control-group">
              <label class="control-label" for="sahkoposti">Sahkoposti</label>
              <div class="controls">
                <input id="Sähköposti" name="sahkoposti" maxlength="50" type="text" placeholder="" class="input-xlarge">
              </div>
            </div>

            <!-- Postinumero-->
            <label class="control-label" for="postinumero">Postinumero</label>
            <div class="control-group">
             <select id="postinumero" name="postinumero" class="input-xlarge">
                 <option value = "00980">00980</option>
                 <!--<c:forEach var="postinumero" items="${postinumerot}">
                   <option value = "${postinumero.numero}">${postinumero.postinumero}</option>
                 </c:forEach>-->
             </select>
            </div>

            <!-- Salasana-->
            <div class="control-group">
                <p>${salasanatEiTasmaa}</p>
              <label class="control-label" for="salasana">Salasana</label>
              <div class="controls">
                <input id="Salasana" name="salasana" maxlength="20" type="password" placeholder="" class="input-xlarge">
              </div>
            </div>

            <!-- Salasanan varmistus-->
            <div class="control-group">
              <label class="control-label" for="varmistaSalasana">Varmista salasana</label>
              <div class="controls">
                <input id="Varmista salasana" name="varmistaSalasana" maxlength="20" type="password" placeholder="" class="input-xlarge">
              </div>
            </div>

            <!-- rekisteroityminen -->
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