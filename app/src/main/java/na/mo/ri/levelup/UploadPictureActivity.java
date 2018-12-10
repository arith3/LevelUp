package na.mo.ri.levelup;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.List;

import na.mo.ri.levelup.dialog.ImageLoaderDialogListener;
import na.mo.ri.levelup.dialog.TwobuttonDialog;
//사진업로드

public class UploadPictureActivity extends AppCompatActivity {
    public final static int REQUEST_PERMISSIONS = 0x01;
    public final static int REQUEST_PICK_IMAGE = 0x20;

    private Button mPeriodMoveButton;
    private TextView mPeriodContentText;
    private TextView mEmptyText;
    private ImageView mPhoto;
    private Uri mCameraUri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uploadpicture_layout);
        mPeriodMoveButton = (Button) findViewById(R.id.next);
        mPeriodContentText = (TextView) findViewById(R.id.goal_content);
        mEmptyText = (TextView) findViewById(R.id.empty_text);
        mPhoto = (ImageView) findViewById(R.id.goal_photo);
        mEmptyText.setOnClickListener(mPeriodEditResultListener);
        mPeriodContentText.setOnClickListener(mPeriodEditResultListener);
        mPhoto.setOnClickListener(mPohtoListener);

        mPeriodMoveButton.setOnClickListener(v -> {
            Suzukaze.Aoba[0] = GetUserData.inView_Group;
            Intent intent = new Intent(UploadPictureActivity.this, PeriodActivity.class);
            startActivity(intent);
           // overridePendingTransition(R.anim.activity_forward_enter, R.anim.activity_forward_exit);
        });

    }

    private View.OnClickListener mPohtoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (!checkPermission(REQUEST_PERMISSIONS)) {

            } else {
                popupImageDialog();
            }
        }
    };

    private View.OnClickListener mPeriodEditResultListener = v -> {
        //밑줄 클릭시 팝업창을 열어준다.
        final TwobuttonDialog dialog = new TwobuttonDialog(this);
        dialog.setDialogContent("나의 목표를 입력 해주세요.");
        dialog.setTwoButtonDialogClickListener(new TwobuttonDialog.DialogClickListener() {
            @Override
            public void onConfirm(String text) {
                dialog.releaseDialog();
                mEmptyText.setVisibility(View.INVISIBLE);
                mPeriodContentText.setVisibility(View.VISIBLE);
                mPeriodContentText.setText(text);
                Suzukaze.Aoba[1] = text;
            }

            @Override
            public void onCancel() {
                dialog.releaseDialog();

            }
        });
        dialog.show();
    };


    private void popupImageDialog() {
        ImageLoaderManager.imageLoaderDialogBuilderSetup(new ImageLoaderDialogListener() {
            @Override
            public void takePhoto() {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                String folderName = "LevelUp";// 폴더명
                String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + folderName;
                File fileFolderPath = new File(path);
                if (!fileFolderPath.exists()) {
                    if (false == fileFolderPath.mkdir()) {
                        return;
                    }
                }

                String url = "levelup_" + String.valueOf(System.currentTimeMillis()) + ".jpg";
                Uri outputFileUri = FileProvider.getUriForFile(getApplicationContext(), getApplicationContext().getPackageName() + ".provider", new File(path, url));

                List<ResolveInfo> resolvedIntentActivities = getApplicationContext().getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
                for (ResolveInfo resolvedIntentInfo : resolvedIntentActivities) {
                    String packageName = resolvedIntentInfo.activityInfo.packageName;
                    getApplicationContext().grantUriPermission(packageName, outputFileUri, Intent.FLAG_GRANT_WRITE_URI_PERMISSION | Intent.FLAG_GRANT_READ_URI_PERMISSION);
                }

                mCameraUri = outputFileUri;

                intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
                startActivityForResult(intent, REQUEST_PICK_IMAGE);
            }

            @Override
            public void choosePhoto() {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, REQUEST_PICK_IMAGE);
            }
        }, UploadPictureActivity.this).show();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_PICK_IMAGE:
                try {
                    Uri uri;
                    if (mCameraUri != null) {
                        uri = mCameraUri;
                        mCameraUri = null;
                    } else {
                        if (data == null) {
                            return;
                        }
                        uri = data.getData();
                    }

                    if (uri != null) {
                        ImageLoaderManager.setProfileImage(getApplicationContext(), uri, mPhoto, "");
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

        }
    }


    protected boolean checkPermission(int type) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int permission, permission2, permission3, permission4, permission5, permission6, permission7;
            switch (type) {
                case REQUEST_PERMISSIONS:
                    permission = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
                    permission2 = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE);
                    permission3 = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA);
                    if (permission == PackageManager.PERMISSION_DENIED || permission2 == PackageManager.PERMISSION_DENIED || permission3 == PackageManager.PERMISSION_DENIED) {
                        ActivityCompat.requestPermissions(this, new String[]{
                                Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, REQUEST_PERMISSIONS);
                        return false;
                    } else {
                        return true;
                    }
            }

        }

        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_PERMISSIONS: {
                if (grantResults.length > 0 &&
                        grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED &&
                        grantResults[2] == PackageManager.PERMISSION_GRANTED) {
                } else {

                }
            }
        }
    }

}
