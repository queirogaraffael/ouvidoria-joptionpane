package application;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entities.Manifestacao;

public class Programa {

	public static void main(String[] args) throws Exception {
		Manifestacao manifestacao;
		List<Manifestacao> manifestacoes = new ArrayList<Manifestacao>();
		Object[] opcoes = { "Listar todas as manifestações", "Adicionar uma nova manifestação",
				"Pesquisar uma manifestação por código", "Remover uma manifestação pelo código", "Sair" };

		Object opcao = "";

		JOptionPane.showMessageDialog(null, "Bem-vindo à ouvidoria.");

		do {
			opcao = JOptionPane.showInputDialog(null, "Escolha uma opção", "Opções", JOptionPane.INFORMATION_MESSAGE,
					null, opcoes, opcoes[0]);

			if (opcao.equals("Listar todas as manifestações")) {
				if (manifestacoes.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Sem manifestações na ouvidoria.", "Alerta",
							JOptionPane.ERROR_MESSAGE);
				} else {
					StringBuilder sb = new StringBuilder();

					for (Manifestacao tarefa : manifestacoes) {
						sb.append(tarefa).append("\n");
					}
					JOptionPane.showMessageDialog(null, sb.toString(), "Manifestações: ",
							JOptionPane.INFORMATION_MESSAGE);

				}

			} else if (opcao.equals("Adicionar uma nova manifestação")) {

				int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Código: "));

				String manifestacaoDado = JOptionPane.showInputDialog(null, "Adicione uma nova manifestação: ");

				manifestacao = new Manifestacao(codigo, manifestacaoDado);
				manifestacoes.add(manifestacao);

				JOptionPane.showMessageDialog(null, "Manifestação adicionada com sucesso!");

			} else if (opcao.equals("Pesquisar uma manifestação por código")) {

				if (manifestacoes.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Adicione primeiro manifestações para pesquisar.", "Alerta",
							JOptionPane.ERROR_MESSAGE);

				} else {
					int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da manifestação"));

					boolean temOuNaoTem = manifestacoes.stream().anyMatch(p -> p.getCodigo() == codigo);

					if (temOuNaoTem) {
						for (int i = 0; i < manifestacoes.size(); i++) {
							if (manifestacoes.get(i).getCodigo() == codigo) {
								JOptionPane.showMessageDialog(null, manifestacoes.get(i));
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Código sem correspondencia a uma manifestação", "Alerta",
								JOptionPane.ERROR_MESSAGE);
					}
				}

			} else if (opcao.equals("Remover uma manifestação pelo código")) {

				if (manifestacoes.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Adicione primeiro manifestações para remover", "Alerta",
							JOptionPane.ERROR_MESSAGE);

				} else {
					int codigo = Integer.parseInt(JOptionPane.showInputDialog("Entre com o código da manifestação: "));

					boolean temOuNaoTem = manifestacoes.stream().anyMatch(p -> p.getCodigo() == codigo);

					if (temOuNaoTem) {
						manifestacoes.removeIf(p -> p.getCodigo() == codigo);

						JOptionPane.showMessageDialog(null, "Removido com sucesso.");
					} else {
						JOptionPane.showMessageDialog(null, "Código sem correspondencia a uma manifestação", "Alerta",
								JOptionPane.ERROR_MESSAGE);
					}
				}

			} else if (opcao.equals("Sair")) {
				JOptionPane.showMessageDialog(null, "Fim do programa!");
			}

			else {
				JOptionPane.showMessageDialog(null, "Opção inválida. Tente outra.");
			}

		} while (!opcao.equals("Sair"));

	}

}