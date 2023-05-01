package com.e.homework_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import com.e.homework_3.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    fun showWin(){

    }

    fun allButtonNeutral(){

        binding.gButtonPlayer.setImageResource(R.drawable.g_button_off)
        binding.bButtonPlayer.setImageResource(R.drawable.b_button_off)
        binding.kButtonPlayer.setImageResource(R.drawable.k_button_off)
        binding.gButtonBot.setImageResource(R.drawable.g_button_off)
        binding.bButtonBot.setImageResource(R.drawable.b_button_off)
        binding.kButtonBot.setImageResource(R.drawable.k_button_off)
    }

    fun compareGest(playerGest:Int,botGest: Int){
        val choice = arrayOf<Int>(1,2,3)
        if(playerGest == botGest){
            binding.textView.text= "Seri"
        }else{
            for (i in 0..2){
                var j = i+1
                if (j>2){
                    j=0
                }
                when(playerGest) {
                    choice[i] ->
                        if (botGest == choice[j]) {
                            binding.textView.text= "Kamu Kalah"
                        } else {
                            binding.textView.text= "Kamu Menang"
                        }
                }
            }
        }
    }

    fun botPick():Int{
        val botgesture= Random.nextInt(1,3)
        when(botgesture){
            1-> binding.gButtonBot.setImageResource(R.drawable.g_button_on)
            2-> binding.bButtonBot.setImageResource(R.drawable.b_button_on)
            3-> binding.kButtonBot.setImageResource(R.drawable.k_button_on)
        }
        return botgesture
    }

    fun playGame(){
        var status=0
        var gesture=0
        var botgesture=0
        binding.gButtonPlayer.setOnClickListener{
            if (status == 0) {
                gesture = 1
                binding.gButtonPlayer.setImageResource(R.drawable.g_button_on)
                botgesture = botPick()
                compareGest(gesture,botgesture)
                binding.playButton.visibility = View.VISIBLE
                status=1
            }
        }
        binding.bButtonPlayer.setOnClickListener{
            if (status == 0) {
                gesture = 2
                binding.bButtonPlayer.setImageResource(R.drawable.b_button_on)
                botgesture = botPick()
                compareGest(gesture,botgesture)
                binding.playButton.visibility = View.VISIBLE
                status=1
            }
        }
        binding.kButtonPlayer.setOnClickListener{
            if (status == 0) {
                gesture = 3
                binding.kButtonPlayer.setImageResource(R.drawable.k_button_on)
                botgesture = botPick()
                compareGest(gesture,botgesture)
                binding.playButton.visibility = View.VISIBLE
                status=1
            }
        }

        binding.playButton.setOnClickListener{
            allButtonNeutral()
            gesture=0
            botgesture=0
            status=0
            binding.textView.text=""
            binding.playButton.visibility = View.INVISIBLE
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.playButton.visibility = View.INVISIBLE
        val view  = binding.root
        setContentView(view)

        playGame()
    }
}