package org.example;

import daoImplements.AlunoDAOImplements;
import daoImplements.ProfessorDAOImplements;
import Database.sqlConn;
import model.Aluno;
import model.Professor;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        sqlConn.testeConnction();

        AlunoDAOImplements alunoDaoMethods = new AlunoDAOImplements();
        ProfessorDAOImplements professorDaoMethods = new ProfessorDAOImplements();

        Scanner sc = new Scanner(System.in);

        int opcao;

        do {

            System.out.println("\n======= MENU =======");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Atualizar Aluno");
            System.out.println("3. Excluir Aluno");
            System.out.println("4. Listar Alunos");
            System.out.println("5. Buscar Aluno por ID");

            System.out.println("6. Cadastrar Professor");
            System.out.println("7. Atualizar Professor");
            System.out.println("8. Excluir Professor");
            System.out.println("9. Listar Professores");
            System.out.println("10. Buscar Professor por ID");

            System.out.println("0. Sair do programa");

            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                // =========================================================
                // ALUNO
                // =========================================================

                case 1:

                    System.out.println("Cadastro de aluno:");

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
                            System.out.println("Data inválida. Mantendo valor anterior.");
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

                // =========================================================
                // PROFESSOR
                // =========================================================

                case 6:

                    System.out.println("Cadastro de professor:");

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

                // =========================================================
                // SAIR
                // =========================================================

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