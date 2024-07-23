package com.example.testbutton;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText numberInput;
    private EditText alphabetInput;
    private Button submitButton;
    private TextView validationMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberInput = findViewById(R.id.numberInput);
        alphabetInput = findViewById(R.id.alphabetInput);
        submitButton = findViewById(R.id.submitButton);
        validationMessage = findViewById(R.id.validationMessage);

        submitButton.setOnClickListener(v -> validateInputs());
    }

    private void validateInputs() {
        String numberText = numberInput.getText().toString().trim();
        String alphabetText = alphabetInput.getText().toString().trim();

        if (TextUtils.isEmpty(numberText) || TextUtils.isEmpty(alphabetText)) {
            showValidationMessage("Empty");
        } else if (!numberText.matches("\\d+")) {
            showValidationMessage("Wrong: Numbers only in first field");
        } else if (!alphabetText.matches("[a-zA-Z]+")) {
            showValidationMessage("Wrong: Alphabets only in second field");
        } else {
            showValidationMessage("Correct");
        }
    }

    private void showValidationMessage(String message) {
        validationMessage.setText(message);
        validationMessage.setVisibility(TextView.VISIBLE);
    }
}
