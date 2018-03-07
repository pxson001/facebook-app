package com.facebook.feedback.ui;

import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.R;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.uicontrib.typinganimation.TypingDotsAnimationHelper;
import com.facebook.uicontrib.typinganimation.TypingDotsAnimationHelper.TypingAnimationParams;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: right_subtitle */
public class TypingDotsView extends CustomLinearLayout {
    @Inject
    public TypingDotsAnimationHelper f4779a;
    private AnimatorSet f4780b;

    private static <T extends View> void m5320a(Class<T> cls, T t) {
        m5321a((Object) t, t.getContext());
    }

    private static void m5321a(Object obj, Context context) {
        ((TypingDotsView) obj).f4779a = TypingDotsAnimationHelper.m19345b(FbInjector.get(context));
    }

    public TypingDotsView(Context context) {
        this(context, null);
    }

    public TypingDotsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TypingDotsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TypingDotsView, 0, 0);
        int color = obtainStyledAttributes.getColor(0, -1);
        obtainStyledAttributes.recycle();
        m5322c(color);
    }

    private void m5319a(TypingDotsAnimationHelper typingDotsAnimationHelper) {
        this.f4779a = typingDotsAnimationHelper;
    }

    private void m5322c(int i) {
        m5320a(TypingDotsView.class, (View) this);
        setContentView(2130907583);
        setGravity(17);
        View a = a(2131564475);
        View a2 = a(2131564476);
        View a3 = a(2131564477);
        m5318a(a, i);
        m5318a(a2, i);
        m5318a(a3, i);
        this.f4780b = this.f4779a.m19346a(new TypingAnimationParams(a, a2, a3, 6, 1633, 367));
    }

    private static void m5318a(View view, int i) {
        Drawable background = view.getBackground();
        if (background instanceof ShapeDrawable) {
            ((ShapeDrawable) background).getPaint().setColor(i);
        } else if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(i);
        }
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1233754756);
        super.onAttachedToWindow();
        this.f4780b.start();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1095776132, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1993320461);
        super.onDetachedFromWindow();
        this.f4780b.end();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 208621380, a);
    }
}
