package na.mo.ri.levelup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MyCommunityActivity extends AppCompatActivity {

    private LinearLayout container;
    private int number = 3;
    private Button addNew;
    private Button Commu_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_community);

        //부모 뷰
        container = (LinearLayout) findViewById(R.id.parent);
        LinearLayout.LayoutParams params = new LinearLayout.
                LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(50, 30, 50, 30);

        //금연 가즈아 커뮤니티 가는 링크로 수정
        Commu_btn = findViewById(R.id.Commu_btn);
        Commu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goActi = new Intent(MyCommunityActivity.this, CommunityTabActivity.class);
                startActivity(goActi);
            }
        });

        addNew = findViewById(R.id.btnadd);
        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iiit = new Intent(MyCommunityActivity.this, CommunityListActivity.class);
                startActivity(iiit);
            }
        });

        if(GetUserData.com1[0].equals("1"))
            number--;
        if(GetUserData.com2[0].equals("1"))
            number--;
        if(GetUserData.com3[0].equals("1"))
            number--;

        System.out.println("SSIBAL!!!---"+GetUserData.name);
        System.out.println("SSIBAL!!!---"+GetUserData.email);
        System.out.println("SSIBAL!!!---"+GetUserData.picLink);
        System.out.println("SSIBAL!!!---"+GetUserData.com2[2]);
        //number = 23;
        for(int i = 0; i < number; i++) {

            // 버튼 생성
            final Button btn = new Button(this);
            // setId 버튼에 대한 키값
            btn.setId(i + 1);
            if(i == 0) {
                btn.setText(GetUserData.com1[0]);
            } else if(i == 1) {
                btn.setText(GetUserData.com2[0]);
            } else
                btn.setText(GetUserData.com3[0]);
            btn.setLayoutParams(params);
            btn.setTextSize(30);

            final int position = i;
            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Log.d("log", "position :" + position);
                    Toast.makeText(getApplicationContext(), "클릭한 position:" + position, Toast.LENGTH_LONG).show();
                }

            });
            container.addView(btn);
        }

    }
}
