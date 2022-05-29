package com.exemplo.locadora.negocio.entidade.vinil;

import com.exemplo.locadora.negocio.entidade.interfaces.Locavel;

public class Vinil extends Locavel {

    private String      titulo;
    private String      artista;
    private String        lancamento;
    private Double      valorDiaria;
    private Double      valorDoVinil;
    private Boolean     danificado;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getLancamento() {
        return lancamento;
    }

    public void setLancamento(String lancamento) {
        this.lancamento = lancamento;
    }

    public Double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(Double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public Double getValorDoVinil() {
        return valorDoVinil;
    }

    public void setValorDoVinil(Double valorDoVinil) {
        this.valorDoVinil = valorDoVinil;
    }

    public Boolean getDanificado() {
        return danificado;
    }

    public void setDanificado(Boolean danificado) {
        this.danificado = danificado;
    }

}
