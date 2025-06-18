# Sistema de Ouvidoria - Java Swing

Este projeto é uma aplicação simples de ouvidoria desenvolvida em Java utilizando a biblioteca Swing (`JOptionPane`) para interação com o usuário via janelas gráficas. O sistema permite o gerenciamento básico de manifestações registradas pelos usuários.

## Funcionalidades

A aplicação oferece as seguintes funcionalidades:

- **Listar todas as manifestações**  
  Exibe todas as manifestações cadastradas até o momento. Caso não existam manifestações, o usuário é alertado.

- **Adicionar uma nova manifestação**  
  Solicita ao usuário um código numérico e a descrição da manifestação. A manifestação é então adicionada à lista principal.

- **Pesquisar uma manifestação por código**  
  Permite ao usuário digitar o código de uma manifestação e, se ela existir, exibe seus dados. Caso contrário, informa que o código não foi encontrado.

- **Remover uma manifestação pelo código**  
  O usuário pode remover uma manifestação existente informando seu código. Se o código for encontrado, a manifestação é removida com sucesso.

- **Sair**  
  Encerra o programa com uma mensagem de despedida.

## Estrutura do Projeto

- **Pacote `application`**
  - Contém a classe principal `Programa`, responsável pela execução do sistema e pelas interações com o usuário.

- **Pacote `entities`**
  - Contém a classe `Manifestacao`, que representa a estrutura de cada manifestação. Inclui campos como código e descrição, além de métodos utilitários como `toString`, `equals`, e `hashCode`.

## Lógica Geral

1. Ao iniciar, o sistema dá as boas-vindas ao usuário.
2. Um menu de opções é exibido em um loop até que o usuário escolha sair.
3. Cada opção aciona uma lógica específica de cadastro, busca, remoção ou listagem de manifestações.
4. As manifestações são armazenadas em uma lista na memória (`ArrayList`), sem persistência em banco de dados.
5. O sistema garante que códigos de manifestações sejam usados para identificar, buscar e remover itens de forma única.

## Observações

- O sistema é executado exclusivamente por meio de janelas gráficas (`JOptionPane`), sem interface em terminal/console.
- Não há verificação de duplicidade de códigos ao adicionar manifestações — isso pode ser adicionado em versões futuras.
- A aplicação é adequada para fins educacionais e introdução a conceitos de orientação a objetos, manipulação de listas, e interfaces gráficas simples em Java.

---

Desenvolvido como exercício prático de programação orientada a objetos com Java e Swing.
