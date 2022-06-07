package br.com.dev.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


public class Fcalc extends javax.swing.JFrame {
	
	private List<Operador> opSuportados;
    
  
    public Fcalc() {
        initComponents();
               
        opSuportados = new ArrayList<Operador>();
        opSuportados.add(new Soma());
        opSuportados.add(new Subtracao());
        opSuportados.add(new Multiplicacao());
        opSuportados.add(new Divisao());
    }
    
    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButtonCalcular = new javax.swing.JButton();
        jTextFieldFormula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldResultado = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabelTempoExecucao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabel1.setText("Calculadora Simples");

        jLabel2.setText("F\u00f3rmula");

        jButtonCalcular.setText("Calcular");
        jButtonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalcularActionPerformed(evt);
            }
        });

        jTextFieldFormula.setText("Ex: 1 + 1 * 3");

        jLabel3.setText("Resultado");

        jTextFieldResultado.setEditable(false);

        jLabel4.setText("Executado em:");

        jLabelTempoExecucao.setFont(new java.awt.Font("Dialog", 2, 12));
        jLabelTempoExecucao.setText("0.0 ms");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldFormula, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonCalcular)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelTempoExecucao, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldFormula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCalcular)
                    .addComponent(jLabel4)
                    .addComponent(jLabelTempoExecucao))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pack();
    }

    private void jButtonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalcularActionPerformed
    	double tempoInicial = System.currentTimeMillis();
    	inicarCalculo();
    	double tempoFinal = System.currentTimeMillis() - tempoInicial;
    	jLabelTempoExecucao.setText(String.valueOf(tempoFinal) + " ms");
    }
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fcalc().setVisible(true);
            }
        });
    }
    
    private void inicarCalculo(){
    	String formula = jTextFieldFormula.getText().trim();   
    	List<Integer> numeros = new ArrayList<Integer>();
    	List<Character> operadores = new ArrayList<Character>();
    	String numeroAsString = "";
    	
    	for(int i = 0; i < formula.trim().length(); i++){    		
    		
    		if (isNumero(String.valueOf(formula.charAt(i)))){
    			numeroAsString = numeroAsString.concat(String.valueOf(formula.charAt(i)));
    	
    		}else if (isOperador(formula.charAt(i))){
    			numeros.add(Integer.parseInt(numeroAsString));
    			operadores.add(formula.charAt(i));
    			numeroAsString = "";    		
    		}
    		
    		if (i+1 == formula.trim().length()){
    			numeros.add(Integer.parseInt(numeroAsString));
    		}
    	}
    	
    	double resultado = 0;
    	
    	for (int i = 0; i < numeros.size(); i++){
    		
    		if (i == 0){
    			resultado = numeros.get(i);
    		}else{
    			for(Operador op : opSuportados){
    				if (op.getSimbolo() == operadores.get(i-1)){
    					resultado = op.calcula(resultado, numeros.get(i));
    					break;
    				}
    			}
    		}
    	}
    	
    	jTextFieldResultado.setText(String.valueOf(resultado));
    }
    
    private boolean isOperador(char c){
    	
    	for(Operador op : opSuportados){
    		if (op.getSimbolo() == c){
    			return true;
    		}
    	}
    	
    	JOptionPane.showMessageDialog(this, "O caractere '"+c+"' não é suportado.");
		throw new RuntimeException("O caractere '"+c+"' não é suportado.");     	
    }
    
	private boolean isNumero(String numero) {
		try {
			Integer i = Integer.parseInt(numero);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
    
    private javax.swing.JButton jButtonCalcular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelTempoExecucao;
    private javax.swing.JTextField jTextFieldFormula;
    private javax.swing.JTextField jTextFieldResultado;
    
}
