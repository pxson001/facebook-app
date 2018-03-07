package com.facebook.reaction.feed.environment;

import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import javax.annotation.Nullable;

/* compiled from: keywords_top */
public interface CanLaunchReactionIntent extends AnyEnvironment {
    void mo695a(String str, String str2, @Nullable ReactionAttachmentIntent reactionAttachmentIntent);

    void mo696a(String str, String str2, @Nullable String str3, @Nullable ReactionAttachmentIntent reactionAttachmentIntent);
}
