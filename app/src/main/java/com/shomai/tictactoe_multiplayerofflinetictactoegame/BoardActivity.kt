package com.shomai.tictactoe_multiplayerofflinetictactoegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_board.*

class BoardActivity : AppCompatActivity() {
    private lateinit var playerOneName : String
    private lateinit var playerTwoName : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board)
        playerOneName = intent.getStringExtra("playerOne")
        playerTwoName = intent.getStringExtra("playerTwo")
        playerOnplayer.text = ("$playerOneName vs $playerTwoName")
        turnText.text = playerOneName
    }
    private var playerOne = true
     fun btnClick(v: View?) {
       val mybtn = v as Button
         playGame(mybtn)
    }
    private fun playGame(mybtn:Button) {
        if (playerOne){
            mybtn.text = "X"
            playerOne = !playerOne
            turnText.text = playerTwoName
        }else {
            mybtn.text = "O"
            playerOne = !playerOne
            turnText.text = playerOneName
        }
        mybtn.isEnabled=false
    }

}
