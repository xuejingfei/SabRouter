package com.xjf.sabrouter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import com.xjf.api.ModuleAInterface

import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_skip_A.setOnClickListener {
            SabRouterManager.getInstance.getService(ModuleAInterface::class.java)?.skipA(this)
        }
    }
}
