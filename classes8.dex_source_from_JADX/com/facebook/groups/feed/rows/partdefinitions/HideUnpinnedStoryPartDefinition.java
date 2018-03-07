package com.facebook.groups.feed.rows.partdefinitions;

import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;

/* compiled from: face_count */
public class HideUnpinnedStoryPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    public final boolean m15711a(Object obj) {
        return ((GraphQLStory) ((FeedProps) obj).a).aW();
    }

    public final Object m15710a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        return null;
    }
}
