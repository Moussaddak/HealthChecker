package com.c19;

public class Question {
    public String[] questions = {
            "During the past 48 hours, what was your warmest temperature?",
            "In the past few days, have you had a cough or has your usual cough changed?",
            "In the past few days, have you noticed a loss or a sharp decrease in your taste or smell?",
            "In the past few days, have you had a sore throat and / or unusual muscle aches and / or body aches and / or unusual headaches?",
            "In the past 24 hours, have you had diarrhea? With at least 3 loose stools.",
            "Have you been unusually tired in the past few days?",
            "For 24 hours or more, have you been unable to eat or drink?",
            "What is your age ? This, in order to calculate a specific risk factor.",
            "Do you have unbalanced diabetes or with complications (eyes, kidneys)?",
            "Do you have chronic respiratory disease (obstructive pulmonary disease,sleep apnea syndrome) or are you under the care of a pulmonologist?"
    };

    public String[][] choices = {
            {"Above 38,0° degree", "37,0° degree", " 38,0° degree"},
            {"Yes", "No", "I don't know"},
            {"Yes", "No", "I don't know"},
            {"Yes", "No", "I don't know"},
            {"Yes", "No", "I don't know"},
            {"Yes", "No", "I don't know"},
            {"Yes", "No", "I don't know"},
            {"more than 50", "between 20 and 50", "less than 20"},
            {"Yes", "No", "I don't know"},
            {"Yes", "No", "I don't know"}
    };

    public String getQuestion(int a) {
        return questions[a];
    }

    public String getchoice1(int a) {
        return choices[a][0];
    }

    public String getchoice2(int a) {
        return choices[a][1];
    }

    public String getchoice3(int a) {
        return choices[a][2];
    }

    /*public String getCorrectAnswer(int a) {
        String answer = correctAnswer[a];
        return answer;
    }*/
}
