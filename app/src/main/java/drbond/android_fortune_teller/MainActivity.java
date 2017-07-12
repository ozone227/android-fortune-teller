package drbond.android_fortune_teller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import java.util.*;
import android.hardware.SensorManager;
import android.hardware.Sensor;
import android.content.*;




public class MainActivity extends AppCompatActivity {
    private TextView answerText;
    private TextView questionText;

    // The following are used for the shake detection
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private FortuneShake mShakeDetector;
    String userQuestion = "";
    String[] fortunes = getResources().getStringArray(R.array.fortunes);
    String randomStr = fortunes[new Random().nextInt(fortunes.length)];


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TextView References
        questionText = (TextView) findViewById(R.id.questionText);
        answerText = (TextView) findViewById(R.id.answerText);

        // TextWatchers
        EditText enterQuestion =
                (EditText) findViewById(R.id.enterQuestion);
        enterQuestion.addTextChangedListener(enterQuestionTextWatcher);

        // ShakeDetector initialization
        // Sensor mAccelerometer = mAccelerometer;
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new FortuneShake();
        mShakeDetector.setOnShakeListener(new FortuneShake.OnShakeListener() {

            @Override
            public void onShake(int count) {
				/*
				 * The following method, "handleShakeEvent(count):" is a stub //
				 * method you would use to setup whatever you want done once the
				 * device has been shook.
				 */
                answerText.setText(randomStr);
            }
        });

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
