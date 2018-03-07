package com.facebook.video.player.plugins;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
/* compiled from: power_plugged_in */
public class CoverImagePlugin extends BaseCoverImagePlugin {
    @DoNotStrip
    public CoverImagePlugin(Context context) {
        this(context, null);
    }

    private CoverImagePlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private CoverImagePlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130903812);
        this.a = (FbDraweeView) m14861a(2131560814);
    }
}
