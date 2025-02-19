package contaBancaria.controller;

import java.util.ArrayList;

import contaBancaria.model.contaBancaria;
import contaBancaria.repository.ContaRepository;

public class contaController implements ContaRepository {

	private ArrayList<contaBancaria> listaContas = new ArrayList<contaBancaria>();
	int numero = 0;
	
	@Override
	public void procurarPorNumero(int numero) {
		var contaBancaria = buscarNaCollection(numero);
		
		if(contaBancaria != null)
			contaBancaria.visualizar();
		else
			System.out.println("\nA conta número: " + numero + " não foi encontrada!");
		
	}

	@Override
	public void listarTodas() {
		for (var contaBancaria : listaContas) {
			contaBancaria.visualizar();
			}
	}

	@Override
	public void cadastrar(contaBancaria contas) {
		listaContas.add(contas);
		System.out.println("\nA Conta número: " + contas.getNumero() + " foi criada com sucesso!");
	}

	@Override
	public void atualizar(contaBancaria contas) {
		var buscarcontaBancaria = buscarNaCollection(contaBancaria.getNumero());
		
		if(buscarcontaBancaria != null) {
			listaContas.set(listaContas.indexOf(buscarcontaBancaria), contas);
			System.out.println("\nA conta númeroo: " + contaBancaria.getNumero() + " foi atualizada com sucesso!");
		} else
			System.out.println("\nA conta número: " + contaBancaria.getNumero() + " não foi encontrada!");
		
	}

	@Override
	public void deletar(int numero) {
		var contaBancaria = buscarNaCollection (numero);
		
		if (contaBancaria != null) {
			if (listaContas.remove(contaBancaria) == true);
			System.out.println("\nA conta número: " + numero + " foi deletada com sucesso!");
		} else
			System.out.println("\nA conta número: " + numero + " não foi encontrada!");
		}
		

	@Override
	public void sacar(int numero, float valor) {
		var contaBancaria = buscarNaCollection(numero);
		
		if (contaBancaria != null) {
			if(contaBancaria.sacar(valor) == true)
				System.out.println("\nO saque na conta número: " + numero + " foi efetuado com sucesso!");
		} else
			System.out.println("\nA conta número: " + numero + " não foi encontrada!");
		}
		
	

	@Override
	public void depositar(int numero, float valor) {
		var contaBancaria = buscarNaCollection(numero);
		
		if(contaBancaria != null) {
			contaBancaria.depositar(valor);
			System.out.println("\nO depósito na conta número: " + numero + " foi efetuado com sucesso!");
		} else
			System.out.println("\nA conta número: " + numero + " não foi encontrada ou a conta destino não é uma conta corrente!");
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if (contaOrigem != null && contaDestino != null ) {
			
			if (contaOrigem.sacar(valor) == true) {
				contaDestino.depositar(valor);
				System.out.println("\nA transferência foi efetuada com sucesso!");
			}
		} else
			System.out.println("\nA conta de origem e/ou destino não foram encontradas!");
		
	}
	public int gerarNumero() {
		return ++ numero;
	}


	public contaBancaria buscarNaCollection(int numero) {
		for (var contaBancaria : listaContas) {
			if (contaBancaria.getNumero() == numero) {
				return contaBancaria;
			}
		}
		return null;
	}
}


