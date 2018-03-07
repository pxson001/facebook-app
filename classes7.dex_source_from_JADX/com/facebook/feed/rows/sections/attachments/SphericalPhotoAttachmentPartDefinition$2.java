package com.facebook.feed.rows.sections.attachments;

import com.facebook.attachments.photos.ui.SphericalPhotoAttachmentView;
import com.facebook.feed.autoplay.VideoViewController;

/* compiled from: Xing */
class SphericalPhotoAttachmentPartDefinition$2 extends VideoViewController<SphericalPhotoAttachmentView> {
    final /* synthetic */ SphericalPhotoAttachmentPartDefinition f20765a;

    SphericalPhotoAttachmentPartDefinition$2(SphericalPhotoAttachmentPartDefinition sphericalPhotoAttachmentPartDefinition, String str) {
        this.f20765a = sphericalPhotoAttachmentPartDefinition;
        super(str);
    }

    public final void m23747a(Object obj) {
        SphericalPhotoAttachmentView sphericalPhotoAttachmentView = (SphericalPhotoAttachmentView) obj;
        sphericalPhotoAttachmentView.setIsViewSignificantlyVisible(false);
        sphericalPhotoAttachmentView.m931k();
        sphericalPhotoAttachmentView.m928g();
    }

    public final void m23748b(Object obj) {
        SphericalPhotoAttachmentView sphericalPhotoAttachmentView = (SphericalPhotoAttachmentView) obj;
        sphericalPhotoAttachmentView.setIsViewSignificantlyVisible(true);
        sphericalPhotoAttachmentView.m930j();
        if (sphericalPhotoAttachmentView.f946j.g) {
            sphericalPhotoAttachmentView.f946j.l();
        }
    }
}
