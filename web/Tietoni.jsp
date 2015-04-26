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
            <form action = "PoistaKayttaja" method="POST">
                <div style =" margin-top: 1%"><button id="PoistaKayttaja" name="Poista" class="btn btn-danger">Poista</button></div>
            </form>
            
            <br></br>
            
            <div style = "border:1px groove grey; height: 1000px; border-bottom-color: white; border-bottom-style: solid;
             border-top-style: solid; border-top-color: grey;">
                <br></br>
            
                <form class="form-horizontal" align = "center" action = "TallennaKayttajanMuokatutTiedot" method="POST">
                <fieldset>

                <legend>Tietoni</legend>
                <p>${tietojenMuokkausViesti}</p>
                <!-- Etunimi-->
                <div class="control-group">
                  <label class="control-label" for="etunimi">Etunimi</label>
                  <div class="controls">
                      <input id="etunimi" name="etunimi" maxlength="20" type="text" value="${kayttajanNimi}" class="input-large">
                  </div>
                </div>

                <!-- Sukunimi-->
                <div class="control-group">
                  <label class="control-label" for="sukunimi">Sukunimi</label>
                  <div class="controls">
                    <input id="sukunimi" name="sukunimi" maxlength="20" type="text" value="${kayttajanSukuNimi}" class="input-large">
                  </div>
                </div>

                <!-- Postinumero-->
                <div class="control-group">
                  <label class="control-label" for="Postinumero">Postinumero</label>
                  <div class="controls">
                    <select id="postinumero" name="postinumero" class="input-xlarge">
                     <option value = "00980">00980</option>
                     <!--<c:forEach var="postinumero" items="${postinumerot}">
                       <option value = "${postinumero.numero}">${postinumero.postinumero}</option>
                     </c:forEach>-->
                    </select>
                  </div>
                </div>

                <!-- Sähköposti-->
                <div class="control-group">
                  <label class="control-label" for="sahkoposti">Sähköposti</label>
                  <div class="controls">
                      <input id="sahkoposti" name="sahkoposti" maxlength="50" type="text" value="${kayttajanSahkoposti}" class="input-large">
                  </div>
                </div>

                </fieldset>
                <div style =" margin-top: 5%"><button id="TallennaTietoni" name="TallennaTiedot" class="btn btn-primary">Tallenna</button></div>
                </form>
            </div>
        </div>
</t:pohja>    
