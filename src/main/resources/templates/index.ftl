<!DOCTYPE html>
<html lang="en">

<head>
<#include "header.ftl">
    <title>PC-Garage</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<#include "nav.ftl">

    <header>
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel" >
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <!-- Slide One - Set the background image for this slide in the line below -->
                <div class="carousel-item active" style="background-image: url('/img/img1.jpg')">
                    <div class="carousel-caption d-none d-md-block">
                        <h3>#1</h3>
                        <p>Valora tu computadora.</p>
                    </div>
                </div>
                <!-- Slide Two - Set the background image for this slide in the line below -->
                <div class="carousel-item" style="background-image: url('/img/img2.jpg')">
                    <div class="carousel-caption d-none d-md-block">
                        <h3>#2</h3>
                        <p>Sacale provecho de tu computadora.</p>
                    </div>
                </div>
                <!-- Slide Three - Set the background image for this slide in the line below -->
                <div class="carousel-item" style="background-image: url('/img/img3.png')">
                    <div class="carousel-caption d-none d-md-block">
                        <h3>#3</h3>
                        <p>Conozca tu computadora.</p>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </header>

    <!-- Page Content -->
    <div class="container">

        <a class="text-center" href="/computadora/agregar">
            <svg class="nav-link" viewBox="0 0 500 200">
                <symbol id="s-text">
                    <text text-anchor="middle" x="50%" y="80%">Valora! </text>
                </symbol>

                <g class = "g-ants">
                    <use xlink:href="#s-text" class="text-copy"></use>
                    <use xlink:href="#s-text" class="text-copy"></use>
                    <use xlink:href="#s-text" class="text-copy"></use>
                    <use xlink:href="#s-text" class="text-copy"></use>
                    <use xlink:href="#s-text" class="text-copy"></use>
                </g>
            </svg>
        </a>
    </div>
    <!-- /.container -->

    <!-- Footer -->
<#include "footer.ftl">

    <!-- Bootstrap core JavaScript -->
<#include "scripts.ftl">

</body>

</html>
