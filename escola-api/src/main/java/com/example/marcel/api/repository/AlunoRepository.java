package com.example.marcel.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.marcel.api.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
