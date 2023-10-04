package dadosVeiculo;

import javax.swing.JOptionPane;

import exerciciosComPOO.DadosBanco;

public class InsereDados {

	public static void main(String[] args) {

		// Instancia dos objetos
		DadosVeiculo carro = new DadosVeiculo(null, null, null, null, null, 0);

		DadosBanco cliente = new DadosBanco("Felipe", (long) 123456789, 5000.0, "BANCO NACIONAL", 123);

		int userInput = 0;

		do {

			// Tratamento de erros, caso o usuario digite algo diferente de um número a
			// excessão será efetuada.
			try {

				userInput = Integer.parseInt(JOptionPane.showInputDialog(null,
						"Escolha uma opção" + " \n1-Mostrar dados do cliente \n2-Fornecer dados do veiculo"
								+ " \n3-Cálculo cotação \n4-Finalizar aplicação"));

			} catch (NumberFormatException | NullPointerException erro) {

				JOptionPane.showMessageDialog(null, "Você inseriu dados inválidos ou fechou o programa incorretamente");
			}

			switch (userInput) {

			// Caso o usuário escolha a primeira opção, os dados bancários do cliente serão
			// gerados!
			case 1:

				cliente.mostrarDados();

				break;

			// Caso a segunda opção seja escolhida , o usuário poderá definir os dados do
			// veiculo e após inserir corretamente, será possível calcular sua cotação
			case 2:

				carro.setCor(null);

				carro.setModelo(null);

				carro.setValor(null);

				carro.setPlaca(null);

				carro.setAno(0);

				carro.mostrarDadosVeiculo();

				break;

			// Calculo da cotação do veiculo, que é dada pelo seu preço multiplicado por uma
			// porcentagem x , no caso dessa aplicação sera 5%
			case 3:

				carro.setCotacao(null);

				break;

			// Se o usuário selecionar a opção 4, ou algo diferente das opções listadas
			// acima a aplicação é encerrada
			case 4:

				JOptionPane.showMessageDialog(null, "A aplicação foi finalizada!!!");

				break;

			default:

				JOptionPane.showMessageDialog(null,

						"Você não selecionou nenhuma opção, portanto a aplicação foi finalizada");

				break;
			}

		} while (userInput > 0);
	}

}
