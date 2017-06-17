/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.inf.Controller;

import Presidente.Constantes;
import br.ufsc.inf.Model.Jogador;
import br.ufsc.inf.Model.Mesa;
import br.ufsc.inf.View.AtorJogador;
import rede.AtorNetGames;

/**
 *
 * @author lucas
 */
public class Controlador {
    
    protected AtorJogador atorJogador;
    protected AtorNetGames atorNetGames;
    protected Jogador jogador;
    protected Jogador adversario;
    protected Mesa mesa;
    protected boolean conectado;
    protected boolean jogoEmAndamento;
    
    public Controlador(){
        this.mesa = new Mesa();
        this.conectado = false;
        this.jogoEmAndamento = false;
        this.atorJogador = new AtorJogador(this);
        this.atorNetGames = new AtorNetGames(this);
        
        this.atorJogador.mostraInterface();
        

    }

    public int conectar() {
        if(this.conectado){
            return Constantes.JA_CONECTADO;
        }
        else{
            String servidor = this.atorJogador.obterNomeServidor();
            String nomeJogador = this.atorJogador.obterNomeJogador();
            this.jogador = new Jogador(nomeJogador);
            this.conectado = this.atorNetGames.conectar(nomeJogador, servidor);
            if(this.conectado){
                return Constantes.CONEXAO_EXITO;
            }
            else{
                return Constantes.CONEXAO_FALHOU;
            }
        }
    }

    public int desconectar() {
        if(this.conectado){
            boolean desconectado = this.atorNetGames.desconectar();
            if(desconectado){
                return Constantes.DESCONEXAO_EXITO;
            }
            else{
                return Constantes.DESCONEXAO_FALHOU;
            }
        }
        else{
            return Constantes.JA_DESCONECTADO;
        }
    }
    
}
