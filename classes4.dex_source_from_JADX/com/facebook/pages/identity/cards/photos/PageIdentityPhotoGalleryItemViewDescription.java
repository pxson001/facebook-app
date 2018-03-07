package com.facebook.pages.identity.cards.photos;

import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager.ViewPoolLimit;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager.ViewPoolPrefillAmount;
import com.facebook.ui.recyclableviewpool.RecyclableViewsDeclaration;

/* compiled from: notif_time */
public class PageIdentityPhotoGalleryItemViewDescription implements RecyclableViewsDeclaration {
    public static ViewPoolLimit f6900a = new ViewPoolLimit(5, 1);
    public static ViewPoolPrefillAmount f6901b = new ViewPoolPrefillAmount(1, 1);

    public final void m7221a(RecyclableViewPoolManager recyclableViewPoolManager) {
        recyclableViewPoolManager.m6901a(PageIdentityPhotoGalleryItemView.class, f6900a, f6901b);
    }
}
