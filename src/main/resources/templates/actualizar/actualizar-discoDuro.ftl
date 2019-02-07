<!DOCTYPE html>
<html lang="en"
      xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>

  <title>Actualizar Disco Duro</title>
<#include "../header.ftl">
</head>

<body>

  <!-- Navigation -->
  <#include "../nav.ftl">

  <!-- Page Content -->
  <div class="container pb-3">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">Actualizar <small>Disco Duro</small></h1>

    <!-- Content Row -->
    <div class="row">
      <div class="col-lg-12 mb-12">
        <form  action="/discoDuro/actualizar" method="post" th:object="${discoDuro}">
            <input type="hidden" name="id" id="id" value="${discoDuro.id}">
            <input type="hidden" name="parte" id="parte" value="${parteId}">

            <div class="form-group">
                <label for="precio">Precio</label>
                <input type="number" name="precio" id="precio" min="0" class="form-control" value="${discoDuro.precio}">
            </div>
            <div class="form-group">
                <label for="capacidad">Capacidad</label>
                <input type="number" name="capacidad" id="capacidad" min="0" value="${discoDuro.capacidad}" class="form-control">
            </div>

            <div class="form-group">
                <label for="tipoCapacidad">Tipo Capacidad</label>
                <select name="tipoCapacidad" id="tipoCapacidad" class="form-control">
                    <option value="-1">Seleccionar Tipo Capacidad</option>
                <#if tipoCapacidades??>
                    <#list tipoCapacidades as t>
                        <#if t.id == discoDuro.tipoCapacidad.id>
                            <option value="${t.id}" selected>${t.descripcion}</option>
                        <#else>
                            <option value="${t.id}">${t.descripcion}</option>
                        </#if>
                    </#list>
                </#if>
                </select>
            </div>

            <div class="form-group">
                <label for="durabilidad">Durabilidad</label>
                <input type="number" name="durabilidad" id="durabilidad" min="0" value="${discoDuro.durabilidad}" class="form-control">
            </div>

            <div class="form-group">
                <label for="velocidad">Velocidad</label>
                <input type="number" name="velocidad" id="velocidad" min="0" value="${discoDuro.velocidad}" class="form-control">
            </div>

            <div class="form-group">
                <label for="tipoDiscoDuro">Tipo Disco Duro</label>
                <select name="tipoDiscoDuro" id="tipoDiscoDuro" class="form-control">
                    <option value="-1">Seleccionar Tipo Disco Duro</option>
                    <#if tipoDiscoDuros??>
                        <#list tipoDiscoDuros as t>
                            <#if t.id == discoDuro.tipoDiscoDuro.id>
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