package com.facebook.search.results.rows.sections.videos.topvideo;

import android.view.View;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: PICKER_SCREEN */
public class SearchVideoAttachmentPartDefinitionProvider extends AbstractAssistedProvider<SearchVideoAttachmentPartDefinition> {
    public final <E extends HasPositionInformation, V extends View> SearchVideoAttachmentPartDefinition<E, V> m28541a(MultiRowSinglePartDefinition<GraphQLStoryAttachment, ?, E, V> multiRowSinglePartDefinition) {
        return new SearchVideoAttachmentPartDefinition(multiRowSinglePartDefinition, BackgroundPartDefinition.a(this));
    }
}
