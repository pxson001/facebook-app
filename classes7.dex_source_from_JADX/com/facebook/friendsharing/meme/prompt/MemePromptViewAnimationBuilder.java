package com.facebook.friendsharing.meme.prompt;

import android.content.Context;
import android.view.View;
import com.facebook.device.ScreenUtil;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPhotoTray;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPromptFlyout;
import com.facebook.feed.photoreminder.common.PromptHScrollView;
import com.facebook.feed.photoreminder.common.ScrollingImagePromptViewAnimationBuilder;
import com.facebook.feed.photoreminder.common.ScrollingImagePromptViewAnimationBuilder.BaseTrayAnimatorListener;
import com.facebook.inject.Assisted;
import com.facebook.ui.animations.persistent.parts.DefaultAnimationPartFactory;
import javax.inject.Inject;

/* compiled from: Resetting decoder after %d ms */
public class MemePromptViewAnimationBuilder<V extends View & HasPromptFlyout & HasPhotoTray> extends ScrollingImagePromptViewAnimationBuilder<BaseTrayAnimatorListener, V> {
    @Inject
    public MemePromptViewAnimationBuilder(ScreenUtil screenUtil, DefaultAnimationPartFactory defaultAnimationPartFactory, @Assisted Context context) {
        super(screenUtil, defaultAnimationPartFactory, context.getResources().getDimensionPixelSize(2131432477));
    }

    public final BaseTrayAnimatorListener mo1465a(V v, PromptHScrollView promptHScrollView, boolean z) {
        return new BaseTrayAnimatorListener(this, promptHScrollView, z);
    }
}
