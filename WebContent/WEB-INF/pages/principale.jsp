
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <jsp:include page="/WEB-INF/pages/Header.jsp"></jsp:include>

    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <!-- Outer Row -->
    
    
  
    <jsp:include page="/WEB-INF/pages/Navigation.jsp"></jsp:include>
           <div class="container-fluid">
             
        <h1 class="h3 mb-2 text-gray-800">Comptes crédit </h1>
  
          
        
     
             
        <c:if test="${!empty erreur}">
        <h1>**<c:out value="${erreur}"></c:out></h1>
        </c:if>
       
    
            <form:form action="creatBankAcount" method="POST" modelAttribute="compte" >
                           
            
                    <div class="form-group">
                          
                    
                          
                   
                <div class="form-group">
                           <label for="sel1">Solde:</label>
                     
                      <form:input type="text"   class="form-control form-control-user"  id="solde" path="solde"   placeholder="00"/>
                    </div>
                    <div class="form-group">
                           <label for="sel1">libelle:</label>
                     
                      <form:input type="text"   class="form-control form-control-user"  id="libelle" path="libelle"   placeholder="libelle"/>
                    </div> 
                   
                   <input class="btn btn-primary btn-user btn-block" type="submit" value="Créer">
                 
                 
                       </form:form>
                  <hr>
 
 
   <h2 class="h3 mb-2 text-gray-800">Liste des comptes</h2>
          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Mes Comptes</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
  
                    <tr>
                      <th>Num</th>
                      <th>Solde</th>
                        <th>libelle</th>
                      
                      <th>Date de creation</th>
                         <th>Historique</th>
                         <th>supprimer </th>
                    </tr>
                  </thead>
 
 	             <c:forEach var="cmp" items="${listC}">
				<tr>

					<td>${cmp.numCompte}</td>
					<td>${cmp.solde}</td>
			
				    <td>${cmp.libelle}</td>
				    	    <td>${cmp.dateCreation}</td>
				    
				    <td>
				    
				  
  <a class="nav-link"href="<c:url value = '/History'>
  <c:param name = "usr" value = "${IDU}"/>
  <c:param name = "compteID" value = "${cmp.numCompte}"/> </c:url>">
  <button type="button" class="btn btn-outline-primary">Historique</button>
	 </td>
             <td>   			  
 
  <form:form action="supprimer" method="GET" modelAttribute="compte" >
 <form:hidden path="numCompte" value = "${cmp.numCompte}"/>
  
             <input id="usr" name="usr" type="hidden" value = "${IDU}"/>
       
                    <input class="btn btn-danger" type="submit" value="Supprimer">

</form:form>
  
	 </td>     
				</tr>
			</c:forEach>
 
                
                </table>
             
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
 
 </div>
  </div>

   <jsp:include page="/WEB-INF/pages/Footer.jsp"></jsp:include>