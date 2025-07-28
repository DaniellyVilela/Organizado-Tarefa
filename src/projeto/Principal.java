package src.projeto;

import java.time.LocalDate;
import java.util.Scanner;

public class Principal {
    static final int MAX_TAREFAS = 5;
    static tarefa[] tarefas = new tarefa[MAX_TAREFAS];
    static int total = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== MENU TAREFAS ===");
            System.out.println("1 - Adicionar tarefa");
            System.out.println("2 - Exibir tarefas");
            System.out.println("3 - Concluir tarefa");
            System.out.println("4 - Excluir tarefa");
            System.out.println("5 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    if (total == MAX_TAREFAS) {
                        System.out.println("Limite de tarefas atingido!");
                        break;
                    }
                    try {
                        System.out.print("Descrição: ");
                        String desc = sc.nextLine();

                        System.out.print("Prazo (Ano-Mês-Dia) \nOBS: O formato deve conter - É NÃO /: ");
                        LocalDate prazo = LocalDate.parse(sc.nextLine());

                        System.out.print("Prioritária? (s/n): ");
                        String p = sc.nextLine();

                        if (p.equalsIgnoreCase("s")) {
                            System.out.print("Prioridade (1=Alta, 2=Média, 3=Baixa): ");
                            int pri = sc.nextInt();
                            sc.nextLine();
                            tarefas[total++] = new TarefaPrioridade(desc, prazo, pri);
                        } else {
                            tarefas[total++] = new tarefaSimples(desc, prazo);
                        }
                        System.out.println("Tarefa adicionada!");
                    } catch (DescInvalida e) {
                        System.out.println("Erro: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Erro ao adicionar tarefa: " + e.getMessage());
                    }
                    break;

                case 2:
                    if (total == 0) {
                        System.out.println("Nenhuma tarefa cadastrada.");
                    } else {
                        for (int i = 0; i < total; i++) {
                            System.out.print((i + 1) + " - ");
                            tarefas[i].exibirInfo();
                        }
                    }
                    break;

                case 3:
                    if (total == 0) {
                        System.out.println("Nenhuma tarefa para concluir.");
                    } else {
                        System.out.print("Número da tarefa para concluir: ");
                        int n = sc.nextInt() - 1;
                        sc.nextLine();
                        if (n >= 0 && n < total) {
                            try {
                                ((Marcavel) tarefas[n]).marcarConcluida();
                            } catch (tarefaConcluida e) {
                                System.out.println("Erro: " + e.getMessage());
                            } catch (Exception e) {
                                System.out.println("Erro inesperado: " + e.getMessage());
                            }
                        } else {
                            System.out.println("Número inválido!");
                        }
                    }
                    break;

                case 4:
                    if (total == 0) {
                        System.out.println("Nenhuma tarefa para excluir.");
                    } else {
                        System.out.print("Número da tarefa para excluir: ");
                        int n = sc.nextInt() - 1;
                        sc.nextLine();
                        if (n >= 0 && n < total) {
                            for (int i = n; i < total - 1; i++) {
                                tarefas[i] = tarefas[i + 1];
                            }
                            tarefas[--total] = null;
                            System.out.println("Tarefa excluída!");
                        } else {
                            System.out.println("Número inválido!");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Saindo do programa. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 5);

        sc.close();
    }
}
