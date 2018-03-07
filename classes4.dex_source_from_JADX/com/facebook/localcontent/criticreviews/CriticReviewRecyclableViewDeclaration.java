package com.facebook.localcontent.criticreviews;

import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager.ViewPoolLimit;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager.ViewPoolPrefillAmount;
import com.facebook.ui.recyclableviewpool.RecyclableViewsDeclaration;

/* compiled from: notification_counts */
public class CriticReviewRecyclableViewDeclaration implements RecyclableViewsDeclaration {
    private static final ViewPoolLimit f6866a = new ViewPoolLimit(5, 2);
    private static final ViewPoolPrefillAmount f6867b = new ViewPoolPrefillAmount(1, 1);

    public final void m7209a(RecyclableViewPoolManager recyclableViewPoolManager) {
        recyclableViewPoolManager.m6901a(CriticReviewView.class, f6866a, f6867b);
    }
}
