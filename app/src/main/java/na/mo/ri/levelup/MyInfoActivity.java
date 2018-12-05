package na.mo.ri.levelup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;

public class MyInfoActivity extends AppCompatActivity {
    ListView dayDreamView;
    ListView weekDreamView;
    ListView monthDreamView;
    MyDreamAdapter dayDreamAdapter;
    MyDreamAdapter weekDreamAdapter;
    MyDreamAdapter monthDreamAdapter;
    ArrayList<dream_item> dayDream_itemArrayList;
    ArrayList<dream_item> weekDream_itemArrayList;
    ArrayList<dream_item> monthDream_itemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo);
        dayDreamView=(ListView)findViewById(R.id.achieveDay_rankview);
        weekDreamView=(ListView)findViewById(R.id.achieveWeek_rankview);
        monthDreamView=(ListView)findViewById(R.id.achieveMonth_rankview);

        dayDream_itemArrayList = new ArrayList<dream_item>();
        weekDream_itemArrayList = new ArrayList<dream_item>();
        monthDream_itemArrayList = new ArrayList<dream_item>();

        dayDreamAdapter = new MyDreamAdapter(MyInfoActivity.this,dayDream_itemArrayList);
        weekDreamAdapter = new MyDreamAdapter(MyInfoActivity.this, weekDream_itemArrayList);
        monthDreamAdapter = new MyDreamAdapter(MyInfoActivity.this, monthDream_itemArrayList);

        dayDream_itemArrayList.add(
                new dream_item(true,"11월29일","한개피"));
        weekDream_itemArrayList.add(
                new dream_item(true,"11월 둘쨰주","개수줄이기"));
        monthDream_itemArrayList.add(
                new dream_item(false,"11월","줄여라"));

        dayDreamView.setAdapter(dayDreamAdapter);
        weekDreamView.setAdapter(weekDreamAdapter);
        monthDreamView.setAdapter(monthDreamAdapter);

        TabHost tabHost1 = (TabHost) findViewById(R.id.tabHost1) ;
        tabHost1.setup() ;
        // 첫 번째 Tab. (탭 표시 텍스트:"TAB 1"), (페이지 뷰:"content1")
        TabHost.TabSpec ts1 = tabHost1.newTabSpec("Tab Spec 1") ;
        ts1.setContent(R.id.achieve_content) ;
        ts1.setIndicator("현황") ;
        tabHost1.addTab(ts1) ;
        // 두 번째 Tab. (탭 표시 텍스트:"TAB 2"), (페이지 뷰:"content2")
        TabHost.TabSpec ts2 = tabHost1.newTabSpec("Tab Spec 2") ;
        ts2.setContent(R.id.achieveDay_content) ;
        ts2.setIndicator("일별") ;
        tabHost1.addTab(ts2) ;
        // 세 번째 Tab. (탭 표시 텍스트:"TAB 3"), (페이지 뷰:"content3")
        TabHost.TabSpec ts3 = tabHost1.newTabSpec("Tab Spec 3") ;
        ts3.setContent(R.id.achieveWeek_content) ;
        ts3.setIndicator("주별") ;
        tabHost1.addTab(ts3) ;
        // 네 번째 Tab. (탭 표시 텍스트:"TAB 4"), (페이지 뷰:"content4")
        TabHost.TabSpec ts4 = tabHost1.newTabSpec("Tab Spec 4") ;
        ts4.setContent(R.id.achieveMonth_content) ;
        ts4.setIndicator("월별") ;
        tabHost1.addTab(ts4) ;

    }
}
