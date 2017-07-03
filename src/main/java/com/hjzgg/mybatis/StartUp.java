package com.hjzgg.mybatis;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import sun.nio.cs.Surrogate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyg on 2017/5/15.
 */
public class StartUp {
    private static final String FILE_PATH = "/generatorConfig.xml";

    @Test
    public void test() throws Exception {
        List<String> warnings = new ArrayList<>();
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(Surrogate.Generator.class.getResourceAsStream(FILE_PATH));
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
}
