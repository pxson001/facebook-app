package com.facebook.timeline.datafetcher;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.friends.FriendingQueryExecutor;
import com.facebook.friends.constants.PeopleYouMayKnowLocation;
import com.facebook.friends.model.FetchPeopleYouMayKnowResult;
import com.facebook.friends.protocol.FetchPeopleYouMayKnowGraphQLModels.PeopleYouMayKnowQueryModel;
import com.facebook.friends.protocol.FetchPeopleYouMayKnowGraphQLModels.PeopleYouMayKnowQueryModel.PeopleYouMayKnowModel;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.RequestObservable;
import com.facebook.graphql.model.GraphQLTimelineSection;
import com.facebook.graphql.model.GraphQLUser;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryExecutor.ProtilesResult;
import com.facebook.timeline.datafetcher.TimelineFirstUnitsQueryExecutor.TimelineFirstUnits;
import com.facebook.timeline.datafetcher.section.TimelineSectionFetchParamsHelper;
import com.facebook.timeline.profileprotocol.FetchTimelineFirstUnitsParams;
import com.facebook.timeline.protiles.model.TimelinePromptSource;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.TimelineProtilesQueryModel;
import com.facebook.timeline.protocol.FetchTimelineFriendingPossibilitiesGraphQL.TimelineFirstUnitsViewingSelfFriendingPossibilitiesString;
import com.facebook.timeline.protocol.FetchTimelineFriendingPossibilitiesGraphQLModels.TimelineFirstUnitsViewingSelfFriendingPossibilitiesModel;
import com.facebook.timeline.protocol.FetchTimelineFriendingPossibilitiesGraphQLModels.TimelineFriendingPossibilitiesConnectionFieldsModel;
import com.facebook.timeline.protocol.FetchTimelinePromptGraphQL.TimelineFirstUnitsViewingSelfPromptString;
import com.facebook.timeline.protocol.FetchTimelinePromptGraphQLModels.TimelinePromptApproximateCountFieldsModel;
import com.facebook.timeline.protocol.FetchTimelinePromptGraphQLModels.TimelinePromptApproximateCountFieldsModel.Builder;
import com.facebook.timeline.protocol.FetchTimelinePromptGraphQLModels.TimelinePromptModel;
import com.facebook.timeline.viewfeaturedcontainers.abtest.FavPhotosVsFeaturedContainersController;
import com.facebook.timeline.viewfeaturedcontainers.data.FeaturedContainersQueryFactory;
import com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel;
import com.google.common.base.Absent;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: greeting_card_load_failure */
public class TimelineSelfFirstUnitsQueryBuilder {
    private final TimelineFirstUnitsQueryBuilder f10594a;
    private final FavPhotosVsFeaturedContainersController f10595b;
    private final FeaturedContainersQueryFactory f10596c;
    private final TimelineSectionQueryExecutor f10597d;
    private final ProtilesQueryFactory f10598e;
    private final FriendingQueryExecutor f10599f;
    public final String f10600g;
    private final int f10601h;

    /* compiled from: greeting_card_load_failure */
    class C15411 implements Function<GraphQLResult<GraphQLUser>, TimelineFirstUnits> {
        final /* synthetic */ TimelineSelfFirstUnitsQueryBuilder f10588a;

        C15411(TimelineSelfFirstUnitsQueryBuilder timelineSelfFirstUnitsQueryBuilder) {
            this.f10588a = timelineSelfFirstUnitsQueryBuilder;
        }

        public Object apply(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            FirstSectionChecker.m10525a(((GraphQLUser) graphQLResult.e).I());
            return new TimelineFirstUnits(((GraphQLUser) graphQLResult.e).bc(), ((GraphQLUser) graphQLResult.e).I(), graphQLResult.freshness);
        }
    }

    /* compiled from: greeting_card_load_failure */
    class C15422 implements Function<TimelineFirstUnitsViewingSelfFriendingPossibilitiesModel, TimelinePromptSource> {
        final /* synthetic */ TimelineSelfFirstUnitsQueryBuilder f10589a;

        C15422(TimelineSelfFirstUnitsQueryBuilder timelineSelfFirstUnitsQueryBuilder) {
            this.f10589a = timelineSelfFirstUnitsQueryBuilder;
        }

        public Object apply(Object obj) {
            TimelineFriendingPossibilitiesConnectionFieldsModel a = ((TimelineFirstUnitsViewingSelfFriendingPossibilitiesModel) obj).a();
            String str = this.f10589a.f10600g;
            Builder builder = new Builder();
            builder.a = a.a();
            builder = builder;
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.c(1);
            flatBufferBuilder.a(0, builder.a, 0);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new TimelinePromptSource(Optional.of(new TimelinePromptApproximateCountFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null))), Absent.INSTANCE, str, TimelinePromptSource.f12121g, false);
        }
    }

    /* compiled from: greeting_card_load_failure */
    class C15433 implements Function<TimelineFirstUnitsViewingSelfFriendingPossibilitiesModel, Boolean> {
        final /* synthetic */ TimelineSelfFirstUnitsQueryBuilder f10590a;

        C15433(TimelineSelfFirstUnitsQueryBuilder timelineSelfFirstUnitsQueryBuilder) {
            this.f10590a = timelineSelfFirstUnitsQueryBuilder;
        }

        public Object apply(Object obj) {
            TimelineFirstUnitsViewingSelfFriendingPossibilitiesModel timelineFirstUnitsViewingSelfFriendingPossibilitiesModel = (TimelineFirstUnitsViewingSelfFriendingPossibilitiesModel) obj;
            boolean z = (timelineFirstUnitsViewingSelfFriendingPossibilitiesModel == null || timelineFirstUnitsViewingSelfFriendingPossibilitiesModel.a() == null) ? false : true;
            return Boolean.valueOf(z);
        }
    }

    /* compiled from: greeting_card_load_failure */
    class C15444 implements Function<TimelinePromptModel, Boolean> {
        final /* synthetic */ TimelineSelfFirstUnitsQueryBuilder f10591a;

        C15444(TimelineSelfFirstUnitsQueryBuilder timelineSelfFirstUnitsQueryBuilder) {
            this.f10591a = timelineSelfFirstUnitsQueryBuilder;
        }

        public Object apply(Object obj) {
            TimelinePromptModel timelinePromptModel = (TimelinePromptModel) obj;
            boolean z = (timelinePromptModel == null || timelinePromptModel.a() == null) ? false : true;
            return Boolean.valueOf(z);
        }
    }

    /* compiled from: greeting_card_load_failure */
    class C15455 implements Function<GraphQLResult<TimelineProtilesQueryModel>, ProtilesResult> {
        final /* synthetic */ TimelineSelfFirstUnitsQueryBuilder f10592a;

        C15455(TimelineSelfFirstUnitsQueryBuilder timelineSelfFirstUnitsQueryBuilder) {
            this.f10592a = timelineSelfFirstUnitsQueryBuilder;
        }

        public Object apply(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            return new ProtilesResult((TimelineProtilesQueryModel) graphQLResult.e, graphQLResult.freshness);
        }
    }

    /* compiled from: greeting_card_load_failure */
    class C15466 implements Function<GraphQLResult<PeopleYouMayKnowQueryModel>, FetchPeopleYouMayKnowResult> {
        final /* synthetic */ TimelineSelfFirstUnitsQueryBuilder f10593a;

        C15466(TimelineSelfFirstUnitsQueryBuilder timelineSelfFirstUnitsQueryBuilder) {
            this.f10593a = timelineSelfFirstUnitsQueryBuilder;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null || graphQLResult.e == null || ((PeopleYouMayKnowQueryModel) graphQLResult.e).a() == null) {
                return null;
            }
            PeopleYouMayKnowModel a = ((PeopleYouMayKnowQueryModel) graphQLResult.e).a();
            return new FetchPeopleYouMayKnowResult(FriendingQueryExecutor.b(a.a()), FriendingQueryExecutor.a(a.j()));
        }
    }

    public static TimelineSelfFirstUnitsQueryBuilder m10667b(InjectorLike injectorLike) {
        return new TimelineSelfFirstUnitsQueryBuilder(ResourcesMethodAutoProvider.a(injectorLike), TimelineFirstUnitsQueryBuilder.m10587a(injectorLike), FavPhotosVsFeaturedContainersController.m12774a(injectorLike), FeaturedContainersQueryFactory.m12782a(injectorLike), TimelineSectionQueryExecutor.m10663b(injectorLike), ProtilesQueryFactory.m10534a(injectorLike), FriendingQueryExecutor.a(injectorLike));
    }

    public final RequestObservable<TimelinePromptSource> m10673a(GraphQLBatchRequest graphQLBatchRequest, FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams, GraphQLCachePolicy graphQLCachePolicy, int i, CallerContext callerContext) {
        GraphQLRequest a = GraphQLRequest.a((TimelineFirstUnitsViewingSelfPromptString) new TimelineFirstUnitsViewingSelfPromptString().a("node_id", String.valueOf(fetchTimelineFirstUnitsParams.f12088a))).a(RequestPriority.NON_INTERACTIVE);
        a.y = i;
        a = a;
        a.f = callerContext;
        return GraphQLResultNullChecker.m10532a(graphQLBatchRequest.a(a.a(graphQLCachePolicy))).b(new C15444(this)).a(TimelinePromptSource.f12120a);
    }

    public final RequestObservable<TimelinePromptSource> m10670a(GraphQLBatchRequest graphQLBatchRequest, GraphQLCachePolicy graphQLCachePolicy, int i, CallerContext callerContext) {
        GraphQLRequest a = GraphQLRequest.a(new TimelineFirstUnitsViewingSelfFriendingPossibilitiesString()).a(RequestPriority.NON_INTERACTIVE);
        a.y = i;
        a = a;
        a.f = callerContext;
        return GraphQLResultNullChecker.m10532a(graphQLBatchRequest.a(a.a(graphQLCachePolicy))).b(new C15433(this)).a(new C15422(this));
    }

    @Inject
    public TimelineSelfFirstUnitsQueryBuilder(Resources resources, TimelineFirstUnitsQueryBuilder timelineFirstUnitsQueryBuilder, FavPhotosVsFeaturedContainersController favPhotosVsFeaturedContainersController, FeaturedContainersQueryFactory featuredContainersQueryFactory, TimelineSectionQueryExecutor timelineSectionQueryExecutor, ProtilesQueryFactory protilesQueryFactory, FriendingQueryExecutor friendingQueryExecutor) {
        this.f10594a = timelineFirstUnitsQueryBuilder;
        this.f10595b = favPhotosVsFeaturedContainersController;
        this.f10596c = featuredContainersQueryFactory;
        this.f10597d = timelineSectionQueryExecutor;
        this.f10598e = protilesQueryFactory;
        this.f10599f = friendingQueryExecutor;
        this.f10600g = resources.getString(2131234966);
        this.f10601h = resources.getDimensionPixelSize(2131430284);
    }

    public final GraphQLRequest<GraphQLUser> m10668a(FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams, GraphQLCachePolicy graphQLCachePolicy, int i, CallerContext callerContext) {
        GraphQLRequest a = GraphQLRequest.a(this.f10594a.m10589a(fetchTimelineFirstUnitsParams)).a(RequestPriority.NON_INTERACTIVE);
        a.y = i;
        a = a;
        a.f = callerContext;
        return a.a(graphQLCachePolicy);
    }

    public final RequestObservable<TimelineFirstUnits> m10671a(GraphQLBatchRequest graphQLBatchRequest, GraphQLRequest<GraphQLUser> graphQLRequest) {
        return GraphQLResultNullChecker.m10533b(graphQLBatchRequest.a(graphQLRequest)).a(new C15411(this));
    }

    public final RequestObservable<GraphQLTimelineSection> m10672a(GraphQLBatchRequest graphQLBatchRequest, GraphQLRequest<GraphQLUser> graphQLRequest, GraphQLCachePolicy graphQLCachePolicy, int i, CallerContext callerContext) {
        return this.f10597d.m10665a(graphQLBatchRequest, TimelineSectionFetchParamsHelper.m10747a(graphQLRequest, graphQLCachePolicy == GraphQLCachePolicy.d), graphQLCachePolicy, i, callerContext);
    }

    @Nullable
    public final RequestObservable<GraphQLResult<FeaturedContainersQueryModel>> m10674b(GraphQLBatchRequest graphQLBatchRequest, FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams, GraphQLCachePolicy graphQLCachePolicy, int i, CallerContext callerContext) {
        if (!this.f10595b.m12778c()) {
            return null;
        }
        GraphQLRequest a = GraphQLRequest.a(this.f10596c.m12784a(fetchTimelineFirstUnitsParams.f12088a)).a(RequestPriority.NON_INTERACTIVE);
        a.y = i;
        a = a;
        a.f = callerContext;
        return GraphQLResultNullChecker.m10533b(graphQLBatchRequest.a(a.a(graphQLCachePolicy)));
    }

    public final RequestObservable<ProtilesResult> m10675c(GraphQLBatchRequest graphQLBatchRequest, FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams, GraphQLCachePolicy graphQLCachePolicy, int i, CallerContext callerContext) {
        GraphQLRequest a = GraphQLRequest.a(this.f10598e.m10537a(String.valueOf(fetchTimelineFirstUnitsParams.f12088a))).a(RequestPriority.NON_INTERACTIVE);
        a.y = i;
        a = a;
        a.f = callerContext;
        return GraphQLResultNullChecker.m10533b(graphQLBatchRequest.a(a.a(graphQLCachePolicy))).a(new C15455(this));
    }

    public final RequestObservable<FetchPeopleYouMayKnowResult> m10669a(GraphQLBatchRequest graphQLBatchRequest, int i, CallerContext callerContext) {
        GraphQLRequest a = this.f10599f.a(null, 20, this.f10601h, PeopleYouMayKnowLocation.SELF_PROFILE, callerContext).a(RequestPriority.NON_INTERACTIVE);
        a.y = i;
        return GraphQLResultNullChecker.m10533b(graphQLBatchRequest.a(a)).a(new C15466(this));
    }
}
