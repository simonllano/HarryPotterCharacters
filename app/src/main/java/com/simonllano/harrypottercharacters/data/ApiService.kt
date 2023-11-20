package com.simonllano.harrypottercharacters.data

import com.simonllano.harrypottercharacters.data.model.CharactersListItem
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/characters")
    suspend fun loadCharacters(): CharactersListItem

}