package com.example.controller;

//import org.springframework.security.core.context.SecurityContextHolder;
import com.example.model.ViecLam;
import com.example.repository.ViecLamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.utils.StudentUtils;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class InliningController {

    private final ViecLamRepository viecLamRepository;

    @GetMapping("/a")
    public String showAddUserForm(ViecLam viecLam, Model model) {
        model.addAttribute("viecLam", viecLam);
        return "index.html";
    }


    @PostMapping("/a")
    public String test(@Valid ViecLam vl, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("viecLam", vl);
            return "index.html";
        }
        viecLamRepository.save(new ViecLam());

        return "index.html";
    }

    @RequestMapping(value = "/html", method = RequestMethod.GET)
    public String getExampleHTML(Model model) {
        model.addAttribute("title", "Baeldung");
        model.addAttribute("description", "<strong>Thymeleaf</strong> tutorial");
        return "inliningExample.html";
    }

    @RequestMapping(value = "/js", method = RequestMethod.GET)
    public String getExampleJS(Model model) {
        model.addAttribute("students", StudentUtils.buildStudents());
        return "studentCheck.js";
    }

//    @RequestMapping(value = "/plain", method = RequestMethod.GET)
//    public String getExamplePlain(Model model) {
//        model.addAttribute("username", SecurityContextHolder.getContext().getAuthentication().getName());
//        model.addAttribute("students", StudentUtils.buildStudents());
//        return "studentsList.txt";
//    }
}
