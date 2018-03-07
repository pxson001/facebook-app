package com.facebook.video.videohome.views;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: show_payment_method_tag */
public class VideoHomeComposerView extends CustomLinearLayout {
    public FbDraweeView f3339a;
    public BetterTextView f3340b;

    public VideoHomeComposerView(Context context) {
        this(context, null);
    }

    private VideoHomeComposerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private VideoHomeComposerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130907711);
        this.f3339a = (FbDraweeView) findViewById(2131568418);
        this.f3340b = (BetterTextView) findViewById(2131568419);
    }
}
