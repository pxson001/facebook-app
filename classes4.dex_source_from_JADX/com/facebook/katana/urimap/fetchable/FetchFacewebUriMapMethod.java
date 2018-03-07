package com.facebook.katana.urimap.fetchable;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.katana.model.UserServerSetting;
import com.facebook.katana.util.FqlQueryBuilderUtils;
import com.facebook.tigon.iface.TigonRequest;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: summary_graphql_text_with_entities */
public class FetchFacewebUriMapMethod implements ApiMethod<Void, String> {
    private final FqlQueryBuilderUtils f1569a;

    @Inject
    public FetchFacewebUriMapMethod(FqlQueryBuilderUtils fqlQueryBuilderUtils) {
        this.f1569a = fqlQueryBuilderUtils;
    }

    public final ApiRequest m1783a(@Nullable Object obj) {
        return new ApiRequest("facewebUriMap", TigonRequest.GET, "fql", ImmutableList.of(new BasicNameValuePair("q", FqlQueryBuilderUtils.m1786a("user_settings", "project='android_faceweb' AND setting='urimap'", this.f1569a.m1787a(UserServerSetting.class)))), ApiResponseType.JSON);
    }

    public final Object m1784a(@Nullable Object obj, ApiResponse apiResponse) {
        return apiResponse.c().b("data").a(0).b("value").s();
    }
}
