package ru.java.rush.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ru.java.rush.entities.FruitEntity;
import ru.java.rush.entities.ProviderEntity;
import ru.java.rush.services.FruitService;
import ru.java.rush.services.ProviderService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class InitiateUtils implements CommandLineRunner {

    private final FruitService fruitService;
    private final ProviderService providerService;

    @Override
    public void run(String... args) throws Exception {

        List<FruitEntity> fruit = new ArrayList<>(
                Arrays.asList(
                        new FruitEntity()
                                .setFruitName("Fruit1")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                        new FruitEntity()
                                .setFruitName("Fruit2")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                        new FruitEntity()
                                .setFruitName("Fruit3")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                        new FruitEntity()
                                .setFruitName("Fruit4")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                        new FruitEntity()
                                .setFruitName("Fruit5")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                        new FruitEntity()
                                .setFruitName("Fruit6")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                        new FruitEntity()
                                .setFruitName("Fruit7")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                        new FruitEntity()
                                .setFruitName("Fruit8")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10)),
                        new FruitEntity()
                                .setFruitName("Fruit9")
                                .setProviderCode(Math.abs(new Random().nextInt() % 10))
                )
        );


        List<ProviderEntity> provider = new ArrayList<>(
                Arrays.asList(
                        new ProviderEntity()
                                .setProviderName("Provider1"),
                        new ProviderEntity()
                                .setProviderName("Provider2"),
                        new ProviderEntity()
                                .setProviderName("Provider3"),
                        new ProviderEntity()
                                .setProviderName("Provider4"),
                        new ProviderEntity()
                                .setProviderName("Provider5")
                )
        );

        fruitService.saveAll(fruit);

        System.out.println("\nТаблица фруктов");
        for (FruitEntity fruitEntity : fruitService.getAll()) {
            System.out.println(fruitEntity);
        }

        providerService.saveAll(provider);

        System.out.println("\nТаблица поставщиков");
        for (ProviderEntity providerEntity : providerService.getAll()) {
            System.out.println(providerEntity);
        }

        System.out.println("\nТаблица фруктов и их поставщиков\n");
        for (String join : fruitService.joinString()) {
            System.out.println(join);
        }

        System.out.println("\nТаблица фруктов и их поставщиков");
        for (FruitEntity join : fruitService.joinFruit()) {
            System.out.println(join);
        }

        System.out.println("\nТаблица фруктов и их поставщиков");
        for (String join : fruitService.joinProvider()) {
            System.out.println(join);
        }
    }
}





