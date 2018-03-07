package com.facebook.video.engine;

import android.net.Uri;
import com.facebook.common.time.MonotonicClock;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

/* compiled from: composite */
public abstract class ExoPlayerPreparerBase {
    private static final String f18805j = ExoPlayerPreparerBase.class.getSimpleName();
    private static final ImmutableMap<Integer, String> f18806k = new Builder().b(Integer.valueOf(3), "STATE_BUFFERING").b(Integer.valueOf(5), "STATE_ENDED").b(Integer.valueOf(1), "STATE_IDLE").b(Integer.valueOf(2), "STATE_PREPARING").b(Integer.valueOf(4), "STATE_READY").b();
    protected final MonotonicClock f18807a;
    protected final Uri f18808b;
    public int f18809c = 2;
    public int f18810d = 2;
    public String f18811e;
    public String f18812f;
    public int f18813g;
    public int f18814h;
    public long f18815i;
    public boolean f18816l;

    public abstract void mo1424e();

    public ExoPlayerPreparerBase(Uri uri, MonotonicClock monotonicClock) {
        this.f18807a = monotonicClock;
        this.f18808b = uri;
        this.f18815i = monotonicClock.now();
    }

    public static String m27529a(int i) {
        return (String) f18806k.get(Integer.valueOf(i));
    }

    protected final void m27530a(Exception exception) {
        this.f18816l = true;
    }
}
