<%-- 
    Document   : Lemmikkini
    Created on : 21.3.2015, 21:36:54
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
                <div style =" margin-top: 5%"><a href="UusiLemmikki" class="btn btn-primary"/>Uusi lemmikki</a></div>
                <p></p>
                <div style = "border:1px groove grey; height: 1000px; border-bottom-color: white; border-bottom-style: solid;
                 border-top-style: solid; border-top-color: grey;">
                    <p><center>${virheViesti}</center></p>
                    <p><center>${viesti}</center></p>
                        <c:forEach var="lemmikki" items="${lemmikit}">
                        <form action = "MuokkaaLemmikkia" method="POST">
                            <div class="lemmikki" style = "border-style: solid; border-width: 1px; background-color: #f8f8f8;">
                                <center><div>
                                    <p align = "center"><h3><c:out value="${lemmikki.nimi}"/></h3>
                                    <br>
                                    <h4>${lemmikki.ika}</h4>
                                    <br>
                                    <center><img src = "${lemmikki.kuva}" style = "width: 300px; height: 400px"></center>
                                    <br>
                                    <pre>
                                    <center><c:out value="${lemmikki.kuvaus}"/></p></center>
                                    </pre>
                                    </div></center>
                                    <p><input id = "lemmikinID" type = "hidden" name ="lemmikinID" value ="${lemmikki.lemmikkiID}"></p>
                                <div>
                                    <center><button name="Muokkaa" class="btn btn-primary">Muokkaa</button></center>
                                    <br>
                                </div>
                            </div>
                        </form>
                        <br>
                        </c:forEach>
                </div>
            </div>
        </div>
    </body>
</t:pohja>