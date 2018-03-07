package com.facebook.feed.feedtype;

import android.content.Intent;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.feed.protocol.FetchTopicFeedMethod;
import com.facebook.graphql.model.GraphQLExploreFeed.Builder;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: app_install_zero_rating_interstitial_continue */
public class TopicFeedTypeDataItem extends AbstractFeedTypeDataItem {
    @Inject
    public TopicFeedTypeDataItem(Lazy<FetchTopicFeedMethod> lazy) {
        super(Name.k, lazy);
    }

    public final String m22716a(Intent intent, FeedType feedType) {
        return intent.getStringExtra("topic_name");
    }

    public final FeedType m22715a(Intent intent) {
        Builder builder = new Builder();
        builder.i = intent.getStringExtra("topic_id");
        builder = builder;
        builder.l = intent.getStringExtra("topic_name");
        return new FeedType(builder.a(), Name.k);
    }
}
