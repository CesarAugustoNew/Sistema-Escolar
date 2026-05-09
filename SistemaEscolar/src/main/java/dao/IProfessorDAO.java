package dao;

import model.Professor;
import java.util.List;

public interface IProfessorDAO {

    // CREATE
    void salvarProfessor(Professor professor);

    // READ
    List<Professor> listarTodosProfessores();

    Professor buscarProfessorPorId(int id);

    // UPDATE
    void atualizarProfessor(Professor professor);

    // DELETE
    void excluirProfessor(int id);
}