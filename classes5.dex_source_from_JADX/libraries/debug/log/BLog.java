package libraries.debug.log;

import android.annotation.SuppressLint;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"StringFormatUse", "BadMethodUse-android.util.Log.v", "BadMethodUse-android.util.Log.d", "BadMethodUse-android.util.Log.i", "BadMethodUse-android.util.Log.w", "BadMethodUse-android.util.Log.e"})
/* compiled from: broadcast_status */
public class BLog {
    public static FbLog f7686a;
    public static volatile int f7687b = 5;
    private static final List<Object> f7688c = new ArrayList();

    public static void m13851a(String str, String str2, Object obj) {
        if (f7687b <= 4) {
            String format = String.format(str2, new Object[]{obj});
            if (f7687b <= 4 && f7686a == null) {
                Log.i(str, format);
            }
        }
    }

    public static void m13853a(String str, String str2, Object... objArr) {
        if (f7687b <= 5) {
            String format = String.format(str2, objArr);
            if (f7686a == null) {
                Log.w(str, format);
            }
        }
    }

    public static void m13854b(String str, String str2, Object... objArr) {
        if (f7687b <= 6) {
            String format = String.format(str2, objArr);
            if (f7686a == null) {
                Log.e(str, format);
            }
        }
    }

    public static void m13852a(String str, String str2, Throwable th) {
        if (f7687b <= 6 && f7686a == null) {
            Log.e(str, str2, th);
        }
    }
}
