package com.facebook.pages.identity.cards.actionbar;

/* compiled from: privacy_checkup_write_request_on_exit */
public class PagesActionBarItem {
    public final int f3265a;
    public final int f3266b;
    private final String f3267c;
    public final int f3268d;
    public final int f3269e;
    public final boolean f3270f;
    public final boolean f3271g;
    public final boolean f3272h;
    public int f3273i;

    public PagesActionBarItem(int i, int i2, int i3, int i4, boolean z) {
        this(i, i2, i3, i4, z, false, false);
    }

    public PagesActionBarItem(int i, int i2, int i3, boolean z) {
        this(i, i2, 0, i3, z, false, false);
    }

    public PagesActionBarItem(int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        this.f3265a = i;
        this.f3266b = i2;
        this.f3267c = null;
        this.f3268d = i3;
        this.f3269e = i4;
        this.f3270f = z;
        this.f3271g = z2;
        this.f3272h = z3;
    }

    public final int m4360a() {
        return this.f3265a;
    }

    public final int m4362b() {
        return this.f3266b;
    }

    public final int m4363c() {
        return this.f3268d;
    }

    public final int m4364d() {
        return this.f3269e;
    }

    public final boolean m4365e() {
        return this.f3270f;
    }

    public final boolean m4366f() {
        return this.f3271g;
    }

    public final boolean m4367g() {
        return this.f3272h;
    }

    public final void m4361a(int i) {
        this.f3273i = i;
    }

    public final int m4368h() {
        return this.f3273i == 0 ? this.f3268d : this.f3273i;
    }
}
