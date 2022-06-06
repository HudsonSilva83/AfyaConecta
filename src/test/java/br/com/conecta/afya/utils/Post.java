package br.com.conecta.afya.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public class Post {

	public static void main(String[] args) throws Exception {

		 //Sending get request
		 URL url = new
		 URL("https://conectadev.azurewebsites.net//user/register-fluig");
		 HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		 String json ="{\"beneficios\":[{\"tipo\":\"VA_VR\"},{\"tipo\":\"SAUDE\",\"descricao\":\"enfermaria\"},{\"tipo\":\"ONDONTO\"},{\"tipo\":\"VT\"}],\"cargo\":\"Analista\",\"coligada\":1,\"cpf\":\"78075328078\",\"email\":\"hu.psilva@gmail.com\",\"filial\":1,\"idPlataforma\":\"00008\",\"name\":\"HudsonSilva\",\"nomeBanco\":\"TODOS\",\"nomeSocial\":\"HudsonSilva\",\"telefone\":\"031994143659\",\"unidade\":\"AFYA\",\"salario\":\"3000.00\"}";
		 StringEntity entity = new StringEntity(json);
		
		 conn.setRequestProperty("Authorization", "Bearer"
		 +
		 "ei6pI6WkAfNfdvPSbu7jOc5XuFGVz67ij0uL/5xG4hf1fLpoQsONTZO1V9++U+B9MWACsIrRd69oX3dVz1G9Z6KJHPYdoVFfyo2BzPGimPpGgR6udpnvQCgKgRfzlF4ffhGTLztJq+LVMKDBHf7NG5Xs3+BOX3FgKdZNTWERRC+jvva5U9h4NDHGSJio683eW29aY7ERWOBRibjduGulXqwrOGmuVN7k9x8FY6w9Mmb0qxfsIBrvKEQEm43qoMsdglNH7iavrzTbGJ7ZT7aPeA==");
		 conn.setRequestProperty("Content-Type", "application/json");
		 conn.setRequestProperty("Accept", "application/json");
		 conn.setRequestMethod("POST");
		
		 BufferedReader in = new BufferedReader(new
		 InputStreamReader(conn.getInputStream()));
		 String output;
		
		 StringBuffer response = new StringBuffer();
		 while ((output = in.readLine()) != null) {
		 response.append(output);
		 }
		
		 in.close();
		 // printing result from response
		 System.out.println("Response:-" + response.toString());
		

	}

}
