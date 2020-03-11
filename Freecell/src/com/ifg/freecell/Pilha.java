package com.ifg.freecell;

import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;


/**
 *Classe construtora da pilha com os metodos da pilha fornecidos pelo java e mais 
 * alguns outros metodos que facilitarão na manipulação do trabalho.
 * @author Patrick Cavalcante Moraes
 * @author Wasller Luduvico Meireles Souza
 * @see java.util.Stack
 */
public class Pilha {


    private int topo;
    private Object[] baralho;

/** 
 * Construtor sem setar o tamanho.
 * 
 */
    public Pilha() {
        baralho = new Object[25];
        topo = -1;
    }
    
/** 
 * Construtor setando o tamanho
 * @param tamanho
 */
    public Pilha(int tamanho) {
        baralho = new Object[tamanho];
        topo = -1;
    }
/**
 * Testa se esta pilha está vazia.
 * @return true se e somente se esta pilha não contiver itens, se não e false.
 */
    public boolean isEmpty() {
        return (topo == -1);
    }
/**
 * Testa se esta pilha está cheia.
 * @return true se e somente se esta pilha estiver cheia, se não e false.
 */
    public boolean isFull() {
        return (topo == baralho.length);
    }

/** retorna a carta (sem remover) da posição i. 
 * @param i
 * @return A carta desejada
 */
    public Object[] getCarta(int i) {
        Object[] carta;
        if (baralho[i] == null) {
            return null;
        }
        carta = (Object[]) baralho[i];

        return carta;
    }

    /**
     * Adiciona um elemento na pilha, sempre no topo da pilha.
     * @param carta 
     */
    public void push(Object[] carta) {
        if (!isFull()) {
            topo++;
            baralho[topo] = carta;
        } else {
            JOptionPane.showMessageDialog(null, "Pilha Cheia!");
        }
    }
/**
 * Remove o objeto no topo desta pilha e retorna esse objeto como o valor dessa 
 * função.
 * @return O objeto que estava no topo da pilha.
 */
    public Object[] pop() {
        Object x[] = (Object[]) baralho[topo];
        baralho[topo] = null;
        topo--;
        return x;
    }
/**
 * Retorna o objeto que esta no topo da pilha sem tirar ele de dentro da pilha.
 * @return O objeto que esta no topo da pilha.
 */
    public Object[] top() {
        if (topo == -1) {
            return null;
        } else {
            return (Object[]) baralho[topo];
        }
    }
/**
 * Retorna o tamanho da pilha.
 * @return O tamanho da pilha.
 */
    public int size() {
        return topo + 1;
    }
    
/** Metodo para inserir no espaço livre (recebe uma pilha).
 * @param pilha 
 */
    public void inserirEspaco(Pilha pilha) {
        Object[] carta = pilha.top();
        if (isEmpty()) {
            push(carta);
            pilha.pop();
        } else {
            JOptionPane.showMessageDialog(null, "ERRO \n Esse espaço so pode armazenar uma carta por vez", "Erro", ERROR_MESSAGE);
        }
    }
    
/**
 * Metodo para inserir no espaço livre (recebe um espaço).
 * @param espaco 
 */
public void inserirEspacoPilha(Pilha espaco) {
        if (espaco.isEmpty()) {
            espaco.push(pop());
        } else {
           JOptionPane.showMessageDialog(null, "ERRO"
                   + "\n Deve respeitar a ordem decrescente e ainda duas cartas adjacentes não devem ter a mesma cor: preta (paus e espada)" +
                        "e vermelha (ouro e copas).", "Erro", ERROR_MESSAGE);
        }
    }
       
/**
 * Metodo para inserir uma carta na pilha principal. 
 * @param pilha 
 */
    public void inserirPilhaPrincipal(Pilha pilha) {
        Object[] carta = pilha.top();
        if (top() == null) {
            if ((Integer) carta[1] == 1) {
                push(carta);
                pilha.pop();
            } else {
              JOptionPane.showMessageDialog(null, "ERRO \n A ordem das cartas devem ser crescentes e começar pela carta As(1)", "Erro", ERROR_MESSAGE); 
            }
        } else {
            if (top()[0].toString().equals(carta[0].toString())
                    && ((Integer) top()[1] + 1) == (Integer) carta[1]) {
                push(carta);
                pilha.pop();
            } else {
                JOptionPane.showMessageDialog(null, "ERRO", "Erro", ERROR_MESSAGE);
            }
        }

    }

/** 
 * Metodo para analizar se a cor do naipe das duas cartas são inversos.
 * @param naipeCarta
 * @param naipeTopo
 * @return Se eles forem inversos retorna true, se nao false.
 */
    private boolean corInversa(String naipeCarta, String naipeTopo) {
        if ("Ouros".equals(naipeCarta) || "Copas".equals(naipeCarta)) {
            if ("Espadas".equals(naipeTopo) || "Paus".equals(naipeTopo)) {
                return true;
            }
        } else {
            if ("Ouros".equals(naipeTopo) || "Copas".equals(naipeTopo)) {
                return true;
            }
        }
        return false;
    }

/**
 * Metodo para mudar uma carta de pilha.
 * 
 * @param nova 
 */
    public void mudarDePilha(Pilha nova) {
        Object[] carta = top();
        Object[] cartaTopo = nova.top();
        if (nova.isEmpty()) {
            nova.push(pop());
        } else if (corInversa(carta[0].toString(), cartaTopo[0].toString())) {
            if (((Integer) carta[1] + 1) == (Integer) cartaTopo[1]) {
                nova.push(pop());
            } else {
                JOptionPane.showMessageDialog(null, "ERRO"
                   + "\n Deve respeitar a ordem decrescente e ainda duas cartas adjacentes não devem ter a mesma cor: preta (paus e espada)" +
                        "e vermelha (ouro e copas).", "Erro", ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "ERRO"
                   + "\n Deve respeitar a ordem decrescente e ainda duas cartas adjacentes não devem ter a mesma cor: preta (paus e espada)" +
                        "e vermelha (ouro e copas).", "Erro", ERROR_MESSAGE);
        }
    }

/**
 * Metodo para retornar a carta do topo.
 * 
 * @return Retorna a carta do topo da pilha caso ela não esteja vazia.
 */
    public String getTopo() {
        if (topo > -1) {
            return getCarta(topo)[0] + " " + getCarta(topo)[1];
        } else {
            return null;
        }

    }

/**Metodo para retornar todas as cartas.
 * 
 * @return Retorna as cartas.
 */
    public String getCartas() {
        String cartas = null;
        for (int i = 0; i < baralho.length; i++) {
            if (baralho[i] == null) {
                break;
            }
            if (cartas == null) {
                cartas = getCarta(i)[0] + " " + getCarta(i)[1] + "\n";
            } else {
                cartas += (getCarta(i)[0] + " " + getCarta(i)[1] + "\n");
            }
        }
        return cartas;
    }

/**
 * Metodo para imprimir todas as cartas.
 * 
 */
    public void imprime() {
        for (int i = 0; i < baralho.length; i++) {
            if (baralho[i] == null) {
                break;
            }
            System.out.print(getCarta(i)[0] + " " + getCarta(i)[1] + " -\t ");
        }
        System.out.println();
    }
}
