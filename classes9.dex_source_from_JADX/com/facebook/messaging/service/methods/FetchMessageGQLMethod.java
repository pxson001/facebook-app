package com.facebook.messaging.service.methods;

import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.graphql.threads.ThreadQueries;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.MessageInfoModel;
import com.facebook.messaging.service.model.FetchMessageParams;
import com.facebook.messaging.service.model.FetchMessageResult;
import com.facebook.messaging.threads.graphql.GQLThreadQueryHelper;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;

/* compiled from: data_warning */
public class FetchMessageGQLMethod extends AbstractPersistedGraphQlApiMethod<FetchMessageParams, FetchMessageResult> {
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<GQLThreadQueryHelper> f16879c = UltralightRuntime.b;

    public static FetchMessageGQLMethod m16888a(InjectorLike injectorLike) {
        FetchMessageGQLMethod fetchMessageGQLMethod = new FetchMessageGQLMethod(GraphQLProtocolHelper.a(injectorLike));
        fetchMessageGQLMethod.f16879c = IdBasedLazy.a(injectorLike, 8547);
        return fetchMessageGQLMethod;
    }

    public final Object m16889a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        FetchMessageParams fetchMessageParams = (FetchMessageParams) obj;
        Collection b = this.b.b(MessageInfoModel.class, jsonParser);
        if (b.size() == 0) {
            return null;
        }
        FetchMessageParams fetchMessageParams2 = new FetchMessageParams(((MessageInfoModel) b.get(0)).w(), fetchMessageParams.f17064b);
        return (FetchMessageResult) ((GQLThreadQueryHelper) this.f16879c.get()).m17774a(b, ImmutableSet.of(fetchMessageParams2)).get(fetchMessageParams2.f17063a);
    }

    public final GraphQlQueryString m16891f(Object obj) {
        FetchMessageParams fetchMessageParams = (FetchMessageParams) obj;
        this.f16879c.get();
        return ThreadQueries.g().a("thread_msg_ids", GQLThreadQueryHelper.m17750a(ImmutableSet.of(fetchMessageParams)));
    }

    @Inject
    public FetchMessageGQLMethod(GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
    }

    public final int m16890b(Object obj, ApiResponse apiResponse) {
        return 0;
    }
}
