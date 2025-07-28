package src.projeto;

import java.time.LocalDate;

public abstract class tarefa {
    protected String descricao;
    protected LocalDate prazo;
    protected boolean concluida;

    public tarefa(String descricao, LocalDate prazo) throws DescInvalida {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new DescInvalida("Descrição vazia não permitida!");
        }
        this.descricao = descricao;
        this.prazo = prazo;
        this.concluida = false;
    }

    public abstract void exibirInfo();

    public boolean Concluida() {
        return concluida;
    }
    public void concluir() throws tarefaConcluida {
        if (concluida) {
            throw new tarefaConcluida("tarefa já está concluída!");
        }
        this.concluida = true;
    }
}


