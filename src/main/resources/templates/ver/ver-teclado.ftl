
   
<!DOCTYPE html>
<html lang="en"  xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

  <head>
      <title>Ver Teclado</title>
      <#include "../header.ftl">
</head>

<body>

    <!-- Navigation -->
    <#include "../nav.ftl">

    <!-- Page Content -->
    <div class="container">
        <div class="row">
            <h1 class="my-4">Información del teclado</h1>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th style="width: 10%">#</th>
                    <th style="width: 70%" class="text-center">Parte</th>
                    <th style="width: 70%" class="text-center">Tipo teclado</th>
                    <th style="width: 20%" colspan="2"></th>
                </tr>
                </thead>
                <tbody>
                    <#if teclado??>
                        <#list teclado as t>
                        <tr>
                            <td>${t?index+1}</td>
                            <td class="text-center">${t.parte.nombre}</td>
                            <td class="text-center">${t.tipoTeclado.nombre}</td>
                            <td><a href="/teclado/actualizar/${t.id}"><i style = "font-size: 24px; color: darkorange" class="fa fa-edit"></i></a></td>
                        </tr>
                    </#list>
                    </#if>
                </tbody>
            </table>
            <div class="row">
                <div class="col-md-2 mb-3">
                    <a href="/teclado/agregar" class="btn btn-info">Agregar otro</a>
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