
   
<!DOCTYPE html>
<html lang="en"  xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

  <head>
      <title>Ver Tipo GPU</title>
      <#include "../header.ftl">
</head>

<body>

    <!-- Navigation -->
    <#include "../nav.ftl">

    <!-- Page Content -->
    <div class="container">
        <div class="row">
            <h1 class="my-4">Información de <small>Tipo GPU</small></h1>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th style="width: 10%">#</th>
                    <th style="width: 35%" class="text-center">Compañia</th>
                    <th style="width: 35%" class="text-center">Descripción</th>
                    <th style="width: 20%" colspan="2"></th>
                </tr>
                </thead>
                <tbody>
                    <#if tipoGpu??>
                        <#list tipoGpu as t>
                        <tr>
                            <td>${t?index+1}</td>
                            <td class="text-center">${t.compania.descripcion}</td>
                            <td class="text-center">${t.descripcion}</td>
                            <td><a href="/tipoGpu/actualizar/${t.id}"><i style = "font-size: 24px; color: darkorange" class="fa fa-edit"></i></a></td>
                            <!--                    <td><i style = "font-size: 24px; color: red" class="fa fa-trash"></i></td>-->
                        </tr>
                    </#list>
                    </#if>
                </tbody>
            </table>
            <div class="row">
                <div class="col-md-2 mb-3">
                    <a href="/tipoGpu/agregar" class="btn btn-info">Agregar otro</a>
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