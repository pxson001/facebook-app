package com.facebook.richdocument.view.widget.video;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.richdocument.view.widget.InchwormAnimatedView;

/* compiled from: nullstate_image_xxhdpi */
public abstract class VideoControlIcon extends InchwormAnimatedView {
    private boolean f7731e;

    public VideoControlIcon(Context context) {
        this(context, null);
    }

    public VideoControlIcon(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoControlIcon(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setLoading(boolean z) {
        if (z) {
            this.f7731e = m7428a();
            return;
        }
        m7430e();
        this.f7731e = false;
    }
}
