package com.example.jwt_example.service;

import com.example.jwt_example.dto.PagingResponse;
import com.example.jwt_example.model.BankBlock;
import com.example.jwt_example.repository.BankBlockRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BankBlockS {
    final BankBlockRepo bankBlockRepo;

    public BankBlockS(BankBlockRepo bankBlockRepo) {
        this.bankBlockRepo = bankBlockRepo;
    }

    public List<BankBlock> getAllBankBlock(){
        return bankBlockRepo.getAllBankBlock();
    }

    public BankBlock getBankBlockById(Integer id){
        return bankBlockRepo.getBankBlockById(id);
    }

    public PagingResponse getAllBankBlockPaging(int pageNum, int pageSize) {
        if (pageNum < 0){
            pageNum = 0;
        }
        if (pageSize <= 0){
            pageSize = 10;
        }
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<BankBlock> bankBlockPage = bankBlockRepo.getAllBankBlockPaging(pageable);
        List<?> bankBlockList = bankBlockPage.stream().toList();

        PagingResponse pagingResponse = new PagingResponse();
        pagingResponse.setContent(bankBlockList);
        pagingResponse.setPageNum(bankBlockPage.getNumber());
        pagingResponse.setPageSize(bankBlockPage.getSize());
        pagingResponse.setTotalPages(bankBlockPage.getTotalPages());
        pagingResponse.setTotalElements(bankBlockPage.getTotalElements());
        pagingResponse.setLast(bankBlockPage.isLast());

        return pagingResponse;
    }

    public BankBlock save(BankBlock bankBlockDto) {
        BankBlock bankBlock = new BankBlock();
        bankBlock.setCode(bankBlockDto.getCode());
        bankBlock.setName_uz(bankBlockDto.getName_uz());
        bankBlock.setName_ru(bankBlockDto.getName_ru());
        bankBlock.setName_en(bankBlockDto.getName_en());
        bankBlock.setDeputy_id(bankBlockDto.getDeputy_id());
        bankBlock.setCondition(bankBlockDto.getCondition());

        return bankBlockRepo.save(bankBlock);
    }

    public int getBlockCount(){
        return bankBlockRepo.getBlockCount();
    }
}
