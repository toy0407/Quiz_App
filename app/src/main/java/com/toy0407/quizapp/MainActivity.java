package com.toy0407.quizapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinkedList<QuestionClass> qList=new LinkedList<>();
    ArrayList<QuestionClass> finalList=new ArrayList<>();
    int qNo=-1,correct=0,wrong=0,skipped=0;
    RadioGroup radioGroup;
    TextView qnotext,question;
    ImageView image;
    RadioButton b1,b2,b3,b4;
    Button next,skip;
    ConstraintLayout questionlayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup=findViewById(R.id.radioGroup);
        qnotext=findViewById(R.id.questionNo);
        question=findViewById(R.id.question);
        image=findViewById(R.id.image);
        b1=findViewById(R.id.radioButton1);
        b2=findViewById(R.id.radioButton2);
        b3=findViewById(R.id.radioButton3);
        b4=findViewById(R.id.radioButton4);
        next=findViewById(R.id.nextButton);
        skip=findViewById(R.id.skipButton);
        questionlayout=findViewById(R.id.questionLayout);


        getQuestions();
        setQuestions();

        setNextQuestion();

    }

    public void skipButton(View view){
        skipped++;
        qnotext.animate().alpha(0f).setDuration(400).start();
        image.animate().alpha(0f).setDuration(400).start();
        question.animate().alpha(0f).setDuration(400).start();
        radioGroup.animate().alpha(0f).setDuration(400).start();
        setNextQuestion();
    }

    public void nextButton(View view){
        int selectedId=radioGroup.getCheckedRadioButtonId();
        if (selectedId == -1)
        {
            Toast.makeText(getApplicationContext(),"Select an answer!",Toast.LENGTH_SHORT).show();
        }
        else
        {
            qnotext.animate().alpha(0f).setDuration(400).start();
            image.animate().alpha(0f).setDuration(400).start();
            question.animate().alpha(0f).setDuration(400).start();
            radioGroup.animate().alpha(0f).setDuration(400).start();

            RadioButton btn;
            btn=findViewById(selectedId);
            if (finalList.get(qNo).getCorrectAnswer().equals(btn.getText())) correct++;
            else wrong++;
            setNextQuestion();
        }
    }

    private void setNextQuestion() {
        qNo++;
        if (qNo>4){
            AlertDialog alert = new AlertDialog.Builder(this).create();
            alert.setTitle("Score");
            alert.setMessage("Your final score is "+correct+"\nCorrect: "+correct+" Wrong: "+wrong+" Skipped: "+skipped);
            alert.setButton(Dialog.BUTTON_POSITIVE,"Reset Game",new DialogInterface.OnClickListener(){

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    qNo=-1;correct=0;wrong=0;skipped=0;
                    finalList.clear();getQuestions();
                    setQuestions();setNextQuestion();

                }
            });

            alert.show();
        }
        else {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    qnotext.setText("Question No. " + (qNo + 1) + " of 5");
                    question.setText(finalList.get(qNo).getQuestion());
                    image.setImageResource(finalList.get(qNo).getImageDrawable());
                    ArrayList<String> choices=new ArrayList<>();
                    choices.add(finalList.get(qNo).getOtherOption1());
                    choices.add(finalList.get(qNo).getOtherOption2());
                    choices.add(finalList.get(qNo).getOtherOption3());
                    choices.add(finalList.get(qNo).getOtherOption4());
                    radioGroup.clearCheck();
                    Collections.shuffle(choices);
                    b1.setText(choices.get(0));
                    b2.setText(choices.get(1));
                    b3.setText(choices.get(2));
                    b4.setText(choices.get(3));
                }
            }, 300);


            final Handler handler2 = new Handler();
            handler2.postDelayed(new Runnable() {
                @Override
                public void run() {
                    qnotext.animate().alpha(1).setDuration(400).start();
                    image.animate().alpha(1).setDuration(400).start();
                    question.animate().alpha(1).setDuration(400).start();
                    radioGroup.animate().alpha(1).setDuration(400).start();
                }
            }, 300);


        }

    }

    private void setQuestions() {
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int randomIndex = rand.nextInt(qList.size());
            finalList.add(qList.get(randomIndex));
            qList.remove(randomIndex);
        }
    }

    private void getQuestions() {
        qList.add(new QuestionClass("What is the name of this historical structure which is located in Piazza del Duomo, Italy:",R.drawable.leaningtowerofpisa,"Leaning Tower of Pisa", "Colosseum", "Milan Cathedral", "Ponte Vecchio","Leaning Tower of Pisa"));
        qList.add(new QuestionClass("This famous statue located in New York City is referred to as:",R.drawable.statueofliberty,"Statue of liberty","Statue of liberty","Spring Temple Buddha","Christ the Redeemer","Lion-man"));
        qList.add(new QuestionClass("The structure below located in the Middle East was built thousands of years ago, and still stands today:",R.drawable.egyptianpyramid,"Egyption Pyramid","Pharaoh’s Tomb","Joseph’s Tomb","Mecca Temple","Egyption Pyramid"));
        qList.add(new QuestionClass("The highest mountain in the world, standing at 8,848 meters and 29,029 feet, with 145 attempts to climb it:",R.drawable.mounteverest,"Mount Everest","Makalu","Mount Everest","Nanga Parbat","Himalayan Mountains"));
        qList.add(new QuestionClass("This is longest wall in the world and has a main-line length of 3,460 km :",R.drawable.greatwallofchina,"Great Wall of China","Kumbhalgarh Fort","Amer Fort Jaipur","Great Wall of China","Ancient Walls of Mesopotamia"));

    }
}