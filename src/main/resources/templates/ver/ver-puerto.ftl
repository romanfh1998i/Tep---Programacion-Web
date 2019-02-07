
   
<!DOCTYPE html>
<html lang="en"  xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

  <head>
      <title>Ver Puerto</title>
      <#include "../header.ftl">
</head>

<body>

    <!-- Navigation -->
    <#include "../nav.ftl">

    <!-- Page Content -->
    <div class="container">
        <div class="row">
            <h1 class="my-4">Información del puerto</h1>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th style="width: 10%">#</th>
                    <th style="width: 70%" class="text-center">Parte</th>
                    <th style="width: 70%" class="text-center">Cantidad</th>
                    <th style="width: 70%" class="text-center">Version</th>
                    <th style="width: 70%" class="text-center">Tipo Puerto</th>
                    <th style="width: 20%" colspan="2"></th>
                </tr>
                </thead>
                <tbody>
                    <#if puerto??>
                        <#list puerto as p>
                        <tr>
                            <td>${p?index+1}</td>
                            <td class="text-center">${p.parte.nombre}</td>
                            <td class="text-center">${p.cantidad}</td>
                            <td class="text-center">${p.version}</td>
                            <td class="text-center">${p.tipoPuerto.nombre}</td>
                            <td><a href="/puerto/actualizar/${p.id}"><i style = "font-size: 24px; color: darkorange" class="fa fa-edit"></i></a></td>
                        </tr>
                    </#list>
                    </#if>
                </tbody>
            </table>
            <div class="row">
                <div class="col-md-2 mb-3">
                    <a href="/puerto/agregar" class="btn btn-info">Agregar otro</a>
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