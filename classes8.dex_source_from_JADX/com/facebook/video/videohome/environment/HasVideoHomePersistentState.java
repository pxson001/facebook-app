package com.facebook.video.videohome.environment;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.multirow.api.AnyEnvironment;

/* compiled from: key_load_updated_place_to_review */
public interface HasVideoHomePersistentState extends AnyEnvironment {
    VideoHomeStoryPersistentState mo688a(FeedProps<GraphQLStory> feedProps, String str);
}
