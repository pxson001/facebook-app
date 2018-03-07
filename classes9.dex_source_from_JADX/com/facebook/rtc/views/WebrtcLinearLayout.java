package com.facebook.rtc.views;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.common.util.FindViewUtil;

/* compiled from: app_package */
public abstract class WebrtcLinearLayout extends LinearLayout {
    protected WebrtcLinearLayout(Context context) {
        super(context);
    }

    public WebrtcLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final <T extends View> T m19719a(int i) {
        return FindViewUtil.b(this, i);
    }

    public final String m19721b(int i) {
        return getContext().getString(i);
    }

    public final String m19720a(int i, Object... objArr) {
        return getContext().getString(i, objArr);
    }

    protected static void m19718a(View view, boolean z) {
        if (VERSION.SDK_INT >= 11) {
            view.setAlpha(z ? 1.0f : 0.8f);
        }
    }
}
