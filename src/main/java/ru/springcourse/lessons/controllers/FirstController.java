package ru.springcourse.lessons.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.springcourse.lessons.Constants;
import ru.springcourse.lessons.validators.CalculatorParametersValidator;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false)String surname,
                            Model model) {
        model.addAttribute("message", "Hello, " + name + " " + surname);

        //System.out.println("Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(HttpServletRequest request, Model model){
        String firstNumber = request.getParameter("a");
        String secondNumber = request.getParameter("b");
        String action = request.getParameter("action");

        System.out.println(firstNumber + " " + secondNumber + " " + action);
        if (CalculatorParametersValidator.validateNumber(firstNumber) &&
                CalculatorParametersValidator.validateNumber(secondNumber)) {
            double first = Double.parseDouble(firstNumber);
            double second = Double.parseDouble(secondNumber);
            double result;
            switch (action) {
                case Constants.MULTIPLICATION:
                    result = first * second;
                    model.addAttribute("message", "Result of multiplication: " + result);
                    break;
                case Constants.DIVISION:
                    result = first / second;
                    model.addAttribute("message", "Result of division: " + result);
                    break;
                case Constants.ADDITION:
                    result = first + second;
                    model.addAttribute("message", "Result of addition: " + result);
                    break;
                case Constants.SUBTRACTION:
                    result = first - second;
                    model.addAttribute("message", "Result of subtraction: " + result);
                    break;
                default:
                    model.addAttribute("message", "Please, enter valid action");
                    break;
            }
        } else {
            model.addAttribute("message", "Please, enter valid numbers");
        }
        return "first/calculator";
    }
}
