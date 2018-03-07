package com.facebook.attachments.angora.actionbutton;

import android.support.annotation.Nullable;
import android.view.View;
import com.facebook.attachments.angora.AttachmentHasButton;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentView;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinition;

/* compiled from: fetch_photos_metadata */
public interface AngoraActionButton<E extends AnyEnvironment> {
    Component mo3512a(ComponentContext componentContext, E e, FeedProps<GraphQLStoryAttachment> feedProps);

    <V extends View & AttachmentHasButton> SinglePartDefinition<FeedProps<GraphQLStoryAttachment>, ?, E, V> mo3513a();

    @Nullable
    SinglePartDefinition<FeedProps<GraphQLStoryAttachment>, ?, E, ComponentView> mo3514b();
}
