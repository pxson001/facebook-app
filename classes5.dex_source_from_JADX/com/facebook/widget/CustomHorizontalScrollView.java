package com.facebook.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.HorizontalScrollView;
import com.facebook.common.util.FindViewUtil;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;

/* compiled from: com.google.android.gms.signin.internal.usePromptModeForAuthCode */
public class CustomHorizontalScrollView extends HorizontalScrollView {
    public OnScrollListener f5591a;

    /* compiled from: com.google.android.gms.signin.internal.usePromptModeForAuthCode */
    public interface OnScrollListener {
        void m10400a();
    }

    public CustomHorizontalScrollView(Context context) {
        super(context);
    }

    public CustomHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomHorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void setContentView(int i) {
        TracerDetour.a("CustomFrameLayout.setContentView", -996280621);
        try {
            LayoutInflater.from(getContext()).inflate(i, this);
        } finally {
            TracerDetour.a(-609891839);
        }
    }

    protected final <T extends View> T m10401a(int i) {
        return FindViewUtil.b(this, i);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.f5591a = onScrollListener;
    }

    public void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f5591a != null) {
            this.f5591a.m10400a();
        }
    }
}
