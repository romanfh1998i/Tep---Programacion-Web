<!DOCTYPE html>
<html lang="en"
      xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

<head>
    <title>Abrir Sesion</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Roman Franco Ho">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,300'>
    <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto:400,700,300'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>

    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/modern-business.css">
<#include "header.ftl">
</head>

<body>
<#include "nav.ftl">

    <div class="signup__container">
        <div class="container__child signup__thumbnail">
            <div class="thumbnail__logo">
                <svg class="logo__shape" width="25px" viewBox="0 0 634 479" xmlns="http://www.w3.org/2000/svg">

        </svg>
                <h1 class="logo__text">PC GARAGE</h1>
            </div>
            <div class="thumbnail__content text-center">
                <h3 class="heading--primary">Hola, Bienvenido.</h3>
            </div>
            <div class="thumbnail__links">
                <ul class="list-inline m-b-0 text-center">
                </ul>
            </div>
            <div class="signup__overlay"></div>
        </div>
        <div class="container__child signup__form">
            <form action="/usuario/agregar" method="post" th:object="${user}">
                <div class="form-group">
                    <input class="form-control" type="text" name="username" minlength="2" maxlength="100" id="username" placeholder="Nombre de usuario..." required />
                </div>
                <div class="form-group">
                    <input class="form-control" type="text" name="name" minlength="6" maxlength="30" id="name" placeholder="Nombre..." required />
                </div>
                <div class="form-group">
                    <input class="form-control" type="email" name="email" id="email" placeholder="Correo..." required />
                </div>
                <div class="form-group">
                    <input class="form-control" type="password" minlength="6" maxlength="30" name="password" id="password" placeholder="Contrasena..." required />
                </div>
                <div class="form-group">
                    <input class="form-control" type="password" name="confirmPassword" id="confirmPassword" placeholder="Confirmar Contraseña..." required />
                </div>
                <div class="m-t-lg">
                    <ul class="list-inline">
                        <li>
                            <button class="btn btn-sm btn--form--cancel" type="cancel"><i class="fa fa-times"></i> Cancelar</button>
                        </li>
                        <li>
                            <button class="btn btn-sm btn--form--submit" type="submit"><i class="fa fa-paper-plane"></i> Entrar</button>
                        </li>
                    </ul>
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
<#--<#include "footer.ftl">-->

<#include "scripts.ftl">
</body>

</html>