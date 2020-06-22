package org.maks.service;

import org.maks.Main;
import org.maks.model.Question;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;



@Service
public class WriteService {

    private final MessageSource messageSource;
    private Locale locale;

    public WriteService(MessageSource messageSource) {
        this.messageSource = messageSource;
        locale = new Locale("RU");
    }



    public void writeToConsole(List<Question> questions){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = "";
        int score = 0;

        System.out.println(messageSource.getMessage(
                "read.username",
                new String[]{},
                locale
        ));
        try {
            name = reader.readLine();
        } catch (IOException exception) {
            System.err.println("Incorrect input");
        }

        System.out.println(questions.toString());
        for (Question question : questions) {
            System.out.printf(messageSource.getMessage(
                    "write.questions",
                    new String[]{},
                    locale),
                    question.getId(),
                    question.getQuestion(),
                    question.getAnswer());
            try {
                String userAnswer = reader.readLine().toLowerCase();
                if (userAnswer.equals(question.getTrueAnswer().toLowerCase())){
                    score++;
                }
            } catch (IOException exception) {
                System.err.println("Incorrect input");
            }

        }

        System.out.printf(messageSource.getMessage(
                "write.score",
                new String[]{},
                locale), name, score);

    }

}
