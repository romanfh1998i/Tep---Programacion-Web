
   
<!DOCTYPE html>
<html lang="en"  xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

  <head>
      <title>Ver memoria</title>
      <#include "../header.ftl">
</head>

<body>

    <!-- Navigation -->
    <#include "../nav.ftl">

    <!-- Page Content -->
    <div class="container">
        <div class="row">
            <h1 class="my-4">Información de la memoria</h1>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th style="width: 10%">#</th>
                    <th style="width: 70%" class="text-center">Tipo memoria</th>
                    <th style="width: 70%" class="text-center">Capacidad</th>
                    <th style="width: 70%" class="text-center">Marca</th>
                    <th style="width: 70%" class="text-center">Precio</th>
                    <th style="width: 70%" class="text-center">Tipo Capacidad</th>
                    <th style="width: 70%" class="text-center">Parte</th>
                    <th style="width: 20%" colspan="2"></th>
                </tr>
                </thead>
                <tbody>
                    <#if memoria??>
                        <#list memoria as m>
                        <tr>
                            <td>${t?index+1}</td>
                            <td class="text-center">${m.tipoMemoria.nombre}</td>
                            <td class="text-center">${m.capacidad}</td>
                            <td class="text-center">${m.marca}</td>
                            <td class="text-center">${m.precio}</td>
                            <td class="text-center">${m.tipoCapacidad.nombre}</td>
                            <td class="text-center">${m.parte.nombre}</td>
                            <td><a href="/memoria/actualizar/${m.id}"><i style = "font-size: 24px; color: darkorange" class="fa fa-edit"></i></a></td>
                        </tr>
                    </#list>
                    </#if>
                </tbody>
            </table>
            <div class="row">
                <div class="col-md-2 mb-3">
                    <a href="/memoria/agregar" class="btn btn-info">Agregar otro</a>
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