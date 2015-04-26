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
                <div style = "border:1px groove grey; height: 1000px; border-bottom-color: white; border-bottom-style: solid;
                 border-top-style: solid; border-top-color: grey;">
                    <p><center>${virheViesti}</center></p>
                    <p><center>${viesti}</center></p>
                    <h1>Hakutoiminto ei vielä toiminnassa.</h1>    
                </div>
            </div>
        </div>
    </body>
</t:pohja>
