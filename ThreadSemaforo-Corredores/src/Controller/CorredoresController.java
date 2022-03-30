package Controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class CorredoresController extends Thread {
	
	int distancia = 200;
	
	Random randomVel = new Random();
	int velocidade = randomVel.nextInt(4, 6);
	
	int _pessoaId;
	public static Semaphore porta = new Semaphore(1);
	
	public CorredoresController(int pessoaId) {
		this._pessoaId = pessoaId;
	}
	
	public void run() {
		try {
			this.caminhar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void caminhar() throws InterruptedException {
		int distanciaPercorrida = 0;
		while(this.distancia >= 0) {
			this.distancia -= this.velocidade;
			distanciaPercorrida += this.velocidade;
			
			if(distanciaPercorrida > 200) {
				distanciaPercorrida = 200;
			}
			
			System.out.println(String.format("Pessoa %d andou %d metros", this._pessoaId, distanciaPercorrida));
			
			Thread.sleep(1000);
		}
		
		CorredoresController.porta.acquire();
		this.entrar();
		CorredoresController.porta.release();
	}
	
	public void entrar() throws InterruptedException {
		Random random = new Random();
		
		int abrir = random.nextInt(1000, 2000);
		
		Thread.sleep(abrir);
		
		System.out.println(String.format("Pessoa %d passou pela porta", this._pessoaId));
	}
	
}
