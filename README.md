# 🚗 Sistema de Gerenciamento de Oficina Mecânica

Projeto desenvolvido como trabalho de conclusão do treinamento de desenvolvimento em Java. O objetivo principal da aplicação é gerenciar os atendimentos, clientes, veículos e ordens de serviço de uma oficina mecânica, aplicando boas práticas de arquitetura de software e orientação a objetos.

---

## 🎯 Foco Arquitetural e Camadas

A aplicação foi desenvolvida com foco na separação clara de responsabilidades, dividida nas seguintes camadas:

* **Modelo (Domain/Entities):** Representação das entidades do domínio do sistema (ex: `Cliente`, `Veiculo`, `OrdemServico`, `Peca`, `Servico`), contendo apenas seus atributos, métodos acessores (Getters/Setters) e regras de integridade do objeto.
* **Negócio (Business/Services):** Onde residem as regras de negócio do sistema (ex: cálculo de orçamentos, validação de status da Ordem de Serviço e aprovação de serviços).
* **Persistência (DAO/Persistence):** Camada responsável pela comunicação e manipulação dos dados (operações de CRUD - Create, Read, Update, Delete) de forma isolada do restante da aplicação.

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 
* **Banco:** PostgreSQL
* **IDE Utilizada:** *NetBeans

---

## 📋 Funcionalidades Principais

- [x] Cadastro e gestão de Clientes e Veículos
- [x] Abertura, atualização e fechamento de Ordens de Serviço (OS)
- [x] Adição de peças e serviços à Ordem de Serviço
- [x] Persistência dos dados das operações no banco de dados

---

