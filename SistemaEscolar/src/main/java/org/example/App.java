
package org.example;

import daoImplements.AlunoDAOImplements;
import Database.sqlConn;
import model.Aluno;

import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        sqlConn.testeConnction();

        AlunoDAOImplements alunoDaoMethods = new AlunoDAOImplements();
        Scanner sc = new Scanner(System.in);

        int opcao;

        do{

            System.out.println("=======MENU=======");
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Atualizar Aluno");
            System.out.println("3. Excluir Aluno");
            System.out.println("4 Listar Aluno");
            System.out.println("0. Sair do programa");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1:
                    System.out.println("Cadrastro de aluno");
                    break;
                case 2:
                    System.out.println("Atualizar aluno");
                    break;
                case 3:
                    System.out.println("Excluir Aluno");
                    break;
                case 4:
                    System.out.println("Listar Alunos");

                    List<Aluno> todosAlunos = alunoDaoMethods.listarTodosAlunos();

                    if (todosAlunos.isEmpty())
                    {
                        System.out.println("Nenhum aluno encontrado.");
                    } else {
                        for (Aluno aluno : todosAlunos){
                            System.out.println(aluno);
                        }
                    }
            }

        }while (opcao !=0);


    }
}



