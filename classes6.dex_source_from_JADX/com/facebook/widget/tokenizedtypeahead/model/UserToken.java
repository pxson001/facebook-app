package com.facebook.widget.tokenizedtypeahead.model;

import com.facebook.user.model.User;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken.Type;
import com.google.common.base.Objects;

/* compiled from: com.facebook.platform.protocol.PROTOCOL_VERSION */
public class UserToken extends BaseToken<User> implements HasUser {
    public final User f20128e;

    public UserToken(User user) {
        super(Type.USER);
        this.f20128e = user;
    }

    public final String mo1185b() {
        return this.f20128e.k();
    }

    public final int mo1187e() {
        return -1;
    }

    public final int mo1188f() {
        return -1;
    }

    public final int mo1189g() {
        return -1;
    }

    public final int mo1190h() {
        return -1;
    }

    public final String mo1191i() {
        return this.f20128e.x();
    }

    public final /* synthetic */ Object mo1186d() {
        return this.f20128e;
    }

    public final User mo1523c() {
        return this.f20128e;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f20128e.T});
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof UserToken) {
            return this.f20128e.T.equals(((UserToken) obj).f20128e.T);
        }
        return false;
    }
}
