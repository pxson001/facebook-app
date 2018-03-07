package com.facebook.feed.rows.sections.attachments.ui;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.ui.attachments.FallbackPhotoGridPropertiesProvider;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.AbstractAssistedProvider;
import com.google.common.collect.ImmutableList;

/* compiled from: VIEW_INIT */
public class MultistoryCollageLayoutPropertiesProvider extends AbstractAssistedProvider<MultistoryCollageLayoutProperties> {
    public final MultistoryCollageLayoutProperties m23961a(ImmutableList<FeedProps<GraphQLStoryAttachment>> immutableList) {
        return new MultistoryCollageLayoutProperties((FallbackPhotoGridPropertiesProvider) getOnDemandAssistedProviderForStaticDi(FallbackPhotoGridPropertiesProvider.class), immutableList);
    }
}
