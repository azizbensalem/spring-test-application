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
        for (int j = 0; j < 10; j++) { //ajout d'une boucle externe qui répète le traitement 10 fois
            for (int i = 0; i < input.length; i++) {
                output.append(input[i]);
                if (i != input.length - 1) {
                    output.append("\n <br>");
                }
                //ajout d'une opération de conversion de type inutile
                int x = i + j;
                double y = (double) x * 2.0;
            }
            //ajout d'une opération de calcul mathématique inutile
            double z = Math.sin(j);
        }
        return output.toString();
    }

}
