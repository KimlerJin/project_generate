package com.domain.project;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.domain.project.module.generate.pojo.GenerateModuleVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;


/**
 * <p>
 * 代码生成演示器
 * </p>
 *
 * @author Henry Deng, No One
 * @since 2018-06-11
 */
public class MpGenerator {

    //用来获取generate.properties文件的配置信息
    private static final ResourceBundle generator = ResourceBundle.getBundle("generate");

    /**
     * <p>
     * Oracle 生成演示
     * </p>
     */
    public static void main(String[] args) {

        GenerateModuleVO generateModuleVO = new GenerateModuleVO();
        generateModuleVO.setTbNames(generator.getString("TB_NAMES"));
        generateModuleVO.setTbPrefix(generator.getString("TB_PREFIX"));
        generateModuleVO.setTbPackage(generator.getString("PACKAGE"));
        generateModuleVO.setTbModule(generator.getString("MODULE"));
        generateModuleVO.setAuthor(generator.getString("AUTHOR"));
        generateModuleVO.setFileOverride(1);

        generate(generateModuleVO, generator);
    }

    public static void generate(GenerateModuleVO generateModuleVO) {
        generate(generateModuleVO, generator);
    }

    public static void generate(GenerateModuleVO generateModuleVO, ResourceBundle generator) {
        final String JAVA_FILE_OUTPUT = generator.getString("JAVA_FILE_OUTPUT");
        final String MAPPER_FILE_OUTPUT = generator.getString("MAPPER_FILE_OUTPUT");

        //pojo path
        String packagePojo = generateModuleVO.getTbPackage() + "." + generateModuleVO.getTbModule() + ".pojo";
        String POJO_FILE_OUTPUT = JAVA_FILE_OUTPUT + "/" + packagePojo.replace(".", "/") + "/";

        // 打印注入设置【可无】
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(JAVA_FILE_OUTPUT);
        gc.setFileOverride(generateModuleVO.getFileOverride() == 1);
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        // .setKotlin(true) 是否生成 kotlin 代码
        gc.setAuthor(generateModuleVO.getAuthor());
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        // gc.setMapperName("%sDao");
        // gc.setXmlName("%sDao");
        gc.setServiceName("%sService");
        // gc.setServiceImplName("%sServiceDiy");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(generator.getString("DB_URL"));
        dataSourceConfig.setDriverName(generator.getString("DB_DRIVER"));
        dataSourceConfig.setUsername(generator.getString("DB_USERNAME"));
        dataSourceConfig.setPassword(generator.getString("DB_PASSWORD"));
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setTypeConvert(new MySqlTypeConvert() {
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型：" + fieldType);
                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                return super.processTypeConvert(fieldType);
            }
        });
        mpg.setDataSource(dataSourceConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        strategy.setTablePrefix(generateModuleVO.getTbPrefix());// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(generateModuleVO.getTbNames().split(",")); // 需要生成的表
        // strategy.setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义实体父类
        strategy.setSuperEntityClass("SuperEntity");
        // 自定义实体，公共字段
        strategy.setSuperEntityColumns(new String[]{"DELETED"});
        // 自定义 mapper 父类
        strategy.setSuperMapperClass("SuperMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
         strategy.setSuperControllerClass("SuperController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // strategy.setEntityBuilderModel(true);
        mpg.setStrategy(strategy);


        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(generateModuleVO.getTbPackage());
        pc.setModuleName(generateModuleVO.getTbModule());
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("packagePojo", packagePojo);
                map.put("superDTO", "SuperDTO");
                map.put("superVO", "SuperVO");
                map.put("superQO", "SuperQO");
//                map.put("superEntity", "SuperEntity");
                this.setMap(map);
            }
        };


        // 自定义 xxList.jsp 生成
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
        focList.add(new FileOutConfig("/code_template/entity.dto.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return POJO_FILE_OUTPUT + tableInfo.getEntityName() + "DTO.java";
            }
        });
        focList.add(new FileOutConfig("/code_template/entity.vo.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return POJO_FILE_OUTPUT + tableInfo.getEntityName() + "VO.java";
            }
        });
        focList.add(new FileOutConfig("/code_template/entity.qo.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return POJO_FILE_OUTPUT + tableInfo.getEntityName() + "QO.java";
            }
        });


        // 调整 xml 生成目录演示
        focList.add(new FileOutConfig("/code_template/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return MAPPER_FILE_OUTPUT + "/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });

        cfg.setFileOutConfigList(focList);

        mpg.setCfg(cfg);

        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/code_templates 下面内容修改，
        // 放置自己项目的 src/main/resources/code_templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        TemplateConfig tc = new TemplateConfig();
        tc.setController("/code_template/controller.java.vm");
        tc.setService("/code_template/service.java.vm");
        tc.setServiceImpl("/code_template/serviceImpl.java.vm");
        // tc.setEntity("...");
        tc.setEntity("/code_template/entity.java.vm");
        tc.setMapper("/code_template/mapper.java.vm");
        tc.setXml(null);
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        mpg.setTemplate(tc);

        // 执行生成
        mpg.execute();
    }

}