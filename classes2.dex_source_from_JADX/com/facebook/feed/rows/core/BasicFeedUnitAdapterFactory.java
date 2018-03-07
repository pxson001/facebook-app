package com.facebook.feed.rows.core;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.feed.rows.core.analytics.MultiRowPerfLogger;
import com.facebook.inject.Lazy;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.MultiRowGroupPartDefinition;
import com.facebook.widget.viewdiagnostics.DiagnosticsRunner;
import javax.annotation.Nullable;

/* compiled from: nearby_friends_cold_nux_location_disabled */
public class BasicFeedUnitAdapterFactory<P, E extends AnyEnvironment> implements FeedUnitAdapterFactory<P, E> {
    private final AbstractFbErrorReporter f12928a;
    private final DiagnosticsRunner f12929b;
    private final DefaultAndroidThreadUtil f12930c;
    private final MultipleRowsStoriesRecycleCallback f12931d;
    private final MultiRowPerfLogger f12932e;
    private final Lazy<? extends MultiRowGroupPartDefinition<?, ?, ? super E>> f12933f;
    private final boolean f12934g;
    private final boolean f12935h;

    public BasicFeedUnitAdapterFactory(FbErrorReporter fbErrorReporter, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, DiagnosticsRunner diagnosticsRunner, AndroidThreadUtil androidThreadUtil, MultiRowPerfLogger multiRowPerfLogger, Lazy<? extends MultiRowGroupPartDefinition<?, ?, ? super E>> lazy, boolean z, boolean z2) {
        this.f12928a = fbErrorReporter;
        this.f12929b = diagnosticsRunner;
        this.f12930c = androidThreadUtil;
        this.f12931d = multipleRowsStoriesRecycleCallback;
        this.f12932e = multiRowPerfLogger;
        this.f12933f = lazy;
        this.f12934g = z;
        this.f12935h = z2;
    }

    public final FeedUnitAdapter<P, E> mo2518a(@Nullable P p, E e) {
        return new FeedUnitAdapter(p, e, (MultiRowGroupPartDefinition) this.f12933f.get(), this.f12928a, this.f12929b, this.f12930c, this.f12931d, this.f12932e, this.f12934g, this.f12935h);
    }
}
