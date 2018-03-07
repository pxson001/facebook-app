package com.facebook.timeline.tempprofilepic;

import android.content.Context;
import android.widget.FrameLayout;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.photos.creativeediting.RotatingFrameLayout;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableLayout;

/* compiled from: facecast_share_now_fail */
public class EditGalleryExpirationControllerProvider extends AbstractAssistedProvider<EditGalleryExpirationController> {
    public final EditGalleryExpirationController m18769a(RotatingFrameLayout rotatingFrameLayout, FrameLayout frameLayout, CreativeEditingSwipeableLayout creativeEditingSwipeableLayout, long j) {
        return new EditGalleryExpirationController(rotatingFrameLayout, frameLayout, creativeEditingSwipeableLayout, j, (Context) getInstance(Context.class), (ExpirationDialogControllerProvider) getOnDemandAssistedProviderForStaticDi(ExpirationDialogControllerProvider.class), LayoutInflaterMethodAutoProvider.b(this));
    }
}
