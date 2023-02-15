package pfe.talan.test.test_application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import pfe.talan.test.test_application.configurations.FileGenConf;
import pfe.talan.test.test_application.services.FileGenService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
}
