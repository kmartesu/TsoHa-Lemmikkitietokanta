<%-- 
    Document   : Lemmikkini
    Created on : 21.3.2015, 21:36:54
    Author     : Kim Martesuo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="../css/bootstrap.css" rel="stylesheet">
        <link href="../css/bootstrap-theme.css" rel="stylesheet">
        <link href="../css/main.css" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Etusivu</title>
    </head>
    
    <body>
        <div class = "päädiv">
            <button type="button" class="btn btn-primary navbar-btn btn-">Kirjaudu ulos</button>
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
        
        <div class = "keskiosa">
            <ul class="nav nav-tabs">
            <li role="presentation" class="active"><a href="Lemmikkini.jsp">Lemmikkini</a></li>
            <li role="presentation" class="middle"><a href="Ryhma.jsp">Ryhmät</a></li>
            <li role="presentation" class="right"><a href="Tietoni.jsp">Tietoni</a></li>
            </ul>
                
            <div>
                
                <div style =" margin-top: 5%"><a href="#" class="uusiLemmikkiButton"/>Uusi lemmikki</a></div>
                <p></p>
                <pre style = "border:1px groove grey; height: 1000px; border-bottom-color: white; border-bottom-style: solid;
                 border-top-style: solid; border-top-color: grey;">
                    <h3><center>Napero</center></h3>
                        <img src = "Koira.jpg" style = "width: 300px; height: 400px">
                        
                        <p></p>
                        <a href="#" class="uusiLemmikkiButton"/>Muokkaa</a>
                        

                        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et 
                        dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea 
                        commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                        Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum
                        
                        Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab 
                        illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur 
                        aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem 
                        ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam 
                        quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi 
                        consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum
                        fugiat quo voluptas nulla pariatur?
                        
                    </pre>
                
                </div>
            </div>
        </div>
    </body>
</html>