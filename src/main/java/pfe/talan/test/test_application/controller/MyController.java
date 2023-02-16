package pfe.talan.test.test_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pfe.talan.test.test_application.configurations.FileGenConf;
import pfe.talan.test.test_application.services.FileGenService;

@RestController
@RequestMapping("/")
public class MyController {

    private final FileGenService fileGenService;
    private final FileGenConf fileGenConf;

    @Autowired
    public MyController(FileGenService fileGenService, FileGenConf fileGenConf) {
        this.fileGenService = fileGenService;
        this.fileGenConf = fileGenConf;
    }

    @GetMapping("")
    public String generatingFiles(){
        int n= fileGenConf.getNumberOfFiles();
        long m = fileGenConf.getSizeOfFiles();
        return ("Generating "+n +" files of size "+m+"\n <br><br><hr>"+fileGenService.returnStringWithNewline(fileGenService.generateFiles(n,m)));

    }
}
