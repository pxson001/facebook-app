package com.facebook.groups.feed.rows;

import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.FeedListType;

/* compiled from: faceweb/f?href=/%s/activity_feed/?type=checkin */
public class GroupsPinnedFeedListType implements FeedListType {
    public static final GroupsPinnedFeedListType f14135a = new GroupsPinnedFeedListType();

    private GroupsPinnedFeedListType() {
    }

    public final FeedListName m15692a() {
        return FeedListName.GROUPS_PINNED;
    }

    public static GroupsPinnedFeedListType m15691b() {
        return f14135a;
    }
}
