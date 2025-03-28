# Análise de Sentimento de Tweets para Campeonato Online

## Descrição

Este projeto tem como objetivo realizar a análise de sentimentos de tweets durante um campeonato de jogos online. Através de uma análise simples baseada em listas de palavras positivas e negativas, o sistema será capaz de determinar a percepção dos usuários sobre o jogo em tempo real.

## Funcionalidades

- **Captura de Tweets**: O sistema coleta tweets durante as partidas.
- **Análise de Sentimento**: Baseado em uma lista de palavras positivas e negativas, o sistema classifica os tweets como **positivos**, **negativos** ou **descartados**.
- **Contagem de Resultados**: O sistema informa o número de tweets capturados, o número de tweets positivos e negativos.

## Tecnologias Utilizadas

- **Java**
- **Spring Boot**
- **Kafka** (para a captura e envio dos tweets)
- **Hibernate**
- **H2** (banco de dados para persistência dos dados)
- **Docker**

## Como Funciona

1. **Captura de Tweets**: O sistema recebe tweets de uma plataforma de microblogging (como o Twitter) em tempo real.
2. **Análise de Sentimento**: Cada tweet é verificado em relação às listas de palavras positivas e negativas.
   - Se o tweet contiver palavras positivas, ele será classificado como **positivo**.
   - Se contiver palavras negativas, será classificado como **negativo**.
   - Se não contiver palavras de nenhuma das listas, o tweet será descartado.
3. **Exibição de Resultados**: Ao final, o sistema retorna:
   - O total de tweets capturados
   - O total de tweets positivos
   - O total de tweets negativos

## Como Rodar o Projeto

### Pré-requisitos

- Java 11 ou superior
- Apache Kafka
- Maven ou Gradle para gerenciamento de dependências
- Docker para iniciar o kafka:
  ```bash
  docker pull apache/kafka:4.0.0
  ```
  
  ```bash
  docker run -p 9092:9092 apache/kafka:4.0.0
  ````


### Passo para execução:

1. Clone o repositório:

```bash
git clone https://github.com/SamuelRicardos/analise-de-tweets.git
```

2- Inicie o projeto:

### Endpoints disponíveis:

http://localhost:8081/api/kafka/send
