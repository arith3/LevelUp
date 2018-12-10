package na.mo.ri.levelup;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static java.lang.Math.toIntExact;

public class CommunityListActivity extends AppCompatActivity {

    private LinearLayout container;
    private Button searccc;
    private EditText searchhh;
    int forint = 0;
    String[] forstr;
    DatabaseReference gData = FirebaseDatabase.getInstance().getReference().child("community");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_list);

        container = (LinearLayout) findViewById(R.id.inLinear);
        LinearLayout.LayoutParams params = new LinearLayout.
                LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(50, 30, 50, 30);

        searchhh = findViewById(R.id.search_area);

        gData.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                forint = toIntExact(dataSnapshot.getChildrenCount());
                forstr = new String[forint];
                for(int i = 0; i < forint; i++) {
                    forstr[i] = dataSnapshot.child("1").child("name").getValue().toString();
                    System.out.println("SSIBAL!!!======"+forstr[i]+"=="+Integer.toString(i));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        searccc = findViewById(R.id.searchGBtn);
        searccc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), searchhh.getText().toString()+" 검색 수행!", Toast.LENGTH_SHORT).show();
            }
        });


        for(int i = 0; i < 3; i++) {

            // 버튼 생성
            final Button btn = new Button(this);
            // setId 버튼에 대한 키값
            btn.setId(i + 1);
            btn.setText(""+forstr[i]+" 가즈아~");

            btn.setLayoutParams(params);
            btn.setTextSize(15);

            final int position = i;
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Log.d("log", "position :" + position);
                    GetUserData.inView_Group = forstr[position] + "가즈아~";
                    //Toast.makeText(getApplicationContext(), "클릭한 position: " + position, Toast.LENGTH_SHORT).show();
                    Intent iiir = new Intent(CommunityListActivity.this, GetNewCommunityActivity.class);
                    startActivity(iiir);
                }
            });
            container.addView(btn);
        }
    }
}
