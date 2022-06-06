package br.com.conecta.afya.utils;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Teste {

		
	public void whenPostJsonUsingHttpClient_thenCorrect() 
			  throws ClientProtocolException, IOException {
			    CloseableHttpClient client = HttpClients.createDefault();
			    HttpPost httpPost = new HttpPost("https://conectadev.azurewebsites.net//user/register-fluig");

			    String json = "{\"beneficios\":[{\"tipo\":\"VA_VR\"},{\"tipo\":\"SAUDE\",\"descricao\":\"enfermaria\"},{\"tipo\":\"ONDONTO\"},{\"tipo\":\"VT\"}],\"cargo\":\"Analista\",\"coligada\":1,\"cpf\":\"78075328078\",\"email\":\"hu.psilva@gmail.com\",\"filial\":1,\"idPlataforma\":\"4454872234\",\"name\":\"HudsonSilva\",\"nomeBanco\":\"TODOS\",\"nomeSocial\":\"HudsonSilva\",\"telefone\":\"031994143659\",\"unidade\":\"AFYA\",\"salario\":\"3000.00\"}";
			    StringEntity entity = new StringEntity(json);
			    httpPost.setEntity(entity);
			    
			    httpPost.setHeader("Authorization", "Bearer "+"ei6pI6WkAfNfdvPSbu7jObywn+N2Oak1Q0aTESZS5rLtOmaeeHbcLkjFIt4p9oaakJ3J7ClusU5k3k+hZ5byCSZC/4spU2Zjna+QDgMcPnzVa1MZuA4Wvy73P1hO0z91e5rU+GiPRdM63n1ktIGDYzVoUva2bNSy3+BhDEYpGSq+O049gJEO236lLBFg7VFdV84+TaWY4OpInOaCpwTJCKtBwceqBP5uP/aEGdTVpcPZkQfECVaJfPMFZqkuV6oChdzVHwcd4ZRHzq3NGg7ccQ==");
			   		 
			    httpPost.setHeader("Accept", "application/json");
			    httpPost.setHeader("Content-type", "application/json");

			    CloseableHttpResponse response = client.execute(httpPost);
			    //assertThat(response.getStatusLine().getStatusCode());
			    
			    String responseAsString = EntityUtils.toString(response.getEntity());
//			     System.out.println(responseAsString);
//			     System.out.println(response.getStatusLine());
			     System.out.println(responseAsString.replace("\"{\"data:\"", ""));
			    System.out.println(response.getStatusLine());
			    client.close();
			}
}
