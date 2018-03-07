package com.facebook.photos.creativeediting.renderers;

import android.content.Context;
import android.graphics.Rect;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.photos.creativeediting.utilities.PhotoOverlayDrawUtilities;

/* compiled from: mStoryCallable threw an exception */
public class MovableItemContainerProvider extends AbstractAssistedProvider<MovableItemContainer> {
    public final MovableItemContainer m11524a(Rect rect) {
        return new MovableItemContainer(rect, (Context) getInstance(Context.class), PhotoOverlayDrawUtilities.b(this), IdBasedProvider.a(this, 1117));
    }
}
