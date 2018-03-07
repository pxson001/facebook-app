package com.facebook.feed.rows.sections.attachments;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.imagepipeline.image.CloseableImage;
import javax.annotation.Nullable;

/* compiled from: Zero Rating Settings */
class GifShareAttachmentPartDefinition$2 extends BaseControllerListener {
    final /* synthetic */ GifShareAttachmentPartDefinition$State f20593a;
    final /* synthetic */ GifShareAttachmentPartDefinition f20594b;

    GifShareAttachmentPartDefinition$2(GifShareAttachmentPartDefinition gifShareAttachmentPartDefinition, GifShareAttachmentPartDefinition$State gifShareAttachmentPartDefinition$State) {
        this.f20594b = gifShareAttachmentPartDefinition;
        this.f20593a = gifShareAttachmentPartDefinition$State;
    }

    public final void m23636a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
        CloseableImage closeableImage = (CloseableImage) obj;
        if (closeableImage != null) {
            if (animatable != null) {
                animatable.start();
            }
            if (closeableImage.g() != 0) {
                this.f20593a.f20596b = ((float) closeableImage.f()) / (((float) closeableImage.g()) * 1.0f);
                this.f20593a.f20597c.setAspectRatio(this.f20593a.f20596b);
            }
        }
    }
}
