package pro.sky.calculator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.calculator.service.CalculatorService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    @GetMapping
    public String welcome() {
        return "Добро пожаловать в калькулятор";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(name = "num1", required = false) Integer a,
                       @RequestParam(name = "num2", required = false) Integer b) {
        if (a == null || b == null) return "не переданно одно из значений";
        int plus = calculatorService.plus(a, b);
        return a + " + " + b + "= " + plus;
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(name = "num1", required = false) Integer a,
                        @RequestParam(name = "num2", required = false) Integer b) {
        if (a == null || b == null) return "не переданно одно из значений";
        int minus = calculatorService.minus(a, b);
        return a + " - " + b + "= " + minus;
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(name = "num1", required = false) Integer a,
                           @RequestParam(name = "num2", required = false) Integer b) {
        if (a == null || b == null) return "не переданно одно из значений";
        int multiply = calculatorService.multiply(a, b);
        return a + " * " + b + "= " + multiply;
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(name = "num1", required = false) Integer a,
                         @RequestParam(name = "num2", required = false) Integer b) {
        if (a == null || b == null) return "не переданно одно из значений";
        double divide;
        try {
            divide = calculatorService.divide(a, b);
        } catch (Throwable e) {
            return e.getMessage();
        }
        return a + " / " + b + "= " + divide;
    }


}
