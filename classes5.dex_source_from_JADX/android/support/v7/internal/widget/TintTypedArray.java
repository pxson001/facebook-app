package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* compiled from: unable to find RGB888+recordable ES2 EGL config */
public class TintTypedArray {
    private final Context f1228a;
    public final TypedArray f1229b;
    private TintManager f1230c;

    public static TintTypedArray m1693a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public TintTypedArray(Context context, TypedArray typedArray) {
        this.f1228a = context;
        this.f1229b = typedArray;
    }

    public final Drawable m1695a(int i) {
        if (this.f1229b.hasValue(i)) {
            int resourceId = this.f1229b.getResourceId(i, 0);
            if (resourceId != 0) {
                return m1700c().m1690a(resourceId);
            }
        }
        return this.f1229b.getDrawable(i);
    }

    public final CharSequence m1697b(int i) {
        return this.f1229b.getText(i);
    }

    public final boolean m1696a(int i, boolean z) {
        return this.f1229b.getBoolean(i, z);
    }

    public final int m1694a(int i, int i2) {
        return this.f1229b.getInt(i, i2);
    }

    public final int m1699c(int i, int i2) {
        return this.f1229b.getDimensionPixelOffset(i, i2);
    }

    public final int m1701d(int i, int i2) {
        return this.f1229b.getDimensionPixelSize(i, i2);
    }

    public final int m1703e(int i, int i2) {
        return this.f1229b.getLayoutDimension(i, i2);
    }

    public final int m1704f(int i, int i2) {
        return this.f1229b.getResourceId(i, i2);
    }

    public final boolean m1702d(int i) {
        return this.f1229b.hasValue(i);
    }

    public final void m1698b() {
        this.f1229b.recycle();
    }

    public final TintManager m1700c() {
        if (this.f1230c == null) {
            TintManager tintManager;
            if (this.f1228a instanceof TintContextWrapper) {
                tintManager = ((TintContextWrapper) this.f1228a).f1208a;
            } else {
                tintManager = new TintManager(this.f1228a);
            }
            this.f1230c = tintManager;
        }
        return this.f1230c;
    }
}
