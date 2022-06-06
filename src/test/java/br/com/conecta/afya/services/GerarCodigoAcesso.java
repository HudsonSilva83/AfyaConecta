package br.com.conecta.afya.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import br.com.conecta.afya.utils.Util;



public class GerarCodigoAcesso {

	//static String webService = "https://conectadev.azurewebsites.net/user/register-fluig-teste";
	static String webService = "https://conectadev.azurewebsites.net/teste/register-fluig";
	static int codigoSucesso = 200;

	public static String gerarCodigoAcesso() throws Exception {
		String urlParaChamada = webService;

		try {
			URL url = new URL(urlParaChamada);
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

			if (conexao.getResponseCode() != codigoSucesso)
				throw new RuntimeException("HTTP error code : " + conexao.getResponseCode());

			BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
			String codigo = Util.converteJsonEmString(resposta);

			return codigo;
		} catch (Exception e) {
			throw new Exception("ERRO: " + e);
		}

	}

	

}
