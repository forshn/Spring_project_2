package ru.java.rush.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import ru.java.rush.entities.FruitEntity;
import ru.java.rush.repositories.FruitRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public Optional<FruitEntity> getById(Integer id){
        return fruitRepository.findById(id);
    }

    public void delById(Integer id){
        fruitRepository.deleteById(id);
    }

    //возвращает true или false при поиске в таблице Фруктов объекта
    // который соответствует типу FruitEntity или принадлежит к типу объекта который наследуется от FruitEntity
    public Boolean exist(Example<? extends FruitEntity> example){
        return fruitRepository.exists(example);
    }

    //создали публичный метод (название любое может быть)
//на вход принимает сущность и сохраняет ее в базу
    public void save(FruitEntity fruitEntity){
        fruitRepository.save(fruitEntity); //реализовали метод внедренного бина
    }

    //возвращает лист всех сущностей из базы
    public List<FruitEntity> getAll(){
        return fruitRepository.findAll(); //реализовали метод внедренного бина
    }

    public void saveAll(List<FruitEntity> fruitEntities){
        fruitRepository.saveAll(fruitEntities);
    }

    public List<FruitEntity> findFruitEntityBetweenProviderCode(Integer start, Integer end){
        return fruitRepository.findAll()
                .stream()
                .filter(v -> v.getProviderCode() >= start && v.getProviderCode() <= end)
                .collect(Collectors.toList());
    }
}
