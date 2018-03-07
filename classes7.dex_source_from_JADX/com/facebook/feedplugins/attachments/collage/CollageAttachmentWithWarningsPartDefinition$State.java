package com.facebook.feedplugins.attachments.collage;

import android.view.View.OnClickListener;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.photos.warning.DisturbingMediaView;
import com.google.common.collect.ImmutableList;

/* compiled from: TOOLTIP_ICONS_TEXT */
public class CollageAttachmentWithWarningsPartDefinition$State {
    public final ImmutableList<FeedProps<GraphQLStoryAttachment>> f22563a;
    public DisturbingMediaView f22564b;
    public OnClickListener f22565c;

    public CollageAttachmentWithWarningsPartDefinition$State(ImmutableList<FeedProps<GraphQLStoryAttachment>> immutableList) {
        this.f22563a = immutableList;
    }
}
