package na.mo.ri.levelup.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import na.mo.ri.levelup.R;


public class TwobuttonDialog extends Dialog {
    private DialogClickListener mDialogClickListener;
    private EditText mContentEdit;
    private Button mConfirmButton;
    private Button mCancelButton;
    private TextView mPeriodText;


    public interface DialogClickListener {
        void onConfirm(String text);

        void onCancel();
    }

    public TwobuttonDialog(Context context) {
        super(context);
        init(context);
    }


    private void init(Context context) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = getLayoutInflater().inflate(R.layout.two_button_dialog, null);
        setContentView(view);
        mConfirmButton = (Button) view.findViewById(R.id.ok);
        mCancelButton = (Button) view.findViewById(R.id.cancel);
        mPeriodText = (TextView) view.findViewById(R.id.two_button_content);
        mContentEdit = (EditText) view.findViewById(R.id.custom_content);
//        DecorationUtils.setScaleAlphaAnimation(true, this);

    }

    public void setDialogContent(String content) {
        if (mPeriodText != null) mPeriodText.setText(content);
    }

    public void setTwoButtonDialogClickListener(DialogClickListener listener) {
        this.mDialogClickListener = listener;
        mConfirmButton.setOnClickListener(v -> {
            if (mDialogClickListener != null)
                if (mContentEdit.getText().toString().equalsIgnoreCase("") || TextUtils.isEmpty(mContentEdit.getText().toString())) {
                    return;
                }
            mDialogClickListener.onConfirm(mContentEdit.getText().toString());
        });

        mCancelButton.setOnClickListener(v -> {
            if (mDialogClickListener != null) mDialogClickListener.onCancel();
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
