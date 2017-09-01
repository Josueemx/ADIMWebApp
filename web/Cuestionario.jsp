<%-- 
    Document   : Cuestionario
    Created on : 26-jul-2017, 12:59:07
    Author     : Morales
--%>

<%@ include file = "header.jsp"%>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      
    </div>
    <div class="col-sm-8 text-left"> 
        <h3>Ubicación del negocio</h3>
        
        
            <input id="pac-input" class="controls" type="text" placeholder="Introduce una ubicación">
            <div id="map"></div>
        
        
        <hr>
        <h3>Información sobre segmentación</h3>
        <form action="Request" method="post">
            <div class="form-group">
                <input type="hidden" name="lat" id="lat">
                <input type="hidden" name="lon" id="lon">
                <input type="hidden" name="radius" id="radius" value="1000"><!-- aqui puede cambiar -->
            </div>
            <div class="form-group">
                <label for="minAge">Edad:</label>
                <br>
                <select id="minAge" name="minAge">
                    <option value="18" selected>18</option>
                    <% for(int i = 19; i < 65; i++){ %>
                        <option value="<%=i%>"><%=i%></option>
                    <% } %>
                </select>
                <label> - </label>
                <select id="maxAge" name="maxAge">
                    <% for(int i = 18; i < 64; i++){ %>
                        <option value="<%=i%>"><%=i%></option>
                    <% } %>
                    <option value="64" selected>64</option>
                </select>
            </div>
            <div class="form-group">
                <label>Género:</label>
                <br>
                <label class="radio-inline"> <!-- aqui checar los valores de los radios, en ingles? -->
                    <input type="radio" name="gender" value="Todos" checked>Todos
                </label>
                <label class="radio-inline">
                    <input type="radio" name="gender" value="Hombres">Hombres
                </label>
                <label class="radio-inline">
                    <input type="radio" name="gender" value="Mujeres">Mujeres
                </label>
            </div>
            <div class="form-group">
                <label for="interests">Intereses:</label>
                <input type="text" name="interests" id="interests" placeholder="(separados por coma)" autocomplete="off" size="50">
            </div>
            <input class="btn btn-default pull-right" type="submit" value="Terminar">
            <br>
            <br>
        </form>
    </div>
    <div class="col-sm-2 sidenav">
      
    </div>
  </div>
</div>

<script defer async src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDcUiD-WFZR5TVypnFv067CKIIjF4v7ptA&libraries=places,drawing&callback=initMap">
</script>
<script>
    startMap(1);
</script>
                
<%@ include file = "footer.jsp"%>
