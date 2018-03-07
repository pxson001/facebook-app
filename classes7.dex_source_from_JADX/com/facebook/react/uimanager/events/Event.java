package com.facebook.react.uimanager.events;

/* compiled from: sync_bad_new_message_delta */
public abstract class Event<T extends Event> {
    private static int f11749a = 0;
    private boolean f11750b;
    public int f11751c;
    public long f11752d;
    private int f11753e;

    public abstract void mo737a(RCTEventEmitter rCTEventEmitter);

    public abstract String mo738b();

    protected Event() {
        int i = f11749a;
        f11749a = i + 1;
        this.f11753e = i;
    }

    protected Event(int i, long j) {
        int i2 = f11749a;
        f11749a = i2 + 1;
        this.f11753e = i2;
        m13908a(i, j);
    }

    protected final void m13908a(int i, long j) {
        this.f11751c = i;
        this.f11752d = j;
        this.f11750b = true;
    }

    public final int m13911c() {
        return this.f11751c;
    }

    public T m13906a(T t) {
        return this.f11752d > t.f11752d ? this : t;
    }

    public final long m13912d() {
        return this.f11752d;
    }

    public boolean mo752e() {
        return true;
    }

    public short mo753f() {
        return (short) 0;
    }

    public final int m13915g() {
        return this.f11753e;
    }

    public void mo736a() {
    }

    final boolean m13916h() {
        return this.f11750b;
    }

    final void m13917i() {
        this.f11750b = false;
        mo736a();
    }
}
