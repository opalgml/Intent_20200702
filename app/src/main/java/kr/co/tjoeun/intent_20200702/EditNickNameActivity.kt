package kr.co.tjoeun.intent_20200702

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_edit_nick_name.*

class EditNickNameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nick_name)

        okBtn.setOnClickListener {

            val inputNick = nickNameEdt.text.toString()

            Log.d("D>>>>", "입력 닉네임 : " + inputNick)
//            finish()  데이터 리턴
            val resultIntent = Intent()
//            변수에 리턴 값 입력
            resultIntent.putExtra("nickName", inputNick)
//            "입력완료" 버튼으로 처리함을 명시 + 결과용 Intent 첨부
            setResult(Activity.RESULT_OK, resultIntent)

//            처리 완료 시 종료
            finish()

        }
    }

}
