package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast


class MainActivity() : AppCompatActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        class dice{

            var sides = 6
            fun roll(): Int{
                var num = (1..sides).random()
                return num
            }
        }

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
            toast.show()
            val resultImageView: ImageView = findViewById(R.id.imageView)
            val diceobj = dice()
           

            when(diceobj.roll()){
                1->resultImageView.setImageResource(R.drawable.dice_1)
                2->resultImageView.setImageResource(R.drawable.dice_2)
                3->resultImageView.setImageResource(R.drawable.dice_3)
                4->resultImageView.setImageResource(R.drawable.dice_4)
                5->resultImageView.setImageResource(R.drawable.dice_5)
                6->resultImageView.setImageResource(R.drawable.dice_6)
            }
            
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }
}