package org.maks.service;

import org.maks.model.Question;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadService {
    ArrayList<Question> questionList = new ArrayList<>();

    public List<Question> getQuestions(String fileLink) throws FileNotFoundException {
        String[] lines = readFile(fileLink).split("\n");

        for (int i = 0; i < lines.length; i++){
            String[] fields = lines[i].split(";");
            questionList.add(getQuestionFromArray(fields));
        }

        return questionList;
    }

    private Question getQuestionFromArray(String[] fields){
        if (fields.length == 4){
            Integer id = Integer.parseInt(fields[0]);
            String question = fields[1];
            String answers = fields[2];
            String trueAnswer = fields[3];
            return new Question(id,question,answers,trueAnswer);
        }else {
            return null;
        }
    }

    private String readFile(String fileLink){
        StringBuilder result = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileLink)))) {
            String line;
            while ((line = br.readLine()) != null){
                result.append(line).append("/n");
            }
        }catch (IOException exception){
            System.err.println("file not found");
        }
        return result.toString();
    }
}
