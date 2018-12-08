package na.mo.ri.levelup.tab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import na.mo.ri.levelup.App;
import na.mo.ri.levelup.PeriodActivity;
import na.mo.ri.levelup.R;
import na.mo.ri.levelup.dialog.CompleteListener;


public class PeriodWeekFragment extends Fragment {
    private ViewGroup mView;
    private App mApp;
    private TextView mPeriodContentText;
    private TextView mEmptyText;
    private TextView mDesContentText;
    public PeriodWeekFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = (ViewGroup) inflater.inflate(R.layout.period_week_fragment, container, false);
        mPeriodContentText = (TextView) mView.findViewById(R.id.goal_content);
        mDesContentText = (TextView) mView.findViewById(R.id.goal_content_text);
        mEmptyText = (TextView) mView.findViewById(R.id.empty_text);
        mEmptyText.setOnClickListener(mPeriodEditResultListener);
        mPeriodContentText.setOnClickListener(mPeriodEditResultListener);
        mDesContentText.setOnClickListener(mDescriptionListener);
        return mView;
    }

    private View.OnClickListener mDescriptionListener = v -> {
        PeriodActivity periodActivity = (PeriodActivity) getActivity();

        if (periodActivity != null) {
            periodActivity.showDialog();
        }
    };

    private View.OnClickListener mPeriodEditResultListener = v -> {
        PeriodActivity periodActivity = (PeriodActivity) getActivity();

        if (periodActivity != null) {
            periodActivity.showDialog("한주 목표를 입력하세요.", new CompleteListener() {
                @Override
                public void onResult(String text) {
                    mEmptyText.setVisibility(View.GONE);
                    mPeriodContentText.setVisibility(View.VISIBLE);
                    mPeriodContentText.setText(text);
                }
            });
        }
    };

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
