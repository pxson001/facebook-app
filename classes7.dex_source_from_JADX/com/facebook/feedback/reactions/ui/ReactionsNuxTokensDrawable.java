package com.facebook.feedback.reactions.ui;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.inject.Lazy;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: settings_token_for_reload */
public class ReactionsNuxTokensDrawable extends Drawable {
    private final Lazy<FeedbackReactionsController> f3884a;
    private final int f3885b;
    private final int f3886c;
    private int f3887d;
    private List<Drawable> f3888e = new ArrayList();

    @Inject
    public ReactionsNuxTokensDrawable(Resources resources, Lazy<FeedbackReactionsController> lazy) {
        this.f3884a = lazy;
        this.f3885b = resources.getDimensionPixelSize(2131430648);
        this.f3886c = resources.getDimensionPixelSize(2131430649);
    }

    public final void m4526a(GraphQLFeedback graphQLFeedback) {
        this.f3888e.clear();
        FeedbackReactionsController feedbackReactionsController = (FeedbackReactionsController) this.f3884a.get();
        ImmutableList a = feedbackReactionsController.a(graphQLFeedback.K());
        if (a == null || a.isEmpty()) {
            a = feedbackReactionsController.c();
        }
        int size = a.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Drawable e = ((FeedbackReaction) a.get(i2)).e();
            e.setBounds(0, 0, this.f3885b, this.f3885b);
            this.f3888e.add(e);
            i++;
            if (i == 8) {
                break;
            }
        }
        this.f3887d = this.f3888e.size() * (this.f3885b + this.f3886c);
    }

    public int getIntrinsicWidth() {
        return this.f3887d;
    }

    public int getIntrinsicHeight() {
        return this.f3885b;
    }

    public void draw(Canvas canvas) {
        if (!this.f3888e.isEmpty()) {
            canvas.save();
            for (Drawable draw : this.f3888e) {
                draw.draw(canvas);
                canvas.translate((float) (this.f3885b + this.f3886c), 0.0f);
            }
            canvas.restore();
        }
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return -2;
    }
}
