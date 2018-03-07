package com.facebook.identitygrowth.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: mCropRectBottom */
public class SaveProfileQuestionMethod implements ApiMethod<SaveProfileQuestionParams, String> {
    public final ApiRequest m18090a(Object obj) {
        SaveProfileQuestionParams saveProfileQuestionParams = (SaveProfileQuestionParams) obj;
        List a = Lists.a();
        if (saveProfileQuestionParams.f11193b != null) {
            a.add(new BasicNameValuePair("action", saveProfileQuestionParams.f11193b));
        }
        if (saveProfileQuestionParams.f11194c != null) {
            a.add(new BasicNameValuePair("logging_session", saveProfileQuestionParams.f11194c));
        }
        if (saveProfileQuestionParams.f11195d != null) {
            a.add(new BasicNameValuePair("page", saveProfileQuestionParams.f11195d));
        } else if (saveProfileQuestionParams.f11197f != null) {
            a.add(new BasicNameValuePair("predefined_option", saveProfileQuestionParams.f11197f));
        } else if (saveProfileQuestionParams.f11198g != null) {
            a.add(new BasicNameValuePair("secondary_option", saveProfileQuestionParams.f11198g));
        }
        if (saveProfileQuestionParams.f11196e != null) {
            a.add(new BasicNameValuePair("privacy", saveProfileQuestionParams.f11196e));
        }
        if (saveProfileQuestionParams.f11192a == null) {
            throw new IllegalArgumentException("Graph API ID param should not be null. Please handle it before pass in");
        }
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "save_profile_question";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = saveProfileQuestionParams.f11192a;
        newBuilder = newBuilder;
        newBuilder.g = a;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        return apiRequestBuilder.C();
    }

    public final Object m18091a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return apiResponse.c().B();
    }
}
