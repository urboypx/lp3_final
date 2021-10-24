package br.ifsul.jogodaforca.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import br.ifsul.jogodaforca.model.Palavra;
import br.ifsul.jogodaforca.model.PalavraRepository;
import javax.swing.JLabel;
import java.awt.TextArea;

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
				UIMain uim = new UIMain(palavraRepository);
				uim.setVisible(true);
				setVisible(false);
			}
		});
		btnVoltar.setBounds(173, 227, 89, 23);
		contentPane.add(btnVoltar);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(10, 10, 414, 211);
		contentPane.add(textArea);

		List<Palavra> listaPalavraRepository = palavraRepository.findAll();

		List<String> listaPalavras = new ArrayList<String>();

		for (Palavra p : listaPalavraRepository) {
			listaPalavras.add(p.getPalavra());
		}

		Collections.sort(listaPalavras);

		for (String p : listaPalavras) {
			if (p.length() >= 6) {
				textArea.append(p + "\n");
			}
		}

		for (String p : listaPalavras) {
			if (p.length() <= 4) {
				textArea.append(p + "\n");
			}
		}

	}
}