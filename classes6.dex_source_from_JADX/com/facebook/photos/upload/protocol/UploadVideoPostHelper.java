package com.facebook.photos.upload.protocol;

import android.os.Bundle;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.time.Clock;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.publish.protocol.PublishHelper;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.ipc.composer.model.CheckinEntryPoint;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.media.upload.MediaAttachementBody;
import com.facebook.share.model.ComposerAppAttribution;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: gallery */
public class UploadVideoPostHelper {
    public static void m21881a(Builder<NameValuePair> builder, ApiRequestBuilder apiRequestBuilder, UploadVideoChunkPostParams uploadVideoChunkPostParams, Clock clock, FbObjectMapper fbObjectMapper) {
        if (!StringUtil.a(uploadVideoChunkPostParams.f14154d)) {
            builder.c(new BasicNameValuePair("description", uploadVideoChunkPostParams.f14154d));
        }
        if (uploadVideoChunkPostParams.f14155e > 0) {
            builder.c(new BasicNameValuePair("place", Long.toString(uploadVideoChunkPostParams.f14155e)));
        }
        if (!StringUtil.a(uploadVideoChunkPostParams.f14156f)) {
            builder.c(new BasicNameValuePair("text_only_place", uploadVideoChunkPostParams.f14156f));
        }
        if (uploadVideoChunkPostParams.f14158h == RedSpaceValue.POST_TO_REDSPACE) {
            builder.c(new BasicNameValuePair("posting_to_redspace", uploadVideoChunkPostParams.f14158h.toApiString()));
        }
        builder.c(new BasicNameValuePair("checkin_entry_point", CheckinEntryPoint.a(uploadVideoChunkPostParams.f14157g)));
        PhotoUploadPrivacy photoUploadPrivacy = uploadVideoChunkPostParams.f14159i;
        if (!StringUtil.a(photoUploadPrivacy.f14024e)) {
            builder.c(new BasicNameValuePair("privacy", photoUploadPrivacy.f14024e));
        }
        builder.c(new BasicNameValuePair("audience_exp", Boolean.TRUE.toString()));
        if (!uploadVideoChunkPostParams.f14161k.isEmpty()) {
            builder.c(new BasicNameValuePair("tags", m21880a((List) uploadVideoChunkPostParams.f14161k)));
        }
        if (uploadVideoChunkPostParams.f14164n != 0) {
            builder.c(new BasicNameValuePair("time_since_original_post", Long.toString(Math.max((clock.a() / 1000) - uploadVideoChunkPostParams.f14164n, 0))));
        }
        builder.b(uploadVideoChunkPostParams.f14162l.a());
        String str = uploadVideoChunkPostParams.f14163m;
        if (!StringUtil.a(str)) {
            builder.c(new BasicNameValuePair("composer_session_id", str));
        }
        str = uploadVideoChunkPostParams.f14171u;
        if (!StringUtil.a(str)) {
            builder.c(new BasicNameValuePair("source_type", str));
        }
        str = uploadVideoChunkPostParams.f14172v;
        if (!StringUtil.a(str)) {
            builder.c(new BasicNameValuePair("creator_product", str));
        }
        builder.c(new BasicNameValuePair("is_looping", String.valueOf(uploadVideoChunkPostParams.f14173w)));
        builder.c(new BasicNameValuePair("target", Long.toString(uploadVideoChunkPostParams.f14160j)));
        builder.c(new BasicNameValuePair("published", String.valueOf(uploadVideoChunkPostParams.f14165o)));
        if (uploadVideoChunkPostParams.f14166p > 0) {
            builder.c(new BasicNameValuePair("scheduled_publish_time", Long.toString(uploadVideoChunkPostParams.f14166p)));
        }
        ComposerAppAttribution composerAppAttribution = uploadVideoChunkPostParams.f14168r;
        if (composerAppAttribution != null) {
            builder.c(new BasicNameValuePair("proxied_app_id", composerAppAttribution.m7689a()));
            builder.c(new BasicNameValuePair("proxied_app_name", composerAppAttribution.m7690b()));
            builder.c(new BasicNameValuePair("android_key_hash", composerAppAttribution.m7691c()));
            builder.c(new BasicNameValuePair("user_selected_tags", String.valueOf(uploadVideoChunkPostParams.f14169s)));
            builder.c(new BasicNameValuePair("user_selected_place", String.valueOf(uploadVideoChunkPostParams.f14170t)));
        }
        if (uploadVideoChunkPostParams.f14167q != null) {
            builder.c(new BasicNameValuePair("product_item", fbObjectMapper.a(uploadVideoChunkPostParams.f14167q)));
        }
        if (uploadVideoChunkPostParams.f14174x != null) {
            if (uploadVideoChunkPostParams.f14174x.equals("moments_video")) {
                Preconditions.checkNotNull(uploadVideoChunkPostParams.f14147C, "Moments video uuid must be set before uploading!");
                builder.c(new BasicNameValuePair("custom_type", "moments_video"));
                builder.c(new BasicNameValuePair("custom_properties[moments_video_uuid]", uploadVideoChunkPostParams.f14147C));
            } else if (uploadVideoChunkPostParams.f14174x.equals("live_video")) {
                builder.c(new BasicNameValuePair("custom_type", uploadVideoChunkPostParams.f14174x));
                Preconditions.checkNotNull(uploadVideoChunkPostParams.f14152H, "Live video broadcast id must be set before uploading!");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("live_broadcast_id", uploadVideoChunkPostParams.f14152H);
                builder.c(new BasicNameValuePair("custom_properties", jSONObject.toString()));
            } else {
                builder.c(new BasicNameValuePair("custom_type", uploadVideoChunkPostParams.f14174x));
                Bundle bundle = uploadVideoChunkPostParams.f14145A;
                JSONObject jSONObject2 = new JSONObject();
                if (uploadVideoChunkPostParams.f14175y != null) {
                    jSONObject2.put("profile_photo_method", uploadVideoChunkPostParams.f14175y);
                }
                if (bundle != null) {
                    int i = bundle.getInt("frame_offset", -1);
                    if (i != -1) {
                        jSONObject2.put("frame_offset", i);
                    }
                }
                jSONObject2.put("expiration_time", String.valueOf(uploadVideoChunkPostParams.f14176z));
                if (uploadVideoChunkPostParams.f14146B != null) {
                    jSONObject2.put("image_overlay_id", uploadVideoChunkPostParams.f14146B);
                }
                builder.c(new BasicNameValuePair("custom_properties", jSONObject2.toString()));
                MediaAttachementBody a = m21879a(uploadVideoChunkPostParams);
                if (a != null) {
                    apiRequestBuilder.l = ImmutableList.of(a.m18846a());
                }
            }
        }
        if (uploadVideoChunkPostParams.f14148D != null) {
            builder.c(new BasicNameValuePair("container_type", uploadVideoChunkPostParams.f14148D));
        }
        if (uploadVideoChunkPostParams.f14150F != null) {
            builder.b(new NameValuePair[]{new BasicNameValuePair("prompt_id", uploadVideoChunkPostParams.f14150F.promptId), new BasicNameValuePair("prompt_type", uploadVideoChunkPostParams.f14150F.promptType), new BasicNameValuePair("prompt_tracking_string", uploadVideoChunkPostParams.f14150F.trackingString)});
        }
        if (uploadVideoChunkPostParams.f14151G) {
            builder.c(new BasicNameValuePair("post_surfaces_blacklist", JSONUtil.b(PublishHelper.f8063a).toString()));
        }
    }

    public static String m21880a(List<?> list) {
        JSONArray jSONArray = new JSONArray();
        for (Object put : list) {
            jSONArray.put(put);
        }
        return jSONArray.toString();
    }

    public static MediaAttachementBody m21879a(UploadVideoChunkPostParams uploadVideoChunkPostParams) {
        if (uploadVideoChunkPostParams.f14174x == null || uploadVideoChunkPostParams.f14174x.equals("moments_video")) {
            return null;
        }
        Bundle bundle = uploadVideoChunkPostParams.f14145A;
        if (bundle == null) {
            return null;
        }
        byte[] byteArray = bundle.getByteArray("thumbnail_bitmap");
        if (byteArray != null) {
            return new MediaAttachementBody("thumb", byteArray, "image/png", "thumbnail.jpg");
        }
        return null;
    }
}
