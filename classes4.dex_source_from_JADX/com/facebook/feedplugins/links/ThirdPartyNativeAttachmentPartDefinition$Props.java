package com.facebook.feedplugins.links;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: optimistic_model */
public class ThirdPartyNativeAttachmentPartDefinition$Props {
    public final FeedProps<GraphQLStoryAttachment> f6032a;
    public final GraphQLStoryAttachment f6033b;
    @Nullable
    public final Map<String, Object> f6034c;
    public final LinkedViewAdapter f6035d;
    public final String f6036e;

    public ThirdPartyNativeAttachmentPartDefinition$Props(FeedProps<GraphQLStoryAttachment> feedProps, Map<String, Object> map, LinkedViewAdapter linkedViewAdapter, String str) {
        this.f6032a = feedProps;
        this.f6033b = (GraphQLStoryAttachment) feedProps.a;
        this.f6034c = map;
        this.f6035d = linkedViewAdapter;
        this.f6036e = str;
    }
}
