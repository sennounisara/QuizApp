package com.example.myapplication.Model;

import java.util.List;

public class Question {
    private String question;
    private List<String> mChoiceList;
    private int AnswerIndex;

    public Question(String mQuestion, List<String> mChoiceList, int answerIndex) {
        this.question = mQuestion;
        this.mChoiceList = mChoiceList;
        AnswerIndex = answerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getChoiceList() {
        return mChoiceList;
    }

    public void setmChoiceList(List<String> mChoiceList) {
        this.mChoiceList = mChoiceList;
    }

    public int getAnswerIndex() {
        return AnswerIndex;
    }

    public void setAnswerIndex(int answerIndex) {
        AnswerIndex = answerIndex;
    }
}
