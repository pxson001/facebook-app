package com.facebook.messaging.xma.hscroll;

import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager.ViewPoolLimit;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager.ViewPoolPrefillAmount;
import com.facebook.ui.recyclableviewpool.RecyclableViewsDeclaration;

/* compiled from: notification_auto_update_list_update */
public class HScrollRecyclableViewDeclaration implements RecyclableViewsDeclaration {
    private static final ViewPoolLimit f6878a = new ViewPoolLimit(5, 1);
    private static final ViewPoolPrefillAmount f6879b = new ViewPoolPrefillAmount(1, 1);

    public final void m7213a(RecyclableViewPoolManager recyclableViewPoolManager) {
        recyclableViewPoolManager.m6901a(HScrollAttachmentAdapter$ViewHolder.class, f6878a, f6879b);
    }
}
