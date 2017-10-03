<%-- 
    Document   : Resultados
    Created on : 30-jul-2017, 20:19:31
    Author     : Morales
--%>

<%@ include file = "header.jsp"%>

<div class="container-fluid text-center">    
    
    <div class="row content">
    <div class="col-sm-2 sidenav">
      
    </div>
    <div class="col-sm-8 text-left"> 
        <h1>Resultados:</h1>
        <div class="col-sm-6 text-center"> 
            <h3>Competencia:</h3>
            <div class="CircularPH" data-toggle="modal" data-target="#myModal">
                <p class="TextoCircular">30 locales</p>
            </div>
            <div id="myModal" class="modal fade" role="dialog">
                <div class="modal-dialog">
                  <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Competencia</h4>
                        </div>
                        <div class="modal-body">
                            
                            <div id="map"></div>
                        </div>
                        <div class="modal-footer">
                        </div>
                  </div>

                </div>
            </div>

        </div>
        <div class="col-sm-6 text-center"> 
            <h3>Clientes potenciales:</h3>
            <div>
                <canvas id="myChart" width="400" height="400"></canvas>
                <p id="clients" style="">
                    ${param.audience}
                </p>
            </div>
        </div>
        <p style="margin-top: 20px;">Al analizar los factores del estudio de mercado, se encontró que existe una alta viabilidad para éste además de suficiente mercado. El cual contaría con almenos 200 clientes.</p>
        <p>Realiza una búsqueda con más funciones <button class="btn btn-primary">Iniciar</button></p>
    </div>
    <div class="col-sm-2 sidenav">
      
    </div>
  </div>
</div>

<script defer async src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDcUiD-WFZR5TVypnFv067CKIIjF4v7ptA&libraries=places,drawing&callback=init2ndMap">
</script>
<script>
    algo();
    startMap(2);
</script>

<%@ include file = "footer.jsp"%>