package com.facebook.photos.data.method;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.method.ModifyAlbumContributorParams.ModifyContributorOperationType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: i18n_post_search_expansion */
public class ModifyAlbumContributorMethod implements ApiMethod<ModifyAlbumContributorParams, Boolean> {
    public static ModifyAlbumContributorMethod m20318a(InjectorLike injectorLike) {
        return new ModifyAlbumContributorMethod();
    }

    public final ApiRequest m20319a(Object obj) {
        ModifyAlbumContributorParams modifyAlbumContributorParams = (ModifyAlbumContributorParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        for (int i = 0; i < modifyAlbumContributorParams.f12949a.size(); i++) {
            a.add(new BasicNameValuePair(StringFormatUtil.a("contributors[%d]", new Object[]{Integer.valueOf(i)}), String.valueOf(modifyAlbumContributorParams.f12949a.get(i))));
        }
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "addContributors";
        newBuilder = newBuilder;
        newBuilder.d = modifyAlbumContributorParams.f12950b + "/contributors";
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        newBuilder = newBuilder;
        newBuilder.g = a;
        newBuilder = newBuilder;
        if (modifyAlbumContributorParams.f12951c == ModifyContributorOperationType.ADD_OPERATION) {
            newBuilder.c = "POST";
        } else {
            newBuilder.c = "DELETE";
        }
        return newBuilder.C();
    }

    public final Object m20320a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(true);
    }
}
