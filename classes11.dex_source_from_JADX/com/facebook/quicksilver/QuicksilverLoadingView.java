package com.facebook.quicksilver;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.facebook.drawee.fbpipeline.FbDraweeView;

/* compiled from: SIZE_LARGE */
public class QuicksilverLoadingView extends LinearLayout {
    private ProgressBar f11379a;
    private FbDraweeView f11380b;

    public QuicksilverLoadingView(Context context) {
        this(context, null);
    }

    public QuicksilverLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QuicksilverLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11710a();
    }

    private void m11710a() {
        View.inflate(getContext(), 2130906564, this);
        this.f11379a = (ProgressBar) findViewById(2131559418);
        this.f11380b = (FbDraweeView) findViewById(2131566525);
    }

    public final void m11712a(String str) {
        this.f11380b.setImageURI(Uri.parse(str));
    }

    public final void m11711a(int i) {
        this.f11379a.setMax(i);
    }

    public final void m11713b(int i) {
        this.f11379a.setProgress(i);
    }
}
