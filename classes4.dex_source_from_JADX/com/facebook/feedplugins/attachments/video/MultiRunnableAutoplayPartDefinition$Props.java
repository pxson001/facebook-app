package com.facebook.feedplugins.attachments.video;

import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: phoneContacts */
public final class MultiRunnableAutoplayPartDefinition$Props {
    public final AutoplayVisibilityRunnable f5010a;
    public final InlineVideoStoryKey f5011b;
    public final GraphQLStory f5012c;
    public final GraphQLStoryAttachment f5013d;

    public MultiRunnableAutoplayPartDefinition$Props(AutoplayVisibilityRunnable autoplayVisibilityRunnable, InlineVideoStoryKey inlineVideoStoryKey, GraphQLStory graphQLStory, GraphQLStoryAttachment graphQLStoryAttachment) {
        this.f5010a = autoplayVisibilityRunnable;
        this.f5011b = inlineVideoStoryKey;
        this.f5012c = graphQLStory;
        this.f5013d = graphQLStoryAttachment;
    }
}
