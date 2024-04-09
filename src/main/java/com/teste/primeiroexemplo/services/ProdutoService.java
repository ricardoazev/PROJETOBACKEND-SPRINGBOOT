package com.teste.primeiroexemplo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teste.primeiroexemplo.model.Produto;
import com.teste.primeiroexemplo.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Metodo para retorna uma lista de produtos
     * @return Lista de produtos.
     */
    public List<Produto> obterTodos() {
       return produtoRepository.obterTodos();
    }

    /**
     * Metodo que retorna o produto pele seu id
     * @param id do produto que sera localizado
     * @return Retorna um produto caso seja o encontrado
     */
    public Optional<Produto> obterPorId(Integer id) {
       return produtoRepository.obterPorId(id);
    }

    /**
     * Metodo Para adicionar produto na lista
     * @param produto que será adicionado
     * @return produto adiconado na lista
     */
    public Produto adicionar(Produto produto) {
        //Aqui poderia ter uma logicavde validação
        return produtoRepository.adicionar(produto);
    }

    /**
     * Metodo para deletar produto por id
     * @param id do produto que sera deletado
     */
    public void deletar(Integer id) {
        //Aqui poderia ter uma logicavde validação
        produtoRepository.deletar(id);
    }

     /**
     * Metodo para atualizar o produto na lista
     * @param produto que sera atualizado
     * @param id do produto
     * @return o produto apos atualizar a lista
     */
    public Produto atualizar(Integer id, Produto produto) {
        //Aqui pode ter uma regra de validação
        produto.setId(id);

        return produtoRepository.atualizar(produto);
        
    }

}
