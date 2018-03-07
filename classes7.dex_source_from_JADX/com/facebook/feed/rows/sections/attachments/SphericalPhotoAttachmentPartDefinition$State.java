package com.facebook.feed.rows.sections.attachments;

import android.view.View.OnClickListener;
import com.facebook.attachments.photos.ui.SphericalPhotoAttachmentView;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.feed.autoplay.VideoViewController;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.spherical.model.SphericalPhotoParams;
import com.facebook.spherical.photo.PartialPanoUtil.PanoBounds;
import com.facebook.spherical.photo.PhotoVRCastParams;

/* compiled from: Xing */
public class SphericalPhotoAttachmentPartDefinition$State {
    public final DraweeController f20773a;
    public final ImageRequest f20774b;
    public final VideoViewController<SphericalPhotoAttachmentView> f20775c;
    public final OnClickListener f20776d;
    public final PhotoVRCastParams f20777e;
    public final SphericalPhotoParams f20778f;
    public final PanoBounds f20779g;

    public SphericalPhotoAttachmentPartDefinition$State(DraweeController draweeController, ImageRequest imageRequest, VideoViewController<SphericalPhotoAttachmentView> videoViewController, OnClickListener onClickListener, PhotoVRCastParams photoVRCastParams, SphericalPhotoParams sphericalPhotoParams, PanoBounds panoBounds) {
        this.f20773a = draweeController;
        this.f20774b = imageRequest;
        this.f20775c = videoViewController;
        this.f20776d = onClickListener;
        this.f20777e = photoVRCastParams;
        this.f20778f = sphericalPhotoParams;
        this.f20779g = panoBounds;
    }
}
