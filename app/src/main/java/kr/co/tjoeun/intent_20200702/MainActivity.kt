package kr.co.tjoeun.intent_20200702

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Intent로 다른 액티비티로 이동
        moveToFirstBtn.setOnClickListener {

//            Intent() -> ()는 java에서의 new.
//            코틀린에서 객체 생성은 new 키워드 없이 () 로 사용한다.
            val myIntent = Intent(this, FirstActivity::class.java)

//            실제 이동 처리
            startActivity(myIntent)
        }

//        두번째 액티비티로 데이터 전달하기
        sendToSecondBtn.setOnClickListener {

            val myIntent = Intent(this, SecondActivity::class.java)
            val inputMessage = messageEdt.text.toString()

//            값 전달 -> putExtra()
            myIntent.putExtra("message", inputMessage)

            startActivity(myIntent)

        }
    }
}
