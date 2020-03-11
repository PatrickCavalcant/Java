package com.ifg.freecell;

import javax.swing.text.html.parser.Element;


/**
 *Classe que cria a lista utlizada no programa com seus metodos originais e algumas 
 * implementações a mais para facilitar o codigo.
 * @author Patrick Cavalcante Moraes
 * @author Wasller Luduvico Meireles Souza
 * 
 */
public class Lista {

    private No head;
    private No last;
/**
 * classe No cria os metodos get set e o construtor do No da lista.
 */
    public final class No {

        private Object[] item;
        private No next;

        public No(Object[] item, No next) {
            this.item = item;
            this.next = next;
        }

        public Object getItem() {
            return this.item;
        }

        public No getNext() {
            return this.next;
        }

        public void setItem(Object[] item) {
            this.item = item;
        }

        public void setNext(No next) {
            this.next = next;
        }

    }
/**
 * Construtor da lista vazio.
 */
    public Lista() {

    }
/**
 * Metodo que verifica se a lista esta vazia, retornará true se esta lista não 
 * contiver elementos.
 * @return True or False
 * @see java.util.List
 */
    public boolean isEmpty() {
        return (head == null);
    }
/**
 * Metodo que insere o elemento especificado ao final desta lista.
 * @see java.util.List
 */
    public void inserir(Object[] item) {
        No tmp = new No(item, null);
        if (head == null) {
            head = tmp;
        } else {
            last.next = tmp;
        }
        last = tmp;
    }

/**
 * Insere o elemento especificado na posição especificada nesta lista.
 * @see java.util.List
 */
    public void inserir2(Object[] item, int k) {
        No novo = new No(item, null);
        No tmp = null;
        No pos = head;
        int posicao = 0;
        while (posicao < k) {
            pos = pos.getNext();
            posicao++;
        }
        if (posicao == k) {
            tmp = pos;
            pos = novo;
            pos.setNext(tmp);
        }

    }
/**
 * Remove o elemento na posição especificada nesta lista (operação opcional).
 * @param posicao
 * @return O proximo valor da fila
 * @see java.util.List
 */
    public Object procurarRemove(int posicao) {
        No filaDepois = head;
        No filaAntes = null;
        int cont = 0;
        while (cont < posicao) {
            filaAntes = filaDepois;
            filaDepois = filaDepois.next;
            cont++;
        }
        if (filaDepois == null) {
            System.err.println("Item não encontrado");
        } else {
            if (filaDepois == head) {
                head = filaDepois.next;
            } else {
                filaAntes.next = filaDepois.next;
            }
            if (filaDepois == last) {
                last = filaDepois;
            }
        }
        return filaDepois.getItem();

    }

/** 
 * Retorna o número de elementos nesta lista.
 * @return O tamanho da lista
 *  @see java.util.List
 */
    public int size() {
        No tmp = head;
        int tamanho = 0;
        while (tmp != null) {
            tamanho++;
            tmp = tmp.next;
        }
        return tamanho;
    }
}
