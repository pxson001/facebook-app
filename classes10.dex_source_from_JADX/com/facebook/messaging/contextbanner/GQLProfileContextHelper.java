package com.facebook.messaging.contextbanner;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.messaging.contextbanner.ProfileContextItemsParser.C03681;
import com.facebook.messaging.contextbanner.graphql.ProfileContextQuery.ProfileContextQueryString;
import com.facebook.messaging.contextbanner.graphql.ProfileContextQueryModels.ContextItemsListModel.NodesModel;
import com.facebook.messaging.contextbanner.graphql.ProfileContextQueryModels.ProfileContextItemsModel;
import com.facebook.messaging.contextbanner.model.ContextItems;
import com.facebook.messaging.contextbanner.model.ProfileContextItem;
import com.facebook.messaging.contextbanner.model.ProfileContextItemType;
import com.facebook.messaging.contextbanner.model.ProfileContextItems;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: suggested_roll_key */
public class GQLProfileContextHelper {
    private final GraphQLQueryExecutor f2195a;
    private final ExecutorService f2196b;
    public final ProfileContextItemsParser f2197c;

    /* compiled from: suggested_roll_key */
    class C03671 implements Function<GraphQLResult<ProfileContextItemsModel>, ContextItems> {
        final /* synthetic */ GQLProfileContextHelper f2194a;

        C03671(GQLProfileContextHelper gQLProfileContextHelper) {
            this.f2194a = gQLProfileContextHelper;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            ProfileContextItems profileContextItems;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            ProfileContextItemsParser profileContextItemsParser = this.f2194a.f2197c;
            if (graphQLResult == null) {
                ((AbstractFbErrorReporter) profileContextItemsParser.f2199a.get()).a("profile_context_query_result", "Graphql ProfileContextQuery result is null");
                profileContextItems = null;
            } else if (((ProfileContextItemsModel) graphQLResult.e).m2077j() == null || ((ProfileContextItemsModel) graphQLResult.e).m2074a() == null) {
                ((AbstractFbErrorReporter) profileContextItemsParser.f2199a.get()).a("profile_context_query_result_fields", "Graphql ProfileContextQuery has unexpected null fields");
                profileContextItems = null;
            } else {
                Object obj2 = null;
                Preconditions.checkNotNull(((ProfileContextItemsModel) graphQLResult.e).m2077j());
                Preconditions.checkNotNull(((ProfileContextItemsModel) graphQLResult.e).m2074a());
                ImmutableList b = new Builder().b(((ProfileContextItemsModel) graphQLResult.e).m2077j().m2069a()).b(((ProfileContextItemsModel) graphQLResult.e).m2074a().m2069a()).b();
                Builder builder = ImmutableList.builder();
                int size = b.size();
                int i = 0;
                while (i < size) {
                    Object obj3;
                    NodesModel nodesModel = (NodesModel) b.get(i);
                    if (!(nodesModel.m2063a() == null || nodesModel.m2065j() == null || Strings.isNullOrEmpty(nodesModel.m2065j().m2061a()))) {
                        switch (C03681.f2198a[nodesModel.m2063a().ordinal()]) {
                            case 1:
                                builder.c(new ProfileContextItem(ProfileContextItemType.WORK, nodesModel.m2065j().m2061a()));
                                obj3 = obj2;
                                continue;
                            case 2:
                                builder.c(new ProfileContextItem(ProfileContextItemType.CURRENT_CITY, nodesModel.m2065j().m2061a()));
                                obj3 = obj2;
                                continue;
                            case 3:
                                builder.c(new ProfileContextItem(ProfileContextItemType.EDUCATION, nodesModel.m2065j().m2061a()));
                                obj3 = obj2;
                                continue;
                            default:
                                if (obj2 == null) {
                                    builder.c(new ProfileContextItem(ProfileContextItemType.OTHER, nodesModel.m2065j().m2061a()));
                                    obj3 = 1;
                                    continue;
                                }
                                break;
                        }
                    }
                    obj3 = obj2;
                    i++;
                    obj2 = obj3;
                }
                profileContextItems = new ProfileContextItems(builder.b());
            }
            return profileContextItems;
        }
    }

    @Inject
    public GQLProfileContextHelper(GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, ProfileContextItemsParser profileContextItemsParser) {
        this.f2196b = executorService;
        this.f2195a = graphQLQueryExecutor;
        this.f2197c = profileContextItemsParser;
    }

    public final ListenableFuture<ContextItems> m2014a(String str) {
        GraphQlQueryString profileContextQueryString = new ProfileContextQueryString();
        profileContextQueryString.a("render_location", "messenger");
        profileContextQueryString.a("profile_id", str);
        profileContextQueryString.a("specific_item_types", ImmutableList.of("work", "education", "current_city"));
        GraphQLRequest a = GraphQLRequest.a(profileContextQueryString).a(GraphQLCachePolicy.a).a(86400);
        a.f = CallerContext.a(getClass());
        return Futures.a(this.f2195a.a(a), new C03671(this), this.f2196b);
    }
}
