package com.tsg.test;

public class Question {
    private String category, body, correctAnswer;
    private String[] unCorrectAnswers;

    public Question(String category, String body, String correctAnswer, String[] unCorrectAnswers) {
        this.category = category;
        this.body = body;
        this.correctAnswer = correctAnswer;
        this.unCorrectAnswers = unCorrectAnswers;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String[] getUnCorrectAnswers() {
        return unCorrectAnswers;
    }

    public void setUnCorrectAnswers(String[] unCorrectAnswers) {
        this.unCorrectAnswers = unCorrectAnswers;
    }
}
