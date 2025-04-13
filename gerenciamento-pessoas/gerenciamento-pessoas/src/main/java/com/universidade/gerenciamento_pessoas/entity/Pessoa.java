package com.universidade.gerenciamento_pessoas.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "pessoa")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private Integer idade;
}
