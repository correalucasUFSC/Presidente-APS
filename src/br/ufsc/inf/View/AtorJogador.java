/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.inf.View;

import br.ufsc.inf.Controller.Controlador;
import br.ufsc.inf.Model.Carta;
import br.ufsc.inf.Model.Mesa;
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

    public void click(String acao) {
        
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
    
    public void atualizaTelaPosJogada(Mesa mesa){
        if(this.owner.getOrdem() == 1) {
            List<Carta> cartasJogador = mesa.getJogador().getMao();
            int cartasAdversario = mesa.getAdversario().getMao().size();
            List<Carta> cartasMesa = mesa.getCartasMesa();
            this.telaMesa.atualizaTelaJogador(cartasJogador, cartasAdversario, cartasMesa);
        } else {
            int cartasJogador = mesa.getJogador().getMao().size();
            List<Carta> cartasAdversario = mesa.getAdversario().getMao();
            List<Carta> cartasMesa = mesa.getCartasMesa();
            this.telaMesa.atualizaTelaAdversario(cartasJogador, cartasAdversario, cartasMesa);
        }
    }
}
