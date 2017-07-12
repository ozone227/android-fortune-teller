package drbond.android_fortune_teller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.*;



public class MainActivity extends AppCompatActivity {
    private TextView answerText;
    private TextView questionText;
    String userQuestion = "";
    String[] fortunes = getResources().getStringArray(R.array.fortunes);
    String randomStr = fortunes[new Random().nextInt(fortunes.length)];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TextView References
        questionText = (TextView) findViewById(R.id.questionText);
        answerText = (TextView) findViewById(R.id.answerText);

        // TextWatchers
        EditText enterQuestion =
                (EditText) findViewById(R.id.enterQuestion);
        enterQuestion.addTextChangedListener(enterQuestionTextWatcher);

    }

    // listener object for DownPayment EditText
    private final TextWatcher enterQuestionTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            userQuestion = s.toString();
            questionText.setText(userQuestion);
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };







}
