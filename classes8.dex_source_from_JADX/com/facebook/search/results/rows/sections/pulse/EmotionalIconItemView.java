package com.facebook.search.results.rows.sections.pulse;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: PUBLIC_WATCHED */
public class EmotionalIconItemView extends CustomFrameLayout {
    private final FbDraweeView f24714a;
    private final BetterTextView f24715b;
    private final BetterTextView f24716c;

    public EmotionalIconItemView(Context context) {
        this(context, null, 2130903968);
    }

    public EmotionalIconItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 2130903968);
    }

    public EmotionalIconItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setContentView(i);
        this.f24714a = (FbDraweeView) c(2131561169);
        this.f24715b = (BetterTextView) c(2131561170);
        this.f24716c = (BetterTextView) c(2131561171);
    }

    public final void m28129a(Uri uri, CallerContext callerContext) {
        this.f24714a.a(uri, callerContext);
    }

    public void setEmotionalDrawable(Drawable drawable) {
        this.f24714a.setImageDrawable(drawable);
    }

    public void setEmotionName(String str) {
        this.f24715b.setText(str);
    }

    public void setEmotionCount(String str) {
        this.f24716c.setText(str);
    }
}
