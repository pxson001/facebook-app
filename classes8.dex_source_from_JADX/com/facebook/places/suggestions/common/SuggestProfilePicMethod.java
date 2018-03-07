package com.facebook.places.suggestions.common;

import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.http.protocol.DataStreamBody;
import com.facebook.photos.base.media.PhotoItem;
import com.google.common.collect.Lists;
import java.io.File;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: search_text */
public class SuggestProfilePicMethod implements ApiMethod<SuggestProfilePicParams, Boolean> {
    public final ApiRequest m3675a(Object obj) {
        SuggestProfilePicParams suggestProfilePicParams = (SuggestProfilePicParams) obj;
        PhotoItem photoItem = suggestProfilePicParams.f3797b;
        File file = new File(photoItem.e());
        FormBodyPart formBodyPart = new FormBodyPart("file", new DataStreamBody(file, photoItem.i(), file.getName()));
        List a = Lists.a();
        if (suggestProfilePicParams.f3798c != null) {
            a.add(new BasicNameValuePair("source", suggestProfilePicParams.f3798c));
        }
        if (suggestProfilePicParams.f3799d != null) {
            a.add(new BasicNameValuePair("entry_point", suggestProfilePicParams.f3799d.getFullName()));
        }
        if (suggestProfilePicParams.f3800e != null) {
            a.add(new BasicNameValuePair("end_point", suggestProfilePicParams.f3800e.getFullName()));
        }
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "page-profile-suggestion-upload";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = StringFormatUtil.formatStrLocaleSafe("%d/suggestions", Long.valueOf(suggestProfilePicParams.f3796a));
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.l = Lists.a(new FormBodyPart[]{formBodyPart});
        return apiRequestBuilder.C();
    }

    public final Object m3676a(Object obj, ApiResponse apiResponse) {
        apiResponse.c();
        return Boolean.valueOf(true);
    }
}
