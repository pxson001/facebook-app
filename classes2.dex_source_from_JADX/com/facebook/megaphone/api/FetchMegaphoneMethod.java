package com.facebook.megaphone.api;

import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.graphql.model.GraphQLMegaphone;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.megaphone.api.FetchMegaphoneGraphQL.FetchMegaphoneQueryString;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.inject.Inject;

/* compiled from: pd_parents */
public class FetchMegaphoneMethod extends AbstractPersistedGraphQlApiMethod<FetchMegaphoneParams, FetchMegaphoneResult> {
    public final GraphQlQueryString mo1433f(Object obj) {
        FetchMegaphoneParams fetchMegaphoneParams = (FetchMegaphoneParams) obj;
        GraphQlQueryString fetchMegaphoneQueryString = new FetchMegaphoneQueryString();
        fetchMegaphoneQueryString.m11315a("location", fetchMegaphoneParams.a.toString()).m11315a("img_size", Integer.toString(fetchMegaphoneParams.b)).m11315a("facepile_img_size", Integer.toString(fetchMegaphoneParams.c));
        fetchMegaphoneQueryString.mo1608a(true);
        return fetchMegaphoneQueryString;
    }

    @Inject
    public FetchMegaphoneMethod(GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
    }

    public final Object mo1424a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        return new FetchMegaphoneResult((GraphQLMegaphone) ((ObjectMapper) jsonParser.mo1761a()).mo908a(jsonParser, GraphQLMegaphone.class), DataFreshnessResult.FROM_SERVER, System.currentTimeMillis());
    }

    public final int mo1428b(Object obj, ApiResponse apiResponse) {
        return 2;
    }
}
