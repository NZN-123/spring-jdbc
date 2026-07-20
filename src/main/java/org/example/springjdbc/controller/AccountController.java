package org.example.springjdbc.controller;

import lombok.RequiredArgsConstructor;
import org.example.springjdbc.Service.BankService;
import org.example.springjdbc.dto.AccountFormDTO;
import org.example.springjdbc.dto.AccountUpdateDTO;
import org.example.springjdbc.dto.AccountViewDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final BankService bankService;

    // /account/{id} - (/account)
//    @RequestMapping("/{id}") // PathVariable
    @GetMapping("/{id}") // PathVariable
    public String getAccountById(@PathVariable long id, Model model) {
        AccountViewDTO account = bankService.findAccount(id);
        model.addAttribute("account", account);
        return "account"; // views/account.jsp
    }

    @PostMapping("/{id}")
    public String updateAccount(
            @PathVariable long id,
            @ModelAttribute AccountFormDTO dto) {
        bankService.changeAccount(new AccountUpdateDTO(id, dto.name()));
        return "redirect:/account/%d".formatted(id); // views/account.jsp
    }

    @PostMapping("/{id}/delete")
    public String deleteAccount(@PathVariable long id) {
        bankService.deleteAccount(id);
        return "redirect:/";
    }
}
