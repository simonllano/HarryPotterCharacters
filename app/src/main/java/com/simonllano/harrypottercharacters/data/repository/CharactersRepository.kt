package com.simonllano.harrypottercharacters.data.repository

import com.simonllano.harrypottercharacters.data.HarryPotterCharacter

class CharactersRepository {


    suspend fun loadCharacters() = HarryPotterCharacter.retrofit.loadCharacters()
}