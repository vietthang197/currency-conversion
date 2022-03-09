package vn.neo.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import vn.neo.dto.CurrencyExchangeDto;

/**
 * @author thanglv on 3/9/2022
 * @project currency-conversion
 */
/*Khi dùng OpenFeign với spring discovery server thì không cần phải chỉ ra url của service khác
Nếu như mà không dùng chung với eureka discovery server thì phải chỉ ra url này
 */
@FeignClient(name = "currency-exchange-service"/*, url = "${currency-exchange.url}"*/)
public interface CurrencyExchangeProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    CurrencyExchangeDto exchange(@PathVariable String from, @PathVariable String to);
}
