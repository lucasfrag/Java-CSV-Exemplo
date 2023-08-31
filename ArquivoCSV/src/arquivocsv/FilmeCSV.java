package arquivocsv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FilmeCSV {
        // Caminho do arquivo
        private static String nomeArquivo = "./dados/Filmes.csv";
    
        // Método para adicionar um filme ao arquivo CSV
        public static void AdicionarFilme(Filme f) {
            try {
                // Verificar se o arquivo já existe
                boolean arquivoExiste = new File(nomeArquivo).exists();
                
                // Abre o escritor para adicionar dados ao arquivo
                FileWriter escritor = new FileWriter(nomeArquivo, StandardCharsets.ISO_8859_1, true);
                if (!arquivoExiste) {
                    escritor.write("Nome;Nota;Assistido\n");
                }
                
                // Escrever os dados do filme no formato apropriado
                escritor.write(f.getNome() + ";" + f.getNota() + ";" + f.isAssistindo() + "\n");
                
                // Escrever todos os dados do buffer no arquivo imediatamente
                escritor.flush();
                
                // Fecha o recurso de escrita
                escritor.close();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        // Método para listar os filmes do arquivo CSV
        public static ArrayList<Filme> ListarFilme() {
            ArrayList<Filme> lista = new ArrayList<>();
            
            try {
                // Abrir o leitor para ler o arquivo
                BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
                String linha;
                boolean primeiraLinha = true;
                
                while ( (linha = leitor.readLine()) != null ) {
                    // Ignora a primeira linha 
                    if (primeiraLinha) {
                        primeiraLinha = false;
                        continue;
                    }
                    
                    // Dividir a linha em partes usando o ponto e vírgula como separador
                    String[] partes = linha.split(";");
                    
                    String nome = partes[0];
                    double nota = Double.parseDouble(partes[1]);
                    boolean assistido = Boolean.parseBoolean(partes[2]);
                    
                    // Criar o objeto filme
                    Filme f = new Filme(nome, nota, assistido);
                    
                    // Adiciona na lista
                    lista.add(f);
                    
                    // Imprimir informações do filme
                    System.out.println("Nome: " + nome + " - Nota: " + nota + " - Assistido: " + assistido);
                }
                
                leitor.close();
                
            } catch(IOException e) {
                e.printStackTrace();
            }
            
            return lista;
        }
}
