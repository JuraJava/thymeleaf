package com.hstn.thymeleaf.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/processPupilFormV2")
    public String correctName2(HttpServletRequest request, Model model) {
        // Такой способ лучше использовать когда у нас более одного параметра
        String oldNameLowerCase = request.getParameter("pupilName").toLowerCase();
        String correctName = "";
        String[] words = oldNameLowerCase.split(" ");
        for (String word : words) {
            String firstLetter = word.substring(0, 1).toUpperCase();
            word = firstLetter + word.substring(1);
            correctName += word + " ";
        }
        correctName = correctName.trim();
        model.addAttribute("correctName", correctName);
        return "pupil-info";
    }

    // Всё что выше можно сделать и по другому:

    @RequestMapping("/processPupilFormV3")
    public String correctName3(@RequestParam("pupilName") String pupilName, Model model) {
        // Такой способ лучше использовать когда у нас всего один параметр
        String oldNameLowerCase = pupilName.toLowerCase();
        String correctName = "";
        String[] words = oldNameLowerCase.split(" ");
        for (String word : words) {
            String firstLetter = word.substring(0, 1).toUpperCase();
            word = firstLetter + word.substring(1);
            correctName += word + " ";
        }
        correctName = correctName.trim();
        model.addAttribute("correctName", correctName);
        return "pupil-info";
    }

}
