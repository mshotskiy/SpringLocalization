package org.maks.service;

import org.maks.model.Question;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {
    ArrayList<Question> questionList = new ArrayList<>();

    public ArrayList<Question> getQuestions(InputStream inputStream){
        String[] lines = readFile(inputStream).split("\n");

        for (String line : lines) {
            String[] fields = line.split(";");
            questionList.add(getQuestionFromArray(fields));
        }

        return questionList;
    }

    private Question getQuestionFromArray(String[] fields){
        if (fields.length == 4){
            int id = Integer.parseInt(fields[0]);
            String question = fields[1];
            String answers = fields[2];
            String trueAnswer = fields[3];
            return new Question(id,question,answers,trueAnswer);
        }else {
            return null;//to fix!
        }
    }

    private String readFile(InputStream inputStream){
        StringBuilder result = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null){
                result.append(line).append("\n");
            }
        }catch (IOException exception){
            System.err.println("file not found");
        }
        return result.toString();
    }
}
