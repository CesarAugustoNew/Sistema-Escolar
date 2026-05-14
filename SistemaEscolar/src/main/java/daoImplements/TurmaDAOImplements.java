package daoImplements;

import Database.sqlConn;
import dao.ITurmaDAO;
import model.Aluno;
import model.Turma;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAOImplements implements ITurmaDAO {

    @Override
    public List<Turma> listarTodasTurmas() {

        String sql = "SELECT * FROM turma ORDER BY turno DESC, nome ASC";

        List<Turma> turmas = new ArrayList<>();

        try (Connection conn = sqlConn.getConnection();
             PreparedStatement stnt = conn.prepareStatement(sql);
             ResultSet rs = stnt.executeQuery()) {

            while (rs.next()) {

                turmas.add(new Turma(
                        rs.getInt("id"),
                        rs.getInt("instituicao_id"),
                        rs.getInt("professor_id"),
                        rs.getString("nome"),
                        rs.getInt("ano_letivo"),
                        rs.getString("turno"),
                        rs.getInt("vagas")
                ));
            }

        } catch (SQLException e) {

            System.out.println("Erro ao listar turmas: " + e.getMessage());
        }

        return turmas;
    }

    @Override
    public List<Aluno> listarAlunosPorTurmaID(int turmaId) {

        String sql =
                "SELECT a.* " +
                        "FROM matricula m " +
                        "INNER JOIN aluno a ON m.aluno_id = a.id " +
                        "WHERE m.turma_id = ? " +
                        "ORDER BY a.nome ASC";

        List<Aluno> alunos = new ArrayList<>();

        try (Connection conn = sqlConn.getConnection();
             PreparedStatement stnt = conn.prepareStatement(sql)) {

            stnt.setInt(1, turmaId);

            ResultSet rs = stnt.executeQuery();

            while (rs.next()) {

                alunos.add(new Aluno(
                        String.valueOf(rs.getInt("id")),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getDate("data_nascimento").toLocalDate(),
                        rs.getString("telefone")
                ));
            }

        } catch (SQLException e) {

            System.out.println("Erro ao listar alunos da turma: " + e.getMessage());
        }

        return alunos;
    }
}