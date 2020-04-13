package trabalho.v1.calculadora.compiladores;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTable;

public class Tela extends Operador {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnVerificar;
	private JLabel lblInformeAEsquao;
	String expressao;
	JTable table = null;
	JScrollPane sp = null;
	String [] nomesColunas = { "Lexema", "Tipo", "Valor"};	
	Object [][] celulas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Tela() {
		setTitle("Analizador");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{30, 414, 0};
		gbl_panel.rowHeights = new int[]{90, 19, 22, 25, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblInformeAEsquao = new JLabel("Informe a esqua\u00E7\u00E3o abaixo:");
		lblInformeAEsquao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblInformeAEsquao = new GridBagConstraints();
		gbc_lblInformeAEsquao.anchor = GridBagConstraints.NORTH;
		gbc_lblInformeAEsquao.insets = new Insets(0, 0, 5, 0);
		gbc_lblInformeAEsquao.gridx = 1;
		gbc_lblInformeAEsquao.gridy = 1;
		panel.add(lblInformeAEsquao, gbc_lblInformeAEsquao);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVerificar.doClick();
			}
		});
		
		btnVerificar = new JButton("Verificar");
		GridBagConstraints gbc_btnVerificar = new GridBagConstraints();
		gbc_btnVerificar.anchor = GridBagConstraints.NORTH;
		gbc_btnVerificar.gridx = 1;
		gbc_btnVerificar.gridy = 3;
		panel.add(btnVerificar, gbc_btnVerificar);
		
		
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean validar;
				expressao = textField.getText();
				validar = validador(expressao);
	
				if(validar) {
					celulas = TabelaController.montarTabela(textField.getText());
					
					if (sp != null) {
						getContentPane().remove(sp);
						getContentPane().validate();
						getContentPane().repaint();
					}
					
					table = new JTable(celulas, nomesColunas);
					table.setAutoCreateRowSorter(true);
					
					sp = new JScrollPane(table);
					getContentPane().add(sp, BorderLayout.CENTER);
					getContentPane().validate();
					getContentPane().repaint();
				}else {
					JOptionPane.showMessageDialog(null, "Expressão inválida!");
				}
			}
		});
	}
}