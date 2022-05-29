package com.exemplo.locadora.negocio.entidade.vinil;

import com.exemplo.locadora.negocio.entidade.interfaces.Locatario;

public class LocatarioDeVinil extends Locatario {

    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
