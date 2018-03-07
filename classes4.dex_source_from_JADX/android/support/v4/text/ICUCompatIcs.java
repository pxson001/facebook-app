package android.support.v4.text;

import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: profile_pic_large_size */
class ICUCompatIcs {
    private static Method f4116a;
    private static Method f4117b;

    ICUCompatIcs() {
    }

    static {
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f4116a = cls.getMethod("getScript", new Class[]{String.class});
                f4117b = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        }
    }

    public static String m4661a(String str) {
        try {
            if (f4116a != null) {
                return (String) f4116a.invoke(null, new Object[]{str});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return null;
    }

    public static String m4662b(String str) {
        try {
            if (f4117b != null) {
                return (String) f4117b.invoke(null, new Object[]{str});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return str;
    }
}
