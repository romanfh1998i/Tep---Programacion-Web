<!DOCTYPE html>
<html lang="en"
      xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>
  <title>Actualizar Teclado</title>
  <#include "../header.ftl">
</head>

<body>
  <!-- Navigation -->
  <#include "../nav.ftl">
  <!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">Actualizar <small>Teclado</small>
    </h1>


      <!-- Content Row -->
      <div class="row">
          <div class="col-lg-12 mb-12">
              <form  action="/teclado/actualizar" method="post" th:object="${teclado}">
                  <input type="hidden" name="id" id="id" value="${teclado.id}">
                  <input type="hidden" name="parte" id="parte" value="${parteId}">

                  <div class="form-group">
                      <label for="tipoTeclado">Tipo teclado</label>
                      <select name="tipoTeclado" id="tipoTeclado" class="form-control">
                          <option value="-1">Seleccionar Tipo teclado</option>
                          <#if tipoTeclados??>
                              <#list tipoTeclados as t>
                                  <#if t.id == teclado.tipoTeclado.id>
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