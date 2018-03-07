package com.facebook.photos.creativeediting.swipeable.composer.nux;

import android.content.Context;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.photos.creativeediting.model.SwipeableParams;
import com.facebook.photos.creativeediting.utilities.SpringAlphaAnimator;
import com.google.common.collect.ImmutableList;

/* compiled from: location_suggestion_profile_image_size */
public class SimplePickerFrameNuxControllerProvider extends AbstractAssistedProvider<SimplePickerFrameNuxController> {
    public final SimplePickerFrameNuxController m11884a(ImmutableList<SwipeableParams> immutableList) {
        return new SimplePickerFrameNuxController(immutableList, new SimplePickerFrameAnimatingViewNuxController((Context) getInstance(Context.class), SpringAlphaAnimator.b(this)));
    }
}
