package com.facebook.feed.rows.sections.attachments.components;

import android.content.Context;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ufiservices.flyout.FlyoutClickSource;
import com.facebook.ufiservices.util.LinkifyUtil;

/* compiled from: Visual Feedback for the VPVD logging */
public class LifeEventAttachmentHeaderTextPersistentSpannableInputProvider extends AbstractAssistedProvider<LifeEventAttachmentHeaderTextPersistentSpannableInput> {
    public final LifeEventAttachmentHeaderTextPersistentSpannableInput m23836a(FeedProps<GraphQLStoryAttachment> feedProps, FeedProps<GraphQLStory> feedProps2, GraphQLTextWithEntities graphQLTextWithEntities, FlyoutClickSource flyoutClickSource, String str) {
        return new LifeEventAttachmentHeaderTextPersistentSpannableInput((Context) getInstance(Context.class), LinkifyUtil.a(this), IdBasedSingletonScopeProvider.a(this, 616), feedProps, feedProps2, graphQLTextWithEntities, flyoutClickSource, str);
    }
}
