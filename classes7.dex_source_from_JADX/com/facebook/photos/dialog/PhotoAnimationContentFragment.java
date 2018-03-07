package com.facebook.photos.dialog;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.base.fragment.FbFragment;
import com.facebook.photos.dialog.util.PhotosDialogPerfUtil.FragmentPerfMarkerConfig;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.photos.mediagallery.launcher.animation.DrawingRule;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import javax.annotation.Nullable;

/* compiled from: live_feedback_input_is_reactions_swipe_nux_shown */
public abstract class PhotoAnimationContentFragment extends FbFragment {
    private static final MediaGalleryTTISequence f10093a = new MediaGalleryTTISequence();

    /* compiled from: live_feedback_input_is_reactions_swipe_nux_shown */
    final class MediaGalleryTTISequence extends AbstractSequenceDefinition {
        public MediaGalleryTTISequence() {
            super(1310722, "MediaGalleryTTI");
        }
    }

    @Nullable
    public abstract DrawingRule mo1489a(Drawable drawable, Rect rect);

    public abstract boolean mo1491a(PhotoAnimationDialogFragment$3 photoAnimationDialogFragment$3);

    public abstract String as();

    @Nullable
    public abstract String mo1495e();

    public void m11982a(PhotoAnimationDialogFragment$2 photoAnimationDialogFragment$2) {
    }

    public void aq() {
    }

    public boolean ar() {
        return false;
    }

    public FragmentPerfMarkerConfig at() {
        return new FragmentPerfMarkerConfig(f10093a, "OpenPhotoGallery", 1310728, 1310729, 1310734);
    }

    public void mo1490a(ConsumptionPhotoEventBus consumptionPhotoEventBus, boolean z, int i) {
    }
}
