package com.example.jwt_example.controller;

import com.example.jwt_example.model.BankBlock;
import com.example.jwt_example.service.BankBlockS;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class BankBlockC {
    private BankBlockS bankBlockS;

    public BankBlockC(BankBlockS bankBlockS) {
        this.bankBlockS = bankBlockS;
    }

    @GetMapping("/bank-block")
    public String getPageEdit(
            @RequestParam(value = "num", defaultValue = "0", required = false) int num,
            @RequestParam(value = "size", defaultValue = "10", required = false) int size,
            Model model,
            HttpSession session){
        model.addAttribute("conditionList", List.of(1,2,3));
        model.addAttribute("list", bankBlockS.getAllBankBlockPaging(num, size));
        return "bank-block";
    }

    @PostMapping("/bank-block/new")
    public String createUserReg(@ModelAttribute("userReg") BankBlock bankBlock){
        bankBlockS.save(bankBlock);
        return "redirect:/bank-block";
    }
}
