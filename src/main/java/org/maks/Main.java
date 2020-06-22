package org.maks;

import org.maks.model.Question;
import org.maks.service.FileService;
import org.maks.service.WriteService;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;

@ComponentScan
@Configuration
public class Main {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        FileService fileService = context.getBean(FileService.class);
        WriteService writeService = context.getBean(WriteService.class);

        ArrayList<Question> questions = fileService.getQuestions();
        writeService.writeToConsole(questions);

    }
}
