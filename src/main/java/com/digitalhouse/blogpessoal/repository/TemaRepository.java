package com.digitalhouse.blogpessoal.repository;

import com.digitalhouse.blogpessoal.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository <Tema, Integer> {
    public Tema findByTema (String postagem);
}
