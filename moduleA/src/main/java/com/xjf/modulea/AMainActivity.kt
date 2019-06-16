package com.xjf.modulea

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import com.xjf.api.ModuleBInterface
import com.xjf.sabrouter.SabRouterManager

import kotlinx.android.synthetic.main.a_content_main.*

class AMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_activity_main)
        tv_skip_B.setOnClickListener {
            SabRouterManager.getInstance().getService(ModuleBInterface::class.java)?.skipB(this)
        }
    }

    companion object {
        fun startActivityB(context: Context) {
            val intent = Intent(context,AMainActivity::class.java)
            context.startActivity(intent)
        }
    }
}
