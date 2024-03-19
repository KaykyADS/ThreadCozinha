package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCozinha;

public class Principal {

	public static void main(String[] args) {
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);

		for (int idThread = 1; idThread < 6; idThread++) {
			Thread tCozi = new ThreadCozinha(idThread, semaforo);
			tCozi.start();
		}

	}

}
