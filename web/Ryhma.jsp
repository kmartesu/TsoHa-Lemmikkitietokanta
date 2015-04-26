<%-- 
    Document   : Ryhma
    Created on : 21.3.2015, 22:40:26
    Author     : Kim Martesuo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces = "true"%>
<%@ taglib prefix = "t" tagdir = "/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pohja pageTitle ="Ryhma">
    <div class = "keskiosa">
        <ul class="nav nav-tabs">
        <li role="presentation" ><a href="lemmikkini">Lemmikkini</a></li>
        <li role="presentation" class="middle active"><a href="Ryhma">Ryhmät</a></li>
        <li role="presentation" class="right"><a href="Tietoni">Tietoni</a></li>
        </ul>

        <div>
            <p></p>
            <c:forEach var="ryhma" items="${ryhmat}">
                <div style = "border-style: solid; border-width: 1px; background-color: #f8f8f8;">
                    <center>
                        <div>
                        <p align = "center"><h3><c:out value="${ryhma.ryhmaNimi}"/></h3>
                        <br>
                        <pre>
                            <center><c:out value="${ryhma.kuvaus}"/></p></center>
                        </pre>
                        </div>
                    </center>
                </div>
                <br>
            </c:forEach>
        </div>
    </div>
</t:pohja>

