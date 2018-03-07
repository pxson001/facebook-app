package com.facebook.facecastdisplay.streamingreactions;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.reactionsanimations.ReactionsFaceDrawable;
import javax.annotation.Nullable;

/* compiled from: state_sections */
public class FacecastReactionView extends View {
    public int f3294a;
    @Nullable
    private ReactionsFaceDrawable f3295b;

    public FacecastReactionView(Context context) {
        this(context, null);
    }

    private FacecastReactionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private FacecastReactionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3294a = 0;
    }

    public void setReactionDrawable(Drawable drawable) {
        setBackgroundDrawable(drawable);
        if (drawable instanceof ReactionsFaceDrawable) {
            this.f3295b = (ReactionsFaceDrawable) drawable;
        }
    }

    public final void m4050a() {
        if (this.f3295b != null) {
            this.f3295b.m18272b();
        }
    }

    public void setPressed(boolean z) {
        super.setPressed(z);
        if (!isClickable()) {
            return;
        }
        if (z) {
            animate().cancel();
            animate().scaleX(0.79545456f).scaleY(0.79545456f).setInterpolator(new DecelerateInterpolator()).setDuration(100).start();
            return;
        }
        animate().cancel();
        animate().scaleX(1.0f).scaleY(1.0f).setInterpolator(new AccelerateInterpolator()).setDuration(100).start();
    }

    public void setReaction(FeedbackReaction feedbackReaction) {
        this.f3294a = feedbackReaction.e;
        setReactionDrawable(feedbackReaction.g());
    }
}
