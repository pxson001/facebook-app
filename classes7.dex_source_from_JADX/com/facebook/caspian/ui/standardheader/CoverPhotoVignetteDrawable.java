package com.facebook.caspian.ui.standardheader;

import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.shapes.RectShape;

/* compiled from: crowdsourcedPhoto */
public class CoverPhotoVignetteDrawable extends ShapeDrawable {
    public CoverPhotoVignetteDrawable(Resources resources) {
        super(new RectShape());
        setShaderFactory(m20596a(resources));
    }

    private ShaderFactory m20596a(Resources resources) {
        final int[] iArr = new int[]{0, resources.getColor(2131362075), resources.getColor(2131362076), resources.getColor(2131362077), resources.getColor(2131362078), resources.getColor(2131362079)};
        final float[] fArr = new float[]{0.0f, 0.12f, 0.66f, 0.73f, 0.82f, 1.0f};
        return new ShaderFactory(this) {
            final /* synthetic */ CoverPhotoVignetteDrawable f16530c;

            public Shader resize(int i, int i2) {
                return new LinearGradient(0.0f, 0.0f, 0.0f, (float) i2, iArr, fArr, TileMode.CLAMP);
            }
        };
    }
}
