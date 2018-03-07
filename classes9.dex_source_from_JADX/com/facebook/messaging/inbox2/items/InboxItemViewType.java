package com.facebook.messaging.inbox2.items;

/* compiled from: mReferenceNo2 */
public enum InboxItemViewType {
    THREAD_SINGLE,
    THREAD_MULTI,
    V2_RECENT_THREADS_PLACEHOLDER,
    V2_CONVERSATION_STARTER,
    V2_PEOPLE_YOU_MAY_MESSAGE,
    V2_PEOPLE_YOU_MAY_MESSAGE_USER,
    V2_SECTION_HEADER,
    V2_MESSAGE_REQUEST_HEADER,
    V2_ACTIVE_NOW,
    V2_ACTIVE_NOW_LOADING,
    V2_ACTIVE_NOW_EMPTY_ITEM,
    V2_RECENT_ITEMS,
    V2_RECENT_ITEM,
    V2_RTC_RECOMMENDATION,
    V2_TRENDING_GIFS,
    V2_TRENDING_GIF_ITEM,
    V2_CAMERA_ROLL,
    V2_CAMERA_ROLL_ITEM,
    V2_LOAD_MORE_THREADS_PLACEHOLDER,
    V2_MONTAGE_COMPOSER_HEADER,
    V2_PHOTO_REMINDERS,
    V2_BYMM_PAGE,
    V2_MORE_FOOTER,
    V2_MESSAGE_REQUEST_THREADS,
    V2_ANNOUNCEMENT,
    V2_UNKNOWN_TYPE;
    
    private static final InboxItemViewType[] sValues = null;

    static {
        sValues = values();
    }

    public static InboxItemViewType valueOf(int i) {
        if (i >= 0 && i < sValues.length) {
            return sValues[i];
        }
        throw new IllegalArgumentException("Unknown view type " + i);
    }

    public final boolean shouldRecyclerViewProvidePressState() {
        switch (this) {
            case THREAD_SINGLE:
            case THREAD_MULTI:
            case V2_CONVERSATION_STARTER:
            case V2_MONTAGE_COMPOSER_HEADER:
            case V2_ACTIVE_NOW:
            case V2_MORE_FOOTER:
            case V2_MESSAGE_REQUEST_HEADER:
                return true;
            default:
                return false;
        }
    }
}
