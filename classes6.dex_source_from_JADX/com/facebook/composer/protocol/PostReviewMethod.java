package com.facebook.composer.protocol;

import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: placeId */
public class PostReviewMethod implements ApiMethod<PostReviewParams, String> {
    public static PostReviewMethod m11490a(InjectorLike injectorLike) {
        return new PostReviewMethod();
    }

    public final ApiRequest m11491a(Object obj) {
        PostReviewParams postReviewParams = (PostReviewParams) obj;
        boolean z = true;
        List a = Lists.a();
        Preconditions.checkNotNull(postReviewParams);
        Preconditions.checkNotNull(postReviewParams.f7936d);
        Preconditions.checkNotNull(postReviewParams.f7939g);
        Preconditions.checkNotNull(postReviewParams.f7938f);
        Preconditions.checkArgument(postReviewParams.f7934b > 0);
        if (postReviewParams.f7937e <= 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        a.add(new BasicNameValuePair("rating", String.valueOf(postReviewParams.f7937e)));
        a.add(new BasicNameValuePair("review", postReviewParams.f7935c));
        a.add(new BasicNameValuePair("privacy", postReviewParams.f7936d.c()));
        a.add(new BasicNameValuePair("surface", postReviewParams.f7939g.toString()));
        a.add(new BasicNameValuePair("mechanism", postReviewParams.f7938f.toString()));
        a.add(new BasicNameValuePair("return_type", "CONTACT_RECOMMENDATION_FIELD"));
        a.add(new BasicNameValuePair("photo_count", String.valueOf(postReviewParams.f7941i)));
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("postRating", "POST", postReviewParams.f7934b + "/open_graph_ratings", a, ApiResponseType.JSON);
    }

    public final Object m11492a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return apiResponse.c().b("id").B();
    }
}
