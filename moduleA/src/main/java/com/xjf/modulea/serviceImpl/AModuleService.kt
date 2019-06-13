package com.xjf.moduleb.serviceImpl

import android.content.Context
import com.xjf.api.ModuleBInterface
import com.xjf.modulea.AMainActivity
import com.xjf.sabrouter.annotation.ServiceImpl

/**
 * description: B的实现接口
 * @author xuejingfei
 * create at 19-6-13
 */
@ServiceImpl
class AModuleService : ModuleBInterface {
    override fun skipB(context:Context) {
        AMainActivity.startActivityB(context)
    }

}
