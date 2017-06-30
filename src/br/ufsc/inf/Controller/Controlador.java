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
import java.util.Collections;
import java.util.List;
import rede.AtorNetGames;

/**
 * @author Lucas Corrêa, Thiago Pauli
 */

public class Controlador {

    protected AtorJogador atorJogador;
    protected AtorNetGames atorNetGames;
    protected Jogador jogador;
    protected Jogador adversario;
    protected Mesa mesa;
    protected int ordem = 0;
    protected int ordemAdversario;
    protected boolean conectado;
    protected boolean jogoEmAndamento;
    protected boolean daVez = false;

    public Controlador() {
        this.mesa = new Mesa();
        this.conectado = false;
        this.jogoEmAndamento = false;
        this.atorJogador = new AtorJogador(this);
        this.atorNetGames = new AtorNetGames(this);
        this.atorJogador.mostraInterface();
    }

    /** Método para conectar
     * @return int
     */
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

    /** Método para desconectar
     * @return int
     */
    public int desconectar() {
        if (this.conectado) {
            boolean desconectado = this.atorNetGames.desconectar();
            if (desconectado) {
                this.conectado = false;
                return Constantes.DESCONEXAO_EXITO;
            } else {
                return Constantes.DESCONEXAO_FALHOU;
            }
        } else {
            return Constantes.JA_DESCONECTADO;
        }
    }

    /** Método para iniciar a partida
     * @return int
     */
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

    /** Método para iniciar nova partida
     * @param ordem Integer - Ordem dos jogadores.
     */
    public void iniciarNovaPartida(Integer ordem) {
        this.limpar();
        this.setOrdens(ordem);
        String nomeAdversario = this.atorNetGames.obterNomeAdversario(this.ordemAdversario);
        if (this.ordem == 1) {
            this.daVez = true;
            this.adversario = new Jogador(nomeAdversario);
            this.atorJogador.informarNomeAdversario(this.adversario.getNome());
            ArrayList<Carta> baralho = this.criaBaralho();
            baralho = this.embaralha(baralho);
            System.out.println("PASSOU 1");
            ArrayList<Carta> maoJogador1 = this.distribuiMao(this.ordem, baralho);
            System.out.println("PASSOU 2");
            ArrayList<Carta> maoJogador2 = this.distribuiMao(2, baralho);
            System.out.println("PASSOU 3");
            this.jogador.setMao(maoJogador1);
            System.out.println("PASSOU 4");
            this.adversario.setMao(maoJogador2);
            this.mesa.setJogador(this.jogador);
            this.mesa.setAdversario(this.adversario);
            this.atorNetGames.enviarJogada(this.mesa);
        }
    }
    
    /** Método para receber jogada
     * @param mesa Mesa - Recebe a mesa inteira do outro jogador.
     */
    public void receberJogada(Mesa mesa){
        if(this.ordem != 0){
            this.mesa = mesa;
            this.atorJogador.atualizaTelaPosJogada(mesa);
        } else {
            this.mesa = mesa;
            this.adversario = this.mesa.getAdversario();
            this.jogador = this.mesa.getJogador();
            this.setOrdens(2);
            this.atorJogador.atualizaTelaPosJogada(mesa);
        }
    }

    /** Método para limpar tudo */
    private void limpar() {
        this.adversario = null;
        this.jogoEmAndamento = false;
        this.mesa = new Mesa();
    }

    /** Método para criar baralho
     * @return ArrayList<Carta> - Baralho completo com 4 naipes (A, B, C e D) e 14 cartas cada naipe.
     */
    private ArrayList<Carta> criaBaralho() {
        ArrayList<Carta> baralho = new ArrayList<>();
        String[] naipes = {"A", "B", "C", "D"};
        for (int valor = 14; valor > 0; valor--) {
            for (int naipe = 0; naipe < 4; naipe++) {
                baralho.add(new Carta(valor, naipes[naipe]));
            }
        }
        return baralho;
    }

    /** Método para embaralhar o baralho.
     * @return List<Carta> - Baralho completo embaralhado.
     */
    private ArrayList<Carta> embaralha(ArrayList<Carta> baralho) {
        Collections.shuffle(baralho);
        return baralho;
    }

    /** Método para distribuir a mão para jogador.
     * @param ordem int - Ordem do jogador.
     * @param baralho List<Carta> - Baralho de cartas.
     * @return List<Carta> - Restantes das cartas do baralho (Não usadas para a mão do jogador).
     */
    private ArrayList<Carta> distribuiMao(int ordem, ArrayList<Carta> baralho) {
        ArrayList<Carta> baralhoTemp = new ArrayList<Carta>();
        if (ordem == 1) {
            for(int i = 0; i < 9; i++){
                baralhoTemp.add(baralho.get(i));
            }
            return baralhoTemp;
        } else {
            for(int i = 10; i < 19; i++){
                baralhoTemp.add(baralho.get(i));
            }
            return baralhoTemp;
        }
    }

    /** Método para descobrir se é o jogador da vez.
     * @return boolean - Verifica se ordem é igual a 1.
     */
    public boolean isDaVez() {
        return this.daVez;
    }


    /** Método para setar a ordem dos jogadores.
     * @param ordem int - Ordem dos jogadores.
     */
    private void setOrdens(int ordem) {
        this.ordem = ordem;
        this.ordemAdversario = this.ordem == 1 ? 2 : 1;
    }

    public int getOrdem() {
        return this.ordem;
    }
    
    public Mesa getMesa() {
        return this.mesa;
    }
}
