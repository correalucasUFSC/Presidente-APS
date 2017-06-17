/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.inf.Model;

/**
 *
 * @author lucas
 */
public class Mesa {
    
    protected Jogador jogador;
    protected Jogador adversario;
    
    public Mesa(){
        
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public void setAdversario(Jogador adversario) {
        this.adversario = adversario;
    }
    
    
    
}
