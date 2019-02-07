<!DOCTYPE html>
<html lang="en"
      xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>
  <title>Actualizar Usuario ROles </title>
  <#include "../header.ftl">
</head>

<body>
  <!-- Navigation -->
  <#include "../nav.ftl">
  <!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
      <h1 class="mt-4 mb-3">Actualizar <small>Roles de Usuario</small>
    </h1>


      <!-- Content Row -->
      <div class="row">
          <div class="col-lg-12 mb-12">
              <form  action="/usuario/roles/actualizar" method="post" th:object="${user}">
                  <input type="hidden" name="id" id="id" value="${user.id}">

                  <div class="form-group">
                      <label for="usuario">Usuario</label>
                      <input type="text" class="form-control" value="${user.name}" readonly>
                  </div>
                  <div class="row">
                      <div class="form-group">
                          <label for="roles">Roles</label>

                  <#if (user.roles?size > 1) >
                      <#list user.roles as rol>
                          <div class="form-check">
                              <#if rol.rol=="ROLE_ADMIN">
                                  <input type="checkbox" name="admin" class="form-check-input" id="admin" checked>
                                  <label class="form-check-label" for="admin">ADMIN</label>
                              <#else>
                                  <input type="checkbox" disabled name="user" class="form-check-input" id="user" checked>
                                  <label class="form-check-label" for="user">USER</label>
                              </#if>
                          </div>
                      </#list>
                  <#else>
                      <#if user.roles[0]=="ROLE_ADMIN">
                          <div class="form-check">
                            <input type="checkbox" name="admin" class="form-check-input" id="admin" checked>
                            <label class="form-check-label" for="admin">ADMIN</label>
                          </div>

                          <div class="form-check">
                            <input type="checkbox" name="user" disabled class="form-check-input" id="user">
                            <label class="form-check-label" for="user">USER</label>
                          </div>
                      <#else>
                          <div class="form-check">
                              <input type="checkbox" name="admin" class="form-check-input" id="admin">
                              <label class="form-check-label" for="admin">ADMIN</label>
                          </div>

                          <div class="form-check">
                              <input type="checkbox" name="user"  disabled class="form-check-input" id="user" checked>
                              <label class="form-check-label" for="user">USER</label>
                          </div>
                      </#if>
                  </#if>
                      </div>

                  </div>

                  <div class="row">
                      <div class="col-md-9"></div>
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