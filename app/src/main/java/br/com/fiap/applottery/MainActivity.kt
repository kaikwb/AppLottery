package br.com.fiap.applottery

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun generateRandomNumbers(
        numbersToGenerate: Int,
        minNumber: Int,
        maxNumber: Int
    ): Set<Int> {
        val randomNumbers = mutableSetOf<Int>()

        while (randomNumbers.size < numbersToGenerate) {
            val randomNumber = Random.nextInt(minNumber, maxNumber)
            randomNumbers.add(randomNumber)
        }

        return randomNumbers
    }

    fun sortNumbers(view: View) {
        val numbers = generateRandomNumbers(
            resources.getInteger(R.integer.lottery_sorted_balls),
            resources.getInteger(R.integer.lottery_min),
            resources.getInteger(R.integer.lottery_max)
        )
        val sortedNumbers = numbers.sorted()

        val lotteryBalls = listOf(
            R.id.ballTextView1,
            R.id.ballTextView2,
            R.id.ballTextView3,
            R.id.ballTextView4,
            R.id.ballTextView5,
            R.id.ballTextView6
        )

        for (i in lotteryBalls.indices) {
            val lotteryBall = findViewById<TextView>(lotteryBalls[i])

            lotteryBall.text = sortedNumbers[i].toString()
        }
    }

    fun clearNumbers(view: View) {
        val lotteryBalls = listOf(
            R.id.ballTextView1,
            R.id.ballTextView2,
            R.id.ballTextView3,
            R.id.ballTextView4,
            R.id.ballTextView5,
            R.id.ballTextView6
        )

        for (i in lotteryBalls.indices) {
            val lotteryBall = findViewById<TextView>(lotteryBalls[i])

            lotteryBall.text = ""
        }
    }
}
