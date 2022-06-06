package br.com.conecta.afya.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class ExcluirDependentes {

	public StatusLine excluirDependentes() throws IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpDelete method = new HttpDelete("https://conectadev.azurewebsites.net/teste/excluir-dependentes");
		HttpResponse response = client.execute(method);
		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
		String output;
		StringBuilder sb = new StringBuilder();
		while ((output = br.readLine()) != null) {
			sb.append(output);
		}

		//System.out.println(sb);
		client.close();
		
		
		return response.getStatusLine();
		
		
	}

}
