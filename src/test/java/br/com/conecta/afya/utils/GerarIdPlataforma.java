package br.com.conecta.afya.utils;

import java.util.Random;

public class GerarIdPlataforma {

	int IdPlataforma;

	public int gerarIdPlataforma() {

		Random gerador = new Random();

		for (int i = 0; i < 10; i++) {

			IdPlataforma = gerador.nextInt(999999999);

		}
		return IdPlataforma;

	}

}
