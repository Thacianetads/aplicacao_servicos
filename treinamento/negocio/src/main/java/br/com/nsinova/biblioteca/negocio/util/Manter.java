package main.java.br.com.nsinova.biblioteca.negocio.util;

import main.java.br.com.nsinova.biblioteca.negocio.interfaces.IManter;
import main.java.br.com.nsinova.conexao.bd.Conexao;

public abstract class Manter{
     public static <K, T> K persist(T t, IManter<T, K> iManter, 
        Conexao conexao) throws Exception {
        boolean emTransacao = conexao.emTransacao();
        try{
            
            if(!emTransacao){
                conexao.inicializarTransacao();
            }
            
            K k = iManter.persist(t);
            
            if(!emTransacao){
                conexao.confirmarTransacao();
            }
            
            return k;
        }catch(Exception ex){
            if(!emTransacao){
                conexao.reverterTransacao();
            }
            throw ex;
        }
    }
}
