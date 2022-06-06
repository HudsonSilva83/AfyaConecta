package br.com.conecta.afya.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.conecta.afya.model.Credenciais;
import br.com.conecta.afya.utils.GerarIdPlataforma;

public class ObterCPFSenha {

	public static Credenciais postCredenciais() throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("https://conectadev.azurewebsites.net//user/register-fluig");

		GerarIdPlataforma id = new GerarIdPlataforma();

		int IdPlataforma = id.gerarIdPlataforma();

		String json = "{\"beneficios\":[{\"tipo\":\"VA_VR\"},{\"tipo\":\"SAUDE\",\"descricao\":\"enfermaria\"},{\"tipo\":\"ONDONTO\"},{\"tipo\":\"VT\"}],\"cargo\":\"Analista\",\"coligada\":1,\"cpf\":\"77707180070\",\"email\":\"hu.psilva@gmail.com\",\"filial\":1,\"idPlataforma\":\""+IdPlataforma+"\",\"name\":\"HudsonSilva\",\"nomeBanco\":\"TODOS\",\"nomeSocial\":\"HudsonSilva\",\"telefone\":\"031994143659\",\"unidade\":\"AFYA\",\"salario\":\"3000.00\"}";
		StringEntity entity = new StringEntity(json);
		httpPost.setEntity(entity);

		httpPost.setHeader("Authorization", "Bearer "
				+ "ei6pI6WkAfNfdvPSbu7jObywn+N2Oak1Q0aTESZS5rLtOmaeeHbcLkjFIt4p9oaakJ3J7ClusU5k3k+hZ5byCSZC/4spU2Zjna+QDgMcPnzVa1MZuA4Wvy73P1hO0z91e5rU+GiPRdM63n1ktIGDYzVoUva2bNSy3+BhDEYpGSq+O049gJEO236lLBFg7VFdV84+TaWY4OpInOaCpwTJCKtBwceqBP5uP/aEGdTVpcPZkQfECVaJfPMFZqkuV6oChdzVHwcd4ZRHzq3NGg7ccQ==");

		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");

		CloseableHttpResponse response = client.execute(httpPost);

		String responseAsString = EntityUtils.toString(response.getEntity());

		Gson gson = new Gson();
		Credenciais credenciais = gson.fromJson(responseAsString, Credenciais.class);

		JsonObject jsonParse = JsonParser.parseString(responseAsString).getAsJsonObject();
		credenciais.setLogin(jsonParse.getAsJsonObject("data").get("login").getAsString());
		credenciais.setPassword(jsonParse.getAsJsonObject("data").get("password").getAsString());

	 System.out.println(responseAsString);
		// System.out.println(response.getStatusLine());
		// System.out.println(responseAsString.trim());
		 System.out.println(response.getStatusLine());
		
		client.close();
		return credenciais;
	}

}
