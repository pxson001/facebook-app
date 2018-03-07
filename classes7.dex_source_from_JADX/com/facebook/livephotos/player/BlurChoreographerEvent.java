package com.facebook.livephotos.player;

/* compiled from: on_demand_content_time_offset */
class BlurChoreographerEvent extends ChoreographerEvent {
    private final boolean f7746d;

    public BlurChoreographerEvent(long j, int i, boolean z) {
        super(j, 0, i);
        this.f7746d = z;
    }

    final void mo443a(TrackContext trackContext, long j) {
        trackContext.f7769c = this.f7746d;
    }
}
