package com.exemplo.locadora.negocio.fachada.interfaces;

import com.exemplo.locadora.negocio.entidade.interfaces.Locacao;
import com.exemplo.locadora.negocio.entidade.interfaces.Locatario;
import com.exemplo.locadora.negocio.entidade.interfaces.Locavel;

import java.security.InvalidParameterException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public  abstract class LocadoraFachada {

    // Os maps simulam um banco de dados com os objetos persistidos.
    private static Map<Long, Locavel>   locaveis   = new HashMap<>();
    private static Map<Long, Locatario> locatarios = new HashMap<>();
    private static Map<Long, Locacao>   locacoes   = new HashMap<>();

    public static Map<Long, Locavel> getLocaveis() {
        return locaveis;
    }

    public static Map<Long, Locatario> getLocatarios() {
        return locatarios;
    }

    // Template Method
    protected abstract void tratarParticularidadesDaLocacao(Locacao _locacao, Locavel _locavel);
    protected abstract void tratarParcicularidadesDaDevolucao(
            Locacao _locacao,
            Map<String, Object> _infoAdicionais);

    public abstract void instanciarObjetos();

    public Locacao locar(Long _idLocatario, Long _idLocavel, Locacao _locacao) {

        Locatario locatario = locatarios.get(_idLocatario);
        if (locatario == null) {
            throw new InvalidParameterException("Locatário não existe!");
        }
        Locavel locavel = locaveis.get(_idLocavel);
        if (locavel == null) {
            throw new InvalidParameterException("Item desejado para locação não existe!");
        }
        if (!locavel.disponivel()) {
            throw new InvalidParameterException("O item já está locado!");
        }
        _locacao.setId(locacoes.size() + 1L);
        _locacao.setInicio(new Date());
        _locacao.setPaga(false);

        this.tratarParticularidadesDaLocacao(_locacao, locavel);

        _locacao.setLocatario(locatario);
        locatario.getLocacoes().add(_locacao);
        _locacao.setLocavel(locavel);
        locavel.getLocacoes().add(_locacao);

        // Salvando no banco de dados simiulado.
        locacoes.put(_locacao.getId(), _locacao);
        return _locacao;
    }

    public void devolver(Locacao                _locacao,
                         Map<String, Object>    _infoAdicionais) {
        if (_locacao == null) {
            throw new InvalidParameterException("Locação não existe!");
        }
        _locacao.setFim(new Date());
        this.tratarParcicularidadesDaDevolucao(_locacao, _infoAdicionais);

    }

    public void salvarLocatario(
            Locatario _locatario,
            String _nome,
            Long _id,
            Map<String, String> _atributosDoLocatario) {
        _locatario.setNome(_nome);
        _locatario.setId(_id);
        this.adicionarAtributosDoLocatario(_locatario, _atributosDoLocatario);
        locatarios.put(_locatario.getId(),_locatario);
    };

    // Template Method
    protected abstract void adicionarAtributosDoLocatario(
            Locatario _locatario,
            Map<String, String> _atributosDoLocatario);

    public void salvarLocavel(Locavel _locavel, Long _id, Map<String, String> _atributosDoLocavel) {
        _locavel.setId(_id);
        this.adicionarAtributosDoLocavel(_locavel, _atributosDoLocavel);
        locaveis.put(_locavel.getId(), _locavel);
    }

    protected abstract void adicionarAtributosDoLocavel(
            Locavel _locavel,
            Map<String, String> _atributosDoLocavel);

    public Locatario pegarLocatario(Long _id) {
        return locatarios.get(_id);
    }

    public Locavel pegarLocavel(Long _id) {
        return locaveis.get(_id);
    }

}
