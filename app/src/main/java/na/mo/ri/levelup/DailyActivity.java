package na.mo.ri.levelup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DailyActivity extends AppCompatActivity implements View.OnClickListener {

    Button alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);
        //ddddd
        //팝업 버튼을 만들어보자
//        alert=(Button)findViewById(R.id.alert);
//        alert.setOnClickListener(this);//클릭됫을시 리스너를 단다
    }

    @Override
    public void onClick(View v) {

    }
}
