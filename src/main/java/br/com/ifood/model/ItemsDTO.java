package br.com.ifood.model;

public class ItemsDTO {

    private String nome;

    public ItemsDTO(String nome) {
        this.nome = nome;
    }

    @SuppressWarnings("unused")
    private ItemsDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
