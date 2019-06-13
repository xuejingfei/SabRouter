package com.xjf.moduleb.serviceImpl

import android.content.Context
import com.xjf.api.ModuleBInterface
import com.xjf.moduleb.BMainActivity
import com.xjf.sabrouter.annotation.ServiceImpl

/**
 * description: B的实现接口
 * @author xuejingfei
 * create at 19-6-13
 */
@ServiceImpl
class BModuleService : ModuleBInterface {
    override fun skipB(context:Context) {
        BMainActivity.startActivityB(context)
    }

}
