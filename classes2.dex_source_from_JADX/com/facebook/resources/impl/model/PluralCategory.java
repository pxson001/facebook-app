package com.facebook.resources.impl.model;

import com.facebook.proxygen.HTTPTransportCallback;
import com.google.common.collect.ImmutableMap;

/* compiled from: validated_phonenumber */
public enum PluralCategory {
    ZERO,
    ONE,
    TWO,
    FEW,
    MANY,
    OTHER;
    
    private static final ImmutableMap<String, PluralCategory> STRING_TO_PLURAL_CATEGORY = null;
    private static final PluralCategory[] map = null;

    static {
        map = new PluralCategory[]{ZERO, ONE, TWO, FEW, MANY, OTHER};
        STRING_TO_PLURAL_CATEGORY = ImmutableMap.builder().m609b("zero", ZERO).m609b("one", ONE).m609b("two", TWO).m609b("few", FEW).m609b("many", MANY).m609b("other", OTHER).m610b();
    }

    public static PluralCategory fromFakeText(CharSequence charSequence) {
        int charAt = charSequence.charAt(0) - 48;
        if (charAt >= 0 && charAt < map.length) {
            return map[charAt];
        }
        throw new RuntimeException("Requesting a PluralCategory that does not exists");
    }

    public static PluralCategory of(String str) {
        if (STRING_TO_PLURAL_CATEGORY.containsKey(str)) {
            return (PluralCategory) STRING_TO_PLURAL_CATEGORY.get(str);
        }
        throw new RuntimeException("No plural category for " + str);
    }

    public static PluralCategory of(int i) {
        switch (i) {
            case 0:
                return ZERO;
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return ONE;
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return TWO;
            case 3:
                return FEW;
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return MANY;
            case 5:
                return OTHER;
            default:
                throw new RuntimeException("No plural category for code " + i);
        }
    }
}
