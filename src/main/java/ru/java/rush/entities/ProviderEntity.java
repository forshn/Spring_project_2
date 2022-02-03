package ru.java.rush.entities;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Accessors(chain = true) // она позволяет  автоматически сгенерировать сеттеры, которые возвращают this  вместо void и вызывать их в стиле билдера.
@Data
@Entity
@Table(name = "provider_table")
public class ProviderEntity {


    @Id
    @Column(name = "id_provider")
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "increment")
    private Integer id;

    @Column(name = "provider_name")
    private String providerName;

}
