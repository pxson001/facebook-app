package com.facebook.messaging.service.methods;

import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.messaging.graphql.threads.ThreadQueries;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.PinnedThreadsQueryModel;
import com.facebook.messaging.service.model.FetchPinnedThreadsParams;
import com.facebook.messaging.service.model.FetchPinnedThreadsResult;
import com.facebook.messaging.threads.graphql.GQLThreadsConverter;
import com.facebook.user.model.User;
import com.fasterxml.jackson.core.JsonParser;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: daily */
public class FetchPinnedThreadsGQLMethod extends AbstractPersistedGraphQlApiMethod<FetchPinnedThreadsParams, FetchPinnedThreadsResult> {
    private final GQLThreadsConverter f16886c;
    private final Provider<User> f16887d;

    public final GraphQlQueryString m16910f(Object obj) {
        return ThreadQueries.i().a("after_time_sec", String.valueOf(((FetchPinnedThreadsParams) obj).f17096c / 1000)).a("thread_count", Integer.valueOf(60)).a("include_message_info", Boolean.FALSE.toString()).a("include_full_user_info", Boolean.FALSE.toString());
    }

    @Inject
    public FetchPinnedThreadsGQLMethod(GraphQLProtocolHelper graphQLProtocolHelper, GQLThreadsConverter gQLThreadsConverter, Provider<User> provider) {
        super(graphQLProtocolHelper);
        this.f16886c = gQLThreadsConverter;
        this.f16887d = provider;
    }

    public final Object m16908a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        User user = (User) this.f16887d.get();
        if (user == null) {
            return FetchPinnedThreadsResult.f17099a;
        }
        PinnedThreadsQueryModel pinnedThreadsQueryModel = (PinnedThreadsQueryModel) jsonParser.a(PinnedThreadsQueryModel.class);
        return this.f16886c.m17791a(pinnedThreadsQueryModel != null ? pinnedThreadsQueryModel.a() : null, user);
    }

    public final int m16909b(Object obj, ApiResponse apiResponse) {
        return 1;
    }
}
