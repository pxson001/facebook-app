package com.facebook.feedback.ui.rows.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.feedback.ui.CommentBackgroundUtil;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.accessibility.AccessibleTextView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: reviewText */
public class CommentActionsView extends CustomLinearLayout implements HighlightableView {
    @Inject
    public CommentBackgroundUtil f5143a;
    private final AccessibleTextView f5144b;
    private OnTouchListener f5145c;

    private static <T extends View> void m5604a(Class<T> cls, T t) {
        m5605a((Object) t, t.getContext());
    }

    private static void m5605a(Object obj, Context context) {
        ((CommentActionsView) obj).f5143a = CommentBackgroundUtil.m4807a(FbInjector.get(context));
    }

    public CommentActionsView(Context context) {
        this(context, null);
    }

    public CommentActionsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommentActionsView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5604a(CommentActionsView.class, (View) this);
        setContentView(2130903614);
        setBackgroundDrawable(this.f5143a.m4813a(context));
        this.f5144b = (AccessibleTextView) findViewById(2131560421);
        this.f5144b.setMovementMethod(LinkMovementMethod.getInstance());
        this.f5144b.setTextSize(0, context.getResources().getDimension(2131428739));
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        if (this.f5145c != null) {
            this.f5145c.onTouch(this, motionEvent);
        }
        return false;
    }

    private void m5603a(CommentBackgroundUtil commentBackgroundUtil) {
        this.f5143a = commentBackgroundUtil;
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
        this.f5145c = onTouchListener;
    }

    public void setMetadataText(CharSequence charSequence) {
        this.f5144b.setText(charSequence);
        this.f5144b.setContentDescription(charSequence);
    }

    public final void mo279a(ValueAnimator valueAnimator) {
        CommentBackgroundUtil.m4809a(getBackground(), valueAnimator);
    }
}
