package com.facebook.feed.rows.sections.attachments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.facebook.feed.rows.sections.attachments.BasePhotoAttachmentPartDefinition.LaunchPhotoGalleryClickListener;

/* compiled from: [F>; */
class C1766x8c4a8d9c implements OnDismissListener {
    final /* synthetic */ LaunchPhotoGalleryClickListener f20545a;

    C1766x8c4a8d9c(LaunchPhotoGalleryClickListener launchPhotoGalleryClickListener) {
        this.f20545a = launchPhotoGalleryClickListener;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        LaunchPhotoGalleryClickListener.a(this.f20545a, true);
    }
}
