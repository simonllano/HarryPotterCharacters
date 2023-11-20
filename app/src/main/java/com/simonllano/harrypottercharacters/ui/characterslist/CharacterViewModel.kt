package com.simonllano.harrypottercharacters.ui.characterslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simonllano.harrypottercharacters.data.model.CharactersListItem
import com.simonllano.harrypottercharacters.data.repository.CharactersRepository
import kotlinx.coroutines.launch

class CharacterViewModel : ViewModel() {
    private val charactersRepository = CharactersRepository()

    private val _charactersLoaded : MutableLiveData<MutableList<CharactersListItem>> = MutableLiveData()
    val charactersLoaded : LiveData<MutableList<CharactersListItem>> = _charactersLoaded

    fun loadCharacters() {
        viewModelScope.launch {
            val charactersList : CharactersListItem = charactersRepository.loadCharacters()
            _charactersLoaded.postValue(charactersList)
        }

    }

}

private fun <T> MutableLiveData<T>.postValue(charactersList: CharactersListItem) {

}
