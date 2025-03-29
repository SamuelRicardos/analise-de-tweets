package com.example.demo.service;

import com.example.demo.model.Mensagem;
import com.example.demo.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class KafkaConsumerService {
    private final List<String> palavrasPositivas = Arrays.asList("bom", "excelente", "ótimo", "maravilhoso", "sensacional", "incrível", "otimo");
    private final List<String> palavrasNegativas = Arrays.asList("ruim", "péssimo", "pessimo","horrível", "horrivel", "terrível", "decepcionante", "fraco");

    private final AtomicInteger totalTweets = new AtomicInteger(0);
    private final AtomicInteger totalPositivos = new AtomicInteger(0);
    private final AtomicInteger totalNegativos = new AtomicInteger(0);

    @Autowired
    private MensagemRepository mensagemRepository;

    @KafkaListener(topics = "tweets", groupId = "meu-grupo")
    public void listen(String message) {
        totalTweets.incrementAndGet();

        String mensagemLower = message.toLowerCase();
        boolean isPositivo = palavrasPositivas.stream().anyMatch(mensagemLower::contains);
        boolean isNegativo = palavrasNegativas.stream().anyMatch(mensagemLower::contains);

        String sentimento;
        if (isPositivo) {
            totalPositivos.incrementAndGet();
            sentimento = "Positivo";
        } else if (isNegativo) {
            totalNegativos.incrementAndGet();
            sentimento = "Negativo";
        } else {
            sentimento = "Neutro";
        }

        Mensagem mensagem = new Mensagem();
        mensagem.setMensagem(message);
        mensagem.setSentimento(sentimento);

        mensagemRepository.save(mensagem);

        System.out.println("[" + sentimento + "] " + message);

        imprimirEstatisticas();
    }

    private void imprimirEstatisticas() {
        System.out.println("\nEstatísticas até agora:");
        System.out.println("Total de tweets processados: " + totalTweets.get());
        System.out.println("Tweets positivos: " + totalPositivos.get());
        System.out.println("Tweets negativos: " + totalNegativos.get());
        System.out.println("---------------------------");
    }
}
