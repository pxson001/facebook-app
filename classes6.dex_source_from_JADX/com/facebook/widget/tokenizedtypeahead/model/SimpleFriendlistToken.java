package com.facebook.widget.tokenizedtypeahead.model;

import com.facebook.widget.tokenizedtypeahead.model.BaseToken.Type;
import com.google.common.base.Objects;

/* compiled from: com.facebook.platform.status.ERROR_DESCRIPTION */
public class SimpleFriendlistToken extends BaseToken<String> {
    public String f20117e;
    private final int f20118f;
    private final int f20119g;
    private final int f20120h;
    private final int f20121i;
    private String f20122j;

    public SimpleFriendlistToken(String str, int i, int i2, int i3, int i4, String str2) {
        super(Type.FRIENDLIST);
        this.f20117e = str;
        this.f20118f = i;
        this.f20119g = i2;
        this.f20120h = i3;
        this.f20121i = i4;
        this.f20122j = str2;
    }

    public final String m28768c() {
        return this.f20117e;
    }

    public final /* synthetic */ Object mo1186d() {
        return this.f20117e;
    }

    public final String mo1185b() {
        return this.f20122j;
    }

    public final int mo1187e() {
        return this.f20118f;
    }

    public final int mo1188f() {
        return this.f20120h;
    }

    public final int mo1189g() {
        return this.f20121i;
    }

    public final int mo1190h() {
        return this.f20119g;
    }

    public final String mo1191i() {
        return null;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f20117e});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SimpleFriendlistToken) {
            return Objects.equal(this.f20117e, ((SimpleFriendlistToken) obj).f20117e);
        }
        return false;
    }
}
