package ru.java.rush.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.java.rush.entities.FruitEntity;

import java.util.List;

@Repository//помечаем что этот бин - репозиторий
// репозиторий является интерфейсом, который наследуется от другого интерфейса JpaRepository<>
//для него необходимо указать с какой сущность он должен работать, у нас это FruitEntity
//и тип данных у поля id данной сущности, у нас это Integer

//@https://sysout.ru/spring-data-jpa-zaprosy-generiruemye-po-imeni-metoda/
public interface FruitRepository extends JpaRepository<FruitEntity,Integer> {

}
