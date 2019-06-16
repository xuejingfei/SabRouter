package com.xjf.sabrouter.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author：xuejingfei
 * <p>
 * Description：
 * <p>
 * Date：2019-06-16 12:28
 */

@Target ({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface AppSpec {

}
