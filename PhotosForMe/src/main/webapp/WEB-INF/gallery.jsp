<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Photographer Gallery | Photography For Me</title>
        <link rel="stylesheet" type="text/css" media="screen" href="styles/gallery.css" />
    </head>

    <body>
        <jsp:include page="navbar.jsp" />
        <h2>Photographer Gallery</h2>
        
        <c:forEach var="photographer" items="${photographers}">
        
        <div class="photographers">
            <div class="container">
                <form action="gallery.do" method="POST">
                <figure class="photographer-img">
                <img src="images/logo.png" alt="Photographer" class="photographer-pic">
                	<figcaption class="caption">${photographer.user.firstName}, ${photographer.user.lastName}</figcaption>
                	<figcaption class="caption">${photographer.user.address.city}, ${photographer.user.address.state}</figcaption>
                	<figcaption class="caption">5 Stars</figcaption>
                	<input type="hidden" name="photographerid" value="${photographer.id}">  
                <button type="submit" class="login-button btn" >View Photographer</button>
                </figure>
                </form>
                <div class="photographer-gallery">
                	<c:forEach begin="1" end="4" step="1" items="${photographer.gallery[0].images}" var="image">
        				<img src="${image.urlLink}" />
      				</c:forEach>
                </div>
            </div>
        </div>
        
        </c:forEach>

        <script src="main.js"></script>
    </body>
	
</html>