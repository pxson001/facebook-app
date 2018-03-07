package com.facebook.messaging.service.methods;

import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.ThreadInfoModel;
import com.facebook.messaging.service.model.FetchThreadParams;
import com.facebook.messaging.service.model.FetchThreadResult;
import com.facebook.messaging.threads.graphql.GQLThreadQueryHelper;
import com.facebook.messaging.threads.graphql.GQLThreadsConverter;
import com.facebook.ultralight.Inject;
import com.facebook.user.model.User;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: d_rpt */
public class FetchThreadGQLMethod extends AbstractPersistedGraphQlApiMethod<FetchThreadParams, FetchThreadResult> {
    GQLThreadQueryHelper f16892c;
    GQLThreadsConverter f16893d;
    Provider<User> f16894e;

    public final GraphQlQueryString m16915f(Object obj) {
        FetchThreadParams fetchThreadParams = (FetchThreadParams) obj;
        Set set = fetchThreadParams.f17155a.b;
        if (set.isEmpty()) {
            return this.f16892c.m17766a(ImmutableList.of(Preconditions.checkNotNull(fetchThreadParams.f17155a.c)), fetchThreadParams.f17160f, Boolean.valueOf(true));
        }
        return this.f16892c.m17767a(set, fetchThreadParams.f17160f, Boolean.valueOf(true));
    }

    @Inject
    public FetchThreadGQLMethod(GraphQLProtocolHelper graphQLProtocolHelper, GQLThreadQueryHelper gQLThreadQueryHelper, GQLThreadsConverter gQLThreadsConverter, Provider<User> provider) {
        super(graphQLProtocolHelper);
        this.f16892c = gQLThreadQueryHelper;
        this.f16893d = gQLThreadsConverter;
        this.f16894e = provider;
    }

    public final Object m16913a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        ThreadInfoModel threadInfoModel = (ThreadInfoModel) jsonParser.a(ThreadInfoModel.class);
        return this.f16893d.m17792a(this.f16893d.m17787a(threadInfoModel, (User) this.f16894e.get()), threadInfoModel, (User) this.f16894e.get(), null);
    }

    public final int m16914b(Object obj, ApiResponse apiResponse) {
        return 1;
    }
}
