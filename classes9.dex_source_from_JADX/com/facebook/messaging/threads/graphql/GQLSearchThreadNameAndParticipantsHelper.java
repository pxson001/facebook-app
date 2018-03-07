package com.facebook.messaging.threads.graphql;

import com.facebook.common.time.SystemClock;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.graphql.fetch.GQLUserConverter;
import com.facebook.messaging.graphql.threads.ThreadQueries.SearchThreadNameAndParticipantsQueryString;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.SearchThreadNameAndParticipantsQueryModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.SearchThreadNameAndParticipantsQueryModel.SearchResultsParticipantsModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.SearchThreadNameAndParticipantsQueryModel.SearchResultsThreadNameModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.ThreadInfoModel;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.model.threads.ThreadsCollection;
import com.facebook.messaging.service.model.FetchGroupThreadsResultBuilder;
import com.facebook.messaging.service.model.SearchThreadNameAndParticipantsParams;
import com.facebook.messaging.service.model.SearchThreadNameAndParticipantsResult;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: com.facebook.login.LoginManager */
public class GQLSearchThreadNameAndParticipantsHelper {
    private final GQLUserConverter f17801a;
    private final GQLThreadsConverter f17802b;
    private final GraphQLQueryExecutor f17803c;
    private final Provider<User> f17804d;

    /* compiled from: com.facebook.login.LoginManager */
    class C21021 implements Comparator<ThreadSummary> {
        final /* synthetic */ GQLSearchThreadNameAndParticipantsHelper f17800a;

        C21021(GQLSearchThreadNameAndParticipantsHelper gQLSearchThreadNameAndParticipantsHelper) {
            this.f17800a = gQLSearchThreadNameAndParticipantsHelper;
        }

        public int compare(Object obj, Object obj2) {
            ThreadSummary threadSummary = (ThreadSummary) obj;
            ThreadSummary threadSummary2 = (ThreadSummary) obj2;
            if (threadSummary2.k < threadSummary.k) {
                return -1;
            }
            if (threadSummary2.k == threadSummary.k) {
                return 0;
            }
            return 1;
        }
    }

    public static GQLSearchThreadNameAndParticipantsHelper m17746b(InjectorLike injectorLike) {
        return new GQLSearchThreadNameAndParticipantsHelper(GQLUserConverter.a(injectorLike), GQLThreadsConverter.m17785b(injectorLike), GraphQLQueryExecutor.a(injectorLike), IdBasedProvider.a(injectorLike, 3595));
    }

    @Inject
    public GQLSearchThreadNameAndParticipantsHelper(GQLUserConverter gQLUserConverter, GQLThreadsConverter gQLThreadsConverter, GraphQLQueryExecutor graphQLQueryExecutor, Provider<User> provider) {
        this.f17801a = gQLUserConverter;
        this.f17802b = gQLThreadsConverter;
        this.f17803c = graphQLQueryExecutor;
        this.f17804d = provider;
    }

    public final SearchThreadNameAndParticipantsResult m17747a(SearchThreadNameAndParticipantsParams searchThreadNameAndParticipantsParams) {
        User user = (User) this.f17804d.get();
        if (user == null) {
            return SearchThreadNameAndParticipantsResult.newBuilder().m17085f();
        }
        GraphQlQueryString searchThreadNameAndParticipantsQueryString = new SearchThreadNameAndParticipantsQueryString();
        searchThreadNameAndParticipantsQueryString.a("max_count", Integer.valueOf(searchThreadNameAndParticipantsParams.f17288a)).a("search_query", searchThreadNameAndParticipantsParams.f17289b).a("include_message_info", Boolean.FALSE.toString()).a("include_full_user_info", Boolean.TRUE.toString());
        SearchThreadNameAndParticipantsQueryModel searchThreadNameAndParticipantsQueryModel = (SearchThreadNameAndParticipantsQueryModel) ((GraphQLResult) FutureDetour.a(this.f17803c.a(GraphQLRequest.a(searchThreadNameAndParticipantsQueryString).a(GraphQLCachePolicy.a).a(120)), -1476834302)).e;
        SearchResultsThreadNameModel j = searchThreadNameAndParticipantsQueryModel.j();
        SearchResultsParticipantsModel a = searchThreadNameAndParticipantsQueryModel.a();
        ThreadsCollection a2 = m17745a(j == null ? null : j.a(), a == null ? null : a.a(), user);
        Builder builder = ImmutableList.builder();
        if (j != null) {
            builder.b(j.a());
        }
        if (a != null) {
            builder.b(a.a());
        }
        ImmutableList a3 = this.f17801a.a(builder.b());
        FetchGroupThreadsResultBuilder newBuilder = SearchThreadNameAndParticipantsResult.newBuilder();
        newBuilder.f17053a = DataFreshnessResult.FROM_SERVER;
        newBuilder = newBuilder;
        newBuilder.f17054b = a2;
        FetchGroupThreadsResultBuilder fetchGroupThreadsResultBuilder = newBuilder;
        fetchGroupThreadsResultBuilder.f17055c = a3;
        fetchGroupThreadsResultBuilder = fetchGroupThreadsResultBuilder;
        fetchGroupThreadsResultBuilder.f17056d = SystemClock.a.a();
        return fetchGroupThreadsResultBuilder.m17085f();
    }

    private ThreadsCollection m17745a(@Nullable ImmutableList<ThreadInfoModel> immutableList, @Nullable ImmutableList<ThreadInfoModel> immutableList2, User user) {
        int size;
        int i;
        ThreadInfoModel threadInfoModel;
        ThreadKey a;
        Collection arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        if (immutableList != null) {
            size = immutableList.size();
            for (i = 0; i < size; i++) {
                threadInfoModel = (ThreadInfoModel) immutableList.get(i);
                a = this.f17802b.m17787a(threadInfoModel, user);
                if (!(a == null || hashSet.contains(a))) {
                    arrayList.add(this.f17802b.m17788a(a, threadInfoModel, null, user));
                    hashSet.add(a);
                }
            }
        }
        if (immutableList2 != null) {
            size = immutableList2.size();
            for (i = 0; i < size; i++) {
                threadInfoModel = (ThreadInfoModel) immutableList2.get(i);
                a = this.f17802b.m17787a(threadInfoModel, user);
                if (!(a == null || hashSet.contains(a))) {
                    arrayList.add(this.f17802b.m17788a(a, threadInfoModel, null, user));
                    hashSet.add(a);
                }
            }
        }
        Collections.sort(arrayList, new C21021(this));
        return new ThreadsCollection(ImmutableList.copyOf(arrayList), false);
    }
}
