package com.example.jwt_example.repository;

import com.example.jwt_example.model.BankBlock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankBlockRepo extends JpaRepository<BankBlock, Integer> {
    @Query("select new com.example.jwt_example.model.BankBlock(a.id, a.code, a.name_uz, a.name_ru, a.name_en, a.deputy_id, a.condition, a.create_date, a.delete_date) from BankBlock a order by a.id")
    Page<BankBlock> getAllBankBlockPaging(Pageable pageable);

    @Query("select new com.example.jwt_example.model.BankBlock(a.id, a.code, a.name_uz, a.name_ru, a.name_en, a.deputy_id, a.condition, a.create_date, a.delete_date) from BankBlock a where a.condition = '1' order by a.id")
    List<BankBlock> getAllBankBlock();

    @Query("select new com.example.jwt_example.model.BankBlock(a.id, a.code, a.name_uz, a.name_ru, a.name_en, a.deputy_id, a.condition, a.create_date, a.delete_date) from BankBlock a where a.id=:id and a.condition = '1' order by a.id")
    BankBlock getBankBlockById(Integer id);

    @Query("select count(a) from BankBlock a where a.condition='1'")
    int getBlockCount();
}
