<!DOCTYPE html>
<html lang="en">

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
                <h3 class="heading--primary">Sustituye tu contrasena ahora.</h3>
            </div>
            <div class="thumbnail__links">
                <ul class="list-inline m-b-0 text-center">
                </ul>
            </div>
            <div class="signup__overlay"></div>
        </div>
        <div class="container__child signup__form">
        <h5>Cambia contraseña</h5>
            <#if error??>
                <label></label>
                    <span><small style="color:red;">${error}</small></span>
                </div>
            <#else>
                <form action="/usuario/reset" method="post">
                    <input type="hidden" name="token" value="${resetToken}">
                    <div class="form-group">
                        <label for="password">Contraseña</label>
                        <input class="form-control" type="password" name="password" id="password" placeholder="**********" required />
                    </div>
                    <div class="form-group">
                        <label for="password">Confirma contraseña</label>
                        <input class="form-control" type="password" name="confirmPassword" id="confirmPassword" placeholder="**********" required />
                    </div>
                    <div class="m-t-lg">
                        <ul class="list-inline">
                            <li>
                                <button class="btn btn-sm btn--form--cancel" type="reset"><i class="fa fa-times"></i> Cancelar</button>
                            </li>
                            <li>
                                <button class="btn btn-sm btn--form--submit" type="submit"><i class="fa fa-paper-plane"></i> Entrar</button>
                            </li>
                        </ul>
                    </div>
                </form>
            </#if>
        </div>
    </div>
<#--<#include "footer.ftl">-->

<#include "scripts.ftl">
</body>

</html>