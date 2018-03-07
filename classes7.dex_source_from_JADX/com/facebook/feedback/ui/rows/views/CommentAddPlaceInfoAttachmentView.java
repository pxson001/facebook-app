package com.facebook.feedback.ui.rows.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: retry_load */
public class CommentAddPlaceInfoAttachmentView extends CustomLinearLayout implements HighlightableView {
    @Inject
    public CommentRowViewControllerProvider f5160a;
    private final CommentRowViewController f5161b;

    public static void m5615a(Object obj, Context context) {
        ((CommentAddPlaceInfoAttachmentView) obj).f5160a = (CommentRowViewControllerProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(CommentRowViewControllerProvider.class);
    }

    public CommentAddPlaceInfoAttachmentView(Context context) {
        this(context, null);
    }

    private CommentAddPlaceInfoAttachmentView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private CommentAddPlaceInfoAttachmentView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = CommentAddPlaceInfoAttachmentView.class;
        m5615a(this, getContext());
        setContentView(2130903617);
        this.f5161b = this.f5160a.m5645a(this);
        this.f5161b.m5642a();
    }

    public final void mo279a(ValueAnimator valueAnimator) {
        this.f5161b.m5643a(valueAnimator);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f5161b.m5644a(motionEvent);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
        this.f5161b.f5194c = onTouchListener;
    }
}
