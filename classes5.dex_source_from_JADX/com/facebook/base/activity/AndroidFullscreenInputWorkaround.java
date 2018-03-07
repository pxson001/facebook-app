package com.facebook.base.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

/* compiled from: suggest_text_2 */
public class AndroidFullscreenInputWorkaround {
    public View f2411a;
    public int f2412b;
    public LayoutParams f2413c;
    public FrameLayout f2414d;
    public int f2415e;
    public OnGlobalLayoutListener f2416f;

    /* compiled from: suggest_text_2 */
    public class C01561 implements OnGlobalLayoutListener {
        final /* synthetic */ AndroidFullscreenInputWorkaround f2410a;

        public C01561(AndroidFullscreenInputWorkaround androidFullscreenInputWorkaround) {
            this.f2410a = androidFullscreenInputWorkaround;
        }

        public void onGlobalLayout() {
            AndroidFullscreenInputWorkaround androidFullscreenInputWorkaround = this.f2410a;
            Rect rect = new Rect();
            androidFullscreenInputWorkaround.f2414d.getWindowVisibleDisplayFrame(rect);
            int i = rect.bottom - rect.top;
            if (i != androidFullscreenInputWorkaround.f2412b) {
                int height = androidFullscreenInputWorkaround.f2414d.getHeight();
                int i2 = height - i;
                if (i2 > height / 4) {
                    androidFullscreenInputWorkaround.f2413c.height = (height - i2) + androidFullscreenInputWorkaround.f2415e;
                } else {
                    androidFullscreenInputWorkaround.f2413c.height = height;
                }
                androidFullscreenInputWorkaround.f2411a.requestLayout();
                androidFullscreenInputWorkaround.f2412b = i;
            }
        }
    }

    public AndroidFullscreenInputWorkaround(Activity activity) {
        int i = 0;
        int identifier = activity.getApplicationContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            i = activity.getApplicationContext().getResources().getDimensionPixelSize(identifier);
        }
        this.f2415e = i;
        this.f2414d = (FrameLayout) activity.findViewById(16908290);
        this.f2411a = this.f2414d.getChildAt(0);
    }

    public final void m3312b() {
        this.f2411a.getViewTreeObserver().removeOnGlobalLayoutListener(this.f2416f);
    }
}
