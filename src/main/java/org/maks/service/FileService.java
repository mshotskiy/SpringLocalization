package org.maks.service;

import org.maks.model.Question;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

@Service
public class FileService {
    ArrayList<Question> questionList = new ArrayList<>();
    private final MessageSource messageSource;
    private Locale locale;

    public FileService(MessageSource messageSource) {
        this.messageSource = messageSource;
        locale = new Locale("RU");
    }

    public ArrayList<Question> getQuestions(){
        String[] lines = readFile(getInputStream()).split("\n");

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

    private InputStream getInputStream(){
        return WriteService.class.getClassLoader().getResourceAsStream(
                messageSource.getMessage("url.questions",new String[]{}, locale));
    }
}
