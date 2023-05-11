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
        Random rand = new Random();
        String[] tableau=new String[numFiles];
        for (int i = 0; i < numFiles; i++) {
            File directory = new File(String.valueOf(MyEnum.DIR_NAME));
            if (! directory.exists()){
                directory.mkdir();
            }
            File file = new File( directory+"/"+MyEnum.FILE_PREFIX +(i+1) + MyEnum.FILE_SUFFIX);
            try (FileOutputStream fos = new FileOutputStream(file)) {
                byte[] buffer = new byte[MyEnum.BUFFER_SIZE];
                long bytesWritten = 0;
                while (bytesWritten < fileSize) {
                    rand.nextBytes(buffer);
                    long bytesRemaining = fileSize - bytesWritten;
                    int bytesToWrite = (int) Math.min(buffer.length, bytesRemaining);
                    fos.write(buffer, 0, bytesToWrite);
                    bytesWritten += bytesToWrite;
                }
                tableau[i]="Generated file " + file.getName() + " with size " + file.length() + " bytes\n";
                //System.out.println("Generated file " + file.getName() + " with size " + file.length() + " bytes");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tableau ;
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
