# 📚 Repositório de Desenvolvimento API Restful

Bem-vindo ao repositório de Desenvolvimento API Restful! Este repositório foi criado para organizar e documentar os projetos e práticas realizados durante o desenvolvimento de APIs seguindo o padrão RESTful.

## 📑 Conteúdo

O repositório está organizado da seguinte forma:

### 📖 `aulas_Api`
- **Códigos e exemplos práticos desenvolvidos durante as aulas teóricas, focando em conceitos fundamentais do desenvolvimento de APIs Restful.**

### 💡 `meus_Projetos`
- **Projetos desenvolvidos de forma prática, como forma de reforço e aplicação dos conceitos estudados. Esses projetos podem incluir desafios reais ou cenários simulados para resolução.**

### 🚀 `projetos_Individuais_Api`
- **Projeto individual desenvolvido durante a disciplina, que serve como avaliação dos conhecimentos adquiridos.**

---

### 🎬 API ImperialFlix (Cinema/Filme)

#### Descrição

A **ImperialFlix API** foi desenvolvida para gerenciar a relação entre cinema e filmes. Ela oferece endpoints para criar, recuperar, atualizar e deletar cinemas e filmes.


## Endpoints

### Operações de Cinema

- `GET /cinemas`: Retorna a lista de cinema.
- `GET /cinemas/{id}`: Retorna os detalhes de um cinema específico com base no ID.
- `POST /cinemas`: Cria um novo cinema.
- `PUT /cinemas/{id}`: Atualiza as informações de um cinema existente.
- `DELETE /cinemas/{id}`: Remove um cinema pelo ID.
- `GET /cinemas/count`: Retorna a quantidade total de cinemas cadastrados.

### Operações de Filme

- `GET /filmes`: Retorna a lista de todos os filmes.
- `GET /filmes/{id}`: Retorna os detalhes de um filme específico com base no ID.
- `POST /filmes`: Cria um novo filme.
- `PUT /filmes/{id}`: Atualiza as informações de um filme existente.
- `DELETE /filmes/{id}`: Remove um filme pelo ID.
- `GET /filmes/count`: Retorna a quantidade total de filmes cadastrados.


## Relacionamento entre Entidades (OneToMany, ManyToOne, OneToOne)

### ManyToOne (Muitos para Um)

- Vários filmes podem estar associado a um cinema.

### OneToMany (Um para Muitos)

- Um cinema pode estar associado a vários filmes.

### OneToOne (Um para Um)

- Um cinema está associado a um único endereço.

### ManyToMany (Muitos para Muitos)

- Vários usuários podem estar associados a vários filmes.
- Vários filmes podem estar associados a vários usuários.

## Pré-requisitos

Para rodar este projeto localmente, é necessário:

- **Java 17** ou superior
- **Maven 3.6+**

---

## 🔢Calculadora API

### Descrição
Este projeto é uma API simples de calculadora desenvolvida em **Java** com o framework **Spring Boot**. A API oferece operações básicas de uma calculadora, além de um conversor de peso no sistema solar.

### Operações Básicas da Calculadora
A API permite realizar as seguintes operações matemáticas:

- **Soma**: Adiciona dois números inteiros.
- **Subtração**: Subtrai dois números inteiros.
- **Multiplicação**: Multiplica dois números inteiros.
- **Divisão**: Divide dois números decimais.

### Conversão de Peso no Sistema Solar
A API oferece conversão do peso de uma pessoa em diferentes corpos celestes:

- **Mercúrio**
- **Vênus**
- **Marte**
- **Júpiter**
- **Saturno**
- **Urano**
- **Netuno**
- **Lua**
- **Sol**

### Endpoints

#### Operações de Calculadora

- `GET /Calculadora/Soma?N1={N1}&N2={N2}`: Soma dois números.
- `GET /Calculadora/Subtração?N1={N1}&N2={N2}`: Subtrai o segundo número do primeiro.
- `GET /Calculadora/Multiplicacão?N1={N1}&N2={N2}`: Multiplica dois números.
- `GET /Calculadora/Divisão?N1={N1}&N2={N2}`: Divide o primeiro número pelo segundo.

#### Conversão de Peso

- `GET /SeuPesoNoSistemaSolar/Seu Peso em Mercurio?pesoNaTerra={peso}`: Converte o peso da Terra para Mercúrio.
- `GET /SeuPesoNoSistemaSolar/Seu Peso em Venus?pesoNaTerra={peso}`: Converte o peso da Terra para Vênus.
- `GET /SeuPesoNoSistemaSolar/Seu Peso em Marte?pesoNaTerra={peso}`: Converte o peso da Terra para Marte.
- `GET /SeuPesoNoSistemaSolar/Seu Peso em Júpiter?pesoNaTerra={peso}`: Converte o peso da Terra para Júpiter.
- `GET /SeuPesoNoSistemaSolar/Seu Peso em Saturno?pesoNaTerra={peso}`: Converte o peso da Terra para Saturno.
- `GET /SeuPesoNoSistemaSolar/Seu Peso em Urano?pesoNaTerra={peso}`: Converte o peso da Terra para Urano.
- `GET /SeuPesoNoSistemaSolar/Seu Peso em Netuno?pesoNaTerra={peso}`: Converte o peso da Terra para Netuno.
- `GET /SeuPesoNoSistemaSolar/Seu Peso na Lua?pesoNaTerra={peso}`: Converte o peso da Terra para a Lua.
- `GET /SeuPesoNoSistemaSolar/Seu Peso no Sol?pesoNaTerra={peso}`: Converte o peso da Terra para o Sol.


## Pré-requisitos

Para rodar este projeto localmente, é necessário:

- **Java 17** ou superior
- **Maven 3.6+**

---

## 🚗Veículo API

### Descrição
Este projeto é uma API para gerenciamento de veículos desenvolvida em **Java** com o framework **Spring Boot**. A API permite realizar operações CRUD para veículos, como adicionar, atualizar, remover e listar veículos.

### Operações de Veículos
A API permite as seguintes operações:

- **Adicionar Veículo**: Cria um novo veículo no sistema.
- **Remover Veículo**: Remove um veículo existente pelo ID.
- **Atualizar Veículo**: Atualiza os dados de um veículo.
- **Buscar Veículo por ID**: Retorna os detalhes de um veículo pelo ID.
- **Listar Veículos**: Lista todos os veículos cadastrados.

### Endpoints

#### Operações de Veículos

- `POST /veiculos`: Adiciona um novo veículo.
- `DELETE /veiculos/{id}`: Remove um veículo pelo ID.
- `PUT /veiculos/{id}`: Atualiza os dados de um veículo pelo ID.
- `GET /veiculos/{id}`: Retorna os detalhes de um veículo específico pelo ID.
- `GET /veiculos`: Lista todos os veículos cadastrados.


## Pré-requisitos

Para rodar este projeto localmente, é necessário:

- **Java 17** ou superior
- **Maven 3.6+**

---
