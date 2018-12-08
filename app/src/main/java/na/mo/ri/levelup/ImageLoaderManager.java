package na.mo.ri.levelup;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.signature.StringSignature;

import na.mo.ri.levelup.dialog.ImageLoaderDialogListener;

public class ImageLoaderManager {

    public static AlertDialog.Builder imageLoaderDialogBuilderSetup(final ImageLoaderDialogListener listener, Context context) {

        String[] Items = new String[]{"사진 촬영",
                "사진 선택"};

        return new AlertDialog.Builder(context)
                .setItems(Items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                listener.takePhoto();
                                break;
                            case 1:
                                listener.choosePhoto();
                                break;
                        }

                    }
                }).setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

    }


    public static void setProfileImage(Context context, Uri imageUri, ImageView imageView, String imageUpdate) {
        if (null == imageUri || "".equals(imageUri.toString())) {
            int placeHolderResId = R.drawable.thumbnail_edit_profile_guest;
            Glide.with(context)
                    .load(imageUri)
                    .signature(new StringSignature(imageUpdate))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(placeHolderResId)
                    .centerCrop()
                    .fitCenter()
                    .dontAnimate()
                    .into(imageView);

        } else {
            Glide.with(context)
                    .load(imageUri)
                    .signature(new StringSignature(imageUpdate))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .dontAnimate()
                    .into(imageView);
        }
    }
}
