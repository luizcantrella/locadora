package com.exemplo.locadora.negocio.fabrica.vinil;

import com.exemplo.locadora.negocio.entidade.interfaces.Locacao;
import com.exemplo.locadora.negocio.entidade.interfaces.Locatario;
import com.exemplo.locadora.negocio.entidade.interfaces.Locavel;
import com.exemplo.locadora.negocio.entidade.vinil.LocacaoDeVinil;
import com.exemplo.locadora.negocio.entidade.vinil.LocatarioDeVinil;
import com.exemplo.locadora.negocio.entidade.vinil.Vinil;
import com.exemplo.locadora.negocio.fabrica.interfaces.LocadoraFabrica;
import com.exemplo.locadora.negocio.fachada.interfaces.LocadoraFachada;
import com.exemplo.locadora.negocio.fachada.vinil.LocadoraDeVinilFachada;

public class LocadoraDeVinilFabrica extends LocadoraFabrica {

    private LocadoraDeVinilFabrica(){};
    public static LocadoraFabrica getInstance() {
        if(instance == null) {
            instance = new LocadoraDeVinilFabrica();
        }
        return instance;
    }

    @Override
    public LocadoraFachada criarFachada() {
        return new LocadoraDeVinilFachada();
    }

    @Override
    public Locacao criarLocacao() {
        return new LocacaoDeVinil();
    }

    @Override
    public Locatario criarLocatario() {
        return new LocatarioDeVinil();
    }

    @Override
    public Locavel criarLocavel() {
        return new Vinil();
    }

}
