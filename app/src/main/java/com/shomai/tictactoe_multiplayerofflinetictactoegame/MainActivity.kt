package com.shomai.tictactoe_multiplayerofflinetictactoegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnPlayHandler(view: View) {
        val playerOneName = findViewById<EditText>(R.id.playerOneName)
        val playerTwoName = findViewById<EditText>(R.id.playerTwoName)
        val playerOne = playerOneName.text.toString()
        val playerTwo = playerTwoName.text.toString()
        if (playerOne.isEmpty() || playerTwo.isEmpty()) {
            Toast.makeText(applicationContext, "Consider Input not empty", Toast.LENGTH_SHORT)
                .show();
        } else {
            if (playerOne == playerTwo) {
                Toast.makeText(
                    applicationContext,
                    "Are you Playing with your self ?",
                    Toast.LENGTH_SHORT
                )
                    .show();
            } else {
                val boardIntent = Intent(this, BoardActivity::class.java).apply {
                    putExtra("playerOne", playerOne)
                    putExtra("playerTwo", playerTwo)
                }
                startActivity(boardIntent)
            }
        }
    }
}