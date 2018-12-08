package na.mo.ri.levelup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {

    private FirebaseAuth mAuth;
    private UserData uData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //main Login page
        Button btnSin = findViewById(R.id.SignInBtn);
        btnSin.setOnClickListener(this);
        Button btnSup = findViewById(R.id.SignUpBtn);
        btnSup.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.SignInBtn:
                //
                final EditText editID = findViewById(R.id.editText);
                final EditText editPS = findViewById(R.id.editText2);
                //Toast.makeText(this,editID.getText(), Toast.LENGTH_SHORT).show();
                //Toast.makeText(this,editPS.getText(), Toast.LENGTH_SHORT).show();
                String mailad = editID.getText().toString().trim();
                String passwd = editPS.getText().toString().trim();

                if(mailad.length() < 2 || passwd.length() < 2) {
                    Toast.makeText(MainActivity.this, "입력 정보를 확인하세요!", Toast.LENGTH_SHORT).show();
                    break;
                }

                mAuth.signInWithEmailAndPassword(mailad, passwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent it33 = new Intent(MainActivity.this, MyCommunityActivity.class);
                            startActivity(it33);
                        } else {
                            Toast.makeText(MainActivity.this, "로그인 오류!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                uData = new UserData(mailad);
                uData.statUpdate();
                break;
            case R.id.SignUpBtn:
                //
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
                break;
        }
    }
}
