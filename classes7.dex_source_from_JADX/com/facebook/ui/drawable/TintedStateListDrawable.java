package com.facebook.ui.drawable;

import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.graphics.ColorUtils;
import android.util.StateSet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: enter_sticker_store */
public class TintedStateListDrawable extends StateListDrawable {
    @Nullable
    private final List<int[]> f15247a = new ArrayList();
    @Nullable
    private final List<Integer> f15248b = new ArrayList();

    public static TintedStateListDrawable m19231a(Drawable drawable, int i, float f) {
        int i2 = 0;
        r1 = new int[2][];
        r1[0] = new int[]{16842910};
        r1[1] = new int[]{-16842910};
        int[] iArr = new int[]{i, ColorUtils.b(i, Math.round(((float) Color.alpha(i)) * f))};
        TintedStateListDrawable tintedStateListDrawable = new TintedStateListDrawable();
        drawable.mutate();
        while (i2 < 2) {
            tintedStateListDrawable.m19232a(r1[i2], Integer.valueOf(iArr[i2]), drawable);
            i2++;
        }
        return tintedStateListDrawable;
    }

    public final void m19232a(int[] iArr, Integer num, Drawable drawable) {
        this.f15247a.add(iArr);
        this.f15248b.add(num);
        super.addState(iArr, drawable);
    }

    public void addState(int[] iArr, Drawable drawable) {
        m19232a(iArr, null, drawable);
    }

    protected boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        if (this.f15247a != null) {
            clearColorFilter();
            int i = 0;
            while (i < this.f15247a.size()) {
                if (!StateSet.stateSetMatches((int[]) this.f15247a.get(i), iArr)) {
                    i++;
                } else if (this.f15248b.get(i) != null) {
                    setColorFilter(((Integer) this.f15248b.get(i)).intValue(), Mode.SRC_IN);
                }
            }
        }
        return onStateChange;
    }
}
