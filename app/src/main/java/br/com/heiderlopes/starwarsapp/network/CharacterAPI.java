package br.com.heiderlopes.starwarsapp.network;

import br.com.heiderlopes.starwarsapp.model.Character;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * Created by heiderlopes on 15/09/16.
 */
public interface CharacterAPI {

    //Endpoint da api que será chamada
    @GET("/people/{id}")
    void getCharacter(@Path("id") int id, Callback<Character> character);
}
