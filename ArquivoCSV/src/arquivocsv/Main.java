package arquivocsv;

public class Main {

    public static void main(String[] args) {
        Filme f1 = new Filme("O Rei Leão", 10, true);
        
        // Adicionar filme ao arquivo
        FilmeCSV.AdicionarFilme(f1);
        
        // Ler filmes do arquivo
        FilmeCSV.ListarFilme();
        
    }
    
}
