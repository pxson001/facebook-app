package com.facebook.facecast.plugin;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.shapes.RectShape;
import android.util.AttributeSet;
import android.view.View;
import javax.annotation.Nullable;

@TargetApi(18)
/* compiled from: block */
public class FacecastWeakConnectionOverlayPlugin extends FacecastBasePlugin {
    private final View f18566c;
    @Nullable
    private ObjectAnimator f18567d;

    /* compiled from: block */
    class WeakConnectionWhiteOverlayDrawable extends ShapeDrawable {
        public WeakConnectionWhiteOverlayDrawable(Resources resources) {
            super(new RectShape());
            setShaderFactory(m22182a(resources));
        }

        private ShaderFactory m22182a(Resources resources) {
            final int[] iArr = new int[]{resources.getColor(2131363606), 0};
            final float[] fArr = new float[]{0.0f, 1.0f};
            return new ShaderFactory(this) {
                final /* synthetic */ WeakConnectionWhiteOverlayDrawable f18565c;

                public Shader resize(int i, int i2) {
                    return new LinearGradient(0.0f, 0.0f, 0.0f, (float) i2, iArr, fArr, TileMode.CLAMP);
                }
            };
        }
    }

    public FacecastWeakConnectionOverlayPlugin(Context context) {
        this(context, null);
    }

    private FacecastWeakConnectionOverlayPlugin(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastWeakConnectionOverlayPlugin(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130904234);
        this.f18566c = a(2131561722);
        this.f18566c.setBackground(new WeakConnectionWhiteOverlayDrawable(context.getResources()));
        this.f18567d = ObjectAnimator.ofFloat(this.f18566c, View.ALPHA, new float[]{0.0f, 0.6f});
        this.f18567d.setDuration(800);
        this.f18567d.setRepeatCount(-1);
        this.f18567d.setRepeatMode(2);
    }

    public void setWeakConnection(boolean z) {
        if (z) {
            this.f18566c.setVisibility(0);
            this.f18566c.setAlpha(0.0f);
            this.f18567d.start();
            return;
        }
        this.f18566c.setVisibility(8);
        this.f18567d.end();
    }
}
