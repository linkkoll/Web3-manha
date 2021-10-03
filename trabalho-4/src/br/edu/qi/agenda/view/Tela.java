package br.edu.qi.agenda.view;

import javax.swing.JOptionPane;

public class Tela {
	
	public void mostrar(String mensagem, String titulo, int icone) {
		JOptionPane.showMessageDialog(
				null,
				mensagem,
				titulo,
				icone);
	}
	
	
	public String informar(String mensagem, String titulo, int icone) {
		return JOptionPane.showInputDialog(
				null,
				mensagem,
				titulo,
				icone);
	}
	
	public int confirmar(String mensagem, String titulo, int icone) {
		return JOptionPane.showConfirmDialog(
				null,
				mensagem,
				titulo,
				JOptionPane.YES_NO_OPTION,
				icone
				);
	}

}
