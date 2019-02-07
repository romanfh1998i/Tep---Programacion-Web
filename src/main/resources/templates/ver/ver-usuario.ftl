
   
<!DOCTYPE html>
<html lang="en"  xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

  <head>
      <title>Ver Usuario</title>
      <#include "../header.ftl">
</head>

<body>

    <!-- Navigation -->
    <#include "../nav.ftl">

    <!-- Page Content -->
    <div class="container">
        <div class="row">
            <h1 class="my-4">Informaciones de los usuarios</h1>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th style="width: 10%">#</th>
                    <th style="width: 25%" class="text-center">Nombre</th>
                    <th style="width: 15%" class="text-center">Nombre de usuario</th>
                    <th style="width: 30%" class="text-center">Roles</th>
                    <th style="width: 20%" colspan="2"></th>
                </tr>
                </thead>
                <tbody>
                    <#if usuarios??>
                        <#list usuarios as u>
                        <tr>
                            <td>${u?index+1}</td>
                            <td class="text-center">${u.name}</td>
                            <td class="text-center">${u.username}</td>
                            <td><#if u.roles??>
                                <#list u.roles as rol>
                                   ${rol.rol}&nbsp;
                                </#list>
                            </#if></td>
                            <td><a href="/usuario/eliminar/${u.id}/${usuario.id}" title="eliminar"><i style = "font-size: 24px; color: red" class="fa fa-trash"></i></a></td>
                            <td><a href="/usuario/roles/${u.id}" title="editar usuario roles"><i style = "font-size: 24px; color: orange" class="fa fa-user"></i></a></td>
                        </tr>
                    </#list>
                    </#if>
                </tbody>
            </table>
            <div class="row">
                <div class="col-md-2 mb-3">
                    <a href="/usuario/agregar" class="btn btn-info">Agregar otro</a>
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