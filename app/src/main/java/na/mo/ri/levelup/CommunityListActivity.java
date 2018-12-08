package na.mo.ri.levelup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class CommunityListActivity extends AppCompatActivity {

    private LinearLayout container;
    private Button searccc;
    private EditText searchhh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_list);

        container = (LinearLayout) findViewById(R.id.inLinear);
        LinearLayout.LayoutParams params = new LinearLayout.
                LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(50, 30, 50, 30);

        searchhh = findViewById(R.id.search_area);

        searccc = findViewById(R.id.searchGBtn);
        searccc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), searchhh.getText().toString()+" 검색 수행!", Toast.LENGTH_SHORT).show();
            }
        });


        for(int i = 0; i < 5; i++) {

            // 버튼 생성
            final Button btn = new Button(this);
            // setId 버튼에 대한 키값
            btn.setId(i + 1);
            btn.setText("커뮤니티 No."+i+"\n"+"이 커뮤니티는 "+i+"하는 곳입니다!");

            btn.setLayoutParams(params);
            btn.setTextSize(15);

            final int position = i;
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Log.d("log", "position :" + position);
                    Toast.makeText(getApplicationContext(), "클릭한 position: " + position, Toast.LENGTH_SHORT).show();

                }

            });
            container.addView(btn);
        }
    }
}
