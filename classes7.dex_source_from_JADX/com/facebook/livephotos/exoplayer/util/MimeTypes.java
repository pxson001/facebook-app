package com.facebook.livephotos.exoplayer.util;

/* compiled from: option_selected_icon */
public final class MimeTypes {
    private MimeTypes() {
    }

    public static boolean m9304a(String str) {
        return m9306c(str).equals("audio");
    }

    public static boolean m9305b(String str) {
        return m9306c(str).equals("video");
    }

    private static String m9306c(String str) {
        int indexOf = str.indexOf(47);
        if (indexOf != -1) {
            return str.substring(0, indexOf);
        }
        throw new IllegalArgumentException("Invalid mime type: " + str);
    }
}
