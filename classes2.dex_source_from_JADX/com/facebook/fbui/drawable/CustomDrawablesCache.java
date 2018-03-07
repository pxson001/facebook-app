package com.facebook.fbui.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.LongSparseArray;
import android.util.TypedValue;

/* compiled from: user_fbid */
public class CustomDrawablesCache extends LongSparseArray<ConstantState> {
    private LongSparseArray<Integer> f1445a;
    private LongSparseArray<ConstantState> f1446b;
    private Resources f1447c;
    private DrawableLoader f1448d;

    public CustomDrawablesCache(LongSparseArray<ConstantState> longSparseArray, DrawableLoader drawableLoader, Resources resources) {
        this.f1448d = drawableLoader;
        this.f1447c = resources;
        this.f1446b = longSparseArray;
        int size = longSparseArray.size();
        for (int i = 0; i < size; i++) {
            long keyAt = longSparseArray.keyAt(i);
            put(keyAt, longSparseArray.get(keyAt));
        }
        m2788a(this.f1448d.f1351e);
    }

    private void m2788a(int[] iArr) {
        if (iArr != null) {
            TypedValue typedValue = new TypedValue();
            this.f1445a = new LongSparseArray(iArr.length);
            for (int i : iArr) {
                this.f1447c.getValue(i, typedValue, true);
                this.f1445a.put((((long) typedValue.assetCookie) << 32) | ((long) typedValue.data), Integer.valueOf(i));
            }
        }
    }

    public Object get(long j) {
        Integer num = this.f1445a != null ? (Integer) this.f1445a.get(j) : null;
        if (num == null) {
            return (ConstantState) super.get(j);
        }
        Drawable a = this.f1448d.m2596a(num.intValue(), this.f1447c);
        if (a != null) {
            return a.getConstantState();
        }
        throw new RuntimeException("Unable to inflate custom drawable with id: 0x" + Integer.toHexString(num.intValue()));
    }
}
