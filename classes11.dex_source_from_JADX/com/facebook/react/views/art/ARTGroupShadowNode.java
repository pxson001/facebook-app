package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Region.Op;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

/* compiled from: SHA1 */
public class ARTGroupShadowNode extends ARTVirtualNode {
    @Nullable
    protected RectF f11417g;

    @ReactProp(name = "clipping")
    public void setClipping(@Nullable ReadableArray readableArray) {
        float[] a = PropHelper.m11802a(readableArray);
        if (a != null) {
            this.f11417g = m11764a(a);
            x();
        }
    }

    public final boolean mo306s() {
        return true;
    }

    public final void mo305a(Canvas canvas, Paint paint, float f) {
        float f2 = f * this.f11414h;
        if (f2 > 0.01f) {
            m11761a(canvas);
            if (this.f11417g != null) {
                Canvas canvas2 = canvas;
                canvas2.clipRect(this.f11415i * this.f11417g.left, this.f11415i * this.f11417g.top, this.f11415i * this.f11417g.right, this.f11415i * this.f11417g.bottom, Op.REPLACE);
            }
            for (int i = 0; i < a(); i++) {
                ARTVirtualNode aRTVirtualNode = (ARTVirtualNode) e(i);
                aRTVirtualNode.mo305a(canvas, paint, f2);
                aRTVirtualNode.w();
            }
            canvas.restore();
        }
    }

    private static RectF m11764a(float[] fArr) {
        if (fArr.length == 4) {
            return new RectF(fArr[0], fArr[1], fArr[0] + fArr[2], fArr[1] + fArr[3]);
        }
        throw new JSApplicationIllegalArgumentException("Clipping should be array of length 4 (e.g. [x, y, width, height])");
    }
}
