package com.facebook.video.api.playersession;

import com.facebook.common.callercontext.CallerContext;
import javax.annotation.Nullable;

/* compiled from: oxygen_map_info_window_draw_time */
public abstract class VideoPlayerSessionBase {
    protected SessionState f5638a = SessionState.START;
    protected int f5639b = -1;
    public int f5640c = -1;
    public int f5641d = -1;
    private final CallerContext f5642e;

    /* compiled from: oxygen_map_info_window_draw_time */
    public enum SessionState {
        START,
        STOP,
        PAUSED,
        INSEEK
    }

    public abstract int mo533a();

    public abstract int mo534b();

    public abstract boolean mo535c();

    protected VideoPlayerSessionBase(@Nullable CallerContext callerContext) {
        this.f5642e = callerContext;
    }

    public final synchronized SessionState m6164d() {
        return this.f5638a;
    }

    @Nullable
    public final CallerContext m6165e() {
        return this.f5642e;
    }

    public final int m6166f() {
        return this.f5640c;
    }

    public final void m6160a(int i) {
        this.f5640c = i;
    }

    public final int m6167g() {
        return this.f5641d;
    }

    public final void m6162b(int i) {
        this.f5641d = i;
    }
}
