package android.support.v4.app;

import android.app.Activity;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;

/* compiled from: wizard_search_pymk */
public class ActivityCompat extends ContextCompat {
    public static void m53a(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }
}
