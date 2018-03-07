package com.facebook.feed.collage;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: groups/pendingposts/<p$1> */
public class DataSavingsCollageLayoutPropertiesProvider extends AbstractAssistedProvider<DataSavingsCollageLayoutProperties> {
    public final DataSavingsCollageLayoutProperties m29277a(FeedProps<GraphQLStoryAttachment> feedProps) {
        return new DataSavingsCollageLayoutProperties(PhotoGridProperties.m28823b((InjectorLike) this), feedProps);
    }
}
