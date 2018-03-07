package com.facebook.graphql.executor;

import com.facebook.common.json.JsonFactoryMethodAutoProvider;
import com.facebook.graphql.executor.GraphQLBatchRequest.EndpointScheduler;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.http.common.RequestIdempotency;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.Lists;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: requiredNetwork */
public class GenericGraphQLBatchMethod implements ApiMethod<GraphQLBatchRequest, Void> {
    private final GraphQLResponseParser f7228a;
    private final GraphQLProtocolHelper f7229b;
    private final JsonFactory f7230c;

    public static GenericGraphQLBatchMethod m11701b(InjectorLike injectorLike) {
        return new GenericGraphQLBatchMethod(JsonFactoryMethodAutoProvider.m8062a(injectorLike), GraphQLProtocolHelper.m9427a(injectorLike), GraphQLResponseParser.m11711b(injectorLike));
    }

    public final ApiRequest mo672a(Object obj) {
        GraphQLBatchRequest graphQLBatchRequest = (GraphQLBatchRequest) obj;
        TracerDetour.a("GenericGraphQLBatchMethod.getRequest", 2037134431);
        try {
            String c;
            Writer stringWriter = new StringWriter();
            JsonGenerator a = this.f7230c.m7159a(stringWriter);
            a.mo1134f();
            for (GraphQLRequest graphQLRequest : graphQLBatchRequest.f6471b) {
                if (!graphQLBatchRequest.m11227d(graphQLRequest)) {
                    a.m7714g(graphQLRequest.m11600a());
                    a.mo1658a("query_id", graphQLRequest.m11605b().m11327f());
                    if (graphQLBatchRequest.m11223b() == EndpointScheduler.PHASED) {
                        a.mo1658a("priority", String.valueOf(graphQLRequest.m11608e()));
                    }
                    String a2 = GraphQLProtocolHelper.m9429a(graphQLRequest.m11607d());
                    if (a2 != null) {
                        a.mo1115a("query_params");
                        a.mo1131d(a2);
                    }
                    a2 = this.f7229b.m9440b(graphQLRequest.m11607d());
                    if (a2 != null) {
                        a.mo1115a("ref_params");
                        a.mo1131d(a2);
                    }
                    c = this.f7229b.m9442c(graphQLRequest.m11607d());
                    if (c != null) {
                        a.mo1115a("rerun_param");
                        a.mo1131d(c);
                    }
                    a.mo1136g();
                }
            }
            a.mo1136g();
            a.flush();
            c = stringWriter.toString();
            List a3 = Lists.m1296a();
            a3.add(new BasicNameValuePair("queries", c));
            a3.add(new BasicNameValuePair("method", "get"));
            EndpointScheduler b = graphQLBatchRequest.m11223b();
            if (!(b == null || b == EndpointScheduler.UNSPECIFIED)) {
                a3.add(new BasicNameValuePair("scheduler", graphQLBatchRequest.m11223b().schedulerName));
            }
            GraphQLProtocolHelper.m9432a(a3);
            GraphQLProtocolHelper.m9434b(a3);
            if (graphQLBatchRequest.m11222a()) {
                GraphQLProtocolHelper.m9435c(a3);
            }
            if (graphQLBatchRequest.m11230g() != null) {
                a3.add(new BasicNameValuePair("batch_name", graphQLBatchRequest.m11230g()));
            }
            ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
            if (graphQLBatchRequest.m11230g() != null) {
                c = graphQLBatchRequest.m11230g();
            } else {
                c = "GraphQLBatchRequest";
            }
            ApiRequest C = newBuilder.m12132a(c).m12137c("POST").m12138d("graphqlbatch").m12133a(a3).m12141h(graphQLBatchRequest.m11231i()).m12140g(graphQLBatchRequest.m11232j()).m12129a(m11700a(graphQLBatchRequest)).m12127a(RequestIdempotency.RETRY_SAFE).m12125C();
            return C;
        } finally {
            TracerDetour.a(-588519413);
        }
    }

    public final Object mo673a(Object obj, ApiResponse apiResponse) {
        GraphQLBatchRequest graphQLBatchRequest = (GraphQLBatchRequest) obj;
        TracerDetour.a("GenericGraphQLBatchMethod.parseResponse", 1068886921);
        try {
            Object f = apiResponse.m22208f();
            if (f instanceof InputStream) {
                f = this.f7228a.m11716a(apiResponse.m22207e(), graphQLBatchRequest);
            } else if (f instanceof JsonParser) {
                f = this.f7228a.m11715a(apiResponse.m22206d(), graphQLBatchRequest);
                TracerDetour.a(1597486798);
            } else {
                throw new RuntimeException("responseObject should either be JsonParser or InputStream");
            }
            return f;
        } finally {
            TracerDetour.a(1991658412);
        }
    }

    @Inject
    public GenericGraphQLBatchMethod(JsonFactory jsonFactory, GraphQLProtocolHelper graphQLProtocolHelper, GraphQLResponseParser graphQLResponseParser) {
        this.f7230c = jsonFactory;
        this.f7229b = graphQLProtocolHelper;
        this.f7228a = graphQLResponseParser;
    }

    public static GenericGraphQLBatchMethod m11699a(InjectorLike injectorLike) {
        return m11701b(injectorLike);
    }

    private static ApiResponseType m11700a(GraphQLBatchRequest graphQLBatchRequest) {
        return graphQLBatchRequest.f6476g ? ApiResponseType.FLATBUFFER : ApiResponseType.JSONPARSER;
    }
}
