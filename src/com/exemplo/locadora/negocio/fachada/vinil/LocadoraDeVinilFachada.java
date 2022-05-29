package com.exemplo.locadora.negocio.fachada.vinil;

import com.exemplo.locadora.negocio.entidade.interfaces.Locacao;
import com.exemplo.locadora.negocio.entidade.interfaces.Locatario;
import com.exemplo.locadora.negocio.entidade.interfaces.Locavel;
import com.exemplo.locadora.negocio.entidade.vinil.LocacaoDeVinil;
import com.exemplo.locadora.negocio.entidade.vinil.LocatarioDeVinil;
import com.exemplo.locadora.negocio.entidade.vinil.Vinil;
import com.exemplo.locadora.negocio.fachada.interfaces.LocadoraFachada;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Map;

public class LocadoraDeVinilFachada extends LocadoraFachada {

    @Override
    public void instanciarObjetos() {

        Vinil v1 = new Vinil();
        v1.setId(1L);
        v1.setArtista("Nirvana");
        v1.setTitulo("Nevermind");
        v1.setDanificado(false);
        v1.setLancamento("24 de Setembro de 1991");
        v1.setValorDiaria(50.00);
        v1.setValorDoVinil(150.00);
        v1.setLocacoes(new ArrayList<>());

        getLocaveis().put(v1.getId(), v1);

        LocatarioDeVinil l1 = new LocatarioDeVinil();
        l1.setId(1L);
        l1.setNome("Luiz Cantrella");
        l1.setCpf("111.111.111-11");
        l1.setLocacoes(new ArrayList<>());

        getLocatarios().put(l1.getId(), l1);
    }

    @Override
    protected void adicionarAtributosDoLocatario(Locatario _locatario, Map<String, String> _atributosDoLocatario) {
        LocatarioDeVinil locatario = (LocatarioDeVinil) _locatario;
        if (_atributosDoLocatario.containsKey("cpf")) {
            locatario.setCpf(_atributosDoLocatario.get("cpf"));
        }
    }

    @Override
    protected void adicionarAtributosDoLocavel(Locavel _locavel, Map<String, String> _atributosDoLocavel) {
        Vinil vinil = (Vinil) _locavel;
        if (_atributosDoLocavel.containsKey("valorDoVinil")) {
            vinil.setValorDoVinil(
                    Double.parseDouble(_atributosDoLocavel.get("valorDoVinil"))
            );
        }
        if (_atributosDoLocavel.containsKey("titulo")) {
            vinil.setTitulo(_atributosDoLocavel.get("titulo"));
        }
        if (_atributosDoLocavel.containsKey("artista")) {
            vinil.setArtista(_atributosDoLocavel.get("artista"));
        }
        if (_atributosDoLocavel.containsKey("lancamento")) {
            vinil.setLancamento(_atributosDoLocavel.get("lancamento"));
        }
        if (_atributosDoLocavel.containsKey("valorDiaria")) {
            vinil.setValorDiaria(
                    Double.parseDouble(_atributosDoLocavel.get("valorDiaria"))
            );
        }
    }

    @Override
    protected void tratarParticularidadesDaLocacao(Locacao _locacao, Locavel _locavel) {
        Vinil vinil = (Vinil)_locavel;
        if (vinil.getDanificado()) {
           throw new InvalidParameterException("Este vinil não pode ser locado, pois está danificado.");
        }
    }

    @Override
    protected void tratarParcicularidadesDaDevolucao(Locacao _locacao, Map<String, Object> _infoAdicionais) {
        LocacaoDeVinil locacaoDeVinil = (LocacaoDeVinil)_locacao;
        Boolean danificado = (Boolean) _infoAdicionais.get("danificado");
        locacaoDeVinil.setDevolvidoDanificado(danificado);
    }

}
