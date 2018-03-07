package com.facebook.composer.publish.protocol;

import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: photo_picker_type_ahead_open */
public class PublishPostMethod implements ApiMethod<PublishPostParams, String> {
    private static final Class<?> f8064a = PublishPostMethod.class;
    private final Clock f8065b;
    private final FbObjectMapper f8066c;

    public static PublishPostMethod m11654b(InjectorLike injectorLike) {
        return new PublishPostMethod((Clock) SystemClockMethodAutoProvider.a(injectorLike), FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ Object m11657a(Object obj, ApiResponse apiResponse) {
        return m11653a(apiResponse);
    }

    public static PublishPostMethod m11652a(InjectorLike injectorLike) {
        return m11654b(injectorLike);
    }

    @Inject
    public PublishPostMethod(Clock clock, FbObjectMapper fbObjectMapper) {
        this.f8065b = clock;
        this.f8066c = fbObjectMapper;
    }

    public final ApiRequest m11655a(PublishPostParams publishPostParams) {
        List a = PublishHelper.m11651a(publishPostParams, this.f8065b, this.f8066c);
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
        if (publishPostParams.isPhotoContainer) {
            a.add(new BasicNameValuePair("is_photo_container", "1"));
        }
        if (publishPostParams.a != null) {
            a.add(new BasicNameValuePair("greeting_card", this.f8066c.a(publishPostParams.a)));
        }
        if (publishPostParams.e != null) {
            a.add(new BasicNameValuePair("content_attachment", publishPostParams.e));
        }
        if (publishPostParams.promptAnalytics != null) {
            a.add(new BasicNameValuePair("prompt_id", publishPostParams.promptAnalytics.promptId));
            a.add(new BasicNameValuePair("prompt_type", publishPostParams.promptAnalytics.promptType));
            a.add(new BasicNameValuePair("prompt_tracking_string", publishPostParams.promptAnalytics.trackingString));
        }
        if (publishPostParams.albumId > 0) {
            a.add(new BasicNameValuePair("album_id", this.f8066c.a(Long.valueOf(publishPostParams.albumId))));
        }
        return new ApiRequest("graphObjectPosts", "POST", StringFormatUtil.a("%s/feed", new Object[]{Long.valueOf(publishPostParams.targetId)}), a, ApiResponseType.JSON);
    }

    public static String m11653a(ApiResponse apiResponse) {
        return apiResponse.c().b("id").B();
    }
}
