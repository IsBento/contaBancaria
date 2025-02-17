package contaBancaria.controller;

import java.util.ArrayList;

import contaBancaria.model.contaBancaria;
import contaBancaria.repository.ContaRepository;

public class contaController implements ContaRepository {

	private ArrayList<contaBancaria> listaContas = new ArrayList<contaBancaria>();
	int numero = 0;
	
	@Override
	public void procurarPorNumero(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listarTodas() {
		for (var contaBancaria : listaContas) {
			contaBancaria.visualizar();
			}
		
	}

	@Override
	public void cadastrar(contaBancaria conta) {
		listaContas.add(conta);
		System.out.println("\nA Conta número: " + conta.getNumero() + "foi criada com sucesso!");
	}

	@Override
	public void atualizar(contaBancaria conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
	}
	public int gerarNumero() {
		return ++ numero;
	}
}
