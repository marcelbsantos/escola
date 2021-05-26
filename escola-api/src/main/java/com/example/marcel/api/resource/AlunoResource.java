package com.example.marcel.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.marcel.api.event.RecursoCriadoEvent;
import com.example.marcel.api.model.Aluno;
import com.example.marcel.api.repository.AlunoRepository;
import com.example.marcel.api.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoResource {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping
	public List<Aluno> listar(){
		return alunoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Aluno> criar(@Valid @RequestBody Aluno aluno, HttpServletResponse response) {
		
		Aluno alunoSalvo = alunoRepository.save(aluno);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, alunoSalvo.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(alunoSalvo);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Aluno> buscarpeloCodigo(@PathVariable Long codigo) {
		Aluno alunoRetorno = alunoRepository.findOne(codigo);
		return alunoRetorno != null ? ResponseEntity.ok(alunoRetorno) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		alunoRepository.delete(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Aluno> atualizar(@PathVariable Long codigo, @Valid @RequestBody Aluno aluno){
		Aluno alunoSalvo = alunoService.atualizar(codigo, aluno);
		return ResponseEntity.ok(alunoSalvo);
	}
	
}
