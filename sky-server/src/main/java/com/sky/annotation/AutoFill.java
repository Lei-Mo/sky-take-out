package com.sky.annotation;

import com.sky.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于表示方法需要进行公共字段的填充处理
 */
@Target(ElementType.METHOD) // 注解只能作用于方法上
@Retention(RetentionPolicy.RUNTIME) // 注解不仅被保存到class文件中，jvm加载class文件之后，仍然存在
public @interface AutoFill {
    /**
     * 数据库操作类型
     */
    OperationType value();
}
