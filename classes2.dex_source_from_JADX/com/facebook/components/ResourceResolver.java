package com.facebook.components;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.AttrRes;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import com.facebook.components.reference.Reference;
import com.facebook.components.reference.ResourceDrawableReference;

/* compiled from: gcore_ */
public class ResourceResolver {
    private ComponentContext f22704a;
    public Resources f22705b;
    private Theme f22706c;
    public ResourceCache f22707d;
    private final int[] f22708e = new int[1];

    public final void m30669a(ComponentContext componentContext, ResourceCache resourceCache) {
        this.f22704a = componentContext;
        this.f22705b = componentContext.getResources();
        this.f22706c = componentContext.getTheme();
        this.f22707d = resourceCache;
    }

    public final int m30665a(float f) {
        return FastMath.m31104a(this.f22705b.getDisplayMetrics().density * f);
    }

    public final int m30666a(int i) {
        return m30665a((float) i);
    }

    public final String m30671b(@StringRes int i) {
        if (i == 0) {
            return null;
        }
        String str = (String) this.f22707d.m30450a(i);
        if (str != null) {
            return str;
        }
        str = this.f22705b.getString(i);
        this.f22707d.m30451a(i, str);
        return str;
    }

    public final int m30673d(@ColorRes int i) {
        if (i == 0) {
            return 0;
        }
        Integer num = (Integer) this.f22707d.m30450a(i);
        if (num != null) {
            return num.intValue();
        }
        int color = this.f22705b.getColor(i);
        this.f22707d.m30451a(i, Integer.valueOf(color));
        return color;
    }

    public final int m30675e(@DimenRes int i) {
        if (i == 0) {
            return 0;
        }
        Integer num = (Integer) this.f22707d.m30450a(i);
        if (num != null) {
            return num.intValue();
        }
        int dimensionPixelSize = this.f22705b.getDimensionPixelSize(i);
        this.f22707d.m30451a(i, Integer.valueOf(dimensionPixelSize));
        return dimensionPixelSize;
    }

    public final int m30678f(@DimenRes int i) {
        if (i == 0) {
            return 0;
        }
        Integer num = (Integer) this.f22707d.m30450a(i);
        if (num != null) {
            return num.intValue();
        }
        int dimensionPixelOffset = this.f22705b.getDimensionPixelOffset(i);
        this.f22707d.m30451a(i, Integer.valueOf(dimensionPixelOffset));
        return dimensionPixelOffset;
    }

    @Nullable
    public final Reference<Drawable> m30679g(@DrawableRes int i) {
        if (i == 0) {
            return null;
        }
        return ResourceDrawableReference.m30964a(this.f22704a).m30972h(i).mo3297b();
    }

    public final int m30667a(@AttrRes int i, @ColorRes int i2) {
        this.f22708e[0] = i;
        TypedArray obtainStyledAttributes = this.f22706c.obtainStyledAttributes(this.f22708e);
        try {
            int color = obtainStyledAttributes.getColor(0, m30673d(i2));
            return color;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final int m30670b(@AttrRes int i, @DimenRes int i2) {
        this.f22708e[0] = i;
        TypedArray obtainStyledAttributes = this.f22706c.obtainStyledAttributes(this.f22708e);
        try {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, m30675e(i2));
            return dimensionPixelSize;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final int m30672c(@AttrRes int i, @DimenRes int i2) {
        this.f22708e[0] = i;
        TypedArray obtainStyledAttributes = this.f22706c.obtainStyledAttributes(this.f22708e);
        try {
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(0, m30678f(i2));
            return dimensionPixelOffset;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Nullable
    public final Reference<Drawable> m30674d(@AttrRes int i, @DrawableRes int i2) {
        if (i == 0) {
            return null;
        }
        this.f22708e[0] = i;
        TypedArray obtainStyledAttributes = this.f22706c.obtainStyledAttributes(this.f22708e);
        try {
            Reference<Drawable> g = m30679g(obtainStyledAttributes.getResourceId(0, i2));
            return g;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final int m30676e(@AttrRes int i, @DimenRes int i2) {
        this.f22708e[0] = i;
        TypedArray obtainStyledAttributes = this.f22706c.obtainStyledAttributes(this.f22708e);
        try {
            int resourceId = obtainStyledAttributes.getResourceId(0, i2);
            return resourceId;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    protected void mo3295a() {
        m30677e();
    }

    public final void m30677e() {
        this.f22704a = null;
        this.f22705b = null;
        this.f22706c = null;
        this.f22707d = null;
    }
}
