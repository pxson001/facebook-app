package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

/* compiled from: SHARED */
public abstract class ARTVirtualNode extends ReactShadowNode {
    private static final float[] f11412g = new float[9];
    private static final float[] f11413j = new float[9];
    protected float f11414h = 1.0f;
    protected final float f11415i = DisplayMetricsHolder.a.density;
    @Nullable
    private Matrix f11416k = new Matrix();

    public abstract void mo305a(Canvas canvas, Paint paint, float f);

    public boolean mo306s() {
        return true;
    }

    protected final void m11761a(Canvas canvas) {
        canvas.save();
        if (this.f11416k != null) {
            canvas.concat(this.f11416k);
        }
    }

    protected static void m11760b(Canvas canvas) {
        canvas.restore();
    }

    @ReactProp(b = 1.0f, name = "opacity")
    public void setOpacity(float f) {
        this.f11414h = f;
        x();
    }

    @ReactProp(name = "transform")
    public void setTransform(@Nullable ReadableArray readableArray) {
        if (readableArray != null) {
            int a = PropHelper.m11801a(readableArray, f11412g);
            if (a == 6) {
                m11759O();
            } else if (a != -1) {
                throw new JSApplicationIllegalArgumentException("Transform matrices must be of size 6");
            }
        }
        this.f11416k = null;
        x();
    }

    private void m11759O() {
        f11413j[0] = f11412g[0];
        f11413j[1] = f11412g[2];
        f11413j[2] = f11412g[4] * this.f11415i;
        f11413j[3] = f11412g[1];
        f11413j[4] = f11412g[3];
        f11413j[5] = f11412g[5] * this.f11415i;
        f11413j[6] = 0.0f;
        f11413j[7] = 0.0f;
        f11413j[8] = 1.0f;
        if (this.f11416k == null) {
            this.f11416k = new Matrix();
        }
        this.f11416k.setValues(f11413j);
    }
}
