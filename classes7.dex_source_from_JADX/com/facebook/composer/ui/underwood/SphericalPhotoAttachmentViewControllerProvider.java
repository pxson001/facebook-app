package com.facebook.composer.ui.underwood;

import android.content.Context;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.spherical.photo.abtest.Photos360QEHelper;

/* compiled from: commercial_break_pre_countdown_cancel */
public class SphericalPhotoAttachmentViewControllerProvider extends AbstractAssistedProvider<SphericalPhotoAttachmentViewController> {
    public final <DataProvider extends ProvidesAttachments> SphericalPhotoAttachmentViewController<DataProvider> m21122a(DataProvider dataProvider, AttachmentsEventListener attachmentsEventListener) {
        return new SphericalPhotoAttachmentViewController(dataProvider, attachmentsEventListener, (Context) getInstance(Context.class), FbDraweeControllerBuilder.b(this), ComposerAttachmentViewUtility.m21071b(this), Photos360QEHelper.a(this));
    }
}
