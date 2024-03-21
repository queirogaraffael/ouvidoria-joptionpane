package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Manifestacao;

public class Programa {

	public static void main(String[] args) throws Exception {
		Manifestacao manifestacao;
		Scanner scanner = new Scanner(System.in);
		List<Manifestacao> manifestacoes = new ArrayList<Manifestacao>();

		int opcao = 0;

		System.out.println("Bem-vindo à ouvidora\n");

		do {

			Menu();
			opcao = scanner.nextInt();

			if (opcao == 1) {

				System.out.println("Todas as manifestações: ");

				if (manifestacoes.isEmpty()) {
					System.out.println("Sem manifestações na ouvidoria.");
					Thread.sleep(3000);
				} else {
					for (Manifestacao tarefa : manifestacoes) {
						System.out.println("1. " + tarefa);
					}
					Thread.sleep(5000);
				}

			} else if (opcao == 2) {

				System.out.println("Nova manifestação");

				System.out.println("Código: ");
				int codigo = scanner.nextInt();

				scanner.nextLine();

				System.out.println("Adicione uma nova manifestação: ");
				String manifestacaoDado = scanner.nextLine();

				manifestacao = new Manifestacao(codigo, manifestacaoDado);
				manifestacoes.add(manifestacao);

				System.out.println("Manifestação adicionada com sucesso!");
				Thread.sleep(2000);

			} else if (opcao == 3) {

				System.out.println("Pesquise uma manifestação por código\n");
				System.out.println("Digite o código da manifestacao  ");
				int codigo = scanner.nextInt();

				boolean temOuNaoTem = manifestacoes.stream().anyMatch(p -> p.getCodigo() == codigo);

				if (temOuNaoTem) {

					for (int i = 0; i < manifestacoes.size(); i++) {
						if (manifestacoes.get(i).getCodigo() == codigo) {
							System.out.println(manifestacoes.get(i));
						}
					}
				} else {
					System.out.println("Manifestação sem código correspondente.");
				}
				Thread.sleep(4000);

			} else if (opcao == 4) {
				System.out.println("Remova uma manifestação por código\n");
				System.out.println("Entre com o código da manifestação: ");
				int codigo = scanner.nextInt();

				// tratamento de exceções

				manifestacoes.removeIf(p -> p.getCodigo() == codigo);

				System.out.println("Removido com sucesso.");
				Thread.sleep(2000);

			} else if (opcao == 5) {
				System.out.println("Fim do programa!");
			}

			else {
				System.out.println("Opção inválida. Tente outra.");
				Thread.sleep(1000);
			}

		} while (opcao != 5);

		scanner.close();

	}

	public static void Menu() {
		System.out.println("Menu:");
		System.out.println("1. Listar todas as manifestações");
		System.out.println("2. Adicionar uma nova manifestação");
		System.out.println("3. Pesquisar uma manifestação por código");
		System.out.println("4. Remover uma manifestação pelo código");
		System.out.println("5. Sair");
		System.out.println("Escolha uma opção: ");

	}

}