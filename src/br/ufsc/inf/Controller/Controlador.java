/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.inf.Controller;

import Presidente.Constantes;
import br.ufsc.inf.Model.Carta;
import br.ufsc.inf.Model.Jogador;
import br.ufsc.inf.Model.Mesa;
import br.ufsc.inf.View.AtorJogador;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import rede.AtorNetGames;

/**
 *
 * @author lucas
 */
public class Controlador {

    protected AtorJogador atorJogador;
    protected AtorNetGames atorNetGames;
    protected Jogador jogador;
    protected Jogador adversario;
    protected Mesa mesa;
    protected int ordem;
    protected int ordemAdversario;
    protected boolean conectado;
    protected boolean jogoEmAndamento;

    public Controlador() {
        this.mesa = new Mesa();
        this.conectado = false;
        this.jogoEmAndamento = false;
        this.atorJogador = new AtorJogador(this);
        this.atorNetGames = new AtorNetGames(this);

        this.atorJogador.mostraInterface();

    }

    public int conectar() {
        if (this.conectado) {
            return Constantes.JA_CONECTADO;
        } else {
            String servidor = this.atorJogador.obterNomeServidor();
            String nomeJogador = this.atorJogador.obterNomeJogador();
            this.jogador = new Jogador(nomeJogador);
            this.conectado = this.atorNetGames.conectar(nomeJogador, servidor);
            if (this.conectado) {
                return Constantes.CONEXAO_EXITO;
            } else {
                return Constantes.CONEXAO_FALHOU;
            }
        }
    }

    public int desconectar() {
        if (this.conectado) {
            boolean desconectado = this.atorNetGames.desconectar();
            if (desconectado) {
                return Constantes.DESCONEXAO_EXITO;
            } else {
                return Constantes.DESCONEXAO_FALHOU;
            }
        } else {
            return Constantes.JA_DESCONECTADO;
        }
    }

    public int iniciarPartida() {
        if (this.conectado) {
            if (this.jogoEmAndamento) {
                return Constantes.JOGO_EM_ANDAMENTO;
            } else {
                boolean iniciada = this.atorNetGames.iniciarPartida();
                if (iniciada) {
                    return Constantes.SOLICITADO_INICIO_PARTIDA;
                } else {
                    return Constantes.INICIAR_PARTIDA_FALHOU;
                }
            }
        } else {
            return Constantes.FALTA_CONEXAO;
        }
    }

    public void iniciarNovaPartida(Integer ordem) {
        this.limpar();
        this.setOrdens(ordem);
        String nomeAdversario = this.atorNetGames.
                    obterNomeAdversario(this.ordemAdversario);

        if (this.ordem == 1) {
            this.adversario = new Jogador(nomeAdversario);
            this.atorJogador.informarNomeAdversario(this.adversario.getNome());
            List<Carta> baralho = this.criaBaralho();
            baralho = this.embaralha(baralho);
            List<Carta> maoJogador1 = this.distribuiMao(this.ordem, baralho);
            List<Carta> maoJogador2 = this.distribuiMao(2, baralho);
            this.jogador.setMao(maoJogador1);
            this.adversario.setMao(maoJogador2);
            this.mesa.setJogador(this.jogador);
            this.mesa.setAdversario(this.adversario);
        }
        

    }

    private void limpar() {
        this.adversario = null;
        this.jogoEmAndamento = false;
        this.mesa = new Mesa();
    }

    private List<Carta> criaBaralho() {
        List<Carta> baralho = new ArrayList<>();
        String[] naipes = {"A", "B", "C", "D"};
        for (int valor = 14; valor > 0; valor--) {
            for (int naipe = 0; naipe < 4; naipe++) {
                baralho.add(new Carta(valor, naipes[naipe]));
            }
        }
        return baralho;
    }

    private List<Carta> embaralha(List<Carta> baralho) {
        Collections.shuffle(baralho);
        return baralho;
    }

    private List<Carta> distribuiMao(int ordem, List<Carta> baralho) {
        if (ordem == 1) {
            return baralho.subList(0, 17);
        } else {
            return baralho.subList(20, 37);
        }
    }

    private boolean isDaVez() {
        return this.ordem == 1;
    }

    private void setOrdens(int ordem) {
        this.ordem = ordem;
        this.ordemAdversario = this.ordem == 1 ? 2 : 1;
    }

}
