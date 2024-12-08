package com.hstn.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/hello")
    public String helloWorld(Model model) {
        // Импортируем из предложенных ту, в которой указано springframework
        // В параметры передадим Model model т.к. это типа контейнер
        // между самим этим приложением и тем, что будет отображаться в браузере
        // ну и т.к. это типа контейнер, то мы можем добавлять туда переменную
        model.addAttribute("today", java.time.LocalDate.now());
        // в переменную model передаём ключ ("today") и
        // значение (сегодняшняя дата так обозн. в Java)
        return "helloworld";
        // здесь имеется ввиду, что вызовется этот templates view (вид, обзор),
        // который должен храниться в пакете templates
    }
}