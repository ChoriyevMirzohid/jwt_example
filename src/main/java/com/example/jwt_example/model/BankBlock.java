package com.example.jwt_example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "BankBlock")
@Table(name = "bank_block")
public class BankBlock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10)
    private String code;

    @Column(length = 100)
    private String name_uz;

    @Column(length = 100)
    private String name_ru;

    @Column(length = 100)
    private String name_en;

    private Integer deputy_id;

    @Column(length = 3)
    private String condition;

    @CreationTimestamp
    private Timestamp create_date;

    private Timestamp delete_date;
}
