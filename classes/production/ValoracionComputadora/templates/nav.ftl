 <!-- Navigation -->
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="/">PC-GARAGE</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link btn btn-sm btn-primary btn-floating waves-effect blue-gradient" href="/computadora/"><i class="fa fa-desktop"></i>Evaluar</a>
            </li>

          <#if usuario??>
            <#list usuario.roles as rol>
              <#if rol.rol=="ROLE_ADMIN">
                  <li class="nav-item dropdown">
                      <a class="nav-link dropdown-toggle" id="navbarDropdownTipo" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          Crear Tipos
                      </a>
                      <div class="dropdown-menu dropdown-menu-right" style="max-height: 500px !important;overflow-y: scroll !important;" aria-labelledby="navbarDropdownTipo">
                          <h5 class="dropdown-header">Crear Tipos</h5>
                          <a class="dropdown-item" href="/tipoCompania/agregar">Compañia</a>
                          <a class="dropdown-item" href="/estado/agregar">Estado</a>
                          <a class="dropdown-item" href="/tipoCapacidad/agregar">Capacidad</a>
                          <a class="dropdown-item" href="/tipoComputadora/agregar">Computadora</a>
                          <a class="dropdown-item" href="/tipoConsumoEnergia/agregar">Consumo Energía</a>
                          <a class="dropdown-item" href="/tipoCpu/agregar">CPU</a>
                          <a class="dropdown-item" href="/tipoDiscoDuro/agregar">Disco Duro</a>
                          <a class="dropdown-item" href="/tipoGpu/agregar">GPU</a>
                          <a class="dropdown-item" href="/tipoMaterial/agregar">Material</a>
                          <a class="dropdown-item" href="/tipoMemoria/agregar">Memoria</a>
                          <a class="dropdown-item" href="/tipoPuerto/agregar">Puerto</a>
                          <a class="dropdown-item" href="/tipoRefrescante/agregar">Refrescante</a>
                          <a class="dropdown-item" href="/tipoRendimiento/agregar">Rendimiento</a>
                          <a class="dropdown-item" href="/tipoTeclado/agregar">Teclado</a>
                          <a class="dropdown-item" href="/tipoSistemaOperativo/agregar">Sistemas Operativas</a>
                          <a class="dropdown-item" href="/tipoTipoRendimientoPrecio/agregar">Tipo Tipo Rend. Precio</a>
                      </div>
                  </li> <li class="nav-item dropdown">
                      <a class="nav-link dropdown-toggle" id="navbarDropdownTipo" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          Ver Tipos
                      </a>
                      <div class="dropdown-menu dropdown-menu-right" style="max-height: 500px !important;overflow-y: scroll !important;" aria-labelledby="navbarDropdownTipo">
                          <h5 class="dropdown-header">Ver Tipos</h5>
                          <a class="dropdown-item" href="/tipoCompania/">Compañia</a>
                          <a class="dropdown-item" href="/estado/">Estado</a>
                          <a class="dropdown-item" href="/tipoCapacidad/">Capacidad</a>
                          <a class="dropdown-item" href="/tipoComputadora/">Computadora</a>
                          <a class="dropdown-item" href="/tipoConsumoEnergia/">Consumo Energía</a>
                          <a class="dropdown-item" href="/tipoCpu/">CPU</a>
                          <a class="dropdown-item" href="/tipoDiscoDuro/">Disco Duro</a>
                          <a class="dropdown-item" href="/tipoGpu/">GPU</a>
                          <a class="dropdown-item" href="/tipoMaterial/">Material</a>
                          <a class="dropdown-item" href="/tipoMemoria/">Memoria</a>
                          <a class="dropdown-item" href="/tipoPuerto/">Puerto</a>
                          <a class="dropdown-item" href="/tipoRefrescante/">Refrescante</a>
                          <a class="dropdown-item" href="/tipoRendimiento/">Rendimiento</a>
                          <a class="dropdown-item" href="/tipoSistemaOperativo/">Sistemas Operativas</a>
                          <a class="dropdown-item" href="/tipoTeclado/">Teclado</a>
                          <a class="dropdown-item" href="/tipoTipoRendimientoPrecio/">Tipo Tipo Rend. Precio</a>
                      </div>
                  </li>
              </#if>
            </#list>
          </#if>

            <#if usuario??>
                <li class="nav-item dropdown">
                    <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownLogout">
                        <#list usuario.roles as rol>
                            <#if rol.rol=="ROLE_ADMIN">
                                <a class="nav-link btn-sm btn blue-gradient" href="/usuario/${usuario.id}">Ver Usuarios</span></a>
                            </#if>
                        </#list>
                        <a class="nav-link btn-sm btn peach-gradient" href="/usuario/actualizar/${usuario.id}">Editar cuenta</span></a>
                        <a class="nav-link btn-sm btn purple-gradient" href="/logout">Cerrar sesión</span></a>
                    </div>
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownLogout" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Bienvenido, <span style="color: #3d8b3d; font-family: cursive">${usuario.name}</span>
                    </a>
                </li>
            <#else>
                <li class="nav-item">
                    <a class="nav-link btn btn-sm btn-primary" href="/login">Abrir Sesión</a>
                </li>
            </#if>
          </ul>
        </div>
      </div>
    </nav>


