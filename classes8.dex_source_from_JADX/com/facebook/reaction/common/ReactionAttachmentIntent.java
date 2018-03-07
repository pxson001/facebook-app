package com.facebook.reaction.common;

import android.content.Intent;
import com.facebook.reaction.analytics.ReactionAnalytics.UnitInteractionType;
import com.facebook.reaction.event.ReactionEvent;
import javax.annotation.Nullable;

/* compiled from: boost_post_tap */
public class ReactionAttachmentIntent {
    public final UnitInteractionType f18828a;
    @Nullable
    public final String f18829b;
    @Nullable
    public final ReactionEvent f18830c;
    @Nullable
    public final Intent f18831d;

    public ReactionAttachmentIntent(@Nullable String str, UnitInteractionType unitInteractionType, Intent intent) {
        this.f18829b = str;
        this.f18828a = unitInteractionType;
        this.f18831d = intent;
        this.f18830c = null;
    }

    public ReactionAttachmentIntent(@Nullable String str, UnitInteractionType unitInteractionType, ReactionEvent reactionEvent) {
        this.f18829b = str;
        this.f18828a = unitInteractionType;
        this.f18830c = reactionEvent;
        this.f18831d = null;
    }

    public ReactionAttachmentIntent(@Nullable String str, UnitInteractionType unitInteractionType) {
        this.f18829b = str;
        this.f18828a = unitInteractionType;
        this.f18830c = null;
        this.f18831d = null;
    }
}
