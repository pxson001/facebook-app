package com.facebook.photos.creativeediting.swipeable.composer.nux;

import com.facebook.inject.Assisted;
import com.facebook.photos.creativeediting.model.SwipeableParams;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: location_text */
public class SimplePickerFrameNuxController implements SwipeableNuxController {
    private final ImmutableList<SwipeableParams> f9934a;
    private final SimplePickerFrameAnimatingViewNuxController f9935b;
    private int f9936c = 0;

    @Inject
    public SimplePickerFrameNuxController(@Assisted ImmutableList<SwipeableParams> immutableList, SimplePickerFrameAnimatingViewNuxController simplePickerFrameAnimatingViewNuxController) {
        this.f9934a = (ImmutableList) Preconditions.checkNotNull(immutableList);
        this.f9935b = simplePickerFrameAnimatingViewNuxController;
    }

    public final boolean mo537a() {
        return true;
    }

    public final void mo538b() {
        this.f9936c++;
    }

    public final boolean mo539c() {
        return this.f9936c < this.f9934a.size();
    }

    public final SwipeableAnimatingNuxViewController mo540d() {
        return this.f9935b;
    }
}
