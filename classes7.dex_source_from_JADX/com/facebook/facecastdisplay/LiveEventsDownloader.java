package com.facebook.facecastdisplay;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.time.Clock;
import com.facebook.facecastdisplay.LiveEventModel.LiveEventType;
import javax.annotation.Nullable;

/* compiled from: sub_message_color */
public abstract class LiveEventsDownloader {
    protected final Clock f2836a;
    @Nullable
    protected LiveEventsStore f2837b;
    @Nullable
    protected String f2838c;
    protected long f2839d;
    protected boolean f2840e;

    abstract void mo120b();

    abstract boolean mo121c();

    abstract LiveEventType mo122d();

    public LiveEventsDownloader(Clock clock) {
        this.f2836a = clock;
    }

    public synchronized void mo125a(String str) {
        mo120b();
        this.f2838c = str;
        this.f2840e = false;
    }

    public final synchronized long m3140g() {
        return this.f2839d;
    }

    public final synchronized void m3135a(LiveEventsStore liveEventsStore) {
        this.f2837b = liveEventsStore;
    }

    public final synchronized boolean m3141h() {
        return this.f2840e;
    }

    public synchronized void mo119a() {
        Preconditions.a(!mo121c());
        this.f2839d = this.f2836a.a();
    }

    public int hq_() {
        return -1;
    }
}
