package com.facebook.sentry;

import android.net.Uri;

/* compiled from: event_sms_declines */
public class SentryUtil {
    public static final Uri f15951a = Uri.parse("https://www.facebook.com/help/174623239336651/");

    /* compiled from: event_sms_declines */
    public enum SentryBlockTitle {
        SENTRY_BLOCK(2131230773),
        SENTRY_LIKE_BLOCK(2131230774),
        SENTRY_COMMENT_LIKE_BLOCK(2131230776),
        SENTRY_COMMENT_DELETE_BLOCK(2131230777),
        SENTRY_COMMENT_POST_BLOCK(2131230775),
        SENTRY_COMMENT_EDIT_BLOCK(2131230778),
        SENTRY_COMMENT_DISPLAY_BLOCK(2131230779),
        SENTRY_REMOVE_TAG_BLOCK(2131230780),
        SENTRY_PROFILE_PICTURE_UPDATE_BLOCK(2131230781),
        SENTRY_PROFILE_LIST_BLOCK(2131230782);
        
        private final int mTitleId;

        private SentryBlockTitle(int i) {
            this.mTitleId = i;
        }

        public final int getTitleId() {
            return this.mTitleId;
        }
    }
}
