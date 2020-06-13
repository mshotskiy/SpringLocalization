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

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getTrueAnswer() {
        return trueAnswer;
    }
}
