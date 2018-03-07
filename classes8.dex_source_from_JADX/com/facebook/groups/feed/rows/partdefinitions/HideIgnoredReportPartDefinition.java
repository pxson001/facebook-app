package com.facebook.groups.feed.rows.partdefinitions;

import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;

/* compiled from: face_frame_position_ms */
public class HideIgnoredReportPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    public static HideIgnoredReportPartDefinition m15705a(InjectorLike injectorLike) {
        return new HideIgnoredReportPartDefinition();
    }

    public final boolean m15707a(Object obj) {
        return ((GraphQLStory) ((FeedProps) obj).a).aU();
    }

    public final Object m15706a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        return null;
    }
}
