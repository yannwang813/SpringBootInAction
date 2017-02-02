package cn.ares.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching // 开启缓存支持
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}