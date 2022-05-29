package com.exemplo.locadora.negocio.fabrica.interfaces;

import com.exemplo.locadora.negocio.entidade.interfaces.Locacao;
import com.exemplo.locadora.negocio.entidade.interfaces.Locatario;
import com.exemplo.locadora.negocio.entidade.interfaces.Locavel;
import com.exemplo.locadora.negocio.fachada.interfaces.LocadoraFachada;

public abstract class LocadoraFabrica {

    protected static LocadoraFabrica instance;

    public abstract LocadoraFachada criarFachada();
    public abstract Locacao criarLocacao();
    public abstract Locatario criarLocatario();
    public abstract Locavel criarLocavel();

}
