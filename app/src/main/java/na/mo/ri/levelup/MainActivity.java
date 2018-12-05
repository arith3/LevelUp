package na.mo.ri.levelup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //main Login page
        Button btnSin = findViewById(R.id.SignInBtn);
        btnSin.setOnClickListener(this);
        Button btnSup = findViewById(R.id.SignUpBtn);
        btnSup.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.SignInBtn:
                //
                final EditText editID = findViewById(R.id.editText);
                final EditText editPS = findViewById(R.id.editText2);
                Toast.makeText(this,editID.getText(), Toast.LENGTH_SHORT).show();
                Toast.makeText(this,editPS.getText(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.SignUpBtn:
                //
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
                break;
        }
    }
}
