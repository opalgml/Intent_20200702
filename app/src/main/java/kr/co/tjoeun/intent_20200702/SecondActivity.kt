package kr.co.tjoeun.intent_20200702

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        
//        들어온 데이터를 받아서 텍스트뷰에 반영
//        액티비티가 가진 intent 변수를 통해서 첨부된 데이터 가져오기 -> getStringExtra (String타입)
        val receivedMessage = intent.getStringExtra("message")
//        int값 받아오기
        val receivedMessage2 = intent.getIntExtra("message2", 99)

        receivedMessageTxt.text = receivedMessage
//        숫자 값을 받아옴. 이때 세팅할 내용 -> "입력한 Number 입력값 : 00" -> String 값을 가공해서 처리한다.
        receivedMessageTxt2.text = "고유번호 : ${receivedMessage2}"

    }
}
