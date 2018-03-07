package com.google.common.base;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
/* compiled from: can_invite_to_campaign */
public final class Defaults {
    public static final Map<Class<?>, Object> DEFAULTS;

    private Defaults() {
    }

    static {
        Map hashMap = new HashMap();
        hashMap.put(Boolean.TYPE, Boolean.valueOf(false));
        hashMap.put(Character.TYPE, Character.valueOf('\u0000'));
        hashMap.put(Byte.TYPE, Byte.valueOf((byte) 0));
        hashMap.put(Short.TYPE, Short.valueOf((short) 0));
        hashMap.put(Integer.TYPE, Integer.valueOf(0));
        hashMap.put(Long.TYPE, Long.valueOf(0));
        hashMap.put(Float.TYPE, Float.valueOf(0.0f));
        hashMap.put(Double.TYPE, Double.valueOf(0.0d));
        DEFAULTS = Collections.unmodifiableMap(hashMap);
    }
}
