package com.facebook.feedback.reactions.ui;

import android.graphics.drawable.Drawable;
import com.facebook.feedback.reactions.data.FeedbackReactionAsset;
import com.facebook.reactionsanimations.ReactionsFaceDrawable;

/* compiled from: share_description */
public class FeedbackReactionVectorAsset implements FeedbackReactionAsset {
    private final ReactionsFaceDataCache f3864a;
    private final int f3865b;
    private final FeedbackReactionAsset f3866c;

    public FeedbackReactionVectorAsset(ReactionsFaceDataCache reactionsFaceDataCache, int i, FeedbackReactionAsset feedbackReactionAsset) {
        this.f3864a = reactionsFaceDataCache;
        this.f3865b = i;
        this.f3866c = feedbackReactionAsset;
    }

    public final Drawable m4503a() {
        if (this.f3864a.a(this.f3865b) == null) {
            return this.f3866c.a();
        }
        return new ReactionsFaceDrawable(this.f3864a.a(this.f3865b));
    }

    public final boolean m4504b() {
        return this.f3866c.b();
    }
}
