package com.facebook.ufiservices.event;

import com.facebook.feed.util.event.FeedEvent;
import com.facebook.feedback.reactions.data.FeedbackReaction;

@Deprecated
/* compiled from: plural */
public class UfiEvents$ReactionUpdatedEvent extends FeedEvent {
    public final String f14041a;
    public final String f14042b;
    public final FeedbackReaction f14043c;
    public final boolean f14044d;

    public UfiEvents$ReactionUpdatedEvent(String str, String str2, FeedbackReaction feedbackReaction, boolean z) {
        this.f14041a = str;
        this.f14042b = str2;
        this.f14043c = feedbackReaction;
        this.f14044d = z;
    }
}
