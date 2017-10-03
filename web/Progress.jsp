<%-- 
    Document   : Progress
    Created on : 30-jul-2017, 18:21:03
    Author     : Morales
--%>

<%@ include file = "header.jsp"%>

<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      
    </div>
    <div class="col-sm-8 text-left"> 
        <h3>Procesando...</h3>
        <div class="progress">
            <div id="bar" class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width:0%">
              (0%)
            </div>
        </div>
        <p id="action">Iniciando conexión</p>
    </div>
    <div class="col-sm-2 sidenav">
      
    </div>
  </div>
</div>

<script>
    progress(
            <% if(request.getAttribute("audience") != null){ %> 
            <%= request.getAttribute("audience")%>
            <% } %>
            );
</script>

<%@ include file = "footer.jsp"%>
