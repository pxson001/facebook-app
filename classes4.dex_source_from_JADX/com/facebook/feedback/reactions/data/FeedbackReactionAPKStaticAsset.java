package com.facebook.feedback.reactions.data;

import android.content.Context;
import android.graphics.drawable.Drawable;

/* compiled from: selection/{#%s} */
public class FeedbackReactionAPKStaticAsset implements FeedbackReactionAsset {
    private final Context f2861a;
    private final int f2862b;

    public FeedbackReactionAPKStaticAsset(Context context, int i) {
        this.f2861a = context;
        this.f2862b = i;
    }

    public final Drawable m3119a() {
        return this.f2861a.getResources().getDrawable(this.f2862b);
    }

    public final boolean m3120b() {
        return this.f2862b != 0;
    }
}
