package com.facebook.groups.feed.rows.partdefinitions;

import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;

/* compiled from: face_found */
public class HidePinnedStoryPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    public final boolean m15709a(Object obj) {
        return ((GraphQLStory) ((FeedProps) obj).a).aV();
    }

    public final Object m15708a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        return null;
    }
}
