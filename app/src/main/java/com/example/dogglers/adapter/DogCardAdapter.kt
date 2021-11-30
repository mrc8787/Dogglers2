/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.MainActivity
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.data.DataSource.dogs
import com.example.dogglers.model.Dog
import com.google.android.material.snackbar.Snackbar
import kotlin.Int as Int


/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private var layout: Int,
    private val dataset: List<Dog> = dogs
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {


    // Done: Initialize the data using the List found in data/DataSource (POWYŻEJ ZAINICJALIZOWALEM)

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?, ViewType: Int): RecyclerView.ViewHolder(view!!) {
        // DONE: Declare and initialize all of the list item UI components
        val tvDogPhoto: ImageView = view!!.findViewById(com.example.dogglers.R.id.dog_photo)
        val tvDogName: TextView = view!!.findViewById(com.example.dogglers.R.id.dog_name)
        val tvDogAge: TextView = view!!.findViewById(com.example.dogglers.R.id.dog_age)
        val tvDogHobbies: TextView = view!!.findViewById(com.example.dogglers.R.id.dog_hobbies)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        // DONE: Use a conditional to determine the layout type and set it accordingly.
        //  if the layout variable is Layout.GRID the grid list item should be used. Otherwise the
        //  the vertical/horizontal list item should be used.
        // DONE Inflate the layout
        /** val layoutType = if (viewType==Layout.GRID) {
            R.layout.grid_list_item
        }else{
            R.layout.vertical_horizontal_list_item
        }
        val adapterLayout = LayoutInflater.from(parent.context).inflate(layoutType,parent,false)
        */
        //layout = 3
        val text = viewType.toString()
        val duration = Toast.LENGTH_SHORT

        val toast = Toast.makeText(parent.context, text, duration)
        toast.show()


         val adapterLayout = if (viewType==3) {
            LayoutInflater.from(parent.context).inflate(com.example.dogglers.R.layout.grid_list_item,parent,false)
        }else{
            LayoutInflater.from(parent.context).inflate(com.example.dogglers.R.layout.vertical_horizontal_list_item,parent,false)
        }
        // DONE: Null should not be passed into the view holder. This should be updated to reflect
        //  the inflated layout.
        return DogCardViewHolder(adapterLayout,layout)
    }

    override fun getItemCount(): Int = dataset.size // DONE: return the size of the data set instead of 0

    override fun onBindViewHolder(holder: DogCardAdapter.DogCardViewHolder, position: Int) {
        // DONE: Get the data at the current position
        val dog = dataset[position]
        // DONE: Set the image resource for the current dog
        holder.tvDogPhoto.setImageResource(dog.imageResourceId)
        // DONE: Set the text for the current dog's name
        holder.tvDogName.text = dog.name
        // DONE: Set the text for the current dog's age
        val resources = context?.resources
        holder.tvDogAge.text = resources?.getString(com.example.dogglers.R.string.dog_age, dog.age)
        // Done: Set the text for the current dog's hobbies by passing the hobbies to the
        //  R.string.dog_hobbies string constant.
        //  Passing an argument to the string resource looks like:
        //  resources?.getString(R.string.dog_hobbies, dog.hobbies)
        holder.tvDogHobbies.text = resources?.getString(com.example.dogglers.R.string.dog_hobbies, dog.hobbies)
    }

}
