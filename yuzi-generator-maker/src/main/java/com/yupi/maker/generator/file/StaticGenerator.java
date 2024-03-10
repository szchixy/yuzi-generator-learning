package com.yupi.maker.generator.file;

import cn.hutool.core.io.FileUtil;

public class StaticGenerator {
    public static void copyFileByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }
}
