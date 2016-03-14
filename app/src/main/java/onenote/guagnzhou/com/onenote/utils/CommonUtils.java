package onenote.guagnzhou.com.onenote.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;

import onenote.guagnzhou.com.onenote.R;

/**
 * Created by Steven.Shi on 2016/3/3.
 */
public class CommonUtils {


    public static void initSystemBar(Activity mContext) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(mContext, true);
            SystemBarTintManager tintManager = new SystemBarTintManager(
                    mContext);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.colorBgLeftView);

        }

    }

    @TargetApi(19)
    public static void setTranslucentStatus(Activity mContext, boolean on) {
        Window win = mContext.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
}
