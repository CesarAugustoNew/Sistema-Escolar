package daoImplements;

import Database.sqlConn;
import dao.IProfessorDAO;
import model.Professor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAOImplements implements IProfessorDAO {

    @Override
    public void salvarProfessor(Professor professor) {

        String sql = "INSERT INTO professor " +
                "(instituicao_id, nome, cpf, email, titulacao) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = sqlConn.getConnection();
             PreparedStatement stnt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stnt.setInt(1, professor.getInstituicaoId());
            stnt.setString(2, professor.getNome());
            stnt.setString(3, professor.getCpf());
            stnt.setString(4, professor.getEmail());
            stnt.setString(5, professor.getTitulacao());

            stnt.executeUpdate();

            ResultSet generatedKeys = stnt.getGeneratedKeys();

            if (generatedKeys.next()) {
                professor.setId(String.valueOf(generatedKeys.getInt(1)));
            }

            System.out.println("Professor cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar professor: " + e.getMessage());
        }
    }

    @Override
    public List<Professor> listarTodosProfessores() {

        String sql = "SELECT * FROM professor ORDER BY nome ASC";

        List<Professor> professores = new ArrayList<>();

        try (Connection conn = sqlConn.getConnection();
             PreparedStatement stnt = conn.prepareStatement(sql);
             ResultSet rs = stnt.executeQuery()) {

            while (rs.next()) {

                professores.add(new Professor(
                        String.valueOf(rs.getInt("id")),
                        rs.getInt("instituicao_id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("titulacao")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar professores: " + e.getMessage());
        }

        return professores;
    }

    @Override
    public Professor buscarProfessorPorId(int id) {

        String sql = "SELECT * FROM professor WHERE id = ?";

        Professor professor = null;

        try (Connection conn = sqlConn.getConnection();
             PreparedStatement stnt = conn.prepareStatement(sql)) {

            stnt.setInt(1, id);

            ResultSet rs = stnt.executeQuery();

            if (rs.next()) {

                professor = new Professor(
                        String.valueOf(rs.getInt("id")),
                        rs.getInt("instituicao_id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getString("titulacao")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar professor: " + e.getMessage());
        }

        return professor;
    }

    @Override
    public void atualizarProfessor(Professor professor) {

        String sql = "UPDATE professor " +
                "SET instituicao_id = ?, nome = ?, cpf = ?, email = ?, titulacao = ? " +
                "WHERE id = ?";

        try (Connection conn = sqlConn.getConnection();
             PreparedStatement stnt = conn.prepareStatement(sql)) {

            stnt.setInt(1, professor.getInstituicaoId());
            stnt.setString(2, professor.getNome());
            stnt.setString(3, professor.getCpf());
            stnt.setString(4, professor.getEmail());
            stnt.setString(5, professor.getTitulacao());
            stnt.setInt(6, Integer.parseInt(professor.getId()));

            int linhasAtualizadas = stnt.executeUpdate();

            if (linhasAtualizadas > 0) {
                System.out.println("Professor atualizado com sucesso!");
            } else {
                System.out.println("Professor não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar professor: " + e.getMessage());
        }
    }

    @Override
    public void excluirProfessor(int id) {

        String sql = "DELETE FROM professor WHERE id = ?";

        try (Connection conn = sqlConn.getConnection();
             PreparedStatement stnt = conn.prepareStatement(sql)) {

            stnt.setInt(1, id);

            int linhasExcluidas = stnt.executeUpdate();

            if (linhasExcluidas > 0) {
                System.out.println("Professor excluído com sucesso!");
            } else {
                System.out.println("Professor não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir professor: " + e.getMessage());
        }
    }
}