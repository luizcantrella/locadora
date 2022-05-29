package com.exemplo.locadora.negocio.entidade.vinil;

import com.exemplo.locadora.negocio.entidade.interfaces.Locacao;

public class LocacaoDeVinil extends Locacao {

    private Boolean devolvidoDanificado;

    public Boolean getDevolvidoDanificado() {
        return devolvidoDanificado;
    }

    public void setDevolvidoDanificado(Boolean _devolvidoDanificado) {
        Vinil vinil = (Vinil)this.getLocavel();
        vinil.setDanificado(_devolvidoDanificado);
        this.devolvidoDanificado = _devolvidoDanificado;
    }

    @Override
    public Double valor() {
        Vinil vinil = (Vinil)this.getLocavel();
        Double valorDiarias      = this.duracaoEmDias() * vinil.getValorDiaria();
        Double valorDisco = 0.0;
        if (this.devolvidoDanificado) {
            valorDisco = vinil.getValorDoVinil();
        }
        return  valorDiarias + valorDisco;
    }
}
