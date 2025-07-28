package src.projeto;

import java.time.format.DateTimeFormatter;

public class tarefaSimples extends tarefa implements Marcavel {

    public tarefaSimples(String descricao, java.time.LocalDate prazo) throws DescInvalida {
        super(descricao, prazo);
    }

    @Override
    public void exibirInfo() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Tarefa Simples: " + descricao + " | Prazo: " +
                prazo.format(fmt) + " | Concluída: " + (concluida ? "Sim" : "Não"));
    }

    @Override
    public void marcarConcluida() throws tarefaConcluida {
        concluir();
        System.out.println("Tarefa '" + descricao + "' marcada como concluída.");
    }
}
