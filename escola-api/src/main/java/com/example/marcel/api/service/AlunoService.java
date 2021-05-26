package com.example.marcel.api.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.marcel.api.model.Aluno;
import com.example.marcel.api.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public Aluno atualizar(Long codigo, Aluno aluno){
		
		Aluno alunoSalvo = alunoRepository.findOne(codigo);
		if(alunoSalvo == null){
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(aluno, alunoSalvo, "codigo");
		return alunoRepository.save(alunoSalvo);
	}
}
