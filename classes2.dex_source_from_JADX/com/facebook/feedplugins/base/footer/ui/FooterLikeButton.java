package com.facebook.feedplugins.base.footer.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.util.ContextUtils;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.feed.widget.FeedbackCustomPressStateButton;
import com.facebook.feedback.reactions.data.FeedbackReaction;
import com.facebook.inject.FbInjector;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: gk_android_enable_ctp_video_prefetch */
public class FooterLikeButton extends FeedbackCustomPressStateButton {
    @Inject
    public GlyphColorizer f22321c;
    private final Drawable f22322d;
    private final Drawable f22323e;
    private final String f22324f;
    private final int f22325g;
    private final String f22326h;
    private final int f22327i;
    private final int f22328j;
    private int f22329k;

    private static <T extends View> void m30267a(Class<T> cls, T t) {
        m30268a((Object) t, t.getContext());
    }

    private static void m30268a(Object obj, Context context) {
        ((FooterLikeButton) obj).f22321c = GlyphColorizer.m11486a(FbInjector.get(context));
    }

    private void m30266a(GlyphColorizer glyphColorizer) {
        this.f22321c = glyphColorizer;
    }

    public FooterLikeButton(Context context) {
        this(context, null);
    }

    public FooterLikeButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FooterLikeButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f22329k = -1;
        m30267a(FooterLikeButton.class, (View) this);
        int c = ContextUtils.m2503c(getContext(), 2130772570, -7235677);
        int c2 = ContextUtils.m2503c(getContext(), 2130772569, -10972929);
        Resources resources = getResources();
        this.f22322d = m30263a(2130843790, c);
        this.f22324f = resources.getString(2131233267);
        this.f22325g = ContextUtils.m2503c(getContext(), 2130772570, -7235677);
        this.f22326h = resources.getString(2131235954);
        this.f22323e = m30263a(2130843790, c2);
        this.f22327i = resources.getDimensionPixelSize(2131427475);
        this.f22328j = this.f22327i + resources.getDimensionPixelSize(2131430634);
        m30269c();
    }

    private void m30269c() {
        setIsLiked(false);
        setWarmupBackgroundResId(FeedbackCustomPressStateButton.f22330a);
    }

    public void setIsLiked(boolean z) {
        setReaction(z ? FeedbackReaction.f21475b : FeedbackReaction.f21474a);
    }

    public void setReaction(FeedbackReaction feedbackReaction) {
        if (this.f22329k != feedbackReaction.f21478e) {
            if (feedbackReaction.f21478e == 0 || feedbackReaction == FeedbackReaction.f21477d) {
                m30265a(this.f22322d, this.f22324f, this.f22325g, this.f22327i, this.f22326h);
            } else if (feedbackReaction.f21478e == 1) {
                m30265a(this.f22323e, this.f22324f, ContextUtils.m2503c(getContext(), 2130772569, -10972929), this.f22327i, m30264a(this.f22324f));
            } else {
                m30265a(feedbackReaction.m29192e(), feedbackReaction.f21479f, feedbackReaction.f21480g, this.f22328j, m30264a(feedbackReaction.f21479f));
            }
            this.f22329k = feedbackReaction.f21478e;
        }
    }

    private void m30265a(Drawable drawable, String str, int i, int i2, String str2) {
        setImageDrawable(drawable);
        setText(str);
        setTextColor(i);
        setCompoundDrawablePadding(i2);
        setContentDescription(str2);
    }

    private Drawable m30263a(int i, int i2) {
        return this.f22321c.m11489a(i, i2);
    }

    private String m30264a(String str) {
        return getResources().getString(2131235955, new Object[]{str});
    }
}
