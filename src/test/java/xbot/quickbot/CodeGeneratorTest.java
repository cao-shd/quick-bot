//package xbot.quickbot;
//
//import com.baomidou.mybatisplus.annotation.DbType;
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
//import com.baomidou.mybatisplus.core.toolkit.StringPool;
//import com.baomidou.mybatisplus.core.toolkit.StringUtils;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.InjectionConfig;
//import com.baomidou.mybatisplus.generator.config.*;
//import com.baomidou.mybatisplus.generator.config.po.TableInfo;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * mybatis plus 自动生成代码
// */
//public class CodeGeneratorTest {
//
//
//    public static void main(String[] args) {
//
//        // ============================================= 全局配置 =================================================
//        GlobalConfig globalConfig = new GlobalConfig();
//        String projectPath = System.getProperty("user.dir");
//        // 生成文件的输出目录
//        globalConfig.setOutputDir(projectPath + "/src/main/java");
//        // 开发人员
//        globalConfig.setAuthor("cao.shd");
//        // 指定生成的主键的ID类型 默认值 null
//        globalConfig.setIdType(IdType.AUTO);
//
//        // 开启 BaseResultMap 默认值 false
//        globalConfig.setBaseResultMap(true);
//        // 开启 BaseColumnList 默认值：false
//        globalConfig.setBaseColumnList(true);
//        // 开启 swagger2 模式
//        globalConfig.setSwagger2(true);
//        // 是否打开输出目录 默认值 true
//        globalConfig.setOpen(false);
//        // 是否覆盖已有文件 默认值 false
//        globalConfig.setFileOverride(false);
//
//        // 使用默认配置
//        // 设置日期类型 默认值 时间类型
//        // globalConfig.setDateType(DateType.TIME_PACK);
//
//        // 配置生成类的类名前缀后缀, %s为实体类占位符
//        // globalConfig.setEntityName("%sEntity");
//        // globalConfig.setMapperName("%sMapper");
//        // globalConfig.setXmlName("%sMapper");
//        // globalConfig.setServiceName("I%sService");
//        // globalConfig.setServiceImplName("%sServiceImpl");
//        // globalConfig.setControllerName("%sMapperController");
//
//        // 是否启用二缓存 默认值 false
//        // globalConfig.setEnableCache(true);
//
//        // ============================================= 数据源配置 ================================================
//        DataSourceConfig dataSourceConfig = new DataSourceConfig();
//        // 配置数据库类型
//        dataSourceConfig.setDbType(DbType.MYSQL);
//        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
//        // FIXME 配置为自己的数据源
//        dataSourceConfig.setUsername("root");
//        dataSourceConfig.setPassword("123456");
//        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/authentication?useSSL=false&useUnicode=true" +
//                "&characterEncoding=utf-8&serverTimezone=GMT%2B8");
//
//        // 使用默认配置
//
//        // 类型转换配置
//        // dataSourceConfig.setTypeConvert((gbConfig, fieldType) -> {
//        //     // 获取数据库中的字段类型
//        //     String type = fieldType.toLowerCase();
//        //
//        //     // 如果是 datetime 类型, 使用自定义转换
//        //     if (type.contains("datetime")) {
//        //         // datetime -> java.util.Date
//        //         return DbColumnType.DATE;
//        //     }
//        //
//        //     // 其他类型 使用默认转换
//        //     return new MySqlTypeConvert().processTypeConvert(gbConfig, type);
//        // });
//
//        // 数据库 schema name
//        // dsc.setSchemaName("public");
//
//        // ============================================= 包配置 ==================================================
//        PackageConfig packageConfig = new PackageConfig();
//        // 配置父包路径
//        packageConfig.setParent("xbot.quickbot");
//        // 运行时输入模块名 配置模块名
//        packageConfig.setModuleName(scanner("模块名"));
//
//        // 使用默认配置
//
//        // Mapper XML包名
//        // packageConfig.setXml("mapper");
//        // Entity包名
//        // packageConfig.setEntity("entity");
//        // Service包名
//        // packageConfig.setService("service");
//        // ServiceImpl包名
//        // packageConfig.setServiceImpl("service.impl");
//        // Mapper包名
//        // packageConfig.setMapper("mapper");
//        // Controller包名
//        // packageConfig.setController("controller");
//
//        // ============================================= 策略配置 =================================================
//        StrategyConfig strategyConfig = new StrategyConfig();
//        // 数据库表映射到实体的命名策略
//        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
//        // 数据库表字段映射到实体的命名策略, 未指定按照 naming 执行
//        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
//        // 生成 @RestController 控制器
//        strategyConfig.setRestControllerStyle(true);
//        // 驼峰转连字符
//        strategyConfig.setControllerMappingHyphenStyle(true);
//        // 表前缀 支持可变参数
//        strategyConfig.setTablePrefix("m_");
//        // 运行时输入要进行自动生成的表名
//        strategyConfig.setInclude(scanner("表名，多个英文逗号分割").split(","));
//        // 自定义继承的Entity类全称，带包名
//        strategyConfig.setSuperEntityClass("xbot.quickbot.common.base.BaseEntity");
//        // 写于父类中的公共字段 注意是数据库中的字段名
//        strategyConfig.setSuperEntityColumns("deleted", "create_by", "create_time", "update_by", "update_time");
//        // 自定义继承的Controller类全称，带包名
//        strategyConfig.setSuperControllerClass("xbot.quickbot.common.base.BaseController");
//        // 使用默认配置
//
//        // 是否使用 Lombok 默认 false
//        strategyConfig.setEntityLombokModel(true);
//        // strategyConfig.setSuperServiceClass("");
//        // strategyConfig.setSuperServiceImplClass("");
//        // 字段前缀 支持可变参数
//        // strategyConfig.setFieldPrefix("");
//
//        // ============================================= 自定义配置 ================================================
//        InjectionConfig customConfig = new InjectionConfig() {
//            @Override
//            public void initMap() {
//            }
//        };
//
//        // 自定义输出配置 会被优先输出
//        List<FileOutConfig> fileOutConfigs = new ArrayList<>();
//        // 配置模板文件所在路径
//        String mapperTemplatePath = "/templates/mapper.xml.ftl";
//        fileOutConfigs.add(new FileOutConfig(mapperTemplatePath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 设置 Mapper.xml 文件名
//                // 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化
//                // "/src/main/resources/mapper/{moduleName}/{entityName}Mapper.xml"
//                return projectPath + "/src/main/resources/mapper/" + packageConfig.getModuleName()
//                        + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });
//        customConfig.setFileOutConfigList(fileOutConfigs);
//        // ============================================= 模板配置 ================================================
//        // 自定义生成代码模板
//        // 1. copy mybatis-plus/src/main/resources/templates
//        // 2. 放到本工程 src/main/resources/templates 目录下
//        // 3. 修改模板内容
//        // TemplateConfig templateConfig = new TemplateConfig();
//        // 配置模板路径 默认使用 mybatis-plus/src/main/resources/templates下的模板文件
//        // 如上模板路径设置为 "" 或者 null, 将不生成该模块。
//        // templateConfig.setController("/templates/mybatis/controller.java");
//        // templateConfig.setService("/templates/mybatis/service.java");
//        // templateConfig.setServiceImpl("/templates/mybatis/serviceImpl.java");
//        // templateConfig.setEntity("/templates/mybatis/entity.java");
//        // templateConfig.setMapper("/templates/mybatis/mapper.java");
//        // templateConfig.setXml("/templates/mybatis/mapper.xml");
//
//        // ============================================= 代码生成器 =================================================
//        AutoGenerator autoGenerator = new AutoGenerator();
//        // 设置全局配置
//        autoGenerator.setGlobalConfig(globalConfig);
//        // 设置数据源配置
//        autoGenerator.setDataSource(dataSourceConfig);
//        // 设置包配置
//        autoGenerator.setPackageInfo(packageConfig);
//        // 设置策略配置
//        autoGenerator.setStrategy(strategyConfig);
//        // 设置自定义配置
//        autoGenerator.setCfg(customConfig);
//        // 设置自定义模板引擎 使用 Freemarker 模板引擎
//        // 注意需要手动添加 Freemarker 依赖
//        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
//        // 设置自定义模板配置
//        // autoGenerator.setTemplate(templateConfig);
//
//        // 执行生成代码操作
//        autoGenerator.execute();
//    }
//
//
//    private static String scanner(String tip) {
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder help = new StringBuilder();
//        help.append("请输入" + tip + "：");
//        System.out.println(help.toString());
//        if (scanner.hasNext()) {
//            String input = scanner.next();
//            if (StringUtils.isNotEmpty(input)) {
//                return input;
//            }
//        }
//        throw new MybatisPlusException("请输入正确的" + tip + "！");
//    }
//}