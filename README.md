# SQL Maker

## Descrição

O SQL Maker é uma biblioteca Java que facilita a geração de consultas SQL dinâmicas a partir de classes Java anotadas. Ele permite criar consultas de seleção, inserção, exclusão e atualização de forma mais simples e flexível, levando em consideração as anotações presentes nas classes Java.

## Como Usar

### Anotações

- `@Column`
- `@Entity`
- `@Id`
- `@OrderBy`
- `@Table`

### Classes Principais

- **`SqlGenerator`**
- **`SqlGenFactory`**
- **`SqlQueryData`**

## Exemplo de Criação de Entidade

```java
package com.example.model;

import com.sql.anotations.Column;
import com.sql.anotations.Entity;
import com.sql.anotations.Id;
import com.sql.anotations.Table;
import com.sql.data.maker.IdType;

@Entity
@Table(name = "users")
public class MyEntity {

    @Id
    @Column(CollumName = "user_id")
    private Long userId;

    @OrderBy
    @Column(CollumName = "username")
    private String username;

    @Column(CollumName = "email")
    private String email;

    // Construtores, getters e setters aqui...
}
```

## Exemplo de Uso

```java
// Criar uma fábrica de SqlGenerator
SqlGenFactory factory = new SqlGenFactory();

// Criar uma instância de SqlGenerator
SqlMaker sqlMaker = factory.createSqlMakerExtended(null);

// Usar métodos do SqlGenerator para gerar consultas SQL dinâmicas
SqlResponse selectAllQuery = sqlMaker.generateSelectAllSql(MyEntity.class);
SqlResponse selectEmailOrUserQuery = sqlMaker.generateSelectSql(MyEntity.class, "OR", "username", "email");
SqlResponse selectEmailAndUserQuery = sqlMaker.generateSelectSql(MyEntity.class, "AND", "username", "email");
SqlResponse insertQuery = sqlMaker.generateInsertSql(MyEntity.class);
SqlResponse deleteQuery = sqlMaker.generateDeleteSql(MyEntity.class);
SqlResponse updateQuery = sqlMaker.generateUpdateSql(MyEntity.class);
```