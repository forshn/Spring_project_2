package ru.java.rush.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import ru.java.rush.entities.ProviderEntity;
import ru.java.rush.repositories.ProviderRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProviderService  {
    private final ProviderRepository repository;

    public Optional<ProviderEntity> getById(Integer id){
        return repository.findById(id);
    }

    public void delById(Integer id){
        repository.deleteById(id);
    }

    public Boolean exist(Example<? extends ProviderEntity> examle){
        return repository.exists(examle);
    }

    public void saveAll(List<ProviderEntity> providerEntityList){
        repository.saveAll(providerEntityList);
    }

    public void save(ProviderEntity providerEntity){
        repository.save(providerEntity);
    }

    public List<ProviderEntity> getAll(){
        return repository.findAll();
    }

}
