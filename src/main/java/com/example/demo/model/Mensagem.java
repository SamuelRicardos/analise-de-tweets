package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="mensagens")
public class Mensagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_mensagem;
    private String mensagem;
    private String sentimento;

    public String getSentimento() {
        return sentimento;
    }

    public void setSentimento(String sentimento) {
        this.sentimento = sentimento;
    }

    public Long getId_mensagem() {
        return id_mensagem;
    }

    public void setId_mensagem(Long id_mensagem) {
        this.id_mensagem = id_mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String message) {
        this.mensagem = message;
    }
}
