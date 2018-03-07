package com.facebook.graphql.cursor.database;

import com.facebook.common.stringformat.StringFormatUtil;
import com.google.common.base.Preconditions;

/* compiled from: mProfileFbid */
public class SortKeyHelper {
    private static long f10979a = 0;

    private static synchronized long m17613b(long j) {
        synchronized (SortKeyHelper.class) {
            if (j > f10979a) {
                f10979a = j;
            } else {
                j = f10979a + 1;
                f10979a = j;
            }
        }
        return j;
    }

    public static void m17612a(String str) {
        try {
            m17613b(Long.parseLong(m17618f(str), 16));
        } catch (Exception e) {
        }
    }

    public static String m17618f(String str) {
        return str.substring(0, 16);
    }

    public static int m17619g(String str) {
        return Integer.parseInt(str.substring(16, 24), 16);
    }

    public static String m17610a(long j) {
        return StringFormatUtil.formatStrLocaleSafe("%016x%08x", Long.valueOf(m17613b(j)), Integer.valueOf(1073741823));
    }

    public static String m17614b(String str) {
        return m17611a(str, 1);
    }

    public static String m17611a(String str, int i) {
        boolean z;
        boolean z2 = true;
        if (str.length() >= 24) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        if (i <= 0) {
            z2 = false;
        }
        Preconditions.checkState(z2);
        return StringFormatUtil.formatStrLocaleSafe("%s%08x", m17618f(str), Integer.valueOf(m17619g(str) - i));
    }

    public static String m17616d(String str) {
        boolean z;
        if (str.length() >= 24) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        return str.substring(0, 24) + "FFFFFFFF";
    }

    public static String m17617e(String str) {
        boolean z;
        if (str.length() >= 24) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        return str.substring(0, 24) + "00000000";
    }

    public static String m17615b(String str, int i) {
        boolean z;
        boolean z2 = true;
        if (str.length() >= 24) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        if (i < 0) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        return StringFormatUtil.formatStrLocaleSafe("%s%08x", str.substring(0, 24), Integer.valueOf(Integer.MAX_VALUE - i));
    }
}
