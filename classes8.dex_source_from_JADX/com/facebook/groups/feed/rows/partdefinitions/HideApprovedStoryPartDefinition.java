package com.facebook.groups.feed.rows.partdefinitions;

import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;

/* compiled from: facedetection_ */
public class HideApprovedStoryPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    public final boolean m15704a(Object obj) {
        return ((GraphQLStory) ((FeedProps) obj).a).aT();
    }

    public final Object m15703a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        return null;
    }
}
