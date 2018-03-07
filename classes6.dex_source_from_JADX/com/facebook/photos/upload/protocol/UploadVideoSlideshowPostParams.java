package com.facebook.photos.upload.protocol;

import android.os.Bundle;
import com.facebook.ipc.composer.model.MinutiaeTag;
import com.facebook.ipc.composer.model.ProductItemAttachment;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.share.model.ComposerAppAttribution;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: future_friending */
public class UploadVideoSlideshowPostParams extends UploadVideoChunkPostParams {
    public final ImmutableList<String> f14215c;
    public final int f14216d;
    public final int f14217e;

    private UploadVideoSlideshowPostParams(String str, String str2, PhotoUploadPrivacy photoUploadPrivacy, long j, boolean z, RedSpaceValue redSpaceValue, String str3, long j2, ImmutableList<Long> immutableList, MinutiaeTag minutiaeTag, String str4, long j3, ComposerAppAttribution composerAppAttribution, boolean z2, boolean z3, Optional<Boolean> optional, Optional<Long> optional2, @Nullable ProductItemAttachment productItemAttachment, String str5, String str6, boolean z4, String str7, String str8, long j4, Bundle bundle, String str9, String str10, ImmutableList<String> immutableList2, PromptAnalytics promptAnalytics, List<String> list, int i, int i2, boolean z5, String str11, String str12) {
        super(str, str2, photoUploadPrivacy, j, z, redSpaceValue, str3, j2, immutableList, minutiaeTag, str4, j3, composerAppAttribution, z2, z3, optional, optional2, productItemAttachment, str5, str6, z4, str7, str8, j4, bundle, str9, str10, immutableList2, promptAnalytics, z5, str11, str12);
        this.f14215c = ImmutableList.copyOf(list);
        this.f14216d = i;
        this.f14217e = i2;
    }

    public static UploadVideoSlideshowPostParams m21885a(String str, UploadOperation uploadOperation, List<String> list, int i, int i2) {
        return new UploadVideoSlideshowPostParams(str, uploadOperation.m21496A(), uploadOperation.m21498C(), uploadOperation.m21499D(), uploadOperation.m21501F(), uploadOperation.m21502G(), uploadOperation.m21500E(), uploadOperation.m21497B(), uploadOperation.m21508M(), uploadOperation.ac(), uploadOperation.m21509N(), uploadOperation.ad(), uploadOperation.m21517V(), uploadOperation.m21518W(), uploadOperation.m21519X(), Optional.of(Boolean.valueOf(uploadOperation.ah() == PublishMode.NORMAL)), Optional.of(Long.valueOf(uploadOperation.ai())), uploadOperation.m21547v(), uploadOperation.as(), uploadOperation.m21511P(), uploadOperation.m21512Q().booleanValue(), (String) UploadVideoChunkPostParams.f14143a.get(uploadOperation.m21510O()), uploadOperation.at(), uploadOperation.av(), uploadOperation.m21550z(), uploadOperation.aB(), (String) UploadVideoChunkPostParams.f14144b.get(uploadOperation.m21510O()), uploadOperation.aD(), uploadOperation.aC(), list, i, i2, uploadOperation.aE(), uploadOperation.aw(), uploadOperation.aF());
    }
}
