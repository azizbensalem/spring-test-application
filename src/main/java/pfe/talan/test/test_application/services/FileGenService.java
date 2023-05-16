package pfe.talan.test.test_application.services;
import org.springframework.stereotype.Service;
import pfe.talan.test.test_application.constants.MyEnum;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

@Service
public class FileGenService {

    public String[] generateFiles(int numFiles, long fileSize) {
        String[] tableau = new String[numFiles];
        File directory = new File(String.valueOf(MyEnum.DIR_NAME));
        if (!directory.exists()) {
            directory.mkdir();
        }
        byte[] buffer = new byte[MyEnum.BUFFER_SIZE];
        Random rand = new Random();
        for (int i = 0; i < numFiles; i++) {
            File file = new File(directory, MyEnum.FILE_PREFIX + (i + 1) + MyEnum.FILE_SUFFIX);
            try (FileOutputStream fos = new FileOutputStream(file)) {
                rand.nextBytes(buffer);
                long bytesWritten = 0;
                while (bytesWritten < fileSize) {
                    int bytesToWrite = (int) Math.min(buffer.length, fileSize - bytesWritten);
                    fos.write(buffer, 0, bytesToWrite);
                    bytesWritten += bytesToWrite;
                }
                tableau[i] = "Generated file " + file.getName() + " with size " + file.length() + " bytes\n";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tableau;
    }

    public String returnStringWithNewline(String[] input) {
        StringBuilder output = new StringBuilder(input.length * (input.length + 1));
        for (String str : input) {
            output.append(str).append("\n <br>");
        }
        return output.toString();
    }

}
