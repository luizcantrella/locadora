package com.exemplo.locadora;

import com.exemplo.locadora.negocio.entidade.interfaces.Locacao;
import com.exemplo.locadora.negocio.entidade.interfaces.Locatario;
import com.exemplo.locadora.negocio.fabrica.interfaces.LocadoraFabrica;
import com.exemplo.locadora.negocio.fabrica.veiculo.LocadoraDeVeiculoFabrica;
import com.exemplo.locadora.negocio.fabrica.vinil.LocadoraDeVinilFabrica;
import com.exemplo.locadora.negocio.fachada.interfaces.LocadoraFachada;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        String config = "vinil";
        LocadoraFabrica fabrica;
        switch (config) {
            case "veiculo": {
                fabrica = LocadoraDeVeiculoFabrica.getInstance();
                break;
            }
            case "vinil": {
                fabrica = LocadoraDeVinilFabrica.getInstance();
                break;
            }
            default:
                fabrica = LocadoraDeVeiculoFabrica.getInstance();
        }

        LocadoraFachada fachada = fabrica.criarFachada();
        fachada.instanciarObjetos();
        Locacao locacao = fabrica.criarLocacao();
        locacao = fachada.locar(1L, 1L, locacao);
        System.out.println("\nLocação criada com as seguintes informações:");
        System.out.println("- Id: " + locacao.getId());
        System.out.println("- Data de início: " + locacao.getInicio());
        System.out.println("- Paga: " + (locacao.getPaga() ? "Sim" : "Não"));

        // devolver
        HashMap<String, Object> infoAdicionais = new HashMap<>();

        if (config == "veiculo") {
            infoAdicionais.put("kmAtual", 100L);
        }
        if (config == "vinil") {
            infoAdicionais.put("danificado", true);
        }
        fachada.devolver(locacao, infoAdicionais);
        System.out.println("- Divida: " + locacao.getLocatario().divida());

        // pagar
        System.out.println("- Valor à pagar: " + locacao.valor());
        locacao.setPaga(true);
        System.out.println("- Divida: " + locacao.getLocatario().divida());

        // cadastrar locatario
        Locatario locatario = fabrica.criarLocatario();
        HashMap<String, String> atributosLocatario = new HashMap<>();
        if ( config == "vinil") {
            atributosLocatario.put("cpf", "111.111.111-11");
        }
        fachada.salvarLocatario(locatario,"Gabriel Cantrella", 2L, atributosLocatario);

        LocadoraFachada.getLocatarios().forEach( (index, it) -> System.out.println(it.getNome()));
	}

}
