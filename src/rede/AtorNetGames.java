/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rede;

import br.ufsc.inf.Controller.Controlador;
import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lucas
 */
public class AtorNetGames implements OuvidorProxy {

    protected Controlador owner;
    protected Proxy proxy;
    private static final long serialVersionUID = 1L;

    public AtorNetGames(Controlador controlador) {
        //super();
        this.owner = controlador;
        this.proxy = Proxy.getInstance();
        this.proxy.addOuvinte(this);

    }

    public boolean conectar(String nomeJogador, String servidor) {

        try {
            this.proxy.conectar(servidor, nomeJogador);
        } catch (NaoPossivelConectarException | ArquivoMultiplayerException
                | JahConectadoException ex) {
            return false;
        }
        return true;
    }
    
    public boolean desconectar() {
        
        try {
            this.proxy.desconectar();
        } catch (NaoConectadoException ex) {
            return false;
        }        
        return true;
    }

    @Override
    public void iniciarNovaPartida(Integer ordem) {
        this.owner.iniciarNovaPartida(ordem);
    }

    @Override
    public void finalizarPartidaComErro(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void receberMensagem(String msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void receberJogada(Jogada jogada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void tratarConexaoPerdida() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void tratarPartidaNaoIniciada(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean iniciarPartida() {
        try {
            this.proxy.iniciarPartida(2);
        } catch (NaoConectadoException ex) {
            return false;
        }
        return true;
    }

    public String obterNomeAdversario(int ordemAdversario) {
        return this.proxy.obterNomeAdversario(ordemAdversario);
    }

}
