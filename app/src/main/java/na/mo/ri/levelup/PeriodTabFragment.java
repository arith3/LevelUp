package na.mo.ri.levelup;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import na.mo.ri.levelup.tab.PeriodMonthFragment;
import na.mo.ri.levelup.tab.PeriodTodayFragment;
import na.mo.ri.levelup.tab.PeriodWeekFragment;


public class PeriodTabFragment extends Fragment implements View.OnClickListener {
    public final static int TAB_TODAY_INDEX = 0;
    public final static int TAB_WEEK_INDEX = 1;
    public final static int TAB_MONTH_INDEX = 2;

    private LinearLayout mTabTodayBtn = null;
    private LinearLayout mTabWeekBtn = null;
    private LinearLayout mTabMonthBtn = null;

    private TextView mTabTodayTitle = null;
    private TextView mTabWeekTitle = null;
    private TextView mTabMonthTitle = null;

    private ViewGroup mView;
    private int mCurrentTabIndex;
    private Fragment mFragment;


    public PeriodTabFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = (ViewGroup) inflater.inflate(R.layout.period_fragment_tab, container, false);

        mTabTodayBtn = (LinearLayout) mView.findViewById(R.id.tab_btn1);
        mTabWeekBtn = (LinearLayout) mView.findViewById(R.id.tab_btn2);
        mTabMonthBtn = (LinearLayout) mView.findViewById(R.id.tab_btn3);

        mTabTodayTitle = (TextView) mView.findViewById(R.id.tab_title1);
        mTabWeekTitle = (TextView) mView.findViewById(R.id.tab_title2);
        mTabMonthTitle = (TextView) mView.findViewById(R.id.tab_title3);

        mTabTodayBtn.setOnClickListener(this);
        mTabWeekBtn.setOnClickListener(this);
        mTabMonthBtn.setOnClickListener(this);

        mCurrentTabIndex = TAB_TODAY_INDEX;
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        selectButton(TAB_TODAY_INDEX);
        replaceFrament(TAB_TODAY_INDEX);
    }


    private synchronized void selectButton(int index) {

        switch (index) {
            case TAB_TODAY_INDEX:
                mTabTodayBtn.setBackgroundColor(Color.parseColor("#ff48CAE1"));
                mTabWeekBtn.setBackgroundColor(Color.parseColor("#bbEAEAEA"));
                mTabMonthBtn.setBackgroundColor(Color.parseColor("#bbEAEAEA"));

                break;
            case TAB_WEEK_INDEX:
                mTabTodayBtn.setBackgroundColor(Color.parseColor("#bbEAEAEA"));
                mTabWeekBtn.setBackgroundColor(Color.parseColor("#ff48CAE1"));
                mTabMonthBtn.setBackgroundColor(Color.parseColor("#bbEAEAEA"));
                break;

            case TAB_MONTH_INDEX:
                mTabTodayBtn.setBackgroundColor(Color.parseColor("#bbEAEAEA"));
                mTabWeekBtn.setBackgroundColor(Color.parseColor("#bbEAEAEA"));
                mTabMonthBtn.setBackgroundColor(Color.parseColor("#ff48CAE1"));
                break;
        }

        mTabTodayTitle.setTextColor(Color.parseColor("#ff191919"));
        mTabWeekTitle.setTextColor(Color.parseColor("#ff191919"));
        mTabMonthTitle.setTextColor(Color.parseColor("#ff191919"));

    }

    private synchronized void replaceFrament(int index) {
        //시별,일별,주월에 Fragment 를 교체한다, 버튼 클릭시
        mFragment = null;
        String tag = null;

        switch (index) {
            case TAB_TODAY_INDEX:
                mFragment = new PeriodTodayFragment();
                tag = "period.today.tag";
                break;
            case TAB_WEEK_INDEX:
                mFragment = new PeriodWeekFragment();
                tag = "period.week.tag";
                break;
            case TAB_MONTH_INDEX:
                mFragment = new PeriodMonthFragment();
                tag = "period.month.tag";
                break;
        }

        final FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.layout_pager_area, mFragment, tag);
        transaction.commitAllowingStateLoss();
    }

    @Override
    public void onClick(View v) {
        //시별 일별 주월 클릭시
        int newIndex = TAB_WEEK_INDEX;
        int id = (int) v.getId();

        switch (id) {
            case R.id.tab_btn1:
                newIndex = TAB_TODAY_INDEX;
                break;
            case R.id.tab_btn2:
                newIndex = TAB_WEEK_INDEX;
                break;
            case R.id.tab_btn3:
                newIndex = TAB_MONTH_INDEX;
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
        replaceFrament(mCurrentTabIndex);

    }
}
