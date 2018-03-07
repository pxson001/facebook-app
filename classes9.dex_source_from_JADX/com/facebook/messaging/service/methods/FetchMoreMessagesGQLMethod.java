package com.facebook.messaging.service.methods;

import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.graphql.threads.ThreadQueries;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.MoreMessagesQueryModel;
import com.facebook.messaging.photos.size.MediaSizeUtil;
import com.facebook.messaging.service.model.FetchMoreMessagesParams;
import com.facebook.messaging.service.model.FetchMoreMessagesResult;
import com.facebook.messaging.threads.graphql.GQLThreadQueryHelper;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.fasterxml.jackson.core.JsonParser;

/* compiled from: dataFreshness */
public class FetchMoreMessagesGQLMethod extends AbstractPersistedGraphQlApiMethod<FetchMoreMessagesParams, FetchMoreMessagesResult> {
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<GQLThreadQueryHelper> f16881c = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<MediaSizeUtil> f16882d = UltralightRuntime.b;

    public static FetchMoreMessagesGQLMethod m16896a(InjectorLike injectorLike) {
        FetchMoreMessagesGQLMethod fetchMoreMessagesGQLMethod = new FetchMoreMessagesGQLMethod(GraphQLProtocolHelper.a(injectorLike));
        com.facebook.inject.Lazy a = IdBasedLazy.a(injectorLike, 8547);
        com.facebook.inject.Lazy b = IdBasedSingletonScopeProvider.b(injectorLike, 8292);
        fetchMoreMessagesGQLMethod.f16881c = a;
        fetchMoreMessagesGQLMethod.f16882d = b;
        return fetchMoreMessagesGQLMethod;
    }

    public final Object m16897a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        return ((GQLThreadQueryHelper) this.f16881c.get()).m17770a((MoreMessagesQueryModel) jsonParser.a(MoreMessagesQueryModel.class), ((FetchMoreMessagesParams) obj).f17066a);
    }

    public final GraphQlQueryString m16899f(Object obj) {
        FetchMoreMessagesParams fetchMoreMessagesParams = (FetchMoreMessagesParams) obj;
        return ThreadQueries.f().a("thread_id", String.valueOf(fetchMoreMessagesParams.f17066a.i())).a("before_time_ms", String.valueOf(fetchMoreMessagesParams.f17068c)).a("msg_count", Integer.valueOf(fetchMoreMessagesParams.f17069d)).a("full_screen_height", Integer.valueOf(((MediaSizeUtil) this.f16882d.get()).g())).a("full_screen_width", Integer.valueOf(((MediaSizeUtil) this.f16882d.get()).f())).a("small_preview_size", Integer.valueOf(((MediaSizeUtil) this.f16882d.get()).k())).a("medium_preview_size", Integer.valueOf(((MediaSizeUtil) this.f16882d.get()).j())).a("large_preview_size", Integer.valueOf(((MediaSizeUtil) this.f16882d.get()).i()));
    }

    @Inject
    public FetchMoreMessagesGQLMethod(GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
    }

    public final int m16898b(Object obj, ApiResponse apiResponse) {
        return 1;
    }
}
