package org.example;

import Database.sqlConn;

import daoImplements.AlunoDAOImplements;
import daoImplements.ProfessorDAOImplements;
import daoImplements.InstituicaoDAOImplements;

import model.Aluno;
import model.Professor;
import model.Instituicao;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        sqlConn.testeConnction();

        AlunoDAOImplements alunoDaoMethods =
                new AlunoDAOImplements();

        ProfessorDAOImplements professorDaoMethods =
                new ProfessorDAOImplements();

        InstituicaoDAOImplements instituicaoDaoMethods =
                new InstituicaoDAOImplements();

        Scanner sc = new Scanner(System.in);

        int opcao;

        do {

            System.out.println("\n=========== MENU SISTEMA ESCOLAR ===========");

            // =====================================================
            // ALUNO
            // =====================================================

            System.out.println("\n========== ALUNO ==========");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Atualizar Aluno");
            System.out.println("3. Excluir Aluno");
            System.out.println("4. Listar Alunos");
            System.out.println("5. Buscar Aluno por ID");

            // =====================================================
            // PROFESSOR
            // =====================================================

            System.out.println("\n======== PROFESSOR ========");
            System.out.println("6. Cadastrar Professor");
            System.out.println("7. Atualizar Professor");
            System.out.println("8. Excluir Professor");
            System.out.println("9. Listar Professores");
            System.out.println("10. Buscar Professor por ID");

            // =====================================================
            // INSTITUIÇÃO
            // =====================================================

            System.out.println("\n======= INSTITUIÇÃO =======");
            System.out.println("11. Cadastrar Instituição");
            System.out.println("12. Atualizar Instituição");
            System.out.println("13. Excluir Instituição");
            System.out.println("14. Listar Instituições");
            System.out.println("15. Buscar Instituição por ID");

            System.out.println("\n0. Sair");

            System.out.print("\nEscolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                // =====================================================
                // ALUNO
                // =====================================================

                case 1:

                    System.out.println("\n=== Cadastro de Aluno ===");

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Data de nascimento (yyyy-MM-dd): ");
                    String dataStr = sc.nextLine();

                    LocalDate dataNascimento;

                    try {
                        dataNascimento = LocalDate.parse(dataStr);
                    } catch (DateTimeParseException e) {
                        System.out.println("Data inválida!");
                        break;
                    }

                    System.out.print("Telefone: ");
                    String telefone = sc.nextLine();

                    Aluno novoAluno = new Aluno(
                            null,
                            nome,
                            cpf,
                            email,
                            dataNascimento,
                            telefone
                    );

                    alunoDaoMethods.salvarAluno(novoAluno);

                    break;

                case 2:

                    System.out.print("Digite o ID do aluno para atualizar: ");

                    int idAtualizar = sc.nextInt();
                    sc.nextLine();

                    Aluno alunoExistente =
                            alunoDaoMethods.buscarAlunoPorId(idAtualizar);

                    if (alunoExistente == null) {

                        System.out.println("Aluno não encontrado.");
                        break;
                    }

                    System.out.print("Novo nome (" + alunoExistente.getNome() + "): ");
                    String novoNome = sc.nextLine();

                    if (!novoNome.isEmpty()) {
                        alunoExistente.setNome(novoNome);
                    }

                    System.out.print("Novo CPF (" + alunoExistente.getCpf() + "): ");
                    String novoCpf = sc.nextLine();

                    if (!novoCpf.isEmpty()) {
                        alunoExistente.setCpf(novoCpf);
                    }

                    System.out.print("Novo email (" + alunoExistente.getEmail() + "): ");
                    String novoEmail = sc.nextLine();

                    if (!novoEmail.isEmpty()) {
                        alunoExistente.setEmail(novoEmail);
                    }

                    System.out.print("Nova data de nascimento (" + alunoExistente.getDataNascimento() + "): ");
                    String novaData = sc.nextLine();

                    if (!novaData.isEmpty()) {

                        try {
                            alunoExistente.setDataNascimento(LocalDate.parse(novaData));
                        } catch (DateTimeParseException e) {
                            System.out.println("Data inválida.");
                        }
                    }

                    System.out.print("Novo telefone (" + alunoExistente.getTelefone() + "): ");
                    String novoTel = sc.nextLine();

                    if (!novoTel.isEmpty()) {
                        alunoExistente.setTelefone(novoTel);
                    }

                    alunoDaoMethods.atualizarAluno(alunoExistente);

                    break;

                case 3:

                    System.out.print("Digite o ID do aluno para excluir: ");

                    int idExcluir = sc.nextInt();
                    sc.nextLine();

                    alunoDaoMethods.excluirAluno(idExcluir);

                    break;

                case 4:

                    List<Aluno> todosAlunos =
                            alunoDaoMethods.listarTodosAlunos();

                    if (todosAlunos.isEmpty()) {

                        System.out.println("Nenhum aluno encontrado.");

                    } else {

                        for (Aluno aluno : todosAlunos) {
                            System.out.println(aluno);
                        }
                    }

                    break;

                case 5:

                    System.out.print("Digite o ID do aluno para buscar: ");

                    int idBuscar = sc.nextInt();
                    sc.nextLine();

                    Aluno alunoBuscado =
                            alunoDaoMethods.buscarAlunoPorId(idBuscar);

                    if (alunoBuscado != null) {

                        System.out.println(alunoBuscado);

                    } else {

                        System.out.println("Aluno não encontrado.");
                    }

                    break;

                // =====================================================
                // PROFESSOR
                // =====================================================

                case 6:

                    System.out.println("\n=== Cadastro de Professor ===");

                    System.out.print("ID da instituição: ");
                    int instituicaoId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nomeProfessor = sc.nextLine();

                    System.out.print("CPF: ");
                    String cpfProfessor = sc.nextLine();

                    System.out.print("Email: ");
                    String emailProfessor = sc.nextLine();

                    System.out.print("Titulação (GRADUACAO, ESPECIALIZACAO, MESTRADO, DOUTORADO): ");
                    String titulacao = sc.nextLine().toUpperCase();

                    Professor novoProfessor = new Professor(
                            instituicaoId,
                            nomeProfessor,
                            cpfProfessor,
                            emailProfessor,
                            titulacao
                    );

                    professorDaoMethods.salvarProfessor(novoProfessor);

                    break;

                case 7:

                    System.out.print("Digite o ID do professor para atualizar: ");

                    int idProfessorAtualizar = sc.nextInt();
                    sc.nextLine();

                    Professor professorExistente =
                            professorDaoMethods.buscarProfessorPorId(idProfessorAtualizar);

                    if (professorExistente == null) {

                        System.out.println("Professor não encontrado.");
                        break;
                    }

                    System.out.print("Novo nome (" + professorExistente.getNome() + "): ");
                    String novoNomeProfessor = sc.nextLine();

                    if (!novoNomeProfessor.isEmpty()) {
                        professorExistente.setNome(novoNomeProfessor);
                    }

                    System.out.print("Novo CPF (" + professorExistente.getCpf() + "): ");
                    String novoCpfProfessor = sc.nextLine();

                    if (!novoCpfProfessor.isEmpty()) {
                        professorExistente.setCpf(novoCpfProfessor);
                    }

                    System.out.print("Novo email (" + professorExistente.getEmail() + "): ");
                    String novoEmailProfessor = sc.nextLine();

                    if (!novoEmailProfessor.isEmpty()) {
                        professorExistente.setEmail(novoEmailProfessor);
                    }

                    System.out.print("Nova titulação (" + professorExistente.getTitulacao() + "): ");
                    String novaTitulacao = sc.nextLine();

                    if (!novaTitulacao.isEmpty()) {
                        professorExistente.setTitulacao(novaTitulacao.toUpperCase());
                    }

                    professorDaoMethods.atualizarProfessor(professorExistente);

                    break;

                case 8:

                    System.out.print("Digite o ID do professor para excluir: ");

                    int idProfessorExcluir = sc.nextInt();
                    sc.nextLine();

                    professorDaoMethods.excluirProfessor(idProfessorExcluir);

                    break;

                case 9:

                    List<Professor> professores =
                            professorDaoMethods.listarTodosProfessores();

                    if (professores.isEmpty()) {

                        System.out.println("Nenhum professor encontrado.");

                    } else {

                        for (Professor professor : professores) {
                            System.out.println(professor);
                        }
                    }

                    break;

                case 10:

                    System.out.print("Digite o ID do professor para buscar: ");

                    int idProfessorBuscar = sc.nextInt();
                    sc.nextLine();

                    Professor professorBuscado =
                            professorDaoMethods.buscarProfessorPorId(idProfessorBuscar);

                    if (professorBuscado != null) {

                        System.out.println(professorBuscado);

                    } else {

                        System.out.println("Professor não encontrado.");
                    }

                    break;

                // =====================================================
                // INSTITUIÇÃO
                // =====================================================

                case 11:

                    System.out.println("\n=== Cadastro de Instituição ===");

                    System.out.print("Nome: ");
                    String nomeInstituicao = sc.nextLine();

                    System.out.print("CNPJ: ");
                    String cnpj = sc.nextLine();

                    System.out.print("Cidade: ");
                    String cidade = sc.nextLine();

                    System.out.print("Estado: ");
                    String estado = sc.nextLine();

                    System.out.print("Email: ");
                    String emailInstituicao = sc.nextLine();

                    System.out.print("Telefone: ");
                    String telefoneInstituicao = sc.nextLine();

                    Instituicao novaInstituicao = new Instituicao(
                            nomeInstituicao,
                            cnpj,
                            cidade,
                            estado,
                            emailInstituicao,
                            telefoneInstituicao
                    );

                    instituicaoDaoMethods.salvarInstituicao(novaInstituicao);

                    break;

                case 12:

                    System.out.print("Digite o ID da instituição para atualizar: ");

                    int idInstituicaoAtualizar = sc.nextInt();
                    sc.nextLine();

                    Instituicao instituicaoExistente =
                            instituicaoDaoMethods.buscarInstituicaoPorId(idInstituicaoAtualizar);

                    if (instituicaoExistente == null) {

                        System.out.println("Instituição não encontrada.");
                        break;
                    }

                    System.out.print("Novo nome (" + instituicaoExistente.getNome() + "): ");
                    String novoNomeInstituicao = sc.nextLine();

                    if (!novoNomeInstituicao.isEmpty()) {
                        instituicaoExistente.setNome(novoNomeInstituicao);
                    }

                    System.out.print("Novo CNPJ (" + instituicaoExistente.getCnpj() + "): ");
                    String novoCnpj = sc.nextLine();

                    if (!novoCnpj.isEmpty()) {
                        instituicaoExistente.setCnpj(novoCnpj);
                    }

                    System.out.print("Nova cidade (" + instituicaoExistente.getCidade() + "): ");
                    String novaCidade = sc.nextLine();

                    if (!novaCidade.isEmpty()) {
                        instituicaoExistente.setCidade(novaCidade);
                    }

                    System.out.print("Novo estado (" + instituicaoExistente.getEstado() + "): ");
                    String novoEstado = sc.nextLine();

                    if (!novoEstado.isEmpty()) {
                        instituicaoExistente.setEstado(novoEstado);
                    }

                    System.out.print("Novo email (" + instituicaoExistente.getEmail() + "): ");
                    String novoEmailInstituicao = sc.nextLine();

                    if (!novoEmailInstituicao.isEmpty()) {
                        instituicaoExistente.setEmail(novoEmailInstituicao);
                    }

                    System.out.print("Novo telefone (" + instituicaoExistente.getTelefone() + "): ");
                    String novoTelefoneInstituicao = sc.nextLine();

                    if (!novoTelefoneInstituicao.isEmpty()) {
                        instituicaoExistente.setTelefone(novoTelefoneInstituicao);
                    }

                    instituicaoDaoMethods.atualizarInstituicao(instituicaoExistente);

                    break;

                case 13:

                    System.out.print("Digite o ID da instituição para excluir: ");

                    int idInstituicaoExcluir = sc.nextInt();
                    sc.nextLine();

                    instituicaoDaoMethods.excluirInstituicao(idInstituicaoExcluir);

                    break;

                case 14:

                    List<Instituicao> instituicoes =
                            instituicaoDaoMethods.listarTodasInstituicoes();

                    if (instituicoes.isEmpty()) {

                        System.out.println("Nenhuma instituição encontrada.");

                    } else {

                        for (Instituicao instituicao : instituicoes) {
                            System.out.println(instituicao);
                        }
                    }

                    break;

                case 15:

                    System.out.print("Digite o ID da instituição para buscar: ");

                    int idInstituicaoBuscar = sc.nextInt();
                    sc.nextLine();

                    Instituicao instituicaoBuscada =
                            instituicaoDaoMethods.buscarInstituicaoPorId(idInstituicaoBuscar);

                    if (instituicaoBuscada != null) {

                        System.out.println(instituicaoBuscada);

                    } else {

                        System.out.println("Instituição não encontrada.");
                    }

                    break;

                // =====================================================
                // SAIR
                // =====================================================

                case 0:

                    System.out.println("Saindo do programa...");
                    break;

                default:

                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}