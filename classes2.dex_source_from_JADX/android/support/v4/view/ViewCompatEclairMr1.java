package android.support.v4.view;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Method;

/* compiled from: nux_data */
class ViewCompatEclairMr1 {
    private static Method f11767a;

    ViewCompatEclairMr1() {
    }

    public static void m17021a(ViewGroup viewGroup, boolean z) {
        if (f11767a == null) {
            try {
                f11767a = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
            } catch (Throwable e) {
                Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", e);
            }
            f11767a.setAccessible(true);
        }
        try {
            f11767a.invoke(viewGroup, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e2) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e2);
        } catch (Throwable e22) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e22);
        } catch (Throwable e222) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e222);
        }
    }
}
