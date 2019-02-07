
   
<!DOCTYPE html>
<html lang="en"  xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

  <head>
      <title>Ver GPU</title>
      <#include "../header.ftl">
</head>

<body>

    <!-- Navigation -->
    <#include "../nav.ftl">

    <!-- Page Content -->
    <div class="container">
        <div class="row">
            <h1 class="my-4">Información del Gpu</h1>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th style="width: 10%">#</th>
                    <th style="width: 70%" class="text-center">Nombre</th>
                    <th style="width: 70%" class="text-center">Capacidad</th>
                    <th style="width: 70%" class="text-center">Tipo Capacidad</th>
                    <th style="width: 70%" class="text-center">Precio</th>
                    <th style="width: 70%" class="text-center">Tipo GPU</th>
                    <th style="width: 20%" colspan="2"></th>
                </tr>
                </thead>
                <tbody>
                    <#if gpu??>
                        <#list gpu as g>
                        <tr>
                            <td>${g?index+1}</td>
                            <td class="text-center">${g.nombre}</td>
                            <td class="text-center">${g.capacidad}</td>
                            <td class="text-center">${g.tipoCapacidad.nombre}</td>
                            <td class="text-center">${g.precio}</td>
                            <td class="text-center">${g.tipoGpu.nombre}</td>
                            <td><a href="/gpu/actualizar/${g.id}"><i style = "font-size: 24px; color: darkorange" class="fa fa-edit"></i></a></td>
                        </tr>
                    </#list>
                    </#if>
                </tbody>
            </table>
            <div class="row">
                <div class="col-md-2 mb-3">
                    <a href="/gpu/agregar" class="btn btn-info">Agregar otro</a>
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