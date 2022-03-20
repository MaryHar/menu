package com.example.menu

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var adapter:MainAdapter2
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val imgActivity2 = findViewById<ImageView>(R.id.addImage)
        imgActivity2.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
        val foodss = arrayListOf(
            FoodModel(R.drawable.food1, "Salad", "Indian Mehak Bar"),
            FoodModel(R.drawable.food2, "Beef ", "Sherep Restaurant"),
            FoodModel(R.drawable.food3, "Pizza", "Lavash Restaurant"),
            FoodModel(R.drawable.food4, "Pizza", "Grillian"),
            FoodModel(R.drawable.food5, "French", "Mayrig Yerevan"),
            FoodModel(R.drawable.food6, "Pizza", "Havana Restaurant "),
            FoodModel(R.drawable.food1, "Salad", "La Fayette Restaurant"),
            FoodModel(R.drawable.food2, "Pizza", "Grillian"),
            FoodModel(R.drawable.food3, "Salad", "Lavash Restaurant"),

        )

        val recycleView2 = findViewById<RecyclerView>(R.id.myRec)
        recycleView2.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter2(this, foodss)
        recycleView2.adapter = adapter

        val addContact = findViewById<ImageView>(R.id.addImage)
        val editName = findViewById<EditText>(R.id.editName)
        val editNumber = findViewById<EditText>(R.id.editRestaurant)


        addContact.setOnClickListener{
            Dialog(this).apply {
                setContentView(R.layout.add)

                val createBtn = findViewById<Button>(R.id.buttonCreate)
                createBtn.setOnClickListener {
                    if(editName.text.toString() != "" && editNumber.text.toString() != ""){
                        foodss.add(
                            FoodModel(
                                R.drawable.food2,
                                editName.text.toString(),
                                editNumber.text.toString())
                        )

                        adapter.notifyItemChanged(foodss.size - 1)
                        dismiss()
                    }else{
                        Toast.makeText(this@SecondActivity, "Please fill  all required fields", Toast.LENGTH_SHORT).show()
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