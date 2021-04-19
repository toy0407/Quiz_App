package com.toy0407.quizapp;

public class QuestionClass {
    private String question;
    private int imageDrawable;
    private String correctAnswer;
    private String otherOption1;
    private String otherOption2;
    private String otherOption3;
    private String otherOption4;


    public QuestionClass(String question, int imageDrawable, String correctAnswer, String otherOption1, String otherOption2, String otherOption3, String otherOption4) {
        this.question = question;
        this.imageDrawable = imageDrawable;
        this.correctAnswer = correctAnswer;
        this.otherOption1=otherOption1;
        this.otherOption2 = otherOption2;
        this.otherOption3 = otherOption3;
        this.otherOption4 = otherOption4;
    }

    public String getOtherOption4() {
        return otherOption4;
    }

    public void setOtherOption4(String otherOption4) {
        this.otherOption4 = otherOption4;
    }

    public String getOtherOption1() {
        return otherOption1;
    }

    public void setOtherOption1(String otherOption1) {
        this.otherOption1 = otherOption1;
    }

    public String getOtherOption2() {
        return otherOption2;
    }

    public void setOtherOption2(String otherOption2) {
        this.otherOption2 = otherOption2;
    }

    public String getOtherOption3() {
        return otherOption3;
    }

    public void setOtherOption3(String otherOption3) {
        this.otherOption3 = otherOption3;
    }

    public int getImageDrawable() {
        return imageDrawable;
    }

    public void setImageDrawable(int imageDrawable) {
        this.imageDrawable = imageDrawable;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}

