package com.exemplo.locadora.negocio.fabrica.veiculo;

import com.exemplo.locadora.negocio.entidade.interfaces.Locacao;
import com.exemplo.locadora.negocio.entidade.interfaces.Locatario;
import com.exemplo.locadora.negocio.entidade.interfaces.Locavel;
import com.exemplo.locadora.negocio.entidade.veiculo.LocacaoDeVeiculo;
import com.exemplo.locadora.negocio.entidade.veiculo.LocatarioDeVeiculo;
import com.exemplo.locadora.negocio.entidade.veiculo.Veiculo;
import com.exemplo.locadora.negocio.fabrica.interfaces.LocadoraFabrica;
import com.exemplo.locadora.negocio.fachada.interfaces.LocadoraFachada;
import com.exemplo.locadora.negocio.fachada.veiculo.LocadoraDeVeiculoFachada;

public class LocadoraDeVeiculoFabrica extends LocadoraFabrica {

    private LocadoraDeVeiculoFabrica(){};
    public static LocadoraFabrica getInstance() {
        if(instance == null) {
            instance = new LocadoraDeVeiculoFabrica();
        }
        return instance;
    }

    @Override
    public LocadoraFachada criarFachada() {
        return new LocadoraDeVeiculoFachada();
    }

    @Override
    public Locacao criarLocacao() {
        return new LocacaoDeVeiculo();
    }

    @Override
    public Locatario criarLocatario() {
        return new LocatarioDeVeiculo();
    }

    @Override
    public Locavel criarLocavel() {
        return new Veiculo();
    }

}
