package com.facebook.zero.service;

import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.zero.protocol.graphql.ZeroTokenGraphQLModels.FetchZeroTokenQueryModel;
import com.facebook.zero.sdk.token.ZeroToken;
import com.google.common.base.Function;

/* compiled from: workTopGroupsComposer */
public class FbZeroRequestHandler$1 implements Function<GraphQLResult<FetchZeroTokenQueryModel>, ZeroToken> {
    final /* synthetic */ FbZeroRequestHandler f224a;

    public FbZeroRequestHandler$1(FbZeroRequestHandler fbZeroRequestHandler) {
        this.f224a = fbZeroRequestHandler;
    }

    public Object apply(Object obj) {
        return FbZeroRequestHandler.a((GraphQLResult) obj);
    }
}
