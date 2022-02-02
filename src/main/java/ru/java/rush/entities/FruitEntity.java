package ru.java.rush.entities;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity//помечаем бин как сущность
@Table(name = "fruit_table")//в этой аннотации можно указать имя создаваемой таблицы
public class FruitEntity {
    @Id//аннотация из пакета avax.persistence.*, помечает поле как id
    @Column(name = "id_fruit")//в этой аннотации можно указать имя поля
    @GenericGenerator(name = "generator", strategy = "increment")//незаметно добрались до hibernate,
// здесь указывается что id будет автоматически увеличиваться при новых записях
    @GeneratedValue(generator = "generator")//аннотация генерации id
    private Integer id;

    @Column(name = "fruit_name")
    private String fruitName;

    @Column(name = "provider_code")
    private Integer providerCode;

    public FruitEntity(){ //пустой конструктор

    }

    public Integer getId() {
        return id;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public Integer getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(Integer providerCode) {
        this.providerCode = providerCode;
    }

    @Override
    public String toString() {
        return "FruitEntity{" +
                "id=" + id +
                ", fruitName='" + fruitName + '\'' +
                ", providerCode=" + providerCode +
                '}';
    }
}
