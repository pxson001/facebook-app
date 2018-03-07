package com.facebook.photos.creativeediting.swipeable.composer;

import android.content.Context;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.photos.creativeediting.swipeable.composer.CreativeEditingSwipeableController.C08137;
import com.facebook.photos.creativeediting.utilities.SpringAnimatorHelper;
import com.facebook.springs.SpringSystem;

/* compiled from: lockscreen_notification_displayed */
public class SwipeableTouchEventControllerProvider extends AbstractAssistedProvider<SwipeableTouchEventController> {
    public final SwipeableTouchEventController m11848a(C08137 c08137) {
        return new SwipeableTouchEventController(c08137, (Context) getInstance(Context.class), new SpringAnimatorHelper(SpringSystem.b(this)));
    }
}
