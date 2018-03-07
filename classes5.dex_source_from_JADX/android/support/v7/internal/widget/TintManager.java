package android.support.v7.internal.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.LruCache;
import android.util.SparseArray;
import android.util.TypedValue;

/* compiled from: unable to parse key as locale */
public final class TintManager {
    static final boolean f1213a = (VERSION.SDK_INT < 21);
    public static final Mode f1214b = Mode.SRC_IN;
    private static final String f1215c = TintManager.class.getSimpleName();
    private static final ColorFilterLruCache f1216d = new ColorFilterLruCache(6);
    public static final int[] f1217e = new int[]{2130837524, 2130837527, 2130837534, 2130837526, 2130837525, 2130837533, 2130837528, 2130837529, 2130837532, 2130837531, 2130837530, 2130837535, 2130837563, 2130837561, 2130837506};
    public static final int[] f1218f = new int[]{2130837560, 2130837562, 2130837522, 2130837559};
    public static final int[] f1219g = new int[]{2130837550, 2130837520, 2130837549};
    public static final int[] f1220h = new int[]{2130837523, 2130837556, 2130837564, 2130837552, 2130837508, 2130837513, 2130837553, 2130837551, 2130837555, 2130837554, 2130837512, 2130837507};
    public static final int[] f1221i = new int[]{2130837521};
    public final Context f1222j;
    public final Resources f1223k;
    private final TypedValue f1224l;
    private final SparseArray<ColorStateList> f1225m = new SparseArray();
    private ColorStateList f1226n;

    /* compiled from: unable to parse key as locale */
    public class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int i) {
            super(i);
        }

        public static int m1680b(int i, Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }
    }

    public TintManager(Context context) {
        this.f1222j = context;
        this.f1224l = new TypedValue();
        this.f1223k = new TintResources(context.getResources(), this);
    }

    public final Drawable m1690a(int i) {
        Drawable a = ContextCompat.a(this.f1222j, i);
        if (a == null) {
            return a;
        }
        a = a.mutate();
        if (m1683a(f1220h, i)) {
            ColorStateList d = m1686d(i);
            Mode mode = f1214b;
            if (i == 2130837554) {
                mode = Mode.MULTIPLY;
            }
            if (d == null) {
                return a;
            }
            a = DrawableCompat.c(a);
            DrawableCompat.a(a, d);
            DrawableCompat.a(a, mode);
            return a;
        } else if (m1683a(f1221i, i)) {
            return this.f1223k.getDrawable(i);
        } else {
            m1691a(i, a);
            return a;
        }
    }

    final void m1691a(int i, Drawable drawable) {
        int i2;
        Mode mode;
        Object obj;
        int i3;
        if (m1683a(f1217e, i)) {
            i2 = -1;
            mode = null;
            obj = 1;
            i3 = 2130772051;
        } else if (m1683a(f1218f, i)) {
            i2 = -1;
            mode = null;
            r4 = 1;
            i3 = 2130772052;
        } else if (m1683a(f1219g, i)) {
            r4 = 1;
            i3 = 16842801;
            mode = Mode.MULTIPLY;
            i2 = -1;
        } else if (i == 2130837538) {
            mode = null;
            r4 = 1;
            i3 = 16842800;
            i2 = Math.round(40.8f);
        } else {
            i2 = -1;
            i3 = 0;
            mode = null;
            obj = null;
        }
        if (obj != null) {
            if (mode == null) {
                mode = f1214b;
            }
            m1682a(drawable, ThemeUtils.m1674a(this.f1222j, i3), mode);
            if (i2 != -1) {
                drawable.setAlpha(i2);
            }
        }
    }

    public static boolean m1683a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static Drawable m1681a(Context context, int i) {
        Object obj;
        if (m1683a(f1219g, i) || m1683a(f1217e, i) || m1683a(f1218f, i) || m1683a(f1220h, i) || m1683a(f1221i, i)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return ContextCompat.a(context, i);
        }
        TintManager tintManager;
        if (context instanceof TintContextWrapper) {
            tintManager = ((TintContextWrapper) context).f1208a;
        } else {
            tintManager = new TintManager(context);
        }
        return tintManager.m1690a(i);
    }

    final ColorStateList m1692b(int i) {
        return m1683a(f1220h, i) ? m1686d(i) : null;
    }

    private ColorStateList m1686d(int i) {
        ColorStateList colorStateList = (ColorStateList) this.f1225m.get(i);
        if (colorStateList == null) {
            if (i == 2130837523) {
                colorStateList = m1687e();
            } else if (i == 2130837555) {
                r2 = new int[3][];
                r3 = new int[3];
                r2[0] = new int[]{-16842910};
                r3[0] = ThemeUtils.m1675a(this.f1222j, 16842800, 0.1f);
                r2[1] = new int[]{16842912};
                r3[1] = ThemeUtils.m1675a(this.f1222j, 2130772052, 0.3f);
                r2[2] = new int[0];
                r3[2] = ThemeUtils.m1675a(this.f1222j, 16842800, 0.3f);
                colorStateList = new ColorStateList(r2, r3);
            } else if (i == 2130837554) {
                colorStateList = m1685d();
            } else if (i == 2130837512 || i == 2130837507) {
                colorStateList = m1688f();
            } else if (i == 2130837552 || i == 2130837553) {
                colorStateList = m1689g();
            } else {
                colorStateList = m1684b();
            }
            this.f1225m.append(i, colorStateList);
        }
        return colorStateList;
    }

    private ColorStateList m1684b() {
        if (this.f1226n == null) {
            int a = ThemeUtils.m1674a(this.f1222j, 2130772051);
            int a2 = ThemeUtils.m1674a(this.f1222j, 2130772052);
            r2 = new int[7][];
            r3 = new int[7];
            r2[0] = new int[]{-16842910};
            r3[0] = ThemeUtils.m1677c(this.f1222j, 2130772051);
            r2[1] = new int[]{16842908};
            r3[1] = a2;
            r2[2] = new int[]{16843518};
            r3[2] = a2;
            r2[3] = new int[]{16842919};
            r3[3] = a2;
            r2[4] = new int[]{16842912};
            r3[4] = a2;
            r2[5] = new int[]{16842913};
            r3[5] = a2;
            r2[6] = new int[0];
            r3[6] = a;
            this.f1226n = new ColorStateList(r2, r3);
        }
        return this.f1226n;
    }

    private ColorStateList m1685d() {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList b = ThemeUtils.m1676b(this.f1222j, 2130772055);
        if (b == null || !b.isStateful()) {
            iArr[0] = new int[]{-16842910};
            iArr2[0] = ThemeUtils.m1677c(this.f1222j, 2130772055);
            iArr[1] = new int[]{16842912};
            iArr2[1] = ThemeUtils.m1674a(this.f1222j, 2130772052);
            iArr[2] = new int[0];
            iArr2[2] = ThemeUtils.m1674a(this.f1222j, 2130772055);
        } else {
            iArr[0] = new int[]{-16842910};
            iArr2[0] = b.getColorForState(iArr[0], 0);
            iArr[1] = new int[]{16842912};
            iArr2[1] = ThemeUtils.m1674a(this.f1222j, 2130772052);
            iArr[2] = new int[0];
            iArr2[2] = b.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    private ColorStateList m1687e() {
        r0 = new int[3][];
        r1 = new int[3];
        r0[0] = new int[]{-16842910};
        r1[0] = ThemeUtils.m1677c(this.f1222j, 2130772051);
        r0[1] = new int[]{-16842919, -16842908};
        r1[1] = ThemeUtils.m1674a(this.f1222j, 2130772051);
        r0[2] = new int[0];
        r1[2] = ThemeUtils.m1674a(this.f1222j, 2130772052);
        return new ColorStateList(r0, r1);
    }

    private ColorStateList m1688f() {
        r0 = new int[4][];
        r1 = new int[4];
        r0[0] = new int[]{-16842910};
        r1[0] = ThemeUtils.m1677c(this.f1222j, 2130772054);
        r0[1] = new int[]{16842919};
        r1[1] = ThemeUtils.m1674a(this.f1222j, 2130772053);
        r0[2] = new int[]{16842908};
        r1[2] = ThemeUtils.m1674a(this.f1222j, 2130772053);
        r0[3] = new int[0];
        r1[3] = ThemeUtils.m1674a(this.f1222j, 2130772054);
        return new ColorStateList(r0, r1);
    }

    private ColorStateList m1689g() {
        r0 = new int[3][];
        r1 = new int[3];
        r0[0] = new int[]{-16842910};
        r1[0] = ThemeUtils.m1677c(this.f1222j, 2130772051);
        r0[1] = new int[]{-16842919, -16842908};
        r1[1] = ThemeUtils.m1674a(this.f1222j, 2130772051);
        r0[2] = new int[0];
        r1[2] = ThemeUtils.m1674a(this.f1222j, 2130772052);
        return new ColorStateList(r0, r1);
    }

    public static void m1682a(Drawable drawable, int i, Mode mode) {
        ColorFilter colorFilter = (PorterDuffColorFilter) f1216d.a(Integer.valueOf(ColorFilterLruCache.m1680b(i, mode)));
        if (colorFilter == null) {
            colorFilter = new PorterDuffColorFilter(i, mode);
            PorterDuffColorFilter porterDuffColorFilter = (PorterDuffColorFilter) f1216d.a(Integer.valueOf(ColorFilterLruCache.m1680b(i, mode)), colorFilter);
        }
        drawable.setColorFilter(colorFilter);
    }
}
