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
                <h3 class="heading--primary">Olvidas Tu Contraseña? Estas cerca de cambiarla!</h3>
            </div>
            <div class="thumbnail__links">
                <ul class="list-inline m-b-0 text-center">
                </ul>
            </div>
            <div class="signup__overlay"></div>
        </div>
        <div class="container__child signup__form">
            <h5>Olvida Contraseña</h5>
            <#if success??>
            <div class="form-group">
                <span><small>${success}</small></span>
            </div>
            <#else>
                <span><small>Entre su correo y te mandamos un enlace para cambiar tu contraseña.</small></span>
                <form action="/usuario/olvidaContrasena" method="post">

                    <div class="form-group">
                        <label for="email">Correo</label>
                        <input class="form-control" type="email" name="email" id="email" placeholder="jdoe@example.com" required />
                    </div>
                    <div class="m-t-lg">
                        <ul class="list-inline">
                            <li>
                                <button class="btn btn-sm btn--form--submit" type="submit"><i class="fa fa-paper-plane"></i> Entrar</button>
                            </li>
                        </ul>
                    </div>
                </form>
            </#if>
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