package exerciciosComPOO;

import javax.swing.JOptionPane;

public class ContaBancaria {

	public static void main(String[] args) {

		DadosBanco conta1 = new DadosBanco("Felipe", (long) 123456789, 5000.0, "BANCO NACIONAL", 123);

		int userInput = 0;

		do {

			try {

				userInput = Integer.parseInt(JOptionPane.showInputDialog(null,

						"Escolha uma opção \n1-Consultar dados \n2-Sacar \n3-Depositar \n4-Finalizar aplicação"));

				switch (userInput) {

				case 1:

					// Consultar os dados bancários, em uma aplicação ficticia.
					conta1.mostrarDados();

					break;

				case 2:

					// Ao realizar o saque, o programa mostra o valor disponível anteriormente e
					// após a operação , se o valor for maior do que o disponivel gera um erro.

					conta1.realizarSaque(0);

					break;

				case 3:

					// Efetuar um deposito , soma o valor que existia anteriormente com o valor
					// novo.
					conta1.efetuarDeposito(null);

					break;

				case 4:

					JOptionPane.showMessageDialog(null, "A aplicação foi finalizada com sucesso!!!");

					break;

				default:

					JOptionPane.showMessageDialog(null,
							"Você não selecionou nenhuma opção válida, portanto a aplicação foi finalizada");

					break;
				}

			} catch (NumberFormatException | NullPointerException erro) {

				JOptionPane.showMessageDialog(null,
						"Ocorreu um erro inesperado, a aplicação foi encerrada incorretamente ou dados inválidos foram inseridos");
			}

		} while (userInput > 0);

	}

}
