package controller;

import java.util.concurrent.Semaphore;

public class ThreadCozinha extends Thread {

	private int idThread;
	private String nomePrato;
	private static int tempo;
	private static double porcentagem;
	private Semaphore semaforo;
	private static int cont;

	public ThreadCozinha(int idThread, Semaphore semaforo) {
		super();
		this.idThread = idThread;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		try {
			semaforo.acquire();
			Cozimento();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			Entrega();
			semaforo.release();
		}
	}

	public void Cozimento() {
		if (idThread % 2 == 0) {
			tempo = (int) (Math.random() * 1200) + 600;
			nomePrato = "Lasanha a Bolonhesa ";
		} else {
			tempo = (int) (Math.random() * 800) + 500;
			nomePrato = "Sopa de Cebola ";
		}
		tempo = (int) (Math.random() * 1200) + 600;
		porcentagem = tempo / 100;
		cont = (int) porcentagem;
		while (cont <= 100) {
			try {
				sleep((long) porcentagem);
				System.out.println(nomePrato + cont + "% pronto");
				cont += porcentagem;
				if (cont > 100) {
					cont = 100;
					System.out.println(nomePrato + cont + "% pronto");
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(nomePrato + "ficou pronto \n");
	}

	public void Entrega() {
		System.out.println("Entregando " + nomePrato + "...");
		try {
			sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Prato entregue\n");
	}
}
