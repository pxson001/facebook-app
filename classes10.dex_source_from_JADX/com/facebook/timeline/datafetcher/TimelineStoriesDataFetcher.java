package com.facebook.timeline.datafetcher;

import android.content.Context;
import com.facebook.analytics.InteractionLogger;
import com.facebook.api.feed.DeleteStoryMethod.Params;
import com.facebook.api.feed.DeleteStoryMethod.Params.DeleteMode;
import com.facebook.api.feedcache.memory.pendingstory.PendingStoryCache;
import com.facebook.api.graphql.feed.StoryMutationModels.HideableStoryMutationFieldsModel;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.MonotonicClock;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.feed.ui.feedprefetch.VideoPrefetchVisitorProvider;
import com.facebook.friends.model.FetchPeopleYouMayKnowResult;
import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.ObservableThreadUtil;
import com.facebook.graphql.executor.RequestObservable;
import com.facebook.graphql.executor.RequestObserver;
import com.facebook.graphql.executor.RequestSubscription;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLTimelineSection;
import com.facebook.graphql.model.GraphQLTimelineSectionUnitsEdge;
import com.facebook.graphql.model.GraphQLTimelineSectionsConnection;
import com.facebook.graphql.model.GraphQLUnseenStoriesConnection;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.inject.Assisted;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.data.TimelineDataSource;
import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryExecutor.FirstUnitsObservables;
import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryExecutor.ProtilesResult;
import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryExecutor.TimelineFirstUnits;
import com.facebook.timeline.datafetcher.TimelineGenericDataFetcher.State;
import com.facebook.timeline.datafetcher.section.TimelineSectionFetchParams;
import com.facebook.timeline.datafetcher.section.TimelineSectionFetchParamsHelper;
import com.facebook.timeline.logging.TimelinePerformanceLogger;
import com.facebook.timeline.profileprotocol.FetchTimelineFirstUnitsParams;
import com.facebook.timeline.profileprotocol.FetchTimelineFirstUnitsParams.QueryType;
import com.facebook.timeline.protiles.model.ProtileModel;
import com.facebook.timeline.protiles.model.ProtilesData;
import com.facebook.timeline.protiles.model.ProtilesLoadingData.ProtilesLoadState;
import com.facebook.timeline.protiles.model.TimelinePromptData;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.ProtileSectionFieldsModel;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.TimelineProtilesQueryModel;
import com.facebook.timeline.protocol.ResultSource;
import com.facebook.timeline.pymk.PeopleYouMayKnowData;
import com.facebook.timeline.pymk.PeopleYouMayKnowModel;
import com.facebook.timeline.stories.TimelineInfiniteScrollController;
import com.facebook.timeline.taggedmediaset.TimelineTaggedMediaSetData;
import com.facebook.timeline.units.model.TimelineAllSectionsData;
import com.facebook.timeline.units.model.TimelineFeedStoryLinkifyUtil;
import com.facebook.timeline.units.model.TimelineFilterHandler;
import com.facebook.timeline.units.model.TimelineSectionData;
import com.facebook.timeline.units.model.TimelineSectionData.SectionType;
import com.facebook.timeline.units.model.TimelineSectionLoadState;
import com.facebook.timeline.viewfeaturedcontainers.data.FeaturedContainersHeaderData;
import com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel;
import com.facebook.video.server.prefetcher.VideoPrefetchLocation;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: groupInformation or groupId is null in viewPhotos */
public class TimelineStoriesDataFetcher {
    private long f10630A;
    public final TimelineViewCallbackUtil f10631B;
    private final List<RequestSubscription> f10632C = Lists.a();
    private TimelineGenericDataFetcher f10633a;
    public final ViewCallback f10634b;
    public final TimelineContext f10635c;
    private final TimelineGenericDataFetcherProvider f10636d;
    public final TimelinePerformanceLogger f10637e;
    private final QueryType f10638f;
    public final TimelineAllSectionsData f10639g;
    public final ProtilesData f10640h;
    public final FeaturedContainersHeaderData f10641i;
    public final PeopleYouMayKnowData f10642j;
    @Nullable
    private final TimelineTaggedMediaSetData f10643k;
    private final TimelinePromptData f10644l;
    private final Context f10645m;
    public FirstUnitsObservables f10646n;
    private final Provider<TimelineSelfFirstUnitsQueryExecutor> f10647o;
    private final Provider<TimelineNonSelfFirstUnitsQueryExecutor> f10648p;
    private final Provider<PageFirstUnitsQueryExecutor> f10649q;
    private final Provider<TimelineSectionQueryExecutor> f10650r;
    private final ObservableThreadUtil f10651s;
    public final TimelineFilterHandler f10652t;
    private final TimelineFeedStoryLinkifyUtil f10653u;
    private final InteractionLogger f10654v;
    private final CallerContext f10655w;
    private final GraphQLCacheManager f10656x;
    private final Clock f10657y;
    public final AbstractFbErrorReporter f10658z;

    /* compiled from: groupInformation or groupId is null in viewPhotos */
    public interface ViewCallback {
        void mo507a(DataFreshnessResult dataFreshnessResult, ResultSource resultSource, long j);

        void mo508a(TimelineSectionFetchParams timelineSectionFetchParams);

        void mo509a(TimelineSectionFetchParams timelineSectionFetchParams, DataFreshnessResult dataFreshnessResult, ResultSource resultSource, long j);

        void aC();

        void mo511b(TimelineSectionFetchParams timelineSectionFetchParams);

        void mo512g();

        void mo513i();

        void mo514j();

        void mX_();
    }

    /* compiled from: groupInformation or groupId is null in viewPhotos */
    class C15493 implements RequestObserver<ProtilesResult> {
        final /* synthetic */ TimelineStoriesDataFetcher f10622a;

        C15493(TimelineStoriesDataFetcher timelineStoriesDataFetcher) {
            this.f10622a = timelineStoriesDataFetcher;
        }

        public final void m10693a(Object obj) {
            ProtilesResult protilesResult = (ProtilesResult) obj;
            ProtilesData protilesData = this.f10622a.f10640h;
            String valueOf = String.valueOf(this.f10622a.f10635c.b);
            TimelineProtilesQueryModel timelineProtilesQueryModel = protilesResult.f10494a;
            if (!(timelineProtilesQueryModel == null || timelineProtilesQueryModel.m12251a() == null)) {
                Builder builder = ImmutableList.builder();
                ImmutableList a = timelineProtilesQueryModel.m12251a().m12226a();
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    ProtileSectionFieldsModel protileSectionFieldsModel = (ProtileSectionFieldsModel) a.get(i);
                    ProtileModel protileModel = new ProtileModel(protileSectionFieldsModel);
                    protileModel.f12105a = valueOf + protileSectionFieldsModel.m12218k().toString();
                    builder.c(protileModel);
                }
                protilesData.f12113a = builder.b();
                protilesData.f12114b.f12119a = ProtilesLoadState.COMPLETED;
            }
            this.f10622a.f10634b.aC();
            this.f10622a.f10637e.a(protilesResult.f10495b);
        }

        public final void m10692a() {
        }

        public final void m10694a(Throwable th) {
            ProtilesData protilesData = this.f10622a.f10640h;
            if (protilesData.f12113a == null) {
                protilesData.f12114b.f12119a = ProtilesLoadState.FAILED;
            }
            this.f10622a.f10634b.aC();
            this.f10622a.f10637e.k();
        }
    }

    /* compiled from: groupInformation or groupId is null in viewPhotos */
    class C15504 implements RequestObserver<GraphQLResult<FeaturedContainersQueryModel>> {
        final /* synthetic */ TimelineStoriesDataFetcher f10623a;

        C15504(TimelineStoriesDataFetcher timelineStoriesDataFetcher) {
            this.f10623a = timelineStoriesDataFetcher;
        }

        public final void m10696a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            FeaturedContainersHeaderData featuredContainersHeaderData = this.f10623a.f10641i;
            FeaturedContainersQueryModel featuredContainersQueryModel = (FeaturedContainersQueryModel) graphQLResult.e;
            featuredContainersHeaderData.f12835a = 3;
            if (!(featuredContainersQueryModel == null || featuredContainersQueryModel.m12862a() == null || featuredContainersQueryModel.m12862a().m12858a() == null)) {
                featuredContainersHeaderData.f12836b = featuredContainersQueryModel.m12862a().m12858a().m12854a();
            }
            featuredContainersHeaderData.f12837c++;
            this.f10623a.f10634b.aC();
        }

        public final void m10695a() {
        }

        public final void m10697a(Throwable th) {
            this.f10623a.f10641i.f12835a = 2;
            this.f10623a.f10634b.aC();
        }
    }

    /* compiled from: groupInformation or groupId is null in viewPhotos */
    class C15526 implements RequestObserver<FetchPeopleYouMayKnowResult> {
        final /* synthetic */ TimelineStoriesDataFetcher f10626a;

        C15526(TimelineStoriesDataFetcher timelineStoriesDataFetcher) {
            this.f10626a = timelineStoriesDataFetcher;
        }

        public final void m10702a(Object obj) {
            FetchPeopleYouMayKnowResult fetchPeopleYouMayKnowResult = (FetchPeopleYouMayKnowResult) obj;
            this.f10626a.f10642j.f12465a = new PeopleYouMayKnowModel(fetchPeopleYouMayKnowResult.a, fetchPeopleYouMayKnowResult.b);
            this.f10626a.f10634b.aC();
        }

        public final void m10701a() {
        }

        public final void m10703a(Throwable th) {
        }
    }

    /* compiled from: groupInformation or groupId is null in viewPhotos */
    public class C15537 implements Function<TimelineFirstUnits, TimelineFirstUnits> {
        final /* synthetic */ TimelineStoriesDataFetcher f10627a;

        public C15537(TimelineStoriesDataFetcher timelineStoriesDataFetcher) {
            this.f10627a = timelineStoriesDataFetcher;
        }

        public Object apply(Object obj) {
            TimelineFirstUnits timelineFirstUnits = (TimelineFirstUnits) obj;
            GraphQLTimelineSectionsConnection graphQLTimelineSectionsConnection = timelineFirstUnits.f10497b;
            GraphQLTimelineSection a = this.f10627a.f10652t.m12734a((GraphQLTimelineSection) graphQLTimelineSectionsConnection.a().get(0));
            GraphQLTimelineSectionsConnection.Builder builder = new GraphQLTimelineSectionsConnection.Builder();
            graphQLTimelineSectionsConnection.h();
            builder.d = graphQLTimelineSectionsConnection.a();
            builder.e = graphQLTimelineSectionsConnection.j();
            BaseModel.Builder.a(builder, graphQLTimelineSectionsConnection);
            GraphQLTimelineSectionsConnection.Builder builder2 = builder;
            builder2.d = ImmutableList.of(a);
            return new TimelineFirstUnits(timelineFirstUnits.f10496a, new GraphQLTimelineSectionsConnection(builder2), timelineFirstUnits.f10498c);
        }
    }

    /* compiled from: groupInformation or groupId is null in viewPhotos */
    public class C15548 implements Function<TimelineFirstUnits, TimelineFirstUnits> {
        final /* synthetic */ TimelineStoriesDataFetcher f10628a;

        public C15548(TimelineStoriesDataFetcher timelineStoriesDataFetcher) {
            this.f10628a = timelineStoriesDataFetcher;
        }

        public Object apply(Object obj) {
            TimelineFirstUnits timelineFirstUnits = (TimelineFirstUnits) obj;
            TimelineFeedStoryLinkifyUtil.m12731a((GraphQLTimelineSection) timelineFirstUnits.f10497b.a().get(0));
            return timelineFirstUnits;
        }
    }

    /* compiled from: groupInformation or groupId is null in viewPhotos */
    public class C15559 implements Function<GraphQLTimelineSection, GraphQLTimelineSection> {
        final /* synthetic */ TimelineStoriesDataFetcher f10629a;

        public C15559(TimelineStoriesDataFetcher timelineStoriesDataFetcher) {
            this.f10629a = timelineStoriesDataFetcher;
        }

        @Nullable
        public Object apply(Object obj) {
            return this.f10629a.f10652t.m12734a((GraphQLTimelineSection) obj);
        }
    }

    @Inject
    public TimelineStoriesDataFetcher(@Assisted Context context, @Assisted ViewCallback viewCallback, @Assisted TimelineContext timelineContext, @Assisted QueryType queryType, @Assisted TimelineAllSectionsData timelineAllSectionsData, @Nullable @Assisted TimelineTaggedMediaSetData timelineTaggedMediaSetData, @Nullable @Assisted TimelinePromptData timelinePromptData, @Nullable @Assisted CallerContext callerContext, ProtilesData protilesData, FeaturedContainersHeaderData featuredContainersHeaderData, PeopleYouMayKnowData peopleYouMayKnowData, TimelineGenericDataFetcherProvider timelineGenericDataFetcherProvider, Provider<TimelineSelfFirstUnitsQueryExecutor> provider, Provider<TimelineNonSelfFirstUnitsQueryExecutor> provider2, Provider<PageFirstUnitsQueryExecutor> provider3, Provider<TimelineSectionQueryExecutor> provider4, ObservableThreadUtil observableThreadUtil, TimelinePerformanceLogger timelinePerformanceLogger, TimelineFilterHandler timelineFilterHandler, TimelineFeedStoryLinkifyUtil timelineFeedStoryLinkifyUtil, InteractionLogger interactionLogger, GraphQLCacheManager graphQLCacheManager, Clock clock, FbErrorReporter fbErrorReporter, VideoPrefetchVisitorProvider videoPrefetchVisitorProvider) {
        this.f10645m = context;
        this.f10636d = timelineGenericDataFetcherProvider;
        this.f10634b = (ViewCallback) Preconditions.checkNotNull(viewCallback);
        this.f10635c = (TimelineContext) Preconditions.checkNotNull(timelineContext);
        this.f10638f = (QueryType) Preconditions.checkNotNull(queryType);
        this.f10639g = (TimelineAllSectionsData) Preconditions.checkNotNull(timelineAllSectionsData);
        this.f10640h = protilesData;
        this.f10641i = featuredContainersHeaderData;
        this.f10642j = peopleYouMayKnowData;
        this.f10643k = timelineTaggedMediaSetData;
        this.f10644l = timelinePromptData;
        this.f10647o = provider;
        this.f10648p = provider2;
        this.f10649q = provider3;
        this.f10650r = provider4;
        this.f10651s = observableThreadUtil;
        this.f10637e = timelinePerformanceLogger;
        this.f10652t = timelineFilterHandler;
        this.f10653u = timelineFeedStoryLinkifyUtil;
        this.f10654v = interactionLogger;
        this.f10655w = callerContext;
        this.f10656x = graphQLCacheManager;
        this.f10657y = clock;
        this.f10658z = fbErrorReporter;
        this.f10631B = new TimelineViewCallbackUtil(this.f10635c, this.f10634b, this.f10639g, fbErrorReporter, videoPrefetchVisitorProvider);
    }

    private TimelineGenericDataFetcher m10716h() {
        if (this.f10633a == null) {
            this.f10633a = this.f10636d.m10601a(this.f10645m, new ProfileViewerContext(this.f10635c.b, this.f10635c.a), this.f10655w);
        }
        return this.f10633a;
    }

    public final void m10723b() {
        m10716h().m10597a();
        for (RequestSubscription a : this.f10632C) {
            a.a();
        }
        this.f10632C.clear();
    }

    public final void m10724c() {
        if (m10716h().f10515j != State.VISIBLE) {
            return;
        }
        if (m10716h().m10600b()) {
            m10716h().m10597a();
            m10716h().f10515j = State.CANCELLED;
            return;
        }
        m10716h().f10515j = State.PAUSED;
    }

    public final void m10725d() {
        if (m10716h().f10515j == State.REFRESH_ON_RESUME) {
            m10726e();
        } else if (m10716h().f10515j == State.CANCELLED) {
            m10722a(false);
        }
        m10716h().f10515j = State.VISIBLE;
    }

    public final void m10717a() {
        m10716h().f10515j = State.REFRESH_ON_RESUME;
    }

    public final void m10726e() {
        m10722a(true);
    }

    private void m10712a(TimelineSectionFetchParams timelineSectionFetchParams, boolean z) {
        this.f10639g.m12719a(timelineSectionFetchParams, TimelineSectionLoadState.LOADING);
        this.f10654v.a(false);
        this.f10634b.aC();
        m10704a((TimelineFirstUnitsQueryExecutor) this.f10647o.get(), z);
    }

    public final void m10720a(TimelineSectionFetchParams timelineSectionFetchParams) {
        this.f10631B.m10741a(timelineSectionFetchParams);
        TimelineSectionFetchParams.Builder a = timelineSectionFetchParams.m10746a();
        a.f10696h = (String) this.f10635c.e().orNull();
        a.m10745b();
        TimelineSectionFetchParams b = a.m10745b();
        m10718a(((TimelineSectionQueryExecutor) this.f10650r.get()).m10666a(b, this.f10655w), b);
    }

    public final void m10718a(@Nullable RequestObservable<GraphQLTimelineSection> requestObservable, @Nullable final TimelineSectionFetchParams timelineSectionFetchParams) {
        if (requestObservable != null && timelineSectionFetchParams != null) {
            final long a = this.f10657y.a();
            this.f10632C.add(this.f10651s.a(requestObservable.a(new C15559(this)).a(new Function<GraphQLTimelineSection, GraphQLTimelineSection>(this) {
                final /* synthetic */ TimelineStoriesDataFetcher f10606a;

                {
                    this.f10606a = r1;
                }

                public Object apply(Object obj) {
                    GraphQLTimelineSection graphQLTimelineSection = (GraphQLTimelineSection) obj;
                    TimelineFeedStoryLinkifyUtil.m12731a(graphQLTimelineSection);
                    return graphQLTimelineSection;
                }
            }), new RequestObserver<GraphQLTimelineSection>(this) {
                final /* synthetic */ TimelineStoriesDataFetcher f10616c;
                private GraphQLTimelineSection f10617d;
                private TimelineSectionFetchParams f10618e = timelineSectionFetchParams;

                public final void m10687a(Object obj) {
                    GraphQLTimelineSection graphQLTimelineSection = (GraphQLTimelineSection) obj;
                    if (this.f10617d != null) {
                        this.f10618e = TimelineStoriesDataFetcher.m10705a(this.f10616c, this.f10618e, this.f10617d);
                    }
                    if (!(this.f10618e == null || Objects.equal(this.f10618e.f10699c, graphQLTimelineSection.j()))) {
                        this.f10616c.f10658z.a("timeline_unexpected_section_id_from_server", StringFormatUtil.formatStrLocaleSafe("Requested more units for section %s; got a GraphQLTimelineSection with ID %s", timelineSectionFetchParams.f10699c, graphQLTimelineSection.j()));
                    }
                    TimelineStoriesDataFetcher.m10714b(this.f10616c, timelineSectionFetchParams, graphQLTimelineSection);
                    this.f10617d = graphQLTimelineSection;
                }

                public final void m10686a() {
                    this.f10616c.m10706a(this.f10617d, this.f10618e, a, DataFreshnessResult.FROM_SERVER, ResultSource.SERVER);
                }

                public final void m10688a(Throwable th) {
                    if (!(th instanceof IllegalArgumentException) || this.f10617d == null) {
                        this.f10616c.f10634b.mo511b(this.f10618e);
                    } else {
                        m10686a();
                    }
                }
            }));
        }
    }

    @Nullable
    public static TimelineSectionFetchParams m10705a(TimelineStoriesDataFetcher timelineStoriesDataFetcher, TimelineSectionFetchParams timelineSectionFetchParams, GraphQLTimelineSection graphQLTimelineSection) {
        if (m10713a(graphQLTimelineSection)) {
            return timelineSectionFetchParams.m10746a().m10742a(graphQLTimelineSection.j()).m10744b(graphQLTimelineSection.l().j().a()).m10745b();
        }
        return null;
    }

    private static boolean m10713a(@Nullable GraphQLTimelineSection graphQLTimelineSection) {
        return (graphQLTimelineSection == null || graphQLTimelineSection.l() == null || graphQLTimelineSection.l().j() == null || graphQLTimelineSection.l().j().a() == null) ? false : true;
    }

    public final void m10722a(boolean z) {
        if (!this.f10635c.i() && this.f10638f == QueryType.USER) {
            m10704a((TimelineFirstUnitsQueryExecutor) this.f10648p.get(), z);
        } else if (this.f10638f == QueryType.PAGE) {
            m10704a((TimelineFirstUnitsQueryExecutor) this.f10649q.get(), z);
        } else {
            m10712a(TimelineSectionFetchParamsHelper.m10749a(z), z);
        }
    }

    private FirstUnitsObservables m10704a(TimelineFirstUnitsQueryExecutor timelineFirstUnitsQueryExecutor, boolean z) {
        this.f10631B.m10741a(TimelineSectionFetchParamsHelper.m10749a(z));
        FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams = new FetchTimelineFirstUnitsParams(this.f10635c.b, (String) this.f10635c.e().orNull(), this.f10635c.d());
        this.f10630A = this.f10657y.a();
        this.f10646n = timelineFirstUnitsQueryExecutor.mo506a(z, fetchTimelineFirstUnitsParams, this.f10655w);
        m10715b(z);
        return this.f10646n;
    }

    public final void m10719a(FirstUnitsObservables firstUnitsObservables, boolean z) {
        this.f10631B.m10741a(TimelineSectionFetchParamsHelper.m10749a(z));
        this.f10646n = firstUnitsObservables;
        m10715b(z);
    }

    private void m10715b(boolean z) {
        if (this.f10646n != null && this.f10646n.f10485a != null) {
            final TimelineSectionFetchParams a = TimelineSectionFetchParamsHelper.m10749a(z);
            m10711a(a, this.f10646n.f10488d, this.f10643k, false);
            m10711a(a, this.f10646n.f10487c, this.f10644l, true);
            m10711a(a, this.f10646n.f10489e, this.f10640h.f12115c, true);
            RequestObservable a2 = this.f10646n.f10485a.a(new C15537(this)).a(new C15548(this));
            final AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.f10632C.add(this.f10651s.a(a2, new RequestObserver<TimelineFirstUnits>(this) {
                final /* synthetic */ TimelineStoriesDataFetcher f10621c;

                public final void m10690a(Object obj) {
                    TimelineFirstUnits timelineFirstUnits = (TimelineFirstUnits) obj;
                    TimelineStoriesDataFetcher.m10709a(this.f10621c, timelineFirstUnits, a, atomicBoolean, this.f10621c.f10646n.f10486b != null);
                    this.f10621c.m10718a(this.f10621c.f10646n.f10486b, TimelineStoriesDataFetcher.m10705a(this.f10621c, a, (GraphQLTimelineSection) timelineFirstUnits.f10497b.a().get(0)));
                }

                public final void m10689a() {
                }

                public final void m10691a(Throwable th) {
                    this.f10621c.f10634b.mo511b(a);
                }
            }));
            if (this.f10646n.f10490f != null) {
                this.f10637e.c.a("ProtilesNetworkFetch");
                ProtilesData protilesData = this.f10640h;
                if (protilesData.f12113a == null) {
                    protilesData.f12114b.f12119a = ProtilesLoadState.LOADING;
                }
                this.f10634b.aC();
                this.f10632C.add(this.f10651s.a(this.f10646n.f10490f, new C15493(this)));
            }
            if (this.f10646n.f10491g != null) {
                this.f10641i.f12835a = 1;
                this.f10634b.aC();
                this.f10651s.a(this.f10646n.f10491g, new C15504(this));
            }
            if (this.f10646n.f10492h != null) {
                this.f10632C.add(this.f10651s.a(this.f10646n.f10492h, new RequestObserver<GraphQLUnseenStoriesConnection>(this) {
                    final /* synthetic */ TimelineStoriesDataFetcher f10625b;

                    public final void m10699a(Object obj) {
                        GraphQLUnseenStoriesConnection graphQLUnseenStoriesConnection = (GraphQLUnseenStoriesConnection) obj;
                        TimelineStoriesDataFetcher timelineStoriesDataFetcher = this.f10625b;
                        TimelineViewCallbackUtil timelineViewCallbackUtil = this.f10625b.f10631B;
                        TimelineSectionLoadState timelineSectionLoadState = atomicBoolean.get() ? TimelineSectionLoadState.COMPLETED : TimelineSectionLoadState.LOADING;
                        TimelineAllSectionsData timelineAllSectionsData = timelineStoriesDataFetcher.f10639g;
                        if (!timelineAllSectionsData.f12765d.isEmpty() && ((TimelineSectionData) timelineAllSectionsData.f12765d.get(0)).f12788a == SectionType.UNSEEN_SECTION) {
                            timelineAllSectionsData.f12765d.remove(0);
                        }
                        timelineViewCallbackUtil.f10682c.m12718a(graphQLUnseenStoriesConnection, timelineSectionLoadState);
                        timelineStoriesDataFetcher.f10639g.m12721a(TimelineSectionLoadState.COMPLETED);
                        timelineStoriesDataFetcher.f10634b.aC();
                    }

                    public final void m10698a() {
                    }

                    public final void m10700a(Throwable th) {
                    }
                }));
            }
            if (this.f10646n.f10493i != null) {
                this.f10632C.add(this.f10651s.a(this.f10646n.f10493i, new C15526(this)));
            }
        }
    }

    public static void m10709a(TimelineStoriesDataFetcher timelineStoriesDataFetcher, TimelineFirstUnits timelineFirstUnits, TimelineSectionFetchParams timelineSectionFetchParams, AtomicBoolean atomicBoolean, boolean z) {
        timelineStoriesDataFetcher.f10639g.m12725a(false);
        timelineStoriesDataFetcher.m10707a(timelineFirstUnits.f10496a);
        timelineStoriesDataFetcher.m10710a(timelineSectionFetchParams, timelineStoriesDataFetcher.f10630A, timelineFirstUnits.f10497b, timelineFirstUnits.f10498c, ResultSource.fromGraphQLResultDataFreshness(timelineFirstUnits.f10498c), z);
        atomicBoolean.set(true);
    }

    private <T> void m10711a(final TimelineSectionFetchParams timelineSectionFetchParams, RequestObservable<T> requestObservable, final TimelineDataSource<T> timelineDataSource, final boolean z) {
        this.f10632C.add(this.f10651s.a(requestObservable, new RequestObserver<T>(this) {
            final /* synthetic */ TimelineStoriesDataFetcher f10610d;

            public final void m10681a() {
            }

            public final void m10683a(Throwable th) {
                this.f10610d.f10634b.mo511b(timelineSectionFetchParams);
            }

            public final void m10682a(T t) {
                timelineDataSource.a(t, 2);
                timelineDataSource.h();
                if (z) {
                    this.f10610d.f10634b.aC();
                }
            }
        }));
    }

    private void m10710a(TimelineSectionFetchParams timelineSectionFetchParams, long j, GraphQLTimelineSectionsConnection graphQLTimelineSectionsConnection, DataFreshnessResult dataFreshnessResult, ResultSource resultSource, boolean z) {
        GraphQLTimelineSection graphQLTimelineSection = (GraphQLTimelineSection) graphQLTimelineSectionsConnection.a().get(0);
        m10714b(this, timelineSectionFetchParams, graphQLTimelineSection);
        this.f10634b.mo507a(dataFreshnessResult, resultSource, j);
        if (z && m10713a(graphQLTimelineSection)) {
            this.f10634b.aC();
        } else {
            m10706a(graphQLTimelineSection, timelineSectionFetchParams, j, dataFreshnessResult, resultSource);
        }
    }

    public static void m10714b(TimelineStoriesDataFetcher timelineStoriesDataFetcher, TimelineSectionFetchParams timelineSectionFetchParams, GraphQLTimelineSection graphQLTimelineSection) {
        timelineStoriesDataFetcher.f10634b.mo513i();
        TimelineViewCallbackUtil timelineViewCallbackUtil = timelineStoriesDataFetcher.f10631B;
        timelineViewCallbackUtil.f10682c.m12719a(timelineSectionFetchParams, TimelineSectionLoadState.COMPLETED);
        timelineViewCallbackUtil.f10682c.m12711a(graphQLTimelineSection);
        if (!(graphQLTimelineSection.l() == null || graphQLTimelineSection.l().a() == null)) {
            ImmutableList a = graphQLTimelineSection.l().a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                FeedUnit j = ((GraphQLTimelineSectionUnitsEdge) a.get(i)).j();
                if (j instanceof GraphQLStory) {
                    if (timelineViewCallbackUtil.f10685f == null) {
                        timelineViewCallbackUtil.f10685f = timelineViewCallbackUtil.f10684e.a(VideoPrefetchLocation.TIMELINE, CallerContext.a(TimelineViewCallbackUtil.class));
                    }
                    timelineViewCallbackUtil.f10685f.a((GraphQLStory) j);
                }
            }
        }
        timelineViewCallbackUtil.f10682c.m12719a(timelineSectionFetchParams, TimelineSectionLoadState.LOADING);
        if (timelineSectionFetchParams.f10703g) {
            timelineViewCallbackUtil.f10682c.m12721a(TimelineSectionLoadState.COMPLETED);
        }
        timelineViewCallbackUtil.f10681b.aC();
        timelineStoriesDataFetcher.f10634b.mo514j();
    }

    private void m10706a(GraphQLTimelineSection graphQLTimelineSection, TimelineSectionFetchParams timelineSectionFetchParams, long j, DataFreshnessResult dataFreshnessResult, ResultSource resultSource) {
        this.f10634b.mo513i();
        this.f10631B.m10740a(graphQLTimelineSection, timelineSectionFetchParams, dataFreshnessResult, resultSource, j);
        this.f10634b.mo514j();
    }

    private void m10707a(GraphQLTimelineSectionsConnection graphQLTimelineSectionsConnection) {
        if (graphQLTimelineSectionsConnection != null) {
            TimelineViewCallbackUtil timelineViewCallbackUtil = this.f10631B;
            TimelineAllSectionsData timelineAllSectionsData = timelineViewCallbackUtil.f10682c;
            boolean a = TimelineInfiniteScrollController.m12681a(timelineViewCallbackUtil.f10680a);
            ImmutableList a2 = graphQLTimelineSectionsConnection.a();
            int size = a2.size();
            int i = 0;
            Object obj = 1;
            while (i < size) {
                PendingStoryCache pendingStoryCache;
                GraphQLTimelineSection graphQLTimelineSection = (GraphQLTimelineSection) a2.get(i);
                String j = graphQLTimelineSection.j();
                String k = graphQLTimelineSection.k();
                SectionType sectionType = obj != null ? SectionType.RECENT_SECTION : SectionType.YEAR_SECTION;
                MonotonicClock monotonicClock = timelineAllSectionsData.f12764c;
                if (obj != null) {
                    pendingStoryCache = timelineAllSectionsData.f12767f;
                } else {
                    pendingStoryCache = null;
                }
                Iterable timelineSectionData = new TimelineSectionData(j, k, sectionType, a, monotonicClock, pendingStoryCache);
                timelineAllSectionsData.f12765d.add(timelineSectionData);
                if (timelineAllSectionsData.f12769h != null) {
                    timelineAllSectionsData.f12769h.m12703a(timelineSectionData);
                }
                i++;
                obj = null;
            }
        }
    }

    public final void m10721a(final String str, final String str2, String str3) {
        Params params = new Params(str, Lists.a(new String[]{str2}), str3, DeleteMode.LOCAL_AND_SERVER);
        HideableStoryMutationFieldsModel.Builder builder = new HideableStoryMutationFieldsModel.Builder();
        builder.a = str3;
        builder = builder;
        builder.c = StoryVisibility.GONE.name();
        builder = builder;
        builder.b = GraphQLNegativeFeedbackActionType.DELETE.name();
        m10716h().m10598a(params, "timeline_delete_story", 2131234928, builder.a(), new OperationResultFutureCallback(this) {
            final /* synthetic */ TimelineStoriesDataFetcher f10613c;

            public final void m10684a(ServiceException serviceException) {
                this.f10613c.f10639g.m12724a(str2, str, null, StoryVisibility.VISIBLE);
                this.f10613c.m10727f();
            }

            public final void m10685a(Object obj) {
                this.f10613c.m10727f();
                if (this.f10613c.f10634b != null) {
                    this.f10613c.f10634b.mo512g();
                }
            }
        });
    }

    public final void m10727f() {
        m10728g();
        this.f10634b.aC();
    }

    public final void m10728g() {
        this.f10656x.a(ImmutableSet.of("timeline_fetch_first_units_classic", "timeline_fetch_first_units_plutonium", "timeline_fetch_section"));
    }
}
