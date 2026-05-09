package daoImplements;

import Database.sqlConn;
import dao.IInstituicaoDAO;
import model.Instituicao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InstituicaoDAOImplements implements IInstituicaoDAO {

    @Override
    public void salvarInstituicao(Instituicao instituicao) {

        String sql = "INSERT INTO instituicao " +
                "(nome, cnpj, cidade, estado, email, telefone) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = sqlConn.getConnection();
             PreparedStatement stnt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stnt.setString(1, instituicao.getNome());
            stnt.setString(2, instituicao.getCnpj());
            stnt.setString(3, instituicao.getCidade());
            stnt.setString(4, instituicao.getEstado());
            stnt.setString(5, instituicao.getEmail());
            stnt.setString(6, instituicao.getTelefone());

            stnt.executeUpdate();

            ResultSet generatedKeys = stnt.getGeneratedKeys();

            if (generatedKeys.next()) {
                instituicao.setId(String.valueOf(generatedKeys.getInt(1)));
            }

            System.out.println("Instituição cadastrada com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar instituição: " + e.getMessage());
        }
    }

    @Override
    public List<Instituicao> listarTodasInstituicoes() {

        String sql = "SELECT * FROM instituicao ORDER BY nome ASC";

        List<Instituicao> instituicoes = new ArrayList<>();

        try (Connection conn = sqlConn.getConnection();
             PreparedStatement stnt = conn.prepareStatement(sql);
             ResultSet rs = stnt.executeQuery()) {

            while (rs.next()) {

                instituicoes.add(new Instituicao(
                        String.valueOf(rs.getInt("id")),
                        rs.getString("nome"),
                        rs.getString("cnpj"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("email"),
                        rs.getString("telefone")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar instituições: " + e.getMessage());
        }

        return instituicoes;
    }

    @Override
    public Instituicao buscarInstituicaoPorId(int id) {

        String sql = "SELECT * FROM instituicao WHERE id = ?";

        Instituicao instituicao = null;

        try (Connection conn = sqlConn.getConnection();
             PreparedStatement stnt = conn.prepareStatement(sql)) {

            stnt.setInt(1, id);

            ResultSet rs = stnt.executeQuery();

            if (rs.next()) {

                instituicao = new Instituicao(
                        String.valueOf(rs.getInt("id")),
                        rs.getString("nome"),
                        rs.getString("cnpj"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("email"),
                        rs.getString("telefone")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar instituição: " + e.getMessage());
        }

        return instituicao;
    }

    @Override
    public void atualizarInstituicao(Instituicao instituicao) {

        String sql = "UPDATE instituicao " +
                "SET nome = ?, cnpj = ?, cidade = ?, estado = ?, email = ?, telefone = ? " +
                "WHERE id = ?";

        try (Connection conn = sqlConn.getConnection();
             PreparedStatement stnt = conn.prepareStatement(sql)) {

            stnt.setString(1, instituicao.getNome());
            stnt.setString(2, instituicao.getCnpj());
            stnt.setString(3, instituicao.getCidade());
            stnt.setString(4, instituicao.getEstado());
            stnt.setString(5, instituicao.getEmail());
            stnt.setString(6, instituicao.getTelefone());
            stnt.setInt(7, Integer.parseInt(instituicao.getId()));

            int linhasAtualizadas = stnt.executeUpdate();

            if (linhasAtualizadas > 0) {
                System.out.println("Instituição atualizada com sucesso!");
            } else {
                System.out.println("Instituição não encontrada.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar instituição: " + e.getMessage());
        }
    }

    @Override
    public void excluirInstituicao(int id) {

        String sql = "DELETE FROM instituicao WHERE id = ?";

        try (Connection conn = sqlConn.getConnection();
             PreparedStatement stnt = conn.prepareStatement(sql)) {

            stnt.setInt(1, id);

            int linhasExcluidas = stnt.executeUpdate();

            if (linhasExcluidas > 0) {
                System.out.println("Instituição excluída com sucesso!");
            } else {
                System.out.println("Instituição não encontrada.");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao excluir instituição: " + e.getMessage());
        }
    }
}