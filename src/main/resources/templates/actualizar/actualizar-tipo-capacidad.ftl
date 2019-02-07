<!DOCTYPE html>
<html lang="en"
      xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>

  <title>Actualizar Tipo Capacidad</title>
<#include "../header.ftl">
</head>

<body>

  <!-- Navigation -->
  <#include "../nav.ftl">

  <!-- Page Content -->
  <div class="container pb-3">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">Actualizar Tipo <small>Capacidad</small></h1>

    <!-- Content Row -->
    <div class="row">
      <div class="col-lg-12 mb-12">
        <form  action="/tipoCapacidad/actualizar" method="post" th:object="${tipoCapacidad}">
            <input type="hidden" name="id" id="id" value="${tipoCapacidad.id}">

            <div class="form-group">
                <label for="descripcion">Descripción</label>
                <textarea class="form-control" maxlength="100" minlength="2" required name="descripcion" id="descripcion" rows="3" >${tipoCapacidad.descripcion}</textarea>
                <small></small>
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