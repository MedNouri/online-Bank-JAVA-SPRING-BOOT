
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <jsp:include page="/WEB-INF/pages/Header.jsp"></jsp:include>

    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <!-- Outer Row -->
    
    
  
    <jsp:include page="/WEB-INF/pages/Navigation.jsp"></jsp:include>
           <div class="container-fluid">
             
    
 
 
   <h2 class="h3 mb-2 text-gray-800">Historique Compte <c:out value="${ID}"></c:out> </h2>
          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Historique</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
  
                    <tr>
                      <th>Num</th>
                      <th>Solde</th>
                      <th>Date de creation</th>
                         <th>opération</th>
                    </tr>
                  </thead>
 
 	             <c:forEach var="cmp" items="${listH}">
				<tr>

					<td>11</td>
				 	<td>${cmp.id}</td>
					<td>${cmp.amount}</td>
				    <td>${cmp.date}</td>
					<td>${cmp.operationType}</td>
				    
        
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