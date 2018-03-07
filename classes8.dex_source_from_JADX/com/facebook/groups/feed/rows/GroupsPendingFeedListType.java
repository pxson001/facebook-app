package com.facebook.groups.feed.rows;

import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.FeedListType;

/* compiled from: faceweb/f?href=/%s/activity_feed/?type=mention */
public class GroupsPendingFeedListType implements FeedListType {
    public static final GroupsPendingFeedListType f14134a = new GroupsPendingFeedListType();

    private GroupsPendingFeedListType() {
    }

    public final FeedListName m15690a() {
        return FeedListName.GROUPS_PENDING;
    }

    public static GroupsPendingFeedListType m15689b() {
        return f14134a;
    }
}
