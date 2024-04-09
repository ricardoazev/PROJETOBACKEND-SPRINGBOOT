package com.teste.primeiroexemplo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.model.exception.ResourceNotFoundException;

@Repository
public class ProdutoRepository {
    
    private List<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;

    /**
     * Metodo para retorna uma lista de produtos
     * @return Lista de produtos.
     */
    public List<Produto> obterTodos(){
        return produtos;
    }

    /**
     * Metodo que retorna o produto pele seu id
     * @param id do produto que sera localizado
     * @return Retorna um produto caso seja o encontrado
     */
    public Optional<Produto> obterPorId(Integer id) {
        return produtos
                .stream()
                .filter(produto -> produto.getId() == id)
                .findFirst();
    }

    /**
     * Metodo Para adicionar produto na lista
     * @param produto que será adicionado
     * @return produto adiconado na lista
     */
    public Produto adicionar(Produto produto) {

        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);
        return produto;
    }

    /**
     * Metodo para deletar produto por id
     * @param id do produto que sera deletado
     */
    public void deletar(Integer id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * Metodo para atualizar o produto na lista
     * @param produto que sera atualizado
     * @return o produto apos atualizar az
     */
    public Produto atualizar(Produto produto) {
        //Encontrar produto
        Optional <Produto> produtoEncontrado = obterPorId(produto.getId());

        // Verificar se o produto foi encontrado
        if (produtoEncontrado.isEmpty()) {
            throw new ResourceNotFoundException("Produto não encontrado");
        }

        // Remover produto antigo da litsa
        deletar(produto.getId());

        //Depois adicionar o novo produto atualizado na lista
        produtos.add(produto);

        return produto;
        
    }


}
