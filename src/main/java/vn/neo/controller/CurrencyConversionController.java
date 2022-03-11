package vn.neo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.neo.dao.CurrencyExchangeProxy;
import vn.neo.dto.CurrencyExchangeDto;

import javax.servlet.http.HttpServletRequest;

/**
 * @author thanglv on 3/9/2022
 * @project currency-conversion
 */
@RestController
@RequestMapping("/currency-conversion")
public class CurrencyConversionController {
    private final Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);
    private final CurrencyExchangeProxy currencyExchangeProxy;

    public CurrencyConversionController(CurrencyExchangeProxy currencyExchangeProxy) {
        this.currencyExchangeProxy = currencyExchangeProxy;
    }

    @GetMapping("/dummy")
    @PreAuthorize("hasAuthority('SCOPE_currency-conversion-scope')")
    public CurrencyExchangeDto exchangeDummy(HttpServletRequest httpServletRequest) {
        return currencyExchangeProxy.exchange("USD", "XXX");
    }
}
