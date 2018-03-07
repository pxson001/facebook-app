package com.facebook.greetingcards.verve.render;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.shapes.RectShape;
import com.facebook.greetingcards.verve.model.VMColor;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: viewed_wallet_active */
public class ColorParseUtil {

    /* compiled from: viewed_wallet_active */
    public final class C00361 extends ShaderFactory {
        final /* synthetic */ VMColor f362a;
        final /* synthetic */ int[] f363b;
        final /* synthetic */ float[] f364c;

        public C00361(VMColor vMColor, int[] iArr, float[] fArr) {
            this.f362a = vMColor;
            this.f363b = iArr;
            this.f364c = fArr;
        }

        public final Shader resize(int i, int i2) {
            float f;
            float f2;
            float f3;
            float f4;
            float f5 = 0.0f;
            if (this.f362a.angle < 0.0f) {
                f = 360.0f + this.f362a.angle;
            } else {
                f = this.f362a.angle;
            }
            if (f == 0.0f) {
                f2 = ((float) i) / 2.0f;
                f3 = (float) i2;
                f4 = f2;
            } else if (f == 90.0f) {
                f = ((float) i2) / 2.0f;
                f2 = (float) i;
                f3 = f;
                f4 = 0.0f;
                f5 = f;
            } else if (f == 180.0f) {
                f2 = ((float) i) / 2.0f;
                f3 = 0.0f;
                f4 = f2;
                f5 = (float) i2;
            } else if (f == 270.0f) {
                f = ((float) i2) / 2.0f;
                f3 = f;
                f4 = (float) i;
                f2 = 0.0f;
                f5 = f;
            } else {
                f5 = (float) Math.tan(Math.toRadians((double) (90.0f - f)));
                float f6 = -1.0f / f5;
                f4 = ((float) i2) / 2.0f;
                f2 = ((float) i) / 2.0f;
                if (f < 90.0f) {
                    f = f4;
                    f3 = f2;
                } else if (f < 180.0f) {
                    f = -f4;
                    f3 = f2;
                } else if (f < 270.0f) {
                    f3 = -f2;
                    f = -f4;
                } else {
                    f3 = -f2;
                    f = f4;
                }
                f -= f3 * f6;
                f5 = f / (f5 - f6);
                f6 = (f6 * f5) + f;
                f3 = f2 + f5;
                f = f4 - f6;
                f2 -= f5;
                f5 = f4 + f6;
                f4 = f3;
                f3 = f;
            }
            return new LinearGradient(f4, f3, f2, f5, this.f363b, this.f364c, TileMode.CLAMP);
        }
    }

    public static Drawable m335a(VMColor vMColor) {
        if (vMColor == null) {
            return null;
        }
        if (!"linear-gradient".equals(vMColor.type)) {
            return new ColorDrawable(m336b(vMColor));
        }
        ImmutableList b;
        int i = 0;
        ImmutableList immutableList = vMColor.locations;
        int[] iArr = new int[vMColor.colors.size()];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = m334a((ImmutableList) vMColor.colors.get(i2));
        }
        if (immutableList == null) {
            Builder builder = ImmutableList.builder();
            for (int i3 = 0; i3 < iArr.length; i3++) {
                builder.c(Float.valueOf(((float) i3) / ((float) (iArr.length - 1))));
            }
            b = builder.b();
        } else {
            b = immutableList;
        }
        float[] fArr = new float[b.size()];
        while (i < fArr.length) {
            fArr[i] = ((Float) b.get(i)).floatValue();
            i++;
        }
        ShaderFactory c00361 = new C00361(vMColor, iArr, fArr);
        Drawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.setShape(new RectShape());
        shapeDrawable.setShaderFactory(c00361);
        return shapeDrawable;
    }

    public static int m336b(VMColor vMColor) {
        return m334a(vMColor.color);
    }

    public static int m334a(ImmutableList<Float> immutableList) {
        if (immutableList == null) {
            immutableList = ImmutableList.of(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(0.0f));
        }
        boolean z = immutableList.size() == 3 || immutableList.size() == 4;
        Preconditions.checkArgument(z);
        if (immutableList.size() == 3) {
            return Color.rgb(m333a(((Float) immutableList.get(0)).floatValue()), m333a(((Float) immutableList.get(1)).floatValue()), m333a(((Float) immutableList.get(2)).floatValue()));
        }
        return Color.argb(m333a(((Float) immutableList.get(3)).floatValue()), m333a(((Float) immutableList.get(0)).floatValue()), m333a(((Float) immutableList.get(1)).floatValue()), m333a(((Float) immutableList.get(2)).floatValue()));
    }

    private static int m333a(float f) {
        return (int) (((double) (255.0f * f)) + 0.5d);
    }
}
