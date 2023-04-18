package com.example.quizapplication;

public class QuestionClass {
    public static String question[] ={
            "In which continent are Chile, Argentina and Brazil?",
            "Which brand of soup featured in one of Andy Warhol’s most famous pop art pieces?",
            "The Mad Hatter and the Cheshire Cat are characters in which famous book?",
            "What measurement scale is used to determine wind speed"
    };

    public static String choices[][] = {
            {"North America", "South America", "Europe", "Australasia"},
            {"Heinz", "Campbell’s", "Baxters", "Knorr"},
            {"Winnie-the-Pooh", "Charlotte's Web", "Charlie and the Chocolate Factory", "Alice in Wonderland"},
            {"Beaufort scale", "Richter scale", "Synoptic scale", "Gusting scale"}
    };

    public static int correctAnswers[] = {
            1,
            1,
            3,
            0
    };
}
