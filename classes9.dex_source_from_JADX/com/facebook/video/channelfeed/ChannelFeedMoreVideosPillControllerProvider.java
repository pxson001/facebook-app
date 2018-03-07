package com.facebook.video.channelfeed;

import android.view.View;
import com.facebook.feed.autoplay.CenteredVideoAutoplayManager;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.springs.SpringSystem;
import com.facebook.ui.animations.ViewHelperViewAnimatorFactory;
import com.facebook.video.channelfeed.ChannelFeedMoreVideosPillController.ViewCallback;
import com.facebook.widget.LazyView;

/* compiled from: synchronizeAfterClientChange */
public class ChannelFeedMoreVideosPillControllerProvider extends AbstractAssistedProvider<ChannelFeedMoreVideosPillController> {
    public final ChannelFeedMoreVideosPillController m2319a(LazyView<View> lazyView, ViewCallback viewCallback) {
        return new ChannelFeedMoreVideosPillController(lazyView, viewCallback, CenteredVideoAutoplayManager.a(this), SpringSystem.b(this), ViewHelperViewAnimatorFactory.a(this));
    }
}
