package com.facebook.backstage.consumption;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build.VERSION;

@TargetApi(21)
/* compiled from: rtc_is_traveling_internationall */
public class StatusBarColorChanger {
    private Activity f4649a;
    private int f4650b;

    public StatusBarColorChanger(Activity activity) {
        this.f4649a = activity;
    }

    public final void m4564a(int i) {
        if (VERSION.SDK_INT >= 21) {
            this.f4650b = this.f4649a.getWindow().getStatusBarColor();
            this.f4649a.getWindow().setStatusBarColor(this.f4649a.getResources().getColor(i));
        }
    }

    public final void m4563a() {
        if (VERSION.SDK_INT >= 21) {
            this.f4649a.getWindow().setStatusBarColor(this.f4650b);
        }
    }
}
