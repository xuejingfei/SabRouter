package com.xjf.moduleb

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import com.xjf.api.ModuleInterface
import com.xjf.sabrouter.SabRouterManager

import kotlinx.android.synthetic.main.b_content_main.*

class BMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.b_activity_main)
        tv_skip_main.setOnClickListener{
            SabRouterManager.instance.getService(ModuleInterface::class.java)?.skipMain(this)
        }
    }

    companion object {
        fun startActivityB(context: Context) {
            val intent = Intent(context,BMainActivity::class.java)
            context.startActivity(intent)
        }
    }
}
