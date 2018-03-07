package com.facebook.photos.creativecam.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.ViewStub;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.heisman.swipeable.ProfilePictureOverlaySwipeableFramesLogController;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.launch.ComposerLauncher;
import com.facebook.ipc.creativecam.CreativeCamCaptureInfo;
import com.facebook.ipc.creativecam.CreativeCamDelegate;
import com.facebook.ipc.creativecam.CreativeCamLaunchConfig;
import com.facebook.ipc.creativecam.CreativeCamResult;
import com.facebook.ipc.creativecam.controller.CreativeCamPickerPreviewController;
import com.facebook.ipc.creativecam.controller.CreativeCamTopBarController;
import com.facebook.photos.base.media.MediaItemFactory;
import com.facebook.photos.base.media.MediaItemFactory.FallbackMediaId;
import com.facebook.photos.creativeediting.model.CreativeEditingData;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.Frame;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FramePackModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Tried to attach  */
public class CreativeCamActivityDelegate implements CreativeCamDelegate {
    public final ComposerLauncher f10549a;
    public final MediaItemFactory f10550b;
    public final Activity f10551c;
    public final CreativeCamLaunchConfig f10552d;
    public final String f10553e;

    @Inject
    public CreativeCamActivityDelegate(ComposerLauncher composerLauncher, MediaItemFactory mediaItemFactory, @Assisted Activity activity, @Assisted CreativeCamLaunchConfig creativeCamLaunchConfig, @Assisted String str) {
        this.f10549a = composerLauncher;
        this.f10550b = mediaItemFactory;
        this.f10551c = activity;
        this.f10552d = creativeCamLaunchConfig;
        this.f10553e = str;
    }

    public final void m11048a(Uri uri, CreativeCamCaptureInfo creativeCamCaptureInfo) {
        Builder builder = new Builder();
        ImmutableList immutableList = creativeCamCaptureInfo.b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            builder.c(FramePackModel.a((FramePackModel) immutableList.get(i)));
        }
        CreativeEditingData.Builder builder2 = new CreativeEditingData.Builder();
        builder2.k = builder.b();
        builder2.a = creativeCamCaptureInfo.c;
        builder2.j = creativeCamCaptureInfo.d;
        if (this.f10552d.m != null) {
            CreativeEditingData a = builder2.a();
            ComposerAttachment.Builder a2 = ComposerAttachment.Builder.a(this.f10550b.a(uri, FallbackMediaId.CREATIVECAM_MEDIA));
            a2.e = a;
            ComposerConfiguration.Builder shouldPickerSupportLiveCamera = ComposerConfiguration.a(this.f10552d.m).setInitialAttachments(ImmutableList.of(Preconditions.checkNotNull(a2.a()))).setUseOptimisticPosting(true).setShouldPickerSupportLiveCamera(true);
            if (this.f10552d.m.getInitialTargetData() == null) {
                shouldPickerSupportLiveCamera.setInitialTargetData(ComposerTargetData.a);
            }
            this.f10549a.a(this.f10553e, shouldPickerSupportLiveCamera.a(), 0, this.f10551c);
            return;
        }
        CreativeCamResult.Builder builder3 = new CreativeCamResult.Builder();
        builder3.b = uri;
        builder3 = builder3;
        builder3.c = builder2.a();
        m11045a(builder3.a());
    }

    public final void m11051b(Uri uri, CreativeCamCaptureInfo creativeCamCaptureInfo) {
        if (this.f10552d.m != null) {
            this.f10549a.a(this.f10553e, ComposerConfiguration.a(this.f10552d.m).setInitialAttachments(ComposerAttachment.a(ImmutableList.of(uri), this.f10550b)).setInitialTargetData(ComposerTargetData.a).setUseOptimisticPosting(true).a(), 0, this.f10551c);
            return;
        }
        CreativeCamResult.Builder builder = new CreativeCamResult.Builder();
        builder.a = uri;
        m11045a(builder.a());
    }

    @Nullable
    public final ListenableFuture<ImmutableList<Frame>> m11046a() {
        return null;
    }

    @Nullable
    public final CreativeCamPickerPreviewController m11050b() {
        return null;
    }

    @Nullable
    public final CreativeCamTopBarController m11052c() {
        return null;
    }

    @Nullable
    public final ProfilePictureOverlaySwipeableFramesLogController m11053d() {
        return null;
    }

    public final void m11047a(int i) {
    }

    public final void m11049a(ViewStub viewStub) {
    }

    private void m11045a(CreativeCamResult creativeCamResult) {
        this.f10551c.setResult(-1, new Intent().putExtra("creative_cam_result_extra", creativeCamResult));
        this.f10551c.finish();
    }
}
