package com.facebook.katana.util;

import com.facebook.common.util.StringUtil.StringProcessor;
import java.net.URI;
import java.net.URISyntaxException;

/* compiled from: p2p_initiate_select_card */
public class StringUtils {
    public static StringProcessor f7588a = new C08451();

    /* compiled from: p2p_initiate_select_card */
    final class C08451 implements StringProcessor {
        C08451() {
        }

        public final String m7879a(Object obj) {
            return obj.toString();
        }
    }

    public static String m7880a(String str) {
        String str2 = null;
        if (str != null) {
            try {
                str2 = new URI(str).getPath();
            } catch (URISyntaxException e) {
            }
        }
        return str2;
    }
}
