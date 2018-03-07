package com.facebook.composer.publish.protocol;

import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.time.Clock;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.google.common.base.Preconditions;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: photo_picker_swipes_to_right_count */
public class PublishShareMethod implements ApiMethod<PublishPostParams, String> {
    private static final Class<?> f8067a = PublishShareMethod.class;
    private final Clock f8068b;
    private final FbObjectMapper f8069c;

    public final ApiRequest m11658a(Object obj) {
        PublishPostParams publishPostParams = (PublishPostParams) obj;
        Preconditions.checkArgument(publishPostParams.targetId > 0);
        Preconditions.checkNotNull(publishPostParams.shareable);
        Preconditions.checkNotNull(publishPostParams.shareable.d());
        List a = PublishHelper.m11651a(publishPostParams, this.f8068b, this.f8069c);
        a.add(new BasicNameValuePair("id", String.valueOf(publishPostParams.shareable.d())));
        a.add(new BasicNameValuePair("to", String.valueOf(publishPostParams.targetId)));
        if (!StringUtil.a(publishPostParams.tracking)) {
            a.add(new BasicNameValuePair("tracking", publishPostParams.tracking));
        }
        if (publishPostParams.name != null) {
            a.add(new BasicNameValuePair("name", publishPostParams.name));
        }
        if (publishPostParams.caption != null) {
            a.add(new BasicNameValuePair("caption", publishPostParams.caption));
        }
        if (publishPostParams.description != null) {
            a.add(new BasicNameValuePair("description", publishPostParams.description));
        }
        if (publishPostParams.picture != null) {
            a.add(new BasicNameValuePair("picture", publishPostParams.picture));
        }
        if (publishPostParams.isThrowbackPost) {
            a.add(new BasicNameValuePair("is_throwback_post", String.valueOf(publishPostParams.isThrowbackPost)));
        }
        if (publishPostParams.reshareOriginalPost) {
            a.add(new BasicNameValuePair("reshare_original_post", String.valueOf(publishPostParams.reshareOriginalPost)));
        }
        return new ApiRequest("graphObjectShare", "POST", "sharedposts", a, ApiResponseType.JSON);
    }

    @Inject
    public PublishShareMethod(Clock clock, FbObjectMapper fbObjectMapper) {
        this.f8068b = clock;
        this.f8069c = fbObjectMapper;
    }

    public final Object m11659a(Object obj, ApiResponse apiResponse) {
        return apiResponse.c().b("id").B();
    }
}
