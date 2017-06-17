/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.inf.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class Jogador {
    
    protected String nome;
    protected List<Carta> mao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Carta> getMao() {
        return mao;
    }

    public void setMao(List<Carta> mao) {
        this.mao = mao;
    }
    
    public Jogador(String nome){
        this.nome = nome;
        
    }
    
}
