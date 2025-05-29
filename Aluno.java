public class Aluno {
    private String matricula;
    private String nome;
    private String curso;
    private String email;

    public Aluno (String matricula, String nome, String curso, String email){
        setMatricula(matricula);
        setNome(nome);
        setCurso(curso);
        setEmail(email);
    }

    public String getMatricula() {
        return matricula;
    }
    private void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso.toUpperCase();
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    
}
