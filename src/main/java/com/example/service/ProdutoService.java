@Service // Diz que isso é um serviço
public class ProdutoService {

    @Autowired // Injeta automaticamente o Repository
    private ProdutoRepository produtoRepository;

    // Buscar todos os produtos
    public List<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }

    // Buscar um produto por ID
    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    // Criar novo produto
    public Produto criar(Produto produto) {
        if (produto.getPreco() <= 0) {
            throw new RuntimeException("Preço deve ser maior que 0");
        }
        return produtoRepository.save(produto);
    }

    // Atualizar produto
    public Produto atualizar(Long id, Produto produtoAtualizado) {
        Produto produto = buscarPorId(id);
        produto.setNome(produtoAtualizado.getNome());
        produto.setPreco(produtoAtualizado.getPreco());
        return produtoRepository.save(produto);
    }

    // Deletar produto
    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }
}
