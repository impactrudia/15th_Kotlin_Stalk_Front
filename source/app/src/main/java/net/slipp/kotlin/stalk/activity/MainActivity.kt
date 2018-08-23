package net.slipp.kotlin.stalk.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import net.slipp.kotlin.stalk.R

class MainActivity : AppCompatActivity() , View.OnClickListener{

    val ADD_TASK_REQUEST = 0x001


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
//        tvCircleMainSide2.text = "전화줘"

        tvCircleMainSide1.setOnClickListener {
            it.visibility = View.INVISIBLE
//            toast(this, getString(R.string.msg_success_send_message), Toast.LENGTH_LONG).sgo
        }

    }

    override fun onClick(p0: View?) {
        if(p0==tvMainTitle){
//            toast(getString(R.string.msg_success_send_message))
        }else if(p0==tvCircleMainSide1){
            val nextIntent = Intent(this, PopupActivity::class.java)
            nextIntent.putExtra("bundleType", "create")
            startActivityForResult(nextIntent, 10)
        }else if(p0 ==tvCircleMainSide2){
            tvMainTitle.text= tvCircleMainSide2.text
        }else if(p0 ==tvCircleMainSide3){
        }else if(p0 ==tvCircleMainSide4){
        }
    }

//    open fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
//        Toast.makeText(this, message, duration).show()
//    }

    fun initView() {
//        val tvCircleMainSide1 : TextView = findViewById(R.id.tvCircleMainSide1)

        tvCircleMainSide3.visibility = View.INVISIBLE
        tvCircleMainSide4.visibility = View.INVISIBLE
        tvCircleMainSide5.visibility = View.INVISIBLE
        tvCircleMainSide6.visibility = View.INVISIBLE
        tvCircleMainSide7.visibility = View.INVISIBLE
        tvCircleMainSide8.visibility = View.INVISIBLE
    }

    fun Any.toast(context: Context, duration: Int = Toast.LENGTH_SHORT): Toast {
        return Toast.makeText(context, this.toString(), duration).apply { show() }
    }

    override fun startActivityForResult(intent: Intent?, requestCode: Int) {
        super.startActivityForResult(intent, requestCode)
        tvCircleMainSide3.visibility = View.INVISIBLE
        tvCircleMainSide3.text = "퇴근"
    }
}
//내가 하고 싶은것
//메인화면 CURL
//Create
//DB에 값이 없을때, side1이 +형태여야함
//+클릭시, 전송하려는 메세지 띄움
//저장시, side2번째에 생김
//클릭, 수정 or 삭제
//수정 수정시, 메인화면에 수정아타남
//삭제 삭제시, 삭제 아이콘생김.

//RealmObject에 저장시킴.

