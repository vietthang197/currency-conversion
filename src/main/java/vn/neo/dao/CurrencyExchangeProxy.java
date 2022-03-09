package vn.neo.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.neo.dto.CurrencyExchangeDto;

/**
 * @author thanglv on 3/9/2022
 * @project currency-conversion
 */
@FeignClient(name = "currency-exchange", url = "${currency-exchange.url}")
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyExchangeDto exchange(@PathVariable String from, @PathVariable String to);
}
