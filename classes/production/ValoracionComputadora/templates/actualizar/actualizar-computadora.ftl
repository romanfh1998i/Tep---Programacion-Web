<!DOCTYPE html>
<html lang="en"
      xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>
  <title>Actualizar Computadora</title>
  <#include "../header.ftl">
</head>

<body>
  <!-- Navigation -->
  <#include "../nav.ftl">
  <!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">Actualizar <small>Computadora</small>
    </h1>


      <!-- Content Row -->
      <!-- Content Row -->
      <div class="row">

              <form action="/computadora/actualizar" method="post" th:object="${computadora}">
                  <div class="col-lg-6 mb-12">
                      <input type="hidden" name="id" id="id" value="${computadora.id}">

                      <div class="form-group">
                          <label for="marca">Marca</label>
                          <input  type="text" id="marca" name="marca" class="form-control" value="${computadora.marca}">
                      </div>

                      <div class="form-group">
                          <label for="color">Color</label>
                          <input type="text" name="color" id="color" class="form-control" value="${computadora.color}">
                      </div>

                      <div class="form-group">
                          <label for="numeroSerie">Numero serie</label>
                          <input type="text" name="numeroSerie" id="numeroSerie" class="form-control" value="${computadora.numeroSerie}">
                      </div>

                      <div class="form-group">
                          <label for="tamano">Tamaño</label>
                          <input type="text" name="tamano" id="tamano" class="form-control" value="${computadora.tamano}">
                      </div>

                      <div class="form-group">
                          <label for="anoSalida">Año salida</label>
                          <input type="number" name="anoSalida" id="anoSalida" class="form-control" value="${computadora.anoSalida}">
                      </div>

                      <div class="form-group">
                          <label for="numeroSlotMemoria">Número Slot Memoria</label>
                          <input type="number" id="numeroSlotMemoria" name="numeroSlotMemoria" class="form-control" value="${computadora.numeroSlotMemoria}">
                      </div>

                      <div class="form-check">
                          <#if computadora.tieneWebcam??>
                              <input type="checkbox" name="tieneWebcam" class="form-check-input" id="tieneWebcam" checked>
                          <#else>
                              <input type="checkbox" name="tieneWebcam" class="form-check-input" id="tieneWebcam">
                          </#if>
                          <label class="form-check-label" for="tieneWebcam">Tiene Webcam</label>
                      </div>

                      <div class="form-check">
                      <#if computadora.esTouch??>
                          <input type="checkbox" class="form-check-input" name="esTouch" id="esTouch" checked>
                      <#else>
                          <input type="checkbox" class="form-check-input" name="esTouch" id="esTouch">
                      </#if>
                          <label class="form-check-label" for="esTouch">Es Touch</label>
                      </div>

                      <div class="form-check">
                      <#if computadora.tieneCargador??>
                          <input type="checkbox" class="form-check-input" name="tieneCargador" id="tieneCargador" checked>
                      <#else>
                          <input type="checkbox" class="form-check-input" name="tieneCargador" id="tieneCargador">
                      </#if>
                          <label class="form-check-label" for="tieneCargador">Tiene Cargador</label>
                      </div>

                      <div class="form-check">
                      <#if computadora.tieneFan??>
                          <input type="checkbox" class="form-check-input" name="tieneFan" id="tieneFan" checked>
                      <#else>
                          <input type="checkbox" class="form-check-input" name="tieneFan" id="tieneFan">
                      </#if>
                          <label class="form-check-label" for="tieneFan">Tiene Fan</label>
                      </div>

                      <div class="form-check">
                      <#if computadora.tieneLectorCDDVD??>
                          <input type="checkbox" class="form-check-input" id="tieneLectorCDDVD" checked>
                      <#else>
                          <input type="checkbox" class="form-check-input" id="tieneLectorCDDVD">
                      </#if>
                          <label class="form-check-label" for="tieneLectorCDDVD">Tiene Lector CV-DVD</label>
                      </div>

                   </div>

                   <div class="col-lg-6 mb-12">

                  <div class="form-group">
                      <label for="tipoMaterial">Tipo Material</label>
                      <select name="tipoMaterial" id="tipoMaterial" required class="form-control">
                          <#if tipoMateriales??>
                              <#list tipoMateriales as t>
                                  <#if t.id == computadora.tipoMaterial.id>
                                      <option value="${t.id}" selected>${t.descripcion}</option>
                                  <#else>
                                      <option value="${t.id}">${t.descripcion}</option>
                                  </#if>
                              </#list>
                          </#if>
                      </select>
                  </div>

                  <div class="form-group">
                      <label for="estado">Estado</label>
                      <select name="estado" id="estado" required class="form-control">
                      <#if estados??>
                          <#list estados as e>
                              <#if e.id == computadora.estado.id>
                                  <option value="${e.id}" selected>${e.descripcion}</option>
                              <#else>
                                  <option value="${e.id}">${e.descripcion}</option>
                              </#if>
                          </#list>
                      </#if>
                      </select>
                  </div>

                  <div class="form-group">
                      <label for="cantidadMemoria">Cantidad Memoria</label>
                      <input type="number" id="cantidadMemoria" name="cantidadMemoria" class="form-control"  value="${computadora.cantidadMemoria}">
                  </div>

                  <div class="form-group">
                      <label for="tipoComputadora">Tipo Computadora</label>
                      <select name="tipoComputadora" id="tipoComputadora" required class="form-control">
                      <#if tipoComputadoras??>
                          <#list tipoComputadoras as t>
                              <#if t.id == computadora.tipoComputadora.id>
                                  <option value="${t.id}" selected>${t.descripcion}</option>
                              <#else>
                                  <option value="${t.id}">${t.descripcion}</option>
                              </#if>
                          </#list>
                      </#if>
                      </select>
                  </div>

                  <div class="form-group">
                      <label for="tipoSistemaOperativo">Tipo Sistema Operativo</label>
                      <select name="tipoSistemaOperativo" id="tipoSistemaOperativo" class="form-control">
                      <#if tipoSistemaOperativos??>
                          <#list tipoSistemaOperativos as t>
                              <#if t.id == computadora.tipoSistemaOperativo.id>
                                  <option value="${t.id}" selected>${t.descripcion}</option>
                              <#else>
                                  <option value="${t.id}">${t.descripcion}</option>
                              </#if>
                          </#list>
                      </#if>
                      </select>
                  </div>

                  <div class="form-group">
                      <label for="cantidadPuertos">Cantidad Puertos</label>
                      <input type="number" id="cantidadPuertos" name="cantidadPuertos" class="form-control" value="${computadora.cantidadPuertos}">
                  </div>



                  <div class="row">
                      <div class="col-md-6">
                          <div class="form-group">
                              <button type="reset" class="btn btn-danger form-control"><i class="fa fa-times"></i> Cancelar</button>
                          </div>
                      </div>

                      <div class="col-md-6">
                          <div class="form-group">
                              <button type="submit" class="btn btn-info form-control"><i class="fa fa-paper-plane"></i> Entrar</button>
                          </div>
                      </div>
                  </div>

                 </div>
          </form>
      </div>


  </div>
  <!-- /.container -->

  <!-- Footer -->
  <#include "../footer.ftl">
  <!-- Bootstrap core JavaScript -->
  <#include "../scripts.ftl">

</body>

</html>