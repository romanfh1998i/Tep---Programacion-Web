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
                <h1 class="logo__text">PC GARAGE</h1>
                <div class="text-center mt-lg-5">
                    <img src="/img/user.jpg" class="img-circle" alt="user" width="50%" height="50%">
                </div>
            </div>
            <div class="thumbnail__content text-center">
            </div>
            <div class="thumbnail__links">
                <ul class="list-inline m-b-0 text-center">
                </ul>
            </div>
            <div class="signup__overlay"></div>
        </div>
        <div class="container__child signup__form">
            <form action="/login" method="post">
                <div class="form-group">
                    <label for="username">Nombre de usuario</label>
                    <input class="form-control" type="text" name="username" id="username" placeholder="james.bond" required />
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input class="form-control" type="password" name="password" id="password" placeholder="********" required />
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
                    <ul class="list-inline">
                        <li>
                            <a style="text-decoration: none" class="blue-color" href="/usuario/agregar">No registrado?</a>
                        </li>
                        <li>
                            <a  style="text-decoration: none" class="blue-color" href="/usuario/olvidaContrasena">Olvida contrasena?</a>
                        </li>
                    </ul>
                </div>
            </form>
            <div class="row">
                <div class="col-xs-12">
                <#if error??>
                    <p style="color: red">${error}</p>
                </#if>
                <#if success??>
                    <p style="color: green">${success}</p>
                </#if>
                </div>
            </div>
        </div>
    </div>

<#--<#include "footer.ftl">-->

<#include "scripts.ftl">
</body>

</html>