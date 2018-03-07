package com.facebook.components;

import android.graphics.drawable.Drawable;
import android.support.v4.util.SparseArrayCompat;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: generateExternalTexture */
public class ComponentHostUtils {
    ComponentHostUtils() {
    }

    static <T> void m30648a(int i, int i2, SparseArrayCompat<T> sparseArrayCompat, SparseArrayCompat<T> sparseArrayCompat2) {
        Object a;
        if (m30652a(i, sparseArrayCompat2)) {
            a = sparseArrayCompat2.m6350a(i);
            sparseArrayCompat2.m6353b(i);
        } else {
            a = sparseArrayCompat.m6350a(i);
            sparseArrayCompat.m6353b(i);
        }
        sparseArrayCompat.m6351a(i2, a);
    }

    static <T> void m30649a(int i, SparseArrayCompat<T> sparseArrayCompat, SparseArrayCompat<T> sparseArrayCompat2) {
        Object a = sparseArrayCompat.m6350a(i);
        if (a != null) {
            sparseArrayCompat2.m6351a(i, a);
        }
    }

    static <T> boolean m30652a(int i, SparseArrayCompat<T> sparseArrayCompat) {
        return (sparseArrayCompat == null || sparseArrayCompat.m6350a(i) == null) ? false : true;
    }

    static List<?> m30647a(SparseArrayCompat<MountItem> sparseArrayCompat) {
        if (sparseArrayCompat.m6348a() == 1) {
            return Collections.singletonList(((MountItem) sparseArrayCompat.m6357f(0)).f22616b);
        }
        List<?> arrayList = new ArrayList();
        for (int i = 0; i < sparseArrayCompat.m6348a(); i++) {
            arrayList.add(((MountItem) sparseArrayCompat.m6357f(i)).f22616b);
        }
        return arrayList;
    }

    public static void m30650a(View view, Drawable drawable, int i) {
        Object obj;
        Object obj2;
        if ((i & 2) == 2) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null || MountItem.m30537b(i)) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null && drawable.isStateful()) {
            drawable.setState(view.getDrawableState());
        }
    }

    static void m30651a(MountItem mountItem) {
        if (mountItem.m30542i()) {
            mountItem.f22617c.m30441b();
        }
    }
}
