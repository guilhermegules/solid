# S.O.L.I.D

## Coesão

- Uma classe coesa faz bem uma única coisa

## Encapsulamento

- Getters e Setters não são formas eficientes de aplicar encapsulamento
- É interessante fornecer acesso apenas ao que é necessário em nossas classes
- O encapsulamento torna o uso das nossas classes mais fácil e intuitivo

## Acoplamento

- Acoplamento é a dependência entre classes
- Acoplamento nem sempre é ruim, e que é impossível criar um sistema sem nenhum acoplamento
- Devemos controlar o nível de acoplamento na nossa aplicação

## Single Responsibility Principle

- Uma classe, módulo, função, etc. Deve ter um e apenas um motivo para mudar
  - Robert C. Martin aka Uncle Bob

## Open/Closed Principle

- Entidades de software (classes, módulos, funções, etc) devem estar abertas para extensão, porém fechadas para modificação
  - Bertrand Meyer

## Liskov Substitution Principle

- Se q(x) é uma propriedade demonstrável dos objetos x de tipo T, então q(y) deve ser verdadeiro para objetos y de tipo S, onde S é um subtipo de T
  - Barbara Liskov
- Embora a herança favoreça o reaproveitamento de código, ela pode trazer efeitos colaterais quando não utilizada da maneira correta;
- O Princípio de Substituição de Liskov (LSP) diz que devemos poder substituir classes base por suas classes derivadas em qualquer lugar, sem problema
