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
        plants = new ArrayList<>();
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
