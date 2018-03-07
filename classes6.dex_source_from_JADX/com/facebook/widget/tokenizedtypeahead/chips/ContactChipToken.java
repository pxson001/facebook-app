package com.facebook.widget.tokenizedtypeahead.chips;

import com.facebook.orca.contacts.picker.UserTokenFactory.2;
import com.facebook.user.model.User;
import com.facebook.widget.tokenizedtypeahead.model.HasUser;
import com.facebook.widget.tokenizedtypeahead.model.Token;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: com.facebook.privacy.checkup.PrivacyCheckupStepFragment */
public class ContactChipToken extends Token<OnContactChipTokenClickedListener> implements HasUser {
    private final User f20110a;
    private boolean f20111e = true;

    public ContactChipToken(User user, boolean z) {
        super(z);
        this.f20110a = user;
    }

    public final boolean mo1195a() {
        return this.f20111e && super.mo1195a();
    }

    public final String mo1185b() {
        return this.f20110a.j();
    }

    public final User mo1523c() {
        return this.f20110a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ContactChipToken) {
            return this.f20110a.T.equals(((ContactChipToken) obj).f20110a.T);
        }
        return false;
    }

    public int hashCode() {
        return this.f20110a.T.hashCode();
    }

    public final void mo1522a(boolean z) {
        if (!z || this.f15076b == null) {
            super.mo1522a(z);
        } else {
            ((2) this.f15076b).a.m28733a((Token) this, false);
        }
    }
}
