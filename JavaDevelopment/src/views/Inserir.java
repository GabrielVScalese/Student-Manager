package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import models.*;
import webService.ClienteWS;

public class Inserir extends JFrame {

	private JPanel contentPane;
	private JTextField txtRA;
	private JTextField txtCodDisciplina;
	private JTextField txtNota;
	private JTextField txtFrequencia;
	
	private Fila<Matricula> fila = new Fila<Matricula>();
	private ClienteWS cws;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inserir frame = new Inserir();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void validarCampos() throws Exception
	{
		if(txtRA.getText().length() != 5)
			throw new Exception("RA inválido");
		try 
		{
			int r = Integer.parseInt(this.txtRA.getText());
		}
		catch(Exception e)
		{
			throw new Exception("RA inválido");
		}
		try 
		{
			int r = Integer.parseInt(this.txtCodDisciplina.getText());
		}
		catch(Exception e)
		{
			throw new Exception("Código de disciplina inválido");
		}
		try
		{
			float n = Float.parseFloat(txtNota.getText());
		}
		catch(Exception e)
		{
			throw new Exception("Nota inválida");
		}
		float nota = Float.parseFloat(txtNota.getText());
		if(nota < 0 || nota > 10)
			throw new Exception("Nota inválida");
		try
		{
			float f = Float.parseFloat(txtFrequencia.getText());
		}
		catch(Exception e)
		{
			throw new Exception("Frequência inválida");
		}
		float freq = Float.parseFloat(txtFrequencia.getText());
		if(freq < 0 || freq > 1)
			throw new Exception("Frequência inválida");
	}

	/**
	 * Create the frame.
	 */
	public Inserir() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("RA:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel);
		
		txtRA = new JTextField();
		txtRA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtRA);
		txtRA.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo da disciplina:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_1);
		
		txtCodDisciplina = new JTextField();
		txtCodDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtCodDisciplina);
		txtCodDisciplina.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nota:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_2);
		
		txtNota = new JTextField();
		txtNota.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtNota);
		txtNota.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Frequ\u00EAncia:");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblNewLabel_3);
		
		txtFrequencia = new JTextField();
		txtFrequencia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(txtFrequencia);
		txtFrequencia.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnInserir = new JButton("Inserir aluno");
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try
				{
					validarCampos();
					int ra = Integer.parseInt(txtRA.getText());
					int cod = Integer.parseInt(txtCodDisciplina.getText());
					float nota = Float.parseFloat(txtNota.getText());
					float frequencia = Float.parseFloat(txtFrequencia.getText());
					Matricula m = new Matricula(ra, cod, nota, frequencia);
					fila.insira(m);
				}
				catch(Exception err)
				{
					JOptionPane.showMessageDialog(null, err);
				}
			}
		});
		btnInserir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btnInserir);
		
		JButton btnSalvar = new JButton("Salvar alunos");
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Fila filaClone = (Fila) fila.clone();
				try
				{
					do
					{
						ClienteWS.postObjeto(fila.getInfo(), null, "http://localhost:3000/resultados");
					}
					while(!fila.isVazia());
				}
				catch (Exception err)
				{
					err.printStackTrace();
				}
				
				Listagem l = new Listagem();
				l.setVisible(true);
				l.preencherTabela(filaClone);
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btnSalvar);
	}

}
