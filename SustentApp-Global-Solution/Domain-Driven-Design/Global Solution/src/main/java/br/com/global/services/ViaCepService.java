package br.com.global.services;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import br.com.global.models.Endereco;
import br.com.global.exceptions.Excecao;

public class ViaCepService {

    public Endereco getEndereco(String cep) {
        Endereco endereco = null;

        try {
            HttpGet request = new HttpGet("https://viacep.com.br/ws/" + cep + "/json/");

            CloseableHttpClient httpClient = HttpClientBuilder.create().disableRedirectHandling().build();

            CloseableHttpResponse response = httpClient.execute(request);

            HttpEntity entity = response.getEntity();

            if (entity != null) {
                String result = EntityUtils.toString(entity);

                Gson gson = new Gson();

                endereco = gson.fromJson(result, Endereco.class);
            }
        } catch (ClientProtocolException e) {
            new Excecao(e);
        } catch (IOException e) {
            new Excecao(e);
        }

        return endereco;
    }
}
