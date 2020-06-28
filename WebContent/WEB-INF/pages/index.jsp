<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html lang="fr">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Login</title>

  <!-- Custom fonts for this template-->
     <link href="<c:url value="/resources/vendor/fontawesome-free/css/all.min.csss" />" rel="stylesheet">
 
  
 
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
      <link href="<c:url value="/resources/css/sb-admin-2.min.css" />" rel="stylesheet">
 

</head>

<body class="bg-gradient-primary">
<div class="container">


    <!-- Outer Row -->
    <div class="row justify-content-center">
     
        
   
        
        
         <div class="col-xl-6 col-lg-6 col-md-9">

        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
              
              <div class="col-lg-12">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">Connectez vous !</h1>
                       <c:if test="${!empty erreur}">
        <h6>**<c:out value="${erreur}"></c:out></h6>
        </c:if>
        
                         <c:if test="${!empty Newid}">
        <h6>*Votre Compte ID :*<c:out value="${Newid}"></c:out></h6>
        </c:if>
        
        
                  </div>
                  <form:form class="user" action="checkUser" method="post" modelAttribute="usr">
                    <div class="form-group">
                           <form:input type="text" class="form-control form-control-user" id="id" path="id" aria-describedby="emailHelp" placeholder="Enter Compte ID ..."/>
                    </div>
                    <div class="form-group">
                      <form:input type="password"   class="form-control form-control-user"  id="password"  path="password" placeholder="Password"/>
                    </div>
             
                   <input class="btn btn-primary btn-user btn-block" type="submit" value="Se connecter">
                 
                 
                       </form:form>
                  <hr>
                  
                  
                  				  
				         <div class="text-center">
                     <a class="small" href="<c:url value = '/register'></c:url>" >  inscription</a>
                  </div>
				  
 
 
    
                        
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>
        
</div>
  </div>
 
   <jsp:include page="/WEB-INF/pages/Footer.jsp"></jsp:include>

 