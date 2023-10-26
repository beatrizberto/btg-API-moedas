package br.com.ada.btgfaztech.apimoedas.servico;

import br.com.ada.btgfaztech.apimoedas.modelo.CotacaoMoeda;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.Response;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import java.util.Optional;

@Service
public class CotacaoMoedaServico {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "https://economia.awesomeapi.com.br/json";

    public CotacaoMoeda obterCotacaoMoeda(String moeda) {
        String url = baseUrl + "/last/" + moeda;
        ResponseEntity<Map<String, CotacaoMoeda>> response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<Map<String, CotacaoMoeda>>() {
        });

        if (response.getStatusCode().is2xxSuccessful() && response.hasBody()) {
            Map<String, CotacaoMoeda> cotacaoMoeda = response.getBody();

            for (String key : cotacaoMoeda.keySet()) {
                return cotacaoMoeda.get(key);
            }
        }

        return null;
    }
}



//public List<CotacaoMoeda> obterCotacaoMoeda(String moeda) throws IOException {
//    String url = baseUrl + "/last/" + moeda;
//
//    ResponseEntity<String> response = restTemplate.exchange(
//            url, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}
//    );
//
//    if (response.getStatusCode().is2xxSuccessful()) {
//        List<CotacaoMoeda> cotacoes = response.getBody();
//        return cotacoes;
//    } else {
//        throw new RuntimeException("Erro ao obter a cotação da moeda.");
//    }
//}



