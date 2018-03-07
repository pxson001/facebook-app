package com.facebook.timeline.datafetcher;

import android.support.annotation.Nullable;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.friends.model.FetchPeopleYouMayKnowResult;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.RequestObservable;
import com.facebook.graphql.model.GraphQLTimelineSection;
import com.facebook.graphql.model.GraphQLTimelineSectionsConnection;
import com.facebook.graphql.model.GraphQLUnseenStoriesConnection;
import com.facebook.timeline.profileprotocol.FetchTimelineFirstUnitsParams;
import com.facebook.timeline.protiles.model.TimelinePromptSource;
import com.facebook.timeline.protiles.protocol.FetchProtilesGraphQLModels.TimelineProtilesQueryModel;
import com.facebook.timeline.protocol.FetchTimelineTaggedMediaSetGraphQLInterfaces.TimelineTaggedMediaSetFields;
import com.facebook.timeline.viewfeaturedcontainers.protocol.FeaturedContainersGraphQLModels.FeaturedContainersQueryModel;

/* compiled from: group_edit_privacy_data */
public interface TimelineFirstUnitsQueryExecutor {

    /* compiled from: group_edit_privacy_data */
    public class FirstUnitsObservables {
        public final RequestObservable<TimelineFirstUnits> f10485a;
        @Nullable
        public final RequestObservable<GraphQLTimelineSection> f10486b;
        public final RequestObservable<TimelinePromptSource> f10487c;
        public final RequestObservable<TimelineTaggedMediaSetFields> f10488d;
        public final RequestObservable<TimelinePromptSource> f10489e;
        @Nullable
        public final RequestObservable<ProtilesResult> f10490f;
        @Nullable
        public final RequestObservable<GraphQLResult<FeaturedContainersQueryModel>> f10491g;
        @Nullable
        public final RequestObservable<GraphQLUnseenStoriesConnection> f10492h;
        @Nullable
        public final RequestObservable<FetchPeopleYouMayKnowResult> f10493i;

        public FirstUnitsObservables(RequestObservable<TimelineFirstUnits> requestObservable, RequestObservable<GraphQLTimelineSection> requestObservable2, RequestObservable<TimelineTaggedMediaSetFields> requestObservable3, RequestObservable<TimelinePromptSource> requestObservable4, RequestObservable<TimelinePromptSource> requestObservable5, RequestObservable<ProtilesResult> requestObservable6, RequestObservable<GraphQLResult<FeaturedContainersQueryModel>> requestObservable7, RequestObservable<GraphQLUnseenStoriesConnection> requestObservable8, RequestObservable<FetchPeopleYouMayKnowResult> requestObservable9) {
            this.f10485a = requestObservable;
            this.f10486b = requestObservable2;
            this.f10488d = requestObservable3;
            this.f10487c = requestObservable4;
            this.f10489e = requestObservable5;
            this.f10490f = requestObservable6;
            this.f10491g = requestObservable7;
            this.f10492h = requestObservable8;
            this.f10493i = requestObservable9;
        }
    }

    /* compiled from: group_edit_privacy_data */
    public class ProtilesResult {
        public final TimelineProtilesQueryModel f10494a;
        public final DataFreshnessResult f10495b;

        public ProtilesResult(TimelineProtilesQueryModel timelineProtilesQueryModel, DataFreshnessResult dataFreshnessResult) {
            this.f10494a = timelineProtilesQueryModel;
            this.f10495b = dataFreshnessResult;
        }
    }

    /* compiled from: group_edit_privacy_data */
    public class TimelineFirstUnits {
        public final GraphQLTimelineSectionsConnection f10496a;
        public final GraphQLTimelineSectionsConnection f10497b;
        public final DataFreshnessResult f10498c;

        public TimelineFirstUnits(GraphQLTimelineSectionsConnection graphQLTimelineSectionsConnection, GraphQLTimelineSectionsConnection graphQLTimelineSectionsConnection2, DataFreshnessResult dataFreshnessResult) {
            this.f10496a = graphQLTimelineSectionsConnection;
            this.f10497b = graphQLTimelineSectionsConnection2;
            this.f10498c = dataFreshnessResult;
        }
    }

    FirstUnitsObservables mo505a(GraphQLBatchRequest graphQLBatchRequest, int i, boolean z, FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams, CallerContext callerContext);

    FirstUnitsObservables mo506a(boolean z, FetchTimelineFirstUnitsParams fetchTimelineFirstUnitsParams, CallerContext callerContext);
}
