
   
<!DOCTYPE html>
<html lang="en"  xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

  <head>
      <title>Ver Computadora</title>
      <#include "../header.ftl">
</head>

<body>

    <!-- Navigation -->
    <#include "../nav.ftl">

    <!-- Page Content -->
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <h1 class="my-4">Información de <small>Computadora</small></h1>
            </div>
        </div>
        <div class="row">
                <#if computadoras??>
                    <#list computadoras as computadora>
                    <div class="col-md-8">
                        <div class="mb-4" id="accordion" role="tablist" aria-multiselectable="true">
                            <div class="card">
                                <div class="card-header" role="tab" id="heading${computadora?index+1}">
                                    <a class="collapsed" data-toggle="collapse" data-parent="#accordion"
                                       href="#collapse${computadora?index+1}"
                                       aria-expanded="false" aria-controls="collapse${computadora?index+1}">
                                        <h5 class="mb-0">
                                            ${computadora.marca} &nbsp; ${computadora.color}<i class="fa fa-angle-down rotate-icon"></i>
                                        </h5>
                                    </a>

                                    <div id="collapse${computadora?index+1}" class="collapse" role="tabpanel" aria-labelledby="heading${computadora?index+1}">
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col"></div>
                                                <div class="col"></div>
                                                <div class="col">
                                                    <a href="/computadora/actualizar"
                                                       class="btn btn-floating btn-warning waves-effect"
                                                       data-toggle="tooltip"
                                                       data-placement="top"
                                                       title="Actualizar Computadora">
                                                        <i class="text-light fa fa-edit"></i>
                                                    </a>
                                                </div>
                                                <div class="col">
                                                    <a href="/parte/"
                                                       class="btn btn-floating btn-success waves-effect"
                                                       data-toggle="tooltip"
                                                       data-placement="top"
                                                       title="Eliminar">
                                                        <i class="text-light fa fa-trash"></i>
                                                    </a>
                                                </div>
                                            </div>
                                            <table class="table table-hover">
                                                <tbody>
                                                    <tr>
                                                        <td><strong>Marca: </strong></td>
                                                        <td class="text-center">${computadora.marca}</td>
                                                    </tr>
                                                    <tr>
                                                        <td><strong>Tipo Computadora: </strong></td>
                                                        <td class="text-center">${computadora.tipoComputadora.descripcion}</td>
                                                    </tr>
                                                    <tr>
                                                        <td><strong>Tipo Sistema Operativo: </strong></td>
                                                        <td class="text-center">${computadora.tipoSistemaOperativo.descripcion}</td>
                                                    </tr>
                                                    <tr>
                                                        <td><strong>Color: </strong></td>
                                                        <td class="text-center">${computadora.color}</td>
                                                    </tr>
                                                    <tr>
                                                        <td><strong>Número Serie: </strong></td>
                                                        <td class="text-center">${computadora.numeroSerie}</td>
                                                    </tr>
                                                    <tr>
                                                        <td><strong>Tamaño: </strong></td>
                                                        <td class="text-center">${computadora.tamano}</td>
                                                    </tr>
                                                    <tr>
                                                        <td><strong>Año de Salida: </strong></td>
                                                        <td class="text-center">${computadora.anoSalida}</td>
                                                    </tr>
                                                    <tr>
                                                        <td><strong>Número de Slot Memoria: </strong></td>
                                                        <td class="text-center">${computadora.cantidadMemoria}</td>
                                                    </tr>
                                                    <tr>
                                                        <td><strong>Cantidad de Memoria: </strong></td>
                                                        <td class="text-center">${computadora.numeroSlotMemoria}</td>
                                                    </tr>
                                                    <tr>
                                                        <td><strong>Tien Webcam: </strong></td>
                                                        <td class="text-center">
                                                            <#if computadora.tieneWebcam == true >
                                                                <span class="badge badge-success">Sí</span>
                                                            <#else>
                                                                <span class="badge badge-danger">No</span>
                                                            </#if>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><strong>Es touch: </strong></td>
                                                        <td class="text-center">
                                                            <#if computadora.esTouch == true >
                                                                <span class="badge badge-success">Sí</span>
                                                            <#else>
                                                                <span class="badge badge-danger">No</span>
                                                            </#if>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><strong>Tiene Cargador: </strong></td>
                                                        <td class="text-center">
                                                            <#if computadora.tieneCargador == true >
                                                                <span class="badge badge-success">Sí</span>
                                                            <#else>
                                                                <span class="badge badge-danger">No</span>
                                                            </#if>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><strong>Tiene Fan: </strong></td>
                                                        <td class="text-center">
                                                            <#if computadora.tieneFan== true >
                                                                <span class="badge badge-success">Sí</span>
                                                            <#else>
                                                                <span class="badge badge-danger">No</span>
                                                            </#if>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><strong>Tiene Lector CD/DVD: </strong></td>
                                                        <td class="text-center">
                                                            <#if computadora.tieneLectorCDDVD== true >
                                                                <span class="adge badge-success">Sí</span>
                                                            <#else>
                                                                <span class="badge badge-danger">No</span>
                                                            </#if>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><strong>Tipo Material: </strong></td>
                                                        <td class="text-center">${computadora.tipoMaterial.descripcion}</td>
                                                    </tr>
                                                    <tr>
                                                        <td><strong>Estado: </strong></td>
                                                        <td class="text-center">${computadora.estado.descripcion}</td>
                                                    </tr>
                                                    <tr>
                                                        <td><strong>Cantidad Puertos: </strong></td>
                                                        <td class="text-center">${computadora.cantidadPuertos}</td>
                                                    </tr>

                                                </tbody>
                                            </table>
                                            <!--                    <td><i style = "font-size: 24px; color: red" class="fa fa-trash"></i></td>-->
                                            <#--<td><a href="/tipoCompania/actualizar/${t.id}"><i style = "font-size: 24px; color: darkorange" class="fa fa-edit"></i></a></td>-->

                                             <div class="row">
                                                 <div class="col"></div>
                                                 <div class="col"></div>
                                                 <div class="col">
                                                    <a href="/parte/${computadora.id}" class="btn btn-outline-default btn-rounded waves-effect" data-toggle="tooltip" data-placement="top" title="Ver Partes"><i class="text-dark fa fa-eye"></i><br>Parte</a>
                                                 </div>
                                                 <div class="col">
                                                     <a href="/parte/agregar/${computadora.id}" class="btn btn-outline-primary btn-rounded waves-effect" data-toggle="tooltip" data-placement="top" title="Agregar Parte"><i class="text-dark fa fa-plus"></i><br>Parte</a>
                                                 </div>
                                             </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </#list>
                </#if>
                </div>
            </div>
            <div class="row">
                <div class="col-md-2 mb-3">
                    <a href="/computadora/agregar" class="btn btn-info">Agregar otro</a>
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