package dadosVeiculo;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;


//Classe
public class DadosVeiculo {

	//Atributos
	private String placa;

	private int ano;

	private String modelo;

	private String cor;

	private Double valor;

	private Double cotacao;

	String valorFormatado;

	DecimalFormat df = new DecimalFormat("R$ ####.##");

	//Método Construtor
	public DadosVeiculo(String placa, String modelo, String cor, Double valor, Double cotacao, int ano) {

		this.placa = placa;

		this.modelo = modelo;

		this.cor = cor;

		this.valor = valor;

		this.cotacao = cotacao;

		this.ano = ano;
	}

	//Imprime os dados do veiculo
	public void mostrarDadosVeiculo() {

		valorFormatado = df.format(valor);

		JOptionPane.showMessageDialog(null, "Modelo:  " + modelo + "\nCor do veiculo:  " + cor + "\nPlaca:  " + placa
				+ "\nPreço: " + valorFormatado + "\nAno do veiculo: " + ano);

	}

	//Define o conteudo da placa
	public void setPlaca(String placa) {

		placa = JOptionPane.showInputDialog(null, "Insira a placa do veiculo: ");

		//Tratamento de erros em um método.
		tratamentoErroString(placa);

		this.placa = placa;

	}

	public String getPlaca() {

		return placa;
	}

	//Cotação do veiculo
	public void setCotacao(Double cotacao) {

		int diferenca = 2023 - ano;

		if (diferenca > 10) {
			JOptionPane.showMessageDialog(null,

					"Não é possível efetuar a cotação de veiculos com idade superior a 10 anos");
		}

		else {

			cotacao = valor * 0.05;

			JOptionPane.showMessageDialog(null, "Valor da cotação do veiculo: " + cotacao);

			this.cotacao = cotacao;

		}

	}

	//Define o ano do veiculo, com tratamento de erros com método.
	public void setAno(int ano) {

		ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o ano do seu veiculo: "));

		tratamentoErroInt(ano);

		this.ano = ano;

	}

	public void setModelo(String modelo) {

		modelo = JOptionPane.showInputDialog(null, "Insira o modelo do veiculo: ");

		tratamentoErroString(modelo);

		modelo = modelo.toUpperCase();

		modelo = modelo.trim();

		this.modelo = modelo;
	}

	public void setCor(String cor) {

		cor = JOptionPane.showInputDialog(null, "Insira a cor do veiculo : ");

		tratamentoErroString(cor);

		cor = cor.toUpperCase();

		cor = cor.trim();

		this.cor = cor;
	}

	public void setValor(Double valor) {

		try {

			valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Insira o valor do veiculo"));

			if (valor <= 0) {
				JOptionPane.showMessageDialog(null,
						"Não é possível inserir valores menores ou iguais a 0 , tente novamente");
			}

			else {

				this.valor = valor;

			}

		} catch (NumberFormatException | NullPointerException erro) {

			JOptionPane.showMessageDialog(null,
					"O programa foi fechado incorretamente ou dados inválidos foram fornecidos");

		}
	}

	public void tratamentoErroString(String frase) {

		try {

			if (frase.isEmpty()) {

				JOptionPane.showMessageDialog(null, "O campo precisa ser preenchido, tente novamente");
			}

		} catch (NullPointerException erro) {

			JOptionPane.showMessageDialog(null, "O programa foi fechado incorretamente, tente novamente!!");
		}

	}

	public void tratamentoErroInt(int numero) {

		try {

			if (numero <= 0) {
				JOptionPane.showMessageDialog(null, "Você não pode inserir valores negativos ou iguais a zero!!");
			}

		} catch (NumberFormatException | NullPointerException erro) {

			JOptionPane.showMessageDialog(null, "Você inseriu dados inválidos ou fechou o programa incorretamente");
		}

	}

}
