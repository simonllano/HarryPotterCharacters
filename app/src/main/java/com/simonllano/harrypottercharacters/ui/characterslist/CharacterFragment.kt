package com.simonllano.harrypottercharacters.ui.characterslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.simonllano.harrypottercharacters.data.model.CharactersListItem
import com.simonllano.harrypottercharacters.databinding.FragmentCharacterBinding


class CharacterFragment : Fragment() {

    private lateinit var characterListBinding: FragmentCharacterBinding
    private lateinit var charactersListAdapter: CharactersListAdapter
    private val characterList = mutableListOf<CharactersListItem>()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val characterViewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)

        characterListBinding = FragmentCharacterBinding.inflate(inflater, container, false)
        val root: View = characterListBinding.root

        characterViewModel.loadCharacters()
        characterViewModel.charactersLoaded.observe(viewLifecycleOwner) {listCharacters ->
            charactersListAdapter.appendItems(listCharacters)
        }

        charactersListAdapter = CharactersListAdapter(characterList, onItemClicked = {character -> onItemClicked(character)})

        characterListBinding.charactersListRecyclerView.apply{
            layoutManager= LinearLayoutManager(this@CharacterFragment.requireContext() )
            adapter = charactersListAdapter
            setHasFixedSize(false)
        }

        return root
    }

    private fun onItemClicked(character: CharactersListItem) {

    }


}