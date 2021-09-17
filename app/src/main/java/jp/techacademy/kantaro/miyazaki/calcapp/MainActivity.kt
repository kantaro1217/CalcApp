package jp.techacademy.kantaro.miyazaki.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.util.Log
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_second.*
import java.lang.Exception

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var value1:EditText = findViewById(R.id.value1)
        var value2:EditText = findViewById(R.id.value2)

        plus.setOnClickListener(this)
        minus.setOnClickListener(this)
        mul.setOnClickListener(this)
        div.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent = Intent(this, SecondActivity::class.java)
        var flag:Boolean = false
        error.text = ""
        try{
            intent.putExtra("VALUE1", value1.text.toString().toDouble())
        }catch (e: Exception){
            flag = true
        }
        try{
            intent.putExtra("VALUE2", value2.text.toString().toDouble())
        }
        catch (e: Exception){
            flag = true
        }
        if (flag != true) {
            var tex = ""
            if (v != null) {
                if (v.id == R.id.plus) {
                    tex = "plus"
                } else if (v.id == R.id.minus) {
                    tex = "minus"
                } else if (v.id == R.id.mul) {
                    tex = "mul"
                } else if (v.id == R.id.div) {
                    tex = "div"
                }
            }
            intent.putExtra("calc", tex)
            startActivity(intent)
        }else {error.text = "要素を入力してください。"}

    }
}