package com.yupi.cli.command;

import java.lang.reflect.Field;

import com.yupi.model.MainTemplateConfig;

import cn.hutool.core.util.ReflectUtil;
import picocli.CommandLine.Command;

@Command(name = "config", description = "查看参数信息", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable {
    public void run() {
        System.out.println("查看参数信息");
        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);
        for (Field field : fields) {
            System.out.println("字段名称: " + field.getName());
            System.out.println("字段类型: " + field.getType());
            System.out.println("---");
        }
    }
}
