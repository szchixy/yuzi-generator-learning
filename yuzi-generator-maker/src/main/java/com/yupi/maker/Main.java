package com.yupi.maker;

import java.io.IOException;

import com.yupi.maker.generator.main.MainGenerator;

import freemarker.template.TemplateException;

public class Main {
    public static void main(String[] args) throws TemplateException, IOException, InterruptedException {
        MainGenerator mainGenerator = new MainGenerator();
        mainGenerator.doGenerate();
    }
}
