package com.digitalhouse.blogpessoal.controller;

import com.digitalhouse.blogpessoal.model.Postagem;
import com.digitalhouse.blogpessoal.model.Usuario;
import com.digitalhouse.blogpessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postagem")
public class PostagemController {
    @Autowired
    private PostagemRepository postagemRepository;

    @GetMapping
    private ResponseEntity<List<Postagem>> getAll(){ return ResponseEntity.ok(postagemRepository.findAll());}

    @GetMapping("/{id}")
    private ResponseEntity<Postagem> getById (@PathVariable Integer id){
        return postagemRepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/titulo/{titulo}")
    private ResponseEntity<List<Postagem>> getByTitulo (@PathVariable String titulo) {
        return ResponseEntity.ok(postagemRepository.findByTitulo(titulo));
    }
    @PutMapping
    private ResponseEntity<Postagem> put (@RequestBody Postagem postagem){
        return ResponseEntity.status(HttpStatus.OK).body(postagemRepository.save(postagem));
    }

    @PostMapping
    private ResponseEntity<Postagem>post (@RequestBody Postagem titulo ){
            return ResponseEntity.status(HttpStatus.CREATED).body(postagemRepository.save(titulo));

        }

    @DeleteMapping
    private void  delete (@PathVariable Integer id){
        postagemRepository.deleteById(id);
    }
}


