@RestController // Diz que isso responde requisições HTTP
@RequestMapping("/api/produtos") // URL base para todas as rotas
public class ProdutoController {

    @Autowired // Injeta o Service automaticamente
    private ProdutoService produtoService;

    // GET /api/produtos - Busca todos os produtos
    @GetMapping
    public List<Produto> listar() {
        return produtoService.buscarTodos();
    }

    // GET /api/produtos/1 - Busca um produto específico
    @GetMapping("/{id}")
    public Produto obter(@PathVariable Long id) {
        return produtoService.buscarPorId(id);
    }

    // POST /api/produtos - Cria um novo produto
    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return produtoService.criar(produto);
    }

    // PUT /api/produtos/1 - Atualiza um produto
    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        return produtoService.atualizar(id, produto);
    }

    // DELETE /api/produtos/1 - Deleta um produto
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        produtoService.deletar(id);
    }
}
