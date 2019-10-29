/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import CharacterApi.ICharacter;
import Loader.CharacterJsonLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Pumkin
 */
public class Model {
    
    private List<ICharacter> pokemonList;
    private List<ICharacter> pikachuList;
    private int numPokemon;
    private int numPikachu;

    public Model() {
        
        CharacterJsonLoader characterJsonLoader = new CharacterJsonLoader();
        this.pokemonList = characterJsonLoader.load("src\\resources\\characters.json");
        this.pikachuList = new ArrayList<>();
        Iterator<ICharacter> iter = pokemonList.iterator();
        while(iter.hasNext()){
            ICharacter p = iter.next();
            if(p.getName().startsWith("pikachu")){
                this.pikachuList.add(p);
                iter.remove(); 
            }
        }
        
        this.numPokemon = 0;
        this.numPikachu = 0;
    }

    public List<ICharacter> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<ICharacter> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public List<ICharacter> getPikachuList() {
        return pikachuList;
    }

    public void setPikachuList(List<ICharacter> pikachuList) {
        this.pikachuList = pikachuList;
    }

    public int getNumPokemon() {
        return numPokemon;
    }

    public void setNumPokemon(int numPokemon) {
        this.numPokemon = numPokemon;
    }

    public int getNumPikachu() {
        return numPikachu;
    }

    public void setNumPikachu(int numPikachu) {
        this.numPikachu = numPikachu;
    }
    
    public List<String> getPikachuImgsList(){
        List<String> imgList = new ArrayList<>();
        for(ICharacter c : this.pikachuList){
            imgList.add(c.getImgPaths().get(0));
        }
        return imgList;
    }
    
    public List<String> getPokemonImgsList(){
        List<String> imgList = new ArrayList<>();
        for(ICharacter c : this.pokemonList){
            imgList.add(c.getImgPaths().get(0));
        }
        return imgList;
    }
    
    public boolean finish(int numFound){
        if(numFound < this.numPikachu){
            return false;
        }else{
            return true;
        }
    }
    
}
