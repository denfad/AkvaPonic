package ru.denfad.akva;

import java.util.ArrayList;
import java.util.List;

import ru.denfad.akva.models.Fish;
import ru.denfad.akva.models.Plant;

public class Repository {

    private static Repository repository;

    private List<Fish> fish;
    private List<Plant> plants;

    private Repository(){
        fish = new ArrayList<>();
        fish.add(new Fish("Андрей","25.04",4,"Пестрый"));
        fish.add(new Fish("Катя","12.04",2,"Игривая"));
        fish.add(new Fish("Вова","15.04",2,"Ленивый"));
        plants = new ArrayList<>();
        plants.add(new Plant("Мята","09.03",5,"отсутствуют"));
        plants.add(new Plant("Базилик","18.04",13,"отсутствуют"));
    }

    public static Repository getInstance(){
        if(repository==null){
            repository = new Repository();
        }
        return repository;
    }

    public void addFish(Fish fish){
        this.fish.add(fish);
    }

    public void addPlant(Plant plant){
        plants.add(plant);
    }

    public List<Fish> getAllFish(){
        return fish;
    }

    public List<Plant> getAllPlants(){
        return plants;
    }

    public Fish getFish(int i){
      return fish.get(i);
    }

    public Plant getPlant(int i){
        return plants.get(i);
    }

    public int getSizeFish(){
        return fish.size();
    }

    public int getSizePlants(){
        return plants.size();
    }
}
