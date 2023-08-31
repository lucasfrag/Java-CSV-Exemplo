package arquivocsv;

public class Filme {
    // Atributos
    private String nome;
    private double nota;
    private boolean assistindo;
    
    // Métodos construtor
    public Filme(String nome, double nota, boolean assistindo) {
        this.nome = nome;
        this.nota = nota;
        this.assistindo = assistindo;
    }
    
    // Métodos Get e Set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public boolean isAssistindo() {
        return assistindo;
    }

    public void setAssistindo(boolean assistindo) {
        this.assistindo = assistindo;
    }
    
    
}
