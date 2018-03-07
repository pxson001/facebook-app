package com.facebook.common.media;

import android.webkit.MimeTypeMap;
import com.facebook.common.internal.ImmutableMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: album */
public class MediaUtils {
    public static final Map<String, String> f11099a = ImmutableMap.a("mkv", "video/x-matroska");

    public static boolean m19094a(@Nullable String str) {
        return str != null && str.startsWith("image/");
    }

    public static boolean m19095b(@Nullable String str) {
        return str != null && str.startsWith("video/");
    }

    @Nullable
    public static String m19096c(String str) {
        String str2;
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0 || lastIndexOf == str.length() - 1) {
            str2 = null;
        } else {
            str2 = str.substring(lastIndexOf + 1);
        }
        String str3 = str2;
        if (str3 == null) {
            return null;
        }
        String toLowerCase = str3.toLowerCase(Locale.US);
        str3 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(toLowerCase);
        if (str3 == null) {
            return (String) f11099a.get(toLowerCase);
        }
        return str3;
    }
}
