<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

	<title>Ninja Gold</title>
</head>
<body>





        <div class="container">
         <div class="gold_count_container">
            <p>Gold: <c:out value="${gold}"/></p>
        </div>
  
            <form action="gold" method="post">
 				<div class="row">
                  <div class="col-3">
                    <h4>Farm</h4>
                    <p>(earns 10-20 gold)</p>
                    <button type="submit" class="btn btn-info" name="getgold" value="farm">Find Gold</button>

                </div>
                <div class="col-3">
                        <h4>Cave</h4>
                        <p>(earns 5-10 gold)</p>
                        <button type="submit" class="btn btn-info" name="getgold" value="cave">Find Gold</button>

                </div>
                <div class="col-3">
                        <h4>House</h4>
                        <p>(earns 2-5 gold)</p>
                        <button type="submit" class="btn btn-info" name="getgold" value="house">Find Gold</button>

                </div>
                <div class="col-3">
                        <h4>Casino</h4>
                        <p>(earns/takes 0-50 gold)</p>
                        
                        <button type="submit" class="btn btn-info" name="getgold" value="casino">Find Gold</button>

                </div>
				</div>
            </form>
           
        <br> <br>
        <div>
        <a href="/reset" class="startover"><button type="button" class="btn btn-danger">Restart</button></a>
        </div>
        <div>
         <p>Activity log:</p>
         <div>
           <c:forEach items="${logList}" var="event">
           	<c:out value="${event}" escapeXml="false" /> <br>
           </c:forEach>
                
         </div>


            </div> 
    </div>
</body>
</html>