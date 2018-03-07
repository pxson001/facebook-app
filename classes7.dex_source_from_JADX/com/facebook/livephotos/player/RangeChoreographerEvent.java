package com.facebook.livephotos.player;

/* compiled from: on_demand_content_time_offset */
abstract class RangeChoreographerEvent extends ChoreographerEvent {
    private final float f7750d;
    private final float f7751e;

    abstract void mo444a(TrackContext trackContext, float f);

    public RangeChoreographerEvent(long j, long j2, int i, float f, float f2) {
        super(j, j2, i);
        this.f7750d = f;
        this.f7751e = f2;
    }

    private static float m9373a(long j, float f, float f2, long j2, long j3) {
        float f3 = (float) (j - j2);
        if (f3 > ((float) j3)) {
            f3 = (float) j3;
        }
        return ((f3 / ((float) j3)) * (f2 - f)) + f;
    }

    final void mo443a(TrackContext trackContext, long j) {
        mo444a(trackContext, m9373a(j, this.f7750d, this.f7751e, this.f7743a, this.f7744b));
    }
}
