package com.facebook.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.facebook.R;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
@Deprecated
/* compiled from: com.google.android.gms.common.api.internal.IStatusCallback */
public class RoundedDrawParams {
    public final boolean f5743a;
    public final boolean f5744b;
    public final boolean f5745c;
    public final boolean f5746d;
    public final boolean f5747e;
    public final float f5748f;
    public final int f5749g;
    public final float f5750h;
    public int f5751i;

    /* compiled from: com.google.android.gms.common.api.internal.IStatusCallback */
    public class Builder {
        public boolean f5734a = false;
        public boolean f5735b = true;
        public boolean f5736c = true;
        public boolean f5737d = true;
        public boolean f5738e = true;
        public float f5739f = 0.0f;
        public int f5740g = 0;
        public float f5741h = 2.0f;
        public int f5742i = 0;

        public final RoundedDrawParams m10526a() {
            return new RoundedDrawParams(this.f5734a, this.f5735b, this.f5736c, this.f5737d, this.f5738e, this.f5739f, this.f5740g, this.f5741h, this.f5742i);
        }
    }

    public static RoundedDrawParams m10528a(Context context, @Nullable AttributeSet attributeSet, int i) {
        Preconditions.checkNotNull(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundedView, i, 0);
        RoundedDrawParams roundedDrawParams = new RoundedDrawParams(obtainStyledAttributes.getBoolean(0, false), obtainStyledAttributes.getBoolean(1, true), obtainStyledAttributes.getBoolean(2, true), obtainStyledAttributes.getBoolean(4, true), obtainStyledAttributes.getBoolean(3, true), obtainStyledAttributes.getDimension(5, 0.0f), obtainStyledAttributes.getColor(6, 0), obtainStyledAttributes.getDimension(7, 2.0f), obtainStyledAttributes.getColor(8, 0));
        obtainStyledAttributes.recycle();
        return roundedDrawParams;
    }

    public static RoundedDrawParams m10527a() {
        return new RoundedDrawParams(true, true, true, true, true, 0.0f, 0, 2.0f, 0);
    }

    private RoundedDrawParams(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, float f, int i, float f2, int i2) {
        this.f5743a = z;
        this.f5744b = z2;
        this.f5745c = z3;
        this.f5746d = z4;
        this.f5747e = z5;
        this.f5748f = f;
        this.f5749g = i;
        this.f5750h = f2;
        this.f5751i = i2;
        if (!this.f5743a) {
            return;
        }
        if (f > 0.0f) {
            throw new IllegalArgumentException("RoundedView cannot have cornerRadius set if it's a circle");
        }
        Object obj;
        if (this.f5744b && this.f5745c && this.f5746d && this.f5747e) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            throw new IllegalArgumentException("RoundedView doesn't support disabling individual rounded corners when it's a circle");
        }
    }
}
