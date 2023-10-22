package br.com.ada.btgfaztech.apimoedas.controlador.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ApiCotacaoResponse {

    private String code;
    private String codein;
    private String name;
    private String high;
    private String low;
    private String varBid;
    private String pctChange;
    private String bid;
    private BigDecimal ask;
    private String timestamp;
    private String create_date;



}
