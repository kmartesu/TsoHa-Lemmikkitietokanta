<%-- 
    Document   : Tietoni
    Created on : 21.3.2015, 22:43:24
    Author     : Kim Martesuo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix = "t" tagdir = "/WEB-INF/tags" %>
<t:pohja pageTitle ="Tietoni">
    <div class = "keskiosa">
        <ul class="nav nav-tabs">
        <li role="presentation" ><a href="lemmikkini">Lemmikkini</a></li>
        <li role="presentation" class="middle"><a href="Ryhma">Ryhmät</a></li>
        <li role="presentation" class="right active"><a href="Tietoni">Tietoni</a></li>
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
</t:pohja>    
