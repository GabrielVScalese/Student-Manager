package janelas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Fila;
import classes.Matricula;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;

public class Listagem extends JFrame {

	private JPanel contentPane;
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
	
	public static void preencherTabela(Fila<Matricula> fila) 
	{

        String [] colunas = {"RA","C�digo da discplina", "Nota", "Frequ�ncia"};
        try 
        {
            ArrayList dados = new ArrayList();
           
            do 
            {
            	dados.add(new Object[] {fila.getSemRemover().getRa(), fila.getSemRemover().getCod(), fila.getSemRemover().getNota(), fila.getSemRemover().getFreq()});
            	fila.removaDoInicio();
            }
            while (!fila.isVazia());
           
            ModeloTabela modTab = new ModeloTabela(dados,colunas);

            table.setModel(modTab);//Criamos a tabela
            table.getColumnModel().getColumn(0).setPreferredWidth(210);
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(1).setPreferredWidth(211);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getTableHeader().setReorderingAllowed(false);
        }
        catch(Exception erro)
        {}
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
		
		table = new JTable();
		contentPane.add(table, BorderLayout.CENTER);
	}

}
