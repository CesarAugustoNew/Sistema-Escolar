package dao;

import model.Aluno;

import java.util.List;

public interface IAlunoDAO {
    //Crud

    //C - create
    void salvar(Aluno aluno);

    //R - read
    List<Aluno> listarTodosAlunos();

    //U - update
    void atualizarAluno(Aluno aluno);

    //D - delete
    void excluirAluno(int id);

}
