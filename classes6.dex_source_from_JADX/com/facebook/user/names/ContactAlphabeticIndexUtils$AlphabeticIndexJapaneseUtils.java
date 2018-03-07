package com.facebook.user.names;

import com.facebook.user.names.ContactAlphabeticIndexUtils.AlphabeticIndexLocaleUtilsBase;
import java.lang.Character.UnicodeBlock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* compiled from: converted */
public class ContactAlphabeticIndexUtils$AlphabeticIndexJapaneseUtils extends AlphabeticIndexLocaleUtilsBase {
    public static final Set<UnicodeBlock> f18456c;
    private final int f18457b = super.a("日");

    public ContactAlphabeticIndexUtils$AlphabeticIndexJapaneseUtils(Locale locale) {
        super(locale);
    }

    static {
        Set hashSet = new HashSet();
        hashSet.add(UnicodeBlock.HIRAGANA);
        hashSet.add(UnicodeBlock.KATAKANA);
        hashSet.add(UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS);
        hashSet.add(UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS);
        hashSet.add(UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS);
        hashSet.add(UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A);
        hashSet.add(UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B);
        hashSet.add(UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION);
        hashSet.add(UnicodeBlock.CJK_RADICALS_SUPPLEMENT);
        hashSet.add(UnicodeBlock.CJK_COMPATIBILITY);
        hashSet.add(UnicodeBlock.CJK_COMPATIBILITY_FORMS);
        hashSet.add(UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS);
        hashSet.add(UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT);
        f18456c = Collections.unmodifiableSet(hashSet);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int m27076a(java.lang.String r5) {
        /*
        r4 = this;
        r0 = super.a(r5);
        r1 = r4.f18457b;
        if (r0 != r1) goto L_0x001a;
    L_0x0008:
        r1 = 0;
        r1 = java.lang.Character.codePointAt(r5, r1);
        r2 = f18456c;
        r3 = java.lang.Character.UnicodeBlock.of(r1);
        r2 = r2.contains(r3);
        r1 = r2;
        if (r1 == 0) goto L_0x001e;
    L_0x001a:
        r1 = r4.f18457b;
        if (r0 <= r1) goto L_0x0020;
    L_0x001e:
        r0 = r0 + 1;
    L_0x0020:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.user.names.ContactAlphabeticIndexUtils$AlphabeticIndexJapaneseUtils.a(java.lang.String):int");
    }

    public final int m27075a() {
        return super.a() + 1;
    }

    public final String m27077a(int i) {
        if (i == this.f18457b) {
            return "他";
        }
        if (i > this.f18457b) {
            i--;
        }
        return super.a(i);
    }
}
