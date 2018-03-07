package com.facebook.identitygrowth.protocol;

import com.facebook.graphql.executor.GraphQLCacheKeySerializer;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.cachekey.KeyFactory;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadFetcher.ResultTransformer;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadSearchGraphQLModels.ProfileInfoTypeaheadSearchQueryModel;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadSearchGraphQLModels.ProfileInfoTypeaheadSearchQueryModel.EligibleHubsModel;
import com.facebook.identitygrowth.protocol.ProfileInfoTypeaheadSearchGraphQLModels.TypeaheadResultPageModel;
import com.facebook.inject.InjectorLike;
import com.facebook.places.future.SimpleExecutor;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mDisplayNumber */
public class ProfileInfoTypeaheadSearchFetcher extends ProfileInfoTypeaheadFetcher<ProfileInfoTypeaheadSearchQueryModel> {
    public static final Collection<String> f11121b = Collections.singleton("typeahead_session_id");
    public GraphQLCacheKeySerializer f11122a = new C06911(this);

    /* compiled from: mDisplayNumber */
    class C06911 implements GraphQLCacheKeySerializer {
        final /* synthetic */ ProfileInfoTypeaheadSearchFetcher f11119c;

        C06911(ProfileInfoTypeaheadSearchFetcher profileInfoTypeaheadSearchFetcher) {
            this.f11119c = profileInfoTypeaheadSearchFetcher;
        }

        public final String m17898a(GraphQLRequest graphQLRequest, Class<?> cls, KeyFactory keyFactory) {
            return keyFactory.a(graphQLRequest.o, cls, graphQLRequest.d(), ProfileInfoTypeaheadSearchFetcher.f11121b);
        }
    }

    /* compiled from: mDisplayNumber */
    public class C06922 implements ResultTransformer<ProfileInfoTypeaheadSearchQueryModel> {
        final /* synthetic */ ProfileInfoTypeaheadSearchFetcher f11120a;

        public C06922(ProfileInfoTypeaheadSearchFetcher profileInfoTypeaheadSearchFetcher) {
            this.f11120a = profileInfoTypeaheadSearchFetcher;
        }

        @Nullable
        public Object apply(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            List a = Lists.a();
            EligibleHubsModel a2 = ((ProfileInfoTypeaheadSearchQueryModel) graphQLResult.e).m17910a();
            if (a2 != null) {
                ImmutableList a3 = a2.m17906a();
                int size = a3.size();
                for (int i = 0; i < size; i++) {
                    a.add((TypeaheadResultPageModel) a3.get(i));
                }
            }
            return a;
        }
    }

    public static ProfileInfoTypeaheadSearchFetcher m17899b(InjectorLike injectorLike) {
        return new ProfileInfoTypeaheadSearchFetcher(SimpleExecutor.m22275b(injectorLike), GraphQLQueryExecutor.a(injectorLike));
    }

    @Inject
    public ProfileInfoTypeaheadSearchFetcher(SimpleExecutor simpleExecutor, GraphQLQueryExecutor graphQLQueryExecutor) {
        super(simpleExecutor, graphQLQueryExecutor);
    }
}
