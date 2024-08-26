package com.example.jwt_example.controller;

import com.example.jwt_example.model.BankBlock;
import com.example.jwt_example.service.BankBlockS;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankBlockRC {
    private BankBlockS bankBlockS;

    public BankBlockRC(BankBlockS bankBlockS) {
        this.bankBlockS = bankBlockS;
    }

    @PostMapping("/bank-block/create")
    public BankBlock createUserReg(@RequestBody BankBlock bankBlock){
        return bankBlockS.save(bankBlock);
    }
}
