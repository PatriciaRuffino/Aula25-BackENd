package com.digitalhouse.blogpessoal.repository;

import com.digitalhouse.blogpessoal.model.Postagem;
import com.digitalhouse.blogpessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostagemRepository extends JpaRepository <Postagem, Integer>  {
    public List<Postagem> findByPostagem (String postagem);
}
