
   
<!DOCTYPE html>
<html lang="en"  xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

  <head>
      <title>Ver Parte</title>
      <#include "../header.ftl">
</head>

<body>

    <!-- Navigation -->
    <#include "../nav.ftl">
    <!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <h1 class="my-4">Información de la parte</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <#if partes??>
                    <div class="mb-4 accordion md-accordion" id="accordion" role="tablist" aria-multiselectable="true">
                        <#list partes as parte>
                            <#if parte.nombre == "Bateria" >
                                <div class="card z-depth-0 bordered">
                                    <div class="card-header" role="tab" id="heading${parte?index+1}">
                                        <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                           href="#collapse${parte?index+1}" aria-expanded="true"
                                           aria-controls="collapse${parte?index+1}">
                                            <h5 class="mb-0">
                                                ${parte.nombre}<i class="fa fa-angle-down rotate-icon"></i>
                                            </h5>
                                        </a>
                                    </div>
                                    <div id="collapse${parte?index+1}" class="collapse show" role="tabpanel" aria-labelledby="heading${parte?index+1}">
                                        <div class="card-body">
                                            <h1 class="my-4">Información de Bateria</h1>
                                            <#if baterias??>
                                                <table class="table table-hover">
                                                    <thead>
                                                        <tr>
                                                            <th style="width: 10%">#</th>
                                                            <th style="width: 30%" class="text-center">Precio</th>
                                                            <th style="width: 20%" class="text-center">Cantidad Celulas</th>
                                                            <th style="width: 20%" class="text-center">Cantidad Voltaje</th>
                                                            <th style="width: 10%" class="text-center"  colspan="2">
                                                                <a href="/bateria/crear/${parte.id}" class="btn-floating btn-sm btn-dark-green" style="color: white" title="Agregar otro">
                                                                    <i class="fa fa-plus"></i>
                                                                </a>
                                                            </th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <#list baterias as bateria>
                                                            <tr>
                                                                <td>${bateria?index+1}</td>
                                                                <td class="text-center">${bateria.precio}</td>
                                                                <td class="text-center">${bateria.cantidadCelulas}</td>
                                                                <td class="text-center">${bateria.cantidadVoltaje}</td>
                                                                <td><a href="/bateria/actualizar/${parte.id}/${bateria.id}"><i style = "font-size: 24px; color: darkorange" class="fa fa-edit"></i></a></td>
                                                                <td><a href="/bateria/eliminar/${bateria.id}/${computadoraId}"><i style = "font-size: 24px; color: red" class="fa fa-trash"></i></a></td>
                                                            </tr>
                                                        </#list>
                                                    </tbody>
                                                </table>
                                            <#else>
                                                <h6>No Hay bateria agrega una...</h6>
                                            </#if>
                                            <#--<div class="row">-->
                                                <#--<div class="col-md-2 mb-3">-->
                                                    <#--<a href="/bateria/crear/${parte.id}" class="btn btn-info">Agregar otro</a>-->
                                                <#--</div>-->
                                            <#--</div>-->
                                        </div>
                                    </div>

                                </div>
                            <#elseif parte.nombre == "CPU" >
                                <div class="card z-depth-0 bordered">
                                    <div class="card-header" role="tab" id="heading${parte?index+1}">
                                        <a class="collapsed"  data-toggle="collapse" data-parent="#accordion"
                                           href="#collapse${parte?index+1}" aria-expanded="false"
                                           aria-controls="collapse${parte?index+1}">
                                            <h5 class="mb-0">
                                                ${parte.nombre}<i class="fa fa-angle-down rotate-icon"></i>
                                            </h5>
                                        </a>
                                    </div>
                                    <div id="collapse${parte?index+1}" class="collapse" role="tabpanel"
                                         aria-labelledby="heading${parte?index+1}">
                                        <div class="card-body">
                                            <h1 class="my-4">Información del CPU</h1>
                                            <#if cpus??>
                                                <table class="table table-hover">
                                                    <thead>
                                                    <tr>
                                                        <th style="width: 10%">#</th>
                                                        <th style="width: 10%" class="text-center">Precio</th>
                                                        <th style="width: 10%" class="text-center">Consumo Energia</th>
                                                        <th style="width: 10%" class="text-center">Tipo Refrescante</th>
                                                        <th style="width: 10%" class="text-center">Tipo Rendimiento</th>
                                                        <th style="width: 10%" class="text-center">Tipo CPU</th>
                                                        <th style="width: 10%;" class="text-center" colspan="2">
                                                            <a href="/cpu/crear/${parte.id}" class="btn-floating btn-sm btn-dark-green" style="color: white" title="Agregar otro">
                                                                <i class="fa fa-plus"></i>
                                                            </a>
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                        <#list cpus as c>
                                                        <tr>
                                                            <td>${c?index+1}</td>
                                                            <td class="text-center">${c.precio}</td>
                                                            <td class="text-center">${c.consumo_energia}
                                                                (${c.tipoConsumoEnergia.descripcion})
                                                            </td>
                                                            <td class="text-center">${c.tipoRefrescante.descripcion}</td>
                                                            <td class="text-center">${c.tipoRendimiento.descripcion}</td>
                                                            <td class="text-center">${c.tipoCPU.descripcion}</td>
                                                            <td><a href="/cpu/actualizar/${parte.id}/${c.id}"><i
                                                                    style="font-size: 24px; color: darkorange"
                                                                    class="fa fa-edit"></i></a></td>
                                                            <td><a href="/cpu/eliminar/${c.id}/${computadoraId}"><i
                                                                    style="font-size: 24px; color: red"
                                                                    class="fa fa-trash"></i></a></td>
                                                        </tr>
                                                        </#list>
                                                    </tbody>
                                                </table>
                                            <#else>
                                                <h6>No Hay CPU agrega una...</h6>
                                            </#if>
                                            <#--<div class="row">-->
                                                <#--<div class="col-md-2 mb-3">-->
                                                    <#--<a href="/cpu/crear/${parte.id}" class="btn btn-info">Agregar otro</a>-->
                                                <#--</div>-->
                                            <#--</div>-->
                                        </div>
                                    </div>
                                </div>
                            <#elseif parte.nombre == "Disco Duro" >
                                <div class="card z-depth-0 bordered">
                                    <div class="card-header" role="tab" id="heading${parte?index+1}">
                                        <a class="collapsed"  data-toggle="collapse" data-parent="#accordion"
                                           href="#collapse${parte?index+1}" aria-expanded="false"
                                           aria-controls="collapse${parte?index+1}">
                                            <h5 class="mb-0">
                                                ${parte.nombre}<i class="fa fa-angle-down rotate-icon"></i>
                                            </h5>
                                        </a>
                                    </div>
                                    <div id="collapse${parte?index+1}" class="collapse" role="tabpanel" aria-labelledby="heading${parte?index+1}">
                                        <div class="card-body">
                                            <h1 class="my-4">Información de Disco Duro</h1>
                                            <#if discoDuros??>
                                                <table class="table table-hover">
                                                    <thead>
                                                    <tr>
                                                        <th style="width: 10%">#</th>
                                                        <th style="width: 15%" class="text-center">Capacidad</th>
                                                        <th style="width: 10%" class="text-center">Durabilidad</th>
                                                        <th style="width: 10%" class="text-center">Velocidad</th>
                                                        <th style="width: 10%" class="text-center">Precio</th>
                                                        <th style="width: 15%" class="text-center">Tipo Disco Duro</th>
                                                        <th style="width: 10%" class="text-center" colspan="2">
                                                            <a href="/discoDuro/crear/${parte.id}" class="btn-floating btn-sm btn-dark-green" style="color: white" title="Agregar otro">
                                                                <i class="fa fa-plus"></i>
                                                            </a>
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                        <#list discoDuros as disco>
                                                        <tr>
                                                            <td>${disco?index+1}</td>
                                                            <td class="text-center">${disco.capacidad}(${disco.tipoCapacidad.descripcion})</td>
                                                            <td class="text-center">${disco.durabilidad}</td>
                                                            <td class="text-center">${disco.velocidad}</td>
                                                            <td class="text-center">${disco.precio}</td>
                                                            <td class="text-center">${disco.tipoDiscoDuro.descripcion}</td>
                                                            <td><a href="/discoDuro/actualizar/${parte.id}/${disco.id}"><i style = "font-size: 24px; color: darkorange" class="fa fa-edit"></i></a></td>
                                                            <td><a href="/discoDuro/eliminar/${disco.id}/${computadoraId}"><i style = "font-size: 24px; color: red" class="fa fa-trash"></i></a></td>
                                                        </tr>
                                                        </#list>
                                                    </tbody>
                                                </table>
                                            <#else>
                                                <h6>No Hay disco duro agrega uno...</h6>
                                            </#if>
                                            <#--<div class="row">-->
                                                <#--<div class="col-md-2 mb-3">-->
                                                    <#--<a href="/discoDuro/crear/${parte.id}" class="btn btn-info">Agregar otro</a>-->
                                                <#--</div>-->
                                            <#--</div>-->
                                        </div>
                                    </div>
                                </div>
                            <#elseif parte.nombre == "GPU">
                                <div class="card z-depth-0 bordered">
                                    <div class="card-header" role="tab" id="heading${parte?index+1}">
                                        <a class="collapsed"  data-toggle="collapse" data-parent="#accordion"
                                           href="#collapse${parte?index+1}" aria-expanded="false"
                                           aria-controls="collapse${parte?index+1}">
                                            <h5 class="mb-0">
                                                 ${parte.nombre}<i class="fa fa-angle-down rotate-icon"></i>
                                            </h5>
                                        </a>
                                    </div>
                                    <div id="collapse${parte?index+1}" class="collapse" role="tabpanel"
                                         aria-labelledby="heading${parte?index+1}">
                                        <div class="card-body">
                                            <h1 class="my-4">Información del GPU</h1>
                                            <#if gpus??>
                                                <table class="table table-hover">
                                                    <thead>
                                                    <tr>
                                                        <th style="width: 10%">#</th>
                                                        <th style="width: 20%" class="text-center">Nombre</th>
                                                        <th style="width: 10%" class="text-center">Capacidad</th>
                                                        <th style="width: 10%" class="text-center">Precio</th>
                                                        <th style="width: 10%" class="text-center">Tipo GPU</th>
                                                        <th style="width: 10%" class="text-center" colspan="2">
                                                            <a href="/gpu/crear/${parte.id}" class="btn-floating btn-sm btn-dark-green" style="color: white" title="Agregar otro">
                                                                <i class="fa fa-plus"></i>
                                                            </a>
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                        <#list gpus as g>
                                                        <tr>
                                                            <td>${g?index+1}</td>
                                                            <td class="text-center">${g.nombre}</td>
                                                            <td class="text-center">${g.capacidad}
                                                                (${g.tipoCapacidad.descripcion})
                                                            </td>
                                                            <td class="text-center">${g.precio}</td>
                                                            <td class="text-center">${g.tipoGPU.descripcion}</td>
                                                            <td><a href="/gpu/actualizar/${parte.id}/${g.id}"><i
                                                                    style="font-size: 24px; color: darkorange"
                                                                    class="fa fa-edit"></i></a></td>
                                                            <td><a href="gpu/eliminar/${g.id}/${computadoraId}"><i
                                                                    style="font-size: 24px; color: red"
                                                                    class="fa fa-trash"></i></a></td>
                                                        </tr>
                                                        </#list>
                                                    </tbody>
                                                </table>
                                            <#else>
                                                <h6>No Hay GPU agrega una...</h6>
                                            </#if>
                                            <#--<div class="row">-->
                                                <#--<div class="col-md-2 mb-3">-->
                                                    <#--<a href="/gpu/crear/${parte.id}" class="btn btn-info">Agregar otro</a>-->
                                                <#--</div>-->
                                            <#--</div>-->
                                        </div>
                                    </div>
                                </div>
                            <#elseif parte.nombre == "Memoria" >
                                <div class="card z-depth-0 bordered" >
                                    <div class="card-header" role="tab" id="heading${parte?index+1}">
                                        <a class="collapsed"  data-toggle="collapse" data-parent="#accordion"
                                           href="#collapse${parte?index+1}" aria-expanded="false"
                                           aria-controls="collapse${parte?index+1}">
                                            <h5 class="mb-0">
                                                ${parte.nombre}<i class="fa fa-angle-down rotate-icon"></i>
                                            </h5>
                                        </a>
                                    </div>
                                    <div id="collapse${parte?index+1}" class="collapse" role="tabpanel" aria-labelledby="heading${parte?index+1}">
                                        <div class="card-body">
                                            <h1 class="my-4">Información de Memoria</h1>
                                            <#if memorias??>
                                                <table class="table table-hover">
                                                    <thead>
                                                    <tr>
                                                        <th style="width: 10%">#</th>
                                                        <th style="width: 20%" class="text-center">Marca</th>
                                                        <th style="width: 15%" class="text-center">Tipo Memoria</th>
                                                        <th style="width: 10%" class="text-center">Capacidad</th>
                                                        <th style="width: 10%" class="text-center">Precio</th>
                                                        <th style="width: 10%" class="text-center" colspan="2">
                                                            <a href="/memoria/crear/${parte.id}" class="btn-floating btn-sm btn-dark-green" style="color: white" title="Agregar otro">
                                                                <i class="fa fa-plus"></i></a>
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                        <#list memorias as memoria>
                                                        <tr>
                                                            <td>${memoria?index+1}</td>
                                                            <td class="text-center">${memoria.marca}</td>
                                                            <td class="text-center">${memoria.tipoMemoria.descripcion}</td>
                                                            <td class="text-center">${memoria.capacidad}(${memoria.tipoCapacidad.descripcion})</td>
                                                            <td class="text-center">${memoria.precio}</td>
                                                            <td><a href="/memoria/actualizar/${parte.id}/${memoria.id}">
                                                                <i style = "font-size: 24px; color: darkorange" class="fa fa-edit"></i></a>
                                                            </td>
                                                            <td><a href="/memoria/eliminar/${memoria.id}/${computadoraId}">
                                                                <i style = "font-size: 24px; color: red" class="fa fa-trash"></i></a>
                                                            </td>
                                                        </tr>
                                                        </#list>
                                                    </tbody>
                                                </table>
                                            <#else>
                                                <h6>No Hay disco duro agrega uno...</h6>
                                            </#if>
                                            <#--<div class="row">-->
                                                <#--<div class="col-md-2 mb-3">-->
                                                    <#--<a href="/memoria/crear/${parte.id}" class="btn btn-info">Agregar otro</a>-->
                                                <#--</div>-->
                                            <#--</div>-->
                                        </div>
                                    </div>
                                </div>
                            <#elseif parte.nombre == "Puerto" >
                                <div class="card z-depth-0 bordered">
                                    <div class="card-header" role="tab" id="heading${parte?index+1}">
                                        <a class="collapsed"  data-toggle="collapse" data-parent="#accordion"
                                           href="#collapse${parte?index+1}" aria-expanded="false"
                                           aria-controls="collapse${parte?index+1}">
                                            <h5 class="mb-0">
                                                ${parte.nombre}<i class="fa fa-angle-down rotate-icon"></i>
                                            </h5>
                                        </a>
                                    </div>
                                    <div id="collapse${parte?index+1}" class="collapse" role="tabpanel"
                                         aria-labelledby="heading${parte?index+1}">
                                        <div class="card-body">
                                            <h1 class="my-4">Información de los puertos</h1>
                                            <#if puertos??>
                                                <table class="table table-hover">
                                                    <thead>
                                                    <tr>
                                                        <th style="width: 10%">#</th>
                                                        <th style="width: 20%" class="text-center">Cantidad</th>
                                                        <th style="width: 15%" class="text-center">Version</th>
                                                        <th style="width: 15%" class="text-center">Tipo Puerto</th>
                                                        <th style="width: 10%" class="text-center" colspan="2">
                                                            <a href="/puerto/crear/${parte.id}" class="btn-floating btn-sm btn-dark-green" style="color: white" title="Agregar otro">
                                                                <i class="fa fa-plus"></i>
                                                            </a>
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                        <#list puertos as p>
                                                        <tr>
                                                            <td>${p?index+1}</td>
                                                            <td class="text-center">${p.cantidad}</td>
                                                            <td class="text-center">${p.version}</td>
                                                            <td class="text-center">${p.tipoPuerto.descripcion}</td>
                                                            <td><a href="/puerto/actualizar/${parte.id}/${p.id}"><i
                                                                    style="font-size: 24px; color: darkorange"
                                                                    class="fa fa-edit"></i></a></td>
                                                            <td><a href="/puerto/eliminar/${p.id}/${computadoraId}"><i
                                                                    style="font-size: 24px; color: red"
                                                                    class="fa fa-trash"></i></a></td>
                                                        </tr>
                                                        </#list>
                                                    </tbody>
                                                </table>
                                            <#else>
                                                <h6>No Hay Puertos agrega uno...</h6>
                                            </#if>
                                            <#--<div class="row">-->
                                                <#--<div class="col-md-2 mb-3">-->
                                                    <#--<a href="/puerto/crear/${parte.id}" class="btn btn-info">Agregar otro</a>-->
                                                <#--</div>-->
                                            <#--</div>-->
                                        </div>
                                    </div>
                                </div>
                            <#elseif parte.nombre == "Teclado" >
                                <div class="card z-depth-0 bordered">
                                    <div class="card-header" role="tab" id="heading${parte?index+1}">
                                        <a class="collapsed"  data-toggle="collapse" data-parent="#accordion"
                                           href="#collapse${parte?index+1}" aria-expanded="false"
                                           aria-controls="collapse${parte?index+1}">
                                            <h5 class="mb-0">
                                                ${parte.nombre}<i class="fa fa-angle-down rotate-icon"></i>
                                            </h5>
                                        </a>
                                    </div>
                                    <div id="collapse${parte?index+1}" class="collapse" role="tabpanel"
                                         aria-labelledby="heading${parte?index+1}">
                                        <div class="card-body">
                                            <h1 class="my-4">Información del Teclado</h1>
                                            <#if teclados??>
                                                <table class="table table-hover">
                                                    <thead>
                                                    <tr>
                                                        <th style="width: 10%">#</th>
                                                        <th style="width: 50%" class="text-center">Tipo Teclado</th>
                                                        <th style="width: 10%" class="text-center" colspan="2">
                                                            <a href="/teclado/crear/${parte.id}" class="btn-floating btn-sm btn-dark-green" style="color: white" title="Agregar otro">
                                                                <i class="fa fa-plus"></i>
                                                            </a>
                                                        </th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                        <#list teclados as t>
                                                        <tr>
                                                            <td>${t?index+1}</td>
                                                            <td class="text-center">${t.tipoTeclado.descripcion}</td>
                                                            <td><a href="/teclado/actualizar/${parte.id}/${t.id}"><i
                                                                    style="font-size: 24px; color: darkorange"
                                                                    class="fa fa-edit"></i></a></td>
                                                            <td><a href="/teclado/eliminar/${t.id}/${computadoraId}"><i
                                                                    style="font-size: 24px; color: red"
                                                                    class="fa fa-trash"></i></a></td>
                                                        </tr>
                                                        </#list>
                                                    </tbody>
                                                </table>
                                            <#else>
                                                <h6>No Hay Teclados agrega una...</h6>
                                            </#if>

                                            <#--<div class="row">-->
                                                <#--<div class="col-md-2 mb-3">-->
                                                    <#--<a href="/teclado/crear/${parte.id}" class="btn btn-info">Agregar otro</a>-->
                                                <#--</div>-->
                                            <#--</div>-->
                                        </div>
                                    </div>
                                </div>
                            </#if>
                        </#list>
                     </div>
                </#if>
                <div class="row">
                    <div class="col-md-2 mb-3">
                        <a href="/parte/agregar/${computadoraId}" class="btn btn-info">Agregar otro</a>
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