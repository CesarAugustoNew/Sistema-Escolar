package daoImplements;

import Database.sqlConn;
import dao.IAlunoDAO;
import model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AlunoDAOImplements implements IAlunoDAO {
    @Override
    public void salvarAluno(Aluno aluno) {


    }

    @Override
    public List<Aluno> listarTodosAlunos()
    {
        String sql = "SELECT * FROM aluno ORDER BY nome ASC";
        List<Aluno> alunos = new ArrayList<>();



        try (Connection conn = sqlConn.getConnection()) {
            PreparedStatement stnt = conn.prepareStatement(sql);
            ResultSet rs = stnt.executeQuery();


            while(rs.next()){
                alunos.add(new Aluno(
                        rs.getString("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("email"),
                        rs.getDate("data_nascimento").toLocalDate(),
                        rs.getString("telefone")

                ));
            }

        }catch (SQLException e){
            System.out.println("Erro ao listar os alunos:" + e.getMessage());
        }

        return alunos;
    }

    @Override
    public void atualizarAluno(Aluno aluno) {

    }

    @Override
    public void excluirAluno(int id) {

    }
}
