package na.mo.ri.levelup.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import na.mo.ri.levelup.R;


public class OnebuttonDialog extends Dialog {
    private DialogClickListener mDialogClickListener;
    private Button mConfirmButton;
    private TextView mPeriodText;


    public interface DialogClickListener {
        void onConfirm();

    }

    public OnebuttonDialog(Context context) {
        super(context);
        init(context);
    }


    private void init(Context context) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = getLayoutInflater().inflate(R.layout.one_button_dialog, null);
        setContentView(view);
        mConfirmButton = (Button) view.findViewById(R.id.ok);

        mPeriodText = (TextView) view.findViewById(R.id.one_button_content);

//        DecorationUtils.setScaleAlphaAnimation(true, this);

    }

    public void setDialogContent(String content) {
        if (mPeriodText != null) mPeriodText.setText(content);
    }

    public void setOneButtonDialogClickListener(DialogClickListener listener) {
        this.mDialogClickListener = listener;
        mConfirmButton.setOnClickListener(v -> {
            if (mDialogClickListener != null)
                mDialogClickListener.onConfirm();
        });

    }

    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event) {
        return false;
    }

    public void releaseDialog() {
        dismiss();
    }
}
