package jp.techacademy.kantaro.miyazaki.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*
import android.util.Log

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val calc = intent.getStringExtra("calc")

        val value1 = intent.getDoubleExtra("VALUE1", 0.0)
        val value2 = intent.getDoubleExtra("VALUE2", 0.0)
        Log.d("ui", value1.toString())
        Log.d("ui", value2.toString())


        if(calc.equals("plus")){
            textView.text = "${value1 + value2 }"
        }else if(calc.equals("minus")){
            textView.text = "${value1 - value2 }"
        }else if(calc.equals("mul")){
            textView.text = "${value1 * value2 }"
        }else if(calc.equals("div")){
            if(value2 != 0.0){
                textView.text = "${value1 / value2 }"
            }else{
                textView.text = "value2に0を入れての徐算は行えません"
            }
        }

    }
}