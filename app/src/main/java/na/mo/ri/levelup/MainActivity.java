package na.mo.ri.levelup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //main Login page

        final EditText editID = (EditText) findViewById(R.id.editText);
        final EditText editPS = (EditText) findViewById(R.id.editText2);

        Button btnSin = (Button) findViewById(R.id.SignInBtn);
        btnSin.setOnClickListener(this);
        Button btnSup = (Button) findViewById(R.id.SignUpBtn);
        btnSup.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.SignInBtn:
                //
                break;
            case R.id.SignUpBtn:
                //
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
                break;
        }
    }
}
