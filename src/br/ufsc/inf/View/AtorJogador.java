/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.inf.View;

import Presidente.Constantes;
import br.ufsc.inf.Controller.Controlador;
import br.ufsc.inf.Model.Carta;
import br.ufsc.inf.Model.Jogador;
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
        this.telaMesa.trocaNomeAdversario(nome);
    }

    public void clickCarta(List<Carta> mao, int posicao) {
        Carta cartaSelecionada = mao.get(posicao);
        if (cartaSelecionada.isSelecionada()) {
            cartaSelecionada.tiraSelecao();
        } else {
            cartaSelecionada.seleciona();
        }
    }

    public boolean tratarJogada(ArrayList<Carta> mao) {
        int retorno = Constantes.JOGADA_INVALIDA;
        boolean continua = false;
        ArrayList<Carta> selecionadas = new ArrayList<>();
        for (Carta carta : mao) {
            if (carta.isSelecionada()) {
                selecionadas.add(carta);
            }
        }
        if(this.owner.getMesa().getCartasMesa().size() > 0){
            if(this.owner.getMesa().getCartasMesa().size() == selecionadas.size()){
                continua = true;
            }
            else{
                //retorna jogada inválida
                this.telaMesa.informarResultado(retorno);
                return false;
            }
        }
        if (this.owner.getMesa().getCartasMesa().isEmpty() || continua){
            int valorConjunto = selecionadas.get(0).getValor();
                for (Carta carta : selecionadas) {
                    if (carta.getValor() != valorConjunto) {
                        //erro conjunto precisa ter cartas com mesmo valor
                        this.telaMesa.informarResultado(retorno);
                        return false;
                    }
                }
                int valorConjuntoMesa = this.owner.getMesa().getCartasMesa().isEmpty() ?
                        0 : this.owner.getMesa().getCartasMesa().get(0).getValor();
                if(valorConjunto > valorConjuntoMesa){
                    //jogada valida           
                    this.owner.getMesa().setCartasDaMesa(selecionadas);
                    mao.removeAll(selecionadas);
                    return true;
                }
                else{
                    //jogada invalida
                    this.telaMesa.informarResultado(retorno);
                    return false;
                }
        }
        System.out.println("verificar o q houve");
        return false;
    }

    public void solicitacaoTratarJogada() {
        boolean jogadaValida;
        Jogador atual;
        if (this.owner.getOrdem() == 1) {
            jogadaValida = this.tratarJogada(this.owner.getMesa().getJogador().getMao());
            atual = this.owner.getMesa().getJogador();
        } else {
            jogadaValida = this.tratarJogada(this.owner.getMesa().getAdversario().getMao());
            atual = this.owner.getMesa().getAdversario();
        }
        if(jogadaValida){
            this.owner.getMesa().trocaUltimoJogadorQueSoltouCarta(atual);
            this.atualizaTelaPosJogada(this.owner.getMesa());
            this.verificaEstadoPartida();
        }
    }

    public void solicitacaoPularJogada() {
        Jogador ultimoAJogar = this.owner.getMesa().getUltimoJogadorQueSoltouCarta();
        Jogador atual = this.owner.getOrdem() == 1 ? this.owner.getMesa().getJogador() : this.owner.getMesa().getAdversario();
        if(ultimoAJogar == atual){
            this.owner.getMesa().getCartasMesa().clear();
            this.telaMesa.informarResultado(Constantes.GANHADOR_JOGADA);
            if(this.owner.getOrdem() == 1){
                this.telaMesa.bloqueiaMesa("jogador", this.owner.getMesa().getJogador().getMao().size());
            } else {
                this.telaMesa.bloqueiaMesa("adversario", this.owner.getMesa().getAdversario().getMao().size());
            }            
            atualizaTelaPosJogada(this.owner.getMesa());
        } else {
            this.owner.setDaVez(false);
            this.atualizaTelaPosJogada(this.owner.getMesa());
            this.verificaEstadoPartida();  
        }
    }

    public void cartaSelecionadaPos(int posicao) {
        if (this.owner.getOrdem() == 1) {
            List<Carta> mao = this.owner.getMesa().getJogador().getMao();
            this.clickCarta(mao, posicao);
        } else if (this.owner.getOrdem() == 2) {
            List<Carta> mao = this.owner.getMesa().getAdversario().getMao();
            this.clickCarta(mao, posicao);
        }
    }

    public void atualizaTelaPosJogada(Mesa mesa) {
        if (this.owner.getOrdem() == 1) {
            this.telaMesa.trocaVez("jogador");
            ArrayList<Carta> cartasJogador = mesa.getJogador().getMao();
            int cartasAdversario = mesa.getAdversario().getMao().size();
            ArrayList<Carta> cartasMesa = mesa.getCartasMesa();
            this.telaMesa.atualizaTelaJogador(cartasJogador, cartasAdversario, cartasMesa);
            if(this.owner.getMesa().getJogador() == this.owner.getMesa().getPresidente()){
                this.telaMesa.trocaPresidente("jogador");
            }
            else if(this.owner.getMesa().getPresidente() != null){
                this.telaMesa.trocaPresidente("adversario");
            }
        } else {
            this.telaMesa.trocaVez("adversario");
            int cartasJogador = mesa.getJogador().getMao().size();
            ArrayList<Carta> cartasAdversario = mesa.getAdversario().getMao();
            ArrayList<Carta> cartasMesa = mesa.getCartasMesa();
            this.telaMesa.atualizaTelaAdversario(cartasJogador, cartasAdversario, cartasMesa);
            if(this.owner.getMesa().getAdversario() == this.owner.getMesa().getPresidente()){
                this.telaMesa.trocaPresidente("adversario");
            }
            else if(this.owner.getMesa().getPresidente() != null){
                this.telaMesa.trocaPresidente("jogador");
            }
        }
    }

    public void atualizaNomeJogador(String jogador, String nome) {
        if (jogador.toLowerCase().equals("jogador")) {
            this.telaMesa.trocaNomeJogador(nome);
            this.telaMesa.aumentaVitoria("jogador", 0);
        } else {
            this.telaMesa.trocaNomeAdversario(nome);
            this.telaMesa.aumentaVitoria("adversario", 0);
        }
    }
    
    public void mostraBotoes(){
        this.telaMesa.inicia();
    }

    public void bloqueiaTelaJogador(int ordem){
        if(ordem == 1){
            this.telaMesa.bloqueiaMesa("jogador", this.owner.getMesa().getJogador().getMao().size());
            this.telaMesa.trocaVez("adversario");
        } else {
            this.telaMesa.bloqueiaMesa("adversario", this.owner.getMesa().getAdversario().getMao().size());
            this.telaMesa.trocaVez("jogador");
        }
    }
    
    public void mudaQuantidadeVitoriasJogador(int vitorias, String jogador){
        this.telaMesa.aumentaVitoria(jogador, vitorias);
    }

    private void verificaEstadoPartida() {
        ArrayList<Carta> maoAVerificar;
        Jogador player;
        String jogador;
        if(this.owner.getOrdem() == 1){
            player = this.owner.getMesa().getJogador();
            maoAVerificar = player.getMao();  
            jogador = "jogador";
        }
        else{
            player = this.owner.getMesa().getAdversario();
            maoAVerificar = player.getMao();
            jogador = "adversario";
        }
        if(maoAVerificar.isEmpty()){
            this.owner.addVitoria();
            mudaQuantidadeVitoriasJogador(this.owner.getVitorias(), jogador);
            if(this.owner.getVitorias() < 3){
                this.owner.getMesa().setVencedorUltimaRodada(player);
                this.owner.iniciaNovaRodada();
            }
            else{
                this.owner.getMesa().setVencedor(player);
            }
        }
        else{
            this.owner.enviarJogada();
        }
    }
}
