package com.facebook.redspace.fragment.controllercallbacks.controller;

import android.os.Bundle;
import com.facebook.analytics.event.HoneyClientEventFast;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.FragmentCreateDestroyCallbacks;
import com.facebook.controllercallbacks.fragment.OnSaveInstanceStateCallback;
import com.facebook.controllercallbacks.fragment.OnUserVisibleHintCallback;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.redspace.analytics.logger.RedSpaceLogger;
import com.facebook.redspace.analytics.logger.RedSpaceTimeLogger;
import com.facebook.redspace.data.RedSpaceFeedProfileUnreadStoriesHelper;
import com.facebook.redspace.data.RedSpaceWallCollection;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;

/* compiled from: PageReactionHeaderAndFirstCardBatchRequest */
public class RedSpaceWallLoadEventController extends BaseController implements FragmentCreateDestroyCallbacks, OnSaveInstanceStateCallback, OnUserVisibleHintCallback, ResumePauseCallbacks {
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<RedSpaceFeedProfileUnreadStoriesHelper> f12110a = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<RedSpaceTimeLogger> f12111b = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<RedSpaceLogger> f12112c = UltralightRuntime.b;
    public boolean f12113d;
    public long f12114e;
    public int f12115f;
    public RedSpaceWallCollection f12116g;
    private boolean f12117h;

    public static RedSpaceWallLoadEventController m12560b(InjectorLike injectorLike) {
        RedSpaceWallLoadEventController redSpaceWallLoadEventController = new RedSpaceWallLoadEventController();
        com.facebook.inject.Lazy a = IdBasedLazy.a(injectorLike, 10167);
        com.facebook.inject.Lazy a2 = IdBasedLazy.a(injectorLike, 10163);
        com.facebook.inject.Lazy b = IdBasedSingletonScopeProvider.b(injectorLike, 10162);
        redSpaceWallLoadEventController.f12110a = a;
        redSpaceWallLoadEventController.f12111b = a2;
        redSpaceWallLoadEventController.f12112c = b;
        return redSpaceWallLoadEventController;
    }

    public final void m12564b() {
    }

    public final void m12565c() {
    }

    public final void m12566d() {
    }

    public final void m12567f() {
        this.f12114e = ((RedSpaceTimeLogger) this.f12111b.get()).b();
        if (this.f12117h) {
            m12561g();
        }
    }

    public final void m12562a(Bundle bundle) {
        bundle.putInt("bundle_initial_badge_count", this.f12115f);
        bundle.putBoolean("bundle_wall_load_flushed", this.f12113d);
        bundle.putLong("bundle_wall_load_finished", this.f12114e);
    }

    private void m12561g() {
        RedSpaceLogger redSpaceLogger = (RedSpaceLogger) this.f12112c.get();
        int i = this.f12115f;
        int e = this.f12116g.m12349e();
        long j = this.f12114e;
        HoneyClientEventFast a = redSpaceLogger.b.a("wall_load", false);
        if (a.a()) {
            a.a("redspace_performance");
            a.a("elapsed_time_ms", j);
            a.a("badge_count", i);
            a.a("stories_count", e);
            a.b();
        }
        this.f12113d = true;
    }

    public final void m12563a(boolean z) {
        this.f12117h = z;
        if (z && this.f12114e > 0 && !this.f12113d) {
            m12561g();
        }
    }
}
