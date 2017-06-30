/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.inf.View;

import br.ufsc.inf.Controller.Controlador;
import br.ufsc.inf.Model.Carta;
import br.ufsc.inf.Model.Mesa;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas Corrêa, Thiago Pauli
 */
public class AtorJogador {
    
    protected Controlador owner;
    protected TelaMesa telaMesa;
    
    public AtorJogador(Controlador controlador) {
        this.telaMesa = new TelaMesa(this);
        this.owner = controlador;
    }

    public void conectar() {
        int resultado = this.owner.conectar();
        this.informarResultado(resultado);
    }

    public void iniciarPartida() {
        int resultado = this.owner.iniciarPartida();
        this.informarResultado(resultado);
    }

    public void desconectar() {
        int resultado = this.owner.desconectar();
        this.informarResultado(resultado);
    }

    private void informarResultado(int resultado) {
        this.telaMesa.informarResultado(resultado);
    }

    public void mostraInterface() {
        this.telaMesa.setLocationRelativeTo(null);
        this.telaMesa.setVisible(true);
    }

    public String obterNomeServidor() {
        return this.telaMesa.obterNomeServidor();
    }

    public String obterNomeJogador() {
        return this.telaMesa.obterNomeJogador();
    }

    public void informarNomeAdversario(String nome) {
        this.telaMesa.atualizarNomeAdversario(nome);
    }
    
    public void clickCarta(List<Carta> mao, int posicao){
        Carta cartaSelecionada = mao.get(posicao);  
        if(cartaSelecionada.isSelecionada()){
               cartaSelecionada.tiraSelecao();
           }
           else{
               cartaSelecionada.seleciona();
           }
    }
    
    public void tratarJogadaJogador(){
        
    }
    
            /*
    public void tratarJogada(){
        List<Carta> selecionadas = new ArrayList<>();
        if(this.owner.isDaVez()){            
            if(this.owner.getOrdem() == 1){
                List<Carta> mao = this.owner.getMesa().getJogador().getMao();
                for(Carta carta : mao){
                    if(carta.isSelecionada()){
                        selecionadas.add(carta);
                        if(){
                            
                        }
                    }
                }
            }
            else{
                List<Carta> mao = this.owner.getMesa().getAdversario().getMao();
                for(Carta carta : mao){
                    if(carta.isSelecionada()){
                        selecionadas.add(carta);
                    }
                }
            }
        }
        else{
            //Não é a sua vez!
        }
    }
*/
    
    public void jogadorSelecionouPosicao(int posicao){
       if(this.owner.getOrdem() == 1){
           List<Carta> mao = this.owner.getMesa().getJogador().getMao();
           this.clickCarta(mao, posicao);
       } 
    }
    
    public void adversarioSelecionouPosicao(int posicao){
        if(this.owner.getOrdem() == 2){
            List<Carta> mao = this.owner.getMesa().getAdversario().getMao();
            this.clickCarta(mao, posicao);
        }
    }
    
    public void atualizaTelaPosJogada(Mesa mesa){
        if(this.owner.getOrdem() == 1) {
            ArrayList<Carta> cartasJogador = mesa.getJogador().getMao();
            int cartasAdversario = mesa.getAdversario().getMao().size();
            ArrayList<Carta> cartasMesa = mesa.getCartasMesa();
            this.telaMesa.atualizaTelaJogador(cartasJogador, cartasAdversario, cartasMesa);
        } else {
            int cartasJogador = mesa.getJogador().getMao().size();
            ArrayList<Carta> cartasAdversario = mesa.getAdversario().getMao();
            ArrayList<Carta> cartasMesa = mesa.getCartasMesa();
            this.telaMesa.atualizaTelaAdversario(cartasJogador, cartasAdversario, cartasMesa);
        }
    }
    
    public void atualizaNomeJogador(String jogador, String nome){
        if(jogador.toLowerCase().equals("jogador")){
            this.telaMesa.trocaNomeJogador(nome);
        } else {
            this.telaMesa.trocaNomeAdversario(nome);
        }
    }
}
