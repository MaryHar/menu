package com.example.menu

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var adapter:MainAdapter
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val foods = arrayListOf(
            FoodModel(R.drawable.food1, "Salad", "Indian Mehak Bar"),
            FoodModel(R.drawable.food2, "Beef ", "Sherep Restaurant"),
            FoodModel(R.drawable.food3, "Pizza", "Lavash Restaurant"),
            FoodModel(R.drawable.food4, "Pizza", "Grillian"),
            FoodModel(R.drawable.food5, "French", "Mayrig Yerevan"),
            FoodModel(R.drawable.food6, "Pizza", "Havana Restaurant "),
            FoodModel(R.drawable.food1, "Salad", "La Fayette Restaurant"),
            FoodModel(R.drawable.food2, "Pizza", "Grillian"),
            FoodModel(R.drawable.food3, "Salad", "Lavash Restaurant"),
            FoodModel(R.drawable.food4, "Pizza", "Indian Mehak Bar"),
            FoodModel(R.drawable.food5, "Pizza", "La Fayette Restaurant"),
            FoodModel(R.drawable.food6, "Pizza", "Grillian"),
            FoodModel(R.drawable.food1, "Salad", "Indian Mehak Bar"),
            FoodModel(R.drawable.food2, "Pizza", "Mayrig Yerevan"),
            FoodModel(R.drawable.food6, "Pizza", "Lavash Restaurant"),
            FoodModel(R.drawable.food4, "Pizza", "094989454"),
        )

        val recycleView = findViewById<RecyclerView>(R.id.myRec)
        recycleView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(this, foods)
        recycleView.adapter = adapter

        val imgActivity2 = findViewById<ImageView>(R.id.basketImage)
        imgActivity2.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        val addContact = findViewById<ImageView>(R.id.addImage2)
        val editName = findViewById<EditText>(R.id.editName)
        val editRestaurant = findViewById<EditText>(R.id.editRestaurant)

        addContact.setOnClickListener{
            Dialog(this).apply {
                setContentView(R.layout.add)

                val createBtn = findViewById<Button>(R.id.buttonCreate)
                createBtn.setOnClickListener {
                    if(editName.text.toString() != "" && editRestaurant.text.toString() != ""){
                        foods.add(
                            FoodModel(
                                R.drawable.food2,
                                editName.text.toString(),
                                editRestaurant.text.toString())
                        )

                        adapter.notifyItemChanged(foods.size - 1)
                        dismiss()
                    }else{
                        Toast.makeText(this@MainActivity, "Please fill  all required fields", Toast.LENGTH_SHORT).show()
                    }
                }

                val cancelButton = findViewById<Button>(R.id.buttonCreate)
                cancelButton.setOnClickListener{
                    dismiss()
                }

                show()
            }
        }
    }
}