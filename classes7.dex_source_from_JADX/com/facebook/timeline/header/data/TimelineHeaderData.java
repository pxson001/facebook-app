package com.facebook.timeline.header.data;

import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.timeline.data.NeedsFragmentCleanup;

/* compiled from: fc2cb580c6ebf18fd085d34732460285 */
public abstract class TimelineHeaderData implements NeedsFragmentCleanup {
    private final TimelineContext f14588a;
    private boolean f14589b = false;
    public int f14590c;
    public int f14591d;
    public InitializeState f14592e = InitializeState.UNINITIALIZED;
    public DataFreshnessResult f14593f = DataFreshnessResult.NO_DATA;
    public GetNotifiedState f14594g = GetNotifiedState.NOT_SHOWN;

    /* compiled from: fc2cb580c6ebf18fd085d34732460285 */
    public enum GetNotifiedState {
        NOT_SHOWN,
        ASK,
        GET_NOTIFIED
    }

    /* compiled from: fc2cb580c6ebf18fd085d34732460285 */
    public enum InitializeState {
        UNINITIALIZED,
        PRELIM_DATA,
        FINAL_DATA
    }

    public TimelineHeaderData(TimelineContext timelineContext) {
        this.f14588a = timelineContext;
        this.f14590c = 1;
        this.f14591d = 1;
    }

    public final void m18480d() {
        this.f14592e = InitializeState.FINAL_DATA;
        m18478a(GetNotifiedState.NOT_SHOWN);
        this.f14589b = true;
    }

    public final void m18481g() {
        this.f14592e = InitializeState.UNINITIALIZED;
    }

    public final boolean m18482j() {
        return this.f14592e != InitializeState.FINAL_DATA;
    }

    public final void m18483k() {
        this.f14590c++;
    }

    protected final void m18484l() {
        this.f14591d++;
    }

    public final boolean m18485m() {
        return this.f14589b;
    }

    public final void m18478a(GetNotifiedState getNotifiedState) {
        this.f14594g = getNotifiedState;
        m18483k();
    }

    public final void mo1149c() {
    }

    public void mo1150p() {
    }
}
