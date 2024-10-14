# 📚Repositório de Desenvolvimento API Restful
Bem-vindo ao repositório de Desenvolvimento API Restful! Este repositório foi criado para organizar e documentar os projetos e práticas realizados durante o desenvolvimento de APIs seguindo o padrão RESTful.

# 📑Conteúdo
O repositório está organizado da seguinte forma:

# 📖aulas_Api
- **Códigos e exemplos práticos desenvolvidos durante as aulas teóricas, focando em conceitos fundamentais do desenvolvimento de APIs Restful.**
  
# 💡meus_Projetos
- **Projetos desenvolvidos de forma prática, como forma de reforço e aplicação dos conceitos estudados. Esses projetos podem incluir desafios reais ou cenários simulados para resolução.**
  
# 🚀projetos_Individuais_Api
- **Projeto individual desenvolvido durante a disciplina, que serve como avaliação dos conhecimentos adquiridos.**

# Calculadora API

## Descrição
Este projeto é uma API simples de calculadora desenvolvida em Java com o framework Spring Boot. A API oferece operações básicas de uma calculadora, além de um conversor de peso no sistema solar.

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

## Endpoints

### Operações de Calculadora
- `GET /Calculadora/Soma?N1={N1}&N2={N2}`: Soma dois números.
- `GET /Calculadora/Subtração?N1={N1}&N2={N2}`: Subtrai o segundo número do primeiro.
- `GET /Calculadora/Multiplicacão?N1={N1}&N2={N2}`: Multiplica dois números.
- `GET /Calculadora/Divisão?N1={N1}&N2={N2}`: Divide o primeiro número pelo segundo.

### Conversão de Peso
- `GET /SeuPesoNoSistemaSolar/Seu Peso em Mercurio?pesoNaTerra={peso}`: Converte o peso da Terra para Mercúrio.
- `GET /SeuPesoNoSistemaSolar/Seu Peso em Venus?pesoNaTerra={peso}`: Converte o peso da Terra para Vênus.
- `GET /SeuPesoNoSistemaSolar/Seu Peso em Marte?pesoNaTerra={peso}`: Converte o peso da Terra para Marte.
- `GET /SeuPesoNoSistemaSolar/Seu Peso em Júpiter?pesoNaTerra={peso}`: Converte o peso da Terra para Júpiter.
- `GET /SeuPesoNoSistemaSolar/Seu Peso em Saturno?pesoNaTerra={peso}`: Converte o peso da Terra para Saturno.
- `GET /SeuPesoNoSistemaSolar/Seu Peso em Urano?pesoNaTerra={peso}`: Converte o peso da Terra para Urano.
- `GET /SeuPesoNoSistemaSolar/Seu Peso em Netuno?pesoNaTerra={peso}`: Converte o peso da Terra para Netuno.
- `GET /SeuPesoNoSistemaSolar/Seu Peso na Lua?pesoNaTerra={peso}`: Converte o peso da Terra para a Lua.
- `GET /SeuPesoNoSistemaSolar/Seu Peso no Sol?pesoNaTerra={peso}`: Converte o peso da Terra para o Sol.

---

## Pré-requisitos
Para rodar este projeto localmente, é necessário:
- Java 17 ou superior
- Maven 3.6+
- PostgreSQL
