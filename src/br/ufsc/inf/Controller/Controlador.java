/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.inf.Controller;

import Presidente.Constantes;
import br.ufsc.inf.Model.Carta;
import br.ufsc.inf.Model.Jogador;
import br.ufsc.inf.Model.Mesa;
import br.ufsc.inf.View.AtorJogador;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rede.AtorNetGames;

/**
 * @author Lucas Corrêa, Thiago Pauli
 */
public class Controlador {

    protected AtorJogador atorJogador;
    protected AtorNetGames atorNetGames;
    protected Jogador jogador;
    protected Jogador adversario;
    protected Mesa mesa;
    protected int ordem = 0;
    protected int ordemAdversario;
    protected boolean conectado;
    protected boolean jogoEmAndamento;
    protected boolean daVez = false;
    protected boolean primeiraJogada = true;
    protected int vitorias = 0;

    public Controlador() {
        this.mesa = new Mesa();
        this.conectado = false;
        this.jogoEmAndamento = false;
        this.atorJogador = new AtorJogador(this);
        this.atorNetGames = new AtorNetGames(this);
        this.atorJogador.mostraInterface();
    }

    /**
     * Método para conectar
     *
     * @return int
     */
    public int conectar() {
        if (this.conectado) {
            return Constantes.JA_CONECTADO;
        } else {
            String servidor = this.atorJogador.obterNomeServidor();
            String nomeJogador = this.atorJogador.obterNomeJogador();
            this.jogador = new Jogador(nomeJogador);
            this.conectado = this.atorNetGames.conectar(nomeJogador, servidor);
            if (this.conectado) {
                return Constantes.CONEXAO_EXITO;
            } else {
                return Constantes.CONEXAO_FALHOU;
            }
        }
    }

    /**
     * Método para desconectar
     *
     * @return int
     */
    public int desconectar() {
        if (this.conectado) {
            boolean desconectado = this.atorNetGames.desconectar();
            if (desconectado) {
                this.conectado = false;
                return Constantes.DESCONEXAO_EXITO;
            } else {
                return Constantes.DESCONEXAO_FALHOU;
            }
        } else {
            return Constantes.JA_DESCONECTADO;
        }
    }

    /**
     * Método para iniciar a partida
     *
     * @return int
     */
    public int iniciarPartida() {
        if (this.conectado) {
            if (this.jogoEmAndamento) {
                return Constantes.JOGO_EM_ANDAMENTO;
            } else {
                boolean iniciada = this.atorNetGames.iniciarPartida();
                if (iniciada) {
                    return Constantes.SOLICITADO_INICIO_PARTIDA;
                } else {
                    return Constantes.INICIAR_PARTIDA_FALHOU;
                }
            }
        } else {
            return Constantes.FALTA_CONEXAO;
        }
    }

    /**
     * Método para iniciar nova partida
     *
     * @param ordem Integer - Ordem dos jogadores.
     */
    public void iniciarNovaPartida(Integer ordem) {
        this.limpar();
        this.setOrdens(ordem);
        String nomeAdversario = this.atorNetGames.obterNomeAdversario(this.ordemAdversario);
        if (this.ordem == 1) {
            this.daVez = true;
            this.adversario = new Jogador(nomeAdversario);
            this.atorJogador.informarNomeAdversario(this.adversario.getNome());
            ArrayList<Carta> baralho = this.criaBaralho();
            baralho = this.embaralha(baralho);
            ArrayList<Carta> maoJogador1 = this.distribuiMao(this.ordem, baralho);
            ArrayList<Carta> maoJogador2 = this.distribuiMao(2, baralho);
            this.jogador.setMao(maoJogador1);
            this.adversario.setMao(maoJogador2);
            this.mesa.setJogador(this.jogador);
            this.mesa.setAdversario(this.adversario);
            this.atorNetGames.enviarJogada(this.mesa);
            this.atualizaTelaPosJogada(this.mesa);
            this.atualizaNomeJogador(Constantes.JOGADOR, this.jogador.getNome());
            this.atualizaNomeJogador(Constantes.ADVERSARIO, this.adversario.getNome());
            this.atorJogador.mostraBotoes();
        }
    }
    
    public void bloqueiaTelaJogador(int ordem){
        if(ordem == 1){
            this.atorJogador.bloqueiaMesa(Constantes.JOGADOR);
            this.atorJogador.trocaVez(Constantes.ADVERSARIO);
        } else {
            this.atorJogador.bloqueiaMesa(Constantes.ADVERSARIO);
            this.atorJogador.trocaVez(Constantes.JOGADOR);
        }
    }
    
    public void verificaEstadoPartida() {
        ArrayList<Carta> maoAVerificar;
        Jogador player;
        String jogador;
        if(this.ordem == 1){
            player = this.mesa.getJogador();
            maoAVerificar = player.getMao();  
            jogador = Constantes.JOGADOR;
        }
        else{
            player = this.mesa.getAdversario();
            maoAVerificar = player.getMao();
            jogador = Constantes.ADVERSARIO;
        }
        if(maoAVerificar.isEmpty()){
            player.aumentaRodadasGanhas();
            this.atorJogador.mudaQuantidadeVitoriasJogador(player.getRodadasGanhas(), jogador);
            if(player.getRodadasGanhas() < 3){
                this.mesa.setVencedorUltimaRodada(player);
                this.iniciaNovaRodada();
            }
            else{
                this.mesa.setVencedor(player);
                this.finalizaPartida();
            }
        }
        else{
            this.enviarJogada();
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
        if(this.mesa.getCartasMesa().size() > 0){
            if(this.mesa.getCartasMesa().size() == selecionadas.size()){
                continua = true;
            }
            else{
                //retorna jogada inválida
                this.atorJogador.informarResultado(retorno);
                return false;
            }
        }
        if (this.mesa.getCartasMesa().isEmpty() || continua){
            int valorConjunto = selecionadas.get(0).getValor();
                for (Carta carta : selecionadas) {
                    if (carta.getValor() != valorConjunto) {
                        //erro conjunto precisa ter cartas com mesmo valor
                        this.atorJogador.informarResultado(retorno);
                        return false;
                    }
                }
                int valorConjuntoMesa = this.mesa.getCartasMesa().isEmpty() ?
                        0 : this.mesa.getCartasMesa().get(0).getValor();
                if(valorConjunto > valorConjuntoMesa){
                    //jogada valida           
                    this.mesa.setCartasDaMesa(selecionadas);
                    mao.removeAll(selecionadas);
                    return true;
                }
                else{
                    //jogada invalida
                    this.atorJogador.informarResultado(retorno);
                    return false;
                }
        }
        return false;
    }
    
    public void clickCarta(List<Carta> mao, int posicao) {
        Carta cartaSelecionada = mao.get(posicao);
        if (cartaSelecionada.isSelecionada()) {
            cartaSelecionada.tiraSelecao();
        } else {
            cartaSelecionada.seleciona();
        }
    }
    
    public void solicitacaoPularJogada() {
        Jogador ultimoAJogar = this.mesa.getUltimoJogadorQueSoltouCarta();
        Jogador atual = this.ordem == 1 ? this.mesa.getJogador() : this.mesa.getAdversario();
        if(ultimoAJogar == atual){
            this.mesa.getCartasMesa().clear();
            this.atorJogador.informarResultado(Constantes.GANHADOR_JOGADA);
            if(this.ordem == 1){
                this.atorJogador.bloqueiaMesa(Constantes.JOGADOR);
            } else {
                this.atorJogador.bloqueiaMesa(Constantes.ADVERSARIO);
            }            
            this.atualizaTelaPosJogada(this.mesa);
        } else {
            this.setDaVez(false);
            this.atualizaTelaPosJogada(this.mesa);
            this.verificaEstadoPartida();  
        }
    }
    
    public void atualizaTelaPosJogada(Mesa mesa) {
        if (this.ordem == 1) {
            this.atorJogador.trocaVez(Constantes.JOGADOR);
            ArrayList<Carta> cartasJogador = mesa.getJogador().getMao();
            int cartasAdversario = mesa.getAdversario().getMao().size();
            ArrayList<Carta> cartasMesa = mesa.getCartasMesa();
            this.atorJogador.atualizaTelaJogador(cartasJogador, cartasAdversario, cartasMesa);
            if(this.mesa.getJogador() == this.mesa.getPresidente()){
                this.atorJogador.trocaPresidente(Constantes.JOGADOR);
            }
            else if(this.mesa.getPresidente() != null){
                this.atorJogador.trocaPresidente(Constantes.ADVERSARIO);
            }
        } else {
            this.atorJogador.trocaVez(Constantes.ADVERSARIO);
            int cartasJogador = mesa.getJogador().getMao().size();
            ArrayList<Carta> cartasAdversario = mesa.getAdversario().getMao();
            ArrayList<Carta> cartasMesa = mesa.getCartasMesa();
            this.atorJogador.atualizaTelaAdversario(cartasJogador, cartasAdversario, cartasMesa);
            if(this.mesa.getAdversario() == this.mesa.getPresidente()){
                this.atorJogador.trocaPresidente(Constantes.ADVERSARIO);
            }
            else if(this.mesa.getPresidente() != null){
                this.atorJogador.trocaPresidente(Constantes.JOGADOR);
            }
        }
    }
    
    public void clickPos(int posicao) {
        ArrayList<Carta> mao = null;
        if (this.ordem == 1) {
            mao = this.mesa.getJogador().getMao();
        } else if (this.ordem == 2) {
            mao = this.mesa.getAdversario().getMao();            
        }
        switch(posicao){
            case Constantes.SOLICITACAO_PULAR_VEZ:
                this.solicitacaoPularJogada();
                break;
            case Constantes.SOLICITACAO_ENVIAR_JOGADA:
                this.solicitacaoTratarJogada();
                break;
            default:
                this.clickCarta(mao, posicao);
                break;
        }
    }
    
    public void solicitacaoTratarJogada() {
        boolean jogadaValida;
        Jogador atual;
        if (this.ordem == 1) {
            jogadaValida = this.tratarJogada(this.mesa.getJogador().getMao());
            atual = this.mesa.getJogador();
        } else {
            jogadaValida = this.tratarJogada(this.mesa.getAdversario().getMao());
            atual = this.mesa.getAdversario();
        }
        if(jogadaValida){
            this.mesa.trocaUltimoJogadorQueSoltouCarta(atual);
            this.atualizaTelaPosJogada(this.mesa);
            this.verificaEstadoPartida();
        }
    }

    /**
     * Método para receber jogada
     *
     * @param mesa Mesa - Recebe a mesa inteira do outro jogador.
     */
    public void receberJogada(Mesa mesa) {
        switch (mesa.getTipoJogada()) {
            case 2:
                this.mesa = mesa;
                mesa.setTipoJogada(0);
                this.daVez = false;
                this.adversario = this.mesa.getAdversario();
                this.jogador = this.mesa.getJogador();
                this.atorJogador.mudaQuantidadeVitoriasJogador(this.mesa.getAdversario().getRodadasGanhas(), "adversario");
                this.atorJogador.mudaQuantidadeVitoriasJogador(this.mesa.getJogador().getRodadasGanhas(), "jogador");
                this.atualizaTelaPosJogada(mesa);
                this.bloqueiaTelaJogador(this.ordem);
                this.atorNetGames.enviarJogada(mesa);
                this.atorJogador.informarResultado(Constantes.VOCE_PERDEU_RODADA);
                break;
            case 1:
            case 0:
                if (ordem == 1 || !primeiraJogada) {
                    this.mesa = mesa;
                    this.daVez = true;
                    this.adversario = this.mesa.getAdversario();
                    this.jogador = this.mesa.getJogador();
                    
                    this.atualizaTelaPosJogada(mesa);
                } else {
                    this.primeiraJogada = false;
                    this.mesa = mesa;
                    this.adversario = this.mesa.getAdversario();
                    this.jogador = this.mesa.getJogador();
                    this.setOrdens(2);
                    this.atualizaTelaPosJogada(mesa);
                    this.atualizaNomeJogador(Constantes.JOGADOR, this.jogador.getNome());
                    this.atualizaNomeJogador(Constantes.ADVERSARIO, this.adversario.getNome());
                    this.bloqueiaTelaJogador(2);
                }   break;
            case 3:
                this.atorJogador.informarResultado(Constantes.PERDEDOR_JOGO);
                this.bloqueiaTelaJogador(1);
                this.bloqueiaTelaJogador(2);
                break;
            default:
                break;
        }

    }

    public void iniciaNovaRodada() {
        this.mesa.getCartasMesa().clear();
        ArrayList<Carta> baralho = this.criaBaralho();
        baralho = this.embaralha(baralho);
        ArrayList<Carta> maoJogador1 = this.distribuiMao(1, baralho);
        ArrayList<Carta> maoJogador2 = this.distribuiMao(2, baralho);
        this.jogador.setMao(maoJogador1);
        this.adversario.setMao(maoJogador2);
        this.addVitoria();
        this.mesa.setPresidente(this.mesa.getVencedorUltimaRodada());
        Jogador cu = this.mesa.getPresidente() == this.mesa.getJogador()
                ? this.mesa.getAdversario() : this.mesa.getJogador();
        this.mesa.setCu(cu);
        this.trocarCartas();
        this.mesa.setTipoJogada(2);
        this.atorNetGames.enviarJogada(this.mesa);
        this.atualizaTelaPosJogada(this.mesa);
        this.atorJogador.informarResultado(Constantes.VOCE_GANHOU_RODADA);
    }

    /**
     * Método para limpar tudo
     */
    private void limpar() {
        this.adversario = null;
        this.jogoEmAndamento = false;
        this.mesa = new Mesa();
    }

    /**
     * Método para criar baralho
     *
     * @return ArrayList<Carta> - Baralho completo com 4 naipes (A, B, C e D) e
     * 14 cartas cada naipe.
     */
    private ArrayList<Carta> criaBaralho() {
        ArrayList<Carta> baralho = new ArrayList<>();
        String[] naipes = {"A", "B", "C", "D"};
        for (int valor = 13; valor > 0; valor--) {
            for (int naipe = 0; naipe < 4; naipe++) {
                baralho.add(new Carta(valor, naipes[naipe]));
            }
        }
        return baralho;
    }

    /**
     * Método para embaralhar o baralho.
     *
     * @return List<Carta> - Baralho completo embaralhado.
     */
    private ArrayList<Carta> embaralha(ArrayList<Carta> baralho) {
        Collections.shuffle(baralho);
        return baralho;
    }

    /**
     * Método para distribuir a mão para jogador.
     *
     * @param ordem int - Ordem do jogador.
     * @param baralho List<Carta> - Baralho de cartas.
     * @return List<Carta> - Restantes das cartas do baralho (Não usadas para a
     * mão do jogador).
     */
    private ArrayList<Carta> distribuiMao(int ordem, ArrayList<Carta> baralho) {
        ArrayList<Carta> baralhoTemp = new ArrayList<>();
        if (ordem == 1) {
            for (int i = 0; i <= 9; i++) {
                baralhoTemp.add(baralho.get(i));
            }
            return baralhoTemp;
        } else {
            for (int i = 10; i <= 19; i++) {
                baralhoTemp.add(baralho.get(i));
            }
            return baralhoTemp;
        }
    }

    /**
     * Método para descobrir se é o jogador da vez.
     *
     * @return boolean - Verifica se ordem é igual a 1.
     */
    public boolean isDaVez() {
        return this.daVez;
    }

    /**
     * Método para setar a ordem dos jogadores.
     *
     * @param ordem int - Ordem dos jogadores.
     */
    private void setOrdens(int ordem) {
        this.ordem = ordem;
        this.ordemAdversario = this.ordem == 1 ? 2 : 1;
    }

    /**
     * Método para retornar ordem
     *
     * @return ordem
     */
    public int getOrdem() {
        return this.ordem;
    }

    /**
     * Método para retornar mesa
     *
     * @return mesa
     */
    public Mesa getMesa() {
        return this.mesa;
    }

    /**
     * Método para enviar jogada, antes de enviar ele bloqueia a tela do jogador
     * atual.
     */
    public void enviarJogada() {
        this.mesa.setTipoJogada(1);
        this.daVez = false;
        this.bloqueiaTelaJogador(this.ordem);
        this.atorNetGames.enviarJogada(this.mesa);
    }

    /**
     * Método para verificar vencedor.
     *
     * @param mao Mão do jogador.
     */
    public void verificaSeJogadorVenceu(ArrayList<Carta> mao) {
        if (mao.isEmpty()) {
            this.vitorias++;
        }
        if (this.vitorias == 3) {
            Jogador vencedor = this.ordem == 1 ? this.jogador : this.adversario;
            this.mesa.setVencedor(vencedor);
        }
    }

    public void addVitoria() {
        this.vitorias++;
    }

    public int getVitorias() {
        return this.vitorias;
    }

    public void setDaVez(boolean b) {
        this.daVez = false;
    }

    private void trocarCartas() {
        Jogador presidente = this.mesa.getPresidente();
        Jogador cu = this.mesa.getCu();
        ArrayList<Carta> maoPresidente = presidente.getMao();
        ArrayList<Carta> maoCu = cu.getMao();
        Carta cartaMaior = new Carta(0);
        for (Carta carta : maoCu) {
            if (carta.getValor() > cartaMaior.getValor()) {
                cartaMaior = carta;
            }
        }
        maoCu.remove(cartaMaior);
        Carta cartaMenor = new Carta(99);
        for (Carta carta : maoPresidente) {
            if (carta.getValor() < cartaMenor.getValor()) {
                cartaMenor = carta;
            }
        }
        maoPresidente.remove(cartaMenor);
        maoCu.add(cartaMenor);
        maoPresidente.add(cartaMaior);
    }
    
    public void atualizaNomeJogador(String jogador, String nome) {
        if (jogador.toLowerCase().equals(Constantes.JOGADOR)) {
            this.atorJogador.trocaNomeJogador(nome);
            this.atorJogador.aumentaVitoria(Constantes.JOGADOR, 0);
        } else {
            this.atorJogador.trocaNomeAdversario(nome);
            this.atorJogador.aumentaVitoria(Constantes.ADVERSARIO, 0);
        }
    }

    public void finalizaPartida() {        
        this.bloqueiaTelaJogador(1);
        this.bloqueiaTelaJogador(2);
        this.mesa.setTipoJogada(3);
        this.atorNetGames.enviarJogada(this.mesa);
        this.atorJogador.informarResultado(Constantes.VENCEDOR_JOGO);
    }
}
