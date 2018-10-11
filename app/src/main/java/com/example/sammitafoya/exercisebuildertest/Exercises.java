package com.example.sammitafoya.exercisebuildertest;

public class Exercises {
    public int pushup;
    public int splitSquat;
    public int kbDeadLift;
    public int armLift;
    public int sitUp;

    public Exercises() {
        pushup = 1;
        splitSquat = 2;
        kbDeadLift = 3;
        armLift = 4;
        sitUp = 5;
    }

    public String getExerciseList() {
        // GENERATE RANDOM NUMBER BETWEEN 1 AND 5
        int max = 5;
        int min = 1;

        int random = (int )(Math.random() * max + min);

        // DETERMINE WHICH EXERCISE TO ADD
        String exerciseList = "\n";

        if (random == pushup) {
            exerciseList += "Push Ups";
        } else if (random == splitSquat) {
            exerciseList += "Split Squats";
        } else if (random == kbDeadLift) {
            exerciseList += "Kettle Bell Dead Lifts";
        } else if (random == armLift) {
            exerciseList += "Arm Lifts";
        } else {
            exerciseList += "Sit Ups";
        }

        return exerciseList;
    }
}
