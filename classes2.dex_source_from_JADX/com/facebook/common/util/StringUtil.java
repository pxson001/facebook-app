package com.facebook.common.util;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import com.google.common.base.Charsets;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: update_merchant_subscription_status */
public class StringUtil {
    private StringUtil() {
    }

    public static boolean m3589a(@Nullable CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean m3591a(CharSequence... charSequenceArr) {
        Preconditions.checkNotNull(charSequenceArr);
        for (CharSequence a : charSequenceArr) {
            if (m3589a(a)) {
                return true;
            }
        }
        return false;
    }

    public static boolean m3590a(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            return str2 == null;
        } else {
            return str.equals(str2);
        }
    }

    public static int m3593b(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            return str2 == null ? 0 : -1;
        } else {
            if (str2 == null) {
                return 1;
            }
            return str.compareTo(str2);
        }
    }

    public static boolean m3600c(String str, String str2) {
        return Objects.equal(Strings.emptyToNull(str), Strings.emptyToNull(str2));
    }

    public static String m3585a(byte[] bArr) {
        try {
            return new String(bArr, Charsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported");
        }
    }

    public static byte[] m3592a(String str) {
        try {
            return str.getBytes(Charsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported");
        }
    }

    public static long m3594b(String str) {
        long j = 1125899906842597L;
        for (int i = 0; i < str.length(); i++) {
            j = (j * 31) + ((long) str.charAt(i));
        }
        return j;
    }

    public static CharSequence m3595b(CharSequence charSequence) {
        int length = charSequence.length();
        while (length > 0 && Character.isWhitespace(charSequence.charAt(length - 1))) {
            length--;
        }
        return length == charSequence.length() ? charSequence : charSequence.subSequence(0, length);
    }

    public static boolean m3599c(@Nullable CharSequence charSequence) {
        if (m3589a(charSequence)) {
            return true;
        }
        for (int i = 0; i < charSequence.length(); i++) {
            if (!Character.isWhitespace(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String m3584a(String str, int i) {
        return (Strings.isNullOrEmpty(str) || i == 0 || str.length() < i) ? str : str.substring(0, i - (Character.charCount(Character.codePointAt(str, i - 1)) - 1));
    }

    public static List<String> m3587a(String str, char c) {
        if (str.length() == 0) {
            return Collections.singletonList("");
        }
        return Lists.m1298a(Splitter.on(c).split(str));
    }

    public static void m3588a(StringBuilder stringBuilder, String str, @Nullable StringProcessor stringProcessor, Object... objArr) {
        Object obj = 1;
        for (Object obj2 : objArr) {
            if (obj != null) {
                obj = null;
            } else {
                stringBuilder.append(str);
            }
            if (obj2 instanceof Collection) {
                m3588a(stringBuilder, str, stringProcessor, ((Collection) obj2).toArray());
            } else if (obj2 instanceof Object[]) {
                m3588a(stringBuilder, str, stringProcessor, (Object[]) obj2);
            } else if (stringProcessor != null) {
                stringBuilder.append(stringProcessor.a(obj2));
            } else {
                stringBuilder.append(obj2.toString());
            }
        }
    }

    public static String m3597b(String str, Object... objArr) {
        StringBuilder stringBuilder = new StringBuilder();
        m3588a(stringBuilder, str, null, objArr);
        return stringBuilder.toString();
    }

    public static CharSequence m3582a(CharSequence charSequence, List<CharSequence> list) {
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        Object obj = 1;
        for (CharSequence charSequence2 : list) {
            if (obj != null) {
                obj = null;
            } else {
                spannableStringBuilder.append(charSequence);
            }
            spannableStringBuilder.append(charSequence2);
        }
        return spannableStringBuilder;
    }

    public static String m3598c(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(str.length());
        String[] split = str.split("\\s");
        int length = split.length;
        for (int i = 0; i < length; i++) {
            if (split[i].length() != 0) {
                if (i > 0) {
                    stringBuilder.append(" ");
                }
                stringBuilder.append(Character.toUpperCase(split[i].charAt(0))).append(split[i].substring(1));
            }
        }
        return stringBuilder.toString();
    }

    public static StringBuilder m3586a(StringBuilder stringBuilder, String str) {
        stringBuilder.append('\'');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\'' || charAt == '\\') {
                stringBuilder.append('\\');
            }
            stringBuilder.append(charAt);
        }
        stringBuilder.append('\'');
        return stringBuilder;
    }

    public static String m3583a(Bundle bundle, String str) {
        Object obj = bundle.get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static String m3601e(String str) {
        if (str == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '&') {
                stringBuilder.append("&amp;");
            } else if (charAt < ' ' || charAt > '~') {
                stringBuilder.append("&#");
                stringBuilder.append(Integer.toString(charAt));
                stringBuilder.append(";");
            } else {
                stringBuilder.append(charAt);
            }
        }
        return stringBuilder.toString();
    }

    public static String m3596b(String str, int i) {
        return str.substring(str.length() - i, str.length());
    }
}
