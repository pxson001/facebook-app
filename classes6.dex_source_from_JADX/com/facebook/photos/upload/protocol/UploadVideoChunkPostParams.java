package com.facebook.photos.upload.protocol;

import android.os.Bundle;
import com.facebook.ipc.composer.model.MinutiaeTag;
import com.facebook.ipc.composer.model.ProductItemAttachment;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperation.Type;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.share.model.ComposerAppAttribution;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: generic_map_my_location_button_impression */
public class UploadVideoChunkPostParams {
    protected static final Map<Type, String> f14143a = ImmutableMap.of(Type.PROFILE_VIDEO, "profile_video", Type.LIVE_VIDEO, "live_video", Type.MOMENTS_VIDEO, "moments_video");
    protected static final Map<Type, String> f14144b = ImmutableBiMap.b(Type.COMMENT_VIDEO, "VIDEO_COMMENT");
    @Nullable
    public final Bundle f14145A;
    @Nullable
    public final String f14146B;
    @Nullable
    public final String f14147C;
    @Nullable
    public final String f14148D;
    public final ImmutableList<String> f14149E;
    @Nullable
    public final PromptAnalytics f14150F;
    public final boolean f14151G;
    @Nullable
    public final String f14152H;
    public final String f14153c;
    public final String f14154d;
    public final long f14155e;
    public final String f14156f;
    public final boolean f14157g;
    public final RedSpaceValue f14158h;
    public final PhotoUploadPrivacy f14159i;
    public final long f14160j;
    public final ImmutableList<Long> f14161k;
    public final MinutiaeTag f14162l;
    public final String f14163m;
    public final long f14164n;
    public final boolean f14165o;
    public final long f14166p;
    public final ProductItemAttachment f14167q;
    public final ComposerAppAttribution f14168r;
    public final boolean f14169s;
    public final boolean f14170t;
    public final String f14171u;
    public final String f14172v;
    public final boolean f14173w;
    @Nullable
    public final String f14174x;
    @Nullable
    public final String f14175y;
    @Nullable
    public final long f14176z;

    UploadVideoChunkPostParams(String str, String str2, PhotoUploadPrivacy photoUploadPrivacy, long j, boolean z, RedSpaceValue redSpaceValue, String str3, long j2, ImmutableList<Long> immutableList, MinutiaeTag minutiaeTag, String str4, long j3, ComposerAppAttribution composerAppAttribution, boolean z2, boolean z3, Optional<Boolean> optional, Optional<Long> optional2, @Nullable ProductItemAttachment productItemAttachment, String str5, String str6, boolean z4, String str7, String str8, long j4, Bundle bundle, String str9, String str10, ImmutableList<String> immutableList2, PromptAnalytics promptAnalytics, boolean z5, String str11, String str12) {
        Preconditions.checkNotNull(immutableList);
        this.f14153c = str;
        this.f14154d = str2;
        this.f14159i = (PhotoUploadPrivacy) Preconditions.checkNotNull(photoUploadPrivacy);
        this.f14155e = j;
        this.f14156f = str3;
        this.f14157g = z;
        this.f14158h = redSpaceValue;
        this.f14160j = j2;
        this.f14161k = immutableList;
        this.f14162l = minutiaeTag;
        this.f14163m = str4;
        this.f14164n = j3;
        this.f14168r = composerAppAttribution;
        this.f14169s = z2;
        this.f14170t = z3;
        this.f14165o = ((Boolean) optional.or(Boolean.valueOf(true))).booleanValue();
        this.f14166p = ((Long) optional2.or(Long.valueOf(0))).longValue();
        this.f14167q = productItemAttachment;
        this.f14171u = str5;
        this.f14172v = str6;
        this.f14173w = z4;
        this.f14174x = str7;
        this.f14175y = str8;
        this.f14176z = j4;
        this.f14145A = bundle;
        this.f14147C = str9;
        this.f14148D = str10;
        this.f14149E = immutableList2;
        this.f14150F = promptAnalytics;
        this.f14151G = z5;
        this.f14146B = str11;
        this.f14152H = str12;
    }

    public static UploadVideoChunkPostParams m21843a(String str, UploadOperation uploadOperation) {
        return new UploadVideoChunkPostParams(str, uploadOperation.m21496A(), uploadOperation.m21498C(), uploadOperation.m21499D(), uploadOperation.m21501F(), uploadOperation.m21502G(), uploadOperation.m21500E(), uploadOperation.m21497B(), uploadOperation.m21508M(), uploadOperation.ac(), uploadOperation.m21509N(), uploadOperation.ad(), uploadOperation.m21517V(), uploadOperation.m21518W(), uploadOperation.m21519X(), Optional.of(Boolean.valueOf(uploadOperation.ah() == PublishMode.NORMAL)), Optional.of(Long.valueOf(uploadOperation.ai())), uploadOperation.m21547v(), uploadOperation.as(), uploadOperation.m21511P(), uploadOperation.m21512Q().booleanValue(), (String) f14143a.get(uploadOperation.m21510O()), uploadOperation.at(), uploadOperation.av(), uploadOperation.m21550z(), uploadOperation.aB(), (String) f14144b.get(uploadOperation.m21510O()), uploadOperation.aD(), uploadOperation.aC(), uploadOperation.aE(), uploadOperation.aw(), uploadOperation.aF());
    }
}
