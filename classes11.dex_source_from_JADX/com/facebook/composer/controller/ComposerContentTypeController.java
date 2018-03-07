package com.facebook.composer.controller;

import android.support.annotation.Nullable;
import com.facebook.checkin.abtest.ExperimentsForCheckinAbTestModule;
import com.facebook.composer.attachments.AttachmentUtils;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.friendsharing.gif.util.GifUtil;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.ComposerStickerData;
import com.facebook.ipc.composer.model.ComposerContentType;
import com.facebook.ipc.composer.model.ComposerFacecastInfo;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.ipc.composer.model.ComposerSlideshowDataSpec;
import com.facebook.qe.api.QeAccessor;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: initialized */
public class ComposerContentTypeController {
    public final QeAccessor f6237a;

    @Inject
    public ComposerContentTypeController(QeAccessor qeAccessor) {
        this.f6237a = qeAccessor;
    }

    public final ComposerContentType m7710a(ImmutableList<ComposerAttachment> immutableList, ComposerFacecastInfo composerFacecastInfo, @Nullable ComposerShareParams composerShareParams, @Nullable ComposerStickerData composerStickerData, @Nullable MinutiaeObject minutiaeObject, @Nullable ComposerLocationInfo composerLocationInfo, @Nullable ComposerSlideshowDataSpec composerSlideshowDataSpec) {
        if (composerSlideshowDataSpec != null) {
            return ComposerContentType.SLIDESHOW;
        }
        if (composerStickerData != null) {
            return ComposerContentType.STICKER;
        }
        if (GifUtil.a(composerShareParams)) {
            return ComposerContentType.GIF_VIDEO;
        }
        if (composerShareParams != null) {
            return ComposerContentType.SHARE_ATTACHMENT;
        }
        if (composerFacecastInfo.facecastCameraIndex != -1) {
            return ComposerContentType.FACECAST;
        }
        if (minutiaeObject != null && minutiaeObject.h()) {
            return ComposerContentType.MINUTIAE;
        }
        if (immutableList.isEmpty()) {
            if (!(minutiaeObject != null || composerLocationInfo == null || composerLocationInfo.b() || composerLocationInfo.a() == null || composerLocationInfo.a().q() == null || composerLocationInfo.a().cf_() == null)) {
                boolean z = false;
                if (this.f6237a.a(ExperimentsForCheckinAbTestModule.f, false) || this.f6237a.a(ExperimentsForCheckinAbTestModule.h, false)) {
                    z = true;
                }
                if (z) {
                    return ComposerContentType.CHECKIN;
                }
            }
            return ComposerContentType.NO_ATTACHMENTS;
        } else if (AttachmentUtils.j(immutableList)) {
            return ComposerContentType.GIF_VIDEO;
        } else {
            if (AttachmentUtils.l(immutableList)) {
                return ComposerContentType.MULTIMEDIA;
            }
            if (AttachmentUtils.i(immutableList)) {
                return ComposerContentType.VIDEO;
            }
            return immutableList.size() == 1 ? ComposerContentType.SINGLE_PHOTO : ComposerContentType.MULTIPLE_PHOTOS;
        }
    }
}
