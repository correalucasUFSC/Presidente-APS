/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.inf.View;

import br.ufsc.inf.Controller.Controlador;
import br.ufsc.inf.Model.Carta;
import java.util.ArrayList;

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

    public void informarResultado(int resultado) {
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
        this.telaMesa.trocaNomeAdversario(nome);
    }

    public void solicitacaoPularJogada() {
        this.owner.solicitacaoPularJogada();
    }

    public void cartaSelecionadaPos(int posicao) {
        this.owner.cartaSelecionadaPos(posicao);
    }

    public void mostraBotoes() {
        this.telaMesa.inicia();
    }

    public void mudaQuantidadeVitoriasJogador(int vitorias, String jogador) {
        this.telaMesa.aumentaVitoria(jogador, vitorias);
    }

    public void solicitacaoTratarJogada() {
        this.owner.solicitacaoTratarJogada();
    }

    public void bloqueiaMesa(String jogador) {
        this.telaMesa.bloqueiaMesa(jogador);
    }

    public void trocaVez(String jogador) {
        this.telaMesa.trocaVez(jogador);
    }

    public void atualizaTelaJogador(ArrayList<Carta> cartasJogador, int cartasAdversario, ArrayList<Carta> cartasMesa) {
        this.telaMesa.atualizaTelaJogador(cartasJogador, cartasAdversario, cartasMesa);
    }

    public void trocaPresidente(String jogador) {
        this.telaMesa.trocaPresidente(jogador);
    }

    public void atualizaTelaAdversario(int cartasJogador, ArrayList<Carta> cartasAdversario, ArrayList<Carta> cartasMesa) {
        this.telaMesa.atualizaTelaAdversario(cartasJogador, cartasAdversario, cartasMesa);
    }

    public void trocaNomeJogador(String nome) {
        this.telaMesa.trocaNomeJogador(nome);
    }

    public void aumentaVitoria(String jogador, int i) {
        this.telaMesa.aumentaVitoria(jogador, i);
    }

    public void trocaNomeAdversario(String nome) {
        this.telaMesa.trocaNomeAdversario(nome);
    }
}
