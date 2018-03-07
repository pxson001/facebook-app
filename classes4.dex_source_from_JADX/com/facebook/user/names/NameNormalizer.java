package com.facebook.user.names;

import com.facebook.common.unicode.UnicodeIterator;
import com.facebook.common.util.Hex;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.google.common.base.Strings;
import java.text.Collator;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: getBucketLabel */
public class NameNormalizer {
    private final Provider<Collator> f11236a;

    public static NameNormalizer m11653b(InjectorLike injectorLike) {
        return new NameNormalizer(IdBasedProvider.a(injectorLike, 4480));
    }

    @Inject
    public NameNormalizer(Provider<Collator> provider) {
        TracerDetour.a("NameNormalizer::_construct", -1769056781);
        try {
            this.f11236a = provider;
        } finally {
            TracerDetour.a(181496225);
        }
    }

    public final String m11655a(String str) {
        return Hex.a(((Collator) this.f11236a.get()).getCollationKey(m11654b(Strings.nullToEmpty(str))).toByteArray(), true);
    }

    private static String m11654b(String str) {
        int[] iArr = new int[str.length()];
        UnicodeIterator unicodeIterator = new UnicodeIterator(str);
        int i = 0;
        while (true) {
            Object obj;
            if (unicodeIterator.f3750a < unicodeIterator.f3751b.length()) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                break;
            }
            int codePointAt = unicodeIterator.f3751b.codePointAt(unicodeIterator.f3750a);
            unicodeIterator.f3750a += Character.charCount(codePointAt);
            int i2 = codePointAt;
            if (Character.isLetterOrDigit(i2)) {
                int i3 = i + 1;
                iArr[i] = i2;
                i = i3;
            }
        }
        if (i != iArr.length) {
            return new String(iArr, 0, i);
        }
        return str;
    }
}
