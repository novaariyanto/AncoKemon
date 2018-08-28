package id.go.patikab.rsud.remun.ancokemon

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.jetbrains.anko.dip
import org.jetbrains.anko.padding
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

class SecondActivity : AppCompatActivity() {
    private var name:String = ""
    lateinit var nameTextView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout {
            padding = dip(6)
            nameTextView = textView()
        }
        val intent = intent
        name = intent.getStringExtra("name")
        nameTextView.text = name
    }
}
