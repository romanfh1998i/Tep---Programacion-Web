<!DOCTYPE html>
<html lang="en"
      xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>

  <title>Crear Computadora</title>
<#include "../header.ftl">
</head>

<body>

  <!-- Navigation -->
  <#include "../nav.ftl">

  <!-- Page Content -->
  <div class="container pb-3">

      <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">Crear <small>Computadora</small></h1>

      <!-- Content Row -->
      <div class="row">
          <div class="col-lg-6 mb-12">
              <form action="/computadora/agregar" method="post" th:object="${computadora}">

                  <div class="form-group">
                      <label for="marca">Marca</label>
                      <input type="text" name="marca" id="marca" placeholder="Marca..." title="Marca" required minlength="2" class="form-control">
                  </div>

                  <div class="form-group">
                      <label for="color">Color</label>
                      <input type="text" name="color" id="color" placeholder="Color..." title="Color" class="form-control">
                  </div>

                  <div class="form-group">
                      <label for="numeroSerie">Número serie</label>
                      <input type="text" name="numeroSerie" placeholder="Numero de serie..." id="numeroSerie" title="Número Serie" class="form-control">
                  </div>

                  <div class="form-group">
                      <label for="tamano">Tamaño</label>
                      <input type="text" name="tamano" id="tamano" required placeholder="Ej. 14'" class="form-control">
                  </div>

                  <div class="form-group">
                      <label for="anoSalida">Año salida</label>
                      <input type="number" name="anoSalida" id="anoSalida" title="Ano de salida de la computadora" placeholder="Año de salida" required class="form-control">
                  </div>

                  <div class="form-group">
                      <label for="numeroSlotMemoria">Cantidad Slot Memoria</label>
                      <input type="number"  id="numeroSlotMemoria" title="Cantidad de slot memoria" name="numeroSlotMemoria" class="form-control">
                  </div>

                  <div class="form-check">
                      <input type="checkbox"  name="tieneWebcam" title="Tiene Webcam" class="form-check-input" id="tieneWebcam">
                      <label class="form-check-label" for="tieneWebcam">Tiene Webcam</label>
                  </div>

                  <div class="form-check">
                      <input type="checkbox" name="esTouch" title="Es Touch" class="form-check-input" id="esTouch">
                      <label class="form-check-label" for="esTouch">Es Touch</label>
                  </div>

                  <div class="form-check">
                      <input type="checkbox" name="tieneCargador" title="Tiene Cargador" class="form-check-input" id="tieneCargador">
                      <label class="form-check-label" for="tieneCargador">Tiene Cargador</label>
                  </div>

                  <div class="form-check">
                      <input type="checkbox" name="tieneFan" title="Tiene Fan" class="form-check-input" id="tieneFan">
                      <label class="form-check-label" for="tieneFan">Tiene Fan</label>
                  </div>

                  <div class="form-check">
                      <input type="checkbox" class="form-check-input" name="tieneLectorCDDVD" title="Tiene Lector Cd/DVD" id="tieneLectorCDDVD">
                      <label class="form-check-label" for="tieneLectorCDDVD">Tiene Lector CD/DVD</label>
                  </div>

          </div>

          <div class="col-lg-6 mb-12">

              <div class="form-group">
                  <label for="tipoMaterial">Tipo Material</label>
                  <select name="tipoMaterial" id="tipoMaterial" required title="El Tipo de material de la computadora" class="form-control">
                      <option value="-1" selected disabled>Seleccionar Tipo Material</option>
                      <#if tipoMateriales??>
                          <#list tipoMateriales as t>
                              <option value="${t.id}">${t.descripcion}</option>
                          </#list>
                      </#if>
                  </select>
              </div>

              <div class="form-group">
                  <label for="estado">Estado</label>
                  <select name="estado" id="estado" title="Estado de la computadora" class="form-control">
                      <option value="-1" selected disabled>Seleccionar Estado</option>
                      <#if estados??>
                          <#list estados as t>
                              <option value="${t.id}">${t.descripcion}</option>
                          </#list>
                      </#if>
                  </select>
              </div>

              <div class="form-group">
                  <label for="cantidadMemoria">Cantidad Memoria</label>
                  <input type="number" name="cantidadMemoria" id="cantidadMemoria" title="Cantidad de Memorias" required class="form-control">
              </div>

              <div class="form-group">
                  <label for="tipoComputadora">Tipo Computadora</label>
                  <select name="tipoComputadora" id="tipoComputadora" required title="El tipo de computadora" class="form-control">
                      <option value="-1">Seleccionar Tipo Computadora</option>
                      <#if tipoComputadoras??>
                          <#list tipoComputadoras as t>
                              <option value="${t.id}">${t.descripcion}</option>
                          </#list>
                      </#if>
                  </select>
              </div>

              <div class="form-group">
                  <label for="tipoSistemaOperativo">Tipo Sistema Operativo</label>
                  <select name="tipoSistemaOperativo" id="tipoSistemaOperativo" title="El sistema operativo" class="form-control">
                      <option value="-1">Seleccionar Tipo Sistema Operativo</option>
                  <#if tipoSistemaOperativos??>
                      <#list tipoSistemaOperativos as t>
                          <option value="${t.id}">${t.descripcion}</option>
                      </#list>
                  </#if>
                  </select>
              </div>

              <div class="form-group">
                  <label for="cantidadPuertos">Cantidad Puertos</label>
                  <input type="number" name="cantidadPuertos" id="cantidadPuertos" required class="form-control">
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
              </form>

          </div>
      </div>

  </div>
  <!-- /.container -->

  <!-- Footer -->
  <#include "../footer.ftl">

  <!-- Bootstrap core JavaScript -->
  <#include "../scripts.ftl">
</body>

</html>