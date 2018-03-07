package com.facebook.common.internalprefhelpers;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.time.Clock;
import com.facebook.config.background.impl.ConfigPrefKeys;
import com.facebook.gk.internal.GkConfigurationComponent;
import com.facebook.gk.internal.GkSessionlessFetcher;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.http.protocol.BatchComponentRunner;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.PrefKey;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: publish_time_millis */
public class GkManualUpdater {
    private static final CallerContext f5978a = CallerContext.a(GkManualUpdater.class);
    private final Clock f5979b;
    private final FbSharedPreferences f5980c;
    private final GkConfigurationComponent f5981d;
    private final GkSessionlessFetcher f5982e;
    private final BatchComponentRunner f5983f;
    private final DefaultAndroidThreadUtil f5984g;
    private final ApiMethodRunnerParams f5985h;

    @Inject
    public GkManualUpdater(Clock clock, FbSharedPreferences fbSharedPreferences, GkConfigurationComponent gkConfigurationComponent, GkSessionlessFetcher gkSessionlessFetcher, BatchComponentRunner batchComponentRunner, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f5979b = clock;
        this.f5980c = fbSharedPreferences;
        this.f5981d = gkConfigurationComponent;
        this.f5982e = gkSessionlessFetcher;
        this.f5983f = batchComponentRunner;
        this.f5984g = defaultAndroidThreadUtil;
        this.f5985h = new ApiMethodRunnerParams();
        this.f5985h.f = RequestPriority.INTERACTIVE;
    }

    public final void m6310a(boolean z) {
        this.f5984g.b();
        this.f5980c.edit().a((PrefKey) ConfigPrefKeys.c.a(this.f5981d.getClass().getName()), this.f5979b.a()).commit();
        this.f5983f.a("manualGkRefresh", f5978a, ImmutableList.of(this.f5981d.c()), this.f5985h);
        if (z && !this.f5982e.a()) {
            throw new RuntimeException("Cannot fetch sessionless gatekeepers: SingleMethodRunner failed");
        }
    }
}
