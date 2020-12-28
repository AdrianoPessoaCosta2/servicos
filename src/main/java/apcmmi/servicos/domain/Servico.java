package apcmmi.servicos.domain;

public class Servico {
    private String name;

    public Servico(String name) {
        this.name = name;
    }

    public Servico() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
