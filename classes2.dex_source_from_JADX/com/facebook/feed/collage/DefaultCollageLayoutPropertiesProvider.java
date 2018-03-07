package com.facebook.feed.collage;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: groups/photos/<p$1> */
public class DefaultCollageLayoutPropertiesProvider extends AbstractAssistedProvider<DefaultCollageLayoutProperties> {
    public final DefaultCollageLayoutProperties m29276a(FeedProps<GraphQLStoryAttachment> feedProps) {
        return new DefaultCollageLayoutProperties(PhotoGridProperties.m28823b((InjectorLike) this), feedProps);
    }
}
