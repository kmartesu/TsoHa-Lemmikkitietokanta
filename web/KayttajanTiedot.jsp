<%-- 
    Document   : KayttajanTiedot
    Created on : 27.4.2015, 22:45:48
    Author     : Kim Martesuo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "t" tagdir = "/WEB-INF/tags" %>
<!DOCTYPE html>
<t:pohja pageTitle ="KayttajanTiedot">
    <div class = "keskiosa">
        <ul class="nav nav-tabs">
        <li role="presentation" ><a href="lemmikkini">Lemmikkini</a></li>
        <li role="presentation" class="middle"><a href="Ryhma">Ryhmät</a></li>
        <li role="presentation" class="right"><a href="Tietoni">Tietoni</a></li>
        </ul>

        <div>
            <br></br>
            <div style = "border:1px groove grey; height: 500px;  border-style: solid;">
                <br></br>
                <fieldset>

                <legend>${toisenKayttajanNimi}</legend>
                <!-- Etunimi-->
                <div align = "center">
                <div class="control-group">
                  <label class="control-label" for="etunimi">Etunimi</label>
                  <div class="controls">
                      <p>${kayttajanNimi}</p>
                  </div>
                </div>

                <!-- Sukunimi-->
                <div class="control-group">
                  <label class="control-label" for="sukunimi">Sukunimi</label>
                  <div class="controls">
                      <p>${kayttajanSukuNimi}</p>
                  </div>
                </div>

                <!-- Postinumero-->
                <div class="control-group">
                  <label class="control-label" for="Postinumero">Postinumero</label>
                  <div class="controls">
                      <p>00980</p>
                  </div>
                </div>

                <!-- Sähköposti-->
                <div class="control-group">
                  <label class="control-label" for="sahkoposti">Sähköposti</label>
                  <div class="controls">
                      <p>${kayttajanSahkoposti}</p>
                  </div>
                </div>
                </div>

                </fieldset>
            </div>
        </div>
</t:pohja>    
