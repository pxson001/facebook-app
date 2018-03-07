package com.facebook.messengerwear.shared;

/* compiled from: photo_view_fragment */
public enum MessageGrouping {
    DEFAULT(false, false, false),
    DEFAULT_WITH_SENDER(false, false, true),
    ONLY_WITH_NEWER_ROW(true, false, false),
    ONLY_WITH_NEWER_ROW_WITH_SENDER(true, false, true),
    ONLY_WITH_OLDER_ROW(false, true, false),
    WITH_OLDER_AND_NEW_ROWS(true, true, false),
    IMAGE_ATTACHMENT_MIDDLE(true, true, true),
    IMAGE_ATTACHMENT_BOTTOM(false, true, true);
    
    public final boolean groupWithNewerRow;
    public final boolean groupWithOlderRow;
    public final boolean stickToTop;

    public static MessageGrouping forGrouping(boolean z, boolean z2, boolean z3) {
        if (z && z2) {
            return WITH_OLDER_AND_NEW_ROWS;
        }
        if (z) {
            return z3 ? ONLY_WITH_NEWER_ROW_WITH_SENDER : ONLY_WITH_NEWER_ROW;
        } else {
            if (z2) {
                return ONLY_WITH_OLDER_ROW;
            }
            return z3 ? DEFAULT_WITH_SENDER : DEFAULT;
        }
    }

    public static MessageGrouping forMiddleImageAttachment() {
        return IMAGE_ATTACHMENT_MIDDLE;
    }

    public static MessageGrouping forBottomImageAttachment(boolean z) {
        return z ? IMAGE_ATTACHMENT_MIDDLE : IMAGE_ATTACHMENT_BOTTOM;
    }

    private MessageGrouping(boolean z, boolean z2, boolean z3) {
        this.groupWithNewerRow = z;
        this.groupWithOlderRow = z2;
        this.stickToTop = z3;
    }
}
