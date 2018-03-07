package com.facebook.common.ui.util;

import android.content.res.Resources;
import android.util.TypedValue;

/* compiled from: shouldPublishUnpublishedContent */
public class ViewDimensionUtil {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m3877a(android.content.Context r4, int r5, int r6, int r7) {
        /*
        r2 = 0;
        r0 = r4.getTheme();
        r1 = 1;
        r1 = new int[r1];
        r1[r2] = r5;
        r1 = r0.obtainStyledAttributes(r1);
        r0 = new android.util.TypedValue;	 Catch:{ all -> 0x0035 }
        r0.<init>();	 Catch:{ all -> 0x0035 }
        r2 = 0;
        r1.getValue(r2, r0);	 Catch:{ all -> 0x0035 }
        r2 = r0.type;	 Catch:{ all -> 0x0035 }
        switch(r2) {
            case 0: goto L_0x0025;
            case 6: goto L_0x0029;
            default: goto L_0x001c;
        };	 Catch:{ all -> 0x0035 }
    L_0x001c:
        r0 = 0;
        r7 = r1.getLayoutDimension(r0, r7);	 Catch:{ all -> 0x0035 }
        r1.recycle();
    L_0x0024:
        return r7;
    L_0x0025:
        r1.recycle();
        goto L_0x0024;
    L_0x0029:
        r2 = (float) r6;
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0 = r0.getFraction(r2, r3);	 Catch:{  }
        r7 = (int) r0;
        r1.recycle();
        goto L_0x0024;
    L_0x0035:
        r0 = move-exception;
        r1.recycle();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.common.ui.util.ViewDimensionUtil.a(android.content.Context, int, int, int):int");
    }

    public static int m3878a(Resources resources, float f, int i) {
        int i2 = (int) f;
        if (i2 < 0) {
            if (i2 == -1) {
                return -1;
            }
            return -2;
        } else if (i2 > 1) {
            return Math.round(TypedValue.applyDimension(1, f, resources.getDisplayMetrics()));
        } else {
            return Math.round(((float) i) * f);
        }
    }
}
