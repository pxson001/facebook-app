package com.facebook.photos.upload.protocol;

import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Joiner;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: getLatLng */
public class PublishPhotoMethod implements ApiMethod<UploadPhotoParams, Long> {
    private static final Class<?> f14026a = PublishPhotoMethod.class;
    private final Provider<String> f14027b;
    private final Clock f14028c;
    private final CreativeEditingPhotoUploadHelper f14029d;

    public static PublishPhotoMethod m21732a(InjectorLike injectorLike) {
        return new PublishPhotoMethod(IdBasedProvider.a(injectorLike, 4442), (Clock) SystemClockMethodAutoProvider.a(injectorLike), CreativeEditingPhotoUploadHelper.m21691a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.facebook.http.protocol.ApiRequest m21734a(java.lang.Object r13) {
        /*
        r12 = this;
        r13 = (com.facebook.photos.upload.protocol.UploadPhotoParams) r13;
        r8 = 0;
        r5 = 1;
        r0 = com.google.common.collect.ImmutableList.builder();
        r10 = r13.f14090H;
        r1 = r10;
        r2 = com.facebook.ipc.composer.model.PublishMode.NORMAL;
        if (r1 != r2) goto L_0x037d;
    L_0x0010:
        r1 = new org.apache.http.message.BasicNameValuePair;
        r2 = "published";
        r3 = java.lang.Boolean.toString(r5);
        r1.<init>(r2, r3);
        r0.c(r1);
    L_0x001e:
        r10 = r13.f14117k;
        r1 = r10;
        r2 = com.facebook.common.util.StringUtil.a(r1);
        if (r2 != 0) goto L_0x0031;
    L_0x0027:
        r2 = new org.apache.http.message.BasicNameValuePair;
        r3 = "name";
        r2.<init>(r3, r1);
        r0.c(r2);
    L_0x0031:
        r1 = r13.m21817f();
        r2 = com.facebook.common.util.StringUtil.a(r1);
        if (r2 != 0) goto L_0x0045;
    L_0x003b:
        r2 = new org.apache.http.message.BasicNameValuePair;
        r3 = "profile_id";
        r2.<init>(r3, r1);
        r0.c(r2);
    L_0x0045:
        r1 = r13.m21819h();
        r2 = com.facebook.common.util.StringUtil.a(r1);
        if (r2 != 0) goto L_0x0059;
    L_0x004f:
        r2 = new org.apache.http.message.BasicNameValuePair;
        r3 = "place";
        r2.<init>(r3, r1);
        r0.c(r2);
    L_0x0059:
        r10 = r13.f14111e;
        r1 = r10;
        r2 = com.facebook.common.util.StringUtil.a(r1);
        if (r2 != 0) goto L_0x006c;
    L_0x0062:
        r2 = new org.apache.http.message.BasicNameValuePair;
        r3 = "text_only_place";
        r2.<init>(r3, r1);
        r0.c(r2);
    L_0x006c:
        r10 = r13.f14113g;
        r1 = r10;
        r2 = com.facebook.ipc.composer.model.RedSpaceValue.POST_TO_REDSPACE;
        if (r1 != r2) goto L_0x0084;
    L_0x0073:
        r1 = new org.apache.http.message.BasicNameValuePair;
        r2 = "posting_to_redspace";
        r10 = r13.f14113g;
        r3 = r10;
        r3 = r3.toApiString();
        r1.<init>(r2, r3);
        r0.c(r1);
    L_0x0084:
        r1 = new org.apache.http.message.BasicNameValuePair;
        r2 = "checkin_entry_point";
        r10 = r13.f14112f;
        r3 = r10;
        r3 = com.facebook.ipc.composer.model.CheckinEntryPoint.a(r3);
        r1.<init>(r2, r3);
        r0.c(r1);
        r1 = r13.m21818g();
        r2 = com.facebook.common.util.StringUtil.a(r1);
        if (r2 != 0) goto L_0x00b5;
    L_0x009f:
        r2 = r12.f14027b;
        r2 = r2.get();
        r2 = r1.equals(r2);
        if (r2 != 0) goto L_0x00b5;
    L_0x00ab:
        r2 = new org.apache.http.message.BasicNameValuePair;
        r3 = "target_id";
        r2.<init>(r3, r1);
        r0.c(r2);
    L_0x00b5:
        r10 = r13.f14119m;
        r1 = r10;
        r1 = m21733a(r1);
        r2 = com.facebook.common.util.StringUtil.a(r1);
        if (r2 != 0) goto L_0x00cc;
    L_0x00c2:
        r2 = new org.apache.http.message.BasicNameValuePair;
        r3 = "tags";
        r2.<init>(r3, r1);
        r0.c(r2);
    L_0x00cc:
        r1 = r12.f14029d;
        r1 = r1.m21693a(r13);
        r2 = com.facebook.common.util.StringUtil.a(r1);
        if (r2 != 0) goto L_0x00e2;
    L_0x00d8:
        r2 = new org.apache.http.message.BasicNameValuePair;
        r3 = "stickers";
        r2.<init>(r3, r1);
        r0.c(r2);
    L_0x00e2:
        r10 = r13.f14097O;
        r1 = r10;
        r2 = com.facebook.common.util.StringUtil.a(r1);
        if (r2 != 0) goto L_0x00f5;
    L_0x00eb:
        r2 = new org.apache.http.message.BasicNameValuePair;
        r3 = "source_type";
        r2.<init>(r3, r1);
        r0.c(r2);
    L_0x00f5:
        r1 = r12.f14029d;
        r1 = r1.m21694b(r13);
        r2 = com.facebook.common.util.StringUtil.a(r1);
        if (r2 != 0) goto L_0x010b;
    L_0x0101:
        r2 = new org.apache.http.message.BasicNameValuePair;
        r3 = "text_overlay";
        r2.<init>(r3, r1);
        r0.c(r2);
    L_0x010b:
        r1 = r12.f14029d;
        r1 = r1.m21695c(r13);
        if (r1 == 0) goto L_0x0121;
    L_0x0113:
        r1 = new org.apache.http.message.BasicNameValuePair;
        r2 = "is_cropped";
        r3 = java.lang.Boolean.toString(r5);
        r1.<init>(r2, r3);
        r0.c(r1);
    L_0x0121:
        r1 = r12.f14029d;
        r1 = r1.m21696d(r13);
        if (r1 == 0) goto L_0x0137;
    L_0x0129:
        r1 = new org.apache.http.message.BasicNameValuePair;
        r2 = "is_rotated";
        r3 = java.lang.Boolean.toString(r5);
        r1.<init>(r2, r3);
        r0.c(r1);
    L_0x0137:
        r1 = r12.f14029d;
        r1 = r1.m21697e(r13);
        if (r1 != 0) goto L_0x015b;
    L_0x013f:
        r1 = r12.f14029d;
        r10 = com.facebook.photos.upload.protocol.CreativeEditingPhotoUploadHelper.m21692h(r13);
        if (r10 == 0) goto L_0x03b1;
    L_0x0147:
        r11 = r10.m4446i();
        if (r11 == 0) goto L_0x03b1;
    L_0x014d:
        r10 = r10.m4446i();
        r10 = r10.isEmpty();
        if (r10 != 0) goto L_0x03b1;
    L_0x0157:
        r10 = 1;
    L_0x0158:
        r1 = r10;
        if (r1 == 0) goto L_0x0180;
    L_0x015b:
        r1 = new org.apache.http.message.BasicNameValuePair;
        r2 = "is_filtered";
        r3 = java.lang.Boolean.toString(r5);
        r1.<init>(r2, r3);
        r0.c(r1);
        r1 = new org.apache.http.message.BasicNameValuePair;
        r2 = "filter_name";
        r3 = r12.f14029d;
        r10 = com.facebook.photos.upload.protocol.CreativeEditingPhotoUploadHelper.m21692h(r13);
        if (r10 == 0) goto L_0x03b4;
    L_0x0175:
        r10 = r10.m4438a();
    L_0x0179:
        r3 = r10;
        r1.<init>(r2, r3);
        r0.c(r1);
    L_0x0180:
        r10 = r13.f14121o;
        r1 = r10;
        r1 = r1.a();
        r0.b(r1);
        r10 = r13.f14116j;
        r1 = r10;
        r2 = r1.f14024e;
        r2 = com.facebook.common.util.StringUtil.a(r2);
        if (r2 != 0) goto L_0x01a1;
    L_0x0195:
        r2 = new org.apache.http.message.BasicNameValuePair;
        r3 = "privacy";
        r1 = r1.f14024e;
        r2.<init>(r3, r1);
        r0.c(r2);
    L_0x01a1:
        r1 = new org.apache.http.message.BasicNameValuePair;
        r2 = "audience_exp";
        r3 = java.lang.Boolean.TRUE;
        r3 = r3.toString();
        r1.<init>(r2, r3);
        r0.c(r1);
        r10 = r13.f14122p;
        r1 = r10;
        r2 = com.facebook.common.util.StringUtil.a(r1);
        if (r2 != 0) goto L_0x01ce;
    L_0x01ba:
        r2 = new org.apache.http.message.BasicNameValuePair;
        r3 = "qn";
        r2.<init>(r3, r1);
        r0.c(r2);
        r2 = new org.apache.http.message.BasicNameValuePair;
        r3 = "composer_session_id";
        r2.<init>(r3, r1);
        r0.c(r2);
    L_0x01ce:
        r10 = r13.f14123q;
        r1 = r10;
        r2 = com.facebook.common.util.StringUtil.a(r1);
        if (r2 != 0) goto L_0x01f4;
    L_0x01d7:
        r2 = new org.apache.http.message.BasicNameValuePair;
        r3 = "idempotence_token";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r1 = r4.append(r1);
        r4 = "-publish";
        r1 = r1.append(r4);
        r1 = r1.toString();
        r2.<init>(r3, r1);
        r0.c(r2);
    L_0x01f4:
        r10 = r13.f14124r;
        r1 = r10;
        if (r1 == 0) goto L_0x0207;
    L_0x01f9:
        r2 = new org.apache.http.message.BasicNameValuePair;
        r3 = "orientation";
        r1 = java.lang.String.valueOf(r1);
        r2.<init>(r3, r1);
        r0.c(r2);
    L_0x0207:
        r1 = new org.apache.http.message.BasicNameValuePair;
        r2 = "is_explicit_location";
        r10 = r13.f14130x;
        r3 = r10;
        r3 = java.lang.String.valueOf(r3);
        r1.<init>(r2, r3);
        r0.c(r1);
        r10 = r13.f14087E;
        r2 = r10;
        r1 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r1 == 0) goto L_0x023c;
    L_0x021f:
        r1 = r12.f14028c;
        r4 = r1.a();
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r4 / r6;
        r2 = r4 - r2;
        r2 = java.lang.Math.max(r2, r8);
        r1 = new org.apache.http.message.BasicNameValuePair;
        r4 = "time_since_original_post";
        r2 = java.lang.String.valueOf(r2);
        r1.<init>(r4, r2);
        r0.c(r1);
    L_0x023c:
        r10 = r13.f14093K;
        r1 = r10;
        r1 = com.google.common.base.Strings.isNullOrEmpty(r1);
        if (r1 != 0) goto L_0x0252;
    L_0x0245:
        r1 = new org.apache.http.message.BasicNameValuePair;
        r2 = "post_channel_id";
        r10 = r13.f14093K;
        r3 = r10;
        r1.<init>(r2, r3);
        r0.c(r1);
    L_0x0252:
        r10 = r13.f14094L;
        r1 = r10;
        if (r1 == 0) goto L_0x0268;
    L_0x0257:
        r1 = new org.apache.http.message.BasicNameValuePair;
        r2 = "post_channel_feedback_state";
        r10 = r13.f14094L;
        r3 = r10;
        r3 = r3.toString();
        r1.<init>(r2, r3);
        r0.c(r1);
    L_0x0268:
        r10 = r13.f14092J;
        r1 = r10;
        r1 = com.google.common.base.Strings.isNullOrEmpty(r1);
        if (r1 != 0) goto L_0x027e;
    L_0x0271:
        r1 = new org.apache.http.message.BasicNameValuePair;
        r2 = "append_story_id";
        r10 = r13.f14092J;
        r3 = r10;
        r1.<init>(r2, r3);
        r0.c(r1);
    L_0x027e:
        r10 = r13.f14095M;
        r1 = r10;
        if (r1 == 0) goto L_0x02a1;
    L_0x0283:
        r10 = r13.f14095M;
        r1 = r10;
        r1 = r1.isEmpty();
        if (r1 != 0) goto L_0x02a1;
    L_0x028c:
        r1 = new org.apache.http.message.BasicNameValuePair;
        r2 = "contributors";
        r10 = r13.f14095M;
        r3 = r10;
        r3 = r3.asList();
        r3 = m21733a(r3);
        r1.<init>(r2, r3);
        r0.c(r1);
    L_0x02a1:
        r10 = r13.f14096N;
        r1 = r10;
        r1 = com.google.common.base.Strings.isNullOrEmpty(r1);
        if (r1 != 0) goto L_0x02b7;
    L_0x02aa:
        r1 = new org.apache.http.message.BasicNameValuePair;
        r2 = "connection_class";
        r10 = r13.f14096N;
        r3 = r10;
        r1.<init>(r2, r3);
        r0.c(r1);
    L_0x02b7:
        r10 = r13.f14128v;
        r1 = r10;
        if (r1 == 0) goto L_0x030c;
    L_0x02bc:
        r2 = new org.apache.http.message.BasicNameValuePair;
        r3 = "proxied_app_id";
        r4 = r1.m7689a();
        r2.<init>(r3, r4);
        r0.c(r2);
        r2 = new org.apache.http.message.BasicNameValuePair;
        r3 = "proxied_app_name";
        r4 = r1.m7690b();
        r2.<init>(r3, r4);
        r0.c(r2);
        r2 = new org.apache.http.message.BasicNameValuePair;
        r3 = "android_key_hash";
        r4 = r1.m7691c();
        r2.<init>(r3, r4);
        r0.c(r2);
        r2 = new org.apache.http.message.BasicNameValuePair;
        r3 = "attribution_app_id";
        r4 = r1.m7689a();
        r2.<init>(r3, r4);
        r0.c(r2);
        r2 = r1.m7692d();
        r2 = com.google.common.base.Strings.isNullOrEmpty(r2);
        if (r2 != 0) goto L_0x030c;
    L_0x02fe:
        r2 = new org.apache.http.message.BasicNameValuePair;
        r3 = "attribution_app_metadata";
        r1 = r1.m7692d();
        r2.<init>(r3, r1);
        r0.c(r2);
    L_0x030c:
        r10 = r13.f14103U;
        r1 = r10;
        if (r1 == 0) goto L_0x0335;
    L_0x0311:
        r2 = new org.apache.http.message.BasicNameValuePair;
        r3 = "prompt_id";
        r4 = r1.promptId;
        r2.<init>(r3, r4);
        r0.c(r2);
        r2 = new org.apache.http.message.BasicNameValuePair;
        r3 = "prompt_type";
        r4 = r1.promptType;
        r2.<init>(r3, r4);
        r0.c(r2);
        r2 = new org.apache.http.message.BasicNameValuePair;
        r3 = "prompt_tracking_string";
        r1 = r1.trackingString;
        r2.<init>(r3, r1);
        r0.c(r2);
    L_0x0335:
        r10 = r13.f14104V;
        r1 = r10;
        com.facebook.composer.publish.protocol.TopicFeedsPublishHelper.m11663a(r1, r0);
        r10 = r13.f14084B;
        r2 = r10;
        r1 = java.lang.Long.toString(r2);
        r10 = r13.f14106X;
        r2 = r10;
        if (r2 == 0) goto L_0x035b;
    L_0x0347:
        r2 = new org.apache.http.message.BasicNameValuePair;
        r3 = "post_surfaces_blacklist";
        r4 = com.facebook.composer.publish.protocol.PublishHelper.f8063a;
        r4 = com.facebook.common.util.JSONUtil.b(r4);
        r4 = r4.toString();
        r2.<init>(r3, r4);
        r0.c(r2);
    L_0x035b:
        r2 = com.facebook.http.protocol.ApiRequest.newBuilder();
        r3 = "publish-photo";
        r2.b = r3;
        r2 = r2;
        r3 = "POST";
        r2.c = r3;
        r2 = r2;
        r2.d = r1;
        r1 = r2;
        r2 = com.facebook.http.protocol.ApiResponseType.STRING;
        r1.k = r2;
        r1 = r1;
        r0 = r0.b();
        r1.g = r0;
        r0 = r1;
        r0 = r0.C();
        return r0;
    L_0x037d:
        r2 = new org.apache.http.message.BasicNameValuePair;
        r3 = "published";
        r4 = 0;
        r4 = java.lang.Boolean.toString(r4);
        r2.<init>(r3, r4);
        r0.c(r2);
        r2 = new org.apache.http.message.BasicNameValuePair;
        r3 = "unpublished_content_type";
        r1 = r1.getContentType();
        r2.<init>(r3, r1);
        r0.c(r2);
        r10 = r13.f14091I;
        r2 = r10;
        r1 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r1 == 0) goto L_0x001e;
    L_0x03a1:
        r1 = new org.apache.http.message.BasicNameValuePair;
        r4 = "scheduled_publish_time";
        r2 = java.lang.String.valueOf(r2);
        r1.<init>(r4, r2);
        r0.c(r1);
        goto L_0x001e;
    L_0x03b1:
        r10 = 0;
        goto L_0x0158;
    L_0x03b4:
        r10 = 0;
        goto L_0x0179;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.upload.protocol.PublishPhotoMethod.a(java.lang.Object):com.facebook.http.protocol.ApiRequest");
    }

    public final Object m21735a(Object obj, ApiResponse apiResponse) {
        return Long.valueOf(((UploadPhotoParams) obj).f14084B);
    }

    @Inject
    public PublishPhotoMethod(Provider<String> provider, Clock clock, CreativeEditingPhotoUploadHelper creativeEditingPhotoUploadHelper) {
        this.f14027b = provider;
        this.f14028c = clock;
        this.f14029d = creativeEditingPhotoUploadHelper;
    }

    @Nullable
    private static String m21733a(List<Long> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return "[" + Joiner.on(',').skipNulls().join(list) + "]";
    }
}
