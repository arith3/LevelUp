package na.mo.ri.levelup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;
import na.mo.ri.levelup.coverFlow.CoverFlowCustomAdapter;
import na.mo.ri.levelup.coverFlow.DoWorkEntity;
import na.mo.ri.levelup.dialog.CompleteListener;
import na.mo.ri.levelup.dialog.GoalDialog;
import na.mo.ri.levelup.dialog.TwobuttonDialog;

public class PeriodActivity extends AppCompatActivity {
    private final static String PERIOD_FRAGMENT = "period_fragment_tag";
    private PeriodTabFragment mPeriodTabFragment;
    private CoverFlowCustomAdapter mCoverFlowCustomAdapter;
    private FeatureCoverFlow mCoverFlow;
    Button bbtn;
    int btnclickcnt = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            return;
        }
        setContentView(R.layout.period_goal_layout);

        mCoverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow);
        mPeriodTabFragment = new PeriodTabFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.row_container, mPeriodTabFragment, PERIOD_FRAGMENT).commitAllowingStateLoss();


        initCoverFlow();
        bbtn = findViewById(R.id.btnYes_or_Yes);
        bbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnclickcnt > 0) {
                    Intent intent = new Intent(getApplicationContext(), UserGoalDescriptionActivity.class);
                    startActivity(intent);
                    bbtn.setText("네!");
                    btnclickcnt = 0;
                } else {
                    bbtn.setText("설정완료");
                    btnclickcnt++;
                }
            }
        });
    }

    private void initCoverFlow() {
        ArrayList<DoWorkEntity> list = new ArrayList<>();

        //커버플로우 적용할 Sample dummy 데이터를 넣습니다.
        list.add(new DoWorkEntity("토익을 하는 사람들의 모임:\n 1. 리딩 chapter2 인증하기  \n 2. 단어 30개 \n 3. 리스닝 Chapter3   ", 1));
        list.add(new DoWorkEntity("다이어터 ♡ :\n 1. 플랭크 20 SET  \n 2. 런닝 뛰고 30 분 인증 \n 3. 보증금 찾아가기", 1));
        list.add(new DoWorkEntity("현사모 \n 1. 현주니랑 밥먹기  \n 2. 현주니랑 만화보기 \n 3. 현주니랑 밥먹기 ", 1));
        list.add(new DoWorkEntity("Cover 4", 0));

        mCoverFlowCustomAdapter = new CoverFlowCustomAdapter(this);
        mCoverFlowCustomAdapter.setData(list);
        mCoverFlow.setAdapter(mCoverFlowCustomAdapter);

        mCoverFlow.setOnItemClickListener((parent, view, position, id) -> {
            //커버플로우 적용된  ex(cover 1 ,cover 2 관련 클릭시 포지션 할당) 클릭 이벤트 처리 여기서 하시면됩니다.
//            L.e(":::::::: " + list.get(position).getTitleResId());

//            Intent intent = new Intent(this, UserGoalDescriptionActivity.class);
//            startActivity(intent);
            overridePendingTransition(R.anim.activity_forward_enter, R.anim.activity_forward_exit);
        });

    }


    @Override
    public void onBackPressed() {
        ArrayList<Fragment> fragments = (ArrayList<Fragment>) getSupportFragmentManager().getFragments();
        for (int index = fragments.size() - 1; index >= 0; index--) {
            Fragment fragment = fragments.get(index);
            if (fragment != null) {
                getSupportFragmentManager().beginTransaction().remove(fragments.get(index)).commitAllowingStateLoss();
            }
        }
        finish();
        overridePendingTransition(R.anim.activity_backward_enter, R.anim.activity_backward_exit);
        super.onBackPressed();
    }

    public void showDialog() {
        final GoalDialog dialog = new GoalDialog(this);
        dialog.show();
    }

    public void showDialog(String context, CompleteListener listener) {
        final TwobuttonDialog dialog = new TwobuttonDialog(this);
        dialog.setDialogContent(context);
        dialog.setTwoButtonDialogClickListener(new TwobuttonDialog.DialogClickListener() {
            @Override
            public void onConfirm(String text) {
                dialog.releaseDialog();
                listener.onResult(text);
            }

            @Override
            public void onCancel() {
                dialog.releaseDialog();

            }
        });
        dialog.show();
    }
}
