package org.maks;

import org.maks.model.Question;
import org.maks.service.FileService;
import org.maks.service.WriteService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        InputStream cpResource = Main.class.getClassLoader().getResourceAsStream("questions.csv");
        FileService fileService = context.getBean(FileService.class);
        WriteService writeService = context.getBean(WriteService.class);

        ArrayList<Question> questions = fileService.getQuestions(cpResource);
        writeService.writeToConsole(questions);

    }
}
