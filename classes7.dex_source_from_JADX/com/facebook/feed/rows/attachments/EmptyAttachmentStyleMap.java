package com.facebook.feed.rows.attachments;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.InjectorLike;
import com.facebook.multirow.api.PartWithIsNeeded;
import javax.annotation.Nullable;

/* compiled from: shutGlContext */
public class EmptyAttachmentStyleMap implements AttachmentStyleMap {
    public static EmptyAttachmentStyleMap m4391a(InjectorLike injectorLike) {
        return new EmptyAttachmentStyleMap();
    }

    @Nullable
    public final PartWithIsNeeded<FeedProps<GraphQLStoryAttachment>> m4392a(GraphQLStoryAttachmentStyle graphQLStoryAttachmentStyle) {
        return null;
    }
}
