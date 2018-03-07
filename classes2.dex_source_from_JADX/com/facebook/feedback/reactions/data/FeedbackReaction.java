package com.facebook.feedback.reactions.data;

import android.graphics.drawable.Drawable;
import com.facebook.graphql.model.GraphQLFeedback;

/* compiled from: gsm_cid */
public class FeedbackReaction {
    @Deprecated
    public static final FeedbackReaction f21474a = m29189a(0);
    @Deprecated
    public static final FeedbackReaction f21475b = m29189a(1);
    public static final FeedbackReaction f21476c = new FeedbackReaction(0, "None", -16777216, true, null, null, null);
    public static final FeedbackReaction f21477d = new FeedbackReaction(-1, "Unknown", -16777216, true, null, null, null);
    public final int f21478e;
    public String f21479f;
    public int f21480g;
    public boolean f21481h;
    private FeedbackReactionAsset f21482i;
    public FeedbackReactionAsset f21483j;
    public FeedbackReactionAsset f21484k;

    public FeedbackReaction(int i, String str, int i2, boolean z, FeedbackReactionAsset feedbackReactionAsset, FeedbackReactionAsset feedbackReactionAsset2, FeedbackReactionAsset feedbackReactionAsset3) {
        this.f21478e = i;
        m29191a(str, i2, z, feedbackReactionAsset, feedbackReactionAsset2, feedbackReactionAsset3);
    }

    public final void m29191a(String str, int i, boolean z, FeedbackReactionAsset feedbackReactionAsset, FeedbackReactionAsset feedbackReactionAsset2, FeedbackReactionAsset feedbackReactionAsset3) {
        this.f21479f = str;
        this.f21480g = i;
        this.f21481h = z;
        this.f21482i = feedbackReactionAsset;
        this.f21483j = feedbackReactionAsset2;
        this.f21484k = feedbackReactionAsset3;
    }

    public final Drawable m29192e() {
        return this.f21482i.mo3166a().getConstantState().newDrawable();
    }

    public final Drawable m29193g() {
        return this.f21483j.mo3166a();
    }

    public String toString() {
        return "FeedbackReaction{id='" + this.f21478e + '\'' + ", name='" + this.f21479f + '\'' + ", isDeprecated=" + this.f21481h + '}';
    }

    public static Integer m29190a(GraphQLFeedback graphQLFeedback) {
        if (graphQLFeedback == null || graphQLFeedback.m23225S() == 0) {
            return Integer.valueOf(0);
        }
        return Integer.valueOf(graphQLFeedback.m23225S());
    }

    @Deprecated
    private static FeedbackReaction m29189a(int i) {
        return new FeedbackReaction(i, null, -1, true, null, null, null);
    }
}
