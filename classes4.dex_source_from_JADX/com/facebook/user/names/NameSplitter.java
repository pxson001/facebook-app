package com.facebook.user.names;

import android.text.TextUtils;
import java.lang.Character.UnicodeBlock;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.StringTokenizer;
import javax.annotation.Nullable;

/* compiled from: receiver_id */
public class NameSplitter {
    private static final String f13233a = Locale.JAPANESE.getLanguage().toLowerCase();
    private static final String f13234b = Locale.KOREAN.getLanguage().toLowerCase();
    private static final String f13235c = Locale.CHINESE.getLanguage().toLowerCase();
    private static final String[] f13236k = new String[]{"강전", "남궁", "독고", "동방", "망절", "사공", "서문", "선우", "소봉", "어금", "장곡", "제갈", "황보"};
    public final HashSet<String> f13237d;
    private final HashSet<String> f13238e;
    private final int f13239f;
    private final HashSet<String> f13240g;
    private final HashSet<String> f13241h;
    public final Locale f13242i;
    private final String f13243j;

    /* compiled from: receiver_id */
    public class Name {
        public String f3716a;
        public String f3717b;
        public String f3718c;
        public String f3719d;
        public String f3720e;
        public int f3721f;
        public String f3722g;
        public String f3723h;
        public String f3724i;
        public int f3725j;

        public String toString() {
            return "[prefix: " + this.f3716a + " given: " + this.f3717b + " middle: " + this.f3718c + " family: " + this.f3719d + " suffix: " + this.f3720e + " ph/given: " + this.f3724i + " ph/middle: " + this.f3723h + " ph/family: " + this.f3722g + "]";
        }
    }

    /* compiled from: receiver_id */
    public class NameTokenizer extends StringTokenizer {
        public final String[] f3761a = new String[10];
        private int f3762b;
        private int f3763c;
        public int f3764d;
        public int f3765e;

        public NameTokenizer(String str) {
            super(str, " .,", true);
            while (hasMoreTokens() && this.f3765e < 10) {
                String nextToken = nextToken();
                if (nextToken.length() <= 0 || nextToken.charAt(0) != ' ') {
                    if (this.f3765e > 0 && nextToken.charAt(0) == '.') {
                        this.f3762b |= 1 << (this.f3765e - 1);
                    } else if (this.f3765e <= 0 || nextToken.charAt(0) != ',') {
                        this.f3761a[this.f3765e] = nextToken;
                        this.f3765e++;
                    } else {
                        this.f3763c |= 1 << (this.f3765e - 1);
                    }
                }
            }
        }
    }

    public NameSplitter(String str, String str2, String str3, String str4, Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        this.f13242i = locale;
        this.f13237d = m14098a(str, this.f13242i);
        this.f13240g = m14098a(str2, this.f13242i);
        this.f13238e = m14098a(str3, this.f13242i);
        this.f13241h = m14098a(str4, this.f13242i);
        this.f13243j = this.f13242i.getLanguage().toLowerCase();
        Iterator it = this.f13238e.iterator();
        int i = 0;
        while (it.hasNext()) {
            int length;
            String str5 = (String) it.next();
            if (str5.length() > i) {
                length = str5.length();
            } else {
                length = i;
            }
            i = length;
        }
        this.f13239f = i;
    }

    private static HashSet<String> m14098a(String str, Locale locale) {
        HashSet<String> hashSet = new HashSet();
        if (str != null) {
            String[] split = str.split(",");
            for (String trim : split) {
                hashSet.add(trim.trim().toUpperCase(locale));
            }
        }
        return hashSet;
    }

    public final String m14106a(Name name, boolean z, boolean z2) {
        String str = z2 ? name.f3716a : null;
        switch (name.f3721f) {
            case 2:
            case 3:
            case 5:
                return m14097a(str, name.f3719d, name.f3718c, name.f3717b, name.f3720e, false, false, false);
            case 4:
                return m14097a(str, name.f3719d, name.f3718c, name.f3717b, name.f3720e, true, false, false);
            default:
                if (z) {
                    return m14097a(str, name.f3717b, name.f3718c, name.f3719d, name.f3720e, true, false, true);
                }
                return m14097a(str, name.f3719d, name.f3717b, name.f3718c, name.f3720e, true, true, true);
        }
    }

    public final String m14105a(Name name) {
        return m14097a(null, name.f3722g, name.f3723h, name.f3724i, null, true, false, false);
    }

    private String m14097a(@Nullable String str, String str2, @Nullable String str3, String str4, @Nullable String str5, boolean z, boolean z2, boolean z3) {
        Object obj;
        String trim = str == null ? null : str.trim();
        String trim2 = str2 == null ? null : str2.trim();
        String trim3 = str3 == null ? null : str3.trim();
        String trim4 = str4 == null ? null : str4.trim();
        String trim5 = str5 == null ? null : str5.trim();
        Object obj2 = !TextUtils.isEmpty(trim) ? 1 : null;
        Object obj3 = !TextUtils.isEmpty(trim2) ? 1 : null;
        Object obj4 = !TextUtils.isEmpty(trim3) ? 1 : null;
        Object obj5 = !TextUtils.isEmpty(trim4) ? 1 : null;
        if (TextUtils.isEmpty(trim5)) {
            obj = null;
        } else {
            obj = 1;
        }
        Object obj6 = 1;
        String str6 = null;
        if (obj2 != null) {
            str6 = trim;
        }
        if (obj3 != null) {
            if (str6 != null) {
                obj6 = null;
            } else {
                str6 = trim2;
            }
        }
        if (obj4 != null) {
            if (str6 != null) {
                obj6 = null;
            } else {
                str6 = trim3;
            }
        }
        if (obj5 != null) {
            if (str6 != null) {
                obj6 = null;
            } else {
                str6 = trim4;
            }
        }
        if (obj != null) {
            if (str6 != null) {
                obj6 = null;
            } else {
                str6 = m14100c(trim5);
            }
        }
        if (obj6 != null) {
            return str6;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (obj2 != null) {
            stringBuilder.append(trim);
        }
        if (obj3 != null) {
            if (obj2 != null) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(trim2);
        }
        if (obj4 != null) {
            if (!(obj2 == null && obj3 == null)) {
                if (z2) {
                    stringBuilder.append(',');
                }
                if (z) {
                    stringBuilder.append(' ');
                }
            }
            stringBuilder.append(trim3);
        }
        if (obj5 != null) {
            if (!(obj2 == null && obj3 == null && obj4 == null) && z) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(trim4);
        }
        if (obj != null) {
            if (!(obj2 == null && obj3 == null && obj4 == null && obj5 == null)) {
                if (z3) {
                    stringBuilder.append(',');
                }
                if (z) {
                    stringBuilder.append(' ');
                }
            }
            stringBuilder.append(m14100c(trim5));
        }
        return stringBuilder.toString();
    }

    private String m14100c(String str) {
        int length = str.length();
        if (length == 0 || str.charAt(length - 1) == '.') {
            return str;
        }
        String str2 = str + '.';
        if (this.f13238e.contains(str2.toUpperCase(this.f13242i))) {
            return str2;
        }
        return str;
    }

    public final int m14103a(int i) {
        if (i == 0) {
            if (f13233a.equals(this.f13243j)) {
                return 4;
            }
            if (f13234b.equals(this.f13243j)) {
                return 5;
            }
            if (f13235c.equals(this.f13243j)) {
                return 3;
            }
            return 1;
        } else if (i != 2) {
            return i;
        } else {
            if (f13233a.equals(this.f13243j)) {
                return 4;
            }
            if (f13234b.equals(this.f13243j)) {
                return 5;
            }
            return 3;
        }
    }

    public final int m14104a(String str) {
        int i = 0;
        if (str == null) {
            return 0;
        }
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int codePointAt = Character.codePointAt(str, i2);
            if (Character.isLetter(codePointAt)) {
                UnicodeBlock of = UnicodeBlock.of(codePointAt);
                if (!m14099a(of)) {
                    Object obj;
                    if (of == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B || of == UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == UnicodeBlock.CJK_RADICALS_SUPPLEMENT || of == UnicodeBlock.CJK_COMPATIBILITY || of == UnicodeBlock.CJK_COMPATIBILITY_FORMS || of == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        return m14096a(str, Character.charCount(codePointAt) + i2);
                    }
                    if (m14102d(of)) {
                        return 4;
                    }
                    if (m14101c(of)) {
                        return 5;
                    }
                }
                i = 1;
            }
            i2 += Character.charCount(codePointAt);
        }
        return i;
    }

    private static int m14096a(String str, int i) {
        int length = str.length();
        while (i < length) {
            int codePointAt = Character.codePointAt(str, i);
            if (Character.isLetter(codePointAt)) {
                UnicodeBlock of = UnicodeBlock.of(codePointAt);
                if (m14102d(of)) {
                    return 4;
                }
                if (m14101c(of)) {
                    return 5;
                }
            }
            i += Character.charCount(codePointAt);
        }
        return 2;
    }

    public static boolean m14099a(UnicodeBlock unicodeBlock) {
        return unicodeBlock == UnicodeBlock.BASIC_LATIN || unicodeBlock == UnicodeBlock.LATIN_1_SUPPLEMENT || unicodeBlock == UnicodeBlock.LATIN_EXTENDED_A || unicodeBlock == UnicodeBlock.LATIN_EXTENDED_B || unicodeBlock == UnicodeBlock.LATIN_EXTENDED_ADDITIONAL;
    }

    public static boolean m14101c(UnicodeBlock unicodeBlock) {
        return unicodeBlock == UnicodeBlock.HANGUL_SYLLABLES || unicodeBlock == UnicodeBlock.HANGUL_JAMO || unicodeBlock == UnicodeBlock.HANGUL_COMPATIBILITY_JAMO;
    }

    public static boolean m14102d(UnicodeBlock unicodeBlock) {
        return unicodeBlock == UnicodeBlock.KATAKANA || unicodeBlock == UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS || unicodeBlock == UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS || unicodeBlock == UnicodeBlock.HIRAGANA;
    }
}
