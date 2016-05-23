package config;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author Maksim Dadzerkin (aka damal).
 * @since 22.5.16 2.20
 */
@Configuration
@ComponentScan(basePackages = {"words", "book", "config"})
@PropertySource("classpath:application.properties")
public class JavaAppConfig {
    @Bean
    public JavaSparkContext sc() {
        SparkConf sparkConf = new SparkConf()
                .setAppName("words-analyzer")
                .setMaster("local[*]");
        return new JavaSparkContext(sparkConf);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer configurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
