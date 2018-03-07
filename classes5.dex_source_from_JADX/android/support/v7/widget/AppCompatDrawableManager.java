package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.util.LruCache;
import android.util.SparseArray;
import java.util.WeakHashMap;

/* compiled from: uiScrollGestures */
public final class AppCompatDrawableManager {
    private static final Mode f1315a = Mode.SRC_IN;
    public static AppCompatDrawableManager f1316b;
    private static final ColorFilterLruCache f1317c = new ColorFilterLruCache(6);
    private static final int[] f1318d = new int[]{2130837563, 2130837561, 2130837506};
    public static final int[] f1319e = new int[]{2130837524, 2130837527, 2130837534, 2130837526, 2130837525, 2130837533, 2130837528, 2130837529, 2130837532, 2130837531, 2130837530, 2130837535};
    private static final int[] f1320f = new int[]{2130837560, 2130837562, 2130837522, 2130837558};
    private static final int[] f1321g = new int[]{2130837550, 2130837520, 2130837549};
    public static final int[] f1322h = new int[]{2130837523, 2130837556, 2130837564, 2130837552, 2130837553, 2130837551, 2130837555, 2130837554, 2130837512, 2130837507};
    public static final int[] f1323i = new int[]{2130837508, 2130837513};
    public WeakHashMap<Context, SparseArray<ColorStateList>> f1324j;

    /* compiled from: uiScrollGestures */
    class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int i) {
            super(i);
        }
    }

    public static boolean m1808a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static ColorStateList m1807a(Context context) {
        int a = ThemeUtils.m2105a(context, 2130772051);
        int a2 = ThemeUtils.m2105a(context, 2130772052);
        r2 = new int[7][];
        int[] iArr = new int[]{ThemeUtils.f1535a, ThemeUtils.m2108c(context, 2130772051), ThemeUtils.f1536b, a2, ThemeUtils.f1537c, a2, ThemeUtils.f1538d};
        iArr[3] = a2;
        r2[4] = ThemeUtils.f1539e;
        iArr[4] = a2;
        r2[5] = ThemeUtils.f1540f;
        iArr[5] = a2;
        r2[6] = ThemeUtils.f1542h;
        iArr[6] = a;
        return new ColorStateList(r2, iArr);
    }

    public static ColorStateList m1809b(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{ThemeUtils.f1535a, ThemeUtils.m2108c(context, 2130772051), ThemeUtils.f1539e};
        iArr[1] = ThemeUtils.m2105a(context, 2130772052);
        r0[2] = ThemeUtils.f1542h;
        iArr[2] = ThemeUtils.m2105a(context, 2130772051);
        return new ColorStateList(r0, iArr);
    }

    public static ColorStateList m1810c(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{ThemeUtils.f1535a, ThemeUtils.m2106a(context, 16842800, 0.1f), ThemeUtils.f1539e};
        iArr[1] = ThemeUtils.m2106a(context, 2130772052, 0.3f);
        r0[2] = ThemeUtils.f1542h;
        iArr[2] = ThemeUtils.m2106a(context, 16842800, 0.3f);
        return new ColorStateList(r0, iArr);
    }

    public static ColorStateList m1812d(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList b = ThemeUtils.m2107b(context, 2130772055);
        if (b == null || !b.isStateful()) {
            iArr[0] = ThemeUtils.f1535a;
            iArr2[0] = ThemeUtils.m2108c(context, 2130772055);
            iArr[1] = ThemeUtils.f1539e;
            iArr2[1] = ThemeUtils.m2105a(context, 2130772052);
            iArr[2] = ThemeUtils.f1542h;
            iArr2[2] = ThemeUtils.m2105a(context, 2130772055);
        } else {
            iArr[0] = ThemeUtils.f1535a;
            iArr2[0] = b.getColorForState(iArr[0], 0);
            iArr[1] = ThemeUtils.f1539e;
            iArr2[1] = ThemeUtils.m2105a(context, 2130772052);
            iArr[2] = ThemeUtils.f1542h;
            iArr2[2] = b.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    public static ColorStateList m1811c(Context context, int i) {
        r0 = new int[4][];
        r1 = new int[4];
        int a = ThemeUtils.m2105a(context, i);
        int a2 = ThemeUtils.m2105a(context, 2130772053);
        r0[0] = ThemeUtils.f1535a;
        r1[0] = ThemeUtils.m2108c(context, 2130772054);
        r0[1] = ThemeUtils.f1538d;
        r1[1] = ColorUtils.m238a(a2, a);
        r0[2] = ThemeUtils.f1536b;
        r1[2] = ColorUtils.m238a(a2, a);
        r0[3] = ThemeUtils.f1542h;
        r1[3] = a;
        return new ColorStateList(r0, r1);
    }

    public static ColorStateList m1813h(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{ThemeUtils.f1535a, ThemeUtils.m2108c(context, 2130772051), ThemeUtils.f1541g};
        iArr[1] = ThemeUtils.m2105a(context, 2130772051);
        r0[2] = ThemeUtils.f1542h;
        iArr[2] = ThemeUtils.m2105a(context, 2130772052);
        return new ColorStateList(r0, iArr);
    }
}
