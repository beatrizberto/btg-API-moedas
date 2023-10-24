package br.com.ada.btgfaztech.apimoedas.servico;

import br.com.ada.btgfaztech.apimoedas.modelo.CotacaoMoeda;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Map;

@Service
public class CotacaoMoedaServico {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "https://economia.awesomeapi.com.br/json";


//    public ApiCotacaoResponse obterCotacaoMoeda(String moeda) throws IOException {
//        String url = baseUrl + "/last/" + moeda;
//        /*ResponseEntity<Map<String, Map<String, Object>>> response = restTemplate.exchange(
//                url, HttpMethod.GET, null,
//                new ParameterizedTypeReference<Map<String, Map<String, Object>>>() {}
//        );*/
//
//        ResponseEntity<ApiCotacaoResponse> response = restTemplate.exchange(
//                url, HttpMethod.GET, null, new ParameterizedTypeReference<ApiCotacaoResponse>() {});
//
//        if (response.getStatusCode() == HttpStatus.OK) {
//            ObjectMapper objectMapper = new ObjectMapper();
//            ApiCotacaoResponse objetoJava = objectMapper.readValue((DataInput) response.getBody(), ApiCotacaoResponse.class);
//            return objetoJava;
//    } else {
//        //throw new MoedaNaoEncontradaException("Moeda não encontrada.");
//        throw new RuntimeException();
//    }
//
////        ApiCotacaoResponse cotacoes = response.getBody();
////        if (cotacoes != null && cotacoes.getCodein().equals(moeda)) {
////            //Map<String, Object> info = cotacoes.get(moeda);
////            //return new BigDecimal(info.get("bid").toString());
////            return cotacoes;
//
//
//    }
//}

    public Map<String, CotacaoMoeda> obterCotacaoMoeda(String moeda) throws IOException {
        String url = baseUrl + "/last/" + moeda;

        ResponseEntity<Map<String, CotacaoMoeda>> response =
                restTemplate.exchange(url, HttpMethod.GET, null, new
                        ParameterizedTypeReference<Map<String, CotacaoMoeda>>() {});
        if (response.getStatusCode().is2xxSuccessful() &&
                response.hasBody()) {
            return response.getBody();

        } else {
            throw new RuntimeException("Erro ao obter a cotação da moeda.");
        }
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



