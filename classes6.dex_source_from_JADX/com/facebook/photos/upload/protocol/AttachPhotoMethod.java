package com.facebook.photos.upload.protocol;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.publish.protocol.PublishHelper;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: getPlaceTypes */
public class AttachPhotoMethod implements ApiMethod<AttachPhotoParam, String> {
    private final Clock f13964a;

    public static AttachPhotoMethod m21685a(InjectorLike injectorLike) {
        return new AttachPhotoMethod((Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    public final ApiRequest m21686a(Object obj) {
        AttachPhotoParam attachPhotoParam = (AttachPhotoParam) obj;
        Builder builder = ImmutableList.builder();
        if (attachPhotoParam.f13986v == PublishMode.NORMAL) {
            builder.c(new BasicNameValuePair("published", "1"));
        } else {
            builder.c(new BasicNameValuePair("published", "0"));
            builder.c(new BasicNameValuePair("unpublished_content_type", attachPhotoParam.f13986v.getContentType()));
            if (attachPhotoParam.f13987w != 0) {
                builder.c(new BasicNameValuePair("scheduled_publish_time", String.valueOf(attachPhotoParam.f13987w)));
            }
        }
        if (attachPhotoParam.f13966b != null) {
            builder.c(new BasicNameValuePair("target_post", attachPhotoParam.f13966b));
            if (attachPhotoParam.f13967c != null) {
                builder.c(new BasicNameValuePair("profile_id", attachPhotoParam.f13967c));
            }
        } else if (attachPhotoParam.f13967c != null) {
            builder.c(new BasicNameValuePair("target", attachPhotoParam.f13967c));
        }
        if (attachPhotoParam.f13968d != null) {
            builder.c(new BasicNameValuePair("qn", attachPhotoParam.f13968d));
            builder.c(new BasicNameValuePair("composer_session_id", attachPhotoParam.f13968d));
        }
        if (attachPhotoParam.f13970f != null) {
            builder.c(new BasicNameValuePair("place", attachPhotoParam.f13970f));
        }
        if (attachPhotoParam.f13971g != null) {
            builder.c(new BasicNameValuePair("text_only_place", attachPhotoParam.f13971g));
        }
        if (attachPhotoParam.f13972h != null) {
            builder.c(new BasicNameValuePair("tags", attachPhotoParam.f13972h));
        }
        if (attachPhotoParam.f13973i != null) {
            builder.c(new BasicNameValuePair("name", attachPhotoParam.f13973i));
        }
        if (attachPhotoParam.f13969e != null) {
            builder.c(new BasicNameValuePair("idempotence_token", attachPhotoParam.f13969e));
        }
        builder.c(new BasicNameValuePair("is_explicit_location", String.valueOf(attachPhotoParam.f13983s)));
        if (attachPhotoParam.f13974j != null) {
            builder.b(attachPhotoParam.f13974j.a());
        }
        if (attachPhotoParam.f13984t != 0) {
            builder.c(new BasicNameValuePair("time_since_original_post", String.valueOf(Math.max((this.f13964a.a() / 1000) - attachPhotoParam.f13984t, 0))));
        }
        if (!Strings.isNullOrEmpty(attachPhotoParam.f13975k)) {
            builder.c(new BasicNameValuePair("stickers", attachPhotoParam.f13975k));
        }
        if (!Strings.isNullOrEmpty(attachPhotoParam.f13976l)) {
            builder.c(new BasicNameValuePair("text_overlay", attachPhotoParam.f13976l));
        }
        if (attachPhotoParam.f13977m) {
            builder.c(new BasicNameValuePair("is_cropped", Boolean.toString(true)));
        }
        if (attachPhotoParam.f13978n) {
            builder.c(new BasicNameValuePair("is_rotated", Boolean.toString(true)));
        }
        if (attachPhotoParam.f13979o) {
            builder.c(new BasicNameValuePair("is_filtered", Boolean.toString(true)));
        }
        builder.c(new BasicNameValuePair("batch_size", Integer.toString(attachPhotoParam.f13985u)));
        builder.c(new BasicNameValuePair("audience_exp", Boolean.TRUE.toString()));
        if (attachPhotoParam.f13981q == RedSpaceValue.POST_TO_REDSPACE) {
            builder.c(new BasicNameValuePair("posting_to_redspace", attachPhotoParam.f13981q.toApiString()));
        }
        if (!StringUtil.a(attachPhotoParam.f13982r)) {
            builder.c(new BasicNameValuePair("feed_topics", attachPhotoParam.f13982r));
        }
        if (attachPhotoParam.f13988x) {
            builder.c(new BasicNameValuePair("post_surfaces_blacklist", JSONUtil.b(PublishHelper.f8063a).toString()));
        }
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "attachPhoto";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = attachPhotoParam.f13965a;
        newBuilder = newBuilder;
        newBuilder.g = builder.b();
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.STRING;
        return apiRequestBuilder.C();
    }

    @Inject
    public AttachPhotoMethod(Clock clock) {
        this.f13964a = clock;
    }

    public final Object m21687a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return apiResponse.b();
    }
}
