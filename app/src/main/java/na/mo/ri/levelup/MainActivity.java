package na.mo.ri.levelup;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.sql.Time;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {

    FirebaseAuth mAuth;
    Toolbar myToolbar;
    UserData uData;
    ProgressBar pgb;
    Button btnSin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread thth = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println("THREAD---------------------THREAD");
                    createNotification();
                    try {
                        Thread.sleep(1000*3);

                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }}
            }
        });
        thth.start();

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        pgb = (ProgressBar) findViewById(R.id.progressBar);
        //pgb.setVisibility(ProgressBar.VISIBLE);

        //main Login page
        btnSin = findViewById(R.id.SignInBtn);
        btnSin.setOnClickListener(this);
        Button btnSup = findViewById(R.id.SignUpBtn);
        btnSup.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
        mAuth.getCurrentUser();
        mAuth.signOut();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    //추가된 소스, ToolBar에 추가된 항목의 select 이벤트를 처리하는 함수
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(getApplicationContext(), "나의 정보 버튼 클릭됨", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), UserdataActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_settings2:
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(getApplicationContext(), "수행현황 버튼 클릭됨", Toast.LENGTH_LONG).show();
                Intent intent1 = new Intent(getApplicationContext(), MyInfoActivity.class);
                startActivity(intent1);
                return true;
            case R.id.action_settings3:
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(getApplicationContext(), "로그아웃 버튼 클릭됨", Toast.LENGTH_LONG).show();
                Intent intent2 = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent2);
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                Toast.makeText(getApplicationContext(), "나머지 버튼 클릭됨", Toast.LENGTH_LONG).show();
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.SignInBtn:
                //createNotification();
                final EditText editID = findViewById(R.id.editText);
                final EditText editPS = findViewById(R.id.editText2);

                String mailad = editID.getText().toString().trim();
                String passwd = editPS.getText().toString().trim();
//                String mailad = "na@mo.ri";
//                String passwd = "namori";
                if(mailad.length() < 2 || passwd.length() < 2) {
                    Toast.makeText(MainActivity.this, "입력 정보를 확인하세요!", Toast.LENGTH_SHORT).show();
                    break;
                } else {
                    pgb.setVisibility(ProgressBar.VISIBLE);
                    btnSin.setText("로그인중..");
                    mAuth.signInWithEmailAndPassword(mailad, passwd).addOnCompleteListener(MainActivity.this, task -> {
                        if (task.isSuccessful()) {
                            uData = new UserData(mailad);

                            Intent it33 = new Intent(MainActivity.this, MyCommunityActivity.class);
                            startActivity(it33);
                            btnSin.setText("로그인");
                            pgb.setVisibility(ProgressBar.INVISIBLE);
                        } else {
                            Toast.makeText(MainActivity.this, "로그인 오류!", Toast.LENGTH_SHORT).show();
                            btnSin.setText("다시 로그인");
                            pgb.setVisibility(ProgressBar.INVISIBLE);
                        }
                    });
                }

                break;
            case R.id.SignUpBtn:
                //
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
                break;
        }
    }
    //////////////////////알림부분
    private void createNotification() {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "default");

        builder.setSmallIcon(R.drawable.aoba);
        builder.setContentTitle("LevelUp 할 시간입니다!");
        String[] arr = {"다른 팀원들은 모두 끝냈는데 언제 하실건가요?","JAVA마스터 인증에 댓글이 달렸습니다.","토익 목표를 달성하고 싶으신가요?","계획없는 순간의 즐거움만 찾지 마세요~"};
        builder.setContentText(arr[((int) (Math.random()*100))%arr.length]);

        builder.setColor(Color.RED);
        // 사용자가 탭을 클릭하면 자동 제거(추후수정가)
        builder.setAutoCancel(true);

        // 알림 표시
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(new NotificationChannel("default", "기본 채널", NotificationManager.IMPORTANCE_DEFAULT));
        }

        notificationManager.notify(1, builder.build());
    }

    private void removeNotification() {

        NotificationManagerCompat.from(this).cancel(1);
    }
}
