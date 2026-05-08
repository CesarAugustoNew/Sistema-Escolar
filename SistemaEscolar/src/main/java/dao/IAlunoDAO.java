package dao;

import model.Aluno;
import java.util.List;

public interface IAlunoDAO {
    //C CREAT
    void salvarAluno(Aluno aluno);
    //R READ
    List<Aluno> listarTodosAlunos();
    Aluno buscarAlunoPorId(int id);
    //U UPDATE
    void atualizarAluno(Aluno aluno);
    // D DELETE
    void excluirAluno(int id);
}