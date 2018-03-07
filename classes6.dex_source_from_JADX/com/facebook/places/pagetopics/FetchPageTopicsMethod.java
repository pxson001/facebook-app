package com.facebook.places.pagetopics;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: formated_price */
public class FetchPageTopicsMethod implements ApiMethod<Long, FetchPageTopicsResult> {
    private static final Class<?> f14736a = FetchPageTopicsMethod.class;
    private Locale f14737b;
    private JsonFactory f14738c;

    public final ApiRequest m22293a(Object obj) {
        Long l = (Long) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("locale", this.f14737b.toString()));
        a.add(new BasicNameValuePair("type", "placetopic"));
        a.add(new BasicNameValuePair("topic_filter", "all"));
        ArrayNode b = JsonNodeFactory.a.b();
        b.h("id");
        b.h("parent_ids");
        b.h("name");
        b.h("count");
        a.add(new BasicNameValuePair("fields", b.toString()));
        a.add(new BasicNameValuePair("topics_version", l.toString()));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "FetchPageTopics";
        newBuilder = newBuilder;
        newBuilder.c = "GET";
        newBuilder = newBuilder;
        newBuilder.d = "search";
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.STRING;
        newBuilder = newBuilder;
        newBuilder.g = a;
        return newBuilder.C();
    }

    @Inject
    public FetchPageTopicsMethod(Locale locale, JsonFactory jsonFactory) {
        this.f14737b = locale;
        this.f14738c = jsonFactory;
    }

    public final Object m22294a(Object obj, ApiResponse apiResponse) {
        FetchPageTopicsResult fetchPageTopicsResult = (FetchPageTopicsResult) this.f14738c.b(apiResponse.b()).a(FetchPageTopicsResult.class);
        fetchPageTopicsResult.m22297a(this.f14737b.toString());
        Preconditions.checkState(fetchPageTopicsResult.m22298b().m22295a() > 0);
        return fetchPageTopicsResult;
    }
}
