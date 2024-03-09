package com.yupi.generator;

import java.io.File;

import cn.hutool.core.io.FileUtil;

public class StaticGenerator {
    public static void copyFileByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        String inputPath = new File(parentFile, "yuzi-generator-demo-projects/acm-template").getAbsolutePath();
        String outputPath = projectPath;
        copyFileByHutool(inputPath, outputPath);
    }
}
