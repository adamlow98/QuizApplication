package com.example.quizapplication;

public class SharedData {
    private static int score;
    private static String name;

    public static int getScore() {
        return score;
    }
    public static void setScore(int myInt) {
        SharedData.score = myInt;
    }

    public static String getName(){
        return name;
    }
    public static void setName(String myName){
        SharedData.name = myName;
    }

}
