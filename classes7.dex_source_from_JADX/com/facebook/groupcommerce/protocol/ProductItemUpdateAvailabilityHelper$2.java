package com.facebook.groupcommerce.protocol;

import com.facebook.feed.util.event.ProductItemEvents.ToggleAvailabilitySurface;

/* compiled from: reaction_unit_user_settings */
/* synthetic */ class ProductItemUpdateAvailabilityHelper$2 {
    static final /* synthetic */ int[] f5493a = new int[ToggleAvailabilitySurface.values().length];

    static {
        try {
            f5493a[ToggleAvailabilitySurface.YOUR_POSTS.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f5493a[ToggleAvailabilitySurface.GROUP_POST_CHEVRON.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f5493a[ToggleAvailabilitySurface.FEED_POST_CHEVRON.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f5493a[ToggleAvailabilitySurface.DELETE_INTERCEPT.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f5493a[ToggleAvailabilitySurface.FEED_STORY.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
