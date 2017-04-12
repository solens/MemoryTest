package com.example.android.quizapp;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.R.attr.checked;
import static android.R.attr.right;

public class MainActivity extends AppCompatActivity {

    public CountDownTimer Timer = null;
    public TextView timer;
    public long time_allowed = 20*1000;

    public int rightAnswers = 0;

    public int question_in_progress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
// Push Start Button: Initialize question_in_progress, start the first question with timer
    public void startQuiz(View v){
        startQuestion1();
    }


    public void startQuestion1(){
        setContentView(R.layout.question1);
        question_in_progress = 1;

        startTimer();

    }

    public void Answer1(View v){
        TextView bottomText = (TextView) findViewById(R.id.bottomText1);
        TextView rightAnswer = (TextView) findViewById(R.id.bottomText1bis);

        Button SubmitButton = (Button) findViewById(R.id.submit1);
        Button NextButton = (Button) findViewById(R.id.next1);

        RadioButton ans = (RadioButton) findViewById(R.id.q1ans3);

        if (ans.isChecked()){
            rightAnswers += 1;
            bottomText.setText("Right!");
            SubmitButton.setClickable(false);
            SubmitButton.setEnabled(false);
            NextButton.setClickable(true);
            NextButton.setEnabled(true);

        }

        else {
            bottomText.setText("Wrong. The answer was:");
            rightAnswer.setText(R.string.q1answer3);

            SubmitButton.setClickable(false);
            SubmitButton.setEnabled(false);
            NextButton.setClickable(true);
            NextButton.setEnabled(true);
        }

        Context context = getApplicationContext();
        CharSequence text = "" + rightAnswers + "/" + question_in_progress;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText( context, text, duration);
        toast.setGravity(Gravity.BOTTOM|Gravity.END,0,10);
        toast.show();


    }

    public void startQuestion2(View v){
        setContentView(R.layout.question2);
        question_in_progress = 2;
        startTimer();

    }

    public void Answer2(View v){
        TextView bottomText = (TextView) findViewById(R.id.bottomText2);
        TextView rightAnswer = (TextView) findViewById(R.id.bottomText2bis);

        Button SubmitButton = (Button) findViewById(R.id.submit2);
        Button NextButton = (Button) findViewById(R.id.next2);

        RadioButton ans = (RadioButton) findViewById(R.id.q2ans2);

        if (ans.isChecked()){
            rightAnswers += 1;
            bottomText.setText("Right!");
            SubmitButton.setClickable(false);
            SubmitButton.setEnabled(false);
            NextButton.setClickable(true);
            NextButton.setEnabled(true);

        }

        else {
            bottomText.setText("Wrong. The answer was:");
            rightAnswer.setText(R.string.q2answer2);

            SubmitButton.setClickable(false);
            SubmitButton.setEnabled(false);
            NextButton.setClickable(true);
            NextButton.setEnabled(true);
        }

        Context context = getApplicationContext();
        CharSequence text = "" + rightAnswers + "/" + question_in_progress;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText( context, text, duration);
        toast.setGravity(Gravity.BOTTOM|Gravity.END,0,10);
        toast.show();

    }

    public void startQuestion3(View v){
        setContentView(R.layout.question3);
        question_in_progress = 3;

        startTimer();

    }

    public void Answer3(View v){
        TextView bottomText = (TextView) findViewById(R.id.bottomText3);

        Button SubmitButton = (Button) findViewById(R.id.submit3);
        Button NextButton = (Button) findViewById(R.id.next3);

        CheckBox ans1 = (CheckBox) findViewById(R.id.q3ans1);
        CheckBox ans2 = (CheckBox) findViewById(R.id.q3ans2);
        CheckBox ans3 = (CheckBox) findViewById(R.id.q3ans3);
        CheckBox ans4 = (CheckBox) findViewById(R.id.q3ans4);

        if (ans1.isChecked() && ans2.isChecked() && ans3.isChecked() && !(ans4.isChecked())){
            rightAnswers += 1;
            bottomText.setText("Right!");
            SubmitButton.setClickable(false);
            SubmitButton.setEnabled(false);
            NextButton.setClickable(true);
            NextButton.setEnabled(true);
        }

        else {
            bottomText.setText("Wrong. There was an elephant, a lemur and a rhinoceros, but no flamingo.");

            SubmitButton.setClickable(false);
            SubmitButton.setEnabled(false);
            NextButton.setClickable(true);
            NextButton.setEnabled(true);
        }

        Context context = getApplicationContext();
        CharSequence text = "" + rightAnswers + "/" + question_in_progress;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText( context, text, duration);
        toast.setGravity(Gravity.BOTTOM|Gravity.END,0,10);
        toast.show();
    }

    public void Answer4page(View v){

        setContentView(R.layout.answer4);
        question_in_progress = 4;

    }

    public void Answer4(View v){

        TextView bottomText = (TextView) findViewById(R.id.bottomText4);

        Button SubmitButton = (Button) findViewById(R.id.submit4);
        Button NextButton = (Button) findViewById(R.id.next4);

        EditText secret = (EditText) findViewById(R.id.secretWord);
        String secret_word = secret.getText().toString().toLowerCase();

        if (secret_word.equals("banana")){
            rightAnswers += 1;
            bottomText.setText("Right!");

            SubmitButton.setClickable(false);
            SubmitButton.setEnabled(false);
            NextButton.setClickable(true);
            NextButton.setEnabled(true);
        }
        else {
            bottomText.setText("We were looking for: Banana");

            SubmitButton.setClickable(false);
            SubmitButton.setEnabled(false);
            NextButton.setClickable(true);
            NextButton.setEnabled(true);
        }

        Context context = getApplicationContext();
        CharSequence text = "" + rightAnswers + "/" + question_in_progress;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText( context, text, duration);
        toast.setGravity(Gravity.BOTTOM|Gravity.END,0,10);
        toast.show();
    }

    public void Results(View v){
        setContentView(R.layout.results);

        TextView score = (TextView) findViewById(R.id.finalScore);
        score.setText("" + rightAnswers+ "/4");
    }

    public void Restart(View v){
        Intent i = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage( getBaseContext().getPackageName() );
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    public void startTimer() {
        timer = (TextView) findViewById(R.id.time);

        if (!(Timer == null)){
            Timer.cancel();}
        Timer = new CountDownTimer(time_allowed, 1000){
            public void onTick(long millisUntilDone){
                timer.setText("" + millisUntilDone/ 1000);
            }
            public void onFinish() {
                if(question_in_progress == 1){setContentView(R.layout.answer1);}
                if(question_in_progress == 2){setContentView(R.layout.answer2);}
                if(question_in_progress == 3){setContentView(R.layout.answer3);}
                Timer.cancel();
            }

        };

        Timer.start();
    }
}
