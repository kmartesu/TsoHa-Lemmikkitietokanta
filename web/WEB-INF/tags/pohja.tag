<%-- 
    Document   : pohja
    Created on : 27.3.2015, 17:09:31
    Author     : Kim Martesuo
--%>

<%@tag description="Pohja lemmikkitietokannan sivuille" pageEncoding="UTF-8" trimDirectiveWhitespaces = "true"%>
<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="pageTitle"%>
<%@attribute name="kayttajaKirjautunut"%>
<%@attribute name="lemmikit"%>
<%@attribute name="virheViesti"%>
<%@attribute name="rodut"%>
<%@attribute name="viesti"%>
<%@attribute name="virheet"%>
<%@attribute name="muokattavaLemmikki"%>
<%-- any content can be specified here e.g.: --%>
<!DOCTYPE html>
<html>
    <head>
        <title>${pageTitle}</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap-theme.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
    </head>
    <body>
        <div class = "päädiv">
            
            <p style = "margin-left: 86%;">Tervetuloa! ${kayttajaKirjautunut}</p>
            <a style ="margin-left: 84%;" href="Uloskirjautuminen" class="btn btn-primary">Kirjaudu ulos</a>
            
        <div class="container">
	<div class="row">
        <div class="col-sm-6 col-sm-offset-3">
            <div id="imaginary_container"> 
                <div class="input-group stylish-input-group">
                    <input type="text" class="form-control"  placeholder="Haku" >
                    <span class="input-group-addon">
                        <button type="submit">
                            <span class="glyphicon glyphicon-search"></span>
                        </button>
                    </span>
                </div>
            </div>
        </div>
	</div>
        </div>
            <jsp:doBody/>
        </div>
    </body>
</html>
