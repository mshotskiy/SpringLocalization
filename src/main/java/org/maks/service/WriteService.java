package org.maks.service;

import org.maks.model.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class WriteService {

    public void writeToConsole(List<Question> questions){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = "";
        int score = 0;

        System.out.println("Please enter your name...  ");
        try {
            name = reader.readLine();
        } catch (IOException exception) {
            System.err.println("Incorrect input");
        }

        System.out.println(questions.toString());
        for (Question question : questions) {
            System.out.printf("Question number %d: %s answers: %s",question.getId(), question.getQuestion(),
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

        System.out.printf("Congratulations %s you have %d points", name, score);

    }

}
