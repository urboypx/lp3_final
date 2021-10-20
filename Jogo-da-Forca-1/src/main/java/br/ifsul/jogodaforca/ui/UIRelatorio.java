package br.ifsul.jogodaforca.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import br.ifsul.jogodaforca.model.Palavra;
import br.ifsul.jogodaforca.model.PalavraRepository;

public class UIRelatorio extends JFrame {

	private JPanel contentPane;

	public UIRelatorio(PalavraRepository palavraRepository) {
		setTitle("Relatório");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVoltar.setBounds(173, 227, 89, 23);
		contentPane.add(btnVoltar);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 414, 205);
		contentPane.add(textArea);

		// TO DO: Ordenar por ordem alfabética e agrupar por dificuldade
		
		List<Palavra> listaPalavras = palavraRepository.findAll();
		
		for (Palavra p : listaPalavras) {
			textArea.append(p.getPalavra() + "\n");
		}

	}
}
