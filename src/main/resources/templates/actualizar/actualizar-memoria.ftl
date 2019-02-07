<!DOCTYPE html>
<html lang="en"
      xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>
  <title>Actualizar Memoria</title>
  <#include "../header.ftl">
</head>

<body>
  <!-- Navigation -->
  <#include "../nav.ftl">
  <!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">Actualizar <small>Memoria</small>
    </h1>


      <!-- Content Row -->
      <div class="row">
          <div class="col-lg-12 mb-12">
              <form  action="/memoria/actualizar" method="post" th:object="${memoria}">
                  <input type="hidden" name="id" id="id" value="${memoria.id}">
                  <input type="hidden" name="parte" id="parte" value="${parteId}">

                  <div class="form-group">
                      <label for="tipoMemoria">Tipo Memoria</label>
                      <select name="tipoMemoria" id="tipoMemoria" class="form-control">
                          <option value="-1">Seleccionar Memoria</option>
                      <#if tipoMemorias??>
                          <#list tipoMemorias as t>
                              <#if t.id == memoria.tipoMemoria.id>
                                  <option value="${t.id}" selected>${t.descripcion}</option>
                              <#else>
                                  <option value="${t.id}">${t.descripcion}</option>
                              </#if>
                          </#list>
                      </#if>
                      </select>
                  </div>

                  <div class="form-group">
                      <label for="marca">Marca</label>
                      <input type="text" class="form-control"  id="marca" name="marca" value="${memoria.marca}">
                  </div>

                  <div class="form-group">
                      <label for="precio">Precio</label>
                      <input type="number" name="precio"  id="precio" class="form-control"  value="${memoria.precio}">
                  </div>


                  <div class="form-group">
                      <label for="capacidad">Capacidad</label>
                      <input type="text" name="capacidad" id="capacidad" class="form-control" value="${memoria.capacidad}">
                  </div>


                  <div class="form-group">
                      <label for="tipoCapacidad">Tipo Capacidad</label>
                      <select name="tipoCapacidad" id="tipoCapacidad" class="form-control">
                          <option value="-1">Seleccionar Tipo Capacidad</option>
                      <#if tipoCapacidades??>
                          <#list tipoCapacidades as t>
                              <#if t.id == memoria.tipoCapacidad.id>
                                  <option value="${t.id}" selected>${t.descripcion}</option>
                              <#else>
                                  <option value="${t.id}">${t.descripcion}</option>
                              </#if>
                          </#list>
                      </#if>
                      </select>
                  </div>

                  <div class="row">
                      <div class="col-md-6"></div>
                      <div class="col-md-3">
                          <div class="form-group">
                              <button type="reset" class="btn btn-danger form-control"><i class="fa fa-times"></i> Cancelar</button>
                          </div>
                      </div>

                      <div class="col-md-3">
                          <div class="form-group">
                              <button type="submit" class="btn btn-info form-control"><i class="fa fa-paper-plane"></i> Entrar</button>
                          </div>
                      </div>
                  </div>
              </form>
              <div class="row">
                  <div class="col-xs-6">
                  <#if error??>
                      <p style="color: red">${error}</p>
                  </#if>
                  <#if msg??>
                      <p>${msg}</p>
                  </#if>
                  </div>
              </div>
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