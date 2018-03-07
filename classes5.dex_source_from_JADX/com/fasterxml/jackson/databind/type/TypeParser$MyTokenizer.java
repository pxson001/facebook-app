package com.fasterxml.jackson.databind.type;

import java.util.StringTokenizer;

/* compiled from: can_viewer_make_cover_photo */
public final class TypeParser$MyTokenizer extends StringTokenizer {
    public final String f6223a;
    protected int f6224b;
    protected String f6225c;

    public TypeParser$MyTokenizer(String str) {
        super(str, "<,>", true);
        this.f6223a = str;
    }

    public final boolean hasMoreTokens() {
        return this.f6225c != null || super.hasMoreTokens();
    }

    public final String nextToken() {
        String str;
        if (this.f6225c != null) {
            str = this.f6225c;
            this.f6225c = null;
        } else {
            str = super.nextToken();
        }
        this.f6224b += str.length();
        return str;
    }

    public final void m11757a(String str) {
        this.f6225c = str;
        this.f6224b -= str.length();
    }

    public final String m11756a() {
        return this.f6223a;
    }

    public final String m11758b() {
        return this.f6223a.substring(this.f6224b);
    }
}
