package com.facebook.backstage.consumption;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import com.facebook.backstage.util.KeyboardHeightChangeDetector;
import com.facebook.backstage.util.KeyboardHeightChangeDetector.C05881;
import com.facebook.backstage.util.KeyboardHeightChangeDetector.OnKeyboardHeightChangeListener;

/* compiled from: saw_step */
public class BackstageLifeCycleHelper {
    private final KeyboardHeightChangeDetector f4513a = KeyboardHeightChangeDetector.m5772a();
    public int f4514b = -1;
    public int f4515c = -1;
    private boolean f4516d = false;

    public final void m4486a(Activity activity) {
        if (!this.f4516d) {
            this.f4516d = true;
            activity.setRequestedOrientation(1);
            if (VERSION.SDK_INT >= 21) {
                if (this.f4514b == -1) {
                    this.f4514b = activity.getWindow().getStatusBarColor();
                }
                if (this.f4514b != activity.getResources().getColor(17170444)) {
                    activity.getWindow().setStatusBarColor(activity.getResources().getColor(17170444));
                }
            }
            this.f4515c = activity.getWindow().getAttributes().softInputMode;
            if (this.f4515c != 48) {
                activity.getWindow().setSoftInputMode(48);
            }
            KeyboardHeightChangeDetector keyboardHeightChangeDetector = this.f4513a;
            Activity b = KeyboardHeightChangeDetector.m5774b(activity);
            View findViewById = b.findViewById(16908290);
            if (findViewById.getWindowToken() != null) {
                KeyboardHeightChangeDetector.m5773a(keyboardHeightChangeDetector, b, findViewById.getWindowToken());
            } else {
                findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new C05881(keyboardHeightChangeDetector, findViewById, b));
            }
        }
    }

    public final void m4488b(Activity activity) {
        if (this.f4516d) {
            this.f4516d = false;
            activity.setRequestedOrientation(4);
            if (VERSION.SDK_INT >= 21 && this.f4514b != -1) {
                activity.getWindow().setStatusBarColor(this.f4514b);
            }
            if (this.f4515c != 48) {
                activity.getWindow().setSoftInputMode(this.f4515c);
            }
            KeyboardHeightChangeDetector keyboardHeightChangeDetector = this.f4513a;
            keyboardHeightChangeDetector.f5573b.removeCallbacksAndMessages(null);
            if (keyboardHeightChangeDetector.f5576e != null) {
                keyboardHeightChangeDetector.f5576e.getViewTreeObserver().removeOnGlobalLayoutListener(keyboardHeightChangeDetector.f5577f);
                keyboardHeightChangeDetector.f5575d.removeViewImmediate(keyboardHeightChangeDetector.f5576e);
                keyboardHeightChangeDetector.f5576e = null;
                keyboardHeightChangeDetector.f5580i = false;
            }
        }
    }

    public final void m4487a(OnKeyboardHeightChangeListener onKeyboardHeightChangeListener) {
        this.f4513a.m5775a(onKeyboardHeightChangeListener);
    }
}
