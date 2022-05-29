package com.exemplo.locadora.negocio.fachada.veiculo;

import com.exemplo.locadora.negocio.entidade.interfaces.Locatario;
import com.exemplo.locadora.negocio.entidade.veiculo.LocatarioDeVeiculo;
import com.exemplo.locadora.negocio.entidade.interfaces.Locacao;
import com.exemplo.locadora.negocio.entidade.interfaces.Locavel;
import com.exemplo.locadora.negocio.entidade.veiculo.LocacaoDeVeiculo;
import com.exemplo.locadora.negocio.entidade.veiculo.Veiculo;
import com.exemplo.locadora.negocio.fachada.interfaces.LocadoraFachada;

import java.util.ArrayList;
import java.util.Map;

public class LocadoraDeVeiculoFachada extends LocadoraFachada {

    @Override
    public void instanciarObjetos() {
        Veiculo v1 = new Veiculo();
        v1.setId(1L);
        v1.setMarca("Fiat");
        v1.setModelo("Pálio 1.6");
        v1.setKmAtual(0L);
        v1.setValorDiaria(100.0);
        v1.setValorKmAdicional(5.0);
        v1.setLocacoes(new ArrayList<>());
        getLocaveis().put(v1.getId(), v1);
        LocatarioDeVeiculo l1 = new LocatarioDeVeiculo();
        l1.setId(1L);
        l1.setNome("João Silva");
        l1.setLocacoes(new ArrayList<>());
        getLocatarios().put(l1.getId(), l1);
    }

    @Override
    protected void adicionarAtributosDoLocatario(Locatario _locatario, Map<String, String> _atributosDoLocatario) {

    }

    @Override
    protected void adicionarAtributosDoLocavel(Locavel _locavel, Map<String, String> _atributosDoLocavel) {
        Veiculo veiculo = (Veiculo) _locavel;
        if (_atributosDoLocavel.containsKey("kmAtual")) {
            veiculo.setKmAtual(
                    Long.parseLong(_atributosDoLocavel.get("kmAtual"))
            );
        }
        if (_atributosDoLocavel.containsKey("marca")) {
            veiculo.setMarca(_atributosDoLocavel.get("marca"));
        }
        if (_atributosDoLocavel.containsKey("modelo")) {
            veiculo.setModelo(_atributosDoLocavel.get("modelo"));
        }
        if (_atributosDoLocavel.containsKey("valorDiaria")) {
            veiculo.setValorDiaria(
                    Double.parseDouble(_atributosDoLocavel.get("valorDiaria"))
            );
        }
        if (_atributosDoLocavel.containsKey("valorKmAdicional")) {
            veiculo.setValorKmAdicional(
                    Double.parseDouble(_atributosDoLocavel.get("valorKmAdicional"))
            );
        }
    }

    @Override
    protected void tratarParticularidadesDaLocacao(Locacao _locacao, Locavel _locavel) {
        LocacaoDeVeiculo locacao = (LocacaoDeVeiculo)_locacao;
        Veiculo          veiculo = (Veiculo)_locavel;
        locacao.setKmRetirada(veiculo.getKmAtual());
    }

    @Override
    protected void tratarParcicularidadesDaDevolucao(Locacao _locacao, Map<String, Object> _infoAdicionais) {
        LocacaoDeVeiculo locacaoDeVeiculo = (LocacaoDeVeiculo)_locacao;
        locacaoDeVeiculo.setKmDevolucao((Long)_infoAdicionais.get("kmAtual"));
    }

}
