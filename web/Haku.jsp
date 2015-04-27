<%-- 
    Document   : Haku
    Created on : 26.4.2015, 17:06:48
    Author     : Kim Martesuo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces = "true"%>
<%@ taglib prefix = "t" tagdir = "/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:pohja pageTitle ="Haku">
    <body>
        <div class = "keskiosa">
            <ul class="nav nav-tabs">
            <li role="presentation" class="left"><a href="lemmikkini">Lemmikkini</a></li>
            <li role="presentation" class="middle"><a href="Ryhma">Ryhmät</a></li>
            <li role="presentation" class="right"><a href="Tietoni">Tietoni</a></li>
            </ul>
            <div>
                <p></p>
                <div style = "border-top:1px groove grey; border-top-style: solid; border-top-color: grey;">
                    <p><center>${virheViesti}</center></p>

                    <!-- lemmikit jotka täsmäävät hakusanaa-->
                    <h2><center>${lemmikitHaullaViesti}</center></h2>
                    <c:forEach var="lemmikki" items="${lemmikitHaulla}">
                        <form action = "LinkkiKayttajaan" method = "POST">
                            <div style = "border-style: solid; border-width: 1px; background-color: #f8f8f8;">
                                <center>
                                    <div>
                                        <p align = "left"><button name="linkkiKayttajaan" class="btn btn-link">omistaja: <c:out value="${lemmikki.omistaja}"/></button></p>
                                        <input type = "hidden" name ="toisenKayttajanNimi" value ="${lemmikki.omistaja}">
                                        <p align = "center"><h3><c:out value="${lemmikki.nimi}"/></h3>
                                        <h4>ikä: ${lemmikki.ika}</h4>
                                        <h4>${lemmikki.vari}</h4>
                                        <h4>${lemmikki.rotu}</h4>
                                        <pre>
                                            <center><c:out value="${lemmikki.kuvaus}"/></center>
                                        </pre>
                                    </div>
                                </center>
                            </div>
                        <br>
                        </form>
                    </c:forEach>
                        
                    <!-- lemmikit joiden omistajilla on hakusanaa täsmäävä postinumero-->
                    <h2><center>${lemmikitPostinumeroHaullaViesti}</center></h2>
                    <c:forEach var="lemmikkiPostinumerolla" items="${lemmikitPostinumeroHaulla}">
                        <form action = "LinkkiKayttajaan" method = "POST">
                            <div style = "border-style: solid; border-width: 1px; background-color: #f8f8f8;">
                                <center>
                                    <div>
                                        <p align = "left"><button name="linkkiKayttajaan" class="btn btn-link">omistaja: <c:out value="${lemmikkiPostinumerolla.omistaja}"/></button></p>
                                        <input type = "hidden" name ="toisenKayttajanNimi" value ="${lemmikkiPostinumerolla.omistaja}">
                                        <p align = "center"><h3><c:out value="${lemmikkiPostinumerolla.nimi}"/></h3>
                                        <h4>ikä: ${lemmikkiPostinumerolla.ika}</h4>
                                        <h4>${lemmikkiPostinumerolla.vari}</h4>
                                        <h4>${lemmikkiPostinumerolla.rotu}</h4>
                                        <pre>
                                            <center><c:out value="${lemmikkiPostinumerolla.kuvaus}"/></center>
                                        </pre>
                                    </div>
                                </center>
                            </div>
                        <br>
                        </form>
                    </c:forEach>
                    
                    <!-- lemmikit jotka täsmäävät rotuhakua -->
                    <h2><center>${lemmikitRotuHaullaViesti}</center></h2>
                    <c:forEach var="lemmikkiRodulla" items="${lemmikitRotuHaulla}">
                        <form action = "LinkkiKayttajaan" method = "POST">
                            <div style = "border-style: solid; border-width: 1px; background-color: #f8f8f8;">
                                <center>
                                    <div>
                                        <p align = "left"><button name="linkkiKayttajaan" class="btn btn-link">omistaja: <c:out value="${lemmikkiRodulla.omistaja}"/></button></p>
                                        <input type = "hidden" name ="toisenKayttajanNimi" value ="${lemmikkiRodulla.omistaja}">
                                        <p align = "center"><h3><c:out value="${lemmikkiRodulla.nimi}"/></h3>
                                        <h4>ikä: ${lemmikkiRodullaa.ika}</h4>
                                        <h4>${lemmikkiRodulla.vari}</h4>
                                        <h4>${lemmikkiRodulla.rotu}</h4>
                                        <pre>
                                            <center><c:out value="${lemmikkiRodulla.kuvaus}"/></center>
                                        </pre>
                                    </div>
                                </center>
                            </div>
                        <br>
                        </form>
                    </c:forEach>    
                </div>
            </div>
        </div>
    </body>
</t:pohja>
