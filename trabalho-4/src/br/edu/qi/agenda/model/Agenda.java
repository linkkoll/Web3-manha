package br.edu.qi.agenda.model;

import java.util.ArrayList;
import java.util.List;

import br.edu.qi.agenda.view.Tela;

public class Agenda {

	public void iniciarAgenda() {

		Tela tela = new Tela();

		String menu = ":: Agenda de Contatos ::\n\n" +
		"1. Cadastrar\n" +
		"2. Buscar\n" +
		"3. Editar\n"+
		"4. Excluir\n\n";

		boolean isAtivo = true;

		while (isAtivo) {
			String opcao = tela.informar(menu, "Informe uma das opçoes", -1);

			switch (opcao) {

			case "1":
				cadastrarContato(tela);
				break;

			case "2":
				buscarContato(tela);
				break;

			case "3":
				editarContato(tela);
				break;

			case "4":
				excluirContato(tela);
				break;

			default:
				int sair = tela.confirmar("Deseja sair?", "Encerrar Sistema", 3);

				if (sair == 0) {
					isAtivo = false;
					tela.mostrar("Encerrando o sistema", "Encerrar Sistema", 1);
				}
			}
		}
	}

	private void cadastrarContato(Tela tela) {

		String nome = tela.informar("Informe o Nome", "Nome", 1);
		String email = tela.informar("Informe o E-mail", "E-mail", 1);
		String fone = tela.informar("Informe o Telefone", "Fone", 1);

		Contato contato = new Contato(nome, email, fone);

		Lista.getInstance().add(contato);
	}

	private void buscarContato(Tela tela) {
		int numeroRegistros = Lista.getInstance().size();

		if (numeroRegistros > 0) {
			String listaContatos = "";

			for (int i = 0; i < numeroRegistros; i++) {
				listaContatos += "ID: " + (i + 1) + "\nNome: " + Lista.getInstance().get(i).getNome() + "\nE-mail: "
						+ Lista.getInstance().get(i).getEmail() + "\nFone: " + Lista.getInstance().get(i).getFone()
						+ "\n\n";
			}

			tela.mostrar(listaContatos, "Contatos", -1);

		} else {
			tela.mostrar("Nenhum contato registrado", "Contatos", 1);
		}
	}

	private void editarContato(Tela tela) {
		buscarContato(tela);

		if (Lista.getInstance().size() < 1) {
			return;
		}

		int id = 0;

		try {
			id = Integer.parseInt(tela.informar("Informe o ID para editar", "Editar contato", 1));

		} catch (Exception e) {
			tela.mostrar("Informe um ID numerico", "ID Inválido", 2);
			return;
		}

		String novoNome = tela.informar("Informe o Nome", "Nome", 1);
		String novoEmail = tela.informar("Informe o E-mail", "E-mail", 1);
		String novoFone = tela.informar("Informe o Telefone", "Fone", 1);
		
		if (!novoNome.equals("")) {
			 Lista.getInstance().get(id -1).setNome(novoNome);
		}
		
		if (!novoEmail.equals("")) {
			Lista.getInstance().get(id -1).setEmail(novoEmail);
		}
		
		if (!novoFone.equals("")) {
			Lista.getInstance().get(id -1).setFone(novoFone);
		}
	}
	
	private void excluirContato(Tela tela) {
		buscarContato(tela);

		if (Lista.getInstance().size() < 1) {
			return;
		}

		int id = 0;

		try {
			id = Integer.parseInt(tela.informar("Informe o ID para excluir", "Excluir contato", 1));

		} catch (Exception e) {
			tela.mostrar("Informe um ID numerico", "ID Inválido", 2);
			return;
		}
	 int numeroRegistros = Lista.getInstance().size();
		for (int i = 0; i < numeroRegistros; i++) {
			
			if (id == (i + 1)) {
				 Lista.getInstance().remove(id -1);
			}
		}
		
	}
		
	}


