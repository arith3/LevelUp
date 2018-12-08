package na.mo.ri.levelup.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import na.mo.ri.levelup.R;


public class GoalDialog extends Dialog implements View.OnClickListener {
    public final static int TAB_TODAY_INDEX = 0;
    public final static int TAB_WEEK_INDEX = 1;

    private LinearLayout mTabTodayBtn = null;
    private LinearLayout mTabWeekBtn = null;

    private TextView mTabTodayTitle = null;
    private TextView mTabWeekTitle = null;

    private int mCurrentTabIndex;

    public GoalDialog(Context context) {
        super(context,android.R.style.Theme_DeviceDefault_Dialog_NoActionBar);
        init(context);
    }


    private void init(Context context) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = getLayoutInflater().inflate(R.layout.goal_dialog, null);
        setContentView(view);

        mTabTodayBtn = (LinearLayout) view.findViewById(R.id.tab_btn1);
        mTabWeekBtn = (LinearLayout) view.findViewById(R.id.tab_btn2);

        mTabTodayTitle = (TextView) view.findViewById(R.id.tab_title1);
        mTabWeekTitle = (TextView) view.findViewById(R.id.tab_title2);


        mTabTodayBtn.setOnClickListener(this);
        mTabWeekBtn.setOnClickListener(this);


        mCurrentTabIndex = TAB_TODAY_INDEX;
        selectButton(TAB_TODAY_INDEX);
    }


    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        return true;
    }

    public void releaseDialog() {
        dismiss();
    }

    private synchronized void selectButton(int index) {

        switch (index) {
            case TAB_TODAY_INDEX:
                mTabTodayBtn.setBackgroundColor(Color.parseColor("#ff48CAE1"));
                mTabWeekBtn.setBackgroundColor(Color.parseColor("#bbEAEAEA"));


                break;
            case TAB_WEEK_INDEX:
                mTabTodayBtn.setBackgroundColor(Color.parseColor("#bbEAEAEA"));
                mTabWeekBtn.setBackgroundColor(Color.parseColor("#ff48CAE1"));
                break;

        }

        mTabTodayTitle.setTextColor(Color.parseColor("#ff191919"));
        mTabWeekTitle.setTextColor(Color.parseColor("#ff191919"));


    }

    @Override
    public void onClick(View v) {
        int newIndex = TAB_WEEK_INDEX;
        int id = (int) v.getId();

        switch (id) {
            case R.id.tab_btn1:
                newIndex = TAB_TODAY_INDEX;
                break;
            case R.id.tab_btn2:
                newIndex = TAB_WEEK_INDEX;
                break;
            default:
                break;
        }

        if (mCurrentTabIndex == newIndex) {
            //같은 버튼 클릭 방지
            return;
        } else {
            //현재 클릭한 버튼 Index를 가져온다
            mCurrentTabIndex = newIndex;
        }
        //버튼 클릭한 select 이미지 전환 및 화면 전환을 한다
        selectButton(mCurrentTabIndex);
    }
}
