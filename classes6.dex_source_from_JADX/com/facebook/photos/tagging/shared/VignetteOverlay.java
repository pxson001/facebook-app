package com.facebook.photos.tagging.shared;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

/* compiled from: has_available_structured_menu */
public class VignetteOverlay extends View {
    private final int[] f13375a;
    private final float[] f13376b;
    private PointF f13377c;
    private float f13378d;
    private Matrix f13379e;

    public VignetteOverlay(Context context) {
        this(context, null);
    }

    private VignetteOverlay(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13375a = new int[]{0, 0, getResources().getColor(2131363081)};
        this.f13376b = new float[]{0.0f, 0.5f, 1.0f};
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(MeasureSpec.getSize(i), MeasureSpec.getSize(i2));
    }

    protected void onDraw(Canvas canvas) {
        if (this.f13377c != null && this.f13378d > 0.0f && this.f13379e != null) {
            float mapRadius = this.f13379e.mapRadius(this.f13378d) / 0.5f;
            float[] fArr = new float[]{this.f13377c.x, this.f13377c.y};
            this.f13379e.mapPoints(fArr);
            Shader radialGradient = new RadialGradient(fArr[0], fArr[1], mapRadius, this.f13375a, this.f13376b, TileMode.CLAMP);
            Paint paint = new Paint();
            paint.setDither(true);
            paint.setShader(radialGradient);
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), paint);
        }
    }

    public void setPosition(PointF pointF) {
        this.f13377c = pointF;
        invalidate();
    }

    public void setRadius(float f) {
        this.f13378d = f;
        invalidate();
    }

    public void setTransformMatrix(Matrix matrix) {
        this.f13379e = matrix;
        invalidate();
    }
}
