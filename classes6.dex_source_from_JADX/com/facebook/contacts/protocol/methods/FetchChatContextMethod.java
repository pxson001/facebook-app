package com.facebook.contacts.protocol.methods;

import com.facebook.common.time.Clock;
import com.facebook.contacts.graphql.ChatContextGraphQLHelper;
import com.facebook.contacts.graphql.ChatContextsGraphQL.FetchChatContextsQueryString;
import com.facebook.contacts.graphql.ChatContextsGraphQLInterfaces.ChatContextForUser;
import com.facebook.contacts.graphql.ChatContextsGraphQLModels.ChatContextModel;
import com.facebook.contacts.graphql.ChatContextsGraphQLModels.FetchChatContextsQueryModel;
import com.facebook.contacts.server.FetchChatContextParams;
import com.facebook.contacts.server.FetchChatContextResult;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.enums.GraphQLUserChatContextType;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.location.FbLocationStatus.State;
import com.facebook.location.FbLocationStatusUtil;
import com.facebook.location.ImmutableLocation;
import com.facebook.qe.api.QeAccessor;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Iterator;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: page_product_unlike */
public class FetchChatContextMethod extends AbstractPersistedGraphQlApiMethod<FetchChatContextParams, FetchChatContextResult> {
    private static final Class<?> f8380c = FetchChatContextMethod.class;
    private final Clock f8381d;
    private final Provider<Boolean> f8382e;
    private final FbLocationStatusUtil f8383f;
    public final QeAccessor f8384g;

    public final GraphQlQueryString m12235f(@Nullable Object obj) {
        Number number;
        FetchChatContextParams fetchChatContextParams = (FetchChatContextParams) obj;
        GraphQlQueryString fetchChatContextsQueryString = new FetchChatContextsQueryString();
        String str = "context_types";
        ImmutableSet c = m12232c();
        Preconditions.checkNotNull(c);
        Builder builder = ImmutableList.builder();
        Iterator it = c.iterator();
        while (it.hasNext()) {
            builder.c(((GraphQLUserChatContextType) it.next()).name());
        }
        fetchChatContextsQueryString.a(str, builder.b());
        int a = this.f8384g.a(8054, 0);
        if (a <= 0) {
            number = null;
        } else {
            number = Integer.valueOf(a);
        }
        Number number2 = number;
        if (number2 != null) {
            fetchChatContextsQueryString.a("friends_count", number2);
        }
        String a2 = this.f8384g.a('ὸ', "");
        if (a2.isEmpty()) {
            a2 = null;
        }
        str = a2;
        if (str != null) {
            fetchChatContextsQueryString.a("order_friends_by", str);
        }
        if (fetchChatContextParams != null && fetchChatContextParams.f8437a.isPresent()) {
            ImmutableLocation immutableLocation = (ImmutableLocation) fetchChatContextParams.f8437a.get();
            fetchChatContextsQueryString.a("latitude", Double.toString(immutableLocation.a())).a("longitude", Double.toString(immutableLocation.b())).a("accuracy", Float.toString(((Float) immutableLocation.c().get()).floatValue())).a("timestamp", (Number) immutableLocation.g().get());
        }
        return fetchChatContextsQueryString;
    }

    public final RequestPriority m12236j(@Nullable Object obj) {
        FetchChatContextParams fetchChatContextParams = (FetchChatContextParams) obj;
        return (fetchChatContextParams == null || fetchChatContextParams.f8438b) ? RequestPriority.CAN_WAIT : RequestPriority.INTERACTIVE;
    }

    @Inject
    public FetchChatContextMethod(GraphQLProtocolHelper graphQLProtocolHelper, Clock clock, Provider<Boolean> provider, FbLocationStatusUtil fbLocationStatusUtil, QeAccessor qeAccessor) {
        super(graphQLProtocolHelper);
        this.f8381d = clock;
        this.f8382e = provider;
        this.f8383f = fbLocationStatusUtil;
        this.f8384g = qeAccessor;
    }

    public final Object m12233a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        UnmodifiableIterator it = ((FetchChatContextsQueryModel) jsonParser.a(FetchChatContextsQueryModel.class)).m11739a().m11734a().iterator();
        ImmutableMap.Builder builder = ImmutableMap.builder();
        while (it.hasNext()) {
            ChatContextForUser chatContextForUser = (ChatContextForUser) it.next();
            String c = chatContextForUser.mo936c();
            ChatContextModel b = chatContextForUser.mo935b();
            if (b != null) {
                if (m12232c().contains(b.m11728b())) {
                    builder.b(new UserKey(Type.FACEBOOK, c), chatContextForUser);
                } else {
                    b.m11728b();
                }
            }
        }
        return new FetchChatContextResult(DataFreshnessResult.FROM_SERVER, this.f8381d.a(), builder.b());
    }

    public final int m12234b(Object obj, ApiResponse apiResponse) {
        return 1;
    }

    private ImmutableSet<GraphQLUserChatContextType> m12232c() {
        if (((Boolean) this.f8382e.get()).booleanValue() && this.f8383f.b().a == State.OKAY) {
            return ChatContextGraphQLHelper.f8143a;
        }
        return ChatContextGraphQLHelper.f8144b;
    }
}
