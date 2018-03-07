package com.fasterxml.jackson.core;

import com.facebook.proxygen.HTTPTransportCallback;

/* compiled from: request_call_path */
public abstract class JsonStreamContext {
    protected int f7354a;
    protected int f7355b;

    public abstract JsonStreamContext mo1659a();

    public abstract String mo1660h();

    protected JsonStreamContext() {
    }

    public final boolean m11958b() {
        return this.f7354a == 1;
    }

    public final boolean m11959c() {
        return this.f7354a == 0;
    }

    public final boolean m11960d() {
        return this.f7354a == 2;
    }

    public final String m11961e() {
        switch (this.f7354a) {
            case 0:
                return "ROOT";
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return "ARRAY";
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return "OBJECT";
            default:
                return "?";
        }
    }

    public final int m11962f() {
        return this.f7355b + 1;
    }

    public final int m11963g() {
        return this.f7355b < 0 ? 0 : this.f7355b;
    }
}
