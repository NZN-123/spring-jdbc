package org.example.springjdbc.controller;

import lombok.RequiredArgsConstructor;
import org.example.springjdbc.Service.BankService;
import org.example.springjdbc.dto.AccountFormDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor

public class MainController {
    private final BankService bankService; // 서비스 구현체가 Component Scan으로 Bean 등록 X

    @GetMapping("/")
    public String index(Model model) { // Return으로 나오는 String을 view resolver가 처리
        model.addAttribute("accounts", bankService.getAccounts());
        return "index";
    }

    @PostMapping("/")
    public String makeAccount(@ModelAttribute AccountFormDTO dto) {
        System.out.println("dto = " + dto);
        bankService.makeAccount(dto);
        return "redirect:/";
    }
}