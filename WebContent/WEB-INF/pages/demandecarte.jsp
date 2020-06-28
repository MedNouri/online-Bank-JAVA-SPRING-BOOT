 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 <jsp:include page="/WEB-INF/pages/Header.jsp"></jsp:include>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
    <!-- Outer Row -->
    
    
  
    <jsp:include page="/WEB-INF/pages/Navigation.jsp"></jsp:include>
           <div class="container-fluid">
             
    
 
       <!-- Page Heading -->
          <h1 class="h3 mb-2 text-gray-800">Demande de Carte</h1>
  
         
        <c:if test="${!empty erreur}">
        <h1>**<c:out value="${erreur}"></c:out></h1>
        </c:if>
       
    
            <form:form action="addCarte" method="POST" modelAttribute="carte" >
              <form:hidden path="usr.id"/>
                    <div class="form-group">
                          
                                                    <label for="sel1">Compte :</label>
                          
                          <form:select class="form-control form-control-user" path="compte.numCompte">
                 <form:options  items="${listC}"  itemValue="numCompte" itemLabel="numCompte"/>
                </form:select>
                           </div>
                    <div class="form-group">
                          <label for="sel1">Type de carte :</label>
                    
                    <form:select class="form-control form-control-user"  path="typeCarte.id">
                 <form:options  items="${listTC}"  itemValue="id" itemLabel="libelle"/>
                </form:select>
                     </div>
                     <div class="form-group">
                           <label for="sel1">Adresse:</label>
                     
                      <form:input type="text"   class="form-control form-control-user"  id="adresse" path="adresse" placeholder="Adresse de Livraison:"/>
                    </div>
                    
                   
                   <input class="btn btn-primary btn-user btn-block" type="submit" value="Demander">
                 
                 
                       </form:form>
                  <hr>
             <h1 class="h3 mb-2 text-gray-800">Demande de Carte</h1>
   
          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Mes Demande</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
  
                    <tr>
                      <th>Num Dem</th>
                      <th>Num Compte</th>
                      <th>libelle</th>
                      <th>Adresse</th>
                    </tr>
                  </thead>
 
 	   		<c:forEach var="dem" items="${listDem}">
				<tr>

					<td>${dem.numDemCarte}</td>
					<td>${dem.compte.numCompte}</td>
				    <td>${dem.typeCarte.libelle}</td>
					<td>${dem.adresse}</td>
				</tr>
			</c:forEach>
                
                </table>
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
 
 
  </div>

   <jsp:include page="/WEB-INF/pages/Footer.jsp"></jsp:include>