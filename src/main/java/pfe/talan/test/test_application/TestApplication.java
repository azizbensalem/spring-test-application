package pfe.talan.test.test_application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pfe.talan.test.test_application.configurations.FileGeneratorProperties;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

@SpringBootApplication
public class TestApplication {
	private static final int BUFFER_SIZE = 1024;
	private static final String FILE_PREFIX = "generated_file_";
	private static final String FILE_SUFFIX = ".txt";
	private static final String DIR_NAME = "Generated_Files";

	@Autowired
	private static FileGeneratorProperties properties;

	public static void generateFiles(int numFiles, long fileSize) {
		Random rand = new Random();

		for (int i = 1; i <= numFiles; i++) {
			File directory = new File(String.valueOf(DIR_NAME));
			if (! directory.exists()){
				directory.mkdir();
			}
			File file = new File( directory+"/"+FILE_PREFIX + i + FILE_SUFFIX);
			try (FileOutputStream fos = new FileOutputStream(file)) {
				byte[] buffer = new byte[BUFFER_SIZE];
				long bytesWritten = 0;
				while (bytesWritten < fileSize) {
					rand.nextBytes(buffer);
					long bytesRemaining = fileSize - bytesWritten;
					int bytesToWrite = (int) Math.min(buffer.length, bytesRemaining);
					fos.write(buffer, 0, bytesToWrite);
					bytesWritten += bytesToWrite;
				}
				System.out.println("Generated file " + file.getName() + " with size " + file.length() + " bytes");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}



	public static void main(String[] args) {

		SpringApplication.run(TestApplication.class, args);
		generateFiles(properties.getNumFiles(), properties.getFileSize());
	}
}
