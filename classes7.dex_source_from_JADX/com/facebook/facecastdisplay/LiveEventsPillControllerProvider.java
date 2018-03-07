package com.facebook.facecastdisplay;

import android.view.ViewStub;
import com.facebook.facecastdisplay.LiveEventsPillController.LiveEventsPillControllerListener;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;

/* compiled from: story_cta */
public class LiveEventsPillControllerProvider extends AbstractAssistedProvider<LiveEventsPillController> {
    public final LiveEventsPillController m3247a(ViewStub viewStub, LiveEventsPillControllerListener liveEventsPillControllerListener) {
        return new LiveEventsPillController(viewStub, liveEventsPillControllerListener, SpringSystem.b(this), ViewHelperViewAnimatorFactory.a(this));
    }
}
