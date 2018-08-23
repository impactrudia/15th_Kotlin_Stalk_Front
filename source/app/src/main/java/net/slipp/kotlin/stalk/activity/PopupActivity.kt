package net.slipp.kotlin.stalk.activity

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_popup.*
import net.slipp.kotlin.stalk.R

/**
 * A login screen that offers login via email/password.
 */
class PopupActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(p0: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popup)

//        if (intent.hasExtra("bundleType")) {
//            btnNegative.visibility = View.GONE
//            btnPositive.text= getString(R.string.register)
//        }

//        btnPositive.setOnClickListener(
//                setResult(Activity.RESULT_OK)
//        )

    }


}
