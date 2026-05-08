package daoImplements;

import Database.sqlConn;
import dao.IAlunoDAO;
import model.Aluno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAOImplements implements IAlunoDAO {

    @Override
    public void salvarAluno(Aluno aluno) {
        String sql = "INSERT INTO aluno (nome, cpf, email, data_nascimento, telefone) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = sqlConn.getConnection();
             PreparedStatement stnt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stnt.setString(1, aluno.getNome());
            stnt.setString(2, aluno.getCpf());
            stnt.setString(3, aluno.getEmail());
            stnt.setDate(4, java.sql.Date.valueOf(aluno.getDataNascimento()));
            stnt.setString(5, aluno.getTelefone());

            stnt.executeUpdate();

            // Recupera o ID gerado
            ResultSet generatedKeys = stnt.getGeneratedKeys();
            if (generatedKeys.next()) {
                aluno.setId(String.valueOf(generatedKeys.getInt(1)));
            }

            System.out.println("Aluno cadastrado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar aluno: " + e.getMessage());
        }
    }

    @Override
    public List<Aluno> listarTodosAlunos() {
        String sql = "SELECT * FROM aluno ORDER BY nome ASC";
        List<Aluno> alunos = new ArrayList<>();

        try (Connection conn = sqlConn.getConnection();
             PreparedStatement stnt = conn.prepareStatement(sql);
             ResultSet rs = stnt.executeQuery()) {

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
            System.out.println("Erro ao listar os alunos: " + e.getMessage());
        }

        return alunos;
    }

    @Override
    public Aluno buscarAlunoPorId(int id) {
        String sql = "SELECT * FROM aluno WHERE id = ?";
        Aluno aluno = null;

        try (Connection conn = sqlConn.getConnection();
             PreparedStatement stnt = conn.prepareStatement(sql)) {

            stnt.setInt(1, id);
            ResultSet rs = stnt.executeQuery();

            if (rs.next()) {
                aluno = new Aluno(
                        String.valueOf(rs.getInt("id")),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getDate("data_nascimento").toLocalDate(),
                        rs.getString("telefone")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar aluno por ID: " + e.getMessage());
        }

        return aluno;
    }

    @Override
    public void atualizarAluno(Aluno aluno) {
        String sql = "UPDATE aluno SET nome = ?, cpf = ?, email = ?, data_nascimento = ?, telefone = ? WHERE id = ?";

        try (Connection conn = sqlConn.getConnection();
             PreparedStatement stnt = conn.prepareStatement(sql)) {

            stnt.setString(1, aluno.getNome());
            stnt.setString(2, aluno.getCpf());
            stnt.setString(3, aluno.getEmail());
            stnt.setDate(4, java.sql.Date.valueOf(aluno.getDataNascimento()));
            stnt.setString(5, aluno.getTelefone());
            stnt.setInt(6, Integer.parseInt(aluno.getId()));

            int linhasAtualizadas = stnt.executeUpdate();
            if (linhasAtualizadas > 0) {
                System.out.println("Aluno atualizado com sucesso!");
            } else {
                System.out.println("Aluno não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar aluno: " + e.getMessage());
        }
    }

    @Override
    public void excluirAluno(int id) {
        String sql = "DELETE FROM aluno WHERE id = ?";

        try (Connection conn = sqlConn.getConnection();
             PreparedStatement stnt = conn.prepareStatement(sql)) {

            stnt.setInt(1, id);
            int linhasExcluidas = stnt.executeUpdate();

            if (linhasExcluidas > 0) {
                System.out.println("Aluno excluído com sucesso!");
            } else {
                System.out.println("Aluno não encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir aluno: " + e.getMessage());
        }
    }
}