package pfe.talan.test.test_application.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileGenConf {

    @Value("${num-files}")
    private int numFiles;
    @Value("${file-size}")
    private long fileSize;


    @Bean
    public int getNumberOfFiles(){
        return numFiles;
    }

    @Bean
    public long getSizeOfFiles(){
        return fileSize;
    }

}
