package com.ruanyangyang.demo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGeneration {

    /**
     * @param args
     * @Title: main
     * @Description: 生成
     */
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 输出文件路径
        gc.setOutputDir("E:\\java\\code\\demo-springboot\\src\\main\\java");        // 输出文件路径
//        gc.setOutputDir("C:\\Users\\ryan\\Desktop\\temp");                          // 输出文件路径
        gc.setFileOverride(true);
        gc.setActiveRecord(false);                                                  // 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);                                                   // XML 二级缓存
        gc.setBaseResultMap(true);                                                  // XML ResultMap
        gc.setBaseColumnList(false);                                                // XML columList
        gc.setAuthor("ryan");                                                       // 作者

        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("YEIG");
        dsc.setPassword("123456");
        dsc.setUrl("jdbc:mysql://47.99.84.93:3306/troucker");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setTablePrefix(new String[] { "sys_" });                        // 表前缀
        // strategy.setSuperServiceClass(null);
        // strategy.setSuperServiceImplClass(null);
        // strategy.setSuperMapperClass(null);
        strategy.setNaming(NamingStrategy.underline_to_camel);                      // 表名生成策略
        strategy.setInclude(new String[]{                                           // 需要生成的表
                "sys_company",
                "sys_driver",
                "sys_operate_log",
                "sys_resource",
                "sys_user",
                "sys_role",
                "sys_role_resource",
                "sys_user_role",
                "sys_vehicle",
                "sys_user_company"
        });
        mpg.setStrategy(strategy);

        // 不生成controller和xml
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController(null);
        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.ruanyangyang.demo");
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("dao");
        pc.setEntity("entity.pojo");
        pc.setXml("xml");
        mpg.setPackageInfo(pc);

        // 执行生成
        mpg.execute();
    }
}
