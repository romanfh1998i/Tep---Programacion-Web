package com.tep.pucmm.ValoracionComputadora.Helpers;

import lombok.Data;

/**
 * Created by Roman on 27/10/18.
 */
//@Data
public class TipoObject {
    private String actionName;
    private Object objeto;

    public TipoObject(String actionName, Object objeto) {
        this.actionName = actionName;
        this.objeto = objeto;
    }

    public TipoObject() {
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }
}
