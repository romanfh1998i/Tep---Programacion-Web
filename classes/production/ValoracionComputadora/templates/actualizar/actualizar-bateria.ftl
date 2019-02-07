<!DOCTYPE html>
<html lang="en"
      xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>

  <title>Actualizar Batería</title>
<#include "../header.ftl">
</head>

<body>
  <!-- Navigation -->
  <#include "../nav.ftl">

  <!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">Actualizar Batería</h1>

    <!-- Content Row -->
    <div class="row">
      <div class="col-lg-12 mb-12">
        <form action="/bateria/actualizar" method="post" th:object="${bateria}">
            <input type="hidden" name="id" id="id" value="${bateria.id}">
            <input type="hidden" name="parte" id="parte" value="${parteId}">

          <div class="form-group">
            <label for="precio">Precio</label>
            <input type="number" class="form-control" name="precio" id="precio" value="${bateria.precio}">
          </div>

          <div class="form-group">
            <label for="cantidadCelulas">Cantidad Celulas</label>
            <input type="number" class="form-control" name="cantidadCelulas" value="${bateria.cantidadCelulas}" id="cantidadCelulas" required>
          </div>


          <div class="form-group">
            <label for="cantidadVoltaje">Cantidad Voltaje</label>
            <input type="number" class="form-control" name="cantidadVoltaje" id="cantidadVoltaje" value="${bateria.cantidadVoltaje}">
          </div>

          <div class="form-group">
            <label for="numeroSerie">Número serie</label>
            <input type="text" class="form-control" name="numeroSerie" id="numeroSerie"  value="${bateria.numeroSerie}">
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