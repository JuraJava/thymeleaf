package com.hstn.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PupilController {

    @RequestMapping("/showPupilForm")
    // Параметры аннотации говорят о том, что этот метод будет доступен в
    // адресной строке по этому указанному в параметрах адресу.
    // Эта аннотация может обрабатывать не только Get - запрос, но и другие
    public String showPupilForm() {
        return "pupil-form";
        // С таким же названием как в кавычках должен быть далее создан
        // HTML файл в пакете templates
    }

    @RequestMapping("/processPupilForm")
    public String processPupilForm() {
        return "pupil-info";
    }

}
