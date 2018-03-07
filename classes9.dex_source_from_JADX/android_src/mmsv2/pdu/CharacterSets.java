package android_src.mmsv2.pdu;

import android.support.v4.util.SimpleArrayMap;
import android.util.SparseArray;
import java.io.UnsupportedEncodingException;

/* compiled from: setPagerSwipingEnabled() not supported yet */
public class CharacterSets {
    static final /* synthetic */ boolean f3816a;
    private static final int[] f3817b = new int[]{0, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 17, 18, 38, 39, 40, 106, 113, 114, 2025, 2026, 1000, 1015, 2085};
    private static final String[] f3818c = new String[]{"*", "us-ascii", "iso-8859-1", "iso-8859-2", "iso-8859-3", "iso-8859-4", "iso-8859-5", "iso-8859-6", "iso-8859-7", "iso-8859-8", "iso-8859-9", "shift_JIS", "euc-jp", "euc-kr", "iso-2022-jp", "iso-2022-jp-2", "utf-8", "gbk", "gb18030", "gb2312", "big5", "iso-10646-ucs-2", "utf-16", "hz-gb-2312"};
    private static final SparseArray<String> f3819d = new SparseArray();
    private static final SimpleArrayMap<String, Integer> f3820e = new SimpleArrayMap();

    static {
        boolean z;
        int i = 0;
        if (CharacterSets.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f3816a = z;
        if (f3816a || f3817b.length == f3818c.length) {
            int length = f3817b.length - 1;
            while (i <= length) {
                f3819d.put(f3817b[i], f3818c[i]);
                f3820e.put(f3818c[i], Integer.valueOf(f3817b[i]));
                i++;
            }
            return;
        }
        throw new AssertionError();
    }

    private CharacterSets() {
    }

    public static String m3599a(int i) {
        String str = (String) f3819d.get(i);
        if (str != null) {
            return str;
        }
        throw new UnsupportedEncodingException();
    }

    public static int m3598a(String str) {
        if (str == null) {
            return -1;
        }
        Integer num = (Integer) f3820e.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new UnsupportedEncodingException();
    }
}
