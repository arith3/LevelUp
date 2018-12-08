package na.mo.ri.levelup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import na.mo.ri.levelup.dialog.OnebuttonDialog;


public class UserGoalDescriptionActivity extends AppCompatActivity {
    private TextView mSurvival;
    private TextView mReleation;
    private TextView mGrowth;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usergoal_des_activity);

        mSurvival = (TextView) findViewById(R.id.survival);
        mReleation = (TextView) findViewById(R.id.releation);
        mGrowth = (TextView) findViewById(R.id.growth);

        mSurvival.setOnClickListener(v -> showDialog("생존 욕구"));

        mReleation.setOnClickListener(v -> showDialog("관계 욕구"));

        mGrowth.setOnClickListener(v -> showDialog("성장 욕구"));


    }

    public void showDialog(String context) {
        //팝업창 생성
        final OnebuttonDialog dialog = new OnebuttonDialog(this);
        dialog.setDialogContent(context);
        dialog.setOneButtonDialogClickListener(() -> dialog.releaseDialog());
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.activity_backward_enter, R.anim.activity_backward_exit);
    }
}
