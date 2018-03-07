package com.facebook.feed.rows.sections.attachments.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;

/* compiled from: V_MPEG4/ISO/ASP */
public abstract class TeamScoreLogoView extends CustomLinearLayout {
    public final BetterTextView f21070a;
    public final FbDraweeView f21071b;

    protected abstract int getLayout();

    public TeamScoreLogoView(Context context) {
        this(context, null);
    }

    public TeamScoreLogoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TeamScoreLogoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(getLayout());
        this.f21070a = (BetterTextView) a(2131567572);
        this.f21071b = (FbDraweeView) a(2131561730);
    }
}
