package kr.co.tjoeun.intent_20200702

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //    닉네임 변경 요청 고유값을 멤버변수로 생성.
    val REQ_FOR_NICKNAME = 1000

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
            val inputMessage2 = numberEdt.text.toString().toInt()

//            값 전달 -> putExtra()
            myIntent.putExtra("message", inputMessage)
            myIntent.putExtra("message2", inputMessage2)

            startActivity(myIntent)

        }

//        닉네임 변경기능
        changeNickNameBtn.setOnClickListener {

            val myIntent = Intent(this, EditNickNameActivity::class.java)

//            창을 띄워서 값을 받아오기 위함 -> startActivity X , startActivityForResult
//            startActivityForResult 사용 시, 어떤 결과를 가지러 가는지에 대한 값을 기술(고유 번호 입력)
            startActivityForResult(myIntent, REQ_FOR_NICKNAME)

        }
    }

//    결과를 가지고 돌아올 때 실행되는 함수. onActivityResult 입력 후 자동완성 선택하면 자동으로 override 입력됨
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    
//        입력받아온 값 조회
        if(requestCode == REQ_FOR_NICKNAME)
        {
//            "입력완료"버튼으로 완료된 건지 확인. (뒤로가기로 창을 닫은 경우에는 반영하지 않아야 함)
            if(resultCode == Activity.RESULT_OK)
            {
                Log.d("D>>", "받아온 닉네임 : " + data?.getStringExtra("nickName"))

                val newNickName = data?.getStringExtra("nickName")

                Log.d("D>>", "받아온 닉네임 2 : " + newNickName)

                nickNameTxt.text = newNickName
            }
        }
    }
}
