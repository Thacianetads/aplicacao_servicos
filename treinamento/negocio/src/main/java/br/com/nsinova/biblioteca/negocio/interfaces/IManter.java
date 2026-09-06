package main.java.br.com.nsinova.biblioteca.negocio.interfaces;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
/**
 *
 * @author Administrador
 * @param <T>
 * @param <K>
 */
public interface IManter<T, K> {
    
    /**
     *  Interface funcional 
     *  que insere/altera/deleta informações 
     *  do Banco de dados.
     *  Recebe objeto do tipo T e retorna
     *  objeto do tipo K.
     * @param t
     * @return
     */
    public K persist(T t); 
    
}
