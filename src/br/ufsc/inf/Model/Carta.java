/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.inf.Model;

/**
 * @author Lucas Corrêa, Thiago Pauli
 */
public class Carta {
    
    protected int valor;
    protected String naipe;
    protected boolean selecionada = false;
    
    public Carta(int valor, String naipe){
        this.valor = valor;
        this.naipe = naipe;
    }
    
    public String getCaminho(){
        return this.valor + this.naipe;
    }
    
    public boolean isSelecionada(){
        return this.selecionada;
    }

    public void tiraSelecao() {
        this.selecionada = false;
    }

    public void seleciona() {
        this.selecionada = true;
    }
    
}
