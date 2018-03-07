package com.facebook.privacy.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: sticker_store_edit */
public class EditReviewPrivacyMethod implements ApiMethod<EditReviewPrivacyParams, String> {
    public final ApiRequest m6033a(Object obj) {
        EditReviewPrivacyParams editReviewPrivacyParams = (EditReviewPrivacyParams) obj;
        Preconditions.checkNotNull(editReviewPrivacyParams);
        Preconditions.checkNotNull(editReviewPrivacyParams.f4134b);
        Preconditions.checkArgument(editReviewPrivacyParams.f4133a > 0);
        List a = Lists.a();
        a.add(new BasicNameValuePair("privacy", editReviewPrivacyParams.f4134b));
        a.add(new BasicNameValuePair("return_type", "CONTACT_RECOMMENDATION_FIELD"));
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("editRatingPrivacy", "POST", editReviewPrivacyParams.f4133a + "/open_graph_ratings_privacy", a, ApiResponseType.JSON);
    }

    public final Object m6034a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return apiResponse.c().b("result").B();
    }
}
