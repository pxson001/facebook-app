package com.facebook.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.ui.animations.EntryAnimationListener;
import com.facebook.widget.AnimatedNotificationBanner;

/* compiled from: Trying to drop  */
public class GenericNotificationBanner extends AnimatedNotificationBanner {

    /* compiled from: Trying to drop  */
    public enum NotificationBannerType {
        NONE(false, 0),
        NO_CONNECTION(false, 2131230763),
        YOU_CAN_STILL_POST(false, 2131230766),
        FEED_IS_UP_TO_DATE(true, 2131233613),
        COMMENT_FETCH_FAILED(true, 2131233580),
        COMMENT_POST_FAILED(true, 2131233581),
        FETCH_STORY_FAILED(true, 2131233582),
        FETCH_TIMELINE_FAILED(true, 2131230797),
        FETCH_PAGE_FAILED(true, 2131230799),
        FETCH_EVENT_FAILED(true, 2131230801),
        FAILURE_LOADING_EVENTS(true, 2131230802);
        
        public final int bannerMessageId;
        public final boolean isTemporaryBanner;

        private NotificationBannerType(boolean z, int i) {
            this.isTemporaryBanner = z;
            this.bannerMessageId = i;
        }

        public final String getBannerString(Resources resources) {
            if (this == NONE) {
                return null;
            }
            return resources.getString(this.bannerMessageId);
        }
    }

    private static <T extends View> void m24326a(Class<T> cls, T t) {
        FbInjector.get(t.getContext());
    }

    private static void m24327a(Object obj, Context context) {
        FbInjector.get(context);
    }

    public GenericNotificationBanner(Context context) {
        this(context, null);
    }

    public GenericNotificationBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24328b();
    }

    private void m24328b() {
        m24326a(GenericNotificationBanner.class, (View) this);
    }

    public final void m24329a(NotificationBannerType notificationBannerType) {
        m24325a(notificationBannerType, null);
    }

    private void m24325a(NotificationBannerType notificationBannerType, EntryAnimationListener entryAnimationListener) {
        if (notificationBannerType != NotificationBannerType.NO_CONNECTION && notificationBannerType != NotificationBannerType.YOU_CAN_STILL_POST) {
            super.a(notificationBannerType.getBannerString(getContext().getResources()), notificationBannerType.isTemporaryBanner, entryAnimationListener);
            if (notificationBannerType == NotificationBannerType.YOU_CAN_STILL_POST) {
                this.a.b(NotificationBannerType.NO_CONNECTION.getBannerString(getContext().getResources()), 5000);
            }
        }
    }
}
