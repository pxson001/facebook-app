package com.facebook.feed.feedtype;

import android.content.Intent;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.feed.protocol.FetchReactionFeedMethod;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: app_rater_create_report */
public class ReactionFeedTypeDataItem extends AbstractFeedTypeDataItem {
    @Inject
    public ReactionFeedTypeDataItem(Lazy<FetchReactionFeedMethod> lazy) {
        super(Name.m, lazy, false, true);
    }

    public final String m22712a(Intent intent, FeedType feedType) {
        return intent.getStringExtra("reaction_feed_title");
    }

    public final FeedType m22711a(Intent intent) {
        return new FeedType(intent.getStringExtra("reaction_feed_story_id"), Name.m);
    }
}
