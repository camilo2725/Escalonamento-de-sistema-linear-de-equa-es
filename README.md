# Projeto de Estrutura Matemáticas – Resolução de sistema de equações lineares através do escalonamento de matrizes.

**Faculdade:** UNIFACS – Universidade Salvador  
**Curso:** Ciência da Computação  
**Disciplina:** Estrutura Matemáticas    
**Professora:** Ivana Barreto Matos  
**Data:** 18/11/2025  

---

**GitHub do Projeto:** https://github.com/camilo2725/Escalonamento-de-sistema-linear-de-equa-es   
**Relatório  do Projeto:** https://drive.google.com/file/d/1iSXXjELywVdBG5BHjO_GiWKKMKg0YpQR/view?usp=sharing      
**Apresentação do Projeto:** https://drive.google.com/file/d/1syi1sf1zLM7w51qiugQbhJAzEynOX5Qo/view?usp=sharing    
**Apresentação do Projeto:** https://drive.google.com/file/d/1syi1sf1zLM7w51qiugQbhJAzEynOX5Qo/view?usp=sharing   
**Ficha de Acompanhamento do Grupo** https://drive.google.com/file/d/1fXAb0jbp5d8hl4DNpuzWAj3oKpay9WnT/view?usp=sharing

## Integrantes do Grupo 

| Nome Completo | RA | Função no grupo |
|----------------|----------------|----------------|
| Rafael Pereira Grigorio de Lacerda | 1272526033 | Ajuda no codigo, Relatório, Readme e Contexto do projeto |
| Camilo Fondado | 12724149761 | Criação do código, Teste do código e Contexto do projeto |
| Witan Mendes Paixão Nascimento de Jesus | 12724123796 | Ajuda no código, Powerpoint e Contexto do projeto |
| Ana Priscilla Silva Oliveira | 1272411739 | Powerpoint e elaboração da apresentação |
| João Paulo Souza Fontes  | 12724113272 | Relatório e elaboração da apresentação |
| Marcio Lima Ribeiro | 12723222001 | Relatório, Powerpoint e Teste do código |

---

## Descrição do Projeto
A equipe foi contratada por uma empresa de consultoria financeira que desejava descobrir o **custo por hora real** de três categorias de profissionais:

- **Sênior (x)**
- **Pleno (y)**
- **Júnior (z)**

Cada serviço concluído é registrado como uma equação linear:

**Ax + By + Cz = Custo Total**

Onde os coeficientes representam as horas trabalhadas por cada consultor.  
Com 3 serviços diferentes, formou-se um **sistema linear 3×3**, permitindo calcular os custos reais.

---

##  Metodologia
O código implementa o método **Eliminação de Gauss (escalonamento)**:

1. Recebe 3 equações do usuário  
2. Monta a matriz aumentada  
3. Escalona linha por linha  
4. Resolve por substituição regressiva  
5. Exibe os valores finais de x, y e z  

---

## Exemplo de Funcionamento

Sistema inserido:

4x + 3y + 2z = 1900
2x + 5y + 3z = 2150
3x + 2y + 4z = 2000

**Resultado final:**

- **z = R$150,00**
- **y = R$200,00**
- **x = R$250,00**

---

## Como Executar

1. Compile o Arquivo:      
     **Escalonamento.java**

2. Insira os valores das equações conforme solicitado. O programa exibirá o sistema organizado, fará o processo de escalonamento passo a passo e mostrará claramente o valor final das incógnitas.
