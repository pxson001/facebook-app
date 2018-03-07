package com.facebook.timeline.datafetcher;

import android.os.Parcelable;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultBigProfilePictureFieldsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.ViewerTopFriendsQueryModel;
import javax.annotation.Nullable;

/* compiled from: group_approve_pending_member */
public class HeaderFetchFutures {
    public final GraphQLQueryFuture<GraphQLResult<? extends Parcelable>> f10416a;
    public final GraphQLQueryFuture<GraphQLResult<? extends Parcelable>> f10417b;
    @Nullable
    public final GraphQLQueryFuture<GraphQLResult<DefaultBigProfilePictureFieldsModel>> f10418c;
    @Nullable
    public final GraphQLQueryFuture<GraphQLResult<ViewerTopFriendsQueryModel>> f10419d;

    public HeaderFetchFutures(GraphQLQueryFuture<GraphQLResult<? extends Parcelable>> graphQLQueryFuture, GraphQLQueryFuture<GraphQLResult<? extends Parcelable>> graphQLQueryFuture2, @Nullable GraphQLQueryFuture<GraphQLResult<DefaultBigProfilePictureFieldsModel>> graphQLQueryFuture3, @Nullable GraphQLQueryFuture<GraphQLResult<ViewerTopFriendsQueryModel>> graphQLQueryFuture4) {
        this.f10416a = graphQLQueryFuture;
        this.f10417b = graphQLQueryFuture2;
        this.f10418c = graphQLQueryFuture3;
        this.f10419d = graphQLQueryFuture4;
    }
}
