package com.facebook.reaction.feed.environment;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import com.facebook.inject.Assisted;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import javax.inject.Inject;

/* compiled from: aymt_local_awareness_tip */
public class HasReactionCardBackgroundImpl implements HasReactionCardBackground {
    private final Context f19124a;

    @Inject
    public HasReactionCardBackgroundImpl(@Assisted Context context) {
        this.f19124a = context;
    }

    public final Drawable mo697b(ReactionUnitComponentNode reactionUnitComponentNode) {
        return new ColorDrawable(ContextCompat.b(this.f19124a, 2131361920));
    }
}
