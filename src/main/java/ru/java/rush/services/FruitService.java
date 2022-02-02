package ru.java.rush.services;

import org.springframework.stereotype.Service;
import ru.java.rush.entities.FruitEntity;
import ru.java.rush.repositories.FruitRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class FruitService {

    private final FruitRepository fruitRepository;

    public FruitService(FruitRepository repository){
        this.fruitRepository = repository;
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

    public void saveAll(FruitEntity fruitEntity){
        List<FruitEntity> fruitEntityList = new ArrayList<>();
        fruitEntityList.add(fruitEntity);
        fruitRepository.saveAll(fruitEntityList);
    }

}
