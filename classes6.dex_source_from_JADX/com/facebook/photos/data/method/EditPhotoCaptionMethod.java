package com.facebook.photos.data.method;

import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.tagging.graphql.utils.MentionsUtils;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: iframeinterval */
public class EditPhotoCaptionMethod implements ApiMethod<EditPhotoCaptionParams, Boolean> {
    private static final Class<?> f12922a = EditPhotoCaptionMethod.class;

    public static EditPhotoCaptionMethod m20300a(InjectorLike injectorLike) {
        return new EditPhotoCaptionMethod();
    }

    public final ApiRequest m20301a(Object obj) {
        EditPhotoCaptionParams editPhotoCaptionParams = (EditPhotoCaptionParams) obj;
        List a = Lists.a();
        DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields = editPhotoCaptionParams.f12924b;
        a.add(new BasicNameValuePair("name", defaultTextWithEntitiesLongFields == null ? " " : MentionsUtils.m25501a(defaultTextWithEntitiesLongFields)));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = f12922a.toString();
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = editPhotoCaptionParams.f12923a;
        newBuilder = newBuilder;
        newBuilder.g = a;
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        return newBuilder.C();
    }

    public final Object m20302a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(apiResponse.c().F());
    }
}
