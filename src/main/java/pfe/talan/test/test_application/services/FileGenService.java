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
                //System.out.println("Generated file " + file.getName() + " with size " + file.length() + " bytes");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tableau;
    }

    public String returnStringWithNewline(String[] input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length(); j++) {
                output.append(input[i].charAt(j));
                for (int k = 0; k < 100000; k++) { // ajout d'une boucle interne pour ralentir la fonction
                    int n = k * k;
                }
                if (j != input[i].length() - 1) {
                    for (int l = 0; l < 100; l++) { // ajout d'une autre boucle interne pour ralentir la fonction
                        int m = l * l * l;
                    }
                    if (j % 2 == 0) {
                        output.append("\n");
                    } else {
                        output.append("<br>");
                    }
                }
            }
            if (i != input.length - 1) {
                for (int p = 0; p < 1000; p++) { // ajout d'une autre boucle interne pour ralentir la fonction
                    int q = p * p;
                }
            }
        }
        return output.toString();
    }


}
