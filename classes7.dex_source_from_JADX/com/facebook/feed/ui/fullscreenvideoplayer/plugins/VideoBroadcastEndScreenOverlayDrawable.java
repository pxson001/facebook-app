package com.facebook.feed.ui.fullscreenvideoplayer.plugins;

import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.shapes.RectShape;

/* compiled from: This root view has already been attached to a catalyst instance manager */
public class VideoBroadcastEndScreenOverlayDrawable extends ShapeDrawable {
    public VideoBroadcastEndScreenOverlayDrawable(Resources resources) {
        super(new RectShape());
        setShaderFactory(m24824a(resources));
    }

    private ShaderFactory m24824a(Resources resources) {
        final int[] iArr = new int[]{0, resources.getColor(2131362640), -16777216, -16777216};
        final float[] fArr = new float[]{0.0f, 0.3f, 0.52f, 1.0f};
        return new ShaderFactory(this) {
            final /* synthetic */ VideoBroadcastEndScreenOverlayDrawable f22171c;

            public Shader resize(int i, int i2) {
                return new LinearGradient(0.0f, 0.0f, 0.0f, (float) i2, iArr, fArr, TileMode.CLAMP);
            }
        };
    }
}
