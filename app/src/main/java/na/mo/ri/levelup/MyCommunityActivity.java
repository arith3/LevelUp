package na.mo.ri.levelup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MyCommunityActivity extends AppCompatActivity {

    private LinearLayout container;
    private int number;
    private ArrayList<Button> btnarr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_community);

        //부모 뷰
        container = (LinearLayout) findViewById(R.id.parent);
        LinearLayout.LayoutParams params = new LinearLayout.
                LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        number = 67; //db에서 받아오자
        for(int i = 0; i < number; i++) {

            // 버튼 생성
            final Button btn = new Button(this);
            // setId 버튼에 대한 키값
            btn.setId(i + 1);
            btn.setText("DB에서 받았어"+i);
            btn.setLayoutParams(params);

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
