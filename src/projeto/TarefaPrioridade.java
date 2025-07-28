package src.projeto;
import java.time.format.DateTimeFormatter;
public class TarefaPrioridade extends tarefa implements Marcavel {
    private int prioridade;
    public TarefaPrioridade(String descricao, java.time.LocalDate prazo, int prioridade) throws DescInvalida {
        super(descricao, prazo);
        if (prioridade < 1 || prioridade > 3) {
            this.prioridade = 3;
        } else {
            this.prioridade = prioridade;
        }
    }
    @Override
    public void exibirInfo() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String p;
        switch (prioridade) {
            case 1: p = "Alta"; break;
            case 2: p = "Média"; break;
            default: p = "Baixa";
        }
        System.out.println("Tarefa Prioritária: " + descricao + " | Prazo: " + prazo.format(fmt) +
                " | Prioridade: " + p + " | Concluída: " + (concluida ? "Sim" : "Não"));
    }

    @Override
    public void marcarConcluida() throws tarefaConcluida {
        concluir();
        System.out.println("Tarefa prioritária '" + descricao + "' marcada como concluída.");
    }
}
