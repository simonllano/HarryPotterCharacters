package com.simonllano.harrypottercharacters.ui.characterslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.simonllano.harrypottercharacters.R
import com.simonllano.harrypottercharacters.data.model.CharactersList
import com.simonllano.harrypottercharacters.data.model.CharactersListItem
import com.simonllano.harrypottercharacters.databinding.CardViewCharactersServerBinding
import com.squareup.picasso.Picasso

class CharactersListAdapter (
    private val characterList: MutableList<CharactersListItem>,
    private val onItemClicked : (CharactersListItem) -> Unit

): RecyclerView.Adapter<CharactersListAdapter.CharactersListViewHolder>(){

 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersListViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_characters_server,parent, false)
    return CharactersListAdapter.CharactersListViewHolder(view)

 }

 override fun onBindViewHolder(holder: CharactersListViewHolder, position: Int) {
    val character = characterList[position]
     holder.bind(character)
     holder.itemView.setOnClickListener{onItemClicked(character)}
 }

 override fun getItemCount(): Int = characterList.size

    fun appendItems(newList: List<CharactersListItem>) {
        characterList.clear()
        characterList.addAll(newList)
        notifyDataSetChanged()
    }

 class CharactersListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

  private val binding = CardViewCharactersServerBinding.bind(itemView)
  fun bind(charactersListItem: CharactersListItem){
   with(binding){
       nameTextView.text = charactersListItem?.name
       houseTextView.text = charactersListItem?.house
       actorTextView.text = charactersListItem?.actor
       if(charactersListItem?.image == null){
           characterImageView.setImageResource(R.drawable.personaje)
       }
       else{
           Picasso.get().load(charactersListItem.image).into(characterImageView)
       }
   }

 }

 }
}

