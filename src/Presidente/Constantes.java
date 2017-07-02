package Presidente;

import br.ufsc.inf.leobr.cliente.Cliente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Lucas Corrêa, Thiago Pauli
 */
public class Constantes {

    //---------CONFIG
    public static final int QUANTIDADE_CARTAS_INICIO = 10;
    //---------CONFIG    

    //---------Numericos
    public static final int CONEXAO_EXITO = 0;
    public static final int CONEXAO_FALHOU = 1;
    public static final int JA_CONECTADO = 2;
    public static final int DESCONEXAO_EXITO = 3;
    public static final int DESCONEXAO_FALHOU = 4;
    public static final int JA_DESCONECTADO = 5;
    public static final int FALTA_CONEXAO = 6;
    public static final int JOGO_EM_ANDAMENTO = 7;
    public static final int INICIAR_PARTIDA_FALHOU = 8;
    public static final int SOLICITADO_INICIO_PARTIDA = 9;
    public static final int JOGADA_INVALIDA = 12;
    public static final int VOCE_GANHOU_RODADA = 13;
    public static final int VOCE_PERDEU_RODADA = 14;
    public static final int VOCE_TEM_CARTAS_SELECIONADAS = 15;
    public static final int VOCE_NAO_TEM_CARTAS_SELECIONADAS = 16;
    public static final int GANHADOR_JOGADA = 17;
    public static final int PERDEDOR_JOGADA = 18;
    public static final int VENCEDOR_JOGO = 19;
    public static final int PERDEDOR_JOGO = 20;
    //---------Numericos
    
    //---------Strings
    public static final String CONEXAO_EXITO_STRING = "Conexao efetuada com exito";
    public static final String CONEXAO_FALHOU_STRING = "Conexao falhou";
    public static final String JA_CONECTADO_STRING = "Ja Conectado";
    public static final String DESCONEXAO_EXITO_STRING = "Desconexao efetuada com exito";
    public static final String DESCONEXAO_FALHOU_STRING = "Desconexao falhou";
    public static final String JA_DESCONECTADO_STRING = "Voce ja esta desconectado";
    public static final String FALTA_CONEXAO_STRING = "Sem conexao";
    public static final String JOGO_EM_ANDAMENTO_STRING = "O jogo esta em andamento";
    public static final String INICIAR_PARTIDA_FALHOU_STRING = "Iniciar partida falhou";
    public static final String SOLICITADO_INICIO_PARTIDA_STRING = "Foi solicitado inicio de partida ao servidor, aguarde o outro jogador";
    public static final String ENDERECO_SERVIDOR = "localhost"; //netgames.labsoft.ufsc.br
    public static final String INSIRA_ENDERECO_SERVIDOR = "Insira o endereco do servidor";
    public static final String INSIRA_NOME_JOGADOR = "Insira o seu nome";
    public static final String IMAGE_PATH = "/br/ufsc/inf/view/imgs/";
    public static final String JOGADA_INVALIDA_STRING = "Jogada invalida.";
    public static final String VOCE_GANHOU_RODADA_STRING = "Parabêns! Você ganhou a rodada.";
    public static final String VOCE_PERDEU_RODADA_STRING = "Que azar, você perdeu a rodada.";
    public static final String VOCE_TEM_CARTAS_SELECIONADAS_STRING = "Você tem cartas selecionadas. Para pular a jogada você não pode ter nenhuma carta selecionada.";
    public static final String VOCE_NAO_TEM_CARTAS_SELECIONADAS_STRING = "Você não selecionou nenhuma carta.";
    public static final String GANHADOR_JOGADA_STRING = "Você ganhou a jogada. Parabêns!";
    public static final String PERDEDOR_JOGADA_STRING = "Você perdeu a jogada. :(";
    public static final String VENCEDOR_JOGO_STRING = "PARABÊNS!!! Você ganhou o jogo!";
    public static final String PERDEDOR_JOGO_STRING = "Parece que você não teve sorte dessa vez. Você perdeu o jogo.";
    
    //---------Strings
    
    
    
    
}
