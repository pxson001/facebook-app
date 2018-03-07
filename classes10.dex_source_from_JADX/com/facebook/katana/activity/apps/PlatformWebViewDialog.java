package com.facebook.katana.activity.apps;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;

/* compiled from: user_update_gender */
public class PlatformWebViewDialog extends Dialog {
    public Handler f676a = new Handler();
    public Activity f677b;

    public PlatformWebViewDialog(Activity activity, int i) {
        super(activity, i);
        this.f677b = activity;
    }
}
