package com.facebook.timeline.aboutpage;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: NEWSFEED_LARGE_IMAGE_LOCATION */
public class ProfileExperienceDeleteMethod implements ApiMethod<ProfileExperienceDeleteParams, Boolean> {
    public static ProfileExperienceDeleteMethod m13820a(InjectorLike injectorLike) {
        return new ProfileExperienceDeleteMethod();
    }

    public final ApiRequest m13821a(Object obj) {
        ProfileExperienceDeleteParams profileExperienceDeleteParams = (ProfileExperienceDeleteParams) obj;
        List a = Lists.a();
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("profileExperienceDelete", "DELETE", profileExperienceDeleteParams.f13050a, a, ApiResponseType.JSON);
    }

    public final Object m13822a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(true);
    }
}
