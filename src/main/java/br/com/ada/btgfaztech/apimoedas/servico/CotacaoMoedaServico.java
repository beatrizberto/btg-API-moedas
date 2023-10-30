package br.com.ada.btgfaztech.apimoedas.servico;

import br.com.ada.btgfaztech.apimoedas.controlador.exception.ValidaMoedaErro;
import br.com.ada.btgfaztech.apimoedas.modelo.CotacaoMoeda;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CotacaoMoedaServico {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "https://economia.awesomeapi.com.br/json";

    public CotacaoMoeda obterCotacaoMoeda(String moeda) {
        String url = baseUrl + "/last/" + moeda;
        ResponseEntity<Map<String, CotacaoMoeda>> response;

        try {
            response = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<Map<String, CotacaoMoeda>>() {
            });

        } catch (RuntimeException ex) {
            throw new ValidaMoedaErro();
        }

        if (response.getStatusCode().is2xxSuccessful() && response.hasBody()) {
            Map<String, CotacaoMoeda> cotacaoMoeda = response.getBody();

            for (String key : cotacaoMoeda.keySet()) {
                return cotacaoMoeda.get(key);
            }
        }

        return null;
    }
}