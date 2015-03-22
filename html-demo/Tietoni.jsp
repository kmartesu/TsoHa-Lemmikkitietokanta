<%-- 
    Document   : Tietoni
    Created on : 21.3.2015, 22:43:24
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
        <title>Etusivu</title>
    </head>
    
    <body>
        <div class = "päädiv">
            <button type="button" class="btn btn-primary navbar-btn btn-">Kirjaudu ulos</button>
        <div class="container">
	<div class="row">
        <div class="col-sm-6 col-sm-offset-3">
            <div id="imaginary_container"> 
                <div class="input-group stylish-input-group">
                    <input type="text" class="form-control"  placeholder="Haku" >
                    <span class="input-group-addon">
                        <button type="submit">
                            <span class="glyphicon glyphicon-search"></span>
                        </button>
                    </span>
                </div>
            </div>
        </div>
	</div>
        </div>
        
        <div class = "keskiosa">
            <ul class="nav nav-tabs">
            <li role="presentation" ><a href="Lemmikkini.jsp">Lemmikkini</a></li>
            <li role="presentation" class="middle"><a href="Ryhma.jsp">Ryhmät</a></li>
            <li role="presentation" class="right active"><a href="Tietoni.jsp">Tietoni</a></li>
            </ul>
                
            <div>
                <div style =" margin-top: 5%"><a href="#" class="uusiLemmikkiButton"/>Tallenna</a><a href="#" class="uusiLemmikkiButton"/>Poista</a></div>
                <br></br>
                <div style = "border:1px groove grey; height: 1000px; border-bottom-color: white; border-bottom-style: solid;
                 border-top-style: solid; border-top-color: grey;">
                    <br></br>
                    <form class="form-horizontal" align = "center">
                    <fieldset>

                    <!-- Form Name -->
                    <legend>Tietoni</legend>

                    <!-- Text input-->
                    <div class="control-group">
                      <label class="control-label" for="Käyttäjätunnus">Käyttäjätunnus</label>
                      <div class="controls">
                        <input id="Käyttäjätunnus" name="Käyttäjätunnus" type="text" placeholder="käyttäjätunnus" class="input-large">

                      </div>
                    </div>

                    <!-- Text input-->
                    <div class="control-group">
                      <label class="control-label" for="Etunimi">Etunimi</label>
                      <div class="controls">
                        <input id="Etunimi" name="Etunimi" type="text" placeholder="etunimi" class="input-large">

                      </div>
                    </div>

                    <!-- Text input-->
                    <div class="control-group">
                      <label class="control-label" for="Sukunimi">Sukunimi</label>
                      <div class="controls">
                        <input id="Sukunimi" name="Sukunimi" type="text" placeholder="sukunimi" class="input-large">

                      </div>
                    </div>

                    <!-- Text input-->
                    <div class="control-group">
                      <label class="control-label" for="Postinumero">Postinumero</label>
                      <div class="controls">
                        <input id="Postinumero" name="Postinumero" type="text" placeholder="Postinumero" class="input-large">

                      </div>
                    </div>
                    
                    <div class="control-group">
                      <label class="control-label" for="Postinumero">Sähköposti</label>
                      <div class="controls">
                        <input id="Sähköposti" name="Sähköposti" type="text" placeholder="Sähköposti" class="input-large">

                      </div>
                    </div>

                    </fieldset>
                    </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
