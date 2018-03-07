package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.fbpipeline.FbDraweeView;

/* compiled from: defaultReference */
public class FullCoverImagePlugin extends BaseCoverImagePlugin {
    public FullCoverImagePlugin(Context context) {
        this(context, null);
    }

    private FullCoverImagePlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FullCoverImagePlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130904539);
        this.a = (FbDraweeView) m14861a(2131560814);
    }
}
