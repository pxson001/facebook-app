package com.facebook.controller.connectioncontroller.common;

import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.TypedGraphQlQueryString;

/* compiled from: minDelayMs < 0 */
public interface ConnectionConfiguration<TEdge, TUserInfo, TRequestModel, TResponseModel> {
    ConnectionPage<TEdge> mo646a(GraphQLResult<TResponseModel> graphQLResult);

    TypedGraphQlQueryString<TRequestModel> mo647a(ConnectionFetchOperation connectionFetchOperation, TUserInfo tUserInfo);
}
