package id.go.patikab.rsud.remun.ancokemon

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.EditText
import id.go.patikab.rsud.remun.ancokemon.R.color.colorAccent
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
    }

    class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                padding = dip(16)

                val name = editText {
                    hint = "Sopo jenengmu ?"
                }
                button("Nyopo !") {
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    onClick { toast("Ndul , ${name.text}") }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }
                button("tampil alert") {
                    backgroundColor = ContextCompat.getColor(context, colorAccent)
                    textColor = Color.WHITE
                    onClick {
                        alert("Happy Coding!", "Hello, ${name.text}!") {
                            yesButton { toast("Oh...") }
                            noButton { }
                        }.show()
                    }

                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }
                button("tampil selector "){
                    backgroundColor  = ContextCompat.getColor(context,colorAccent)
                    textColor = Color.WHITE
                    onClick {
                        val club = listOf("Barcelona","RealMadrid","Bayern Munchen","Arema")
                        selector("Hello , ${name.text}! Club pilihanmu opo ndul ?",club){_,i ->
                           toast("${club[i]}, ndul ?")
                        }
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }
                button("tampil SnackBar "){
                    backgroundColor = ContextCompat.getColor(context,colorAccent)
                    textColor = Color.WHITE
                    onClick {
                      snackbar(name,"${name.text}")
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }
                button("tampil progressBar"){
                    backgroundColor = ContextCompat.getColor(context,colorAccent)
                    textColor = Color.WHITE
                    onClick {
                        indeterminateProgressDialog( "Hello , ${name.text} ! Nteni..." ).show()
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }
                button("Pindah aktifitas ke dua"){
                    backgroundColor= ContextCompat.getColor(context,colorAccent)
                    textColor  = Color.WHITE
                    onClick { startActivity<SecondActivity>("name" to "${name.text}") }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }
            }
        }
    }
}
