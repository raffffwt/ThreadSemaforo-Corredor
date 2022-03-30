package Main;

import Controller.CorredoresController;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 4; i++) {
			new CorredoresController((i+1)).start();
		}
	}

}
