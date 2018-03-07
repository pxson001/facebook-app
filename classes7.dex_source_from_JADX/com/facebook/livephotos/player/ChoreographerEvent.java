package com.facebook.livephotos.player;

/* compiled from: only_display_status */
public abstract class ChoreographerEvent {
    public final long f7743a;
    public final long f7744b;
    public final int f7745c;

    abstract void mo443a(TrackContext trackContext, long j);

    public ChoreographerEvent(long j, long j2, int i) {
        this.f7745c = i;
        this.f7743a = j;
        this.f7744b = j2;
    }
}
