package com.facebook.feedback.ui;

import com.facebook.common.util.StringUtil;
import com.facebook.ufiservices.cache.PendingCommentInputEntry;

/* compiled from: seal_video_broadcast */
public class ComposerFunnelLoggingUtil {
    public static String m4975a(PendingCommentInputEntry pendingCommentInputEntry) {
        Object obj = 1;
        if (pendingCommentInputEntry.g != null) {
            return "sticker_comment_posted";
        }
        Object obj2 = !StringUtil.c(pendingCommentInputEntry.c) ? 1 : null;
        if (pendingCommentInputEntry.f == null) {
            obj = null;
        }
        if (obj != null && obj2 == null) {
            return "photo_comment_without_text_posted";
        }
        if (obj != null) {
            return "photo_comment_with_text_posted";
        }
        if (obj2 != null) {
            return "text_only_comment_posted";
        }
        return null;
    }
}
