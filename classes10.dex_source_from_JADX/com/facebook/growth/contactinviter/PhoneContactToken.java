package com.facebook.growth.contactinviter;

import com.google.common.base.Objects;
import com.google.common.io.BaseEncoding;

/* compiled from: TERMINATOR */
public class PhoneContactToken implements Comparable<PhoneContactToken> {
    public String f23315a;
    public String f23316b;
    public State f23317c = State.UNINVITED;

    /* compiled from: TERMINATOR */
    public enum State {
        UNINVITED,
        PENDING,
        INVITED
    }

    public int compareTo(Object obj) {
        return this.f23315a.compareToIgnoreCase(((PhoneContactToken) obj).f23315a);
    }

    public PhoneContactToken(String str, String str2) {
        this.f23315a = str;
        this.f23316b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PhoneContactToken phoneContactToken = (PhoneContactToken) obj;
        if (this.f23316b != null) {
            return this.f23316b.equals(phoneContactToken.f23316b);
        }
        if (phoneContactToken.f23316b != null) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(new Object[]{this.f23315a, this.f23316b});
    }

    public final String m24625a() {
        return BaseEncoding.b.a(String.valueOf(hashCode()).getBytes());
    }
}
