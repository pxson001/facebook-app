package com.facebook.composer.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.facebook.analytics.tagging.AnalyticsActivity;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.composer.analytics.ComposerPerformanceLogger;
import com.facebook.composer.ui.underwood.ActionUpTouchInterceptorFrameLayout;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.sequencelogger.Sequence;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.google.common.collect.ImmutableBiMap;
import javax.inject.Inject;

/* compiled from: isTop */
public final class ComposerActivity extends FbFragmentActivity implements AnalyticsActivity {
    private static final String f6013p = ComposerActivity.class.getSimpleName();
    private static boolean f6014s = false;
    private ComposerFragment f6015q;
    public ComposerPerformanceLogger f6016r;

    private static <T extends Context> void m7397a(Class<T> cls, T t) {
        m7398a((Object) t, (Context) t);
    }

    public static void m7398a(Object obj, Context context) {
        ((ComposerActivity) obj).f6016r = ComposerPerformanceLogger.a(FbInjector.get(context));
    }

    @Inject
    private void m7396a(ComposerPerformanceLogger composerPerformanceLogger) {
        this.f6016r = composerPerformanceLogger;
    }

    public final void m7399b(Bundle bundle) {
        long uptimeMillis = SystemClock.uptimeMillis();
        super.b(bundle);
        Class cls = ComposerActivity.class;
        m7398a((Object) this, (Context) this);
        ComposerPerformanceLogger composerPerformanceLogger = this.f6016r;
        boolean z = f6014s;
        Sequence e = composerPerformanceLogger.d.e(ComposerPerformanceLogger.a);
        if (e != null) {
            SequenceLoggerDetour.a(SequenceLoggerDetour.e(SequenceLoggerDetour.a(SequenceLoggerDetour.b(e, "RefHandOff", -2050605516), "ComposerLaunchPhase", null, ImmutableBiMap.b("is_warm_launch", String.valueOf(z)), 1137428080), z ? "warm_launch" : "cold_launch", -1879604689), "ComposerDIPhase", -139406467);
        }
        f6014s = true;
        getWindow().getDecorView().setBackgroundColor(-1);
        setContentView(2130903655);
        if (bundle == null) {
            Intent intent = getIntent();
            Bundle bundle2 = new Bundle();
            bundle2.putAll(intent.getExtras());
            ComposerFragment composerFragment = new ComposerFragment();
            composerFragment.g(bundle2);
            this.f6015q = composerFragment;
            kO_().a().a(2131560487, this.f6015q).b();
        } else {
            this.f6015q = (ComposerFragment) kO_().a(2131560487);
        }
        this.f6015q.cS = (ActionUpTouchInterceptorFrameLayout) a(2131560487);
        this.f6016r.e.a(f6013p, uptimeMillis);
    }

    public final String am_() {
        return "composer";
    }

    public final void onUserInteraction() {
        if (this.f6015q != null) {
            ComposerFragment composerFragment = this.f6015q;
            if (composerFragment.y && composerFragment.am != null) {
                composerFragment.aU.m7630b(ComposerFragment.cn).m7697c().m7689a();
            }
        }
        super.onUserInteraction();
    }

    public final void onBackPressed() {
        if (this.f6015q == null || this.f6015q.ar()) {
            super.onBackPressed();
        }
    }

    protected final void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -135341370);
        ComposerPerformanceLogger composerPerformanceLogger = this.f6016r;
        composerPerformanceLogger.e.c(f6013p);
        super.onStart();
        composerPerformanceLogger = this.f6016r;
        composerPerformanceLogger.e.d(f6013p);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -405013554, a);
    }

    protected final void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 2028115229);
        ComposerPerformanceLogger composerPerformanceLogger = this.f6016r;
        composerPerformanceLogger.e.e(f6013p);
        super.onResume();
        composerPerformanceLogger = this.f6016r;
        composerPerformanceLogger.e.f(f6013p);
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 11284467, a);
    }
}
