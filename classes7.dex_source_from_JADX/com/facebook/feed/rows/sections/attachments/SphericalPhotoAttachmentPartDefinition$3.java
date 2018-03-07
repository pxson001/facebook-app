package com.facebook.feed.rows.sections.attachments;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.photos.ui.SphericalPhotoAttachmentView;
import com.facebook.fbui.draggable.Direction;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.base.analytics.constants.PhotoLoggingConstants.FullscreenGallerySource;
import com.facebook.photos.dialog.PhotoAnimationDialogFragment;
import com.facebook.photos.dialog.PhotoAnimationDialogLaunchParams.Builder;
import com.facebook.photos.sphericalphoto.SphericalPhotoFragment;
import com.facebook.spherical.model.SphericalPhotoParams;
import com.facebook.spherical.photo.PartialPanoUtil.PanoBounds;
import com.facebook.spherical.photo.PhotoVRCastParams;

/* compiled from: Xing */
class SphericalPhotoAttachmentPartDefinition$3 implements OnClickListener {
    final /* synthetic */ ImageRequest f20766a;
    final /* synthetic */ ImageRequest f20767b;
    final /* synthetic */ FeedProps f20768c;
    final /* synthetic */ PhotoVRCastParams f20769d;
    final /* synthetic */ SphericalPhotoParams f20770e;
    final /* synthetic */ PanoBounds f20771f;
    final /* synthetic */ SphericalPhotoAttachmentPartDefinition f20772g;

    SphericalPhotoAttachmentPartDefinition$3(SphericalPhotoAttachmentPartDefinition sphericalPhotoAttachmentPartDefinition, ImageRequest imageRequest, ImageRequest imageRequest2, FeedProps feedProps, PhotoVRCastParams photoVRCastParams, SphericalPhotoParams sphericalPhotoParams, PanoBounds panoBounds) {
        this.f20772g = sphericalPhotoAttachmentPartDefinition;
        this.f20766a = imageRequest;
        this.f20767b = imageRequest2;
        this.f20768c = feedProps;
        this.f20769d = photoVRCastParams;
        this.f20770e = sphericalPhotoParams;
        this.f20771f = panoBounds;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1196652567);
        this.f20772g.h.c();
        ((SphericalPhotoAttachmentView) view).m931k();
        ((SphericalPhotoAttachmentView) view).f954s = true;
        ((SphericalPhotoAttachmentView) view).m932l();
        Builder builder = new Builder(FullscreenGallerySource.UNKNOWN);
        builder.f10110h = false;
        builder.m11992a(Direction.UP);
        SphericalPhotoFragment sphericalPhotoFragment = new SphericalPhotoFragment();
        sphericalPhotoFragment.a(this.f20766a, this.f20767b, this.f20768c, this.f20769d, SphericalPhotoAttachmentPartDefinition.b, (SphericalPhotoAttachmentView) view, this.f20770e, ((SphericalPhotoAttachmentView) view).getShouldShowPhoneAnimationInFullScreen(), ((SphericalPhotoAttachmentView) view).f953r, this.f20771f);
        PhotoAnimationDialogFragment.a(view.getContext(), sphericalPhotoFragment, builder.m11994a(), null, null);
        Logger.a(2, EntryType.UI_INPUT_END, 363984921, a);
    }
}
