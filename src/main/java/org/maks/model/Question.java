package org.maks.model;

public class Question {
    private int id;
    private String question;
    private String answer;
    private String trueAnswer;

    public Question() {
    }


    public Question(int id, String question, String answer, String trueAnswer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.trueAnswer = trueAnswer;
    }
}
