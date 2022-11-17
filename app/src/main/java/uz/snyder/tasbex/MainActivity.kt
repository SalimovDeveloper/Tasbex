package uz.snyder.tasbex

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.MemoryFile
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var count = 0
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("tasbex_count", Context.MODE_PRIVATE)

        count = sharedPreferences.getInt("KeyCount",  0)
        text_View.text = count.toString()

        val editor = sharedPreferences.edit()
        add_Bottom.setOnClickListener {
            count++
            editor.putInt("KeyCount", count)
            editor.apply()
            text_View.text = count.toString()
        }

        reset_Bottom.setOnClickListener {

            count = 0
            editor.putInt("KeyCount", count)
            editor.apply()
            text_View.text = count.toString()

        }

    }
}