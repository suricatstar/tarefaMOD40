package com.example.repository;

@Repository  

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // JpaRepository já fornece métodos prontos!
    // findAll() - busca todos os produtos
    // findById(id) - busca um produto por ID
    // save(produto) - salva um novo produto
    // delete(produto) - deleta um produto
}
