package na.mo.ri.levelup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GetNewCommunityActivity extends AppCompatActivity {

    private Button inside;
    TextView titleM;
    TextView nowPeo;
    TextView nowPer;

    int status = 0;
    int randIs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_new_community);
        titleM = findViewById(R.id.gazua);
        titleM.setText(GetUserData.inView_Group);
        nowPeo = findViewById(R.id.nowPeople);
        nowPeo.setText(GetUserData.nownum+"명 참여중");
        nowPer = findViewById(R.id.nowPercent);
        randIs = (int) (Math.random()*100) + 1;
        nowPer.setText(randIs+"% 진행중");
        inside = findViewById(R.id.butttttttt);
        inside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "참여하시려면 한번 더 버튼을 누르세요!", Toast.LENGTH_SHORT).show();
                status++;
                if(status > 1) {
                    Intent iiiit = new Intent(GetNewCommunityActivity.this, UploadPictureActivity.class);
                    startActivity(iiiit);
                }
            }
        });

    }
}
