package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

/* compiled from: SERVICES_CAROUSEL */
public class ARTShapeShadowNode extends ARTVirtualNode {
    @Nullable
    protected Path f11419g;
    @Nullable
    private float[] f11420j;
    @Nullable
    private float[] f11421k;
    @Nullable
    private float[] f11422l;
    private float f11423m = 1.0f;
    private int f11424n = 1;
    private int f11425o = 1;

    @ReactProp(name = "d")
    public void setShapePath(@Nullable ReadableArray readableArray) {
        this.f11419g = m11779a(PropHelper.m11802a(readableArray));
        x();
    }

    @ReactProp(name = "stroke")
    public void setStroke(@Nullable ReadableArray readableArray) {
        this.f11420j = PropHelper.m11802a(readableArray);
        x();
    }

    @ReactProp(name = "strokeDash")
    public void setStrokeDash(@Nullable ReadableArray readableArray) {
        this.f11422l = PropHelper.m11802a(readableArray);
        x();
    }

    @ReactProp(name = "fill")
    public void setFill(@Nullable ReadableArray readableArray) {
        this.f11421k = PropHelper.m11802a(readableArray);
        x();
    }

    @ReactProp(b = 1.0f, name = "strokeWidth")
    public void setStrokeWidth(float f) {
        this.f11423m = f;
        x();
    }

    @ReactProp(c = 1, name = "strokeCap")
    public void setStrokeCap(int i) {
        this.f11424n = i;
        x();
    }

    @ReactProp(c = 1, name = "strokeJoin")
    public void setStrokeJoin(int i) {
        this.f11425o = i;
        x();
    }

    public void mo305a(Canvas canvas, Paint paint, float f) {
        float f2 = this.f11414h * f;
        if (f2 > 0.01f) {
            m11761a(canvas);
            if (this.f11419g == null) {
                throw new JSApplicationIllegalArgumentException("Shapes should have a valid path (d) prop");
            }
            if (m11782b(paint, f2)) {
                canvas.drawPath(this.f11419g, paint);
            }
            if (m11781a(paint, f2)) {
                canvas.drawPath(this.f11419g, paint);
            }
            canvas.restore();
        }
        w();
    }

    protected final boolean m11781a(Paint paint, float f) {
        if (this.f11423m == 0.0f || this.f11420j == null || this.f11420j.length == 0) {
            return false;
        }
        paint.reset();
        paint.setFlags(1);
        paint.setStyle(Style.STROKE);
        switch (this.f11424n) {
            case 0:
                paint.setStrokeCap(Cap.BUTT);
                break;
            case 1:
                paint.setStrokeCap(Cap.ROUND);
                break;
            case 2:
                paint.setStrokeCap(Cap.SQUARE);
                break;
            default:
                throw new JSApplicationIllegalArgumentException("strokeCap " + this.f11424n + " unrecognized");
        }
        switch (this.f11425o) {
            case 0:
                paint.setStrokeJoin(Join.MITER);
                break;
            case 1:
                paint.setStrokeJoin(Join.ROUND);
                break;
            case 2:
                paint.setStrokeJoin(Join.BEVEL);
                break;
            default:
                throw new JSApplicationIllegalArgumentException("strokeJoin " + this.f11425o + " unrecognized");
        }
        paint.setStrokeWidth(this.f11423m * this.f11415i);
        paint.setARGB((int) (this.f11420j.length > 3 ? (this.f11420j[3] * f) * 255.0f : f * 255.0f), (int) (this.f11420j[0] * 255.0f), (int) (this.f11420j[1] * 255.0f), (int) (this.f11420j[2] * 255.0f));
        if (this.f11422l != null && this.f11422l.length > 0) {
            FLog.a("React", "ART: Dashes are not supported yet!");
        }
        return true;
    }

    protected final boolean m11782b(Paint paint, float f) {
        if (this.f11421k == null || this.f11421k.length <= 0) {
            return false;
        }
        paint.reset();
        paint.setFlags(1);
        paint.setStyle(Style.FILL);
        int i = (int) this.f11421k[0];
        switch (i) {
            case 0:
                paint.setARGB((int) (this.f11421k.length > 4 ? (this.f11421k[4] * f) * 255.0f : f * 255.0f), (int) (this.f11421k[1] * 255.0f), (int) (this.f11421k[2] * 255.0f), (int) (this.f11421k[3] * 255.0f));
                break;
            default:
                FLog.a("React", "ART: Color type " + i + " not supported!");
                break;
        }
        return true;
    }

    private Path m11779a(float[] fArr) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        int i = 0;
        while (i < fArr.length) {
            int i2 = i + 1;
            i = (int) fArr[i];
            int i3;
            switch (i) {
                case 0:
                    i3 = i2 + 1;
                    i = i3 + 1;
                    path.moveTo(this.f11415i * fArr[i2], fArr[i3] * this.f11415i);
                    break;
                case 1:
                    path.close();
                    i = i2;
                    break;
                case 2:
                    i3 = i2 + 1;
                    i = i3 + 1;
                    path.lineTo(this.f11415i * fArr[i2], fArr[i3] * this.f11415i);
                    break;
                case 3:
                    i3 = i2 + 1;
                    int i4 = i3 + 1;
                    int i5 = i4 + 1;
                    int i6 = i5 + 1;
                    int i7 = i6 + 1;
                    int i8 = i7 + 1;
                    path.cubicTo(fArr[i2] * this.f11415i, fArr[i3] * this.f11415i, fArr[i4] * this.f11415i, fArr[i5] * this.f11415i, fArr[i6] * this.f11415i, fArr[i7] * this.f11415i);
                    i = i8;
                    break;
                case 4:
                    i = i2 + 1;
                    float f = fArr[i2] * this.f11415i;
                    i2 = i + 1;
                    float f2 = fArr[i] * this.f11415i;
                    i = i2 + 1;
                    float f3 = fArr[i2] * this.f11415i;
                    i2 = i + 1;
                    float toDegrees = (float) Math.toDegrees((double) fArr[i]);
                    i3 = i2 + 1;
                    float toDegrees2 = (float) Math.toDegrees((double) fArr[i2]);
                    i = i3 + 1;
                    if ((fArr[i3] == 0.0f ? 1 : null) == null) {
                        toDegrees2 = 360.0f - toDegrees2;
                    }
                    path.addArc(new RectF(f - f3, f2 - f3, f + f3, f2 + f3), toDegrees, toDegrees - toDegrees2);
                    break;
                default:
                    throw new JSApplicationIllegalArgumentException("Unrecognized drawing instruction " + i);
            }
        }
        return path;
    }
}
