package na.mo.ri.levelup;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    private EditText yourID;
    private EditText yourPS;
    private EditText yourPS2;
    private Button cnlth;
    private Button gaip;
    private FirebaseAuth fAuth;
    private boolean phase = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        yourID = findViewById(R.id.editText);
        yourPS = findViewById(R.id.editText2);
        yourPS2 = findViewById(R.id.editText3);
        cnlth = findViewById(R.id.NoBtn);
        gaip = findViewById(R.id.BackBtn);

        fAuth = FirebaseAuth.getInstance();

        yourPS2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (yourPS.getText().toString().equals(yourPS2.getText().toString())) {
                    yourPS.setBackgroundColor(Color.rgb(30, 255, 30));
                    yourPS2.setBackgroundColor(Color.rgb(30, 255, 30));
                    phase = true;
                } else {
                    yourPS.setBackgroundColor(Color.rgb(255, 30, 30));
                    yourPS2.setBackgroundColor(Color.rgb(255, 30, 30));
                    phase = false;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        gaip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String line = yourID.getText().toString().trim();
                String ps2ps = yourPS2.getText().toString().trim();
                //Toast.makeText(SignupActivity.this, line, Toast.LENGTH_SHORT).show();
                //Toast.makeText(SignupActivity.this, ps2ps, Toast.LENGTH_SHORT).show();
                if(phase) {
                    fAuth.createUserWithEmailAndPassword(line, ps2ps).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                Toast.makeText(SignupActivity.this, "Signup Complete!", Toast.LENGTH_SHORT).show();
                                Intent iiit = new Intent(SignupActivity.this, MainActivity.class);
                                startActivity(iiit);
                                finish();
                            } else {
                                Toast.makeText(SignupActivity.this, "ERROR! Retry please.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(SignupActivity.this, "Check Passwords!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cnlth.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
