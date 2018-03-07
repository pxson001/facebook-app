package com.facebook.feed.rows.core;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.feed.rows.core.analytics.MultiRowPerfLogger;
import com.facebook.feed.rows.qe.RangePreparerExperimentHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.MultiRowGroupPartDefinition;
import com.facebook.widget.viewdiagnostics.DiagnosticsRunner;
import javax.inject.Inject;

/* compiled from: search_events.txt */
public class BasicFeedUnitAdapterFactoryFactory {
    private final AbstractFbErrorReporter f5878a;
    private final DiagnosticsRunner f5879b;
    private final DefaultAndroidThreadUtil f5880c;
    private final MultipleRowsStoriesRecycleCallback f5881d;
    private final boolean f5882e;

    public static BasicFeedUnitAdapterFactoryFactory m10038b(InjectorLike injectorLike) {
        return new BasicFeedUnitAdapterFactoryFactory(FbErrorReporterImpl.m2317a(injectorLike), MultipleRowsStoriesRecycleCallback.m10040a(injectorLike), DiagnosticsRunner.m10045a(injectorLike), DefaultAndroidThreadUtil.m1646b(injectorLike), RangePreparerExperimentHelper.m10049a(injectorLike));
    }

    @Inject
    public BasicFeedUnitAdapterFactoryFactory(AbstractFbErrorReporter abstractFbErrorReporter, MultipleRowsStoriesRecycleCallback multipleRowsStoriesRecycleCallback, DiagnosticsRunner diagnosticsRunner, DefaultAndroidThreadUtil defaultAndroidThreadUtil, RangePreparerExperimentHelper rangePreparerExperimentHelper) {
        this.f5878a = abstractFbErrorReporter;
        this.f5879b = diagnosticsRunner;
        this.f5880c = defaultAndroidThreadUtil;
        this.f5881d = multipleRowsStoriesRecycleCallback;
        this.f5882e = rangePreparerExperimentHelper.m10051a();
    }

    public final <E extends AnyEnvironment> FeedUnitAdapterFactory<?, E> m10039a(Lazy<? extends MultiRowGroupPartDefinition<?, ?, ? super E>> lazy, MultiRowPerfLogger multiRowPerfLogger, boolean z) {
        return new BasicFeedUnitAdapterFactory(this.f5878a, this.f5881d, this.f5879b, this.f5880c, multiRowPerfLogger, lazy, z, this.f5882e);
    }

    public static BasicFeedUnitAdapterFactoryFactory m10037a(InjectorLike injectorLike) {
        return m10038b(injectorLike);
    }
}
