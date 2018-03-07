package com.facebook.composer.ui.titlebar;

import com.google.common.base.Objects;
import com.google.common.base.Strings;

/* compiled from: tapped_invite_friend_from_social_context_unit */
public class HarrisonPlusIconType {
    public final Type f2108a;
    public final String f2109b;

    /* compiled from: tapped_invite_friend_from_social_context_unit */
    public enum Type {
        DEFAULT,
        ALBUM,
        GROUP,
        EVENT,
        PROFILE
    }

    public HarrisonPlusIconType(Type type) {
        this(type, "");
    }

    public HarrisonPlusIconType(Type type, String str) {
        this.f2108a = type;
        this.f2109b = str;
    }

    public static HarrisonPlusIconType m2079a(String str) {
        if (Strings.isNullOrEmpty(str)) {
            return new HarrisonPlusIconType(Type.DEFAULT);
        }
        return new HarrisonPlusIconType(Type.PROFILE, str);
    }

    public static HarrisonPlusIconType m2080c() {
        return new HarrisonPlusIconType(Type.DEFAULT);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HarrisonPlusIconType)) {
            return false;
        }
        HarrisonPlusIconType harrisonPlusIconType = (HarrisonPlusIconType) obj;
        if (this.f2108a == harrisonPlusIconType.f2108a && Objects.equal(this.f2109b, harrisonPlusIconType.f2109b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f2108a, this.f2109b});
    }
}
