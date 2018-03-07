package com.facebook.messaging.composershortcuts;

import android.content.res.Resources;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryParamSet;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.messaging.composershortcuts.graphql.SampleContentQueryFragment.SampleContentQueryFragmentString;
import com.facebook.messaging.composershortcuts.graphql.SampleContentQueryFragmentModels.SampleContentQueryFragmentModel;
import com.facebook.messaging.composershortcuts.graphql.SampleContentQueryUtils;
import com.facebook.messaging.media.externalmedia.MediaParams;
import com.facebook.messaging.media.externalmedia.MediaParams.MediaType;
import com.facebook.messaging.media.externalmedia.MediaParamsBuilder;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: message_data */
public class SampleContentGraphQLFetchHelper {
    private final Resources f10167a;
    private final GraphQLQueryExecutor f10168b;
    public final SampleContentQueryUtils f10169c;

    /* compiled from: message_data */
    class C11751 implements Function<GraphQLResult<SampleContentQueryFragmentModel>, ImmutableMap<String, ImmutableList<PlatformSampleContent>>> {
        final /* synthetic */ SampleContentGraphQLFetchHelper f10166a;

        C11751(SampleContentGraphQLFetchHelper sampleContentGraphQLFetchHelper) {
            this.f10166a = sampleContentGraphQLFetchHelper;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (graphQLResult == null) {
                return RegularImmutableBiMap.a;
            }
            return this.f10166a.f10169c.m10753a((SampleContentQueryFragmentModel) graphQLResult.e);
        }
    }

    @Inject
    public SampleContentGraphQLFetchHelper(Resources resources, GraphQLQueryExecutor graphQLQueryExecutor, SampleContentQueryUtils sampleContentQueryUtils) {
        this.f10167a = resources;
        this.f10168b = graphQLQueryExecutor;
        this.f10169c = sampleContentQueryUtils;
    }

    public final ListenableFuture<ImmutableMap<String, ImmutableList<PlatformSampleContent>>> m10618a(boolean z) {
        return Futures.a(this.f10168b.a(GraphQLRequest.a(m10617a()).a(z ? GraphQLCachePolicy.d : GraphQLCachePolicy.a).a(86400)), new C11751(this));
    }

    private SampleContentQueryFragmentString m10617a() {
        int dimensionPixelSize = this.f10167a.getDimensionPixelSize(2131427828);
        int i = this.f10167a.getDisplayMetrics().widthPixels;
        int dimensionPixelSize2 = this.f10167a.getDimensionPixelSize(2131427826);
        MediaParamsBuilder newBuilder = MediaParams.newBuilder();
        newBuilder.f11618a = ImmutableList.of(MediaType.WEBP, MediaType.GIF, MediaType.JPG, MediaType.PNG);
        newBuilder = newBuilder;
        newBuilder.f11620c = dimensionPixelSize;
        MediaParams e = newBuilder.m12245e();
        newBuilder = MediaParams.newBuilder();
        newBuilder.f11618a = ImmutableList.of(MediaType.WEBP, MediaType.GIF, MediaType.JPG, MediaType.PNG);
        newBuilder = newBuilder;
        newBuilder.f11619b = i;
        MediaParams e2 = newBuilder.m12245e();
        newBuilder = MediaParams.newBuilder();
        newBuilder.f11618a = ImmutableList.of(MediaType.JPG);
        newBuilder = newBuilder;
        newBuilder.f11619b = dimensionPixelSize2;
        newBuilder = newBuilder;
        newBuilder.f11620c = dimensionPixelSize2;
        MediaParams e3 = newBuilder.m12245e();
        GraphQlQueryParamSet graphQlQueryParamSet = new GraphQlQueryParamSet();
        PlatformAppsGraphQLRequest platformAppsGraphQLRequest = new PlatformAppsGraphQLRequest(ImmutableList.of(e, e2), ImmutableList.of(e3));
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        objectNode.c("media_params", MediaParams.m12244a(platformAppsGraphQLRequest.f10153a));
        objectNode.c("app_icon_params", MediaParams.m12244a(platformAppsGraphQLRequest.f10154b));
        graphQlQueryParamSet.a("request", objectNode.toString());
        GraphQlQueryString sampleContentQueryFragmentString = new SampleContentQueryFragmentString();
        sampleContentQueryFragmentString.a = graphQlQueryParamSet;
        return sampleContentQueryFragmentString;
    }
}
