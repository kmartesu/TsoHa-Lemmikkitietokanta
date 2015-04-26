<%-- 
    Document   : Etusivu
    Created on : 20.3.2015, 14:41:49
    Author     : Kim Martesuo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" trimDirectiveWhitespaces = "true"%>
<%@ taglib prefix = "t" tagdir = "/WEB-INF/tags" %>
<t:pohja pageTitle ="Etusivu">     
    <div class = "keskiosa">
        <ul class="nav nav-tabs">
        <li role="presentation" ><a href="lemmikkini">Lemmikkini</a></li>
        <li role="presentation" class="middle"><a href="Ryhma">Ryhmät</a></li>
        <li role="presentation" class="right"><a href="Tietoni">Tietoni</a></li>
        </ul>

        <div>
            <pre align = "center" style = "border:1px groove grey; height: 1000px; border-bottom-color: white; border-bottom-style: solid;
             border-top-style: solid; border-top-color: white;">
                
                <font size = "4">   
                Lemmikkitietokantaan voit lisätä lemmikkejäsi, luonnin yhteydessä lemmikille luodaan oma sivu. 
                Voit selailla omia ja muiden käyttäjien lemmikkejä ja hakea lemmikkejä esimerkiksi rodun perusteella.
                Voit myös tarkistaa palvelusta lähelläsi asuvia lemmikkejä postinumeron perusteella.
                Voit lisätä lemmikkisi ryhmiin ja voit luoda ryhmiä itse.
                </font>  
                <h1 align = "center">Tervetuloa!</h1>
            </pre>
        </div>
    </div>
</t:pohja>