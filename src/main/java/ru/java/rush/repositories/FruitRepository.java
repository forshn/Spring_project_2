package ru.java.rush.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.java.rush.entities.FruitEntity;

import java.util.List;

@Repository//помечаем что этот бин - репозиторий
// репозиторий является интерфейсом, который наследуется от другого интерфейса JpaRepository<>
//для него необходимо указать с какой сущность он должен работать, у нас это FruitEntity
//и тип данных у поля id данной сущности, у нас это Integer

//@https://sysout.ru/spring-data-jpa-zaprosy-generiruemye-po-imeni-metoda/

// https://ru.bmstu.wiki/JPQL_(Java_Persistence_Query_Language)
public interface FruitRepository extends JpaRepository<FruitEntity, Integer> {

    @Query("select f from FruitEntity f where f.providerCode between ?1 and ?2")
    public List<FruitEntity> findFruitEntitiesBetweenProviderCode(Integer start, Integer end);

    @Query("select f.fruitName, p.providerName from  FruitEntity f left join ProviderEntity p on f.providerCode = p.id")
    List<String> joinSting();

    @Query("select f from  FruitEntity f  join ProviderEntity p on f.providerCode = p.id")
    List<FruitEntity> joinFruit();

    @Query(
            value = "select fruit_table.fruit_name, provider_table.provider_name from  fruit_table  join provider_table on fruit_table.provider_code = provider_table.id_provider",
            nativeQuery = true)
    List<String> joinProvider();

}
