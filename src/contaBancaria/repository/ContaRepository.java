package contaBancaria.repository;

import contaBancaria.model.contaBancaria;

public interface ContaRepository {
	
		// CRUD da Conta
		public void procurarPorNumero(int numero);
		public void listarTodas();
		public void cadastrar(contaBancaria conta);
		public void atualizar(contaBancaria conta);
		public void deletar(int numero);
		
		// Métodos Bancários
		public void sacar(int numero, float valor);
		public void depositar(int numero, float valor);
		public void transferir(int numeroOrigem, int numeroDestino, float valor);

}
