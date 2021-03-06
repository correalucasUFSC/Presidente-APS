/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.inf.Model;

import br.ufsc.inf.leobr.cliente.Jogada;
import java.util.ArrayList;

/**
 * @author Lucas Corrêa, Thiago Pauli
 */
public class Jogador implements Jogada {
    
    protected String nome;
    protected ArrayList<Carta> mao;
    protected int rodadasGanhas;
    protected boolean ehPresidente;
    
    protected boolean primeiraJogada = true;
    
    /** Construtor com nome.
     * @param nome String - Nome do jogador.
     */
    public Jogador(String nome){
        this.nome = nome;
    }

    public Jogador(ArrayList<Carta> maoJogador2, String nomeAdversario) {
        this.mao = maoJogador2;
        this.nome = nomeAdversario;
    }

    /** Método para pegar nome do jogador.
     * @return String - Nome do jogador.
     */
    public String getNome() {
        return nome;
    }

    /** Método para setar o nome do jogador.
     * @param nome String - Nome do jogador.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /** Método para pegar a mão do jogador.
     * @return List(Carta) - Mão do jogador.
     */
    public ArrayList<Carta> getMao() {
        return mao;
    }

    /** Método para setar a mão do jogador.
     * @param mao List(Carta) - Mão do jogador.
     */
    public void setMao(ArrayList<Carta> mao) {
        this.mao = mao;
    }

    /** Método para aumentar a quantidade de rodadas ganhas pelo jogador.
     */
    public void aumentaRodadasGanhas(){
        this.rodadasGanhas++;
    }
    
    /** Método para pegar o numero de rodadas ganhas pelo jogador.
     * @return int - Numero de rodadas vitorioso.
     */
    public int getRodadasGanhas(){
        return this.rodadasGanhas;
    }

    /** Método para descobrir se jogador é presidente ou cu.
     * @return boolean - TRUE se presidente, FALSE se cu.
     */
    public boolean getEhPresidente(){
        return this.ehPresidente;
    }
    
    /** Método para transformar jogador em presidente ou cu.
     * @param ehPresidente boolean - TRUE se presidente, FALSE se cu.
     */
    public void setPresidente(boolean ehPresidente){
        this.ehPresidente = ehPresidente;
    }
    
}
