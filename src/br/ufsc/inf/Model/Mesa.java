/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.inf.Model;

import br.ufsc.inf.leobr.cliente.Jogada;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas Corrêa, Thiago Pauli
 */
public class Mesa implements Jogada {
    
    protected Jogador jogador;
    protected Jogador presidente;
    protected Jogador adversario;
    protected Jogador vencedor;
    protected Jogador cu;
    protected int tipoJogada;
    protected Jogador vendedorUltimaRodada;
    protected int rodadaAtual;
    protected Jogador daVez;
    protected ArrayList<Carta> cartasDaMesa = new ArrayList<Carta>(); 
    protected int qntJogadasPuladas = 0;
    
    public Mesa(){
        
    }
    
    public Jogador getVencedorUltimaRodada(){
        return this.vendedorUltimaRodada;
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

    public void setVencedorUltimaRodada(Jogador player) {
        this.vendedorUltimaRodada = player;
    }

    public void setCartasDaMesa(ArrayList<Carta> selecionadas) {
        this.cartasDaMesa = selecionadas;
    }

    public void setPresidente(Jogador vencedorUltimaRodada) {
        this.presidente = vencedorUltimaRodada;
    }
    
    public Jogador getPresidente(){
        return this.presidente;
    }

    public void setCu(Jogador cu) {
        this.cu = cu;
    }
    
    public Jogador getCu(){
        return this.cu;
    }
    
    public int getQntJogadasPuladas(){
        return this.qntJogadasPuladas;
    }
    
    public void aumentaQntJogadasPuladas(){
        if(++qntJogadasPuladas == 2){
            cartasDaMesa.clear();
            qntJogadasPuladas = 0;
        }
    }
    
    public void zeraQntJogadasPuladas(){
        this.qntJogadasPuladas = 0;
    }
    
    
}
