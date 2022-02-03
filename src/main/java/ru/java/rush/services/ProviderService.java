package ru.java.rush.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.java.rush.entities.ProviderEntity;
import ru.java.rush.repositories.ProviderRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProviderService  {
    private final ProviderRepository repository;

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
