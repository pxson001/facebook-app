package com.facebook.ipc.composer.model;

import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StringLocaleUtil;

/* compiled from: default_members */
public enum TargetType {
    OTHER("other"),
    UNDIRECTED("feed"),
    USER("wall"),
    GROUP("group"),
    EVENT("event"),
    PAGE("page"),
    FRIENDLIST("friendlist"),
    PAGE_RECOMMENDATION("recommendation"),
    MARKETPLACE("marketplace");
    
    public final String analyticsName;

    /* compiled from: default_members */
    /* synthetic */ class C13411 {
        static final /* synthetic */ int[] f14034a = null;

        static {
            f14034a = new int[TargetType.values().length];
            try {
                f14034a[TargetType.EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f14034a[TargetType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f14034a[TargetType.PAGE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private TargetType(String str) {
        this.analyticsName = str;
    }

    public final String toString() {
        return this.analyticsName;
    }

    public static TargetType fromString(String str) {
        String a = StringLocaleUtil.a(str);
        for (TargetType targetType : values()) {
            if (targetType.analyticsName.equals(a)) {
                return targetType;
            }
        }
        throw new IllegalArgumentException(StringFormatUtil.formatStrLocaleSafe("Unknown TargetType value: '%s'", a));
    }

    public static TargetType fromString(String str, TargetType targetType) {
        try {
            targetType = fromString(str);
        } catch (IllegalArgumentException e) {
        }
        return targetType;
    }

    public static int convertToObjectType(TargetType targetType) {
        switch (C13411.f14034a[targetType.ordinal()]) {
            case 1:
                return 67338874;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                return 69076575;
            case 3:
                return 2479791;
            default:
                return 2645995;
        }
    }
}
