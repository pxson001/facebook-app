package com.facebook.messaging.contactsyoumayknow;

import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.messaging.contactsyoumayknow.graphql.ContactsYouMayKnowQuery.ContactsYouMayKnowQueryString;
import com.facebook.messaging.contactsyoumayknow.graphql.ContactsYouMayKnowQueryModels.ContactsYouMayKnowQueryModel;
import com.google.common.base.Function;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: sync_sequence_id_difference */
public class ContactsYouMayKnowFetcher {
    private static final Class<?> f2098a = ContactsYouMayKnowFetcher.class;
    public final GraphQLQueryExecutor f2099b;
    public final ContactsYouMayKnowDataDeserializer f2100c;
    private final GraphQLCacheManager f2101d;
    private final ExecutorService f2102e;

    /* compiled from: sync_sequence_id_difference */
    public class C03501 implements Function<GraphQLResult<ContactsYouMayKnowQueryModel>, ContactsYouMayKnowData> {
        final /* synthetic */ ContactsYouMayKnowFetcher f2097a;

        public C03501(ContactsYouMayKnowFetcher contactsYouMayKnowFetcher) {
            this.f2097a = contactsYouMayKnowFetcher;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            ContactsYouMayKnowData contactsYouMayKnowData;
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            ContactsYouMayKnowFetcher contactsYouMayKnowFetcher = this.f2097a;
            if (graphQLResult == null || graphQLResult.e == null) {
                contactsYouMayKnowData = null;
            } else {
                contactsYouMayKnowData = contactsYouMayKnowFetcher.f2100c.m1914a((ContactsYouMayKnowQueryModel) graphQLResult.e);
            }
            return contactsYouMayKnowData;
        }
    }

    @Inject
    public ContactsYouMayKnowFetcher(GraphQLQueryExecutor graphQLQueryExecutor, ContactsYouMayKnowDataDeserializer contactsYouMayKnowDataDeserializer, GraphQLCacheManager graphQLCacheManager, ExecutorService executorService) {
        this.f2099b = graphQLQueryExecutor;
        this.f2100c = contactsYouMayKnowDataDeserializer;
        this.f2101d = graphQLCacheManager;
        this.f2102e = executorService;
    }

    public static GraphQLRequest<ContactsYouMayKnowQueryModel> m1915b() {
        GraphQLRequest<ContactsYouMayKnowQueryModel> a = GraphQLRequest.a((TypedGraphQlQueryString) new ContactsYouMayKnowQueryString().a("max_count", Integer.valueOf(50)).a("square_profile_pic_size_big", Integer.valueOf(GraphQlQueryDefaults.c()))).a(GraphQLCachePolicy.a).a(86400);
        a.b = true;
        return a;
    }
}
