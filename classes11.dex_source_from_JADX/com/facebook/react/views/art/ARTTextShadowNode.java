package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.annotations.ReactProp;
import javax.annotation.Nullable;

/* compiled from: SELECTED_GUEST_COUNT */
public class ARTTextShadowNode extends ARTShapeShadowNode {
    @Nullable
    public ReadableMap f11428j;
    public int f11429k = 0;

    @ReactProp(name = "frame")
    public void setFrame(@Nullable ReadableMap readableMap) {
        this.f11428j = readableMap;
    }

    @ReactProp(c = 0, name = "alignment")
    public void setAlignment(int i) {
        this.f11429k = i;
    }

    public final void mo305a(Canvas canvas, Paint paint, float f) {
        if (this.f11428j != null) {
            float f2 = f * this.f11414h;
            if (f2 > 0.01f && this.f11428j.hasKey("lines")) {
                ReadableArray a = this.f11428j.a("lines");
                if (a != null && a.size() != 0) {
                    m11761a(canvas);
                    String[] strArr = new String[a.size()];
                    for (int i = 0; i < strArr.length; i++) {
                        strArr[i] = a.getString(i);
                    }
                    String join = TextUtils.join("\n", strArr);
                    if (m11781a(paint, f2)) {
                        m11799a(paint);
                        if (this.f11419g == null) {
                            canvas.drawText(join, 0.0f, -paint.ascent(), paint);
                        } else {
                            canvas.drawTextOnPath(join, this.f11419g, 0.0f, 0.0f, paint);
                        }
                    }
                    if (m11782b(paint, f2)) {
                        m11799a(paint);
                        if (this.f11419g == null) {
                            canvas.drawText(join, 0.0f, -paint.ascent(), paint);
                        } else {
                            canvas.drawTextOnPath(join, this.f11419g, 0.0f, 0.0f, paint);
                        }
                    }
                    canvas.restore();
                    w();
                }
            }
        }
    }

    private void m11799a(Paint paint) {
        int i = 1;
        switch (this.f11429k) {
            case 0:
                paint.setTextAlign(Align.LEFT);
                break;
            case 1:
                paint.setTextAlign(Align.RIGHT);
                break;
            case 2:
                paint.setTextAlign(Align.CENTER);
                break;
        }
        if (this.f11428j != null && this.f11428j.hasKey("font")) {
            ReadableMap b = this.f11428j.b("font");
            if (b != null) {
                int i2;
                float f = 12.0f;
                if (b.hasKey("fontSize")) {
                    f = (float) b.getDouble("fontSize");
                }
                paint.setTextSize(f * this.f11415i);
                int i3 = (b.hasKey("fontWeight") && "bold".equals(b.getString("fontWeight"))) ? 1 : 0;
                if (b.hasKey("fontStyle") && "italic".equals(b.getString("fontStyle"))) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (i3 != 0 && i2 != 0) {
                    i = 3;
                } else if (i3 == 0) {
                    i = i2 != 0 ? 2 : 0;
                }
                paint.setTypeface(Typeface.create(b.getString("fontFamily"), i));
            }
        }
    }
}
