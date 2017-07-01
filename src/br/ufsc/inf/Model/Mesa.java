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
public class Mesa implements Jogada {
    
    protected Jogador jogador;
    protected Jogador adversario;
    protected Jogador vencedor;
    protected int tipoJogada;
    protected Jogador vendedorUltimaRodada;
    protected int rodadaAtual;
    protected Jogador daVez;
    protected ArrayList<Carta> cartasDaMesa = new ArrayList<Carta>();  
    
    public Mesa(){
        
    }

    /** Método para setar jogador principal.
     * @param jogador Jogador - Jogador principal.
     */
    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    /** Método para recuperar jogador principal.
     * @return Jogador - Jogador principal.
     */
    public Jogador getJogador(){
        return this.jogador;
    }

    /** Método para setar jogador adversário.
     * @param adversario Jogador - Jogador adversário.
     */
    public void setAdversario(Jogador adversario) {
        this.adversario = adversario;
    }

    /** Método para recuperar jogador adversário.
     * @return Jogador - Jogador adversário.
     */
    public Jogador getAdversario(){
        return this.adversario;
    }
    
    public void setJogadorDaVez(Jogador jogador) {
        this.daVez = jogador;
    }
    
    /** Método para recuperar cartas que estão na mesa.
     * @return List(Carta) - Cartas jogadas na mesa.
     */
    public ArrayList<Carta> getCartasMesa() {
        return cartasDaMesa;
    }

    public void setVencedor(Jogador vencedor) {
        this.vencedor = vencedor;
    }
    
    
}
