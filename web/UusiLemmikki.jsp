<%-- 
    Document   : UusiLemmikki
    Created on : 10.4.2015, 13:05:17
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
            <li role="presentation" class="middle"><a href="Ryhma">Ryhmät</a></li>
            <li role="presentation" class="right"><a href="Tietoni">Tietoni</a></li>
            </ul>
            <div>
                <div>
                    <c:forEach var="Virheet" items="${virheet}">
                        <p>${virheet}</p>
                    </c:forEach>
                <p></p>
                <form class="form-horizontal" align = "center" action = "TallennaLemmikki" method="POST">
                    
                    <p></p>
                    <!-- Nimi-->
                    <div class="control-group">
                      <label class="control-label" for="Nimi">Nimi</label>
                      <div class="controls">
                        <input id="name" name="Nimi" maxlength="20" type="text" placeholder="lemmikin nimi" class="input-xlarge">
                      </div>


                    <!-- Ikä-->
                      <label class="control-label" for="lemmikinIka">Ikä</label>
                      <div class="controls">
                        <input id="lika"  name="lemmikinIka" type="number" placeholder="lemmikin ikä" class="input-xlarge">
                      </div>


                    <!-- Rotu-->
                      <label class="control-label" for="Rotu">Rotu</label>
                      <div class="controls">
                        <select id="race" name="Rotu" class="input-xlarge">
                             <c:forEach var="Rotu" items="${rodut}">
                                <option value = "${Rotu.rotuID}">${Rotu.nimi}</option>
                             </c:forEach>
                        </select>
                      </div>


                    <!-- Väri-->
                      <label class="control-label" for="Vari">Väri</label>
                      <div class="controls">
                        <input id="color" name="Vari" maxlength="20" type="text" placeholder="lemmikin väri" class="input-xlarge">
                      </div>


                    <!-- Kuvaus-->
                      <label class="control-label" for="Kuvaus">Kuvaus</label>
                      <div class="controls">                     
                        <textarea id="describe" name="Kuvaus" maxlength="500"></textarea>
                      </div>
                      <p></p>
                      <button id="Tallenna" name="Tallenna" class="btn btn-primary">Tallenna</button>
                      <a href="lemmikkini" class="uusiLemmikkiButton"/>Peruuta</a>
                    </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</t:pohja>
