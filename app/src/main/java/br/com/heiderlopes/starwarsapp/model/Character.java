package br.com.heiderlopes.starwarsapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by heiderlopes on 15/09/16.
 */
public class Character {

    private String name;
    private String height;
    //Como o servico retorna a massa com o nome mass
    //podemos utilizar a anotacao abaixo para receber
    //o valor
    @SerializedName("mass")
    private String weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
