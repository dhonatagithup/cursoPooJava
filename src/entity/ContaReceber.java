package entity;

import enuns.SituacaoConta;

public class ContaReceber extends Conta {
	

	private Cliente cliente;
	
	public ContaReceber() {
		
	}

	public ContaReceber(Cliente cliente, String descricao, Double valor, String dataVencimento) {
		this.cliente = cliente;
		setDescricao(descricao);
		setValor(valor);
		setDataVencimento(dataVencimento);
		
	}

	public void cancelar() {
		if (this.getValor() > 50000d) {
			System.out.println("Essa conta a receber n�o pode ser cancelada. " +
				"� muito dinheiro para deixar de receber: " + this.getDescricao());
		} else {
			super.cancelar();
		}
	}
	
	public void receber() {
		if (SituacaoConta.PAGA.equals(this.getSituacaoConta())) {
			System.out.println("N�o pode receber uma conta que j� est� paga: " 
				+ this.getDescricao() + ".");
		} else if (SituacaoConta.CANCELADA.equals(this.getSituacaoConta())) {
			System.out.println("N�o pode receber uma conta que est� cancelada: " 
				+ this.getDescricao() + ".");
		} else {
			System.out.println("Recebendo conta " + this.getDescricao() + " no valor de " 
				+ this.getValor() + " e vencimento em " + this.getDataVencimento() 
				+ " do cliente " + this.getCliente().getNome() + ".");
				
			// altera situa��o da conta para PAGA
			this.situacaoConta = SituacaoConta.PAGA;
		}
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
