package com.facebook.feedback.ui.rows.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import com.facebook.attachments.ui.AttachmentViewPhoto;
import com.facebook.inject.FbInjector;
import javax.inject.Inject;

/* compiled from: result_in_responded */
public class CommentPhotoView extends AttachmentViewPhoto implements HighlightableView {
    @Inject
    public CommentRowViewControllerProvider f5185g;
    private final CommentRowViewController f5186h;

    public static void m5638a(Object obj, Context context) {
        ((CommentPhotoView) obj).f5185g = (CommentRowViewControllerProvider) FbInjector.get(context).getOnDemandAssistedProviderForStaticDi(CommentRowViewControllerProvider.class);
    }

    public CommentPhotoView(Context context) {
        this(context, null, 0);
    }

    private CommentPhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = CommentPhotoView.class;
        m5638a(this, getContext());
        this.f5186h = this.f5185g.m5645a(this);
        this.f5186h.m5642a();
    }

    public final void mo279a(ValueAnimator valueAnimator) {
        this.f5186h.m5643a(valueAnimator);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f5186h.m5644a(motionEvent);
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        super.setOnTouchListener(onTouchListener);
        this.f5186h.f5194c = onTouchListener;
    }
}
