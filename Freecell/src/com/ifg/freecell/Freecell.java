package com.ifg.freecell;

import javax.swing.JOptionPane;

/**
 *Classe principal contendo o frame do programa onde e implementada a interface 
 * e todos os metodos para que a interface funcione perfeitamente.
 * @author Patrick Cavalcante Moraes
 * @author Wasller Luduvico Meireles Souza
 * 
 */
public class Freecell extends javax.swing.JFrame {

    /**
     * Creates new form Freecell
     */
    private Baralho baralho;

    public Freecell() {
        initComponents();
        novoJogo();
    }

/** 
 * Metodo para criar um novo jogo.
 * 
 */
    private void novoJogo() {
        baralho = new Baralho();
        baralho.embaralhar();
        bRetirarEspaco1.setEnabled(false);
        bRetirarEspaco2.setEnabled(false);
        bRetirarEspaco3.setEnabled(false);
        bRetirarEspaco4.setEnabled(false);
        atualizar();
    }

/** 
 * Metodo para atualizar as pilhas.
 * 
 */
    private void atualizar() {
        if (venceu()) {
            JOptionPane.showMessageDialog(this, "Parabéns!\nVocê venceu!");
        }
        txtPilha1.setText(baralho.getPrimeiraPilha().getCartas());
        txtPilha2.setText(baralho.getSegundaPilha().getCartas());
        txtPilha3.setText(baralho.getTerceiraPilha().getCartas());
        txtPilha4.setText(baralho.getQuartaPilha().getCartas());
        txtPilha5.setText(baralho.getQuintaPilha().getCartas());
        txtPilha6.setText(baralho.getSextaPilha().getCartas());
        txtPilha7.setText(baralho.getSetimaPilha().getCartas());
        txtPilha8.setText(baralho.getOitavaPilha().getCartas());
        txtPilhaBase1.setText(baralho.getPilhaPrincipal1().getTopo());
        txtPilhaBase2.setText(baralho.getPilhaPrincipal2().getTopo());
        txtPilhaBase3.setText(baralho.getPilhaPrincipal3().getTopo());
        txtPilhaBase4.setText(baralho.getPilhaPrincipal4().getTopo());
        txtEspaco1.setText(baralho.getEspaco1().getTopo());
        txtEspaco2.setText(baralho.getEspaco2().getTopo());
        txtEspaco3.setText(baralho.getEspaco3().getTopo());
        txtEspaco4.setText(baralho.getEspaco4().getTopo());
    }
/** Metodo para verificar se o jogador venceu.
 * 
 * @return True se o jogador vencer, false caso contrario.
 */
    private boolean venceu() {
        if (baralho.getPilhaPrincipal1().isEmpty() && baralho.getPilhaPrincipal2().isEmpty()
                && baralho.getPilhaPrincipal3().isEmpty() && baralho.getPilhaPrincipal4().isEmpty()) {
            return false;
        } else if ((Integer) baralho.getPilhaPrincipal1().top()[1] == 13
                && (Integer) baralho.getPilhaPrincipal2().top()[1] == 13
                && (Integer) baralho.getPilhaPrincipal3().top()[1] == 13
                && (Integer) baralho.getPilhaPrincipal4().top()[1] == 13) {

            return true;
        }
        return false;
    }

/** Metodo para receber qual pilha o jogador quer colocar a carta.
 * 
 * @param opcao
 * @param carta 
 */
    private void mudarCarta(String opcao, Pilha carta) {
        switch (opcao) {
            case "Pilha 1":
                carta.mudarDePilha(baralho.getPrimeiraPilha());
                break;
            case "Pilha 2":
                carta.mudarDePilha(baralho.getSegundaPilha());
                break;
            case "Pilha 3":
                carta.mudarDePilha(baralho.getTerceiraPilha());
                break;
            case "Pilha 4":
                carta.mudarDePilha(baralho.getQuartaPilha());
                break;
            case "Pilha 5":
                carta.mudarDePilha(baralho.getQuintaPilha());
                break;
            case "Pilha 6":
                carta.mudarDePilha(baralho.getSextaPilha());
                break;
            case "Pilha 7":
                carta.mudarDePilha(baralho.getSetimaPilha());
                break;
            case "Pilha 8":
                carta.mudarDePilha(baralho.getOitavaPilha());
                break;
            case "Pilha Principal 1":
                baralho.getPilhaPrincipal1().inserirPilhaPrincipal(carta);
                break;
            case "Pilha Principal 2":
                baralho.getPilhaPrincipal2().inserirPilhaPrincipal(carta);
                break;
            case "Pilha Principal 3":
                baralho.getPilhaPrincipal3().inserirPilhaPrincipal(carta);
                break;
            case "Pilha Principal 4":
                baralho.getPilhaPrincipal4().inserirPilhaPrincipal(carta);
                break;
        }
    }
/**
 * Metodo para mover a carta para a pilha principal.
 * @param opcao
 * @param pilha 
 */
    private void colocarPilhaPrincipal(String opcao, Pilha pilha) {
        switch (opcao) {
            case "Pilha Principal 1":
                baralho.getPilhaPrincipal1().inserirPilhaPrincipal(pilha);
                break;
            case "Pilha Principal 2":
                baralho.getPilhaPrincipal2().inserirPilhaPrincipal(pilha);
                break;
            case "Pilha Principal 3":
                baralho.getPilhaPrincipal3().inserirPilhaPrincipal(pilha);
                break;
            case "Pilha Principal 4":
                baralho.getPilhaPrincipal4().inserirPilhaPrincipal(pilha);
                break;
        }
    }
/**
 * Metodo para mover a carta para o espaço reserva se ele estiver livre.
 * @param opcao
 * @param pilha 
 */
    private void colocarEspacoLivre(String opcao, Pilha pilha) {
        switch (opcao) {
            case "Espaço 1":
                pilha.inserirEspacoPilha(baralho.getEspaco1());
                bRetirarEspaco1.setEnabled(true);
                break;
            case "Espaço 2":
                pilha.inserirEspacoPilha(baralho.getEspaco2());
                bRetirarEspaco2.setEnabled(true);
                break;
            case "Espaço 3":
                pilha.inserirEspacoPilha(baralho.getEspaco3());
                bRetirarEspaco3.setEnabled(true);
                break;
            case "Espaço 4":
                pilha.inserirEspacoPilha(baralho.getEspaco4());
                bRetirarEspaco4.setEnabled(true);
                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        pEspaco1 = new javax.swing.JPanel();
        txtEspaco1 = new javax.swing.JLabel();
        pEspaco2 = new javax.swing.JPanel();
        txtEspaco2 = new javax.swing.JLabel();
        pEspaco4 = new javax.swing.JPanel();
        txtEspaco4 = new javax.swing.JLabel();
        pEspaco3 = new javax.swing.JPanel();
        txtEspaco3 = new javax.swing.JLabel();
        pPilha1 = new javax.swing.JPanel();
        txtPilha1 = new javax.swing.JTextArea();
        bMudarPilha1 = new javax.swing.JButton();
        pPilhaBase1 = new javax.swing.JPanel();
        txtPilhaBase1 = new javax.swing.JLabel();
        pPilhaBase2 = new javax.swing.JPanel();
        txtPilhaBase2 = new javax.swing.JLabel();
        pPilhaBase4 = new javax.swing.JPanel();
        txtPilhaBase4 = new javax.swing.JLabel();
        pPilhaBase3 = new javax.swing.JPanel();
        txtPilhaBase3 = new javax.swing.JLabel();
        bMudarPilha2 = new javax.swing.JButton();
        pPilha2 = new javax.swing.JPanel();
        txtPilha2 = new javax.swing.JTextArea();
        bMudarPilha3 = new javax.swing.JButton();
        pPilha3 = new javax.swing.JPanel();
        txtPilha3 = new javax.swing.JTextArea();
        pPilha4 = new javax.swing.JPanel();
        txtPilha4 = new javax.swing.JTextArea();
        bMudarPilha4 = new javax.swing.JButton();
        pPilha5 = new javax.swing.JPanel();
        txtPilha5 = new javax.swing.JTextArea();
        bMudarPilha5 = new javax.swing.JButton();
        pPilha6 = new javax.swing.JPanel();
        txtPilha6 = new javax.swing.JTextArea();
        bMudarPilha6 = new javax.swing.JButton();
        pPilha7 = new javax.swing.JPanel();
        txtPilha7 = new javax.swing.JTextArea();
        bMudarPilha7 = new javax.swing.JButton();
        pPilha8 = new javax.swing.JPanel();
        txtPilha8 = new javax.swing.JTextArea();
        bMudarPilha8 = new javax.swing.JButton();
        bRetirarEspaco1 = new javax.swing.JButton();
        bRetirarEspaco2 = new javax.swing.JButton();
        bRetirarEspaco3 = new javax.swing.JButton();
        bRetirarEspaco4 = new javax.swing.JButton();
        jMenuBar = new javax.swing.JMenuBar();
        mJogo = new javax.swing.JMenu();
        miNovoJogo = new javax.swing.JMenuItem();
        miSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Freecell");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(945, 500));

        jPanel.setBackground(new java.awt.Color(0, 0, 255));

        pEspaco1.setBackground(new java.awt.Color(0, 102, 255));
        pEspaco1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 238), 2, true));

        javax.swing.GroupLayout pEspaco1Layout = new javax.swing.GroupLayout(pEspaco1);
        pEspaco1.setLayout(pEspaco1Layout);
        pEspaco1Layout.setHorizontalGroup(
            pEspaco1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEspaco1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtEspaco1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pEspaco1Layout.setVerticalGroup(
            pEspaco1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEspaco1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtEspaco1, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                .addContainerGap())
        );

        pEspaco2.setBackground(new java.awt.Color(0, 102, 255));
        pEspaco2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(253, 245, 245), 2, true));

        javax.swing.GroupLayout pEspaco2Layout = new javax.swing.GroupLayout(pEspaco2);
        pEspaco2.setLayout(pEspaco2Layout);
        pEspaco2Layout.setHorizontalGroup(
            pEspaco2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEspaco2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtEspaco2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pEspaco2Layout.setVerticalGroup(
            pEspaco2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEspaco2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtEspaco2, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                .addContainerGap())
        );

        pEspaco4.setBackground(new java.awt.Color(0, 102, 255));
        pEspaco4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 238), 2, true));

        javax.swing.GroupLayout pEspaco4Layout = new javax.swing.GroupLayout(pEspaco4);
        pEspaco4.setLayout(pEspaco4Layout);
        pEspaco4Layout.setHorizontalGroup(
            pEspaco4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEspaco4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtEspaco4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pEspaco4Layout.setVerticalGroup(
            pEspaco4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEspaco4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtEspaco4, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                .addContainerGap())
        );

        pEspaco3.setBackground(new java.awt.Color(0, 102, 255));
        pEspaco3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 238), 2, true));

        javax.swing.GroupLayout pEspaco3Layout = new javax.swing.GroupLayout(pEspaco3);
        pEspaco3.setLayout(pEspaco3Layout);
        pEspaco3Layout.setHorizontalGroup(
            pEspaco3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEspaco3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtEspaco3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pEspaco3Layout.setVerticalGroup(
            pEspaco3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pEspaco3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtEspaco3, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                .addContainerGap())
        );

        pPilha1.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 153, 0)));

        txtPilha1.setEditable(false);
        txtPilha1.setBackground(new java.awt.Color(0, 102, 255));
        txtPilha1.setColumns(20);
        txtPilha1.setRows(5);

        javax.swing.GroupLayout pPilha1Layout = new javax.swing.GroupLayout(pPilha1);
        pPilha1.setLayout(pPilha1Layout);
        pPilha1Layout.setHorizontalGroup(
            pPilha1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPilha1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        pPilha1Layout.setVerticalGroup(
            pPilha1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPilha1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );

        bMudarPilha1.setText("Mover");
        bMudarPilha1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMudarPilha1ActionPerformed(evt);
            }
        });

        pPilhaBase1.setBackground(new java.awt.Color(0, 102, 255));
        pPilhaBase1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 238), 2, true));

        javax.swing.GroupLayout pPilhaBase1Layout = new javax.swing.GroupLayout(pPilhaBase1);
        pPilhaBase1.setLayout(pPilhaBase1Layout);
        pPilhaBase1Layout.setHorizontalGroup(
            pPilhaBase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPilhaBase1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPilhaBase1, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );
        pPilhaBase1Layout.setVerticalGroup(
            pPilhaBase1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPilhaBase1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPilhaBase1, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                .addContainerGap())
        );

        pPilhaBase2.setBackground(new java.awt.Color(0, 102, 255));
        pPilhaBase2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(253, 245, 245), 2, true));

        javax.swing.GroupLayout pPilhaBase2Layout = new javax.swing.GroupLayout(pPilhaBase2);
        pPilhaBase2.setLayout(pPilhaBase2Layout);
        pPilhaBase2Layout.setHorizontalGroup(
            pPilhaBase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPilhaBase2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPilhaBase2, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );
        pPilhaBase2Layout.setVerticalGroup(
            pPilhaBase2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPilhaBase2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPilhaBase2, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                .addContainerGap())
        );

        pPilhaBase4.setBackground(new java.awt.Color(0, 102, 255));
        pPilhaBase4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 238), 2, true));

        javax.swing.GroupLayout pPilhaBase4Layout = new javax.swing.GroupLayout(pPilhaBase4);
        pPilhaBase4.setLayout(pPilhaBase4Layout);
        pPilhaBase4Layout.setHorizontalGroup(
            pPilhaBase4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPilhaBase4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPilhaBase4, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );
        pPilhaBase4Layout.setVerticalGroup(
            pPilhaBase4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPilhaBase4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPilhaBase4, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                .addContainerGap())
        );

        pPilhaBase3.setBackground(new java.awt.Color(0, 102, 255));
        pPilhaBase3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(238, 238, 238), 2, true));

        javax.swing.GroupLayout pPilhaBase3Layout = new javax.swing.GroupLayout(pPilhaBase3);
        pPilhaBase3.setLayout(pPilhaBase3Layout);
        pPilhaBase3Layout.setHorizontalGroup(
            pPilhaBase3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPilhaBase3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPilhaBase3, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );
        pPilhaBase3Layout.setVerticalGroup(
            pPilhaBase3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pPilhaBase3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtPilhaBase3, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                .addContainerGap())
        );

        bMudarPilha2.setText("Mover");
        bMudarPilha2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMudarPilha2ActionPerformed(evt);
            }
        });

        pPilha2.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 153, 0)));

        txtPilha2.setBackground(new java.awt.Color(0, 102, 255));
        txtPilha2.setColumns(20);
        txtPilha2.setRows(5);

        javax.swing.GroupLayout pPilha2Layout = new javax.swing.GroupLayout(pPilha2);
        pPilha2.setLayout(pPilha2Layout);
        pPilha2Layout.setHorizontalGroup(
            pPilha2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPilha2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        pPilha2Layout.setVerticalGroup(
            pPilha2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPilha2, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );

        bMudarPilha3.setText("Mover");
        bMudarPilha3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMudarPilha3ActionPerformed(evt);
            }
        });

        pPilha3.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 153, 0)));

        txtPilha3.setEditable(false);
        txtPilha3.setBackground(new java.awt.Color(0, 102, 255));
        txtPilha3.setColumns(20);
        txtPilha3.setRows(5);

        javax.swing.GroupLayout pPilha3Layout = new javax.swing.GroupLayout(pPilha3);
        pPilha3.setLayout(pPilha3Layout);
        pPilha3Layout.setHorizontalGroup(
            pPilha3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPilha3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        pPilha3Layout.setVerticalGroup(
            pPilha3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPilha3, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );

        pPilha4.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 153, 0)));

        txtPilha4.setEditable(false);
        txtPilha4.setBackground(new java.awt.Color(0, 102, 255));
        txtPilha4.setColumns(20);
        txtPilha4.setRows(5);

        javax.swing.GroupLayout pPilha4Layout = new javax.swing.GroupLayout(pPilha4);
        pPilha4.setLayout(pPilha4Layout);
        pPilha4Layout.setHorizontalGroup(
            pPilha4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPilha4, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        pPilha4Layout.setVerticalGroup(
            pPilha4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPilha4, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );

        bMudarPilha4.setText("Mover");
        bMudarPilha4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMudarPilha4ActionPerformed(evt);
            }
        });

        pPilha5.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 153, 0)));

        txtPilha5.setEditable(false);
        txtPilha5.setBackground(new java.awt.Color(0, 102, 255));
        txtPilha5.setColumns(20);
        txtPilha5.setRows(5);

        javax.swing.GroupLayout pPilha5Layout = new javax.swing.GroupLayout(pPilha5);
        pPilha5.setLayout(pPilha5Layout);
        pPilha5Layout.setHorizontalGroup(
            pPilha5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPilha5, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        pPilha5Layout.setVerticalGroup(
            pPilha5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPilha5, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );

        bMudarPilha5.setText("Mover");
        bMudarPilha5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMudarPilha5ActionPerformed(evt);
            }
        });

        pPilha6.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 153, 0)));

        txtPilha6.setBackground(new java.awt.Color(0, 102, 255));
        txtPilha6.setColumns(20);
        txtPilha6.setRows(5);

        javax.swing.GroupLayout pPilha6Layout = new javax.swing.GroupLayout(pPilha6);
        pPilha6.setLayout(pPilha6Layout);
        pPilha6Layout.setHorizontalGroup(
            pPilha6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPilha6, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        pPilha6Layout.setVerticalGroup(
            pPilha6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPilha6, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );

        bMudarPilha6.setText("Mover");
        bMudarPilha6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMudarPilha6ActionPerformed(evt);
            }
        });

        pPilha7.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 153, 0)));

        txtPilha7.setEditable(false);
        txtPilha7.setBackground(new java.awt.Color(0, 102, 255));
        txtPilha7.setColumns(20);
        txtPilha7.setRows(5);

        javax.swing.GroupLayout pPilha7Layout = new javax.swing.GroupLayout(pPilha7);
        pPilha7.setLayout(pPilha7Layout);
        pPilha7Layout.setHorizontalGroup(
            pPilha7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPilha7, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        pPilha7Layout.setVerticalGroup(
            pPilha7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPilha7, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );

        bMudarPilha7.setText("Mover");
        bMudarPilha7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMudarPilha7ActionPerformed(evt);
            }
        });

        pPilha8.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 153, 0)));

        txtPilha8.setEditable(false);
        txtPilha8.setBackground(new java.awt.Color(0, 102, 255));
        txtPilha8.setColumns(20);
        txtPilha8.setRows(5);

        javax.swing.GroupLayout pPilha8Layout = new javax.swing.GroupLayout(pPilha8);
        pPilha8.setLayout(pPilha8Layout);
        pPilha8Layout.setHorizontalGroup(
            pPilha8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPilha8, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );
        pPilha8Layout.setVerticalGroup(
            pPilha8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPilha8, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );

        bMudarPilha8.setText("Mover");
        bMudarPilha8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMudarPilha8ActionPerformed(evt);
            }
        });

        bRetirarEspaco1.setText("Retirar");
        bRetirarEspaco1.setEnabled(false);
        bRetirarEspaco1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRetirarEspaco1ActionPerformed(evt);
            }
        });

        bRetirarEspaco2.setText("Retirar");
        bRetirarEspaco2.setEnabled(false);
        bRetirarEspaco2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRetirarEspaco2ActionPerformed(evt);
            }
        });

        bRetirarEspaco3.setText("Retirar");
        bRetirarEspaco3.setEnabled(false);
        bRetirarEspaco3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRetirarEspaco3ActionPerformed(evt);
            }
        });

        bRetirarEspaco4.setText("Retirar");
        bRetirarEspaco4.setEnabled(false);
        bRetirarEspaco4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRetirarEspaco4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bMudarPilha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pPilha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bMudarPilha2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pPilha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bMudarPilha3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pPilha3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bMudarPilha4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pPilha4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bMudarPilha5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pPilha5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bMudarPilha6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pPilha6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bMudarPilha7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pPilha7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bMudarPilha8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pPilha8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bRetirarEspaco1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(pEspaco1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pEspaco2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bRetirarEspaco2, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pEspaco3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bRetirarEspaco3, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pEspaco4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bRetirarEspaco4, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pPilhaBase1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pPilhaBase2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pPilhaBase3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pPilhaBase4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bRetirarEspaco1)
                    .addComponent(bRetirarEspaco2)
                    .addComponent(bRetirarEspaco3)
                    .addComponent(bRetirarEspaco4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pEspaco4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pEspaco3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pEspaco2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pEspaco1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pPilhaBase4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pPilhaBase3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pPilhaBase2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pPilhaBase1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(bMudarPilha8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pPilha8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(bMudarPilha7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pPilha7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(bMudarPilha6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pPilha6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(bMudarPilha5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pPilha5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(bMudarPilha4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pPilha4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(bMudarPilha3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pPilha3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(bMudarPilha1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pPilha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(bMudarPilha2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pPilha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mJogo.setText("Jogo");

        miNovoJogo.setText("Novo Jogo");
        miNovoJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNovoJogoActionPerformed(evt);
            }
        });
        mJogo.add(miNovoJogo);

        miSair.setText("Sair");
        miSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSairActionPerformed(evt);
            }
        });
        mJogo.add(miSair);

        jMenuBar.add(mJogo);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * Botão que muda as cartas de pilha.
 * @param evt 
 */
    private void bMudarPilha1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMudarPilha1ActionPerformed
        if (!baralho.getPrimeiraPilha().isEmpty()) {
            Object[] opcao = {"Mover para outra pilha", "Mover para reserva", "Mover para principal"};

            String[] escolha;
            int resp = JOptionPane.showOptionDialog(this, "O que deseja fazer?",
                    "Freecell", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);
            if (resp == JOptionPane.YES_OPTION) {
                escolha = new String[]{"Pilha 2", "Pilha 3", "Pilha 4", "Pilha 5", "Pilha 6", "Pilha 7", "Pilha 8"};
                Object resp2 = JOptionPane.showInputDialog(this, "Escolha a pilha onde quer colocar a carta!",
                        "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
                if (resp2 != null) {
                    mudarCarta(resp2.toString(), baralho.getPrimeiraPilha());
                }
            } else if (resp == JOptionPane.NO_OPTION) {
                escolha = new String[]{"Espaço 1", "Espaço 2", "Espaço 3", "Espaço 4"};
                Object resp2 = JOptionPane.showInputDialog(this, "Escolha o espaço para guardar a carta!",
                        "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
                if (resp2 != null) {
                    colocarEspacoLivre(resp2.toString(), baralho.getPrimeiraPilha());
                }
            } else if (resp == JOptionPane.CANCEL_OPTION) {
                escolha = new String[]{"Pilha Principal 1", "Pilha Principal 2", "Pilha Principal 3", "Pilha Principal 4"};
                Object resp2 = JOptionPane.showInputDialog(this, "Escolha uma pilha base!",
                        "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
                if (resp2 != null) {
                    colocarPilhaPrincipal(resp2.toString(), baralho.getPrimeiraPilha());
                }
            }
            atualizar();
        }
    }//GEN-LAST:event_bMudarPilha1ActionPerformed
/**
 * Botão que muda as cartas de pilha.
 * @param evt 
 */
    private void bMudarPilha2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMudarPilha2ActionPerformed
        if (!baralho.getSegundaPilha().isEmpty()) {
            Object[] opcao = {"Mover para outra pilha", "Mover para reserva", "Mover para principal"};

            String[] escolha;
            int resp = JOptionPane.showOptionDialog(this, "O que deseja fazer?",
                    "Freecell", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);
            if (resp == JOptionPane.YES_OPTION) {
                escolha = new String[]{"Pilha 1", "Pilha 3", "Pilha 4", "Pilha 5", "Pilha 6", "Pilha 7", "Pilha 8"};
                Object resp2 = JOptionPane.showInputDialog(this, "Escolha a pilha onde quer colocar a carta!",
                        "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
                if (resp2 != null) {
                    mudarCarta(resp2.toString(), baralho.getSegundaPilha());
                }
            } else if (resp == JOptionPane.NO_OPTION) {
                escolha = new String[]{"Espaço 1", "Espaço 2", "Espaço 3", "Espaço 4"};
                Object resp2 = JOptionPane.showInputDialog(this, "Escolha o espaço para guardar a carta!",
                        "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
                if (resp2 != null) {
                    colocarEspacoLivre(resp2.toString(), baralho.getSegundaPilha());
                }
            } else if (resp == JOptionPane.CANCEL_OPTION) {
                escolha = new String[]{"Pilha Principal 1", "Pilha Principal 2", "Pilha Principal 3", "Pilha Principal 4"};
                Object resp2 = JOptionPane.showInputDialog(this, "Escolha uma pilha base!",
                        "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
                if (resp2 != null) {
                    colocarPilhaPrincipal(resp2.toString(), baralho.getSegundaPilha());
                }
            }
            atualizar();
        }
    }//GEN-LAST:event_bMudarPilha2ActionPerformed
/**
 * Botão que muda as cartas de pilha.
 * @param evt 
 */
    private void bMudarPilha3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMudarPilha3ActionPerformed
        if (!baralho.getTerceiraPilha().isEmpty()) {
            Object[] opcao = {"Mover para outra pilha", "Mover para reserva", "Mover para principal"};

            String[] escolha;
            int resp = JOptionPane.showOptionDialog(this, "O que deseja fazer?",
                    "Freecell", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);
            if (resp == JOptionPane.YES_OPTION) {
                escolha = new String[]{"Pilha 1", "Pilha 2", "Pilha 4", "Pilha 5", "Pilha 6", "Pilha 7", "Pilha 8"};
                Object resp2 = JOptionPane.showInputDialog(this, "Escolha a pilha onde quer colocar a carta!",
                        "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
                if (resp2 != null) {
                    mudarCarta(resp2.toString(), baralho.getTerceiraPilha());
                }
            } else if (resp == JOptionPane.NO_OPTION) {
                escolha = new String[]{"Espaço 1", "Espaço 2", "Espaço 3", "Espaço 4"};
                Object resp2 = JOptionPane.showInputDialog(this, "Escolha o espaço para guardar a carta!",
                        "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
                if (resp2 != null) {
                    colocarEspacoLivre(resp2.toString(), baralho.getTerceiraPilha());
                }
            } else if (resp == JOptionPane.CANCEL_OPTION) {
                escolha = new String[]{"Pilha Principal 1", "Pilha Principal 2", "Pilha Principal 3", "Pilha Principal 4"};
                Object resp2 = JOptionPane.showInputDialog(this, "Escolha uma pilha base!",
                        "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
                if (resp2 != null) {
                    colocarPilhaPrincipal(resp2.toString(), baralho.getTerceiraPilha());
                }
            }
            atualizar();
        }
    }//GEN-LAST:event_bMudarPilha3ActionPerformed
/**
 * Botão que muda as cartas de pilha.
 * @param evt 
 */
    private void bMudarPilha4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMudarPilha4ActionPerformed
        if (!baralho.getQuartaPilha().isEmpty()) {
            Object[] opcao = {"Mover para outra pilha", "Mover para reserva", "Mover para principal"};

            String[] escolha;
            int resp = JOptionPane.showOptionDialog(this, "O que deseja fazer?",
                    "Freecell", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);
            if (resp == JOptionPane.YES_OPTION) {
                escolha = new String[]{"Pilha 1", "Pilha 2", "Pilha 3", "Pilha 5", "Pilha 6", "Pilha 7", "Pilha 8"};
                Object resp2 = JOptionPane.showInputDialog(this, "Escolha a pilha onde quer colocar a carta!",
                        "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
                if (resp2 != null) {
                    mudarCarta(resp2.toString(), baralho.getQuartaPilha());
                }
            } else if (resp == JOptionPane.NO_OPTION) {
                escolha = new String[]{"Espaço 1", "Espaço 2", "Espaço 3", "Espaço 4"};
                Object resp2 = JOptionPane.showInputDialog(this, "Escolha o espaço para guardar a carta!",
                        "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
                if (resp2 != null) {
                    colocarEspacoLivre(resp2.toString(), baralho.getQuartaPilha());
                }
            } else if (resp == JOptionPane.CANCEL_OPTION) {
                escolha = new String[]{"Pilha Principal 1", "Pilha Principal 2", "Pilha Principal 3", "Pilha Principal 4"};
                Object resp2 = JOptionPane.showInputDialog(this, "Escolha uma pilha base!",
                        "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
                if (resp2 != null) {
                    colocarPilhaPrincipal(resp2.toString(), baralho.getQuartaPilha());
                }
            }
            atualizar();
        }
    }//GEN-LAST:event_bMudarPilha4ActionPerformed
/**
 * Botão que muda as cartas de pilha.
 * @param evt 
 */
    private void bMudarPilha5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMudarPilha5ActionPerformed
        if (!baralho.getQuintaPilha().isEmpty()) {
            Object[] opcao = {"Mover para outra pilha", "Mover para reserva", "Mover para principal"};

            String[] escolha;
            int resp = JOptionPane.showOptionDialog(this, "O que deseja fazer?",
                    "Freecell", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);
            if (resp == JOptionPane.YES_OPTION) {
                escolha = new String[]{"Pilha 1", "Pilha 2", "Pilha 3", "Pilha 4", "Pilha 6", "Pilha 7", "Pilha 8"};
                Object resp2 = JOptionPane.showInputDialog(this, "Escolha a pilha onde quer colocar a carta!",
                        "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
                if (resp2 != null) {
                    mudarCarta(resp2.toString(), baralho.getQuintaPilha());
                }
            } else if (resp == JOptionPane.NO_OPTION) {
                escolha = new String[]{"Espaço 1", "Espaço 2", "Espaço 3", "Espaço 4"};
                Object resp2 = JOptionPane.showInputDialog(this, "Escolha o espaço para guardar a carta!",
                        "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
                if (resp2 != null) {
                    colocarEspacoLivre(resp2.toString(), baralho.getQuintaPilha());
                }
            } else if (resp == JOptionPane.CANCEL_OPTION) {
                escolha = new String[]{"Pilha Principal 1", "Pilha Principal 2", "Pilha Principal 3", "Pilha Principal 4"};
                Object resp2 = JOptionPane.showInputDialog(this, "Escolha uma pilha base!",
                        "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
                if (resp2 != null) {
                    colocarPilhaPrincipal(resp2.toString(), baralho.getQuintaPilha());
                }
            }
            atualizar();
        }
    }//GEN-LAST:event_bMudarPilha5ActionPerformed
/**
 * Botão que muda as cartas de pilha.
 * @param evt 
 */
    private void bMudarPilha6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMudarPilha6ActionPerformed
        if (!baralho.getSextaPilha().isEmpty()) {
            Object[] opcao = {"Mover para outra pilha", "Mover para reserva", "Mover para principal"};

            String[] escolha;
            int resp = JOptionPane.showOptionDialog(this, "O que deseja fazer?",
                    "Freecell", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);
            if (resp == JOptionPane.YES_OPTION) {
                escolha = new String[]{"Pilha 1", "Pilha 2", "Pilha 3", "Pilha 4", "Pilha 5", "Pilha 7", "Pilha 8"};
                Object resp2 = JOptionPane.showInputDialog(this, "Escolha a pilha onde quer colocar a carta!",
                        "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
                if (resp2 != null) {
                    mudarCarta(resp2.toString(), baralho.getSextaPilha());
                }
            } else if (resp == JOptionPane.NO_OPTION) {
                escolha = new String[]{"Espaço 1", "Espaço 2", "Espaço 3", "Espaço 4"};
                Object resp2 = JOptionPane.showInputDialog(this, "Escolha o espaço para guardar a carta!",
                        "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
                if (resp2 != null) {
                    colocarEspacoLivre(resp2.toString(), baralho.getSextaPilha());
                }
            } else if (resp == JOptionPane.CANCEL_OPTION) {
                escolha = new String[]{"Pilha Principal 1", "Pilha Principal 2", "Pilha Principal 3", "Pilha Principal 4"};
                Object resp2 = JOptionPane.showInputDialog(this, "Escolha uma pilha base!",
                        "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
                if (resp2 != null) {
                    colocarPilhaPrincipal(resp2.toString(), baralho.getSextaPilha());
                }
            }
            atualizar();
        }
    }//GEN-LAST:event_bMudarPilha6ActionPerformed
/**
 * Botão que muda as cartas de pilha.
 * @param evt 
 */
    private void bMudarPilha7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMudarPilha7ActionPerformed
        if (!baralho.getSetimaPilha().isEmpty()) {
            Object[] opcao = {"Mover para outra pilha", "Mover para reserva", "Mover para principal"};

            String[] escolha;
            int resp = JOptionPane.showOptionDialog(this, "O que deseja fazer?",
                    "Freecell", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);
            if (resp == JOptionPane.YES_OPTION) {
                escolha = new String[]{"Pilha 1", "Pilha 2", "Pilha 3", "Pilha 4", "Pilha 5", "Pilha 6", "Pilha 8"};
                Object resp2 = JOptionPane.showInputDialog(this, "Escolha a pilha onde quer colocar a carta!",
                        "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
                if (resp2 != null) {
                    mudarCarta(resp2.toString(), baralho.getSetimaPilha());
                }
            } else if (resp == JOptionPane.NO_OPTION) {
                escolha = new String[]{"Espaço 1", "Espaço 2", "Espaço 3", "Espaço 4"};
                Object resp2 = JOptionPane.showInputDialog(this, "Escolha o espaço para guardar a carta!",
                        "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
                if (resp2 != null) {
                    colocarEspacoLivre(resp2.toString(), baralho.getSetimaPilha());
                }
            } else if (resp == JOptionPane.CANCEL_OPTION) {
                escolha = new String[]{"Pilha Principal 1", "Pilha Principal 2", "Pilha Principal 3", "Pilha Principal 4"};
                Object resp2 = JOptionPane.showInputDialog(this, "Escolha uma pilha base!",
                        "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
                if (resp2 != null) {
                    colocarPilhaPrincipal(resp2.toString(), baralho.getSetimaPilha());
                }
            }
            atualizar();
        }
    }//GEN-LAST:event_bMudarPilha7ActionPerformed
/**
 * Botão que muda as cartas de pilha.
 * @param evt 
 */
    private void bMudarPilha8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMudarPilha8ActionPerformed
        if (!baralho.getOitavaPilha().isEmpty()) {
            Object[] opcao = {"Mover para outra pilha", "Mover para reserva", "Mover para principal"};

            String[] escolha;
            int resp = JOptionPane.showOptionDialog(this, "O que deseja fazer?",
                    "Freecell", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcao, opcao[0]);
            if (resp == JOptionPane.YES_OPTION) {
                escolha = new String[]{"Pilha 1", "Pilha 2", "Pilha 3", "Pilha 4", "Pilha 5", "Pilha 6", "Pilha 7"};
                Object resp2 = JOptionPane.showInputDialog(this, "Escolha a pilha onde quer colocar a carta!",
                        "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
                if (resp2 != null) {
                    mudarCarta(resp2.toString(), baralho.getOitavaPilha());
                }
            } else if (resp == JOptionPane.NO_OPTION) {
                escolha = new String[]{"Espaço 1", "Espaço 2", "Espaço 3", "Espaço 4"};
                Object resp2 = JOptionPane.showInputDialog(this, "Escolha o espaço para guardar a carta!",
                        "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
                if (resp2 != null) {
                    colocarEspacoLivre(resp2.toString(), baralho.getOitavaPilha());
                }
            } else if (resp == JOptionPane.CANCEL_OPTION) {
                escolha = new String[]{"Pilha Principal 1", "Pilha Principal 2", "Pilha Principal 3", "Pilha Principal 4"};
                Object resp2 = JOptionPane.showInputDialog(this, "Escolha uma pilha base!",
                        "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
                if (resp2 != null) {
                    colocarPilhaPrincipal(resp2.toString(), baralho.getOitavaPilha());
                }
            }
            atualizar();
        }
    }//GEN-LAST:event_bMudarPilha8ActionPerformed
/**
 * Botão que retira a carta do espaço livre.
 * @param evt 
 */
    private void bRetirarEspaco1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRetirarEspaco1ActionPerformed
        String[] escolha = new String[]{"Pilha 1", "Pilha 2", "Pilha 3", "Pilha 4",
            "Pilha 5", "Pilha 6", "Pilha 7", "Pilha 8", "Pilha Principal 1", "Pilha Principal 2", "Pilha Principal 3", "Pilha Principal 4"};
        Object resp2 = JOptionPane.showInputDialog(this, "Escolha a pilha onde quer colocar a carta!",
                "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
        if (resp2 != null) {
            mudarCarta(resp2.toString(), baralho.getEspaco1());
            if (baralho.getEspaco1().isEmpty()) {
                bRetirarEspaco1.setEnabled(false);
            }
            atualizar();
        }
    }//GEN-LAST:event_bRetirarEspaco1ActionPerformed
/**
 * Botão que retira a carta do espaço livre.
 * @param evt 
 */
    private void bRetirarEspaco2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRetirarEspaco2ActionPerformed
        String[] escolha = new String[]{"Pilha 1", "Pilha 2", "Pilha 3", "Pilha 4", "Pilha 5", "Pilha 6",
            "Pilha 7", "Pilha 8", "Pilha Principal 1", "Pilha Principal 2", "Pilha Principal 3", "Pilha Principal 4"};
        Object resp2 = JOptionPane.showInputDialog(this, "Escolha a pilha onde quer colocar a carta!",
                "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
        if (resp2 != null) {
            mudarCarta(resp2.toString(), baralho.getEspaco2());
            if (baralho.getEspaco2().isEmpty()) {
                bRetirarEspaco2.setEnabled(false);
            }
            atualizar();
        }
    }//GEN-LAST:event_bRetirarEspaco2ActionPerformed
/**
 * Botão que retira a carta do espaço livre.
 * @param evt 
 */
    private void bRetirarEspaco3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRetirarEspaco3ActionPerformed
        String[] escolha = new String[]{"Pilha 1", "Pilha 2", "Pilha 3", "Pilha 4", "Pilha 5", "Pilha 6",
            "Pilha 7", "Pilha 8", "Pilha Principal 1", "Pilha Principal 2", "Pilha Principal 3", "Pilha Principal 4"};
        Object resp2 = JOptionPane.showInputDialog(this, "Escolha a pilha onde quer colocar a carta!",
                "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
        if (resp2 != null) {
            mudarCarta(resp2.toString(), baralho.getEspaco3());
            if (baralho.getEspaco3().isEmpty()) {
                bRetirarEspaco3.setEnabled(false);
            }
            atualizar();
        }
    }//GEN-LAST:event_bRetirarEspaco3ActionPerformed
/**
 * Botão que retira a carta do espaço livre.
 * @param evt 
 */
    private void bRetirarEspaco4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRetirarEspaco4ActionPerformed
        String[] escolha = new String[]{"Pilha 1", "Pilha 2", "Pilha 3", "Pilha 4", "Pilha 5", "Pilha 6",
            "Pilha 7", "Pilha 8", "Pilha Principal 1", "Pilha Principal 2", "Pilha Principal 3", "Pilha Principal 4"};
        Object resp2 = JOptionPane.showInputDialog(this, "Escolha a pilha onde quer colocar a carta!",
                "Freecell", JOptionPane.PLAIN_MESSAGE, null, escolha, escolha[0]);
        if (resp2 != null) {
            mudarCarta(resp2.toString(), baralho.getEspaco4());
            if (baralho.getEspaco4().isEmpty()) {
                bRetirarEspaco4.setEnabled(false);
            }
            atualizar();
        }
    }//GEN-LAST:event_bRetirarEspaco4ActionPerformed
/**
 * Reiniciar o jogo.
 * @param evt 
 */
    private void miNovoJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNovoJogoActionPerformed
        novoJogo();
    }//GEN-LAST:event_miNovoJogoActionPerformed
/** 
 * Sair do jogo.
 * @param evt 
 */
    private void miSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSairActionPerformed
        fechar();
    }//GEN-LAST:event_miSairActionPerformed

    private void fechar() {
        if (javax.swing.JOptionPane.showConfirmDialog(null, "Deseja sair do programa?", "ATENÇÃO ", javax.swing.JOptionPane.YES_NO_OPTION) == 0) {
            dispose();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Freecell.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Freecell.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Freecell.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Freecell.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Freecell().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bMudarPilha1;
    private javax.swing.JButton bMudarPilha2;
    private javax.swing.JButton bMudarPilha3;
    private javax.swing.JButton bMudarPilha4;
    private javax.swing.JButton bMudarPilha5;
    private javax.swing.JButton bMudarPilha6;
    private javax.swing.JButton bMudarPilha7;
    private javax.swing.JButton bMudarPilha8;
    private javax.swing.JButton bRetirarEspaco1;
    private javax.swing.JButton bRetirarEspaco2;
    private javax.swing.JButton bRetirarEspaco3;
    private javax.swing.JButton bRetirarEspaco4;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JPanel jPanel;
    private javax.swing.JMenu mJogo;
    private javax.swing.JMenuItem miNovoJogo;
    private javax.swing.JMenuItem miSair;
    private javax.swing.JPanel pEspaco1;
    private javax.swing.JPanel pEspaco2;
    private javax.swing.JPanel pEspaco3;
    private javax.swing.JPanel pEspaco4;
    private javax.swing.JPanel pPilha1;
    private javax.swing.JPanel pPilha2;
    private javax.swing.JPanel pPilha3;
    private javax.swing.JPanel pPilha4;
    private javax.swing.JPanel pPilha5;
    private javax.swing.JPanel pPilha6;
    private javax.swing.JPanel pPilha7;
    private javax.swing.JPanel pPilha8;
    private javax.swing.JPanel pPilhaBase1;
    private javax.swing.JPanel pPilhaBase2;
    private javax.swing.JPanel pPilhaBase3;
    private javax.swing.JPanel pPilhaBase4;
    private javax.swing.JLabel txtEspaco1;
    private javax.swing.JLabel txtEspaco2;
    private javax.swing.JLabel txtEspaco3;
    private javax.swing.JLabel txtEspaco4;
    private javax.swing.JTextArea txtPilha1;
    private javax.swing.JTextArea txtPilha2;
    private javax.swing.JTextArea txtPilha3;
    private javax.swing.JTextArea txtPilha4;
    private javax.swing.JTextArea txtPilha5;
    private javax.swing.JTextArea txtPilha6;
    private javax.swing.JTextArea txtPilha7;
    private javax.swing.JTextArea txtPilha8;
    private javax.swing.JLabel txtPilhaBase1;
    private javax.swing.JLabel txtPilhaBase2;
    private javax.swing.JLabel txtPilhaBase3;
    private javax.swing.JLabel txtPilhaBase4;
    // End of variables declaration//GEN-END:variables
}
