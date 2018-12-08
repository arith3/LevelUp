package na.mo.ri.levelup;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;


public class App extends Application implements Application.ActivityLifecycleCallbacks {
    public static App sInstance;
    private int mRunning = 0;
    private AppStatus mAppStatus = AppStatus.BACKGROUND;
    private Context mContext;

    public enum AppStatus {
        BACKGROUND, // app is background
        RETURNED_TO_FOREGROUND, // app returned to foreground(or first launch)
        FOREGROUND; // app is foreground
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;
        mContext = sInstance.getApplicationContext();

        registerActivityLifecycleCallbacks(this);
    }


    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {

        if (bundle != null) {
            activity.finish();
            activity.overridePendingTransition(0, 0);


            PackageManager packageManager = this.getPackageManager();
            Intent intent = packageManager.getLaunchIntentForPackage(this.getPackageName());
            ComponentName componentName = intent.getComponent();
//            Intent mainIntent = IntentCompat.makeRestartActivityTask(componentName);
            Intent mainIntent = Intent.makeRestartActivityTask(componentName);
            this.startActivity(mainIntent);
            activity.overridePendingTransition(0, 0);


        }
    }

    @Override
    public void onActivityStarted(Activity activity) {
        if (++mRunning == 1) { // original position
            mAppStatus = AppStatus.RETURNED_TO_FOREGROUND;
        } else if (mRunning > 1) {
            mAppStatus = AppStatus.FOREGROUND;
        }

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {
        if (--mRunning == 0) {
            mAppStatus = AppStatus.BACKGROUND;
        }
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }


}
