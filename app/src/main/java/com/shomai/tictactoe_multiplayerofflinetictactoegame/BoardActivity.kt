package com.shomai.tictactoe_multiplayerofflinetictactoegame

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.shomai.tictactoe_multiplayerofflinetictactoegame.databinding.ActivityBoardBinding

class BoardActivity : AppCompatActivity() {

    private lateinit var playerOneName: String
    private lateinit var playerTwoName: String
    private lateinit var turnStatus: String
    private lateinit var bind: ActivityBoardBinding

    val checkWin = arrayOf("0", "1", "2", "3", "4", "5", "6", "7", "8")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = setContentView(this, R.layout.activity_board)
        playerOneName = intent.getStringExtra("playerOne")
        playerTwoName = intent.getStringExtra("playerTwo")
        turnStatus = "$playerOneName's turns"
        bind.player1Name = playerOneName
        bind.player2Name = playerTwoName
        bind.turnStatus = turnStatus
    }

    private var playerOne = true

    fun btnClick(v: View?) {
        val mybtn = v as Button
        playGame(mybtn)
        println(checkWin.joinToString())
    }

    private fun playGame(mybtn: Button) {
        val tag = mybtn.tag.toString()
        if (playerOne) {
            mybtn.text = "X"
            playerOne = !playerOne
            turnStatus = "$playerTwoName's turns"
            bind.turnStatus = turnStatus
            checkWin[tag.toInt()] = "X"
        } else {
            mybtn.text = "O"
            playerOne = !playerOne
            turnStatus = "$playerOneName's turns"
            bind.turnStatus = turnStatus
            checkWin[tag.toInt()] = "O"
        }
        mybtn.isEnabled = false
        checkWin(checkWin)
    }

    private fun checkWin(data: Array<String>) {

        val cond1 = data[0] == data[1] && data[0] == data[2]
        val cond2 = data[3] == data[4] && data[3] == data[5]
        val cond3 = data[6] == data[7] && data[6] == data[8]

        val cond4 = data[0] == data[3] && data[0] == data[6]
        val cond5 = data[1] == data[4] && data[1] == data[7]
        val cond6 = data[2] == data[5] && data[2] == data[8]

        val cond7 = data[0] == data[4] && data[0] == data[8]
        val cond8 = data[2] == data[4] && data[2] == data[6]

        val condList: Array<Boolean> =
            arrayOf(cond1, cond2, cond3, cond4, cond5, cond6, cond7, cond8)

        for (i in condList) if (i) {
            Toast.makeText(applicationContext, "Win", Toast.LENGTH_SHORT)
                .show()
            return
        }
    }
}
