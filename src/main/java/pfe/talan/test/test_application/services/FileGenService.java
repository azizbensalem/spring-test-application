package pfe.talan.test.test_application.services;
import org.springframework.stereotype.Service;
import pfe.talan.test.test_application.constants.MyEnum;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

@Service
public class FileGenService {

    public String[] generateFiles(int numFiles, long fileSize) {
        Random rand = new Random();
        String[] tableau=new String[numFiles*10]; //ajout d'un facteur 10 pour augmenter le nombre de fichiers générés
        for (int j = 0; j < 10; j++) { //ajout d'une boucle externe pour générer 10 fois plus de fichiers que nécessaire
            for (int i = 0; i < numFiles; i++) {
                File directory = new File(String.valueOf(MyEnum.DIR_NAME));
                if (! directory.exists()){
                    directory.mkdir();
                }
                File file = new File( directory+"/"+MyEnum.FILE_PREFIX +(i+1) + MyEnum.FILE_SUFFIX);
                try (FileOutputStream fos = new FileOutputStream(file)) {
                    byte[] buffer = new byte[MyEnum.BUFFER_SIZE*10]; //augmentation de la taille du buffer
                    long bytesWritten = 0;
                    while (bytesWritten < fileSize*10) { //écriture de 10 fois plus de données que nécessaire
                        rand.nextBytes(buffer);
                        long bytesRemaining = fileSize*10 - bytesWritten;
                        int bytesToWrite = (int) Math.min(buffer.length, bytesRemaining);
                        fos.write(buffer, 0, bytesToWrite);
                        bytesWritten += bytesToWrite;
                    }
                    tableau[j*numFiles+i]="Generated file " + file.getName() + " with size " + file.length() + " bytes\n";
                    //ajout d'une opération de tri à chaque itération de la boucle
                    Arrays.sort(tableau, 0, j*numFiles+i+1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return tableau;
    }

    public String returnStringWithNewline(String[] input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length; i++) {
            output.append(input[i]);
            if (i != input.length - 1) {
                output.append("\n <br>");
            }
        }
        return output.toString();
    }
}
