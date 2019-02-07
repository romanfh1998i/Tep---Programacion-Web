<!DOCTYPE html>
<html lang="en"
      xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>

  <title>Actualizar CPU</title>
<#include "../header.ftl">
</head>

<body>

  <!-- Navigation -->
  <#include "../nav.ftl">

  <!-- Page Content -->
  <div class="container pb-3">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">Actualizar <small>CPU</small></h1>

    <!-- Content Row -->
    <div class="row">
      <div class="col-lg-12 mb-12">
        <form  action="/cpu/actualizar" method="post" th:object="${cpu}">
            <input type="hidden" name="id" id="id" value="${cpu.id}">
            <input type="hidden" name="parte" id="parte" value="${parteId}">

            <div class="form-group">
                <label for="precio">Precio</label>
                <input type="number" name="precio" id="precio" min="0" class="form-control" value="${cpu.precio}">
            </div>

            <div class="form-group">
                <label for="consumo_energia">Consumo Energía</label>
                <input type="number" name="consumo_energia" id="consumo_energia" min="0" value="${cpu.consumo_energia}" class="form-control">
            </div>

            <div class="form-group">
                <label for="tipoConsumoEnergia">Tipo Consumo Energía</label>
                <select name="tipoConsumoEnergia" id="tipoConsumoEnergia" class="form-control">
                    <option value="-1">Seleccionar Tipo Consumo Energía</option>
                    <#if tipoConsumoEnergias??>
                        <#list tipoConsumoEnergias as t>
                            <#if t.id == cpu.tipoConsumoEnergia.id>
                                <option value="${t.id}" selected>${t.descripcion}</option>
                            <#else>
                                <option value="${t.id}">${t.descripcion}</option>
                            </#if>
                         </#list>
                    </#if>
                </select>
            </div>
            <div class="form-group">
                <label for="tipoRefrescante">Tipo Refrescante</label>
                <select name="tipoRefrescante" id="tipoRefrescante" class="form-control">
                    <option value="-1">Seleccionar Tipo Refrescante</option>
                    <#if tipoRefrescantes??>
                        <#list tipoRefrescantes as t>
                            <#if t.id == cpu.tipoRefrescante.id>
                                <option value="${t.id}" selected>${t.descripcion}</option>
                            <#else>
                                <option value="${t.id}">${t.descripcion}</option>
                            </#if>
                        </#list>
                    </#if>
                </select>
            </div>

            <div class="form-group">
                <label for="tipoRendimiento">Tipo Rendimiento</label>
                <select name="tipoRendimiento" id="tipoRendimiento" class="form-control">
                    <option value="-1">Seleccionar Tipo Rendimiento</option>
                    <#if tipoRendimientos??>
                        <#list tipoRendimientos as t>
                            <#if t.id == cpu.tipoRendimiento.id>
                                <option value="${t.id}" selected>${t.descripcion}</option>
                            <#else>
                                <option value="${t.id}">${t.descripcion}</option>
                            </#if>
                        </#list>
                    </#if>
                </select>
            </div>
            <div class="form-group">
                <label for="tipoCPU">Tipo CPU</label>
                <select name="tipoCPU" id="tipoCPU" class="form-control">
                    <option value="-1">Seleccionar Tipo CPU</option>
                    <#if tipoCpus??>
                        <#list tipoCpus as t>
                            <#if t.id == cpu.tipoCPU.id>
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