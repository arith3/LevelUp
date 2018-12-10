package na.mo.ri.levelup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;

import static java.lang.Math.toIntExact;


public class Reenter extends AppCompatActivity implements View.OnClickListener {

    private EditText reentercontentview;
    TextView tv1;
    private Button reenter_button;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_reenter_k);
        //reentertextview=(EditText) findViewById(R.id.reenter_title);
        reentercontentview=(EditText)findViewById(R.id.reenter_content);
        reenter_button=(Button)findViewById(R.id.reenter_button);
        reenter_button.setOnClickListener(this);
        tv1 = findViewById(R.id.textView4);
        tv1.setText("\""+Suzukaze.Aoba[1] + "\" 입니다.");
    }

    public void onClick(View v) {

        switch (v.getId()){
            case R.id.reenter_button :
                Suzukaze.Aoba[5] = reentercontentview.getText().toString();

                Intent intent = new Intent(
                        getApplicationContext(), // 현재 화면의 제어권자
                        inGroup_info.class); // 다음 넘어갈 클래스 지정
                startActivity(intent);
                break;
        }
    }








}
