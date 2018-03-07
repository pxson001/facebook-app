package com.facebook.feedback.ui.rows.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import com.facebook.attachments.ui.AttachmentViewVideo;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: response_delay */
public class CommentVideoView extends AttachmentViewVideo implements HighlightableView {
    @Inject
    public CommentRowViewControllerProvider f5210b;
    private final CommentRowViewController f5211c;

    public static void m5659a(Object obj, Context context) {
        ((CommentVideoView) obj).f5210b = (CommentRowViewControllerProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(CommentRowViewControllerProvider.class);
    }

    public CommentVideoView(Context context) {
        this(context, null, 0);
    }

    private CommentVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = CommentVideoView.class;
        m5659a(this, getContext());
        this.f5211c = this.f5210b.m5645a(this);
        this.f5211c.m5642a();
    }

    public final void mo279a(ValueAnimator valueAnimator) {
        this.f5211c.m5643a(valueAnimator);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f5211c.m5644a(motionEvent);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
        this.f5211c.f5194c = onTouchListener;
    }
}
