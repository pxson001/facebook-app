package com.facebook.messaging.notify;

/* compiled from: isPage */
public class AlertDisposition {
    public boolean f12637a;
    public boolean f12638b;
    private long f12639c;
    public boolean f12640d;
    public boolean f12641e;
    public boolean f12642f;
    public boolean f12643g;
    public boolean f12644h;
    private String f12645i;

    public final long m13101a() {
        return this.f12639c;
    }

    public final void m13102a(long j) {
        this.f12639c = j;
    }

    public final void m13106c() {
        this.f12640d = true;
    }

    public final void m13107e() {
        this.f12641e = true;
    }

    public final boolean m13108l() {
        return this.f12640d || this.f12641e || this.f12644h || this.f12643g || this.f12642f;
    }

    public final void m13104a(boolean z) {
        this.f12638b = z;
    }

    public final void m13105b(boolean z) {
        this.f12637a = z;
    }

    public final String m13109o() {
        return this.f12645i;
    }

    public final void m13103a(String str) {
        this.f12645i = str;
    }
}
