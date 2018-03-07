package com.facebook.feed.rows.attachments;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.multirow.api.PartWithIsNeeded;
import javax.annotation.Nullable;

/* compiled from: initCause */
public interface AttachmentStyleMap {
    @Nullable
    PartWithIsNeeded<FeedProps<GraphQLStoryAttachment>> mo3126a(GraphQLStoryAttachmentStyle graphQLStoryAttachmentStyle);
}
