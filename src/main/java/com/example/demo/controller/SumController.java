// src/main/java/com/example/demo/controller/SumController.java

package com.example.demo.controller;

import com.example.demo.MyBigNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SumController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/sum")
    public String sum(@RequestParam("number1") String number1,
                      @RequestParam("number2") String number2,
                      Model model) {
        MyBigNumber myBigNumber = new MyBigNumber();
        String result = myBigNumber.sum(number1, number2);
        String log = myBigNumber.getLog();

        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("result", result);
        model.addAttribute("log", log);

        return "result";
    }
}
