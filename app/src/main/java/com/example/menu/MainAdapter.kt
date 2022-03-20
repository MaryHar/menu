package com.example.menu

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(var context: Context, var dataArray:
ArrayList<FoodModel>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val imageFood = itemView.findViewById<ImageView>(R.id.imageFood)
        val foodName = itemView.findViewById<TextView>(R.id.nameFood)
        val restaurantName = itemView.findViewById<TextView>(R.id.nameRestaurant)
        val addBasket = itemView.findViewById<ImageView>(R.id.basket2)
        val deleteContact = itemView.findViewById<ImageView>(R.id.delete2)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.menu_item, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageFood.setImageResource(dataArray[position].imageFood)
        holder.foodName.text = dataArray[position].nameFood
        holder.restaurantName.text = dataArray[position].restaurantName

        holder.deleteContact.setOnClickListener {
            AlertDialog.Builder(context).apply {
                setTitle("Delete")
                setIcon(R.drawable.delete)
                setMessage("Are you sure you want to delete this food?")
                setPositiveButton("YES") { _, _ ->
                    dataArray.removeAt(position)
                    notifyItemRemoved(position)
                }
                setNegativeButton("NO") { _, _ ->
                }
                show()
            }
            true
        }
        holder.addBasket.setOnClickListener {
            AlertDialog.Builder(context).apply {
                setTitle("Add")
                setIcon(R.drawable.add)
                setMessage("Are you sure you want to add this food?")
                setPositiveButton("YES") { _, _ ->
                    dataArray.add(FoodModel(dataArray[position].imageFood,
                        "$dataArray[position].nameFood",
                        "$dataArray[position].restaurantName"),)
                }
                setNegativeButton("NO") { _, _ ->
                }
                show()
            }
            true
        }
    }

    override fun getItemCount(): Int = dataArray.size

}