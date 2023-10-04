package exerciciosComPOO;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

//Classe
public class DadosBanco {

	// Atributos
	private String nomeTitular;

	private Long cpf;

	private Double saldo;

	private String banco;

	private int agencia;

	private String valorFormatado;

	private DecimalFormat df = new DecimalFormat("R$ ####.##");

	public DadosBanco(String nomeTitular, Long cpf, Double saldo, String banco, int agencia) {

		this.nomeTitular = nomeTitular;

		this.cpf = cpf;

		this.saldo = saldo;

		this.banco = banco;

		this.agencia = agencia;
	}

	// Mostra os dados bancários
	public void mostrarDados() {

		valorFormatado = df.format(saldo);

		JOptionPane.showMessageDialog(null, "Nome do cliente:  " + nomeTitular + "\nCPF:  " + cpf + "\nSaldo:  "
				+ valorFormatado + "\nBanco:  " + banco + "\nAgência:  " + agencia);

	}

	// Método para realização de um deposito, que recebe um valor como parametro e
	// soma com o valor anterior.

	public void efetuarDeposito(Double valor) {

		String valorFormatado;

		String valorFormatado2;

		valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Insira um valor para efetuar o deposito"));

		tratamentoErroDecimal(valor);

		valorFormatado = df.format(valor + saldo);

		valorFormatado2 = df.format(saldo);

		JOptionPane.showMessageDialog(null, "DEPOSITO REALIZADO COM SUCESSO!" + "\nValor antes do deposito:  "
				+ valorFormatado2 + "\nValor após a operação:  " + valorFormatado);

	}

	// Método para realização do saque, que recebe um valor como parametro.
	public Double realizarSaque(double saque) {

		saque = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor que deseja sacar"));

		tratamentoErroDecimal(saque);

		if (saque > saldo) {

			JOptionPane.showMessageDialog(null,
					"Não é possível prosseguir com a operação, pois o valor do saque é maior que o valor do saldo!!!");
		}

		else {

			valorFormatado = df.format(saldo - saque);

			String valorFormatado2 = df.format(saldo);

			JOptionPane.showMessageDialog(null, "SAQUE REALIZADO COM SUCESSO!! \nValor antes do saque:  "
					+ valorFormatado2 + "\nValor após a operação:  " + valorFormatado);

		}

		return saque;

	}

	// Método que faz a verificação da entrada do usuário com números decimais.
	public void tratamentoErroDecimal(Double decimal) {

		try {

			if (decimal <= 0) {
				JOptionPane.showMessageDialog(null,
						"Não é possível inserir valores negativos ou igual a 0 , tente novamente");
			}

		} catch (NullPointerException | NumberFormatException erro) {

			JOptionPane.showMessageDialog(null,
					"Você finalizou a aplicação de maneira incorreta, ou inseriu dados inválidos , tente novamente!!");

		}

	}

}
