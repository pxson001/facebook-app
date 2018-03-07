package com.facebook.messaging.media.upload;

import android.net.Uri;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.JSONUtil;
import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.http.protocol.DataStreamBody;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.upload.util.MediaHashCache;
import com.facebook.messaging.model.attachment.ImageData;
import com.facebook.messaging.model.attachment.VideoData;
import com.facebook.messaging.model.attribution.ContentAppAttribution;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceBody;
import com.facebook.ui.media.attachments.MediaResourceBodyFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: loadVideos */
public class MediaUploadMethod implements ApiMethod<Params, String> {
    private static final AtomicLong f11930g = new AtomicLong(0);
    private final Clock f11931a;
    private final MediaResourceBodyFactory f11932b;
    private final MediaUploadConfig f11933c;
    private final AbstractFbErrorReporter f11934d;
    private final SkipUploadExperimentHelper f11935e;
    private final MediaHashCache f11936f;

    @Immutable
    /* compiled from: loadVideos */
    public class Params {
        public final boolean f11925a;
        public final String f11926b;
        public final MediaResource f11927c;
        public final int f11928d;
        public final Map<String, String> f11929e;

        public Params(MediaResource mediaResource, int i) {
            this(mediaResource, i, false, null);
        }

        public Params(MediaResource mediaResource, int i, boolean z, String str) {
            Object obj;
            boolean z2 = (z && str == null) ? false : true;
            Preconditions.checkState(z2, "Chunked upload used but session id not provided.");
            this.f11927c = mediaResource;
            this.f11928d = i;
            this.f11925a = z;
            this.f11926b = str;
            this.f11929e = Maps.a(mediaResource.w);
            if (mediaResource.e.isQuickCamSource()) {
                String str2 = "selfie_cam";
                this.f11929e.put("camera_position", mediaResource.e == Source.QUICKCAM_BACK ? "back_facing" : "front_facing");
                obj = str2;
            } else {
                obj = mediaResource.e.DBSerialValue;
            }
            this.f11929e.put("image_send_source", obj);
        }
    }

    public static MediaUploadMethod m12499b(InjectorLike injectorLike) {
        return new MediaUploadMethod((Clock) SystemClockMethodAutoProvider.a(injectorLike), MediaResourceBodyFactory.a(injectorLike), MediaUploadConfig.m12479b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), SkipUploadExperimentHelper.a(injectorLike), MediaHashCache.a(injectorLike));
    }

    public final ApiRequest m12500a(Object obj) {
        Params params = (Params) obj;
        MediaResource mediaResource = params.f11927c;
        MediaResourceBody a = this.f11932b.a(mediaResource);
        List a2 = Lists.a();
        Builder builder = ImmutableList.builder();
        if (params.f11925a) {
            builder.c(new BasicNameValuePair("chunked_session_id", params.f11926b));
        } else if (this.f11933c.m12480b(mediaResource)) {
            builder.c(new BasicNameValuePair("external_attachment_url", mediaResource.y.toString()));
            if (mediaResource.z) {
                builder.c(new BasicNameValuePair("skip_attachment_hash_check", "1"));
            } else {
                builder.c(new BasicNameValuePair("external_attachment_sha256_hash", this.f11936f.c(mediaResource)));
            }
        } else {
            a2.add(new FormBodyPart(new StringBuilder(String.valueOf(this.f11931a.a())).append("_").append(String.valueOf(f11930g.getAndIncrement())).toString(), a));
        }
        String str;
        String str2;
        if (mediaResource.d == Type.PHOTO) {
            str = "image_type";
            if (mediaResource.e.isQuickCamSource()) {
                str2 = ImageData.Source.QUICKCAM.apiStringValue;
            } else {
                str2 = ImageData.Source.NONQUICKCAM.apiStringValue;
            }
            builder.c(new BasicNameValuePair(str, str2));
        } else if (mediaResource.d == Type.VIDEO) {
            FormBodyPart a3 = m12498a(mediaResource);
            if (a3 != null) {
                a2.add(a3);
            }
            str = "video_type";
            if (mediaResource.e.isQuickCamSource()) {
                str2 = VideoData.Source.QUICKCAM.apiStringValue;
            } else {
                str2 = VideoData.Source.NONQUICKCAM.apiStringValue;
            }
            builder.c(new BasicNameValuePair(str, str2));
        } else if (mediaResource.d == Type.AUDIO) {
            builder.c(new BasicNameValuePair("audio_type", "VOICE_MESSAGE"));
            builder.c(new BasicNameValuePair("duration", String.valueOf(mediaResource.i)));
        }
        if (this.f11935e.a(mediaResource) && !Strings.isNullOrEmpty(this.f11936f.c(mediaResource))) {
            builder.c(new BasicNameValuePair("media_hash", this.f11936f.c(mediaResource)));
        }
        builder.c(new BasicNameValuePair("extra_logging_data", JSONUtil.a(params.f11929e).toString()));
        ContentAppAttribution contentAppAttribution = mediaResource.x;
        if (contentAppAttribution != null) {
            builder.c(new BasicNameValuePair("attribution_app_id", contentAppAttribution.b));
            if (mediaResource.z) {
                builder.c(new BasicNameValuePair("skip_android_hash_check", "1"));
            } else {
                builder.c(new BasicNameValuePair("android_key_hash", contentAppAttribution.d));
            }
            if (contentAppAttribution.f != null) {
                builder.c(new BasicNameValuePair("attribution_app_metadata", contentAppAttribution.f));
            }
        }
        builder.c(new BasicNameValuePair("render_as_sticker", mediaResource.B ? "1" : "0"));
        builder.c(new BasicNameValuePair("is_voicemail", mediaResource.C ? "1" : "0"));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "media-" + params.f11928d;
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = MediaUploadConfig.m12478a(mediaResource);
        newBuilder = newBuilder;
        newBuilder.g = builder.b();
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        newBuilder = newBuilder;
        newBuilder.l = a2;
        return newBuilder.C();
    }

    @Inject
    public MediaUploadMethod(Clock clock, MediaResourceBodyFactory mediaResourceBodyFactory, MediaUploadConfig mediaUploadConfig, AbstractFbErrorReporter abstractFbErrorReporter, SkipUploadExperimentHelper skipUploadExperimentHelper, MediaHashCache mediaHashCache) {
        this.f11931a = clock;
        this.f11932b = mediaResourceBodyFactory;
        this.f11933c = mediaUploadConfig;
        this.f11934d = abstractFbErrorReporter;
        this.f11935e = skipUploadExperimentHelper;
        this.f11936f = mediaHashCache;
    }

    public final Object m12501a(Object obj, ApiResponse apiResponse) {
        JsonNode c = apiResponse.c();
        if (c.o()) {
            return c.B();
        }
        return JSONUtil.b(c.b("id"));
    }

    private FormBodyPart m12498a(MediaResource mediaResource) {
        Uri uri = mediaResource.f;
        if (uri == null || !Objects.equal(uri.getScheme(), "file")) {
            this.f11934d.a("SendMessageParameterHelper_missing_video_thumbnail", "No thumbnail was set for video");
            return null;
        }
        File file = new File(uri.getPath());
        return new FormBodyPart("video_thumbnail", new DataStreamBody(file, "image/jpeg", file.getName()));
    }
}
