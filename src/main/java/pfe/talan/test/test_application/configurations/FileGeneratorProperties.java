package pfe.talan.test.test_application.configurations;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

    @Component
    @PropertySource("classpath:application.properties")
    @ConfigurationProperties(prefix = "file-generator")
    public class FileGeneratorProperties {
        private int numFiles;
        private long fileSize;

        public int getNumFiles() {
            return numFiles;
        }

        public void setNumFiles(int numFiles) {
            this.numFiles = numFiles;
        }

        public long getFileSize() {
            return fileSize;
        }

        public void setFileSize(long fileSize) {
            this.fileSize = fileSize;
        }
    }
