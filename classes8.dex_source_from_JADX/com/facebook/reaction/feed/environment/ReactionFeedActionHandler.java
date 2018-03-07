package com.facebook.reaction.feed.environment;

import android.content.Context;
import com.facebook.inject.Assisted;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.common.ReactionCardContainer;
import com.facebook.reaction.intent.ReactionIntentLauncher;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: auto_identify_started */
public class ReactionFeedActionHandler implements CanLaunchReactionIntent, HasReactionCardContainer {
    private final WeakReference<ReactionCardContainer> f19128a;
    private final Context f19129b;
    private final ReactionIntentLauncher f19130c;

    @Inject
    public ReactionFeedActionHandler(@Assisted Context context, @Assisted ReactionCardContainer reactionCardContainer, ReactionIntentLauncher reactionIntentLauncher) {
        this.f19128a = new WeakReference(reactionCardContainer);
        this.f19129b = context;
        this.f19130c = reactionIntentLauncher;
    }

    @Nullable
    public final ReactionCardContainer mo705q() {
        return (ReactionCardContainer) this.f19128a.get();
    }

    public final void mo695a(String str, String str2, @Nullable ReactionAttachmentIntent reactionAttachmentIntent) {
        if (reactionAttachmentIntent != null) {
            ReactionCardContainer reactionCardContainer = (ReactionCardContainer) this.f19128a.get();
            if (reactionCardContainer != null) {
                if (reactionCardContainer.getInteractionTracker() != null) {
                    reactionCardContainer.getInteractionTracker().mo981a(str, str2, reactionAttachmentIntent);
                }
                this.f19130c.m24384a(str, reactionAttachmentIntent, reactionCardContainer, this.f19129b);
            }
        }
    }

    public final void mo696a(String str, String str2, @Nullable String str3, @Nullable ReactionAttachmentIntent reactionAttachmentIntent) {
        if (reactionAttachmentIntent != null) {
            ReactionCardContainer reactionCardContainer = (ReactionCardContainer) this.f19128a.get();
            if (reactionCardContainer != null) {
                if (reactionCardContainer.getInteractionTracker() != null) {
                    reactionCardContainer.getInteractionTracker().m18943a(str, str2, str3, reactionAttachmentIntent);
                }
                this.f19130c.m24384a(str, reactionAttachmentIntent, reactionCardContainer, this.f19129b);
            }
        }
    }
}
