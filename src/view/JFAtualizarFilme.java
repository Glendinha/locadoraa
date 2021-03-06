package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Filme;
import model.dao.FilmeDAO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class JFAtualizarFilme extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtCategoria;

	private static int id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtualizarFilme frame = new JFAtualizarFilme(id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFAtualizarFilme(int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 549, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alterar Filme");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(198, 13, 101, 41);
		contentPane.add(lblNewLabel);
		
		FilmeDAO fdao = new FilmeDAO();
		Filme f = fdao.read(id);
		
		JLabel lblNewLabel_7 = new JLabel("ID do Filme:");
		lblNewLabel_7.setBounds(10, 24, 57, 25);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblId = new JLabel("New label");
		lblId.setBounds(77, 29, 18, 14);
		contentPane.add(lblId);
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EDtulo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 50, 33, 25);
		contentPane.add(lblNewLabel_1);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(10, 76, 482, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Sinopse");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 107, 57, 25);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 132, 497, 153);
		contentPane.add(scrollPane);
		
		JTextArea txtSinopse = new JTextArea();
		scrollPane.setViewportView(txtSinopse);
		
		JLabel lblNewLabel_3 = new JLabel("Categoria");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(10, 296, 79, 25);
		contentPane.add(lblNewLabel_3);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(10, 321, 482, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Tempo");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(21, 377, 46, 25);
		contentPane.add(lblNewLabel_4);
		
		JSpinner spnTempo = new JSpinner();
		spnTempo.setBounds(72, 370, 42, 41);
		contentPane.add(spnTempo);
		
		JLabel lblNewLabel_5 = new JLabel("Imagem");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(185, 352, 57, 25);
		contentPane.add(lblNewLabel_5);
		
		JRadioButton rdbtn2D = new JRadioButton("2D");
		rdbtn2D.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtn2D.setBounds(165, 384, 57, 23);
		contentPane.add(rdbtn2D);
		
		JRadioButton rdbtn3D = new JRadioButton("3D");
		rdbtn3D.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtn3D.setBounds(224, 384, 46, 23);
		contentPane.add(rdbtn3D);
		
		ButtonGroup imagem = new ButtonGroup();
		imagem.add(rdbtn2D);
		imagem.add(rdbtn3D);
		
		JLabel lblNewLabel_6 = new JLabel("�udio");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(377, 357, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JRadioButton rdbtnDublado = new JRadioButton("Dublado");
		rdbtnDublado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnDublado.setBounds(317, 384, 79, 23);
		contentPane.add(rdbtnDublado);
		
		JRadioButton rdbtnLegendado = new JRadioButton("Legendado");
		rdbtnLegendado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnLegendado.setBounds(398, 384, 109, 23);
		contentPane.add(rdbtnLegendado);
		
		ButtonGroup audio = new ButtonGroup();
		audio.add(rdbtnDublado);
		audio.add(rdbtnLegendado);
		
		lblId.setText(String.valueOf(f.getIdFilme()));
		txtTitulo.setText(f.getTitulo());
		txtSinopse.setText(f.getSinopse());
		txtCategoria.setText(f.getCategoria());
		spnTempo.setValue(f.getTempo());
		if(f.isImagem3d() == true) {
			rdbtn3D.setSelected(true);
		}else if (f.isImagem3d() == false) {
			rdbtn2D.setSelected(true);
		}
		if(f.isDublado() == true) {
			rdbtnDublado.setSelected(true);
		}else if (f.isDublado() == false) {
			rdbtnLegendado.setSelected(true);
		}
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Filme f = new Filme();
				FilmeDAO dao = new FilmeDAO();
				f.setIdFilme(Integer.parseInt(lblId.getText()));
				f.setTitulo(txtTitulo.getText());
				f.setSinopse(txtSinopse.getText());
				f.setCategoria(txtCategoria.getText());
				f.setTempo(Integer.parseInt(spnTempo.getValue().toString()));
				if (rdbtn2D.isSelected()) {
					f.setImagem3d(false);
				} else if (rdbtn3D.isSelected()) {
					f.setImagem3d(true);
				}
				if (rdbtnDublado.isSelected()) {
					f.setDublado(true);
				} else if (rdbtnLegendado.isSelected()) {
					f.setDublado(false);
				}
				dao.update(f);

			}
		});
		
		btnAlterar.setBounds(10, 440, 94, 36);
		contentPane.add(btnAlterar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTitulo.setText(null);
				txtSinopse.setText(null);
				txtCategoria.setText(null);
				spnTempo.setValue(0);
				imagem.clearSelection();
				audio.clearSelection();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLimpar.setBounds(235, 439, 101, 38);
		contentPane.add(btnLimpar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(118, 439, 101, 38);
		contentPane.add(btnCancelar);
		
		
	}
}
