package com.zqh.example.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;


/**
 * mybatis-plus自动生成文件
 */
public class CodeGenerator {

    public static void main(String[] args) {
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setActiveRecord(true)
                .setAuthor("zqh")
                .setOutputDir(System.getProperty("user.dir") + "/src/main/java")//设置生成路径
                .setFileOverride(true)
                .setIdType(IdType.AUTO)
                .setServiceName("%sService")
                .setBaseResultMap(true)
                .setBaseColumnList(true);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/mybatis")
                .setUsername("root")
                .setPassword("root");
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setCapitalMode(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setEntityLombokModel(true)
                .setRestControllerStyle(true)
                .setInclude("user","order");//生成的表
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.zqh.example")
                .setMapper("mapper")
                .setService("service")
                .setController("controller")
                .setEntity("pojo")
                .setXml("mapper");

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        mpg.setGlobalConfig(gc)
                .setDataSource(dsc)
                .setStrategy(strategy)
                .setPackageInfo(pc)
                .setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}