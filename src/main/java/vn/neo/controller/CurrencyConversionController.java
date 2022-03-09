package vn.neo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.neo.dao.CurrencyExchangeProxy;
import vn.neo.dto.CurrencyExchangeDto;

/**
 * @author thanglv on 3/9/2022
 * @project currency-conversion
 */
@RestController
@RequestMapping("/currency-conversion")
public class CurrencyConversionController {

    private final CurrencyExchangeProxy currencyExchangeProxy;

    public CurrencyConversionController(CurrencyExchangeProxy currencyExchangeProxy) {
        this.currencyExchangeProxy = currencyExchangeProxy;
    }

    @GetMapping("/dummy")
    public CurrencyExchangeDto exchangeDummy() {
        return currencyExchangeProxy.exchange("USD", "XXX");
    }
}
