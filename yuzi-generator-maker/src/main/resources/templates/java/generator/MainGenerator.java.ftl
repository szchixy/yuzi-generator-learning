package ${basePackage}.generator;

import ${basePackage}.model.DataModel;

import java.io.File;
import java.io.IOException;

import freemarker.template.TemplateException;
import cn.hutool.core.io.FileUtil;

public class MainGenerator {
    public static void doGenerate(DataModel model) throws TemplateException, IOException {
        String inputRootPath = "${fileConfig.inputRootPath}";
        String outputRootPath = "${fileConfig.outputRootPath}";
        FileUtil.del(outputRootPath);

        String inputPath;
        String outputPath;
    <#list fileConfig.files as fileInfo>

        <#if fileInfo.condition??>
        if (model.${fileInfo.condition}){
            inputPath = new File(inputRootPath, "${fileInfo.inputPath}").getAbsolutePath();
            outputPath = new File(outputRootPath, "${fileInfo.outputPath}").getAbsolutePath();
            <#if fileInfo.generateType == "static">
            StaticGenerator.copyFileByHutool(inputPath, outputPath);
            <#else/>
            DynamicGenerator.doGenerate(inputPath, outputPath, model);
            </#if>
        }
        <#else/>
        inputPath = new File(inputRootPath, "${fileInfo.inputPath}").getAbsolutePath();
        outputPath = new File(outputRootPath, "${fileInfo.outputPath}").getAbsolutePath();
        <#if fileInfo.generateType == "static">
        StaticGenerator.copyFileByHutool(inputPath, outputPath);
        <#else/>
        DynamicGenerator.doGenerate(inputPath, outputPath, model);
        </#if>
        </#if>
    </#list>
    }
}
