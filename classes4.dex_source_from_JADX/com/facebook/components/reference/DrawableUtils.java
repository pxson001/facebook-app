package com.facebook.components.reference;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import java.lang.reflect.Field;

/* compiled from: oxygen_map_static_map_report_button_clicked */
public class DrawableUtils {
    private static Field f5602a;
    private static Field f5603b;
    private static Field f5604c;
    private static Field f5605d;
    private static Field f5606e;
    private static Field f5607f;
    private static boolean f5608g;

    static {
        f5608g = false;
        try {
            Class cls = Class.forName("android.graphics.drawable.LayerDrawable$LayerState");
            Class cls2 = Class.forName("android.graphics.drawable.LayerDrawable$ChildDrawable");
            Field declaredField = LayerDrawable.class.getDeclaredField("mLayerState");
            f5602a = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = cls.getDeclaredField("mChildren");
            f5603b = declaredField2;
            declaredField2.setAccessible(true);
            declaredField2 = cls2.getDeclaredField("mInsetL");
            f5604c = declaredField2;
            declaredField2.setAccessible(true);
            declaredField2 = cls2.getDeclaredField("mInsetT");
            f5605d = declaredField2;
            declaredField2.setAccessible(true);
            declaredField2 = cls2.getDeclaredField("mInsetR");
            f5606e = declaredField2;
            declaredField2.setAccessible(true);
            declaredField2 = cls2.getDeclaredField("mInsetB");
            f5607f = declaredField2;
            declaredField2.setAccessible(true);
            f5608g = true;
        } catch (Exception e) {
            f5608g = false;
        }
    }

    public static boolean m6004a(Drawable drawable, Drawable drawable2) {
        if (drawable == drawable2) {
            return true;
        }
        if (drawable == null && drawable2 == null) {
            return true;
        }
        if (drawable == null || drawable2 == null) {
            return false;
        }
        if (drawable.getClass() != drawable2.getClass()) {
            return false;
        }
        if (drawable instanceof ColorDrawable) {
            ColorDrawable colorDrawable = (ColorDrawable) drawable;
            ColorDrawable colorDrawable2 = (ColorDrawable) drawable2;
            boolean z = false;
            if (colorDrawable.getColor() == colorDrawable2.getColor() && colorDrawable.getOpacity() == colorDrawable2.getOpacity() && colorDrawable.getAlpha() == colorDrawable2.getAlpha()) {
                z = true;
            }
            return z;
        } else if (drawable instanceof LayerDrawable) {
            return m6005a((LayerDrawable) drawable, (LayerDrawable) drawable2);
        } else {
            if (drawable.getConstantState() != drawable2.getConstantState()) {
                return false;
            }
            return true;
        }
    }

    private static boolean m6005a(LayerDrawable layerDrawable, LayerDrawable layerDrawable2) {
        if (!f5608g) {
            return false;
        }
        try {
            Object[] objArr = (Object[]) f5603b.get(f5602a.get(layerDrawable));
            Object[] objArr2 = (Object[]) f5603b.get(f5602a.get(layerDrawable2));
            if (objArr == null || objArr2 == null) {
                return false;
            }
            if (layerDrawable.getNumberOfLayers() != layerDrawable2.getNumberOfLayers()) {
                return false;
            }
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            int i = 0;
            while (i < numberOfLayers) {
                if (!m6004a(layerDrawable.getDrawable(i), layerDrawable2.getDrawable(i))) {
                    return false;
                }
                try {
                    if (!m6006a(objArr[i], objArr2[i])) {
                        return false;
                    }
                    i++;
                } catch (IllegalAccessException e) {
                    return false;
                }
            }
            return true;
        } catch (IllegalAccessException e2) {
            return false;
        }
    }

    private static boolean m6006a(Object obj, Object obj2) {
        if (f5604c.getInt(obj) == f5604c.getInt(obj2) && f5605d.getInt(obj) == f5605d.getInt(obj2) && f5606e.getInt(obj) == f5606e.getInt(obj2) && f5607f.getInt(obj) == f5607f.getInt(obj2)) {
            return true;
        }
        return false;
    }
}
