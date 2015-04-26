<%-- 
    Document   : LemmikinMuokkaus
    Created on : 21.3.2015, 22:03:50
    Author     : Kim Martesuo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces = "true"%>
<%@ taglib prefix = "t" tagdir = "/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pohja pageTitle ="Etusivu">
    <body>
        <div class = "keskiosa">
            <ul class="nav nav-tabs">
            <li role="presentation" class="active"><a href="lemmikkini">Lemmikkini</a></li>
            <li role="presentation" class="middle"><a href="Ryhma.jsp">Ryhmät</a></li>
            <li role="presentation" class="right"><a href="Tietoni.jsp">Tietoni</a></li>
            </ul>
                
            <div>
                <p></p>
                <div>
                <form class="form-horizontal" align = "center" action = "TallennaLemmikinMuutokset" method = "POST">
                    <!-- Text input-->
                    <div class="control-group">
                      <label class="control-label" for="Nimi">Nimi</label>
                      <div class="controls">
                        <input id="Nimi" name="Nimi" maxlength="20" type="text" value="${muokattavaLemmikki.nimi}" class="input-xlarge">

                      </div>


                    <!-- Ikä-->
                      <label class="control-label" for="Ikä">Ikä</label>
                      <div class="controls">
                        <input id="Ikä" name="Ika" type="text" value="${muokattavaLemmikki.ika}" class="input-xlarge">
                      </div>


                    <!-- Rotu -->
                      <label class="control-label" for="Rotu">Rotu</label>
                      <div class="controls">
                        <select id="race" name="Rotu" class="input-xlarge">
                             <c:forEach var="Rotu" items="${rodut}">
                                <option value = "${Rotu.rotuID}">${Rotu.nimi}</option>
                             </c:forEach>
                        </select>
                      </div>


                    <!-- Vari-->
                      <label class="control-label" for="Väri">Väri</label>
                      <div class="controls">
                        <input id="Väri" name="Vari" maxlength="20" type="text" value="${muokattavaLemmikki.vari}" class="input-xlarge">
                      </div>
                      <input id="lemmikkiID" name="lemmikkiID" type="hidden" value="${muokattavaLemmikki.lemmikkiID}" class="input-xlarge">

                    <!-- Kuvaus -->
                      <label class="control-label" for="Kuvaus">Kuvaus</label>
                      <div class="controls">                     
                        <textarea id="Kuvaus" name="Kuvaus" maxlength="500">${muokattavaLemmikki.kuvaus}</textarea>
                      </div>
                      <p></p>
                      <button id="Tallenna" name="Tallenna" class="btn btn-primary">Tallenna</button>
                    </form>
                    <p></p>
                    <form class="form-horizontal" align = "center" action = "PoistaLemmikki" method = "POST">
                        <input id="lemmikkiID" name="lemmikkiID" type="hidden" value="${muokattavaLemmikki.lemmikkiID}" class="input-xlarge">
                        <button id="Poista" name="Poista" class="btn btn-primary">Poista</button>
                    </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
 </t:pohja>