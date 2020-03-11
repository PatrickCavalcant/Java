package com.ifg.freecell;

import java.util.Random;

/**
 *Classe Baralho que cria o baralho com seus metodos e tambêm o embaralha ja o 
 * deixando preparado para o jogo. 
 * @author Patrick Cavalcante Moraes
 * @author Wasller Luduvico Meireles Souza
 */
public class Baralho {

    private Pilha primeiraPilha;
    private Pilha segundaPilha;
    private Pilha terceiraPilha;
    private Pilha quartaPilha;
    private Pilha quintaPilha;
    private Pilha sextaPilha;
    private Pilha setimaPilha;
    private Pilha oitavaPilha;

    private Pilha pilhaPrincipal1;
    private Pilha pilhaPrincipal2;
    private Pilha pilhaPrincipal3;
    private Pilha pilhaPrincipal4;

    private Pilha espaco1;
    private Pilha espaco2;
    private Pilha espaco3;
    private Pilha espaco4;

/** Metodo construtor do baralho inicia todas as pilhas e coloca tamanho 
 *  1 nos espaços.
 * 
 */
    public Baralho() {
        this.primeiraPilha = new Pilha();
        this.segundaPilha = new Pilha();
        this.terceiraPilha = new Pilha();
        this.quartaPilha = new Pilha();
        this.quintaPilha = new Pilha();
        this.sextaPilha = new Pilha();
        this.setimaPilha = new Pilha();
        this.oitavaPilha = new Pilha();
        this.pilhaPrincipal1 = new Pilha();
        this.pilhaPrincipal2 = new Pilha();
        this.pilhaPrincipal3 = new Pilha();
        this.pilhaPrincipal4 = new Pilha();
        this.espaco1 = new Pilha(1);
        this.espaco2 = new Pilha(1);
        this.espaco3 = new Pilha(1);
        this.espaco4 = new Pilha(1);
    }

/** Metodo para gerar uma lista que contenha as cartas e colocar no baralho, 
 * instancia todas as cartas as numerando de 1 a 13 para cada nipe,
 * sendo 1 == A e o 13 == K.
 * 
 * @return Baralho
 */
    private static Lista gerarBaralho() {
        Lista baralho = new Lista();
        Object[] carta;

//        Colocando todas as cartas de Paus no baralho
        carta = new Object[]{"Paus", 1};
        baralho.inserir(carta);
        carta = new Object[]{"Paus", 2};
        baralho.inserir(carta);
        carta = new Object[]{"Paus", 3};
        baralho.inserir(carta);
        carta = new Object[]{"Paus", 4};
        baralho.inserir(carta);
        carta = new Object[]{"Paus", 5};
        baralho.inserir(carta);
        carta = new Object[]{"Paus", 6};
        baralho.inserir(carta);
        carta = new Object[]{"Paus", 7};
        baralho.inserir(carta);
        carta = new Object[]{"Paus", 8};
        baralho.inserir(carta);
        carta = new Object[]{"Paus", 9};
        baralho.inserir(carta);
        carta = new Object[]{"Paus", 10};
        baralho.inserir(carta);
        carta = new Object[]{"Paus", 11};
        baralho.inserir(carta);
        carta = new Object[]{"Paus", 12};
        baralho.inserir(carta);
        carta = new Object[]{"Paus", 13};
        baralho.inserir(carta);

//        Colocando todas as cartas de Copas no baralho
        carta = new Object[]{"Copas", 1};
        baralho.inserir(carta);
        carta = new Object[]{"Copas", 2};
        baralho.inserir(carta);
        carta = new Object[]{"Copas", 3};
        baralho.inserir(carta);
        carta = new Object[]{"Copas", 4};
        baralho.inserir(carta);
        carta = new Object[]{"Copas", 5};
        baralho.inserir(carta);
        carta = new Object[]{"Copas", 6};
        baralho.inserir(carta);
        carta = new Object[]{"Copas", 7};
        baralho.inserir(carta);
        carta = new Object[]{"Copas", 8};
        baralho.inserir(carta);
        carta = new Object[]{"Copas", 9};
        baralho.inserir(carta);
        carta = new Object[]{"Copas", 10};
        baralho.inserir(carta);
        carta = new Object[]{"Copas", 11};
        baralho.inserir(carta);
        carta = new Object[]{"Copas", 12};
        baralho.inserir(carta);
        carta = new Object[]{"Copas", 13};
        baralho.inserir(carta);

//        Colocando todas as cartas de Espadas no baralho
        carta = new Object[]{"Espadas", 1};
        baralho.inserir(carta);
        carta = new Object[]{"Espadas", 2};
        baralho.inserir(carta);
        carta = new Object[]{"Espadas", 3};
        baralho.inserir(carta);
        carta = new Object[]{"Espadas", 4};
        baralho.inserir(carta);
        carta = new Object[]{"Espadas", 5};
        baralho.inserir(carta);
        carta = new Object[]{"Espadas", 6};
        baralho.inserir(carta);
        carta = new Object[]{"Espadas", 7};
        baralho.inserir(carta);
        carta = new Object[]{"Espadas", 8};
        baralho.inserir(carta);
        carta = new Object[]{"Espadas", 9};
        baralho.inserir(carta);
        carta = new Object[]{"Espadas", 10};
        baralho.inserir(carta);
        carta = new Object[]{"Espadas", 11};
        baralho.inserir(carta);
        carta = new Object[]{"Espadas", 12};
        baralho.inserir(carta);
        carta = new Object[]{"Espadas", 13};
        baralho.inserir(carta);

//        Colocando todas as cartas de Ouros no baralho
        carta = new Object[]{"Ouros", 1};
        baralho.inserir(carta);
        carta = new Object[]{"Ouros", 2};
        baralho.inserir(carta);
        carta = new Object[]{"Ouros", 3};
        baralho.inserir(carta);
        carta = new Object[]{"Ouros", 4};
        baralho.inserir(carta);
        carta = new Object[]{"Ouros", 5};
        baralho.inserir(carta);
        carta = new Object[]{"Ouros", 6};
        baralho.inserir(carta);
        carta = new Object[]{"Ouros", 7};
        baralho.inserir(carta);
        carta = new Object[]{"Ouros", 8};
        baralho.inserir(carta);
        carta = new Object[]{"Ouros", 9};
        baralho.inserir(carta);
        carta = new Object[]{"Ouros", 10};
        baralho.inserir(carta);
        carta = new Object[]{"Ouros", 11};
        baralho.inserir(carta);
        carta = new Object[]{"Ouros", 12};
        baralho.inserir(carta);
        carta = new Object[]{"Ouros", 13};
        baralho.inserir(carta);
//        'A', '1', '2', '3', '4', '5', '6', '7', '8', '9','J', 'Q', 'K'
        return baralho;
    }

/** Metodo que embaralha as cartas de forma que ela pega a lista do baralho e 
 * aleatoriamenta vai reorganizando-a em pilhas aleatorias, ou seja, embaralha as
 * cartas. 
 */
    public void embaralhar() {
        Lista baralho = gerarBaralho();

        Random rand = new Random();

        int tamanho = baralho.size();
        int numeroRand;

        for (int i = 0; i < 7; i++) {
            numeroRand = rand.nextInt(tamanho);
            tamanho--;
            getPrimeiraPilha().push((Object[]) baralho.procurarRemove(numeroRand));
            numeroRand = rand.nextInt(tamanho);
            tamanho--;
            segundaPilha.push((Object[]) baralho.procurarRemove(numeroRand));
            numeroRand = rand.nextInt(tamanho);
            tamanho--;
            terceiraPilha.push((Object[]) baralho.procurarRemove(numeroRand));
            numeroRand = rand.nextInt(tamanho);
            tamanho--;
            quartaPilha.push((Object[]) baralho.procurarRemove(numeroRand));
            if (i < 6 || tamanho != 0) {
                numeroRand = rand.nextInt(tamanho);
                tamanho--;
                quintaPilha.push((Object[]) baralho.procurarRemove(numeroRand));
                numeroRand = rand.nextInt(tamanho);
                tamanho--;
                sextaPilha.push((Object[]) baralho.procurarRemove(numeroRand));
                numeroRand = rand.nextInt(tamanho);
                tamanho--;
                setimaPilha.push((Object[]) baralho.procurarRemove(numeroRand));
                numeroRand = rand.nextInt(tamanho);
                tamanho--;
                oitavaPilha.push((Object[]) baralho.procurarRemove(numeroRand));
            }
        }

    }
    /**
     * Metodo GET
     * @return primeiraPilha;
     */
    
    public Pilha getPrimeiraPilha() {
        return primeiraPilha;
    }
/**
     * Metodo GET
     * @return segundaPilha;
     */
    public Pilha getSegundaPilha() {
        return segundaPilha;
    }
/**
     * Metodo GET
     * @return terceiraPilha;
     */
    public Pilha getTerceiraPilha() {
        return terceiraPilha;
    }
/**
     * Metodo GET
     * @return quartaPilha;
     */
    public Pilha getQuartaPilha() {
        return quartaPilha;
    }
/**
     * Metodo GET
     * @return quintaPilha;
     */
    public Pilha getQuintaPilha() {
        return quintaPilha;
    }
/**
     * Metodo GET
     * @return sextaPilha;
     */
    public Pilha getSextaPilha() {
        return sextaPilha;
    }
/**
     * Metodo GET
     * @return setimaPilha;
     */
    public Pilha getSetimaPilha() {
        return setimaPilha;
    }
/**
     * Metodo GET
     * @return oitavaPilha;
     */
    public Pilha getOitavaPilha() {
        return oitavaPilha;
    }
/**
     * Metodo GET
     * @return pilhaPrincipal1;
     */
    public Pilha getPilhaPrincipal1() {
        return pilhaPrincipal1;
    }
/**
     * Metodo GET
     * @return pilhaPrincipal2;
     */
    public Pilha getPilhaPrincipal2() {
        return pilhaPrincipal2;
    }
/**
     * Metodo GET
     * @return pilhaPrincipal3;
     */
    public Pilha getPilhaPrincipal3() {
        return pilhaPrincipal3;
    }
/**
     * Metodo GET
     * @return pilhaPrincipal4;
     */
    public Pilha getPilhaPrincipal4() {
        return pilhaPrincipal4;
    }
    /**
     * Metodo GET
     * @return espaco1;
     */
    public Pilha getEspaco1() {
        return espaco1;
    }
    /**
     * Metodo GET
     * @return espaco2;
     */

    public Pilha getEspaco2() {
        return espaco2;
    }
    /**
     * Metodo GET
     * @return espaco3;
     */

    public Pilha getEspaco3() {
        return espaco3;
    }
    /**
     * Metodo GET
     * @return espaco4
     */

    public Pilha getEspaco4() {
        return espaco4;
    }
}
