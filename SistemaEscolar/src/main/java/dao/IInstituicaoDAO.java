package dao;

import model.Instituicao;
import java.util.List;

public interface IInstituicaoDAO {

    // CREATE
    void salvarInstituicao(Instituicao instituicao);

    // READ
    List<Instituicao> listarTodasInstituicoes();

    Instituicao buscarInstituicaoPorId(int id);

    // UPDATE
    void atualizarInstituicao(Instituicao instituicao);

    // DELETE
    void excluirInstituicao(int id);
}