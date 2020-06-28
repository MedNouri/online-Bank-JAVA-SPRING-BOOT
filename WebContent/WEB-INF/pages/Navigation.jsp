
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <!-- Page Wrapper --> 
  <div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

      <!-- Sidebar - Brand -->
      <a class="sidebar-brand d-flex align-items-center justify-content-center" href="#">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">Ma Banque En Ligne</div>
      </a>

       <hr class="sidebar-divider my-0">

       <li class="nav-item">
      
         
        
     
 
  
        
          <li class="nav-item">
        <a class="nav-link" href="<c:url value = '/principale'>
   <c:param name = "usr" value = "${user.id}"/>
</c:url>">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Liste des comptes</span></a>
      </li>
        
        
        <hr class="sidebar-divider">
        
        
 
   
        
  <li class="nav-item">
  <a class="nav-link"href="<c:url value = '/demCarte'>
   <c:param name = "usr" value = "${user.id}"/>
</c:url>">


   <div class="sidebar-heading">
        Carte
      </div>
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Demande de carte</span></a>
      </li>
        
      <!-- Divider -->
      <hr class="sidebar-divider">

 
 
      <!-- Divider -->
   
  <li class="nav-item">
  <a class="nav-link"href="<c:url value = '/Checkbook'>
   <c:param name = "usr" value = "${user.id}"/>
</c:url>">


   <div class="sidebar-heading">
        Chèques
      </div>
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Demande de chéquier</span></a>
      </li>
 
      <!-- Divider -->
      <hr class="sidebar-divider d-none d-md-block">


 

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

      <!-- Main Content -->
      <div id="content">

        <!-- Topbar -->
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

          

       
          <!-- Topbar Navbar -->
          <ul class="navbar-nav ml-auto">

          
  
  
  
  
 
              <a class="nav-link dropdown-toggle" href="<c:url value = '/'></c:url>">
                          <span class="mr-2 d-none d-lg-inline text-gray-600 small">Déconnexion</span>
          </a>
          
  
  

          </ul>

        </nav>