package org.maks.model;

public class Question {
    private int id;
    private String question;
    private String answer;

    public Question() {
    }

    public Question(int id, String question, String answer) {
        this.id = id;
        this.question = question;
        this.answer = answer;
    }

}
