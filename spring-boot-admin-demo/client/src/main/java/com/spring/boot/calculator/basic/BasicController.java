/**
 * @author Triprurari
 *
 *11-Sep-2021
*/
package com.spring.boot.calculator.basic;

import static com.spring.boot.calculator.model.ResultBuilder.getResult;
import static com.spring.boot.calculator.model.ResultBuilder.getResultFromError;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.calculator.model.ApiResult;


@RestController
@RequestMapping("/simple")
public class BasicController {
	Logger logger = LoggerFactory.getLogger(BasicController.class);

   @GetMapping("/add")
   public ApiResult add(@RequestParam BigDecimal augend, @RequestParam BigDecimal addend ) {
	   logger.trace("A TRACE Message");
       logger.debug("A DEBUG Message");
       logger.info("An INFO Message");
       logger.warn("A WARN Message");
       logger.error("An ERROR Message");

      return getResult(augend.add(addend));
   }

   @GetMapping("/subtract")
   public ApiResult subtract(@RequestParam BigDecimal minuent, @RequestParam BigDecimal subtrahend) {
      return getResult(minuent.subtract(subtrahend));
   }

   @GetMapping("/multiply")
   public ApiResult multiply(@RequestParam BigDecimal multiplier, @RequestParam BigDecimal multiplicand) {
      return getResult(multiplier.multiply(multiplicand));
   }

   @GetMapping("/divide")
   public ApiResult divide(@RequestParam BigDecimal dividend, @RequestParam BigDecimal divisor) {
      if (divisor.equals(BigDecimal.ZERO)) {
         return getResultFromError("no division by null");
      }
      return getResult(dividend.divide(divisor, RoundingMode.HALF_EVEN));
   }

}
