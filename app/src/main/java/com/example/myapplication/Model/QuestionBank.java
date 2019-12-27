package com.example.myapplication.Model;

import java.util.Collections;
import java.util.List;

public class QuestionBank {
    private List<Question> mQuestionList;
    private int NextQuestionIndex;

    public QuestionBank(List<Question> mQuestionList) {
        this.mQuestionList = mQuestionList;
        // --- Melanger le contenu de la list --- //
        Collections.shuffle(mQuestionList);
        NextQuestionIndex = 0;
    }
    public Question getQuestion(){
        if(NextQuestionIndex == mQuestionList.size()){
            NextQuestionIndex = 0 ;
        }
        return mQuestionList.get(NextQuestionIndex++);
    }
}
