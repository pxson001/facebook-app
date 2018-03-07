package android.support.v4.text;

import android.os.Build.VERSION;

/* compiled from: profile_pic_medium */
public class ICUCompat {
    public static final ICUCompatImpl f4115a;

    /* compiled from: profile_pic_medium */
    class ICUCompatImplIcs implements ICUCompatImpl {
        ICUCompatImplIcs() {
        }

        public final String mo338a(String str) {
            return ICUCompatIcs.m4661a(str);
        }

        public final String mo339b(String str) {
            return ICUCompatIcs.m4662b(str);
        }
    }

    /* compiled from: profile_pic_medium */
    public interface ICUCompatImpl {
        String mo338a(String str);

        String mo339b(String str);
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f4115a = new ICUCompatImplIcs();
        } else {
            f4115a = new ICUCompatImplBase();
        }
    }
}
