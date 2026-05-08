package org.example;

import daoImplements.AlunoDAOImplements;
import Database.sqlConn;
import model.Aluno;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        sqlConn.testeConnction();

        AlunoDAOImplements alunoDaoMethods = new AlunoDAOImplements();
        Scanner sc = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n======= MENU =======");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Atualizar Aluno");
            System.out.println("3. Excluir Aluno");
            System.out.println("4. Listar Alunos");
            System.out.println("5. Buscar Aluno por ID");
            System.out.println("0. Sair do programa");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
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

                    Aluno novoAluno = new Aluno(null, nome, cpf, email, dataNascimento, telefone);
                    alunoDaoMethods.salvarAluno(novoAluno);
                    break;

                case 2:
                    System.out.print("Digite o ID do aluno para atualizar: ");
                    int idAtualizar = sc.nextInt();
                    sc.nextLine();
                    Aluno alunoExistente = alunoDaoMethods.buscarAlunoPorId(idAtualizar);
                    if (alunoExistente == null) {
                        System.out.println("Aluno não encontrado.");
                        break;
                    }

                    System.out.print("Novo nome (" + alunoExistente.getNome() + "): ");
                    String novoNome = sc.nextLine();
                    if (!novoNome.isEmpty()) alunoExistente.setNome(novoNome);

                    System.out.print("Novo CPF (" + alunoExistente.getCpf() + "): ");
                    String novoCpf = sc.nextLine();
                    if (!novoCpf.isEmpty()) alunoExistente.setCpf(novoCpf);

                    System.out.print("Novo email (" + alunoExistente.getEmail() + "): ");
                    String novoEmail = sc.nextLine();
                    if (!novoEmail.isEmpty()) alunoExistente.setEmail(novoEmail);

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
                    if (!novoTel.isEmpty()) alunoExistente.setTelefone(novoTel);

                    alunoDaoMethods.atualizarAluno(alunoExistente);
                    break;

                case 3:
                    System.out.print("Digite o ID do aluno para excluir: ");
                    int idExcluir = sc.nextInt();
                    sc.nextLine();
                    alunoDaoMethods.excluirAluno(idExcluir);
                    break;

                case 4:
                    List<Aluno> todosAlunos = alunoDaoMethods.listarTodosAlunos();
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
                    Aluno alunoBuscado = alunoDaoMethods.buscarAlunoPorId(idBuscar);
                    if (alunoBuscado != null) {
                        System.out.println(alunoBuscado);
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;

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