package com.facebook.presence;

import com.facebook.user.model.UserKey;

/* compiled from: forceFetch */
public class ContactPushableState {
    public final UserKey f11479a;
    public final boolean f11480b;
    public final boolean f11481c;

    public ContactPushableState(UserKey userKey, boolean z, boolean z2) {
        this.f11479a = userKey;
        this.f11480b = z;
        this.f11481c = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ContactPushableState contactPushableState = (ContactPushableState) obj;
        if (this.f11480b != contactPushableState.f11480b) {
            return false;
        }
        if (this.f11479a == null ? contactPushableState.f11479a != null : !this.f11479a.equals(contactPushableState.f11479a)) {
            return false;
        }
        if (this.f11481c != contactPushableState.f11481c) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        int i = 1;
        if (this.f11479a != null) {
            hashCode = this.f11479a.hashCode();
        } else {
            hashCode = 0;
        }
        int i2 = hashCode * 31;
        if (this.f11480b) {
            hashCode = 1;
        } else {
            hashCode = 0;
        }
        hashCode = (hashCode + i2) * 31;
        if (!this.f11481c) {
            i = 0;
        }
        return hashCode + i;
    }
}
