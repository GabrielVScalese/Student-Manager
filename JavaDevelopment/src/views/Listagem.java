package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Fila;
import models.Resultados;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Listagem extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Listagem frame = new Listagem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void preencherTabela(Fila<Resultados> fila, Fila<String> inserido) 
	{

        String [] colunas = {"RA","Código da discplina", "Nota", "Frequência", "Inserido"};
        try 
        {
            ArrayList dados = new ArrayList();
           
            do 
            {
            	dados.add(new Object[] {fila.getSemRemover().getRa(), fila.getSemRemover().getCod(), fila.getSemRemover().getNota(), fila.getSemRemover().getFreq(), inserido.getSemRemover()});
            	fila.removaDoInicio();
            	inserido.removaDoInicio();
            }
            while (!fila.isVazia());
           
            ModeloTabela modTab = new ModeloTabela(dados,colunas);

            table.setModel(modTab);
            table.getColumnModel().getColumn(0).setPreferredWidth(210);
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setPreferredWidth(211);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getTableHeader().setReorderingAllowed(false);
        }
        catch(Exception erro)
        {
        	System.out.println(erro.getMessage());
        }
    }

	/**
	 * Create the frame.
	 */
	public Listagem() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Listagem de alunos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

}
