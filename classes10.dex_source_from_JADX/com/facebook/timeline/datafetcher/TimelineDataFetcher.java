package com.facebook.timeline.datafetcher;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.time.Clock;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.connection.ConnectionTailLoaderManager;
import com.facebook.graphql.connection.ConnectionTailLoaderManager.Callbacks;
import com.facebook.graphql.connection.ConnectionTailLoaderManagerProvider;
import com.facebook.graphql.cursor.LocalModelCursorLoaderManager;
import com.facebook.graphql.cursor.LocalModelCursorLoaderManagerProvider;
import com.facebook.graphql.cursor.ModelCursor;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import com.facebook.timeline.BaseTimelineFragment;
import com.facebook.timeline.TimelineFragment;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.cursor.TimelineAllSectionsCursor;
import com.facebook.timeline.cursor.TimelineCursorHelper;
import com.facebook.timeline.cursor.TimelineSelfFirstUnitsBatchConfigurationProvider;
import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryExecutor.FirstUnitsObservables;
import com.facebook.timeline.datafetcher.TimelineStoriesDataFetcher.ViewCallback;
import com.facebook.timeline.datafetcher.section.TimelineSectionFetchParams;
import com.facebook.timeline.logging.TimelinePerformanceLogger;
import com.facebook.timeline.logging.TimelinePerformanceLogger.1;
import com.facebook.timeline.logging.TimelinePerformanceLogger.UnitsFetchTrigger;
import com.facebook.timeline.profileprotocol.FetchTimelineFirstUnitsParams;
import com.facebook.timeline.profileprotocol.FetchTimelineFirstUnitsParams.QueryType;
import com.facebook.timeline.protiles.model.TimelinePromptData;
import com.facebook.timeline.protocol.ResultSource;
import com.facebook.timeline.taggedmediaset.TimelineTaggedMediaSetData;
import com.facebook.timeline.units.model.TimelineAllSectionsData;
import com.google.common.base.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: groupInformation or url is null in startSharingIntent */
public class TimelineDataFetcher implements ViewCallback {
    public final TimelineFragment f10430a;
    private final TimelineUserContext f10431b;
    private final QueryType f10432c;
    private final TimelineAllSectionsData f10433d;
    @Nullable
    private final TimelineTaggedMediaSetData f10434e;
    @Nullable
    private final TimelinePromptData f10435f;
    @Nullable
    private final TimelinePerformanceLogger f10436g;
    @Nullable
    private final CallerContext f10437h;
    private final Context f10438i;
    private final TimelineHeaderDataFetcherProvider f10439j;
    private final TimelineStoriesDataFetcherProvider f10440k;
    private final QeAccessor f10441l;
    private final Provider<Clock> f10442m;
    private TimelineHeaderDataFetcher f10443n;
    private TimelineStoriesDataFetcher f10444o;
    private boolean f10445p = false;
    public final TimelineAllSectionsCursor f10446q;
    private final TimelineCursorHelper f10447r;
    private final ConnectionTailLoaderManagerProvider f10448s;
    private final TimelineSelfFirstUnitsBatchConfigurationProvider f10449t;
    private ConnectionTailLoaderManager f10450u;
    private final LocalModelCursorLoaderManagerProvider f10451v;
    private LocalModelCursorLoaderManager f10452w;

    /* compiled from: groupInformation or url is null in startSharingIntent */
    public class C15321 {
        final /* synthetic */ TimelineDataFetcher f10426a;

        C15321(TimelineDataFetcher timelineDataFetcher) {
            this.f10426a = timelineDataFetcher;
        }

        public final void m10541a(FirstUnitsObservables firstUnitsObservables) {
            this.f10426a.m10562b().m10719a(firstUnitsObservables, false);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: groupInformation or url is null in startSharingIntent */
    public @interface ReloadSource {
    }

    @Inject
    public TimelineDataFetcher(@Assisted Context context, @Assisted ViewCallback viewCallback, @Assisted TimelineUserContext timelineUserContext, @Assisted QueryType queryType, @Assisted TimelineAllSectionsData timelineAllSectionsData, @Assisted TimelineAllSectionsCursor timelineAllSectionsCursor, @Nullable @Assisted TimelineTaggedMediaSetData timelineTaggedMediaSetData, @Nullable @Assisted TimelinePromptData timelinePromptData, @Nullable @Assisted TimelinePerformanceLogger timelinePerformanceLogger, @Nullable @Assisted CallerContext callerContext, TimelineHeaderDataFetcherProvider timelineHeaderDataFetcherProvider, TimelineStoriesDataFetcherProvider timelineStoriesDataFetcherProvider, QeAccessor qeAccessor, Provider<Clock> provider, TimelineCursorHelper timelineCursorHelper, ConnectionTailLoaderManagerProvider connectionTailLoaderManagerProvider, TimelineSelfFirstUnitsBatchConfigurationProvider timelineSelfFirstUnitsBatchConfigurationProvider, LocalModelCursorLoaderManagerProvider localModelCursorLoaderManagerProvider) {
        this.f10438i = context;
        this.f10447r = timelineCursorHelper;
        this.f10448s = connectionTailLoaderManagerProvider;
        this.f10449t = timelineSelfFirstUnitsBatchConfigurationProvider;
        this.f10430a = (TimelineFragment) Preconditions.checkNotNull(viewCallback);
        this.f10431b = timelineUserContext;
        this.f10432c = queryType;
        this.f10433d = timelineAllSectionsData;
        this.f10446q = timelineAllSectionsCursor;
        this.f10434e = timelineTaggedMediaSetData;
        this.f10435f = timelinePromptData;
        this.f10436g = timelinePerformanceLogger;
        this.f10441l = qeAccessor;
        this.f10442m = provider;
        this.f10437h = callerContext;
        this.f10439j = timelineHeaderDataFetcherProvider;
        this.f10440k = timelineStoriesDataFetcherProvider;
        this.f10451v = localModelCursorLoaderManagerProvider;
    }

    public final TimelineHeaderDataFetcher m10555a() {
        if (this.f10443n == null) {
            this.f10443n = this.f10439j.m10621a(this.f10438i, this, this.f10431b, this.f10436g, this.f10437h);
        }
        return this.f10443n;
    }

    public final TimelineStoriesDataFetcher m10562b() {
        if (this.f10444o == null) {
            this.f10444o = this.f10440k.m10729a(this.f10438i, this, this.f10431b, this.f10432c, this.f10433d, this.f10434e, this.f10435f, this.f10437h);
        }
        return this.f10444o;
    }

    public final void m10565c() {
        m10562b().m10723b();
        m10555a().m10613a();
        if (this.f10452w != null) {
            this.f10452w.close();
            this.f10452w = null;
        }
    }

    public final void m10566e() {
        m10555a().m10617c();
        if (!m10553l()) {
            m10562b().m10725d();
        }
    }

    public final void m10567f() {
        m10554m().b();
    }

    public final void m10556a(int i) {
        m10555a().m10613a();
        m10562b().m10723b();
        m10552b(i);
    }

    private void m10552b(int i) {
        boolean z = true;
        m10555a().m10614a(i);
        if (m10553l()) {
            m10554m().a();
            return;
        }
        TimelineStoriesDataFetcher b = m10562b();
        if (i != 1) {
            z = false;
        }
        b.m10722a(z);
    }

    public final void m10558a(@Nullable FirstUnitsObservables firstUnitsObservables, boolean z) {
        if (this.f10441l.a(ExperimentsForTimelineAbTestModule.B, false) && m10555a().m10619f()) {
            this.f10445p = true;
            return;
        }
        if (m10553l()) {
            m10554m().a();
        } else if (firstUnitsObservables != null) {
            m10562b().m10719a(firstUnitsObservables, z);
        } else {
            m10562b().m10722a(z);
        }
        this.f10445p = false;
    }

    public final void m10563b(@Nullable FirstUnitsObservables firstUnitsObservables, boolean z) {
        if (this.f10445p) {
            if (m10553l()) {
                m10554m().a();
            } else if (firstUnitsObservables != null) {
                m10562b().m10719a(firstUnitsObservables, z);
            } else {
                m10562b().m10722a(z);
            }
            this.f10445p = false;
        }
    }

    public final void m10561a(boolean z) {
        if (z) {
            m10562b().m10728g();
            m10552b(1);
            return;
        }
        m10555a().m10620g();
    }

    public final void mo512g() {
        this.f10430a.aI();
    }

    public final void m10569h() {
        this.f10430a.aL();
    }

    public final void mo508a(TimelineSectionFetchParams timelineSectionFetchParams) {
        TimelinePerformanceLogger timelinePerformanceLogger = this.f10430a.cm;
        UnitsFetchTrigger unitsFetchTrigger = timelineSectionFetchParams.f10698b;
        String str = timelineSectionFetchParams.f10697a;
        if (unitsFetchTrigger != null) {
            switch (1.a[unitsFetchTrigger.ordinal()]) {
                case 1:
                    timelinePerformanceLogger.c.a("TimelineInitialFetchUnits");
                    timelinePerformanceLogger.b.b(1703952);
                    timelinePerformanceLogger.c.a("TimelineFirstUnitsNetworkFetch");
                    timelinePerformanceLogger.g.a("TimelineFirstUnitsNetworkFetch");
                    return;
                case 2:
                    timelinePerformanceLogger.u = true;
                    timelinePerformanceLogger.b.e(1703968, str.hashCode());
                    return;
                case 3:
                    timelinePerformanceLogger.b.e(1703969, str.hashCode());
                    return;
                default:
                    return;
            }
        }
    }

    public final void mo507a(DataFreshnessResult dataFreshnessResult, ResultSource resultSource, long j) {
        this.f10430a.m10301a(dataFreshnessResult, resultSource, j);
    }

    public final void mo509a(TimelineSectionFetchParams timelineSectionFetchParams, DataFreshnessResult dataFreshnessResult, ResultSource resultSource, long j) {
        this.f10430a.m10302a(timelineSectionFetchParams, dataFreshnessResult, j);
    }

    public final void mo511b(TimelineSectionFetchParams timelineSectionFetchParams) {
        this.f10430a.m10308b(timelineSectionFetchParams);
    }

    public final void aC() {
        this.f10430a.aC();
    }

    public final void mo513i() {
        this.f10430a.aM();
    }

    public final void mo514j() {
        this.f10430a.aN();
    }

    public final void mX_() {
        BaseTimelineFragment baseTimelineFragment = this.f10430a;
        if (baseTimelineFragment.bv != null) {
            int q = baseTimelineFragment.bv.q();
            baseTimelineFragment.m10241a(q, (Math.min(baseTimelineFragment.bv.r(), baseTimelineFragment.bv.s() - 1) - q) + 1, baseTimelineFragment.bv.s());
        }
    }

    private boolean m10553l() {
        return this.f10447r.m10502a(this.f10431b);
    }

    private ConnectionTailLoaderManager m10554m() {
        Preconditions.checkState(this.f10447r.m10502a(this.f10431b));
        if (this.f10450u != null) {
            return this.f10450u;
        }
        final long a = ((Clock) this.f10442m.get()).a();
        FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams = new FetchTimelineFirstUnitsParams(this.f10431b.b, (String) this.f10431b.e().orNull(), this.f10431b.d());
        String b = TimelineCursorHelper.m10501b(this.f10431b);
        this.f10450u = this.f10448s.a(b, this.f10449t.m10516a(fetchTimelineFirstUnitsParams, this.f10437h, new C15321(this)), new Callbacks(this) {
            final /* synthetic */ TimelineDataFetcher f10428b;
            private boolean f10429c = false;

            public final void m10542a(ModelCursor modelCursor) {
                if (this.f10428b.f10446q != null) {
                    if (!this.f10429c) {
                        this.f10428b.f10430a.m10301a(DataFreshnessResult.FROM_SERVER, ResultSource.GRAPH_CURSOR_DB, a);
                    }
                    this.f10429c = true;
                    this.f10428b.f10446q.m10499a(modelCursor);
                    this.f10428b.aC();
                }
            }

            public final void m10543a(Throwable th) {
            }

            public final void m10544a(boolean z) {
                if (this.f10428b.f10446q != null) {
                    this.f10428b.f10446q.f10387f = z;
                    this.f10428b.aC();
                }
            }
        }, null);
        this.f10452w = this.f10451v.a(b, this.f10450u);
        this.f10452w.a();
        return this.f10450u;
    }
}
