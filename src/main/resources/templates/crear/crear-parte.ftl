<!DOCTYPE html>
<html lang="en"
      xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>

  <title>Crear Parte</title>
<#include "../header.ftl">
</head>

<body>

  <!-- Navigation -->
  <#include "../nav.ftl">

  <!-- Page Content -->
  <div class="container pb-3">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">Crear <small>Parte</small></h1>

    <!-- Content Row -->
    <div class="row">
      <div class="col-lg-12 mb-12">
        <form  action="/parte/agregar" method="post" th:object="${parte}">

            <div class="form-group">
                <label for="computadora">Computadora</label>
                <select name="computadora" id="computadora" readonly="true" class="form-control">
                    <#--<option value="-1">Seleccionar Computadora</option>-->
                    <#if parte.computadora??>
                        <option value="${parte.computadora.id}" selected>${parte.computadora.marca}</option>
                        <#--<#list computadoras as computadora>-->
                            <#--<#if computadora.id == parte.computadora.id>-->
                                <#--<option value="${computadora.id}" selected>${computadora.marca}</option>-->
                            <#--<#else>-->
                                <#--<option value="${computadora.id}">${computadora.marca}</option>-->
                            <#--</#if>-->
                        <#--</#list>-->
                    </#if>
                </select>
            </div>

            <div class="form-group">
                <label for="nombre">Nombre</label>
                <select name="nombre" id="nombre" required title="Nombre Parte" class="form-control">
                    <option value="-1" selected disabled>Selecciona una Parte</option>
                    <option>Bateria</option>
                    <option>CPU</option>
                    <option>Disco Duro</option>
                    <option>GPU</option>
                    <option>Memoria</option>
                    <option>Puerto</option>
                    <option>Teclado</option>

                <#--<#if tipoMateriales??>-->
                    <#--<#list tipoMateriales as t>-->
                        <#--<option value="${t.id}">${t.descripcion}</option>-->
                    <#--</#list>-->
                <#--</#if>-->
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