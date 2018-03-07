package com.facebook.photos.creativeediting.ui;

import android.widget.ImageView;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.photos.creativeediting.renderers.MovableItemContainer;
import com.facebook.springs.SpringSystem;

/* compiled from: live_video_invite_friend_dialog */
public class MovableItemAnimationControllerProvider extends AbstractAssistedProvider<MovableItemAnimationController> {
    public final MovableItemAnimationController m11948a(ImageView imageView, MovableItemContainer movableItemContainer, MovableContainerView movableContainerView) {
        return new MovableItemAnimationController(imageView, movableItemContainer, movableContainerView, SpringSystem.b(this));
    }
}
