package android_src.mmsv2.util;

import android_src.provider.Telephony.Mms;
import java.util.HashMap;

/* compiled from: sent_timestamp_ms */
public class MessageUtils {
    private static final char[] f3889a = new char[]{'-', '.', ',', '(', ')', ' ', '/', '\\', '*', '#', '+'};
    public static HashMap f3890b = new HashMap(f3889a.length);

    static {
        for (int i = 0; i < f3889a.length; i++) {
            f3890b.put(Character.valueOf(f3889a[i]), Character.valueOf(f3889a[i]));
        }
    }

    public static String m3744a(String str) {
        if (Mms.b(str)) {
            return str;
        }
        String str2;
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '+' && stringBuilder.length() == 0) {
                stringBuilder.append(charAt);
            } else if (Character.isDigit(charAt)) {
                stringBuilder.append(charAt);
            } else if (f3890b.get(Character.valueOf(charAt)) == null) {
                str2 = null;
                break;
            }
        }
        str2 = stringBuilder.toString();
        str = str2;
        return str == null ? null : str;
    }
}
