package com.facebook.reaction.feed.environment;

import com.facebook.inject.Assisted;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: back_presses */
public class CanLaunchReactionIntentImpl implements CanLaunchReactionIntent {
    private final ReactionFeedActionHandler f19122a;

    @Inject
    public CanLaunchReactionIntentImpl(@Assisted ReactionFeedActionHandler reactionFeedActionHandler) {
        this.f19122a = reactionFeedActionHandler;
    }

    public final void mo695a(String str, String str2, @Nullable ReactionAttachmentIntent reactionAttachmentIntent) {
        this.f19122a.mo695a(str, str2, reactionAttachmentIntent);
    }

    public final void mo696a(String str, String str2, @Nullable String str3, @Nullable ReactionAttachmentIntent reactionAttachmentIntent) {
        this.f19122a.mo696a(str, str2, str3, reactionAttachmentIntent);
    }
}
