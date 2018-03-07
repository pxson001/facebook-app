package com.facebook.photos.upload.protocol;

import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.publish.protocol.PublishHelper;
import com.facebook.composer.publish.protocol.TopicFeedsPublishHelper;
import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.entity.mime.apache.content.StringBody;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.http.protocol.DataStreamBody;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.model.CheckinEntryPoint;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.photos.base.tagging.Tag;
import com.facebook.photos.base.tagging.compat.FacebookPhotoTagBase;
import com.facebook.photos.base.tagging.compat.FacebookPhotoWithTag;
import com.facebook.share.model.ComposerAppAttribution;
import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: getAddress */
public class UploadPhotoMethod implements ApiMethod<UploadPhotoParams, Long> {
    private static final Class<?> f14035a = UploadPhotoMethod.class;
    private final Provider<String> f14036b;
    private final Clock f14037c;

    public static UploadPhotoMethod m21752b(InjectorLike injectorLike) {
        return new UploadPhotoMethod(IdBasedProvider.a(injectorLike, 4442), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    public static UploadPhotoMethod m21751a(InjectorLike injectorLike) {
        return m21752b(injectorLike);
    }

    @Inject
    public UploadPhotoMethod(Provider<String> provider, Clock clock) {
        this.f14036b = provider;
        this.f14037c = clock;
    }

    private ApiRequest m21750a(UploadPhotoParams uploadPhotoParams) {
        Object n;
        Object formBodyPart;
        Builder c = ImmutableList.builder().c(new BasicNameValuePair("published", Boolean.toString(false)));
        if (uploadPhotoParams.m21826o()) {
            n = uploadPhotoParams.m21825n();
            if (!StringUtil.a(n)) {
                c.c(new BasicNameValuePair("caption", n));
            }
        }
        n = uploadPhotoParams.m21817f();
        if (!StringUtil.a(n)) {
            c.c(new BasicNameValuePair("profile_id", n));
        }
        n = uploadPhotoParams.m21819h();
        if (!StringUtil.a(n)) {
            c.c(new BasicNameValuePair("place", n));
        }
        if (uploadPhotoParams.m21822k() == RedSpaceValue.POST_TO_REDSPACE) {
            c.c(new BasicNameValuePair("posting_to_redspace", uploadPhotoParams.m21822k().toApiString()));
        }
        if (uploadPhotoParams.m21823l()) {
            c.c(new BasicNameValuePair("allow_spherical_photo", "true"));
        }
        n = uploadPhotoParams.m21824m();
        if (!StringUtil.a(n)) {
            c.c(new BasicNameValuePair("spherical_metadata", n));
        }
        n = uploadPhotoParams.m21820i();
        if (!StringUtil.a(n)) {
            c.c(new BasicNameValuePair("text_only_place", n));
        }
        c.c(new BasicNameValuePair("checkin_entry_point", CheckinEntryPoint.a(uploadPhotoParams.m21821j())));
        c.c(new BasicNameValuePair("is_explicit_location", String.valueOf(uploadPhotoParams.m21804K())));
        if (uploadPhotoParams.m21800G()) {
            int i;
            ImmutableList z = uploadPhotoParams.m21834z();
            ImmutableList y = uploadPhotoParams.m21833y();
            List a = Lists.a();
            if (z != null) {
                int size = z.size();
                for (i = 0; i < size; i++) {
                    a.add((Tag) z.get(i));
                }
            }
            if (y != null) {
                int size2 = y.size();
                for (i = 0; i < size2; i++) {
                    a.add(new FacebookPhotoWithTag(((Long) y.get(i)).longValue()));
                }
            }
            if (!a.isEmpty()) {
                c.c(new BasicNameValuePair("tags", FacebookPhotoTagBase.m20177a(a)));
            }
        } else {
            ImmutableList z2 = uploadPhotoParams.m21834z();
            if (!(z2 == null || z2.isEmpty())) {
                c.c(new BasicNameValuePair("tags", FacebookPhotoTagBase.m20177a(z2)));
            }
        }
        c.b(uploadPhotoParams.m21794A().a());
        PhotoUploadPrivacy p = uploadPhotoParams.m21827p();
        if (!StringUtil.a(p.f14024e)) {
            c.c(new BasicNameValuePair("privacy", p.f14024e));
        }
        c.c(new BasicNameValuePair("audience_exp", Boolean.TRUE.toString()));
        long H = uploadPhotoParams.m21801H();
        if (H != 0) {
            c.c(new BasicNameValuePair("time_since_original_post", String.valueOf(Math.max((this.f14037c.a() / 1000) - H, 0))));
        }
        String B = uploadPhotoParams.m21795B();
        if (!StringUtil.a(B)) {
            c.c(new BasicNameValuePair("qn", B));
            c.c(new BasicNameValuePair("composer_session_id", B));
        }
        n = uploadPhotoParams.m21796C();
        if (!StringUtil.a(n)) {
            c.c(new BasicNameValuePair("idempotence_token", n));
        }
        int D = uploadPhotoParams.m21797D();
        if (D != 0) {
            c.c(new BasicNameValuePair("orientation", String.valueOf(D)));
        }
        boolean q = uploadPhotoParams.m21828q();
        boolean z3 = uploadPhotoParams.m21831v() != 0;
        if (q) {
            String r = uploadPhotoParams.m21829r();
            c.c(new BasicNameValuePair("vault_image_id", r));
            formBodyPart = new FormBodyPart("vault_image_id", new StringBody(r, Charsets.UTF_8));
        } else if (Strings.isNullOrEmpty(uploadPhotoParams.ab())) {
            n = uploadPhotoParams.m21812b();
            if (z3) {
                n = uploadPhotoParams.m21815d();
            }
            if (StringUtil.a(n)) {
                throw new FileNotFoundException("UploadPhotoMethod: file not specified");
            }
            File file = new File(n);
            r1 = new FormBodyPart("source", new DataStreamBody(file, "image/jpeg", file.getName()));
        } else {
            c.c(new BasicNameValuePair("sync_object_uuid", uploadPhotoParams.ab()));
            r1 = new FormBodyPart("sync_object_uuid", new StringBody(uploadPhotoParams.ab(), Charsets.UTF_8));
        }
        if (z3) {
            c.c(new BasicNameValuePair("is_full_res", "true"));
        } else if (uploadPhotoParams.m21830u()) {
            c.c(new BasicNameValuePair("full_res_is_coming_later", "true"));
        }
        B = "me/photos";
        if (z3) {
            B = Long.toString(uploadPhotoParams.m21831v());
        } else {
            ViewerContext F = uploadPhotoParams.m21799F();
            if (F != null && F.d()) {
                B = StringFormatUtil.a("%s/photos", new Object[]{F.a()});
                c.c(new BasicNameValuePair("temporary", Boolean.toString(true)));
            }
        }
        ComposerAppAttribution I = uploadPhotoParams.m21802I();
        if (I != null) {
            c.c(new BasicNameValuePair("proxied_app_id", I.m7689a()));
            c.c(new BasicNameValuePair("proxied_app_name", I.m7690b()));
            c.c(new BasicNameValuePair("android_key_hash", I.m7691c()));
            c.c(new BasicNameValuePair("user_selected_tags", String.valueOf(uploadPhotoParams.m21803J())));
            c.c(new BasicNameValuePair("user_selected_place", String.valueOf(uploadPhotoParams.m21804K())));
            c.c(new BasicNameValuePair("attribution_app_id", I.m7689a()));
            if (!Strings.isNullOrEmpty(I.m7692d())) {
                c.c(new BasicNameValuePair("attribution_app_metadata", I.m7692d()));
            }
        }
        Object T = uploadPhotoParams.m21806T();
        if (!StringUtil.a(T)) {
            c.c(new BasicNameValuePair("source_type", T));
        }
        TopicFeedsPublishHelper.m11663a(uploadPhotoParams.aa(), c);
        if (uploadPhotoParams.ad()) {
            c.c(new BasicNameValuePair("post_surfaces_blacklist", JSONUtil.b(PublishHelper.f8063a).toString()));
        }
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "upload-photo";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = B;
        ApiRequestBuilder apiRequestBuilder = newBuilder;
        apiRequestBuilder.k = ApiResponseType.JSON;
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.l = ImmutableList.of(formBodyPart);
        apiRequestBuilder = apiRequestBuilder;
        apiRequestBuilder.g = c.b();
        return apiRequestBuilder.C();
    }

    public final Object m21754a(Object obj, ApiResponse apiResponse) {
        return Long.valueOf(JSONUtil.c(apiResponse.c().b("id")));
    }
}
